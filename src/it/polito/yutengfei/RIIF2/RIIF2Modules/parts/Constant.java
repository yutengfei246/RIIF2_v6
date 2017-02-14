package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.List;

public class Constant extends Label<Label> {

    public Constant(RIIF2Recorder recorder) {
        super(recorder);
    }

    @Override
    public void vectorInitializer() {
        int length = super.getVectorLength();

        for (int i= 0; i < length ; i ++) {
            Constant parameter = this.createConstant();
            super.assignVectorItem(i,parameter);
        }
    }

    private Constant createConstant() {
        return new Constant(super.getRecorder());
    }


    @Override
    public void print() {

        // print field
        System.out.print("Constant " + super.getName() + " : " + super.getType() );
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

        super.printVector();
        super.printAttribute();
        super.printAssociative();
    }

    @Override
    public String getLiteral() {

        StringBuffer literal = new StringBuffer();

        Object initialValue = super.getValue();

        if (initialValue != null){
            if (initialValue instanceof Expression) {
                literal.append(((Expression)initialValue).getLiteral());
            }

            if (initialValue instanceof List){
                Object value = super.getValue();
                List valueList = (List)value;
                literal.append(valueList.toString());
            }

            if (initialValue instanceof String)
                literal.append(initialValue.toString());
        }
        else
            literal.append("null");

        return literal.toString();
    }
}
