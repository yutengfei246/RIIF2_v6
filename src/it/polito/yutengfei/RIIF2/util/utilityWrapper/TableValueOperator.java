package it.polito.yutengfei.RIIF2.util.utilityWrapper;


import it.polito.yutengfei.RIIF2.initializer.ArrayInitializer;
import it.polito.yutengfei.RIIF2.initializer.ListInitializer;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TableValueOperator implements Serializable{


    private final List<String> headers;

    private Map<String,T_Column> sharpStructure;
    private List<T_Row> tableStructure;

    public TableValueOperator(List<String> headers){

        if (headers == null)
            System.out.println("Header is null");
        this.headers = headers;

        this.tableStructure = new LinkedList<>();
        this.sharpStructure = new LinkedHashMap<String,T_Column>(){{
            headers.forEach(s -> put(s,new T_Column()));
        }};
    }

    public Boolean setRows (Object object){

        if (object instanceof ArrayInitializer){
            ArrayInitializer arrayInitializer = (ArrayInitializer) object;
            List<Expression> expressionList = arrayInitializer.getInitializer();

            if (expressionList.size() != headers.size())
                return false;

            T_Row t_row = this.createRow(expressionList);
            this.tableStructure.add(t_row);

            for ( int i = 0 ; i < this.headers.size() ; i ++ ){
                String headerName = this.headers.get(i);
                T_Column column = this.sharpStructure.get(headerName);

                Expression ex = expressionList.get(i);
                column.add(ex);
            }
        }

        if (object instanceof Row){
            Row row = (Row) object;

            if (row.getType() == Row.EXPRESSION ){
                Expression expRow = (Expression) row.getValue();
                if ( expRow.isArray() ){
                    T_Row t_row = this.createRow(expRow) ;
                    this.tableStructure.add(t_row);
                }

                //TODO: create sharp structure
            }

            if (row.getType() == Row.ROW_ITEMS_ARRAY) {
                List<RowItem> rowItemList = (List<RowItem>) row.getValue();

                T_Row t_row = this.createRow(rowItemList);
                this.tableStructure.add(t_row);

                for (int i = 0; i < this.headers.size() ; i ++ ){
                    RowItem rowItem = rowItemList.get(i);
                    String headerName = this.headers.get(i);

                    T_Column t_column = sharpStructure.get(headerName);

                    if (rowItem.getType() == RowItem.EXPRESSION){
                        Expression expRI = (Expression) rowItem.getValue();

                        if (expRI.isValid())
                            t_column.add(expRI);
                    }
                }

            }

        }
        return true;
    }

    private T_Row createRow(Expression expRow) {
        return new T_Row(expRow);
    }

    private T_Row createRow(List list) {
        return new T_Row(list);
    }

    public void print() {
        if ( this.tableStructure.size() == 0)
            System.out.print(" Table size is null ");
        else {
            this.tableStructure.forEach(t_row -> {
                List list = t_row.getRow();

                if (list == null ){
                    Expression expression  = t_row.getExpRow();
                    if ( expression != null ){
                        System.out.print(" [ ");
                        expression.print();
                        System.out.print(" ] ");
                    }

                }else {
                    System.out.print("[ ");
                    list.forEach(o -> {
                        if (o instanceof Expression)
                            ((Expression) o).print();
                        else if (o instanceof List) {
                            System.out.print(" { ");
                            List theL = (List) o;
                            theL.forEach(o1 ->
                                    {
                                        if (o1 instanceof Expression) {
                                            ((Expression) o1).print();

                                        } else System.out.print(" " + o1.toString() + " ");
                                    }
                            );
                            System.out.print(" } ");
                        } else
                            System.out.print(" " + list.toString() + " ");

                    });
                    System.out.print(" ]");
                }
            });
        }
    }

    private class T_Column implements Serializable{

        private List<Object> column = new LinkedList<>();

        public void add(Object ex) {
            this.column.add(ex);
        }
    }

    private class T_Row implements Serializable {

        private List<Object> row = new LinkedList<>();

        private Expression expRow ;
        T_Row(List<?> list){

            list.forEach(o -> {
                if (o instanceof Expression)
                    this.row.add(o);

                if (o instanceof RowItem){
                    RowItem rowItem = (RowItem) o;
                    if (rowItem.getType() == RowItem.LIST_STRING){
                        ListInitializer listInitializer = (ListInitializer) rowItem.getValue();
                        this.row.add( listInitializer.getInitializer() );
                    } else
                        this.row.add(rowItem.getValue());
                }
            });
        }

        public T_Row(Expression expRow) {
            this.expRow = expRow;
        }

        public Expression getExpRow(){
            return this.expRow;
        }

        public List getRow() {
            if (this.row.size() == 0)
                return null;

            return this.row;
        }
    }
}
