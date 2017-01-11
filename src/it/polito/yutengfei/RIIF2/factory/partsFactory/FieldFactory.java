package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.*;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.SomeVariableMissingException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.VeriableAlreadyExistException;
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
import it.polito.yutengfei.RIIF2.util.utilityWrapper.ExpressionOperator;

import java.util.List;
import java.util.Objects;

public class FieldFactory implements Factory{

    private final RIIF2Recorder recorder ;
    private final ComponentFactory componentFactory;

    private Label<Label> fieldLabel = null;

    private Declarator declarator;
    private DeclaratorId declaratorId;
    private Initializer initializer;
    private RIIF2Type fieldType;

    private ExpressionOperator eo;

    public FieldFactory(ComponentFactory componentFactory, RIIF2Recorder recorder) {
        this.componentFactory = componentFactory;
        this.recorder = recorder;
    }

    private void initializer() {
        this.declarator = this.componentFactory.getDeclarator();
        this.fieldType = this.componentFactory.getFieldType();
        this.declaratorId = this.declarator.getDeclaratorId();
        this.initializer = this.declarator.getInitializer();

        this.eo = new ExpressionOperator(this.recorder);
    }

    private void setUpDeclarator()
            throws VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {

        this.positionFieldLabel();
        this.inLineInitializer();
    }

    private void positionFieldLabel()
            throws VeriableAlreadyExistException, FieldTypeNotMarchException, SomeVariableMissingException {

        String id = this.declaratorId.getId();

        if (this.declarator instanceof ListDeclarator
                || this.declarator instanceof TableDeclarator){

            if (this.recorder.contains( id ) ){
                throw new VeriableAlreadyExistException(id,
                        this.declaratorId.getLine(),
                        this.declaratorId.getColumn());
            }

            this.createFieldLabel(id);

        } else if (this.declarator instanceof AssociativeDeclarator ){

            this.fieldLabel = this.recorder.getLabel(id);

            if ( this.fieldLabel == null
                    || !this.fieldLabel.isAssociative()
                    || (this.fieldLabel instanceof Parameter
                        && this.fieldType.getType().equals(RIIF2Grammar.FIELD_CONSTANT) )
                    || (this.fieldType.getType().equals(RIIF2Grammar.FIELD_PARAMETER)
                        && this.fieldLabel instanceof Constant) )
                throw new FieldTypeNotMarchException(id,this.declaratorId.getLine(),this.declaratorId.getColumn());

            String associativeId = this.declaratorId
                    .getAssociativeIndex()
                    .getId();

            Label<Label> associativeLabel
                    = this.createFieldLabel1(associativeId, this.fieldLabel.getType());

            this.fieldLabel.putAssoc(associativeId,associativeLabel);
            this.fieldLabel = associativeLabel;

        } else if (this.declarator instanceof PrimitiveFieldDeclarator ) {

            if ( !this.declaratorId.hasAttributeIndex()
                    && !this.declaratorId.hasAssociativeIndex() ) {

                if (this.recorder.contains( id ) ){
                    throw new VeriableAlreadyExistException(id,
                            this.declaratorId.getLine(),
                            this.declaratorId.getColumn());
                }

                this.createFieldLabel(id);

            }else {
                this.fieldLabel = this.recorder.getLabel(id);

                if (this.fieldLabel == null
                        || (this.fieldType.getType().equals(RIIF2Grammar.FIELD_PARAMETER)
                        && !(this.fieldLabel instanceof Parameter))
                        || (this.fieldType.getType().equals(RIIF2Grammar.FIELD_CONSTANT)
                        && !(this.fieldLabel instanceof Constant))
                        )
                    throw new FieldTypeNotMarchException(this.declaratorId.getId(),
                            this.declaratorId.getLine(), this.declaratorId.getColumn());
            }

            if (declaratorId.hasAssociativeIndex() && declaratorId.hasAttributeIndex())
                this.positionFieldLabelForPrimitiveFieldDeclarator2();
            else
                this.positionFieldLabelForPrimitiveFieldDeclarator1();
        }
    }

