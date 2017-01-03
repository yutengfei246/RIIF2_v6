package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

public class FailMode extends Label<FailMode> {

    private LinkedList<FailMode> vectorValue = null ;
    private Map<String,FailMode> assocs = null;
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
    FailMode getValue() {
        return null;
    }

    @Override
    public void setValue(FailMode value) {

    }

    @Override
    public void putAttribute(String key, Attribute attribute) {
        this.attributeMap.put(key, attribute);
    }

    @Override
    public void putAssoc(String name, FailMode assocIndex) {
        this.assocs.put(name, assocIndex);
    }

    @Override
    public FailMode getAssociative(String index) {
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
    public void addVectorItem(FailMode value) {
        this.vectorValue.add(value);
    }



    public void print() {
        System.out.print("Fail_Mode " + getName());
        System.out.println(" ; ");
    }
}
