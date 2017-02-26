package it.polito.yutengfei.RIIF2.factory.Exceptions;

public class FieldTypeNotMarchException extends Throwable {

    public static final String MARCHED = "label can not be initialized";

    private static final String RESOLVED= "can not be resolved";
    public static final String OPERATION = "can not be operated in this type";
    public static final String MESSAGE = "print the message";
    public static final String NOT_FOUND = "not find";
    public static final String NOT_MARCHED = "not march";
    private final String id;
    private final int line;
    private final int column;
    private final String type;
    private final String value;

    public FieldTypeNotMarchException(String id, int line, int column) {
        this(RESOLVED,id,line,column);
    }

    public FieldTypeNotMarchException(String type, String name, int line, int column) {
        this(type,name,null,line,column);

    }

    public FieldTypeNotMarchException(String type, String name, String s, int line, int column) {
        this.type = type;
        this.id = name;
        this.line = line;
        this.value = s;
        this.column = column;

    }

    public void print(){

        switch (this.type) {
            case RESOLVED:
                System.err.println("<" + id + ">" + " can not be resolved in the line [" + line + ":" + column + "]") ;
                break;
            case MARCHED:
                System.err.println("<" + id + ">" + " can not be marched with the statement in the line:column [" + line + ":" + column + "]" );
                break;
            case OPERATION:
                System.err.println("Type " + "<" + id + ">" + " can not be operated in the statement in the line:column [" + line + ":" + column + "]" );
                break;
            case MESSAGE:
                System.err.println(this.id + " in the line:column [" + this.line + ":" +this.column + "]");
                break;

            case NOT_FOUND:
                System.err.println("<" + this.id + ">"  + " can not be resolved in the line [" + line + ":" + column + "]" );
                break;

            default: break;
        }
    }
}