    private void positionFieldLabelForPrimitiveFieldDeclarator1() {

        if (this.declaratorId.hasAttributeIndex()){
            PrimitiveFieldDeclarator primitiveFieldDeclarator
                    = (PrimitiveFieldDeclarator) this.declarator;
            String primitiveType = primitiveFieldDeclarator.getPrimitiveType().getType();

            Attribute attribute = PreDefinedAttribute.createAttribute(this.declaratorId.getAttributeIndex().getId(),
                    primitiveType, null);

            this.fieldLabel.putAttribute(this.declaratorId.getAttributeIndex().getId(),
                    attribute);
            this.fieldLabel = attribute;
        }
    }

    private void positionFieldLabelForPrimitiveFieldDeclarator2() throws SomeVariableMissingException {

        String associativeIndex
                = this.declaratorId.getAssociativeIndex().getId();

        if (!this.fieldLabel.containsAssociativeIndex(associativeIndex))
            throw new SomeVariableMissingException(associativeIndex,
                    this.declaratorId.getAssociativeIndex().getLine(),
                    this.declaratorId.getAssociativeIndex().getColumn());

        this.fieldLabel
                =(Label<Label>) this.fieldLabel.getAssociative(associativeIndex);


        PrimitiveFieldDeclarator primitiveFieldDeclarator
                = (PrimitiveFieldDeclarator) this.declarator;

        String primitiveType
                = primitiveFieldDeclarator.getPrimitiveType().getType();
        String attributeIndex
                = this.declaratorId.getAttributeIndex().getId();

        Attribute attribute = PreDefinedAttribute.createAttribute( attributeIndex,
                primitiveType, null);
        this.fieldLabel.putAttribute(attributeIndex, attribute);
        this.fieldLabel = attribute;
    }


    private void inLineInitializer() throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (this.initializer == null)
            return;

