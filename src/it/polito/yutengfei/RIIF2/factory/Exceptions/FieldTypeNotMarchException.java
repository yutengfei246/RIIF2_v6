package it.polito.yutengfei.RIIF2.factory.Exceptions;

public class FieldTypeNotMarchException extends Throwable {

    public FieldTypeNotMarchException(String id, int line, int column) {
        this.id = id;
        this.line = line;
        this.column = column;
    }

    public void print(){};
}
