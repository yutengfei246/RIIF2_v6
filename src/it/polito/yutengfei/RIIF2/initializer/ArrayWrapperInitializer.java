package it.polito.yutengfei.RIIF2.initializer;

import java.util.LinkedList;

public class ArrayWrapperInitializer implements Initializer<ArrayInitializer>{
    private LinkedList<ArrayInitializer> initializer
            = new LinkedList<>();
    private int line;
    private int column;

    @Override
    public void addItem(ArrayInitializer item) {
        this.initializer.add(item);
    }

    @Override
    public ArrayInitializer getItem(int index) {
        return this.initializer.get(index);
    }

    @Override
    public LinkedList<ArrayInitializer> getInitializer() {
        return this.initializer;
    }

    @Override
    public void setLine(int line) {
        this.line = line;
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

    @Override
    public int size() {
        return this.initializer.size();
    }
}
