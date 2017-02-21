package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.parser.typeUtility.*;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

public abstract class Label<T extends Label> extends ValueMember{

    private final RIIF2Recorder recorder;
    private String name;

    private Vector<T> vector;

    private Map<String,T> associativeMap;
    private Map<String,Attribute> attributeMap;

    private EnumType enumType;

    protected Label(RIIF2Recorder recorder) {
        this.recorder = recorder;
    }

    /*
     *The given value could be String, Expression, ArrayInitializer, ArrayWrapperInitializer, TableInitializer
     * */
    public void setValue(Object value) throws FieldTypeNotMarchException {
        super.setValue(this ,value, recorder);
    }
    /**
     * name value type setters and getters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * enumType setters and getters
     */
    public void setEnumType(EnumType enumType) {
        this.enumType = enumType;
    }

    public EnumType getEnumType(){
        return this.enumType;
    }

    public boolean isEnumType(){
        return this.getEnumType() != null ;
    }

    /**
     * attribute setters and getters
     */
    public void setAttribute(Boolean b ) {
        if (b) this.attributeMap = new HashMap<>();
    }

    public Boolean hasAttribute() {
        return this.attributeMap != null;
    }

    public void putAttribute(String attributeName, Attribute attribute) {
        if (this.attributeMap == null )
            this.setAttribute(true);

        this.attributeMap.put(attributeName,attribute);
    }

    public Attribute getAttribute(String attributeName) {
        if (this.attributeMap == null )
            return null;

        return this.attributeMap.get(attributeName);
    }

    public Boolean containsAttribute(String attributeName) {
        return this.attributeMap.containsKey(attributeName);
    }

    /**
     * associative setters and getters
     */
    public Boolean isAssociative() {
        return this.associativeMap != null;
    } // specify this label is a associativeLabel

    public void setAssociative(Boolean b) {
        if (b) this.associativeMap = new HashMap<>();
    }

    public void putAssociative(String associativeName, T entry){
        this.associativeMap.put(associativeName, entry);
    }

    public T getAssociative(String associativeName) {

        return this.associativeMap.get(associativeName);
    }

    public Boolean containsAssociative(String associativeName) {
        return this.associativeMap.containsKey(associativeName);
    }

    /**
     * vector setters and getters
     */
    public void setVector(Boolean b) {
        if (b) this.vector = new Vector<>();
    }

    public Boolean isVector() {
        return this.vector != null;
    }

    public void setVectorLength(int length) {
        this.vector.setLength(length);
    }

    public int getVectorLength() {
        return this.vector.getLength();
    }

    public void setVectorValue(int index, Object value) throws FieldTypeNotMarchException {
        this.vector.setValue(index,value);
    }

    public void assignVectorItem(int index, T label){
        this.vector.assignFlatItem(index, label);
    }

    public void assignVectorValue(int left, int right, Object value ) throws FieldTypeNotMarchException {
        this.vector.assignFlatValue(left, right, value);
    }

    public void addVectorItem(T item){
        this.vector.add(item);
    }

    public T getVectorItem(int index){
        return this.vector.get(index);
    }


    /***********************************************************************************/

    public abstract void vectorInitializer(String name, String type, Object value );

    public abstract void print();

    public abstract String getLiteral();

    void printVector(){
        if (this.isVector()){

            this.vector.print();
        }
    }

    protected void printAttribute(){
        if (this.hasAttribute()) {
            this.attributeMap.forEach((s, attribute) -> {
                System.out.print(" @Attribute-" );
                attribute.print();
            });
            System.out.println(" ");
        }
    }

    protected void printAssociative(){

        if (this.isAssociative() ) {
            System.out.println("----------------start associative " + this.getName() + "--------------------");
            this.associativeMap.forEach((s, t) -> {
                t.print();
            });
            System.out.println("----------------end associative " + this.getName() + "--------------------");
        }

    }

    public RIIF2Recorder getRecorder() {
        return this.recorder;
    }

    public void setVectorLeftExpression(Expression value) {
        this.vector.setLeftExpression(value);
    }

    public void setVectorRightExpression(Expression value) {
        this.vector.setRightExpression(value);
    }

    public Collection<T> getAssociatives() {
        if (this.associativeMap == null || this.associativeMap.size() == 0)
            return null;

        return this.associativeMap.values();
    }

    public Collection<Attribute> getAttributes() {
        if (this.attributeMap == null || this.attributeMap.size() == 0)
            return null;

        return this.attributeMap.values();
    }

    public List getArray() {

        if (this.vector != null) {
            ArrayList array = this.vector.getArrayList();

            return array;
        }

        return null;
    }
}
