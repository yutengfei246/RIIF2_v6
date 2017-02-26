package it.polito.yutengfei.RIIF2.Declarator;


import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

public class AssertionDeclarator implements Declarator{

    Id attributeId ;
    Expression initializer;
    String oper;
    private String unit;


    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getOper(){
        return this.oper;
    }

    public void setAttributeId(Id attributeId) {
        this.attributeId = attributeId;
    }

    public Id getAttributeId()  {
        return this.attributeId;
    }

    public void setExpression(Expression expression) {
        this.initializer = expression;
    }

    public Expression getExpression() {
        return this.initializer;
    }

    @Override
    public void setDeclaratorId(DeclaratorId declaratorId) {

    }

    @Override
    public void setInitializer(Initializer initializer) {
    }

    @Override
    public DeclaratorId getDeclaratorId() {
        return null;
    }

    @Override
    public Initializer getInitializer() {
        return null;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return this.unit;
    }
}
