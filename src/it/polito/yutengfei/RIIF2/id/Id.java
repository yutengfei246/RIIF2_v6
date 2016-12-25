package it.polito.yutengfei.RIIF2.id;

import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.util.Collection;
import java.util.LinkedList;

public class Id {
    private final String type;
    private final String id;

    private Id associativeIndex;
    private Id attributeIndex;
    private Id primitiveId;

    private LinkedList<Id> hierPostfixIds = new LinkedList<>();
    private Id associaticeIndex;

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

    private Collection<? extends Id> hierPostfixIds() {
        return this.hierPostfixIds;
    }

    public String id() {
        return this.id;
    }

    private String type(){
        return this.type;
    }

    private Id setAttributeIndex(Id attributeIndex) {
        this.attributeIndex = attributeIndex;
        return this;
    }

    private Id setAssociaticeIndex(Id associaticeIndex) {
        this.associaticeIndex = associaticeIndex;
        return this;
    }

    public Id getAttributeIndex() {
        return attributeIndex;
    }

    public static Id associativeIndex(String identifier) {
        return new Id(RIIF2Grammar.TYPE_ASSOCIATIVE_INDEX,identifier);
    }

    public static Id attributeIndex(String identifier) {
        return new Id(RIIF2Grammar.TYPE_ATTRIBUTE, identifier);
    }

    public static Id hierIndex(String identifier) {
        return new Id(RIIF2Grammar.TYPE_HIER, identifier);
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

    public static Id associativeId(Id primitiveId, Id associativeIndex) {
        return primitiveId.setAssociaticeIndex(associativeIndex);
    }

    public static Id attributeId(Id primitiveId, Id attributeIndex) {
        return primitiveId.setAttributeIndex( attributeIndex );
    }

    public static Id tableId(Id attributeId, String identifier1, String identifier2) {
        if (attributeId.getAttributeIndex().id() != "Item"){
            System.err.println(" cannot create table Id  because the attributeIndex is not Irem");
        }

        return new Id()
    }
}
