package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.List;

public class Parameter extends Label<Label> {

    public Parameter(RIIF2Recorder recorder){
        super(recorder);
    }

    public String environmentType ;

    public void setEnvironmentType(String environmentType) {
        this.environmentType =environmentType ;
    }

    public String getEnvironmentType() {
        return this.environmentType;
    }



    @Override
    public void vectorInitializer(String name, String type, Object value ) {
        int length = super.getVectorLength();

        for (int i= 0; i < length ; i ++) {
            Parameter parameter = this.createParameter(name, type, value);
            super.assignVectorItem(i,parameter);
        }
    }

    private Parameter createParameter(String name, String type, Object value) {
        Parameter parameter = new Parameter(super.getRecorder());

        parameter.setName(name);
        parameter.setType(type);

        return parameter;
    }


    @Override
    public String getLiteral(){

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


    @Override
    public void print() {


        if (this.getEnvironmentType() != null )
            System.out.print(this.getEnvironmentType() + " ");
        // print field
        System.out.print("Parameter " + super.getName() );

        if (this.isVector())
            System.out.print(" [1:" + super.getVectorLength() + "]");
        else
            System.out.print(  " : " + super.getType() );

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

        super.printVector();
        super.printAttribute();
        super.printAssociative();
    }

}
