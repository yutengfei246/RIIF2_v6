package it.polito.yutengfei.RIIF2.initializer;


import it.polito.yutengfei.RIIF2.util.utilityWrapper.Row;

import java.util.LinkedList;

public class TableInitializer implements Initializer<Row> {
    private LinkedList<Row> initializer = new LinkedList<>();

    @Override
    public void addItem(Row item) {
        this.initializer.add(item);
    }

    @Override
    public Row getItem(int index) {
        return this.initializer.get(index);
    }

    @Override
    public LinkedList<Row> getInitializer() {
        return this.initializer;
    }

    @Override
    public int size() {
        return this.initializer.size();
    }
}
