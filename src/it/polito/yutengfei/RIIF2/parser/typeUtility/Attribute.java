package it.polito.yutengfei.RIIF2.parser.typeUtility;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.TableValueOperator;

import java.util.List;

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

            else if (value instanceof List){
                System.out.print(" " + ((List)value).toString() + " " );
            }


            else if (value instanceof TableValueOperator){
                TableValueOperator tableValueOperator = (TableValueOperator) value;
                tableValueOperator.print();
            }

            else
                System.out.print(" " + value.toString() + "  ");
        }else
            System.out.print("null; ");

        this.printStackValue();
    }

    public void printStackValue() {

        super.printAttribute();
        super.printAssociative();
    }


}
