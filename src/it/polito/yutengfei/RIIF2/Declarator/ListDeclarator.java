package it.polito.yutengfei.RIIF2.Declarator;

import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.initializer.Initializer;

/**
 * Created by yutengfei on 27/12/16.
 */
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
