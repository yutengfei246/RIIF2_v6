package it.polito.yutengfei.RIIF2.Declarator;

import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;

public class AisDeclarator implements  Declarator{
    private DeclaratorId declaratorId;
    private RIIF2Type aisType;
    private RIIF2Type associativeIndex;
    private RIIF2Type attributeIndex;

    public RIIF2Type getAisType() {
        return aisType;
    }

    public RIIF2Type getAssociativeIndex() {
        return associativeIndex;
    }

    public RIIF2Type getAttributeIndex() {
        return attributeIndex;
    }

    private Initializer initializer;

    @Override
    public void setDeclaratorId(DeclaratorId declaratorId) {
        this.declaratorId = declaratorId;
    }

    @Override
    public void setInitializer(Initializer initializer) {
        this.initializer = initializer;
    }

    @Override
    public DeclaratorId getDeclaratorId() {
        return declaratorId;
    }

    @Override
    public Initializer getInitializer() {
        return initializer;
    }

    public void setAisType(RIIF2Type aisType) {
        this.aisType = aisType;
    }

    public void setAssociativeIndex(RIIF2Type associativeIndex) {
        this.associativeIndex = associativeIndex;
    }

    public void setAttributeIndex(RIIF2Type attributeIndex) {
        this.attributeIndex = attributeIndex;
    }


}
