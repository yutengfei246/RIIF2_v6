package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

public class Parameter extends Label<Object> {

    private Object value = null;

    private LinkedList<Object> vectorValue = null ;

    private Map<String,Object> assocs = null;
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
    Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public void putAttribute(String key ,Attribute attribute) {
        this.attributeMap.put(key,attribute);
    }

    @Override
    public void putAssoc(String name, Object assocIndex) {
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
    public Object getAssociative(String index) {
        return this.assocs.get(index);
    }

    @Override
    public boolean containsAttributeIndex(String index) {
        return this.attributeMap.containsKey(index);
    }

    @Override
    public Attribute getAttribute(String index) {
        return this.attributeMap.get(index);
    }

    @Override
    public void addVectorItem(Object value) {
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

        if (this.attributeMap.size() != 0 ){
            this.attributeMap.forEach((s, attribute) ->
                System.out.println("Attribute : " + s  + attribute.print())
            );
        }
    }

}
