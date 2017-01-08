package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.*;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.initializer.ArrayInitializer;
import it.polito.yutengfei.RIIF2.initializer.ArrayWrapperInitializer;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.initializer.ListInitializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.List;
import java.util.Objects;

/**
*   This class is responsible for creating Parameter/Constant for template or component
* */

public class FieldFactory implements Factory{

    private final RIIF2Recorder recorder ;
    private final ComponentFactory componentFactory;

    private Label<Label> fieldLabel = null;

    private Declarator declarator;
    private DeclaratorId declaratorId;
    private Initializer initializer;
    private RIIF2Type fieldType;

    public FieldFactory(ComponentFactory componentFactory, RIIF2Recorder recorder) {
        this.componentFactory = componentFactory;
        this.recorder = recorder;
    }

    private void initializer() {
        this.declarator = this.componentFactory.getDeclarator();
        this.fieldType = this.componentFactory.getFieldType();
        this.declaratorId = this.declarator.getDeclaratorId();
        this.initializer = this.declarator.getInitializer();
    }

    private void setUpDeclarator()
            throws InvalidFieldDeclaration, VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {

        this.positionFieldLabel();

        if (this.declarator instanceof PrimitiveFieldDeclarator)
            this.primitiveFieldDeclarator();
        if (this.declarator instanceof ListDeclarator)
            this.newListFieldDeclarator();
        if (this.declarator instanceof ListDeclarator
                || this.declarator instanceof AssociativeDeclarator)
            this.inLineInitializer();
        if (this.declarator instanceof TableDeclarator)
            this.newTableDeclarator();

    }

    private void positionFieldLabel() throws VeriableAlreadyExistException, FieldTypeNotMarchException {

        String id = this.declaratorId.getId();

        if (this.declarator instanceof ListDeclarator
                || this.declarator instanceof TableDeclarator
                || ( this.declarator instanceof PrimitiveFieldDeclarator
                    &&  !this.declaratorId.hasAttributeIndex()
                    &&  !this.declaratorId.hasAssociativeIndex() )
                ){

            if (this.recorder.contains( id ) ){
                throw new VeriableAlreadyExistException(id,
                        this.declaratorId.getLine(),
                        this.declaratorId.getColumn());
            }

            this.createFieldLabel();

            this.recorder.addLabel(this.fieldLabel);
        }

        if (this.declarator instanceof AssociativeDeclarator ){

            this.fieldLabel = this.recorder.getLabel(id);

            if ( (this.fieldLabel instanceof Parameter
                    && this.fieldType.getType().equals(RIIF2Grammar.FIELD_CONSTANT))
                    || (this.fieldType.getType().equals(RIIF2Grammar.FIELD_PARAMETER)
                    && this.fieldLabel instanceof Constant)
                    || !this.fieldLabel.isAssociative() )
                throw new FieldTypeNotMarchException(id,this.declaratorId.getLine(),this.declaratorId.getColumn());


            String associativeId = this.declaratorId
                                        .getAssociativeIndex()
                                        .getId();

            Label<Label> associativeLabel
                    = this.createFieldLabel1(associativeId, this.fieldLabel.getType());

            this.fieldLabel.putAssoc(associativeId,associativeLabel);
            this.fieldLabel = associativeLabel;
        }
    }

