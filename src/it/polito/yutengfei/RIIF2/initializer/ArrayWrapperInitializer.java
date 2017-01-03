package it.polito.yutengfei.RIIF2.initializer;

import java.util.LinkedList;

public class ArrayWrapperInitializer implements Initializer<ArrayInitializer>{
    private LinkedList<ArrayInitializer> initializer
            = new LinkedList<>();

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
}
