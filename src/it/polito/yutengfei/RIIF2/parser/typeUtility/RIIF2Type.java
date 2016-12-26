package it.polito.yutengfei.RIIF2.parser.typeUtility;


import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

public class RIIF2Type {


    private final String type;

    private EnumType enumType;
    private Vector vector;



    private RIIF2Type(String aBoolean) {
        this.type = aBoolean;
    }

    private RIIF2Type(String anEnum, EnumType enumType) {
        this.type = anEnum;
        this.enumType = enumType;
    }

    private RIIF2Type(String typeVector, Vector vector) {
        this.type = typeVector;
        this.vector = vector;
    }

    public static RIIF2Type primitiveTypeBoolean() {
        return new RIIF2Type(RIIF2Grammar.BOOLEAN);
    }

    public static RIIF2Type primitiveTypeFloat() {
        return new RIIF2Type(RIIF2Grammar.DOUBLE);
    }

    public static RIIF2Type primitiveTypeInteger() {
        return new RIIF2Type(RIIF2Grammar.INTEGER);
    }

    public static RIIF2Type primitiveTypeString() {
        return new RIIF2Type(RIIF2Grammar.STRING);
    }

    public static RIIF2Type primitiveTypeTime() {
        return new RIIF2Type(RIIF2Grammar.TIME);
    }

    public static RIIF2Type primitiveTypeUserDefined(String identifier) {
        return new RIIF2Type(identifier);
    }

    public static RIIF2Type enumType(EnumType enumType) {
        return new RIIF2Type(RIIF2Grammar.ENUM, enumType);
    }

    public static RIIF2Type associativeType() {
        return new RIIF2Type(RIIF2Grammar.TYPE_ASSOCIATIVE);
    }

    public static RIIF2Type fieldTypeConstant() {
        return new RIIF2Type(RIIF2Grammar.FIELD_CONSTANT);
    }

    public static RIIF2Type fieldTypeParameter() {
        return new RIIF2Type(RIIF2Grammar.FIELD_PARAMETER);
    }

    public static RIIF2Type vectorType(Vector vector) {
        return new RIIF2Type(RIIF2Grammar.TYPE_VECTOR, vector);
    }

    public static RIIF2Type flatVectorType(Vector vector) {
        return new RIIF2Type(RIIF2Grammar.TYPE_FLAT_VECTOR, vector);
    }

    public String getType() {
        return type;
    }

    public Vector getVector() {
        return vector;
    }
}
