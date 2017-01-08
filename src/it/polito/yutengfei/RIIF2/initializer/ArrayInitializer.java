package it.polito.yutengfei.RIIF2.initializer;

import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.LinkedList;

public class ArrayInitializer implements Initializer<Expression>{

    private LinkedList<Expression> initializer = new LinkedList<>();
    private String type;

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
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type ;
    }


}
