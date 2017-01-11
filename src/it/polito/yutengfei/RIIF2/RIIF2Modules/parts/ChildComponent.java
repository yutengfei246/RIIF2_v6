package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.ExpressionOperator;

import java.util.*;

public class ChildComponent extends Label<Label> {

    private LinkedList<Label> vectorValue = null ;
    private Map<String,Label> assocs = null;


    @Override
    public void setAssociative(Boolean b) {
        if (b){
            super.associativeTrue();
            this.assocs = new HashMap<>();
        }
        else
            super.associativeFalse();
    }

    @Override
    public void putAttribute(String key, Attribute attribute) {

    }

    @Override
    public void putAssoc(String name, Label assocIndex) {
        this.assocs.put(name,assocIndex);
    }

    @Override
    public Label getAssociative(String index) {
        return this.assocs.get(index);
    }

    @Override
    public void setVector(Vector vector, RIIF2Recorder recorder) {
        super.vectorTrue();

        ExpressionOperator eo = new ExpressionOperator(recorder);

        Expression exp = vector.getLeft();
        exp.setExpressionOperator(eo);
        int left = (int) exp.getValue();

        exp = vector.getRight();
        exp.setExpressionOperator(eo);
        int right = (int) exp.getValue();

        super.setVectorLength( left * right);

        this.vectorValue = new LinkedList<>();

        for ( int i = 0; i < right*left; i++)
            this.vectorValue.add(new ChildComponent());

    }

    @Override
    public boolean containsAssociativeIndex(String index) {
        return this.assocs.containsKey( index );
    }

    @Override
    public boolean containsAttributeIndex(String index) {
        return false;
    }

    @Override
    public void addVectorItem(Label value) {
        this.vectorValue.add(value);
    }

    @Override
    public Label getVector(int index) {
        return this.vectorValue.get(index);
    }

    @Override
    public void setPlatform(RIIF2Recorder recorder) {

    }

    @Override
    public RIIF2Recorder getPlatform() {
        return null;
    }

    @Override
    public Attribute getAttribute(String attribute) {
        return null;
    }


    public void print(){
        System.out.print("ChildComponent " + super.getName() );
        if (this.assocs != null && this.assocs.size() != 0)
            System.out.print("[ ]");

        System.out.println(";");

        if (this.assocs != null && this.assocs.size() != 0) {
            for (Map.Entry<String,Label> entry : this.assocs.entrySet() ) {
                System.out.println("ChildComponent " + super.getName() + "[" +
                        entry.getValue().getName() + "]" );
            }
        }

        RIIF2Recorder value = (RIIF2Recorder) this.getValue();
        if (value != null ){
            value.print8();
        }
    }


}
