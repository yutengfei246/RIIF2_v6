package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.EnumType;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public abstract class Label<T extends Label> implements Serializable {

    private Boolean associative = false;
    private Boolean vector = false;

    private String name = null;
    private String type = null;
    private Object value = null;

    private int vectorLength = 0;
    private int vectorLeft = 0;
    private int vectorRight = 0;
    private EnumType enumType = null;

    private int _self1 = -1;
    private int _self2 = -1;

    public void set_self1(int i){
        this._self1 = i;
    }

    public void set_self2(int i){
        this._self2  = i;
    }

    public void resetSelf(){
        this._self1 = -1;
        this._self2 = -1;
    }

    public void printSelf(){
        System.out.println( this._self1  +" " + this._self2);
    }

    public void setSelfValue(Object selfValue){
        if ( this._self1 == -1 && this._self2 == -1 )
            this.value = selfValue;

        LinkedList<Object> lst = (LinkedList<Object>) this.value;
        if (this._self1 != -1 && this._self2 == -1){
            LinkedList<Object> newLst = new LinkedList<>();

            for (int i = 0 ; i < this._self1 ; i++)
                newLst.add(lst.get(i));
            newLst.add(selfValue);
            for (int i = this._self1; i <  lst.size() ; i++)
                newLst.add(lst.get(i));

            this.value = newLst;
        }

        if (this._self1 != -1 && this._self2 != -1){
            Item item = (Item) lst.get(this._self1);
            item.getUnitItem(this._self2).setValue(selfValue);
        }

    }

    public Object getSelfValue(){
        if ( this._self1 == -1 && this._self2 == -1 )
            return this.value;

        if (!(this.getValue() instanceof List))
            return null;

        List lst = (List) this.getValue();
        if (this._self1 != -1 && this._self2 == -1)
            return lst.get(this._self1);

        if (this._self1 != -1 && this._self2 != -1 )
            return ((Item)lst.get(this._self1)).getUnitItem(this._self2).getValue();

        return null;
    }

    public String getSelfValueType(){

        if (this._self1 == -1 && this._self2 == -1)
            return this.type;

        if (this._self1 != -1  && this._self2 == -1){
            //TODO:: reserved

        }

        if (this._self1 != -1 && this._self2 != -1 ){
            return ((Item)((List) this.getValue()).get(this._self1)).getUnitItem(this._self2).getType();
        }

        return null;
    }

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

    public void setEnumType(EnumType enumType) {
        this.enumType = enumType;
    }

    public EnumType getEnumType(){
        return this.enumType;
    }

    public boolean isEnumType(){
        return this.getEnumType() != null ;
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
