package it.polito.yutengfei.RIIF2.Declarator;


import it.polito.yutengfei.RIIF2.id.Identifier;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;

public class PrimitiveFieldDeclarator implements Declarator{
    private Identifier declaratorId = null;
    private RIIF2Type declaratorType = null;
    private Initializer initializer = null;

    public void setDeclaratorId(Identifier declaratorId) {
        this.declaratorId = declaratorId;
    }

    public void setDeclaratorType(RIIF2Type declaratorType) {
        this.declaratorType = declaratorType;
    }

    public void setInitializer(Initializer initializer) {
        this.initializer = initializer;
    }

    public Identifier getDeclaratorId() {
        return declaratorId;
    }

    public RIIF2Type getDeclaratorType() {
        return declaratorType;
    }

    public Initializer getInitializer() {
        return initializer;
    }
}
