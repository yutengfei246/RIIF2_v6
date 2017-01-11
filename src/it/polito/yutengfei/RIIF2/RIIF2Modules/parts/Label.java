package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;

import java.io.Serializable;

public abstract class Label<T extends Label> implements Serializable {

    private Boolean associative = false;
    private Boolean vector = false;

    private String name = null;
    private String type = null;
    private Object value = null;

    private int vectorLength = 0;
    private int vectorLeft = 0;
    private int vectorRight = 0;


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

    void setVectorLeft(int vectorLeft) {
        this.vectorLeft = vectorLeft;
    }

    void setVectorRight(int vectorRight){
        this.vectorRight = vectorRight;
    }

    public int getVectorLeft() {
        return this.vectorLeft;
    }

    public int getVectorRight() {
        return this.vectorRight;
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

    public abstract void setVector(Vector vector, RIIF2Recorder recorder) ;

    public abstract void addVectorItem(T value);

    public abstract T getVector(int index);

    public abstract void setPlatform(RIIF2Recorder recorder);

    public abstract RIIF2Recorder getPlatform();

    public abstract void print();
}
