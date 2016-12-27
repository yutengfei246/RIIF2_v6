package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

public class Parameter<T> extends Label<T> {

    private T value = null;

    private LinkedList<T> vectorValue = null ;
    private Map<String,Object> assocs = null;

    private List<Attribute> attributes =  new LinkedList<>();

    private int vectorLength = 0;


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
    Map<String, Object> getAssocs() {
        return assocs;
    }

    @Override
    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
    }

    @Override
    public void addAssoc(String name, Object assocIndex) {
        this.assocs.put(name,assocIndex);
    }

    @Override
    public void setVector(Vector vector) {
        super.vectorTrue();

        Expression exp = vector.getLeft();
        int left = (int) exp.getValue();
        exp = vector.getRight();
        int right = (int) exp.getValue();

        this.vectorValue = new LinkedList<T>();
        this.vectorLength = right*left;
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
    public void addVectorItem(Object value) {
        this.vectorValue.add((T) value);
    }


}
