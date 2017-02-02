package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.Iterator;
import java.util.List;

public class Parameter extends Label<Label> {

    public Parameter(RIIF2Recorder recorder){
        super(recorder);
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

        // print field
        System.out.print("Parameter " + super.getName() + " : " + super.getType() );
        System.out.print(" := " );

        Object initialValue = super.getValue();

        if (initialValue != null ) {
            if (initialValue instanceof Expression) {
                Expression value = (Expression) super.getValue();
                value.print();
            }

            if (initialValue instanceof List){

                List<Object> valueList = (List<Object>) super.getValue();
                System.out.print(" " + valueList.toString() + " ");
            }
        } else
            System.out.print(" null ");

        System.out.print(";");

        Iterator<Object> iterator = super.getStackValueIterator();

        System.out.print("-Stack-");
        while (iterator.hasNext()){
            Object o = iterator.next();
                if (o instanceof Expression){
                    Expression e = (Expression) o;
                    ((Expression) o).print();
                } else if (o instanceof List){
                    System.out.print("List  " + ((List)o).toString());
                }
                else
                    System.out.print(" " + o.toString() + " ");
            System.out.print(" | ");
        }
        System.out.print("-Stack-\n" );

        super.printAttribute();
        super.printAssociative();
    }


}
