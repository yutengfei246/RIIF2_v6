package it.polito.yutengfei.RIIF2.id;

import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;

public class DeclaratorId{

    private String id;

    private Id primitiveId;

    private RIIF2Type typeType = null;
    private RIIF2Type aisType;

    private Id attributeIndex = null;
    private Id associativeIndex = null;
    private Id tableId;
    private Id hierPostfix;


    public void setTypeType(RIIF2Type typeType) {
        this.typeType = typeType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrimitiveId(Id primitiveId) {
        this.primitiveId = primitiveId;
    }

    public void setAisType(RIIF2Type aisType) {
        this.aisType = aisType;
    }

    public void setAttributeIndex(Id attributeIndex) {
        this.attributeIndex = attributeIndex;
    }

    public void setAssociativeIndex(Id associativeIndex) {
        this.associativeIndex = associativeIndex;
    }

    public void setTableId(Id tableId) {
        this.tableId = tableId;
    }

    public void setHierPostfix(Id id) {
        this.hierPostfix = id ;
    }

    public String getId() {
        return id;
    }

    public RIIF2Type getTypeType() {
        return typeType;
    }

    public boolean hasAttributeIndex() {
        return this.attributeIndex == null ? false :true;
    }

    public boolean hasTypeType() {
        return this.typeType == null ? false : true ;
    }

    public boolean hasAssociativeIndex() {
        return this.associativeIndex == null ? false: true ;
    }

    public Id getAssociativeIndex() {
        return associativeIndex;
    }

    public Id getAttributeIndex() {
        return attributeIndex;
    }
}
