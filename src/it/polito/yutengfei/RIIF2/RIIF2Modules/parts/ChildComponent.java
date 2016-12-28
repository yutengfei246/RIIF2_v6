package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

public class ChildComponent<ChildComponent> extends Label<ChildComponent> {

    private LinkedList<ChildComponent> vectorValue = null ;
    private Map<String,ChildComponent> assocs = null;


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
    ChildComponent getValue() {
        return null;
    }


    @Override
    public void setValue(ChildComponent value) {

    }

    @Override
    List<Attribute> getAttributes() {
        return null;
    }

    @Override
    Map<String, ChildComponent> getAssocs() {
        return this.assocs;
    }


    @Override
    public void addAttribute(Attribute attribute) {}

    @Override
    public void addAssoc(String name, ChildComponent assocIndex) {
        this.assocs.put(name,assocIndex);
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
        return this.assocs.containsKey( index );
    }

    @Override
    public boolean containsAttributeIndex(String index) {
        return false;
    }

    @Override
    public void addVectorItem(ChildComponent value) {
        this.vectorValue.add(value);
    }

    public void print(){
        System.out.print("ChildComponent " + super.getName());

        System.out.println(";");
    }


}
