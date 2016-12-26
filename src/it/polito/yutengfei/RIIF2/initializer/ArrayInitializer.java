package it.polito.yutengfei.RIIF2.initializer;

import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.LinkedList;

public class ArrayInitializer implements Initializer{

    private LinkedList<Expression> expressions = new LinkedList<>();

    public void addArrayItem( Expression expression){
        this.expressions.add(expression);
    }

    public LinkedList<Expression> getExpressions() {
        return expressions;
    }
}
