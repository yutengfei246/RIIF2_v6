package it.polito.yutengfei.RIIF2.id;

import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;

import java.io.Serializable;

public class DeclaratorId implements Serializable{

    private int line , column;

    private String id;

    private Id primitiveId;

    private RIIF2Type typeType = null;
    private RIIF2Type aisType = null ;

    private Id attributeIndex = null;
    private Id associativeIndex = null;
    private Id hierPostfix= null;
    private Id tableIndex;


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
        return this.attributeIndex != null;
    }

    public boolean hasTypeType() {
        return this.typeType != null;
    }

    public boolean hasAssociativeIndex() {
        return this.associativeIndex != null;
    }

    public Id getAssociativeIndex() {
        return associativeIndex;
    }

    public Id getAttributeIndex() {
        return attributeIndex;
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
        return this.aisType != null;
    }

    public Boolean hasHierPostfix(){
        return this.hierPostfix != null;
    }

    public void setTableIndex(Id tableIndex) {
        this.tableIndex = tableIndex;
    }

    public Id getTableIndex(){
        return this.tableIndex;
    }

    public boolean hasTableIndex() {
        return this.tableIndex != null;
    }

    public void setLine(int line){
        this.line = line;
    }

    public void setColumn( int column){
        this.column = column;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    @Override
    public String toString(){
        StringBuilder stringBuffer = new StringBuilder();

        if (this.primitiveId != null) {
            stringBuffer.append(this.primitiveId.toString());
        }

        if (this.associativeIndex != null)
            stringBuffer.append("[").append(this.associativeIndex.toString()).append("]");

        if (this.attributeIndex != null)
            stringBuffer.append("'").append(this.attributeIndex.toString());

        if (this.hierPostfix != null )
            stringBuffer.append(".").append(this.hierPostfix.toString());

        return stringBuffer.toString();
    }
}
