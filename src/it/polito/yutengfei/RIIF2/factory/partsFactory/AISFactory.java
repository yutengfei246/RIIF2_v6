package it.polito.yutengfei.RIIF2.factory.partsFactory;


import it.polito.yutengfei.RIIF2.Declarator.AisDeclarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.ChildComponent;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
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

import java.util.List;
import java.util.Objects;

public class AISFactory implements Factory{

    private final String AISType;
    private final ComponentFactory componentFactory;
    private final RIIF2Recorder recorder;

    private DeclaratorId declaratorId;
    private Initializer initializer;

    private Id primitiveId;
    private Id tableId;

    private Label aisLabel = null;

    public AISFactory(ComponentFactory componentFactory, String assignment, RIIF2Recorder recorder) {
        this.componentFactory = componentFactory;
        this.recorder = recorder;
        this.AISType = assignment;
    }

    private void initializer() {
        AisDeclarator aisDeclarator = (AisDeclarator) this.componentFactory.getDeclarator();
        this.initializer = aisDeclarator.getInitializer();
        this.declaratorId = aisDeclarator.getDeclaratorId();

        this.primitiveId = this.declaratorId.getPrimitiveId();
        this.tableId = this.declaratorId.getTableId();

    }

    private void aisDeclaration()
            throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (this.primitiveId != null ) {

            this.getAisLabel();
            this.newAISDeclarator();
        }

