package it.polito.yutengfei.RIIF2.factory.partsFactory;

public class VeriableAlreadyExistException extends Throwable {
    private final String id;
    private final int line;
    private final int column;

    VeriableAlreadyExistException(String id, int line, int column) {
        this.id = id;
        this.line = line;
        this.column = column;
    }

    public void print(){
        System.err.println("The variable <" + id + "> declaration in Line:Column "
                + this.line+":"+this.column
                + "has already declared before ");
    }
}
