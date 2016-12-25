package it.polito.yutengfei.RIIF2.util.utilityWrapper;

/**
 * Created by yutengfei on 11/12/16.
 */
public class Operation {


    private int opr;
    private Expression oprExpression = null;

    private Expression targetExpression = null;


    public void setOpr(int opr) {
        this.opr = opr;
    }

    public void setOprExpression(Expression oprExpression) {
        if( this.oprExpression != null){
            this.targetExpression = oprExpression;
        }else
            this.oprExpression = oprExpression;
    }

    public int getOpr() {
        return opr;
    }

    public Expression getOprExpression() {
        return oprExpression;
    }

    public Expression getOprTargetExpression() {
        return targetExpression;
    }
}
