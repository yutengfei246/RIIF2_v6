package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;

import java.util.List;
import java.util.Map;


public abstract class Label<T> {

    private Boolean isAbstract;
    private Boolean isAssociative;

    private String name;
    private T value;
    private String type;

    private List<Attribute> attributes = null;
    private Map<String,AssocIndex> assocs = null;

    public Boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(Boolean anAbstract) {
        isAbstract = anAbstract;
    }

    public Boolean isAssociative() {
        return isAssociative;
    }

    public void setAssociative(Boolean associative) {
        isAssociative = associative;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void addAttribute(Attribute attribute){
        this.attributes.add(attribute);
    }

    public Map<String, AssocIndex> getAssocs() {
        return assocs;
    }

    public void addAssocs(String name, AssocIndex assocValue) {
        this.assocs.put(name,assocValue);
    }


}
