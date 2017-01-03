package it.polito.yutengfei.RIIF2.initializer;

import java.util.LinkedList;

public interface Initializer<T> {

    void addItem(T item);
    T getItem(int index);
    LinkedList<T> getInitializer();

}
