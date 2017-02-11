package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.Iterator;
import java.util.List;

public class Parameter extends Label<Label> {

    public Parameter(RIIF2Recorder recorder){
        super(recorder);
    }


    @Override
    public void print() {

        // print field
        System.out.print("Parameter " + super.getName() + " : " + super.getType() );

        if (this.isEnumType() ){
            System.out.print(" [ ");
            this.getEnumType().getEnums().forEach(s -> System.out.print(" " + s + " "));
            System.out.print(" ] ");
        }

        System.out.print(" := " );


        Object initialValue = super.getValue();

        if (initialValue != null ) {
            if (initialValue instanceof Expression) {
                Expression value = (Expression) super.getValue();
                value.print();
            }

            if (initialValue instanceof List){
                Object value = super.getValue();
                List valueList = (List) value;
                System.out.print(" " + valueList.toString() + " ");
            }

            if (initialValue instanceof String)
                System.out.print(" " + initialValue.toString() + " ");

        } else
            System.out.print(" null ");

        System.out.print(";");

        super.printAttribute();
        super.printAssociative();
    }

}
