package it.polito.yutengfei.RIIF2.initializer;

import java.util.LinkedList;

public class ArrayWrapperInitializer implements Initializer{
    private LinkedList<ArrayInitializer> arrayInitializers
            = new LinkedList<>();

    public void addArrayInitializerItem(ArrayInitializer arrayListInitializer) {
        this.arrayInitializers.add(arrayListInitializer);
    }

    public LinkedList<ArrayInitializer> getArrayInitializers() {
        return arrayInitializers;
    }
}
