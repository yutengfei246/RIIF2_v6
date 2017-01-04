package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.*;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Constant;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Parameter;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
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
        this.initializer();
    }

    private void initializer() {
        this.declarator = this.componentFactory.getDeclarator();
        this.fieldType = this.componentFactory.getFieldType();
        this.declaratorId = this.declarator.getDeclaratorId();
        this.initializer = this.declarator.getInitializer();
    }

    public void commit() throws InvalidFieldDeclaration, VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {
        this.setUpDeclarator(); // set those properties to fieldLabel
        this.recorder.addLabel(this.fieldLabel);
    }

    private void setUpDeclarator() throws InvalidFieldDeclaration, VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {

        if (this.declarator instanceof  PrimitiveFieldDeclarator)
            this.primitiveFieldDeclarator();
        if (this.declarator instanceof ListDeclarator )
            this.listDeclarator();
        if (this.declarator instanceof AssociativeDeclarator)
            this.associativeDeclarator();
        if (this.declarator instanceof TableDeclarator)
            this.tableDeclarator();

    }

    //Done
    private void primitiveFieldDeclarator()
            throws FieldTypeNotMarchException, InvalidFieldDeclaration, SomeVariableMissingException, VeriableAlreadyExistException {

        if ( !declaratorId.hasAttributeIndex() && !declaratorId.hasAssociativeIndex() )
            this.createFieldLabel(this.fieldLabel);
        else{
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
        this.fieldLabel.setType( primitiveType );

        if (!this.declaratorId.hasAttributeIndex()){
            /*in this case we need to create associated typeType to the label*/
            if (this.declaratorId.hasTypeType()){
                RIIF2Type typeType = this.declaratorId.getTypeType();
                if (Objects.equals(typeType.getType(), RIIF2Grammar.TYPE_ASSOCIATIVE)) {
                    this.fieldLabel.setAssociative(true);

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
        }
    }

    /*DeclaratorId :: Identifier associativeIndex attributeIndex*/
    /*Initializer :: list expression array*/
    //Done
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
        this.fieldLabel.putAttribute(attributeIndex,attribute);
    }


    private void listDeclarator() throws VeriableAlreadyExistException, FieldTypeNotMarchException {

        String id = declaratorId.getId();
        if ( this.recorder.contains(id) )
            throw new VeriableAlreadyExistException();

        this.createFieldLabel(this.fieldLabel);
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
        this.fieldLabel.setType(RIIF2Grammar.TABLE);
    }

    /*Identifier [ associativeIndex] := Initializer ? */
    private void associativeDeclarator() throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {

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

        if ( this.fieldLabel.containsAssociativeIndex(associativeIndex) )
            throw new VeriableAlreadyExistException();

        if (!this.fieldLabel.isAssociative())
            throw new FieldTypeNotMarchException();

        Label associativeLabel = null;
        associativeLabel = this.createFieldLabel(associativeLabel);
        associativeLabel.setName( associativeIndex);
        associativeLabel.setType( this.fieldType.getType());

        this.fieldLabel.putAssoc(associativeIndex,associativeLabel);
        this.fieldLabel = associativeLabel;

        this.newAssociativeDeclarator();
    }

    private void newAssociativeDeclarator() throws FieldTypeNotMarchException {

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

    private void setVectorValue(String primitiveType, Vector vector) {
        //TODO:: set vector value
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


    private void setAssociativeIndexValue(String associativeIndexValue) {
        //TODO:: set AssociativeIndex value
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

    private Label createFieldLabel(Label fieldLabel) {

        if (Objects.equals(RIIF2Grammar.FIELD_PARAMETER, this.fieldType.getType()))
            fieldLabel = new Parameter();
        if (Objects.equals(RIIF2Grammar.FIELD_CONSTANT, this.fieldType.getType()))
            fieldLabel = new Constant();

        String id = declaratorId.getId();
        fieldLabel.setName(id);

        return fieldLabel;
    }
}
