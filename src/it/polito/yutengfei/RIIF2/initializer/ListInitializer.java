package it.polito.yutengfei.RIIF2.initializer;

import java.util.LinkedList;

public class ListInitializer implements Initializer<String>{

    private LinkedList<String> initializer = new LinkedList<>();
    private int line;
    private int column;

    @Override
    public void addItem(String item) {
        this.initializer.add(item);
    }

    @Override
    public String getItem(int index) {
        return this.initializer.get(index);
    }

    @Override
    public LinkedList<String> getInitializer() {
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
