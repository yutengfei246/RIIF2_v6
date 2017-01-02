package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

public class FailMode extends Label<FailMode> {

    private List<Attribute> attributes = null;
    private LinkedList<FailMode> vectorValue = null ;
    private Map<String,FailMode> assocs = null;

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
    List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    Map<String, FailMode> getAssocs() {
        return this.assocs;
    }

    @Override
    public void addAttribute(Attribute attribute) {
        if (this.attributes == null)
            this.attributes = new LinkedList<>();

        this.attributes.add(attribute);
    }

    @Override
    public void addAssoc(String name, FailMode assocIndex) {
        if (this.assocs == null)
            this.assocs = new HashMap<>();

        this.assocs.put(name, assocIndex);
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
        for (Attribute attribute : this.attributes){
            if (Objects.equals(attribute.getId(), index))
                return true;
        }
        return false;
    }

    @Override
    public void addVectorItem(FailMode value) {
        this.vectorValue.add(value);
    }

    @Override
    public Attribute getAttribute(String attributeName ) {
        if (this.attributes == null)
            return null;

        for (Attribute attribute : this.attributes){
            if (Objects.equals(attribute.getId(), attributeName)){
                return attribute;
            }
        }
        return  null;
    }

    public void print() {
        System.out.print("Fail_Mode " + getName());
        System.out.println(" ; ");
    }
}
