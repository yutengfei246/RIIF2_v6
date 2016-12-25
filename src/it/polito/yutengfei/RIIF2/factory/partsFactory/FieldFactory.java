package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Constant;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Parameter;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FieldFactory implements Factory {

    private RIIF2Recorder recorder;

    private Boolean _abstract = false;

    private Label<Object> fieldLabel = null;

    private int fieldType = -1; // parameter / constant

    private String identifier = null; // id
    private int typeType = -1; // assoc or vector

    // if type type is vector
    private int vecLeft = -1;
    private int vecRight = -1;

    private boolean associative = false ; // [asssociativeIndex]
    private String associativeIndex = null;

    private boolean attribute = false; //  'attribute
    private String attributeIndex = null;

    private String type; // : float / integer / ...
    private String userDefinedType;
    private List<String> enumTypes = null;


    private int initializerType = -1; // list array expression
    private Object initializer; // := initializer

    private boolean list = false; // := {}
    private boolean table =false; // table



    public FieldFactory(RIIF2Recorder recorder) {
        this.recorder = recorder;
    }

    public void setFieldType(int fieldType) {
        this.fieldType = fieldType;
    }

    public void setAttribute(boolean b) {
        this.attribute = b;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setTypeType(int typeType) {
        this.typeType = typeType;
    }

    public void setVector(int vecLeft, int vecRight) {
        this.vecLeft = vecLeft;
        this.vecRight = vecRight;
    }

    public void setAttributeIndex(String attributeIndex) {
        this.attributeIndex = attributeIndex;
    }

    public void setAssociative(boolean associative) {
        this.associative = associative;
    }

    public void setAssociativeIndex(String identifier) {
        this.associativeIndex = identifier;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addEnumType(String entityEnum) {
        if ( this.enumTypes == null )
            this.enumTypes = new ArrayList<>();

        this.enumTypes.add(entityEnum);
    }

    public void setType(String userDefined, String identifier) {
        this.type = userDefined;
        this.userDefinedType = identifier;
    }

    public void setInitializerType(int initializerType) {
        this.initializerType = initializerType;
    }

    public void setInitializer(Object initializer) {
        this.initializer = initializer;
    }

    private Attribute createAttribute(String attributeIndex, String attributeType) {
        Attribute attribute = new Attribute();

        attribute.setId( attributeIndex );
        attribute.setType( attributeType );

        return attribute;
    }

    public void commit() throws FieldTypeNotMarchException { /*responsible for building the field in any case */
        if (this.attribute){
            if (/* id[aocId]'aId */ this.associative){

            }else if (/* id[]'aId*/ this.typeType == RIIF2Grammar.TYPE_TYPE_ASSOCIATIVE){

            }else if (/* id[3:3]'aId*/ this.typeType == RIIF2Grammar.TYPE_TYPE_VECTOR){

            }else /* id'aId*/{
            }
        }else if (/* id[aocId] */ this.associative){
            this.newAssociativeIndex();
        }else if (/* id[] */ this.typeType == RIIF2Grammar.TYPE_TYPE_ASSOCIATIVE ){
            this.newAssocField();
        }else if (/* id[2:2] */ this.typeType == RIIF2Grammar.TYPE_TYPE_VECTOR){
            this.newVectorField();
        }else /* id */ {
            this.newField();
        }

        if (/* is list */this.list){

        }

        if (/* is table */ this.table){

        }

    }

    private void newAssociativeIndex() {

    }

    private void newAssocField() {
        
    }

    private void newVectorField() {
        
    }

    private void newField() throws FieldTypeNotMarchException {
        if ( this.fieldType == RIIF2Grammar.PARAMETER ) {
            this.fieldLabel = new Parameter<>();
            this.recorder.addParameter( this.fieldLabel /* Record this parameter */);
        }

        if ( this.fieldType == RIIF2Grammar.CONSTANT ) {
            this.fieldLabel = new Constant<>();
            this.recorder.addConstant( this.fieldLabel /* Record this constant */);
        }

        this.fieldLabel.setName( this.identifier );
        this.fieldLabel.setType( this.type );
        this.fieldLabel.setAbstract( this._abstract);

        if (this.initializerType == RIIF2Grammar.EXPRESSION ){
            if ( !(Objects.equals(this.type, RIIF2Grammar.DOUBLE)
                    || Objects.equals(this.type, RIIF2Grammar.BOOLEAN)
                    || Objects.equals(this.type, RIIF2Grammar.INTEGER)
                    || Objects.equals(this.type, RIIF2Grammar.STRING) ) ) {

                throw new FieldTypeNotMarchException();
            }

            Expression expression = (Expression) this.initializer;

            if(!Objects.equals(expression.getType(), this.type))
                throw new FieldTypeNotMarchException();

            this.fieldLabel.setValue(expression.getValue());
        }

        if (this.initializerType == RIIF2Grammar.ARRAY_INITIALIZER){
            //TODO:
        }

        if (this.initializerType == RIIF2Grammar.LIST_INITIALIZER){
            //TODO:
        }
    }


    @Override
    public RIIF2Recorder getRIIF2Recorder() {
        return this.recorder;
    }
}
