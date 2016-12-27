package it.polito.yutengfei.RIIF2.Declarator;

import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.initializer.Initializer;


public class ListDeclarator implements Declarator {
    private DeclaratorId declaratorId;
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
}
