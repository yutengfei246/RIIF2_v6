package it.polito.yutengfei.RIIF2.Declarator;

import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.initializer.Initializer;

public interface Declarator {

    void setDeclaratorId(DeclaratorId declaratorId);
    void setInitializer(Initializer initializer);
    DeclaratorId getDeclaratorId();
    Initializer getInitializer();


}
