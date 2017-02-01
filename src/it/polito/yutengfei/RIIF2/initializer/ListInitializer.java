package it.polito.yutengfei.RIIF2.initializer;

import java.util.LinkedList;

public class ListInitializer implements Initializer<Object>{

    private LinkedList<Object> initializer = new LinkedList<>();
    private int line;
    private int column;

    @Override
    public void addItem(Object item) {
        this.initializer.add(item);
    }

    @Override
    public Object getItem(int index) {
        return this.initializer.get(index);
    }

    @Override
    public LinkedList<Object> getInitializer() {
        return this.initializer;
    }

    @Override
    public void setLine(int line) {
        this.line= line;
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
