package it.polito.yutengfei.RIIF2.util.utilityWrapper;

import java.io.Serializable;

class Operation implements Serializable{


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

    Boolean isOprWithSelf(){
        return oprExpression == null && targetExpression == null;
    }

    Boolean isOprWithOneExpression(){
        return oprExpression != null && targetExpression == null ;
    }

    Boolean isOprWithTwoExpression(){
        return oprExpression != null && targetExpression != null;
    }

    Expression getOprExpression() {
        return oprExpression;
    }

    Expression getOprTargetExpression() {
        return targetExpression;
    }
}