    //Done with two attribute assign automatically
    private void primitiveFieldDeclarator()
            throws FieldTypeNotMarchException, InvalidFieldDeclaration, SomeVariableMissingException, VeriableAlreadyExistException {

        if ( !declaratorId.hasAttributeIndex()
                && !declaratorId.hasAssociativeIndex() ) {

            //add the attribute when create the field
            Attribute attributeMin = this.createAttribute(RIIF2Grammar.MIN,RIIF2Grammar.DOUBLE,null);
            Attribute attributeMax = this.createAttribute(RIIF2Grammar.MAX,RIIF2Grammar.DOUBLE,null);
            Attribute attributeUnit = this.createAttribute(RIIF2Grammar.UNIT,RIIF2Grammar.USER_DEFINED,null);

            this.fieldLabel.putAttribute(RIIF2Grammar.MAX, attributeMax);
            this.fieldLabel.putAttribute(RIIF2Grammar.MIN,attributeMin);
            this.fieldLabel.putAttribute(RIIF2Grammar.UNIT,attributeUnit);
        } else{

            /*other cases to search in recorder and add those properties into recorder*/
            String id = declaratorId.getId();

            if (Objects.equals(this.fieldType.getType(), RIIF2Grammar.FIELD_CONSTANT)
                    && !this.recorder.containsConstant(id)  )
                throw new InvalidFieldDeclaration();
            else
                this.fieldLabel = this.recorder.getConstant(id);

            if (Objects.equals(this.fieldType.getType(), RIIF2Grammar.FIELD_PARAMETER)
                    && !this.recorder.containsParameter(id) ) throw new InvalidFieldDeclaration();
            else this.fieldLabel = this.recorder.getParameter(id);
        }


        if (declaratorId.hasAssociativeIndex() && declaratorId.hasAttributeIndex())
            this.newPrimitiveFieldDeclarator2();
        else
            this.newPrimitiveFieldDeclarator1((PrimitiveFieldDeclarator) this.declarator);
    }

    /*Identifier typeType? attributeIndex? */
    //Done
    private void newPrimitiveFieldDeclarator1(PrimitiveFieldDeclarator primitiveFieldDeclarator) throws FieldTypeNotMarchException {

        RIIF2Type primitiveTypeS= primitiveFieldDeclarator.getPrimitiveType();
        String primitiveType = primitiveTypeS.getType();

        if (!this.declaratorId.hasAttributeIndex()){
            /*in this case we need to create associated typeType to the label*/
            if (this.declaratorId.hasTypeType()){
                RIIF2Type typeType = this.declaratorId.getTypeType();
                if (Objects.equals(typeType.getType(), RIIF2Grammar.TYPE_ASSOCIATIVE)) {
                    this.fieldLabel.setAssociative(true); // parameter myAssoc[] :float := ...?

                    /*set value */
                    if (this.initializer != null)
                        this.setAssociativeIndexValue(primitiveType);
                }

                if (Objects.equals(typeType.getType(), RIIF2Grammar.TYPE_VECTOR)) {
                    Vector vector = typeType.getVector();
                    this.fieldLabel.setVector(vector);

                    /*set value*/
                    if (this.initializer != null)
                        this.setVectorValue(primitiveType,vector);
                }
            }else{
                /*pure value assign*/
                /*initializer could be Expression only */
                this.setPureValue(primitiveType);
            }
        }else{
            //TODO:: has attribute
            if (this.declaratorId.hasTypeType()){

            }else{

            }
        }
    }

    /*DeclaratorId :: Identifier associativeIndex attributeIndex?*/
    /*Initializer :: list expression array*/
    private void newPrimitiveFieldDeclarator2()
            throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {


      /*retrieve the associativeIndex from the label if not exits throw an exception*/
        Id associativeIndexId = declaratorId.getAssociativeIndex();
        String associativeIndex  = associativeIndexId.getId();

        if (!this.fieldLabel.containsAssociativeIndex(associativeIndex))
            throw new SomeVariableMissingException();

        this.fieldLabel = (Label) this.fieldLabel.getAssociative(associativeIndex);


        Id attributeIndexId = declaratorId.getAttributeIndex();
        String attributeIndex = attributeIndexId.getId();

        if (this.fieldLabel.containsAttributeIndex(attributeIndex))
            throw new VeriableAlreadyExistException();

        Attribute attribute = new Attribute();
        this.initialAttribute(attribute);
        this.fieldLabel.putAttribute(attributeIndex, attribute);

    }

    private void newListFieldDeclarator() throws FieldTypeNotMarchException {
        this.fieldLabel.setType(RIIF2Grammar.LIST_INITIALIZER);
        this.setListValue();
    }


