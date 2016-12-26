package it.polito.yutengfei.RIIF2.initializer;

import java.util.LinkedList;

public class ListInitializer implements Initializer{

    private LinkedList<String> initializer = new LinkedList<>();

    public void addItem(String item){
        this.initializer.add(item);
    }

}
