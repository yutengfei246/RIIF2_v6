package it.polito.yutengfei.RIIF2.parser.typeUtility;


import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

public class RIIF2Type {

    private final String type;
    private String value;

    private EnumType enumType;
    private Vector vector;
    private int column;
    private int line;

    /**
     * user defined type  / child_component
     * @param userDefinedType user defined name
     * @param typeName user defined type name
     * @param line line number
     * @param column column number
     */

    private RIIF2Type(String userDefinedType, String typeName, int line, int column) {
        this.value = typeName;
        this.type = userDefinedType;
        this.column = column;
        this.line = line;
    }

    /**
     * Enum type
     * @param anEnum enum type
     * @param enumType enumType instance
     */

    private RIIF2Type(String anEnum, EnumType enumType , int line, int column) {
        this.type = anEnum;
        this.enumType = enumType;
        this.line = line;
        this.column = column;
    }

    /**
     * @param typeVector vector type
     * @param vector vector instance
     */

    private RIIF2Type(String typeVector, Vector vector) {
        this.type = typeVector;
        this.vector = vector;
    }

    public RIIF2Type(String aBoolean, int line, int charPositionInLine) {
        this.type = aBoolean;
    }

    /**
     * @param line
     * @param charPositionInLine*****************************************************************************************/

    public static RIIF2Type primitiveTypeBoolean(int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.BOOLEAN, line, charPositionInLine);
    }

    public static RIIF2Type primitiveTypeFloat(int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.DOUBLE, line, charPositionInLine);
    }

    public static RIIF2Type primitiveTypeInteger(int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.INTEGER, line, charPositionInLine);
    }

    public static RIIF2Type primitiveTypeString(int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.STRING, line, charPositionInLine);
    }

    public static RIIF2Type primitiveTypeTime(int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.TIME, line, charPositionInLine);
    }

    public static RIIF2Type primitiveTypeUserDefined(String identifier, int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.USER_DEFINED, identifier,line,charPositionInLine);
    }

    public static RIIF2Type enumType(EnumType enumType, int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.ENUM, enumType, line, charPositionInLine);
    }

    public static RIIF2Type associativeType(int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.TYPE_ASSOCIATIVE, line, charPositionInLine);
    }

    public static RIIF2Type fieldTypeConstant(int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.FIELD_CONSTANT,line,charPositionInLine);
    }

    public static RIIF2Type fieldTypeParameter(int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.FIELD_PARAMETER, line, charPositionInLine);
    }

    public static RIIF2Type vectorType(Vector vector) {
        return new RIIF2Type(RIIF2Grammar.TYPE_VECTOR, vector);
    }

    public static RIIF2Type flatVectorType(Vector vector) {
        return new RIIF2Type(RIIF2Grammar.TYPE_FLAT_VECTOR, vector);
    }

    public static RIIF2Type childComponentType(String identifier, int line, int charPositionInLine) {
        return new RIIF2Type(RIIF2Grammar.TYPE_CC, identifier,line,charPositionInLine );
    }

    /*****************************************************************************************************************/
    public String getType() {
        return type;
    }

    public Vector getVector() {
        return vector;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public String getValue() {
        return value;
    }

    public EnumType getEnumType() {
        return this.enumType;
    }
}
