package it.polito.yutengfei.RIIF2.Declarator;

import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;

public class ChildComponentDeclarator implements Declarator {
    private DeclaratorId declaratorId;
    private RIIF2Type CCType;

    @Override
    public void setDeclaratorId(DeclaratorId declaratorId) {
        this.declaratorId = declaratorId;
    }

    @Override
    public void setInitializer(Initializer initializer) {}

    @Override
    public DeclaratorId getDeclaratorId() {
        return declaratorId;
    }

    @Override
    public Initializer getInitializer() {
        return null;
    }

    public void setCCType(RIIF2Type CCType) {
        this.CCType = CCType;
    }

    public RIIF2Type getCCType() {
        return CCType;
    }
}
