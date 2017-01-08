package it.polito.yutengfei.RIIF2.id;

import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;

public class DeclaratorId{

    int line , column;

    private String id;

    private Id primitiveId;

    private RIIF2Type typeType = null;
    private RIIF2Type aisType = null ;

    private Id attributeIndex = null;
    private Id associativeIndex = null;
    private Id tableId = null;
    private Id hierPostfix= null;
    private Id tableIndex;


    public void setTypeType(RIIF2Type typeType) {
        this.typeType = typeType;
    }

    public void setId(String id, int line, int charPositionInLine) {
        this.id = id;
        this.line = line;
        this.column = charPositionInLine;
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

    public Id getTableId() {
        return tableId;
    }

    public Id getPrimitiveId() {
        return primitiveId;
    }

    public RIIF2Type getAisType() {
        return aisType;
    }

    public Id getHierPostfix() {
        return hierPostfix;
    }

    public boolean hasAisType() {
        return this.aisType == null ? false : true;
    }

    public Boolean hasHierPostfix(){
        return this.hierPostfix == null ? false : true;
    }

    public void setTableIndex(Id tableIndex) {
        this.tableIndex = tableIndex;
    }

    public Id getTableIndex(){
        return this.tableIndex;
    }

    public boolean hasTableIndex() {
        return this.tableIndex == null ? false : true ;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }
}
