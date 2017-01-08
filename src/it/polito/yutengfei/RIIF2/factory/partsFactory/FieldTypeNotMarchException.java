package it.polito.yutengfei.RIIF2.factory.partsFactory;

public class FieldTypeNotMarchException extends Throwable {

    FieldTypeNotMarchException(String id, int line, int column) {
        this.id = id;
        this.line = line;
        this.column = column;
    }

    public void print(){};
}
