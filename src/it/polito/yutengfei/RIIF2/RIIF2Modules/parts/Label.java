package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;


public abstract class Label<T> {

    private Boolean isAssociative = false;
    private Boolean vector = false;

    private String name;

    private T value = null;
    private LinkedList<T> vectorValue ;

    private String type;

    private List<Attribute> attributes =  new LinkedList<>();
    private Map<String,AssocIndex> assocs = null;
    private int vectorLength = 0;


    public Boolean isAssociative() {
        return isAssociative;
    }

    public void setAssociative(Boolean associative) {
        isAssociative = associative;

        if (associative)
            this.assocs = new HashMap<>();
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

    public void setVector(Vector vector) {
        this.vector = true;

        Expression exp = vector.getLeft();
        int left = (int) exp.getValue();
        exp = vector.getRight();
        int right = (int) exp.getValue();

        this.vectorValue = new LinkedList<T>();
        this.vectorLength = right*left;

    }

    public boolean containsAssociativeIndex(String index) {
        return this.assocs.containsKey( index );
    }

    public boolean containsAttributeIndex(String atIndex) {
        for (Attribute attribute : this.attributes){
            if (Objects.equals(attribute.getId(), atIndex))
                return true;
        }
        return false;
    }

    public boolean isVector() {
        return vector;
    }

    public void addVectorItem(Object value) {
        this.vectorValue.add((T) value);
    }

    public void print(){
        System.out.print("Parameter " + this.getName());
        System.out.print(" : " + this.getType());

        if (this.getValue() != null)
            System.out.print(" := "  + this.getValue().toString() );
        else
            System.out.print(" := null " );
        System.out.println(";");
    }
}