    private void newTableDeclarator() {
        /* set the pre-defined attributes Item and Header to the label */
        Attribute attribute
                = this.createAttribute(RIIF2Grammar.HEADER,RIIF2Grammar.LIST,null);
        this.fieldLabel.putAttribute(RIIF2Grammar.HEADER, attribute);

        attribute =
                this.createAttribute(RIIF2Grammar.ITEMS, RIIF2Grammar.JSON, null);
        this.fieldLabel.putAttribute(RIIF2Grammar.ITEMS, attribute);
    }

    private Attribute createAttribute(String Id , String type, String value) {
        Attribute attribute = new Attribute();
        attribute.setName(Id);
        attribute.setType(type);
        attribute.setValue(value);

        return attribute;
    }



    private void inLineInitializer() throws FieldTypeNotMarchException {

        this.fieldLabel.setValue(null);

        if (this.initializer == null)
            return;

        if ()

        if (initializer instanceof Expression){
            Expression expInitializer = (Expression) this.initializer;

            if ( !this.fieldLabel.getType().equals( expInitializer.getType() ))
                throw new FieldTypeNotMarchException(expInitializer.getValue().toString(),
                        expInitializer.getLine(),expInitializer.getColumn());

            this.fieldLabel.setValue(expInitializer.getValue());
        }

        if (initializer instanceof ListInitializer){
            ListInitializer listInitializer = (ListInitializer) initializer;

            List<String> strings = listInitializer.getInitializer();
            this.fieldLabel.setValue( strings );

        }else
            throw new FieldTypeNotMarchException();
    }

    private void setListValue() throws FieldTypeNotMarchException {

        if (initializer instanceof ListInitializer){
            ListInitializer listInitializer
                    = (ListInitializer) initializer;

            List<String> strings = listInitializer.getInitializer();
            this.fieldLabel.setValue( strings );

        }else
            throw new FieldTypeNotMarchException();
    }


    private void setVectorValue(String primitiveType, Vector vector)
            throws FieldTypeNotMarchException {

        if (initializer instanceof ArrayInitializer){
            ArrayInitializer arrayInitializer
                    = (ArrayInitializer) this.initializer;

            if (arrayInitializer.size() > this.fieldLabel.getVectorLength())
                throw new FieldTypeNotMarchException();

            arrayInitializer.getInitializer()
                    .forEach(expression -> {
                        if (!Objects.equals(expression.getType(), primitiveType))
                            throw new IllegalArgumentException();

                        Label vectorItem = null ;
                        if (this.fieldLabel instanceof Parameter)
                            vectorItem = new Parameter();
                        if (this.fieldLabel instanceof Constant)
                            vectorItem = new Constant();

                        assert vectorItem != null;
                        vectorItem.setName(null);
                        vectorItem.setValue(expression.getValue());
                        this.fieldLabel.addVectorItem(vectorItem);
                    });


        }else if (initializer instanceof ArrayWrapperInitializer){
            ArrayWrapperInitializer arrayWrapperInitializer
                    = (ArrayWrapperInitializer) this.initializer;

            int vectorLeft = this.fieldLabel.getVectorLeft();
            int vectorRight = this.fieldLabel.getVectorRight();

            if (arrayWrapperInitializer.size() != vectorRight)
                throw new FieldTypeNotMarchException();

            arrayWrapperInitializer.getInitializer()
                    .forEach(arrayInitializer -> {
                        if (arrayInitializer.size() != vectorLeft)
                            throw new IllegalArgumentException();

                        arrayInitializer.getInitializer()
                                .forEach(expression -> {
                                    if (!Objects.equals(expression.getType(), primitiveType))
                                        throw new IllegalArgumentException();

                                    Label vectorItem = null ;
                                    if (this.fieldLabel instanceof Parameter)
                                        vectorItem = new Parameter();
                                    if (this.fieldLabel instanceof Constant)
                                        vectorItem = new Constant();

                                    assert vectorItem != null;
                                    vectorItem.setName(null);
                                    vectorItem.setValue(expression.getValue());
                                    this.fieldLabel.addVectorItem(vectorItem);
                                });
                    });

        }else
            throw new FieldTypeNotMarchException();
    }

