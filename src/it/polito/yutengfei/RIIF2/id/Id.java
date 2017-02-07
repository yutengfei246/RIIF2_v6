package it.polito.yutengfei.RIIF2.id;

import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Id implements Serializable {

    private int line;
    private int column;

    private String type;
    private String id;

    // for hierarchy
    private LinkedList<Id> hierPostfixIds = new LinkedList<>();

    private String xx;
    private String yy;

    private Id attributeIndex = null;  // current attribute index
    private Id associativeIndex = null; // current attribute index

    /**
     * It is a simple index constructor with the indexId line and column number
     * attribute index / associative Index / Hierarchical index / simple primitive Identifier
     * @param typeAssociativeIndex index type
     * @param identifier index id
     * @param line line
     * @param column column
     */
    public Id(String typeAssociativeIndex, String identifier, int line, int column) {
        this.type = typeAssociativeIndex;
        this.id = identifier;
        this.line = line;
        this.column = column;
    }

    /**
     * It is the method that generate Hierarchical primitive Id
     * @param typeHier RIIF2Grammar type hier
     * @param primitiveId the primitive Id
     * @param hierPostfixId  the hierPost Id
     */

    public Id(/* Hierarchy primitive index typically is a assign Id */String typeHier, Id primitiveId, Id hierPostfixId) {
        this.type = typeHier;
        this.id = hierPostfixId.getId();

        this.hierPostfixIds.addAll( primitiveId.hierPostfixIds());
        this.hierPostfixIds.add( primitiveId );
    }

    public Id(String table, Id attributeId, String identifier1, String identifier2, int line, int column) {
        this.type = table;
        this.id = attributeId.getId();

        if (attributeId.getAttributeIndex() == null
                || !Objects.equals(attributeId.getAttributeIndex().getId(), "Item")) {
            System.err.print("Error: table Id can not be created ");
            System.exit(1);
        }

        this.xx = identifier1;
        this.yy = identifier2;

        this.line = line ;
        this.column = column;
    }

    public Id(String table, String identifier1, String identifier2, int line, int column) {
        this.type = table;
        this.xx = identifier1;
        this.yy = identifier2;

        this.line = line;
        this.column = column;

    }


    /******************************************************************************************************/
    public static Id associativeIndex(String identifier, int line, int charPositionInLine) {
        return new Id(RIIF2Grammar.TYPE_ASSOCIATIVE_INDEX,identifier, line, charPositionInLine);
    }

    public static Id attributeIndex(String identifier, int line, int charPositionInLine) {
        return new Id(RIIF2Grammar.TYPE_ATTRIBUTE_INDEX, identifier,line, charPositionInLine);
    }

    public static Id hierIndex(String identifier, int line, int charPositionInLine) {
        return new Id(RIIF2Grammar.TYPE_HIER_INDEX, identifier, line, charPositionInLine);
    }

    public static Id primitiveId(String identifier, int line, int charPositionInLine) {
        return new Id(RIIF2Grammar.TYPE_PRIMITIVE, identifier, line, charPositionInLine);
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

    public static Id tableId(Id attributeId, String identifier1, String identifier2, int line, int column) {
        return new Id(RIIF2Grammar.TABLE,attributeId,identifier1,identifier2, line, column);
    }

    public static Id tableId(String identifier1, String identifier2, int Identifier2TokenLine, int positionInLine) {
        return new Id(RIIF2Grammar.TABLE, identifier1, identifier2 , Identifier2TokenLine,positionInLine);
    }

    /************************************************************************************************************/

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

    private Id getAttributeIndex() {
        return this.attributeIndex;
    }

    private Id getAssociativeIndex() {
        return associativeIndex;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getLine() { return line; }

    public int getColumn() { return column; }

    public String getXX() {
        return xx;
    }

    public String getYY() {
        return yy;
    }

    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();

        if (this.id != null)
        stringBuffer.append(this.id );

        if (this.hierPostfixIds != null && this.hierPostfixIds().size() != 0)
            this.hierPostfixIds.forEach(id1 -> stringBuffer.append(id1.toString()));

        if (this.associativeIndex != null )
            stringBuffer.append("[").append(this.associativeIndex.toString()).append("]");

        if (this.attributeIndex != null)
            stringBuffer.append("'").append(this.attributeIndex.toString());
        return stringBuffer.toString();
    }
}
