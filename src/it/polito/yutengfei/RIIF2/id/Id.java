package it.polito.yutengfei.RIIF2.id;

import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Id {
    private final String type;
    private final String id;

    private List<Id> associativeIndexs = new LinkedList<>();
    private List<Id> attributeIndexs =  new LinkedList<>();
    private Id primitiveId;

    private LinkedList<Id> hierPostfixIds = new LinkedList<>();

    private String xx;
    private String yy;

    public Id(String typeAssociativeIndex, String identifier) {
        this.type = typeAssociativeIndex;
        this.id = identifier;
    }

    public Id(String typeHier, Id primitiveId, Id hierPostfixId) {
        this.type = typeHier;
        this.id = hierPostfixId.id();

        this.hierPostfixIds.addAll( primitiveId.hierPostfixIds());
        this.hierPostfixIds.add( primitiveId );
    }

    public Id(String table, Id attributeId, String identifier1, String identifier2) {
        this.type = table;
        this.id = attributeId.id();
        this.associativeIndexs = attributeId.getAssociativeIndexs();
        this.attributeIndexs = attributeId.getAttributeIndexs();
        this.primitiveId = attributeId.getPrimitiveId();

        this.xx = identifier1;
        this.yy = identifier2;
    }

    public static Id associativeIndex(String identifier) {
        return new Id(RIIF2Grammar.TYPE_ASSOCIATIVE_INDEX,identifier);
    }

    public static Id attributeIndex(String identifier) {
        return new Id(RIIF2Grammar.TYPE_ATTRIBUTE_INDEX, identifier);
    }

    public static Id hierIndex(String identifier) {
        return new Id(RIIF2Grammar.TYPE_HIER_INDEX, identifier);
    }

    public static Id childComponent(String identifier) {
        return new Id(RIIF2Grammar.TYPE_CC,identifier);
    }

    public static Id primitiveId(String identifier) {
        return new Id(RIIF2Grammar.TYPE_PRIMITIVE, identifier);
    }

    public static Id primitiveIdId(Id primitiveId, Id hierPostfixId) {
        return new Id(RIIF2Grammar.TYPE_HIER, primitiveId,hierPostfixId);
    }

    //TODO: this is not correct, it need to retreive and check 
    public static Id associativeId(Id primitiveId, Id associativeIndex) {
        return primitiveId.addAssociativeIndex(associativeIndex);
    }

    public static Id attributeId(Id primitiveId, Id attributeIndex) {
        return primitiveId.addAttributeIndex( attributeIndex );
    }

    public static Id tableId(Id attributeId, String identifier1, String identifier2) {
        return new Id(RIIF2Grammar.TABLE,attributeId,identifier1,identifier2);
    }

    public List<Id> getAssociativeIndexs() {
        return associativeIndexs;
    }

    public Id getPrimitiveId() {
        return primitiveId;
    }

    private Collection<? extends Id> hierPostfixIds() {
        return this.hierPostfixIds;
    }

    public String id() {
        return this.id;
    }

    private String type(){
        return this.type;
    }

    private Id addAttributeIndex(Id attributeIndex) {
        this.attributeIndexs.add(attributeIndex);
        return this;
    }

    private Id addAssociativeIndex(Id associativeIndex) {
        this.associativeIndexs.add(associativeIndex);
        return this;
    }

    public List<Id> getAttributeIndexs() {
        return attributeIndexs;
    }
}
