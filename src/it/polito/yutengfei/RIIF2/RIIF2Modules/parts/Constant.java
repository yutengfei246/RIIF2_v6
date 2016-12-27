package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;


import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;

import java.util.List;
import java.util.Map;

public class Constant<T> extends Label<T> {


    @Override
    public void setAssociative(Boolean b) {

    }

    @Override
    T getValue() {
        return null;
    }

    @Override
    public void setValue(T value) {

    }

    @Override
    List<Attribute> getAttributes() {
        return null;
    }

    @Override
    Map<String, Object> getAssocs() {
        return null;
    }

    @Override
    public void addAttribute(Attribute attribute) {

    }

    @Override
    public void addAssoc(String name, Object assocIndex) {

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
    public void addVectorItem(Object value) {

    }
}
