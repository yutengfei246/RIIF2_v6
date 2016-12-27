package it.polito.yutengfei.RIIF2.Declarator;

import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.initializer.Initializer;

public interface Declarator {

    public void setDeclaratorId(DeclaratorId declaratorId );
    public void setInitializer(Initializer initializer);
    public DeclaratorId getDeclaratorId();
    public Initializer getInitializer();


}
