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
import org.w3c.dom.Attr;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AISFactory implements Factory{

    private final String AISType;
    private final ComponentFactory componentFactory;
    private final RIIF2Recorder recorder;

    private DeclaratorId declaratorId;
    private Initializer initializer;

    private Id primitiveId;

    private Label<Label> aisLabel = null;

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
            this.positionAisAssociative();
            this.positionHierPostfix();
            this.positionAttribute();
            this.assignInitializer();
        }
    }

    // position the primitive label if the type is impose and assignment or set
    private void positionAisLabelPrimitiveId()
            throws SomeVariableMissingException, FieldTypeNotMarchException {

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

                if (theRecorder != null )
                    preRecorder = theRecorder;
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
        }

        if (this.declaratorId.hasAisType()) {
            RIIF2Type aisType = this.declaratorId.getAisType();
            String type = aisType.getType();

            if (type.equals(RIIF2Grammar.TYPE_FLAT_VECTOR)) {

                Vector vector = aisType.getVector();
                Expression expLeft = vector.getLeft();
                if (!expLeft.getType().equals(RIIF2Grammar.INTEGER))
                    throw new FieldTypeNotMarchException(expLeft.getType(), expLeft.getLine(), expLeft.getColumn());

                Expression expRight = vector.getRight();
                if (!expRight.getType().equals(RIIF2Grammar.INTEGER))
                    throw new FieldTypeNotMarchException(expRight.getType(), expLeft.getLine(), expLeft.getColumn());

                Map.Entry<Expression, Expression> vectorEntry =
                        VectorImpl.createExpressionEntryPair(expLeft, expRight);

                VectorItem label = new VectorItem(this.recorder);

                this.aisLabel.putVectorEntryValue(vectorEntry, label);
                this.aisLabel = label;

            }
        }
    }

    private void positionHierPostfix() throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (this.declaratorId.hasHierPostfix()) {
            Id hierPostfixId = this.declaratorId.getHierPostfix();
            String hierPostfixName = hierPostfixId.getId();

            if (!(this.aisLabel instanceof ChildComponent)) {
                throw new FieldTypeNotMarchException(hierPostfixName,
                        hierPostfixId.getLine(), hierPostfixId.getColumn());
            }

            RIIF2Recorder ccRecorder  = (RIIF2Recorder) (this.aisLabel).getValue();

            this.aisLabel = ccRecorder.getAssignmentLabel(hierPostfixName) != null
                            ? ccRecorder.getAssignmentLabel(hierPostfixName)
                            : ccRecorder.getImposeLabel(hierPostfixName) != null
                            ? ccRecorder.getImposeLabel(hierPostfixName)
                            : null;

            if (this.aisLabel == null)
                throw new SomeVariableMissingException(hierPostfixName,
                        hierPostfixId.getLine(), hierPostfixId.getColumn());
        }
    }

    private void positionAttribute() throws FieldTypeNotMarchException {

        if (this.declaratorId.hasAttributeIndex()){

            Id attributeId = this.declaratorId.getAttributeIndex();
            String attributeIndex = attributeId.getId();

            Label<Label> tempLabel = this.aisLabel.getAttribute(attributeIndex);

            if (tempLabel == null){
                tempLabel = PreDefinedAttribute.createAttribute(attributeIndex,RIIF2Grammar.STRING,null,this.recorder);
                this.aisLabel.putAttribute(attributeIndex, (Attribute) tempLabel);
            }
            this.aisLabel = tempLabel;
        }
    }

    // pay attention: the ais value should be pushed into a stack
    private void assignInitializer() throws FieldTypeNotMarchException, SomeVariableMissingException {

            // if the initializer is an expression
            if (this.initializer instanceof Expression) {

                Expression expInitializer = (Expression) this.initializer;
                expInitializer.setRecorder(this.recorder);
                expInitializer.setCurrentLabel(this.aisLabel);

                // the expInitializer type is USER_DEFINED
                if (expInitializer.type().equals(RIIF2Grammar.USER_DEFINED)) {

                    Id primitiveId = ((DeclaratorId)expInitializer.value()).getPrimitiveId();

                    // the expInitializer is a enum element.
                    if (this.aisLabel.isEnumType()) {
                        String enumType = primitiveId.getId();

                        if (primitiveId.getType().equals(RIIF2Grammar.TYPE_HIER))
                            throw new FieldTypeNotMarchException(enumType, expInitializer.getLine(), expInitializer.getColumn());

                        else if (!this.aisLabel.getEnumType().contains(enumType))
                            throw new SomeVariableMissingException(enumType,expInitializer.getLine(),expInitializer.getColumn());

                        else
                            this.aisLabel.setValue(enumType);
                    }

                    // current label is an attribute
                    else if (this.aisLabel instanceof Attribute) {

                        // the expInitializer is a attribute unit.
                        if (this.aisLabel.getName().equals(RIIF2Grammar.UNIT)) {
                            String unit = primitiveId.getId();

                            if (primitiveId.getType().equals(RIIF2Grammar.TYPE_HIER))
                                throw new FieldTypeNotMarchException(unit, expInitializer.getLine(), expInitializer.getColumn());
                            else
                                this.aisLabel.setValue(unit);
                        }

                        //..tableId  = 'Item[][]
                        // in this case, the aisLable is a attribute label ITEMS of a Table label and the tableIndex would have two different case.
                        else if (this.aisLabel.getName().equals(RIIF2Grammar.ITEMS) && this.declaratorId.hasTableIndex() ){

                            Id tableIndex = this.declaratorId.getTableIndex();
                            String xx = tableIndex.getXX();
                            String yy = tableIndex.getYY();

                           // expInitializer.isValid(); // throw Exceptions
                            expInitializer.setLocation(xx,yy);
                            this.aisLabel.setValue(expInitializer);
                        }
                    }

                    // the type is platform
                    else if (this.aisLabel.getType().equals(RIIF2Grammar.PLATFORM)) {
                        String componentId =  primitiveId.getId();

                        if (!Repository.containsComponent(componentId))
                            throw new SomeVariableMissingException(componentId,expInitializer.getLine(), expInitializer.getColumn());

                        RIIF2Recorder platformRecorder = (RIIF2Recorder) Repository.getDeepCopedRecorderFromComponentRepository(componentId);

                        this.aisLabel.setValue(platformRecorder);
                    }

                    else
                        throw new FieldTypeNotMarchException(this.aisLabel.getName(), expInitializer.getLine(), expInitializer.getColumn());

                }

                // if the the expInitializer type same with current label type
                else if (expInitializer.getType().equals( this.aisLabel.getType()) )
                    this.aisLabel.setValue(expInitializer);

                else if (expInitializer.getType().equals( RIIF2Grammar.INTEGER)
                            && this.aisLabel.getType().equals(RIIF2Grammar.DOUBLE) )
                    this.aisLabel.setValue(expInitializer);

                else
                    throw new FieldTypeNotMarchException( this.aisLabel.getName()
                            + ":" + this.aisLabel.getType()
                            + " , " + expInitializer.getType(), expInitializer.getLine(), expInitializer.getColumn());
            }

            // if the initializer is a listInitializer
            if (this.initializer instanceof ListInitializer) {
                ListInitializer listInitializer = (ListInitializer) this.initializer;
                this.aisLabel.setValue(listInitializer );
            }


            // no this case
            if (this.initializer instanceof ArrayInitializer){
                throw new FieldTypeNotMarchException(this.aisLabel.getName(), this.initializer.getLine(),this.initializer.getColumn());
            }

            if (this.initializer instanceof ArrayWrapperInitializer){
                this.aisLabel.setValue(this.initializer);
           //     System.out.println("After assign ");
            }

            // the initializer is a tableInitializer
            if (this.initializer instanceof TableInitializer){

                TableInitializer tableInitializer
                        = (TableInitializer) this.initializer;

                if (!(this.aisLabel instanceof Attribute)
                        || ( !this.aisLabel.getName().equals(RIIF2Grammar.HEADER)
                             && !this.aisLabel.getName().equals(RIIF2Grammar.ITEMS) )
                        ) {
                    throw new FieldTypeNotMarchException( RIIF2Grammar.ASSIGNMENT,
                            tableInitializer.getLine(),
                            tableInitializer.getColumn());
                }

                this.aisLabel.setValue(tableInitializer);
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


    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {
        this.initializer();
        this.aisDeclaration();
    }
}