        if (this.tableId != null ){
            //TODO: table Id
            System.out.println("Table need to be done ...");
        }
    }

    private void newAISDeclarator() throws FieldTypeNotMarchException, SomeVariableMissingException {
         /*vector or associative*/
        if (this.declaratorId.hasAisType()) {
            RIIF2Type aisType = this.declaratorId.getAisType();
            String type = aisType.getType();

            if (type.equals(RIIF2Grammar.TYPE_ASSOCIATIVE)) {
                //TODO: skip
                System.out.println("Going to finish ");
            }

            if (type.equals(RIIF2Grammar.TYPE_FLAT_VECTOR)) {

                if (!this.aisLabel.isVector())
                    throw new FieldTypeNotMarchException();

                Vector vector = aisType.getVector();

                String hierPostfixIndex = this.getHierPostfixIndex();
                if (hierPostfixIndex != null) {

                    String attributeIndex = this.getAttributeIndex();
                    if (attributeIndex != null)
                        this.setVectorHierPostfixAttributeValue(vector, hierPostfixIndex, attributeIndex);
                    else
                        this.setVectorHierPostfixValue(vector, hierPostfixIndex);
                } else {

                    String attributeIndex = this.getAttributeIndex();
                    if (attributeIndex != null)
                        this.setVectorAttributeValue(vector, attributeIndex);
                    else
                        this.setVectorValue(vector);
                }
            }
        } else {

            String hierPostfixIndex = this.getHierPostfixIndex();
            if (hierPostfixIndex != null) {

                String attributeIndex = this.getAttributeIndex();
                if (attributeIndex != null)
                    this.setHierPostfixAttributeValue(hierPostfixIndex, attributeIndex);
                else
                    this.setHierPostfixValue(hierPostfixIndex);
            } else {

                String attributeIndex = this.getAttributeIndex();
                if (attributeIndex != null)
                    this.setAttributeValue(attributeIndex);
                else
                    this.setPureValue();
            }
        }

    }

    private void getAisLabel() throws SomeVariableMissingException, FieldTypeNotMarchException {

        String labelName = primitiveId.getId();

        if (Objects.equals(primitiveId.getType(),
                RIIF2Grammar.TYPE_PRIMITIVE)) {

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

            if (this.aisLabel == null)
                throw new SomeVariableMissingException();
        }

        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_HIER)){

            RIIF2Recorder theRecorder = null;
            RIIF2Recorder preRecorder = this.recorder;
            int index = -1;

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
                    System.out.println("theRecorder is nullable and idName is " + idName);

                    if (  ! (this.aisLabel instanceof ChildComponent) )
                        throw new FieldTypeNotMarchException();
                    break;
                }
            }

            if (theRecorder != null)
                this.aisLabel = theRecorder.getLabel(labelName);
            else {
                while (index+1  <  ids.size() ){
                    index ++ ;
                    System.out.println("Going the check the aisLabel " );
                    if (  ! (this.aisLabel instanceof ChildComponent) )
                        throw new FieldTypeNotMarchException();
                    this.aisLabel
                            = ((RIIF2Recorder) this.aisLabel.getValue() )
                            .getAssignmentLabel( ids.get(index).getId() );
                }
                this.aisLabel
                        = ((RIIF2Recorder)this.aisLabel.getValue()).getLabel(labelName);
            }

            if (this.aisLabel == null )
                throw new SomeVariableMissingException();
        }

    }

    private void setPureValue()
            throws FieldTypeNotMarchException {

        if (this.initializer instanceof Expression){
            Expression expInitializer = (Expression) this.initializer;

            if (!Objects.equals(expInitializer.getType(), this.aisLabel.getType()))
                throw new FieldTypeNotMarchException();

            this.aisLabel.setValue(expInitializer.getValue());
        }

        if (this.initializer instanceof ArrayInitializer){
            //TODO: arrayInitializer
            System.out.println("array need to be finish ");
        }

        if (this.initializer instanceof ListInitializer){
            //TODO: listInitializer
            System.out.println("list need to be finish");
        }


    }

    private void setHierPostfixValue(String hierPostfixIndex)
            throws FieldTypeNotMarchException {

        RIIF2Recorder recorder
                = (RIIF2Recorder) this.aisLabel.getValue();
        this.aisLabel = recorder.getLabel(hierPostfixIndex);

        this.setPureValue();
    }

    private void setAttributeValue(String attributeIndex)
            throws FieldTypeNotMarchException {

        Attribute attribute
                =  this.aisLabel.getAttribute( attributeIndex );

        if (attribute == null) {
            attribute = createAttribute(attributeIndex);
            this.aisLabel.putAttribute(attributeIndex,attribute);
        }

        this.initialAttribute(attribute);
    }


    private void setHierPostfixAttributeValue(String hierPostfixIndex, String attributeIndex) {
        //TODO:: ...
    }

    private void setVectorAttributeValue(Vector vector, String attributeIndex) {
        //TODO:: ...
    }

    public void setVectorValue(Vector vectorValue) {
        //TODO::
    }

    private void setVectorHierPostfixValue(Vector vector, String hierPostfix) {
        //TODO::
    }

    private void setVectorHierPostfixAttributeValue(Vector vector, String hierPostfix, String attributeIndex) {
        //TODO::
    }

    private Attribute createAttribute(String attributeName ) {

        Attribute attribute = new Attribute();

        if (Objects.equals(attributeName, RIIF2Grammar.RATE))
            attribute.setType(RIIF2Grammar.INTEGER);
        else
            attribute.setType( RIIF2Grammar.STRING );
        attribute.setId(attributeName);

        return attribute;
    }

    private void initialAttribute(Attribute attribute) throws FieldTypeNotMarchException {

        if (this.initializer instanceof Expression){
            Expression expInitializer = (Expression) this.initializer;

            if ( !Objects.equals(expInitializer.getType(), attribute.getType()) )
                throw new FieldTypeNotMarchException();
            attribute.setValue( expInitializer.getValue() );
        }

    }


    private String getAttributeIndex() throws SomeVariableMissingException {
        String attribute = null;

        if (this.declaratorId.hasAttributeIndex()){

            Id attributeIndexId  = this.declaratorId.getAttributeIndex();
            attribute = attributeIndexId.getId();
        }

        return attribute;
    }

    private String getHierPostfixIndex() throws FieldTypeNotMarchException {
        String hierPostfix = null ;

        if (this.declaratorId.hasHierPostfix()) {

            if (!(this.aisLabel instanceof ChildComponent))
                throw new FieldTypeNotMarchException();

            Id hierPostfixId = this.declaratorId.getHierPostfix();
            hierPostfix = hierPostfixId.getId();

        }
        return hierPostfix;
    }

    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, InvalidFieldDeclaration, FieldTypeNotMarchException {
        this.initializer();
        this.aisDeclaration();
    }
}