        if (initializer instanceof Expression) {
            Expression expInitializer = (Expression) this.initializer;
            expInitializer.setExpressionOperator(eo);

            if (this.fieldLabel.getName().equals(RIIF2Grammar.UNIT)) {

                if  (! (expInitializer.value() instanceof DeclaratorId ) )
                    throw new FieldTypeNotMarchException(expInitializer.value().toString(),
                            expInitializer.getLine(), expInitializer.getColumn());

                String type = ((DeclaratorId) expInitializer.value()).getPrimitiveId().getId();

                this.fieldLabel.setValue(type);

            }else if (expInitializer.getType().equals(this.fieldLabel.getType())){
                this.fieldLabel.setValue(expInitializer.getValue());
            }else {
                throw new FieldTypeNotMarchException(expInitializer.getValue().toString(),
                        expInitializer.getLine(), expInitializer.getColumn());
            }

        } else if (initializer instanceof ListInitializer){
            ListInitializer listInitializer = (ListInitializer) initializer;

            if ( !this.fieldLabel.getType().equals(RIIF2Grammar.LIST) )
                throw new FieldTypeNotMarchException(RIIF2Grammar.LIST,
                        listInitializer.getLine(), listInitializer.getColumn());

            List<String> listListInitializer= listInitializer.getInitializer();
            this.fieldLabel.setValue( listListInitializer );
        } else {


            if (!this.fieldLabel.isVector() && !this.fieldLabel.isAssociative())
                throw new FieldTypeNotMarchException(RIIF2Grammar.ARRAY,
                        this.initializer.getLine(),
                        this.initializer.getColumn());

            // Label should have the vector
            if (initializer instanceof ArrayInitializer) {
                ArrayInitializer arrayInitializer
                        = (ArrayInitializer) this.initializer;

                if (arrayInitializer.size() != this.fieldLabel.getVectorLength())
                    throw new FieldTypeNotMarchException(RIIF2Grammar.ARRAY,
                            this.initializer.getLine(),
                            this.initializer.getColumn());

                final int[] i = {0};
                arrayInitializer.getInitializer()
                        .forEach(expression -> {
                            expression.setExpressionOperator(this.eo);

                            if (!Objects.equals(expression.getType(), this.fieldLabel.getType()))
                                throw new IllegalArgumentException();

                            if (this.fieldLabel.isAssociative()) {
                                Label usedLabel = null;
                                if (this.fieldLabel instanceof Parameter)
                                    usedLabel = new Parameter();
                                if (this.fieldLabel instanceof Constant)
                                    usedLabel = new Constant();

                                assert usedLabel != null;

                                usedLabel.setType(this.fieldType.getType());
                                usedLabel.setName(expression.getValue().toString());
                                this.fieldLabel.putAssoc(expression.getValue().toString(), usedLabel);
                            }

                            if (this.fieldLabel.isVector()) {
                                Label usedLabel = this.fieldLabel.getVector(i[0]);
                                i[0]++;

                                usedLabel.setValue(expression.getValue());
                                usedLabel.setType(expression.getType());
                            }

                        });
            }

            if (this.initializer instanceof ArrayWrapperInitializer) {
                ArrayWrapperInitializer arrayWrapperInitializer
                        = (ArrayWrapperInitializer) this.initializer;

                int vectorLeft = this.fieldLabel.getVectorLeft();
                int vectorRight = this.fieldLabel.getVectorRight();

                if (arrayWrapperInitializer.size() != vectorRight)
                    throw new FieldTypeNotMarchException(RIIF2Grammar.ARRAY,
                            arrayWrapperInitializer.getLine(),
                            arrayWrapperInitializer.getColumn());

                arrayWrapperInitializer.getInitializer()
                        .forEach(arrayInitializer -> {

                            if (arrayInitializer.size() != vectorLeft)
                                throw new IllegalArgumentException();

                            arrayInitializer.getInitializer()
                                    .forEach(expression -> {
                                        if (!Objects.equals(expression.getType(), this.fieldLabel.getType()))
                                            throw new IllegalArgumentException();

                                        Label vectorItem = null;
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
            }
        }

    }

    private void createFieldLabel(String name){

        if (this.fieldType.getType().equals(RIIF2Grammar.FIELD_PARAMETER) )
            this.fieldLabel = new Parameter();
        if (this.fieldType.getType().equals(RIIF2Grammar.FIELD_CONSTANT) )
            fieldLabel = new Constant();

        assert this.fieldLabel != null;
        this.fieldLabel.setName(name);

        if (this.declarator instanceof PrimitiveFieldDeclarator) {

            PrimitiveFieldDeclarator primitiveFieldDeclarator
                    = (PrimitiveFieldDeclarator) this.declarator;

            String primitiveType
                    = primitiveFieldDeclarator.getPrimitiveType().getType();
            this.fieldLabel.setType(primitiveType);

            if ( !this.declaratorId.hasAttributeIndex()
                    && !this.declaratorId.hasAssociativeIndex()){

                PreDefinedAttribute.FieldAttribute(this.fieldLabel);
            }

            if (this.declaratorId.hasTypeType()) {
                RIIF2Type TypeType = this.declaratorId.getTypeType();
                String typeType = TypeType.getType();

                if (typeType.equals(RIIF2Grammar.TYPE_ASSOCIATIVE))
                    this.fieldLabel.setAssociative(true);

                if (typeType.equals(RIIF2Grammar.TYPE_VECTOR)) {
                    Vector vector = TypeType.getVector();
                    this.fieldLabel.setVector(vector,this.recorder);
                }
            }
        }

        if (this.declarator instanceof  ListDeclarator) {
            this.fieldLabel.setType(RIIF2Grammar.LIST);
            PreDefinedAttribute.ListAttribute(this.fieldLabel);
        }

        if (this.declarator instanceof TableDeclarator){

            this.fieldLabel.setType(RIIF2Grammar.TABLE);
            PreDefinedAttribute.TableAttribute(this.fieldLabel);
        }

        this.recorder.addLabel( this.fieldLabel);
    }

    private Label<Label> createFieldLabel1(String name, String type){
        Label<Label> fieldLabel = null;

        if (Objects.equals(RIIF2Grammar.FIELD_PARAMETER, this.fieldType.getType()))
            fieldLabel = new Parameter();
        if (Objects.equals(RIIF2Grammar.FIELD_CONSTANT, this.fieldType.getType()))
            fieldLabel = new Constant();

        assert fieldLabel != null;

        fieldLabel.setName(name);
        fieldLabel.setType(type);

        return fieldLabel;
    }


    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {
        this.initializer();
        this.setUpDeclarator(); // set those properties to fieldLabel
    }
}
