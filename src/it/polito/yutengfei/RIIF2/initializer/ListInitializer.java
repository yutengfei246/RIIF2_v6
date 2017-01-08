package it.polito.yutengfei.RIIF2.initializer;

import java.util.LinkedList;

public class ListInitializer implements Initializer<String>{

    private LinkedList<String> initializer = new LinkedList<>();
    private String type;

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
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type =type;
    }

    @Override
    public int size() {
        return this.initializer.size();
    }
}
