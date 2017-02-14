package it.polito.yutengfei.RIIF2.util.utilityWrapper;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Parameter;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.initializer.ArrayInitializer;
import it.polito.yutengfei.RIIF2.initializer.ArrayWrapperInitializer;
import it.polito.yutengfei.RIIF2.initializer.ListInitializer;
import it.polito.yutengfei.RIIF2.initializer.TableInitializer;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TableValueOperator implements Serializable{

    private final List<?> headers;
    private final Label<?> labelContainer;

    private List<_Row> tableEntry;

    private Map<String, List<Label<Label>> > sharpOperationStack;

    // constructor
    public TableValueOperator(List<?> headers, Label<?> labelContainer) {
        this.labelContainer = labelContainer;

        if (headers == null)
            System.out.println("Header is null");

        this.headers = headers;

        this.tableEntry = new LinkedList<>();

        this.sharpOperationStack = new LinkedHashMap< String,List<Label<Label>>>(){{
            assert headers != null;
            headers.forEach(s -> put( s.toString() , new LinkedList<>()) );
        }};
    }

    private _Row getRow(int index){
        return this.tableEntry.get(index);
    }

    // for each row it would be ArrayInitializer or Object Row
    public Boolean setRows (Object object) {

        // the table is just assigned
        _Row row = new _Row(this.labelContainer.getRecorder());

        row.initialRow(object);

        this.tableEntry.add(row);

        for ( int i = 0 ; i < row.size() ; i ++) {
            Label<Label> label = row.getRowItem(i);
            String headerName = (String) this.headers.get(i);

            this.sharpOperationStack.get(headerName).add(label);
        }
        return true;
    }

    public void newTableInitializer(TableInitializer tableInitializer) {

        if (this.tableEntry == null || this.tableEntry.size() == 0) {
            tableInitializer.getInitializer().forEach(this::setRows);
            return;
        }

        List<Row> rowList = tableInitializer.getInitializer();
        List<_Row> tableEntryC = this.tableEntry;
        this.tableEntry = new LinkedList<>();

        this.sharpOperationStack = new LinkedHashMap<String, List<Label<Label>>>() {{
            assert headers != null;
            headers.forEach(s -> put(s.toString(), new LinkedList<>()));
        }};

        for (int i = 0; i < rowList.size(); i++) {
            Row row = rowList.get(i);
            _Row _row = tableEntryC.get(i);

            if (row.getType() == Row.EXPRESSION) {

                Expression expRow = (Expression) row.getValue();
                expRow.setCurrentLabel(_row);
                expRow.setRecorder(this.labelContainer.getRecorder());
                List array = expRow.getInitializer();
                array.forEach(o -> {
                    Expression expression = (Expression) o;
                    //expression.print();
                });
                this.setRows(array);
            } else this.setRows(row);
        }


    }

    public void newTableInitializer(ArrayWrapperInitializer arrayWrapperInitializer) {

        if (this.tableEntry == null || this.tableEntry.size() == 0) {
            arrayWrapperInitializer.getInitializer().forEach(this::setRows);
        }
    }

    public void sharpOperation(String yy, Expression value) {

        if(this.sharpOperationStack == null  || this.sharpOperationStack.size() == 0)
            return;

        List<Label<Label>> labels = this.sharpOperationStack.get(yy);


        // the value is valid for each label in the labelList

        // 1, get type
        // 2, replacement

        labels.forEach(labelLabel -> {

            value.setCurrentLabel(labelLabel);
            value.setRecorder(this.labelContainer.getRecorder());
            value.getType(); // in case the expression including SELF
           // System.out.println(" value " + value.getType() + " label " +labelLabel.getType());
            value.setLocation(null,null);;
            try {
                // this table with name Item type is
                labelLabel.setValue(value);
                //((Expression)labelLabel.getValue()).print();
            } catch (FieldTypeNotMarchException e) {
                e.printStackTrace();
            }
        });
    }

    public class _Row extends Label<Label> {

        // Object:: Expression | List
        private List<Label<Label>> oneRow;

        _Row(RIIF2Recorder recorder) {
            super(recorder);
            this.oneRow = new LinkedList<>();
            this.setName(RIIF2Grammar._ROW);
        }

        @Override
        public void vectorInitializer() {

        }

        void initialRow(Object rowItem) {
            // array wrapper initializer
            if (rowItem instanceof ArrayInitializer) {
                ArrayInitializer arrayInitializer = (ArrayInitializer) rowItem;
                List<Expression> array = arrayInitializer.getInitializer();

                array.forEach(expression -> {
                    Label<Label> label = this.createLabel(RIIF2Grammar.ITEMS ,expression.getType(), expression);
                    this.addItem(label);
                });
            }

            // the expression returned array
            if (rowItem instanceof List){
                ((List) rowItem).forEach(o -> {
                    Label<Label> label = this.createLabel(RIIF2Grammar.ITEMS, ((Expression)o).getType(),o);
                    this.addItem(label);
                });
            }

            // table initializer , in this case we have Row  -> rowItem list | expression
            if (rowItem instanceof Row) {
                Row row = (Row) rowItem;

                // rowItem list
                if (row.getType() == Row.ROW_ITEMS_ARRAY) {
                    List rowItems = (List) row.getValue();

                    rowItems.forEach(o -> {
                        if (o instanceof RowItem) {
                            RowItem item = (RowItem)o;
                            if ( item.getType() == RowItem.LIST_STRING){
                                ListInitializer listInitializer = (ListInitializer) item.getValue();
                                Label<Label> label = this.createLabel(RIIF2Grammar.ITEMS,RIIF2Grammar.LIST,listInitializer);
                                this.addItem(label);
                            }

                            if ( item.getType() == RowItem.EXPRESSION) {
                                Expression exp = (Expression) item.getValue();
                                exp.setCurrentLabel(TableValueOperator.this.labelContainer);
                                exp.setRecorder(this.getRecorder());
                                Label<Label> label = this.createLabel(RIIF2Grammar.ITEMS,((Expression)item.getValue()).getType(),item.getValue());
                                this.addItem(label);
                            }
                        }
                    });
                }
            }
        }

        private Label<Label> createLabel(String items, String type, Object value){

            Parameter parameter = new Parameter(TableValueOperator.this.labelContainer.getRecorder());

            try {
                parameter.setName(items);
                parameter.setType(type);
                parameter.setValue(value);
            }
            catch (FieldTypeNotMarchException e) {
                e.printStackTrace();
            }

            return parameter;
        }

        private void addItem(Label<Label> object) {
            this.oneRow.add(object);
        }

        public Label<Label> getRowItem(int index) {
            return this.oneRow.get(index);
        }

        @Override
        public void print() {

            if (this.oneRow == null || this.oneRow.size() == 0) {
                System.out.print(" null ");
                return;
            }

            System.out.print(" [ ");
            this.oneRow.forEach(Label::print);

            System.out.print(" ] ");
        }

        @Override
        public String getLiteral() {
            return null;
        }

        public int size() {
            if (this.oneRow == null )
                return 0;

            return this.oneRow.size();
        }
    }

    public void print(){

        if (this.tableEntry != null && this.tableEntry.size() != 0 ) {

            System.out.print(" { ");
            this.tableEntry.forEach(_Row::print);
            System.out.print(" } ");
        }
        else
            System.out.print(" null ");

    }

}
