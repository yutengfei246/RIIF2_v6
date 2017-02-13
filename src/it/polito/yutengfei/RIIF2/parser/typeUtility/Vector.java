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

    public int getLeftValue(){

        Object o = this.left.getValue();

        if (o instanceof Expression)
            return (int) ((Expression) o).getValue();

        return (int) o;

    }

    public int getRightValue(){

        Object o = this.right.getValue();

        if (o instanceof Expression)
            return (int) ((Expression) o).getValue();

        return (int) o;

    }


    public int getLength(){

        if (this.right.getValue() instanceof Expression)
            return (int) ((Expression) this.right.getValue()).getValue();
        return (int) this.right.getValue();
    }


}
