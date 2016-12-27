package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;


public abstract class Label<T> {

    private Boolean isAssociative = false;
    private Boolean vector = false;

    private String name;
    private String type;


    public Boolean isAssociative() {
        return isAssociative;
    }

    void associativeTrue(){
        this.isAssociative = true;
    }

    void associativeFalse(){
        this.isAssociative = false;
    }

    void vectorTrue(){
        this.vector = true;
    }

    void vectorFalse(){
        this.vector = false;
    }

    public boolean isVector() {
        return vector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void setAssociative(Boolean b);

    abstract T getValue();

    public abstract void setValue(T value);

    abstract List<Attribute> getAttributes();

    abstract Map<String, Object > getAssocs();

    public abstract void addAttribute(Attribute attribute);

    public abstract void addAssoc(String name, Object assocIndex);

    public abstract void setVector(Vector vector);

    public abstract boolean containsAssociativeIndex(String index);

    public abstract boolean containsAttributeIndex(String index);

    public abstract void addVectorItem(Object value);

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