    private void setPureValue(String primitiveType) throws FieldTypeNotMarchException {

        if (this.initializer != null){

            if (this.initializer instanceof  Expression){
                Expression expInitializer = (Expression) this.initializer;
                String expType = expInitializer.getType();

                if (!Objects.equals(expType, RIIF2Grammar.USER_DEFINED)
                        && !Objects.equals(expType, primitiveType)) {

                    System.err.println( "Line " + expInitializer.getLine() + " Column " + expInitializer.getColumn() + " cannot recognized" );
                    throw new FieldTypeNotMarchException();
                }

                this.fieldLabel.setValue(expInitializer.getValue());
            }
        }

    }

    private void setAssociativeIndexValue(String primitiveType)
            throws FieldTypeNotMarchException {

        if (this.initializer instanceof ArrayInitializer){
            ArrayInitializer arrayInitializer
                    = (ArrayInitializer) this.initializer;

            arrayInitializer.getInitializer()
                    .forEach(expression -> {
                        Label associativeLabel = null;
                        if (this.fieldLabel instanceof Parameter)
                            associativeLabel = new Parameter();
                        if (this.fieldLabel instanceof Constant)
                            associativeLabel = new Constant();

                        associativeLabel.setType(primitiveType);
                        associativeLabel.setName( expression.getValue().toString() );
                        this.fieldLabel.putAssoc(expression.getValue().toString(),associativeLabel);
                    });
        }else
            throw new FieldTypeNotMarchException();
    }

    private void initialAttribute(Attribute attribute) throws FieldTypeNotMarchException {
        PrimitiveFieldDeclarator primitiveFieldDeclarator
                = (PrimitiveFieldDeclarator) this.declarator;
        RIIF2Type primitiveType = primitiveFieldDeclarator.getPrimitiveType();

        if (this.initializer instanceof  Expression){
            Expression expInitializer = (Expression) this.initializer;
            if (!Objects.equals(primitiveType.getType(), expInitializer.getType()))
                throw new FieldTypeNotMarchException();

            attribute.setType( expInitializer.getType());
            attribute.setValue(expInitializer.getValue());
            attribute.setName( this.declaratorId.getAttributeIndex().getId());
        }
    }

    private void createFieldLabel(){
        if (Objects.equals(RIIF2Grammar.FIELD_PARAMETER, this.fieldType.getType()))
            this.fieldLabel = new Parameter();
        if (Objects.equals(RIIF2Grammar.FIELD_CONSTANT, this.fieldType.getType()))
            fieldLabel = new Constant();

        String id = declaratorId.getId();
        fieldLabel.setName(id);

        if (this.declarator instanceof PrimitiveFieldDeclarator) {
            PrimitiveFieldDeclarator primitiveFieldDeclarator
                    = (PrimitiveFieldDeclarator) this.declarator;
            RIIF2Type primitiveTypeS = primitiveFieldDeclarator.getPrimitiveType();
            String primitiveType = primitiveTypeS.getType();

            fieldLabel.setType(primitiveType);
        }

        if (this.declarator instanceof  ListDeclarator) {
            fieldLabel.setType(RIIF2Grammar.LIST);
        }

        if (this.declarator instanceof TableDeclarator){
            fieldLabel.setType(RIIF2Grammar.TABLE);
        }
    }

    private Label<Label> createFieldLabel1(String associativeName, String type){
        Label<Label> fieldLabel = null;

        if (Objects.equals(RIIF2Grammar.FIELD_PARAMETER, this.fieldType.getType()))
            fieldLabel = new Parameter();
        if (Objects.equals(RIIF2Grammar.FIELD_CONSTANT, this.fieldType.getType()))
            fieldLabel = new Constant();

        assert fieldLabel != null;
        fieldLabel.setName(associativeName);
        fieldLabel.setType(type);

        return fieldLabel;
    }


    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, InvalidFieldDeclaration, FieldTypeNotMarchException {
        this.initializer();
        this.setUpDeclarator(); // set those properties to fieldLabel
    }
}
