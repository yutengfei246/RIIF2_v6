package it.polito.yutengfei.RIIF2.factory.Exceptions;

public class FieldTypeNotMarchException extends Throwable {

    private final String id;
    private final int line;
    private final int column;

    public FieldTypeNotMarchException(String id, int line, int column) {
        this.id = id;
        this.line = line;
        this.column = column;
    }

    public void print(){
        System.err.println("<" + id + ">" + "can not be marched in the line:column" + line+":"+column);
    }

}
