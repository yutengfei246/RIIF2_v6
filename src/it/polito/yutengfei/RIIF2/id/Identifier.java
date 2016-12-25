package it.polito.yutengfei.RIIF2.id;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;

import java.util.ArrayList;
import java.util.List;

public class Identifier {

    private String id;
    private String identifier = null;

    private Identifier primitiveId;

    private List<Attribute> attributes = new ArrayList<>();
    private RIIF2Type typeType;
    private RIIF2Type aisType;

    private Id attributeIndex;
    private Id associativeIndex;
    private Id tableId;
    private Id hierPostfix;


    public void setTypeType(RIIF2Type typeType) {
        this.typeType = typeType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId(Identifier primitiveId) {
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
}
