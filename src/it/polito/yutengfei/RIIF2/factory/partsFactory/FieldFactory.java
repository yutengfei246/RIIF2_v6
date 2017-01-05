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

/*
*   This class is responsible for creating Parameter/Constant for template or component
* */

public class FieldFactory implements Factory{

    private final RIIF2Recorder recorder ;
    private final ComponentFactory componentFactory;

    private Label fieldLabel = null;

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

        if (this.declarator instanceof PrimitiveFieldDeclarator)
            this.primitiveFieldDeclarator();
        if (this.declarator instanceof ListDeclarator)
            this.listDeclarator();
        if (this.declarator instanceof TableDeclarator)
            this.tableDeclarator();
        if (this.declarator instanceof AssociativeDeclarator)
            this.associativeDeclarator();

    }

    //Done
    private void primitiveFieldDeclarator()
            throws FieldTypeNotMarchException, InvalidFieldDeclaration, SomeVariableMissingException, VeriableAlreadyExistException {

        if ( !declaratorId.hasAttributeIndex()
                && !declaratorId.hasAssociativeIndex() ) {
            this.createFieldLabel();
            this.recorder.addLabel(this.fieldLabel);
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

    private void listDeclarator() throws VeriableAlreadyExistException, FieldTypeNotMarchException {

        String id = declaratorId.getId();
        if ( this.recorder.contains(id) )
            throw new VeriableAlreadyExistException();

        this.createFieldLabel();
        this.recorder.addLabel(this.fieldLabel);
        this.newListFieldDeclarator();
    }

    private void newListFieldDeclarator() throws FieldTypeNotMarchException {
        this.fieldLabel.setType(RIIF2Grammar.LIST_INITIALIZER);
        this.setListValue();
    }

    private void tableDeclarator()
            throws VeriableAlreadyExistException {

        String id = this.declaratorId.getId();
        if (this.recorder.contains(id))
            throw new VeriableAlreadyExistException();

        /* need to add predefined attributes*/
        this.createFieldLabel(this.fieldLabel);
        this.recorder.addLabel(this.fieldLabel);
        this.fieldLabel.setType(RIIF2Grammar.TABLE);
    }

    /*Identifier [ associativeIndex] := Initializer ? */
    private void associativeDeclarator()
            throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {

        String id = declaratorId.getId();

        if (Objects.equals(this.fieldType.getType(), RIIF2Grammar.FIELD_PARAMETER)) {
            if (!this.recorder.containsParameter(id))
                throw new SomeVariableMissingException();

            this.fieldLabel = this.recorder.getParameter(id);
        }

        if (Objects.equals(this.fieldType.getType(), RIIF2Grammar.FIELD_CONSTANT)){
            if (!this.recorder.containsConstant(id))
                throw new SomeVariableMissingException();

            this.fieldLabel = this.recorder.getConstant(id);
        }

        Id associativeId = declaratorId.getAssociativeIndex();
        String associativeIndex = associativeId.getId();

        if (!this.fieldLabel.isAssociative())
            throw new FieldTypeNotMarchException();

        if ( this.fieldLabel.containsAssociativeIndex(associativeIndex) )
            throw new VeriableAlreadyExistException();

        Label associativeLabel = this.createFieldLabel1();
        associativeLabel.setName( associativeIndex);
        associativeLabel.setType( this.fieldType.getType());

        this.fieldLabel.putAssoc(associativeIndex,associativeLabel);
        this.fieldLabel = associativeLabel;

        this.setAssociativeValue();
    }

    private void setAssociativeValue() throws FieldTypeNotMarchException {

        if (initializer == null ) {
            this.fieldLabel.setValue(null);
            return;
        }

        if ( initializer instanceof Expression){
            Expression expression = (Expression) initializer;

            if (!Objects.equals(this.fieldLabel.getType(), expression.getType()))
                throw new FieldTypeNotMarchException();

            this.fieldLabel.setValue(expression.getValue());
        }
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

                if (!Objects.equals(expType, primitiveType))
                    throw new FieldTypeNotMarchException();

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
            attribute.setId( this.declaratorId.getAttributeIndex().getId());
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

    private Label createFieldLabel1(){
        Label fieldLabel = null;

        if (Objects.equals(RIIF2Grammar.FIELD_PARAMETER, this.fieldType.getType()))
            fieldLabel = new Parameter();
        if (Objects.equals(RIIF2Grammar.FIELD_CONSTANT, this.fieldType.getType()))
            fieldLabel = new Constant();

        assert fieldLabel != null;

        return fieldLabel;
    }

    private Label createFieldLabel(Label fieldLabel) {

        if (Objects.equals(RIIF2Grammar.FIELD_PARAMETER, this.fieldType.getType()))
            fieldLabel = new Parameter();
        if (Objects.equals(RIIF2Grammar.FIELD_CONSTANT, this.fieldType.getType()))
            fieldLabel = new Constant();

        String id = declaratorId.getId();
        fieldLabel.setName(id);

        PrimitiveFieldDeclarator primitiveFieldDeclarator
                = (PrimitiveFieldDeclarator) this.declarator;
        RIIF2Type primitiveTypeS= primitiveFieldDeclarator.getPrimitiveType();
        String primitiveType = primitiveTypeS.getType();

        fieldLabel.setType( primitiveType );
        return fieldLabel;
    }

    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, InvalidFieldDeclaration, FieldTypeNotMarchException {
        this.initializer();
        this.setUpDeclarator(); // set those properties to fieldLabel
    }
}
