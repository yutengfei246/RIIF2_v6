package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;


import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;


public class Platform extends Label<Label>{

    private RIIF2Recorder value;

    @Override
    public void setAssociative(Boolean b) {

    }

    @Override
    public void putAttribute(String key, Attribute attribute) {

    }

    @Override
    public void putAssoc(String name, Label assocIndex) {

    }

    @Override
    public Label getAssociative(String index) {
        return null;
    }


    @Override
    public Attribute getAttribute(String index) {
        return null;
    }

    @Override
    public boolean containsAssociativeIndex(String index) {
        return false;
    }

    @Override
    public boolean containsAttributeIndex(String index) {
        return false;
    }

    @Override
    public void setVector(Vector vector) {

    }

    @Override
    public void addVectorItem(Label value) {

    }

    @Override
    public Label getVector(int index) {
        return null;
    }

    @Override
    public void setPlatform(RIIF2Recorder recorder) {
        this.value = recorder;
    }

    @Override
    public RIIF2Recorder getPlatform() {
        return this.value;
    }

    @Override
    public void print() {

    }
}
