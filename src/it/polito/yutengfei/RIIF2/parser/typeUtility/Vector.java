package it.polito.yutengfei.RIIF2.parser.typeUtility;

import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;


// should have a check on the left if it is not one, then should throw an exception
public class Vector {

    private Expression left;
    private Expression right;


    public Vector(Expression left, Expression right) {

        this.left = left;
        this.right = right;
    }

    public Expression getLeft(){
        return this.left;
    }

    public Expression getRight(){
        return this.right;
    }


    public Expression getLength(){
        return this.right;
    }


}
