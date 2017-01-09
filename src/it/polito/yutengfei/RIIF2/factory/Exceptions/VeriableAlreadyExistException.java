package it.polito.yutengfei.RIIF2.factory.Exceptions;

public class VeriableAlreadyExistException extends Throwable {
    private String id;
    private int line;
    private int column;
    private String platformIdentifier;

    public VeriableAlreadyExistException(String id, int line, int column) {
        this.id = id;
        this.line = line;
        this.column = column;
    }

    public VeriableAlreadyExistException(String identifier) {
        this.platformIdentifier = identifier;
    }

    public void print(){
        System.err.println("The variable <" + id + "> declaration in Line:Column "
                + this.line+":"+this.column
                + "has already declared before ");
    }
}
