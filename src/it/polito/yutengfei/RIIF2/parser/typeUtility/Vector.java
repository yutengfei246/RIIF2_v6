package it.polito.yutengfei.RIIF2.parser.typeUtility;

import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

public class Vector {

    private Expression left;
    private Expression right;


    public Vector(Expression left, Expression right) throws ExpressionTypeNotMarchException {

        if ( ! left.isInteger() || ! right.isInteger() ){
            throw new ExpressionTypeNotMarchException();
        }

        this.left = left;
        this.right = right;
    }

    public void setLeft(Expression left ){
        this.left = left;
    }

    public void setRight(Expression right ){
        this.right = right;
    }

    public Expression getLeft(){
        return this.left;
    }

    public Expression getRight(){
        return this.right;
    }
}
