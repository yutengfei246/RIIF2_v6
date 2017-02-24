package it.polito.yutengfei.RIIF2.factory.Exceptions;


public class SomeVariableMissingException extends Throwable {

    private final String id;
    private final int line;
    private final int column;

    public SomeVariableMissingException(String associativeIndex, int line, int column) {
        this.id = associativeIndex;
        this.line = line;
        this.column = column;
    }

    public void print(){
        System.err.println("<" + id + ">" + " can not be resolved in the line:column" + line + ":"+ column );
    }
}
