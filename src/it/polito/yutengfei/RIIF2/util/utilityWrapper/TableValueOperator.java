package it.polito.yutengfei.RIIF2.util.utilityWrapper;


import it.polito.yutengfei.RIIF2.initializer.ArrayInitializer;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TableValueOperator {


    private final List<String> headers;

    private Map<String,T_Column> sharpStructure;
    private List<T_Row> tableStructure;

    public TableValueOperator(List<String> headers){
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
        return true;
    }

    private T_Row createRow(List list) {
        return new T_Row(list);
    }

    public void print() {
        if ( this.tableStructure.size() == 0)
            System.out.print(" Table size is null ");

        this.tableStructure.forEach(t_row -> {
            List list = t_row.getRow();

            System.out.print("[ ");
            list.forEach(o -> {
                if (o instanceof Expression)
                    ((Expression)o).print();
                else
                    System.out.print(" " + list.toString() + " ");

            });
            System.out.print(" ]");
        });
    }

    private class T_Column {

        private List column = new LinkedList();

        public void add(Object ex) {
            this.column.add(ex);
        }
    }

    private class T_Row {

        private List row = new LinkedList();

        public T_Row (List list){
            row.addAll(list);
        }

        public List getRow() {
            return row;
        }
    }
}
