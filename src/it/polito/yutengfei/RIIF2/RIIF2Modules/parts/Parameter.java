package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

public class Parameter<T> extends Label<T> {

    private T value = null;

    private LinkedList<T> vectorValue = null ;
    private Map<String,T> assocs = null;

    private List<Attribute> attributes =  new LinkedList<>();

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
    T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    Map<String, T> getAssocs() {
        return this.assocs;
    }


    @Override
    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
    }

    @Override
    public void addAssoc(String name, T assocIndex) {
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

        this.vectorValue = new LinkedList<T>();

    }

    @Override
    public boolean containsAssociativeIndex(String index) {
        return this.assocs.containsKey( index );
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
    public void addVectorItem(T value) {
        this.vectorValue.add(value);
    }

    public void print(){
        System.out.print("Parameter " + this.getName());
        System.out.print(" : " + this.getType());

        if (this.getValue() != null)
            System.out.print(" := "  + this.getValue().toString() );
        else
            System.out.print(" := null " );
        System.out.println(";");
    }

}
