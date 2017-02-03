package it.polito.yutengfei.RIIF2.util.utilityWrapper;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Parameter;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.initializer.ArrayInitializer;
import it.polito.yutengfei.RIIF2.initializer.ListInitializer;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class TableValueOperator implements Serializable{


    private final List<String> headers;
    private final Label<?> labelContainer;

    private List<T_Row> tableStructure;

    public TableValueOperator(List<String> headers, Label<?> labelContainer){

        this.labelContainer = labelContainer;

        if (headers == null)
            System.out.println("Header is null");
        this.headers = headers;

        this.tableStructure = new LinkedList<>();
    }

    // for each row it would be ArrayInitializer or Object Row
    public Boolean setRows (Object object){

        if (object instanceof ArrayInitializer){
            ArrayInitializer arrayInitializer = (ArrayInitializer) object;
            List<Expression> expressionList = arrayInitializer.getInitializer();

            if (expressionList.size() != headers.size())
                return false;

            T_Row t_row = new T_Row(expressionList);
            this.tableStructure.add(t_row);
        }

        if (object instanceof Row){
            Row row = (Row) object;

            if (row.getType() == Row.EXPRESSION ){
                Expression expRow = (Expression) row.getValue();
                if ( expRow.isArray() ){
                    T_Row t_row = new T_Row(expRow);
                    this.tableStructure.add(t_row);
                }
            }

            if (row.getType() == Row.ROW_ITEMS_ARRAY) {
                Object value = row.getValue();
                List rowItemList = (List) value;

                T_Row t_row = new T_Row(rowItemList);
                this.tableStructure.add(t_row);
            }
        }

        return true;
    }

    // Row contains Expression and List
    private class T_Row implements Serializable {

        // the label List for each item in the table, in this way, when one item change, we can simply push the value into it.
        private List<Label<Label> > rowLabel = new LinkedList<>();

        // it may have the possibility for each row to be an expression( only is an array )
        private Expression expRow ;

        T_Row(Expression expRow) {
            this.expRow = expRow;
        }

        T_Row(List<?> list) {
            list.forEach(o -> {
                // in this case, it is Expression String or a Number ( integer / floating )
                if (o instanceof Expression ){
                    Label<Label> itemLabel =  this.createLabel( o );
                    this.rowLabel.add(itemLabel);
                }

                // in this case, it is RowItem , in which we have Expression or ListInitializer
                if (o instanceof RowItem){
                    RowItem rowItem = (RowItem) o;

                    Label<Label> itemLabel = null;
                    try {
                        if (rowItem.getType() == RowItem.LIST_STRING) {
                            ListInitializer listInitializer = (ListInitializer) rowItem.getValue();
                            itemLabel = this.createLabel(listInitializer);
                        } else
                            itemLabel = this.createLabel(rowItem.getValue());
                    } finally {
                        this.rowLabel.add(itemLabel);
                    }
                }
            });
        }

        private Label<Label> createLabel(Object o) {

            Label<Label> rtnLabel = new Parameter(labelContainer.getRecorder()) ;

            try {
                if (o instanceof Expression) {
                    Expression expO = Expression.class.cast(o);
                    rtnLabel.setType(expO.getType());
                    rtnLabel.putValue(o);
                }

                if (o instanceof ListInitializer) {
                    rtnLabel.setType(RIIF2Grammar.LIST);
                    //System.out.println("the list should coming out  " + o.toString());
                    rtnLabel.setValue(o);
                }


                rtnLabel.setName(RIIF2Grammar.TABLE_ITEM);
            } catch (FieldTypeNotMarchException e) {
                e.printStackTrace();
            }

            return rtnLabel;
        }

        Expression getExpRow(){
            return this.expRow;
        }

        public List< Label<Label> > getRow() {
            if (this.rowLabel.size() == 0)
                return null;

            return this.rowLabel;
        }
    }


    public void print() {
        if ( this.tableStructure.size() == 0)
            System.out.print(" Table size is null ");
        else {
            this.tableStructure.forEach(t_row -> {
                List< Label<Label> > list = t_row.getRow();

                if (list == null ){
                    Expression expression  = t_row.getExpRow();
                    if ( expression != null ){
                        System.out.print(" [ ");
                        expression.print();
                        System.out.print(" ] ");
                    }

                }else {
                    System.out.print("[ ");
                    list.forEach(Label::print);
                    System.out.print(" ]");
                }
            });
        }
    }
}
