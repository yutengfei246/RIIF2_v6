package it.polito.yutengfei.RIIF2.util.utilityWrapper;

class Operation {


    private int opr;
    private Expression oprExpression = null;

    private Expression targetExpression = null;


    void setOpr(int opr) {
        this.opr = opr;
    }

    void setOprExpression(Expression oprExpression) {
        if( this.oprExpression != null){
            this.targetExpression = oprExpression;
        }else
            this.oprExpression = oprExpression;
    }

    int getOpr() {
        return opr;
    }

    Expression getOprExpression() {
        return oprExpression;
    }

    Expression getOprTargetExpression() {
        return targetExpression;
    }
}
