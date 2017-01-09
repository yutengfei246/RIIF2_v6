package it.polito.yutengfei.RIIF2.initializer;

import java.util.LinkedList;

public interface Initializer<T> {

    void addItem(T item);
    T getItem(int index);
    int size();
    LinkedList<T> getInitializer();
    void setLine(int line);
    int getLine();
    void setColumn(int column);
    int getColumn();
}
