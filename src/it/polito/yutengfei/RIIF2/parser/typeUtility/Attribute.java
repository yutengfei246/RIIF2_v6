package it.polito.yutengfei.RIIF2.parser.typeUtility;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.TableValueOperator;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Attribute extends Label<Label> {

    // a table label references
    private Label<Label> table;

    public Attribute(RIIF2Recorder recorder) {
        super(recorder);
    }

    // get the table label references
    public Label<Label> getTable(){
        return table;
    }

    // back to the entry label
    public void setTable(Label table){
        this.table = table;
    }


    @Override
    public void setPlatform(RIIF2Recorder recorder) {
    }

    @Override
    public RIIF2Recorder getPlatform() {
        return null;
    }

    @Override
    public void print() {
        System.out.print (this.getName()  + " Type: "
                + this.getType()
                + " value: " );

        Object value = super.getValue();

        if (value != null){
            if (value instanceof Expression){
                Expression expression = (Expression) value;
                expression.print();
            }

            if (value instanceof List){
                System.out.print(" " + ((List)value).toString() + " " );
            }


            if (value instanceof TableValueOperator){
                TableValueOperator tableValueOperator = (TableValueOperator) value;
                tableValueOperator.print();
            }
        }else
            System.out.print("null; ");

        this.printStackValue();
    }

    public void printStackValue() {

        Iterator<Object> iterator = super.getStackValueIterator();

        System.out.print("-Stack-");
        while (iterator.hasNext()){
            Object o = iterator.next();
            if (o instanceof Expression){
                Expression e = (Expression) o;
                e.print();
            } else if (o instanceof List){
                System.out.print("List  " + o.toString());
            } else if (o instanceof TableValueOperator){
                TableValueOperator tableValueOperator = (TableValueOperator) o;
                tableValueOperator.print();
            } else
                System.out.print(" " + o.toString() + " ");

            System.out.print(" | ");
        }
        System.out.print("-Stack-\n" );

        super.printAttribute();
        super.printAssociative();
    }


}
