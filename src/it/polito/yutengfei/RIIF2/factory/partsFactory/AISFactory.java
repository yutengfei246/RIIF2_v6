package it.polito.yutengfei.RIIF2.factory.partsFactory;


import it.polito.yutengfei.RIIF2.Declarator.AisDeclarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.SomeVariableMissingException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.VeriableAlreadyExistException;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.initializer.*;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Repository;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class AISFactory implements Factory{

    private final String AISType;
    private final ComponentFactory componentFactory;
    private final RIIF2Recorder recorder;

    private DeclaratorId declaratorId;
    private Initializer initializer;

    private Id primitiveId;

    private Label<Label> aisLabel ;

    private List<Label> listLabel = new LinkedList<>();

    public AISFactory(ComponentFactory componentFactory, String assignment, RIIF2Recorder recorder) {
        this.componentFactory = componentFactory;
        this.recorder = recorder;
        this.AISType = assignment;
    }

    private void initializer() {
        AisDeclarator aisDeclarator
                = (AisDeclarator) this.componentFactory.getDeclarator();
        this.initializer = aisDeclarator.getInitializer();
        this.declaratorId = aisDeclarator.getDeclaratorId();

        this.primitiveId = this.declaratorId.getPrimitiveId();
    }

    private void aisDeclaration() throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (this.primitiveId != null ) {

            this.positionAisLabelPrimitiveId();

            this.positionAisAssociative(); // store into listLabel structure in case there has vector

            this.positionHierPostfix();
            this.positionAttribute();
            this.assignInitializer();

        }
    }

    // position the primitive label if the type is impose and assignment or set
    private void positionAisLabelPrimitiveId() throws SomeVariableMissingException, FieldTypeNotMarchException {

        String labelName = primitiveId.getId();

        // if the primitiveId is simple type without hierPostfix
        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_PRIMITIVE)) {

            switch (this.AISType){
                case RIIF2Grammar.IMPOSE:
                    this.aisLabel = this.recorder.getImposeLabel(labelName);
                    break;
                case RIIF2Grammar.ASSIGNMENT:
                    this.aisLabel = this.recorder.getAssignmentLabel(labelName);
                    break;
                case RIIF2Grammar.SET:
                    this.aisLabel = this.recorder.getSetLabel(labelName);
                    break;
                default:
                    this.aisLabel = null;
                    break;
            }
        }

        // if the primitiveId is not simple type with hierPostfix
        if (Objects.equals(this.primitiveId.getType(), RIIF2Grammar.TYPE_HIER)){

            RIIF2Recorder theRecorder = null;
            RIIF2Recorder preRecorder = this.recorder;
            int index = -1;

            // get the hierpostfix from the primitiveId
            List<Id> ids = this.primitiveId.hierPostfixIds();
            for (Id id: ids) {
                index++;
                String idName = id.getId();

                assert preRecorder != null;

                switch (this.AISType){
                    case RIIF2Grammar.IMPOSE:
                        theRecorder = preRecorder.getExRecorder(idName);
                        break;
                    case RIIF2Grammar.ASSIGNMENT:
                        theRecorder = preRecorder.getExRecorder(idName);
                        break;
                    case RIIF2Grammar.SET:
                        theRecorder = preRecorder.getImplRecorder(idName);
                        break;
                    default:
                        theRecorder = null;
                }

                if (theRecorder != null ) {
                    preRecorder = theRecorder;
                }

                else {
                    this.aisLabel = preRecorder.getAssignmentLabel(idName);
                    break;
                }
            }

            if (theRecorder != null)
                this.aisLabel = theRecorder.getAssignmentLabel(labelName);
            else {
                while (index+1  <  ids.size() ){
                    Id id = ids.get(index);

                    if (this.aisLabel == null )
                        throw new SomeVariableMissingException(id.getId(),
                                id.getLine() , id.getColumn());
                    if (  ! (this.aisLabel instanceof ChildComponent) )
                        throw new FieldTypeNotMarchException(id.getId(),
                                id.getLine(), id.getColumn());

                    index ++ ;
                    this.aisLabel = ((RIIF2Recorder) this.aisLabel.getValue() )
                            .getAssignmentLabel( ids.get(index).getId() );
                }
                this.aisLabel
                        = ((RIIF2Recorder)this.aisLabel.getValue()).getLabel(labelName);
            }
        }

        if (this.aisLabel == null )
            throw new SomeVariableMissingException(labelName,
                    this.primitiveId.getLine(),this.primitiveId.getColumn());
    }

    /**
     * declaratorId ::
     * primitiveId (aisType|associativeIndex) ? hierPostfix ? attributeIndex?
     * */
    private void positionAisAssociative() throws FieldTypeNotMarchException, SomeVariableMissingException {

        // if it is associativeIndex, then get the label, or create a new label put the new label into the associativeLabel and get back.
        if (this.declaratorId.hasAssociativeIndex()) {
            Id associativeId = this.declaratorId.getAssociativeIndex();
            String associativeIndex = associativeId.getId();

            if (!this.aisLabel.isAssociative())
                throw new FieldTypeNotMarchException(associativeIndex,
                        associativeId.getLine(), associativeId.getColumn());

            Label tempLabel = this.aisLabel;

            this.aisLabel = tempLabel.getAssociative(associativeIndex);

            if (this.aisLabel == null) {
                // if not find the label, then create the label
                this.aisLabel = this.createLabel(associativeIndex, tempLabel);
                tempLabel.putAssociative(associativeIndex, this.aisLabel);
            }

            this.listLabel.add(this.aisLabel);
        }

        else if (this.declaratorId.hasAisType()) {
            RIIF2Type aisType = this.declaratorId.getAisType();
            String type = aisType.getType();

            // if the declaratorId is flat vector type
            if (type.equals(RIIF2Grammar.TYPE_FLAT_VECTOR)) {

                if ( !this.aisLabel.isVector())
                    throw new FieldTypeNotMarchException(this.declaratorId.toString(), this.declaratorId.getLine(), this.declaratorId.getColumn());

                this.verifyVector(aisType);
                Vector vector = aisType.getVector();
                int left = vector.getLeftValue();
                int right = vector.getRightValue();

                List<Label> currListLabel = new LinkedList<>();
                for (int i = left; i <= right; i++) {
                    Label label = this.aisLabel.getVectorItem(i-1);
                    currListLabel.add(label);
                }

                this.listLabel = currListLabel;
            }
        }

        else this.listLabel.add(this.aisLabel);
    }

    private void positionHierPostfix() throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (this.declaratorId.hasHierPostfix()) {
            List<Label> currListLabel = new LinkedList<>();

            for (Label label : this.listLabel) {

                Id hierPostfixId = this.declaratorId.getHierPostfix();
                String hierPostfixName = hierPostfixId.getId();

                if (!(label instanceof ChildComponent)) {
                    throw new FieldTypeNotMarchException(hierPostfixName,
                            hierPostfixId.getLine(), hierPostfixId.getColumn());
                }

                RIIF2Recorder ccRecorder = (RIIF2Recorder) (label).getValue();

                if (ccRecorder == null)
                    System.out.println("the ccRecorder is null ");


                label = ccRecorder.getAssignmentLabel(hierPostfixName) != null
                        ? ccRecorder.getAssignmentLabel(hierPostfixName)
                        : ccRecorder.getImposeLabel(hierPostfixName) != null
                        ? ccRecorder.getImposeLabel(hierPostfixName)
                        : null;

                if (label == null)
                    throw new SomeVariableMissingException(hierPostfixName,
                            hierPostfixId.getLine(), hierPostfixId.getColumn());

                currListLabel.add(label);
            }

            if (currListLabel.size() == 0 )
                System.out.println("hier size is zero");

            this.listLabel = currListLabel;
        }
    }

    private void positionAttribute() throws FieldTypeNotMarchException {

        if (this.declaratorId.hasAttributeIndex()) {
            List<Label> currListLabel = new LinkedList<>();

            for (Label label : this.listLabel) {

                Id attributeId = this.declaratorId.getAttributeIndex();
                String attributeIndex = attributeId.getId();

                // if the current label is child component then we need to pass value into the child component
                if (label instanceof ChildComponent) {
                    RIIF2Recorder childComponent = (RIIF2Recorder) label.getValue();
                    label = childComponent.getLabel(attributeIndex);
                } else {
                    Label<Label> tempLabel = label.getAttribute(attributeIndex);

                    if (tempLabel == null) {
                        tempLabel = PreDefinedAttribute.createAttribute(attributeIndex, RIIF2Grammar.STRING, null, this.recorder);
                        label.putAttribute(attributeIndex, (Attribute) tempLabel);
                    }
                    label = tempLabel;
                }


                currListLabel.add(label);
            }

            if (currListLabel.size() == 0 )
                System.out.println("attribute size is zero");
            this.listLabel = currListLabel;
        }
    }

    // pay attention: the ais value should be pushed into a stack
    private void assignInitializer() throws FieldTypeNotMarchException, SomeVariableMissingException {

        int i = 0;
        for (Label label : this.listLabel) {
            this.aisLabel = label;

            if (this.aisLabel == null)
                throw new SomeVariableMissingException(this.declaratorId.toString(), this.declaratorId.getLine(), this.declaratorId.getColumn());

            // if the initializer is an expression
            if (this.initializer instanceof Expression) {

                Expression expInitializer = (Expression) this.initializer;
                expInitializer.setRecorder(this.recorder);
                expInitializer.setCurrentLabel(this.aisLabel);


                // in the case the declarator has table Index
                if (this.aisLabel.getName().equals(RIIF2Grammar.ITEMS) && this.declaratorId.hasTableIndex()){
                    Id tableIndex = this.declaratorId.getTableIndex();
                    String xx = tableIndex.getXX();
                    String yy = tableIndex.getYY();

                    // expInitializer.isValid(); // throw Exceptions
                    expInitializer.setLocation(xx, yy);
                    this.aisLabel.setValue(expInitializer);
                }

                // the expInitializer type is USER_DEFINED
                else if (expInitializer.getType().equals(RIIF2Grammar.USER_DEFINED)) {

                    Id primitiveId = ((DeclaratorId) expInitializer.value()).getPrimitiveId();

                    // the expInitializer is a enum element.
                    if (this.aisLabel.isEnumType()) {
                        String enumType = primitiveId.getId();

                        if (primitiveId.getType().equals(RIIF2Grammar.TYPE_HIER))
                            throw new FieldTypeNotMarchException(enumType, expInitializer.getLine(), expInitializer.getColumn());

                        else if (!this.aisLabel.getEnumType().contains(enumType))
                            throw new SomeVariableMissingException(enumType, expInitializer.getLine(), expInitializer.getColumn());

                        else this.aisLabel.setValue(enumType);
                    }

                    // current label is an attribute
                    else if (this.aisLabel instanceof Attribute) {

                        // the expInitializer is a attribute unit.
                        if (this.aisLabel.getName().equals(RIIF2Grammar.UNIT)) {
                            String unit = primitiveId.getId();

                            if (primitiveId.getType().equals(RIIF2Grammar.TYPE_HIER))
                                throw new FieldTypeNotMarchException(unit, expInitializer.getLine(), expInitializer.getColumn());
                            else this.aisLabel.setValue(unit);
                        }
                    }

                    // the type is platform
                    else if (this.aisLabel.getType().equals(RIIF2Grammar.PLATFORM)) {
                        String componentId = primitiveId.getId();

                        if (!Repository.containsComponent(componentId))
                            throw new SomeVariableMissingException(componentId, expInitializer.getLine(), expInitializer.getColumn());

                        RIIF2Recorder platformRecorder = (RIIF2Recorder) Repository.getDeepCopedRecorderFromComponentRepository(componentId);

                        this.aisLabel.setValue(platformRecorder);
                    } else
                        throw new FieldTypeNotMarchException(this.aisLabel.getName(), expInitializer.getLine(), expInitializer.getColumn());
                }

                // if the the expInitializer type same with current label type
                else if (expInitializer.getType().equals(this.aisLabel.getType()))
                    this.aisLabel.setValue(expInitializer);

                else if (expInitializer.getType().equals(RIIF2Grammar.INTEGER)
                        && this.aisLabel.getType().equals(RIIF2Grammar.DOUBLE))
                    this.aisLabel.setValue(expInitializer);

                else
                    throw new FieldTypeNotMarchException(this.aisLabel.getName()
                            + ":" + this.aisLabel.getType()
                            + " , " + expInitializer.getType(), expInitializer.getLine(), expInitializer.getColumn());
            }

            // if the initializer is a listInitializer
            if (this.initializer instanceof ListInitializer) {
                ListInitializer listInitializer = (ListInitializer) this.initializer;
                this.aisLabel.setValue(listInitializer);
            }



            if (this.initializer instanceof ArrayInitializer) {
                ArrayInitializer arrayInitializer = (ArrayInitializer) this.initializer;
                List<Expression> expressions = arrayInitializer.getInitializer();

                Expression expression = expressions.get(i++);
                expression.setCurrentLabel(this.aisLabel);
                expression.setRecorder(this.recorder);

                this.aisLabel.setValue(expression);
            }

            if (this.initializer instanceof ArrayWrapperInitializer) {
                this.aisLabel.setValue(this.initializer);
            }

            // the initializer is a tableInitializer
            if (this.initializer instanceof TableInitializer) {

                TableInitializer tableInitializer
                        = (TableInitializer) this.initializer;

                if (!(this.aisLabel instanceof Attribute)
                        || (!this.aisLabel.getName().equals(RIIF2Grammar.HEADER)
                        && !this.aisLabel.getName().equals(RIIF2Grammar.ITEMS))
                        ) {
                    throw new FieldTypeNotMarchException(RIIF2Grammar.ASSIGNMENT,
                            tableInitializer.getLine(),
                            tableInitializer.getColumn());
                }

                this.aisLabel.setValue(tableInitializer);
            }
        }
    }

    private Label<Label> createLabel(String associativeIndex, Label tempLabel) throws FieldTypeNotMarchException {

        Label<Label> rtnLabel = null;
        if ( tempLabel instanceof Parameter) {
            rtnLabel = new Parameter(this.recorder);
            rtnLabel.setAttribute(true);
            PreDefinedAttribute.FieldAttribute(rtnLabel,this.recorder);
        }
        if (tempLabel instanceof Constant) {
            rtnLabel = new Constant(this.recorder);
            rtnLabel.setAttribute(true);
            PreDefinedAttribute.FieldAttribute(rtnLabel,this.recorder);
        }
        if (tempLabel instanceof FailMode) {
            rtnLabel = new FailMode(this.recorder);
            rtnLabel.setAttribute(true);
            PreDefinedAttribute.FMAttribute( rtnLabel,this.recorder );
        }
        if (tempLabel instanceof ChildComponent) {
            rtnLabel = new ChildComponent(this.recorder);
            rtnLabel.setValue(tempLabel.getValue());
        }

        assert rtnLabel != null;
        rtnLabel.setName(associativeIndex);
        rtnLabel.setType(tempLabel.getType());

        return rtnLabel;
    }

    private void verifyVector(RIIF2Type TypeType) throws FieldTypeNotMarchException {

        Vector  vector = TypeType.getVector();
        Expression left = vector.getLeft();
        Expression right = vector.getRight();

        left.setCurrentLabel(this.aisLabel);
        left.setRecorder(this.recorder);

        right.setCurrentLabel(this.aisLabel);
        right.setRecorder(this.recorder);

        if (!left.isInteger())
            throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MESSAGE,left.getLine(),left.getColumn());

        int leftValue;
        if (left.getValue() instanceof Expression ){
            this.aisLabel.setVectorLeftExpression((Expression)left.getValue());
            leftValue = (int) ((Expression) left.getValue()).getValue();
        }else
            leftValue = (int) left.getValue();

        if (!right.isInteger())
            throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MESSAGE,right.getLine(), right.getColumn());

        int rightValue;
        if(right.getValue() instanceof  Expression){
            this.aisLabel.setVectorRightExpression((Expression)right.getValue());
            rightValue = (int) ((Expression) right.getValue()).getValue();
        }
        else rightValue = (int) right.getValue();

        if ( leftValue < 0 || leftValue > rightValue )
            throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MESSAGE, left.getLine(),left.getLine());

    }

    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {
        this.initializer();
        this.aisDeclaration();
    }
}
