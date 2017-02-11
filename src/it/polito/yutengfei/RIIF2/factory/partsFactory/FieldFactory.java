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
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.initializer.ListInitializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.Objects;

public class FieldFactory implements Factory{

    private final RIIF2Recorder recorder ;
    private final ComponentFactory componentFactory;

    private Label<Label> fieldLabel = null;

    private Declarator declarator;
    private DeclaratorId declaratorId;
    private Initializer initializer;
    private RIIF2Type fieldType;

//    private ExpressionOperator eo;

    public FieldFactory(ComponentFactory componentFactory, RIIF2Recorder recorder) {
        this.componentFactory = componentFactory;
        this.recorder = recorder;
    }

    private void initializer() {
        this.declarator = this.componentFactory.getDeclarator();
        this.fieldType = this.componentFactory.getFieldType();
        this.declaratorId = this.declarator.getDeclaratorId();
        this.initializer = this.declarator.getInitializer();

 //       this.eo = new ExpressionOperator(this.recorder);
    }

    private void setUpDeclarator()
            throws VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {

        this.positionFieldLabel();
        this.inLineInitializer();
    }

    private void positionFieldLabel()
            throws VeriableAlreadyExistException, FieldTypeNotMarchException, SomeVariableMissingException {

        String id = this.declaratorId.getId();

        // if the declarator is a listDeclarator and TableDeclarator, we create a new
        // label
        if (this.declarator instanceof ListDeclarator
                || this.declarator instanceof TableDeclarator){

            // check if the current recorder contains the same label name
            // because in this language, we do not allowed people declare parameter with same name
            if (this.recorder.contains( id ) ){
                throw new VeriableAlreadyExistException(id,
                        this.declaratorId.getLine(),
                        this.declaratorId.getColumn());
            }

            // create the field label
            this.createFieldLabel(id);

        } else if (this.declarator instanceof AssociativeDeclarator ){

            // first get the label from the recorder, pay attention only the label inside the same recorder
            this.fieldLabel = this.recorder.getLabel(id);

            if ( this.fieldLabel == null
                    || !this.fieldLabel.isAssociative()
                    || (this.fieldLabel instanceof Parameter
                        && this.fieldType.getType().equals(RIIF2Grammar.FIELD_CONSTANT) )
                    || (this.fieldType.getType().equals(RIIF2Grammar.FIELD_PARAMETER)
                        && this.fieldLabel instanceof Constant) )
                throw new FieldTypeNotMarchException(id,this.declaratorId.getLine(),this.declaratorId.getColumn());

            String associativeId = this.declaratorId.getAssociativeIndex().getId();

            // if it is a associativeLabel we need to create a need associative label for the associative Index using createFieldLabel1 method
            Label<Label> associativeLabel = this.createFieldLabel1(associativeId, this.fieldLabel.getType());

            // and add the label to the associativeLabel and replacement of the fieldLabel with the created one.
            this.fieldLabel.putAssociative(associativeId,associativeLabel);
            this.fieldLabel = associativeLabel;

            // if it is a Primitive Field Declarator, we create the label using the method createFieldLabel(String id), the method will handle everything
        } else if (this.declarator instanceof PrimitiveFieldDeclarator ) {

            // only when there is no any attributes and associativeIndex, the new Label can be created from scratch
            if ( !this.declaratorId.hasAttributeIndex()
                    && !this.declaratorId.hasAssociativeIndex() ) {

                if (this.recorder.contains( id ) ){
                    throw new VeriableAlreadyExistException(id,
                            this.declaratorId.getLine(),
                            this.declaratorId.getColumn());
                }

                this.createFieldLabel(id);

            }else {
                // otherwise, I get have the label reference from the RIIF2Recorder directly
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


    private void positionFieldLabelForPrimitiveFieldDeclarator1() throws FieldTypeNotMarchException {
        // if it has an attributeIndex, create an attribute and replace it
        if (this.declaratorId.hasAttributeIndex()){
            PrimitiveFieldDeclarator primitiveFieldDeclarator
                    = (PrimitiveFieldDeclarator) this.declarator;
            String primitiveType = primitiveFieldDeclarator.getPrimitiveType().getType();

            Attribute attribute = PreDefinedAttribute.createAttribute(this.declaratorId.getAttributeIndex().getId(),
                    primitiveType, null,this.recorder);

            this.fieldLabel.putAttribute(this.declaratorId.getAttributeIndex().getId(),
                    attribute);
            this.fieldLabel = attribute;
        }
    }


    // declaration of an attribute of an associativeIndex. Getting the associativeIndex label form RIIF2Recorder
    // and create an Attribute label and put the attribute label into hte AssociativeIndex
    private void positionFieldLabelForPrimitiveFieldDeclarator2() throws SomeVariableMissingException, FieldTypeNotMarchException {

        String associativeIndex = this.declaratorId.getAssociativeIndex().getId();

        if (!this.fieldLabel.containsAssociative(associativeIndex))
            throw new SomeVariableMissingException(associativeIndex,
                    this.declaratorId.getAssociativeIndex().getLine(),
                    this.declaratorId.getAssociativeIndex().getColumn());

        this.fieldLabel
                = this.fieldLabel.getAssociative(associativeIndex);


        PrimitiveFieldDeclarator primitiveFieldDeclarator
                = (PrimitiveFieldDeclarator) this.declarator;

        String primitiveType
                = primitiveFieldDeclarator.getPrimitiveType().getType();
        String attributeIndex
                = this.declaratorId.getAttributeIndex().getId();

        Attribute attribute = PreDefinedAttribute.createAttribute( attributeIndex,
                primitiveType, null,this.recorder);
        this.fieldLabel.putAttribute(attributeIndex, attribute);
        this.fieldLabel = attribute;
    }


    // method for in-line initializer.
    private void inLineInitializer() throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (this.initializer == null)
            return;

        // if the initializer is an expression type
        if (this.initializer instanceof Expression) {
            Expression expInitializer = (Expression) this.initializer;
            expInitializer.setRecorder(this.recorder);
            expInitializer.setCurrentLabel(this.fieldLabel);

            // the expression Initialize is user-defined type
            if (expInitializer.getType().equals(RIIF2Grammar.USER_DEFINED)) {

                Id primitiveId = ((DeclaratorId)expInitializer.value()).getPrimitiveId();

                if (this.fieldLabel.isEnumType() && this.fieldLabel.getEnumType().contains(primitiveId.getId())) {
                    this.fieldLabel.setValue(primitiveId.getId());
                }

                else if (this.fieldLabel.getName().equals(RIIF2Grammar.UNIT)) {
                    this.fieldLabel.setValue(primitiveId.getId());
                }
            }

            // third. other case We could set the expression into the fieldLabel
            else if (expInitializer.getType().equals(this.fieldLabel.getType())){
                this.fieldLabel.setValue(expInitializer);
            }

            else throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MARCHED, this.fieldLabel.getName(), expInitializer.getLine(), expInitializer.getColumn());

        }

        // if initializer is actually a ListInitializer
        else if (initializer instanceof ListInitializer){
            ListInitializer listInitializer = (ListInitializer) initializer;
            this.fieldLabel.setValue( listInitializer );


        } else if (initializer instanceof  ArrayInitializer){
            // if in the next cases, it should be array or associative TypeType
            if (!this.fieldLabel.isVector() && !this.fieldLabel.isAssociative())
                throw new FieldTypeNotMarchException(RIIF2Grammar.ARRAY,
                        this.initializer.getLine(),
                        this.initializer.getColumn());

            // if it is an ArrayInitializer
            // Label should have the vector
                ArrayInitializer arrayInitializer
                        = (ArrayInitializer) this.initializer;

                //arrayInitializer is a list of Expression.........
                arrayInitializer.getInitializer().forEach( expression -> {

                            if (!Objects.equals(expression.getType(), this.fieldLabel.getType()))
                                throw new IllegalArgumentException();

                            if (this.fieldLabel.isAssociative()) {
                                Label usedLabel = null;
                                if (this.fieldLabel instanceof Parameter)
                                    usedLabel = new Parameter(this.recorder);
                                if (this.fieldLabel instanceof Constant)
                                    usedLabel = new Constant(this.recorder);

                                assert usedLabel != null;

                                // read the associative Name from each one.
                                DeclaratorId declaratorId = (DeclaratorId) expression.value();
                                String associativeName = declaratorId.getPrimitiveId().getId();

                                // set the instance of associative with same type of the associative-label
                                usedLabel.setType(this.fieldType.getType());
                                usedLabel.setName(associativeName);
                                this.fieldLabel.putAssociative(associativeName,usedLabel);
                            }

                            if (this.fieldLabel.isVector()) {
                                this.fieldLabel.addVectorItem(expression);
                            }

                        });
            }

    }

    // create a label with the name given
    private void createFieldLabel(String name) throws FieldTypeNotMarchException {

        // have a decision of the fieldType of the label.
        if (this.fieldType.getType().equals(RIIF2Grammar.FIELD_PARAMETER) )
            this.fieldLabel = new Parameter(this.recorder);
        if (this.fieldType.getType().equals(RIIF2Grammar.FIELD_CONSTANT) )
            fieldLabel = new Constant(this.recorder);

        assert this.fieldLabel != null;
        this.fieldLabel.setName(name); // set the name to the field
        //PreDefinedAttribute.FieldAttribute(this.fieldLabel,this.recorder);


        // have a decision of the primitiveType (float, integer,String or anything else )
        if (this.declarator instanceof PrimitiveFieldDeclarator) {

            PrimitiveFieldDeclarator primitiveFieldDeclarator
                    = (PrimitiveFieldDeclarator) this.declarator;

            String primitiveType
                    = primitiveFieldDeclarator.getPrimitiveType().getType();

            if (this.initializer instanceof ListInitializer){
                switch (primitiveType){
                    case RIIF2Grammar.STRING:
                        this.fieldLabel.setType(RIIF2Grammar.LIST_STRING);
                        break;
                    case RIIF2Grammar.INTEGER:
                        this.fieldLabel.setType(RIIF2Grammar.LIST_INTEGER);
                        break;
                    case RIIF2Grammar.DOUBLE:
                        this.fieldLabel.setType(RIIF2Grammar.LIST_DOUBLE);
                        break;
                    default:
                        this.fieldLabel.setType(RIIF2Grammar.LIST);
                        break;
                }

            }
            // The user defined type
            else if ( primitiveType.equals(RIIF2Grammar.USER_DEFINED)) {
                String userDefinedTypeName = primitiveFieldDeclarator.getPrimitiveType().getValue();
                this.fieldLabel.setType(userDefinedTypeName);
            }
            // the primitive type
            else  this.fieldLabel.setType(primitiveType);


            // Since enum type is a special one. So we need to decide if the current type is enum
            if (primitiveType.equals(RIIF2Grammar.ENUM)){
                this.fieldLabel.setEnumType(primitiveFieldDeclarator.getPrimitiveType().getEnumType());
            }

            // if the current declarator is not an attribute , we would have the pre-declare attribute .
            if ( !this.declaratorId.hasAttributeIndex()
                    && !this.declaratorId.hasAssociativeIndex()){

                this.fieldLabel.setAttribute(true);
                PreDefinedAttribute.FieldAttribute(this.fieldLabel,this.recorder);
            }

            // in this case we could decide if typeType is a vector or it is a associative One.
            if (this.declaratorId.hasTypeType()) {
                RIIF2Type TypeType = this.declaratorId.getTypeType();
                String typeType = TypeType.getType();

                if (typeType.equals(RIIF2Grammar.TYPE_ASSOCIATIVE))
                    this.fieldLabel.setAssociative(true);

                // if it is a vector, the left item has to be one
                if (typeType.equals(RIIF2Grammar.TYPE_VECTOR)) {
                    Vector vector = TypeType.getVector();

                    Expression left = vector.getLeft();
                    Expression right = vector.getRight();


                    left.setCurrentLabel(this.fieldLabel);
                    left.setRecorder(this.recorder);
                    if (!left.isInteger())
                        throw new FieldTypeNotMarchException(left.toString(), left.getLine(), left.getColumn());

                    right.setCurrentLabel(this.fieldLabel);
                    right.setRecorder(this.recorder);
                    if (!right.isInteger())
                        throw new FieldTypeNotMarchException(right.toString(), right.getLine(), right.getColumn());


                    this.fieldLabel.setVector(true);
                    this.fieldLabel.setVectorLength(vector.getLength());
                }
            }
        }

        if (this.declarator instanceof  ListDeclarator) {
            this.fieldLabel.setType(RIIF2Grammar.LIST);
            this.fieldLabel.setAttribute(true);
            PreDefinedAttribute.ListAttribute(this.fieldLabel);
        }

        if (this.declarator instanceof TableDeclarator){

            this.fieldLabel.setType(RIIF2Grammar.TABLE);
            this.fieldLabel.setAttribute(true);
            PreDefinedAttribute.TableAttribute(this.fieldLabel,this.recorder);
        }

        // int the end, we have to add the label into the recorder
        this.recorder.addLabel( this.fieldLabel);
    }

    // create a field label with given name and type and return it back
    private Label<Label> createFieldLabel1(String name, String type) throws FieldTypeNotMarchException {
        Label<Label> fieldLabel = null;

        if (Objects.equals(RIIF2Grammar.FIELD_PARAMETER, this.fieldType.getType()))
            fieldLabel = new Parameter(this.recorder);
        if (Objects.equals(RIIF2Grammar.FIELD_CONSTANT, this.fieldType.getType()))
            fieldLabel = new Constant(this.recorder);

        assert fieldLabel != null;

        PreDefinedAttribute.FieldAttribute(fieldLabel,this.recorder);
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
