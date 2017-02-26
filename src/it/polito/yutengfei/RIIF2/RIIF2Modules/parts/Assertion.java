package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

public class Assertion extends Label<Label>{

    private String oper;

    public Assertion(RIIF2Recorder recorder) {
        super(recorder);
    }

    @Override
    public void vectorInitializer(String name, String type, Object value) {

    }

    @Override
    public void print() {
        System.out.print(" Assert "  + super.getName() );
        Attribute attributeRate = super.getAttribute(RIIF2Grammar.RATE);

        System.out.print("'" + attributeRate.getName()  + " " + this.oper);

        System.out.print(" " + attributeRate.getValue().toString());

        Attribute attributeUnit = super.getAttribute(RIIF2Grammar.UNIT);
        System.out.print(" " + attributeUnit.getValue());

        System.out.println(" ");

    }

    @Override
    public String getLiteral() {
        return null;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }
}
