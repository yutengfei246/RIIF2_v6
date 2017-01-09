package it.polito.yutengfei.RIIF2.initializer;

import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.LinkedList;

public class ArrayInitializer implements Initializer<Expression>{

    private LinkedList<Expression> initializer = new LinkedList<>();
    private int line;
    private int column;

    @Override
    public void addItem(Expression item) {
        this.initializer.add(item);
    }

    @Override
    public Expression getItem(int index) {
        return this.initializer.get(index);
    }

    @Override
    public int size() {
        return this.initializer.size();
    }

    @Override
    public LinkedList<Expression> getInitializer() {
        return this.initializer;
    }

    @Override
    public void setLine(int line) {
        this.line = line ;
    }

    @Override
    public int getLine() {
        return this.line;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

}
