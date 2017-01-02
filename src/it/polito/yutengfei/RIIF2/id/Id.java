package it.polito.yutengfei.RIIF2.id;

import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Id {
    private String type;
    private String id;

    // for hierarchy
    private LinkedList<Id> hierPostfixIds = new LinkedList<>();

    private String xx;
    private String yy;

    private Id attributeIndex = null;  // current attribute index
    private Id associativeIndex = null; // current attribute index

    public Id(/* Simple index Id and primitive Id */String typeAssociativeIndex, String identifier) {
        this.type = typeAssociativeIndex;
        this.id = identifier;
    }

    public Id(/* Hierarchy primitive index typically is a assign Id */String typeHier, Id primitiveId, Id hierPostfixId) {
        this.type = typeHier;
        this.id = hierPostfixId.getId();

        this.hierPostfixIds.addAll( primitiveId.hierPostfixIds());
        this.hierPostfixIds.add( primitiveId );
    }

    public Id(String table, Id attributeId, String identifier1, String identifier2) {
        this.type = table;
        this.id = attributeId.getId();

        if (attributeId.attributeIndex() == null
                || !Objects.equals(attributeId.attributeIndex().getId(), "Item")) {
            System.err.print("Error: table Id can not be created ");
            System.exit(1);
        }

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

    public static Id primitiveId(String identifier) {
        return new Id(RIIF2Grammar.TYPE_PRIMITIVE, identifier);
    }

    public static Id primitiveIdId(Id primitiveId, Id hierPostfixId) {
        return new Id(RIIF2Grammar.TYPE_HIER, primitiveId,hierPostfixId);
    }

    public static Id associativeId(Id primitiveId, Id associativeIndex) {
        return primitiveId.addAssociativeIndex(associativeIndex);
    }

    public static Id attributeId(Id primitiveId, Id attributeIndex) {
        return primitiveId.addAttributeIndex( attributeIndex );
    }

    public static Id tableId(Id attributeId, String identifier1, String identifier2) {
        return new Id(RIIF2Grammar.TABLE,attributeId,identifier1,identifier2);
    }

    private Id addAttributeIndex(Id attributeIndex) {
        this.type = RIIF2Grammar.ID_ATTRIBUTE;
        this.attributeIndex = attributeIndex;
        return this;
    }

    private Id addAssociativeIndex(Id associativeIndex) {
        this.type = RIIF2Grammar.ID_ASSOCIATIVE;
        this.associativeIndex = associativeIndex;
        return this;
    }

    public List<Id> hierPostfixIds() {
        return this.hierPostfixIds;
    }

    private Id attributeIndex() {
        return this.attributeIndex;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
