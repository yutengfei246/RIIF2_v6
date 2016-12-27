package it.polito.yutengfei.RIIF2.Declarator;


import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;

public class PrimitiveFieldDeclarator implements Declarator{
    private DeclaratorId declaratorId = null;
    private RIIF2Type declaratorType = null;
    private Initializer initializer = null;

    public void setDeclaratorType(RIIF2Type declaratorType) {
        this.declaratorType = declaratorType;
    }

    public RIIF2Type getDeclaratorType() {
        return declaratorType;
    }

    @Override
    public void setDeclaratorId(DeclaratorId declaratorId) {
        this.declaratorId =declaratorId;
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
}
