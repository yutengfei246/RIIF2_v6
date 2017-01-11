package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

public class Constant extends Label<Label> {

    private LinkedList<Label> vectorValue = null ;

    private Map<String,Label> assocs = null;
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
    public void putAttribute(String key ,Attribute attribute) {
        this.attributeMap.put(key,attribute);
    }

    @Override
    public void putAssoc(String name, Label assocIndex) {
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

        for (int i= 0; i < left*right ; i++ )
            this.vectorValue.add(new Constant());

    }

    @Override
    public boolean containsAssociativeIndex(String index) {
        return this.assocs.containsKey( index );
    }

    @Override
    public Label getAssociative(String index) {
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
    public void addVectorItem(Label value) {
        this.vectorValue.add(value);
    }

    @Override
    public Label getVector(int index) {
        return this.vectorValue.get(index);
    }

    @Override
    public void setPlatform(RIIF2Recorder recorder) {

    }

    @Override
    public RIIF2Recorder getPlatform() {
        return null;
    }


    @Override
    public void print() {
        System.out.print("Constant " + this.getName());
        System.out.print(" : " + this.getType());

        if (isAssociative()) {
            System.out.print("[]");
        }

        if (this.getValue() != null)
            System.out.print(" := "  + this.getValue().toString() );
        else
            System.out.print(" := null " );

        System.out.println(";");

        if (this.attributeMap.size() > 0) {
            System.out.println(getName() + "@attribute ");

            this.attributeMap.forEach((s, attribute) -> attribute.print());

            System.out.println(getName() + "@endattribute");
        }

        if (isAssociative()) {
            this.assocs.forEach((s, label) -> {
                System.out.println(getName() + "[" + s + "]");
                label.print();
            });
        }


        if (this.vectorValue != null && this.vectorValue.size() != 0) {
            System.out.println("--vector--");
            this.vectorValue.forEach(Label::print);
            System.out.println("--vector end ");
        }
    }
}
