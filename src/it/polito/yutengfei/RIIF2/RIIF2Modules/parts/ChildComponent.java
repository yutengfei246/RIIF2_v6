package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

public class ChildComponent extends Label<ChildComponent> {

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
    public void putAttribute(String key, Attribute attribute) {

    }

    @Override
    public void putAssoc(String name, ChildComponent assocIndex) {
        this.assocs.put(name,assocIndex);
    }

    @Override
    public ChildComponent getAssociative(String index) {
        return this.assocs.get(index);
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

    @Override
    public void setPlatform(RIIF2Recorder recorder) {

    }

    @Override
    public RIIF2Recorder getPlatform() {
        return null;
    }

    @Override
    public Attribute getAttribute(String attribute) {
        return null;
    }


    public void print(){
        System.out.print("ChildComponent " + super.getName() );
        if (this.assocs != null && this.assocs.size() != 0)
            System.out.print("[ ]");

        System.out.println(";");

        if (this.assocs != null && this.assocs.size() != 0) {
            for (Map.Entry<String,ChildComponent> entry : this.assocs.entrySet() ) {
                System.out.println("ChildComponent " + super.getName() + "[" +
                        entry.getValue().getName() + "]" );
            }
        }
    }


}
