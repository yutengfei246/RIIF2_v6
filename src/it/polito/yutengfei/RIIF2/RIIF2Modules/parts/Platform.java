package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;


import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;

import java.util.List;
import java.util.Map;

public class Platform extends Label<RIIF2Recorder>{

    private RIIF2Recorder value;

    @Override
    public void setAssociative(Boolean b) {

    }

    @Override
    RIIF2Recorder getValue() {
        return null;
    }

    @Override
    public void setValue(RIIF2Recorder value) {
        this.value = value;
    }

    @Override
    List<Attribute> getAttributes() {
        return null;
    }

    @Override
    Map<String, RIIF2Recorder> getAssocs() {
        return null;
    }

    @Override
    public void addAttribute(Attribute attribute) {

    }

    @Override
    public void addAssoc(String name, RIIF2Recorder assocIndex) {

    }

    @Override
    public void setVector(Vector vector) {

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
    public void addVectorItem(RIIF2Recorder value) {

    }

    @Override
    public Attribute getAttribute(String attribute) {
        return null;
    }
}
