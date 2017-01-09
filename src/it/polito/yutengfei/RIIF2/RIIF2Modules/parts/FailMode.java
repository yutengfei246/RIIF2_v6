package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

public class FailMode extends Label<Label> {

    private LinkedList<Label> vectorValue = null ;
    private Map<String,Label> assocs = null;
    private Map<String,Attribute> attributeMap = new HashMap<>();

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
        this.attributeMap.put(key, attribute);
    }

    @Override
    public void putAssoc(String name, Label assocIndex) {
        this.assocs.put(name, assocIndex);
    }

    @Override
    public Label getAssociative(String index) {
        return this.assocs.get(index);
    }

    @Override
    public Attribute getAttribute(String index) {
        return this.attributeMap.get(index);
    }


    @Override
    public void setVector(Vector vector) {
        super.vectorTrue();

        Expression exp = vector.getLeft();
        int left = (int) exp.getValue();
        exp = vector.getRight();
        int right = (int) exp.getValue();

        super.setVectorLength( left * right);

        this.vectorValue = new LinkedList<>();

        for (int i=0 ; i< right*left ; i++)
            this.vectorValue.add(new FailMode());
    }

    @Override
    public boolean containsAssociativeIndex(String index) {
        return this.assocs.containsKey(index);
    }

    @Override
    public boolean containsAttributeIndex(String index) {
        return this.attributeMap.containsKey(index);
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


    public void print() {
        System.out.print("Fail_Mode " + getName());
        System.out.println(" ; ");

        if (this.attributeMap.size() != 0 ){
            this.attributeMap.forEach((s, attribute) -> {
                System.out.print("Fail_Mode:" + this.getName() + "@Attribute:");
                attribute.print();
            });
        }
    }
}
