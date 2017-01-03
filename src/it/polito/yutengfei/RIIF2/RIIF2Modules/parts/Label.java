package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;

import java.io.Serializable;


public abstract class Label<T> implements Serializable {

    private Boolean associative = false;
    private Boolean vector = false;

    private String name;
    private String type;
    private Object value;

    private int vectorLength;


    public Boolean isAssociative() {
        return associative;
    }

    void associativeTrue(){
        this.associative = true;
    }

    void associativeFalse(){
        this.associative = false;
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

    public int getVectorLength() {
        return vectorLength;
    }

    void setVectorLength(int vectorLength) {
        this.vectorLength = vectorLength;
    }

    public Object getValue(){
        return this.value;
    }

    public void setValue(Object value){
        this.value = value;
    }

    /***********************************************************************************/

    public abstract void setAssociative(Boolean b);

    public abstract void putAttribute(String key, Attribute attribute);

    public abstract void putAssoc(String name, T assocIndex);

    public abstract T getAssociative(String index);

    public abstract Attribute getAttribute(String index);

    public abstract boolean containsAssociativeIndex(String index);

    public abstract boolean containsAttributeIndex(String index);

    public abstract void setVector(Vector vector);

    public abstract void addVectorItem(T value);

}
