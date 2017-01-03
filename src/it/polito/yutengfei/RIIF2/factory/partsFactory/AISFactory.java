package it.polito.yutengfei.RIIF2.factory.partsFactory;


import it.polito.yutengfei.RIIF2.Declarator.AisDeclarator;
import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Platform;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.List;
import java.util.Objects;

public class AISFactory {

    private final String AISType;

    private RIIF2Recorder recorder;
    private Declarator declarator;

    private Initializer initializer;
    private AisDeclarator aisDeclarator;

    public AISFactory(String assignment, RIIF2Recorder recorder) {
        this.recorder = recorder;
        this.AISType = assignment;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void commit() throws FieldTypeNotMarchException, SomeVariableMissingException {
        this.aisDeclarator = (AisDeclarator) this.declarator;
        this.initializer = this.declarator.getInitializer();

        this.aisDeclaration();
    }

    private void aisDeclaration() throws FieldTypeNotMarchException, SomeVariableMissingException {

        switch (this.AISType){

            case RIIF2Grammar.ASSIGNMENT:
                this.assignmentDeclaration();
                break;
            case RIIF2Grammar.SET:
                this.setDeclaration();
                break;
            case RIIF2Grammar.IMPOSE:
                this.imposeDeclaration();
                break;
            default:
                break;
        }
    }

    /*current template or the templates extended by current template */
    private void imposeDeclaration() throws FieldTypeNotMarchException {
        DeclaratorId imposeDeclaratorId = aisDeclarator.getDeclaratorId();
        Id primitiveId = imposeDeclaratorId.getPrimitiveId();

        if(/*the most easy one */ Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_PRIMITIVE)){

            String labelName = primitiveId.getId();
            Label theLabel = this.recorder.getLabel(labelName);

            if (/*has attribute */ imposeDeclaratorId.getAttributeIndex() != null ){
                Id attributeIndex = imposeDeclaratorId.getAttributeIndex();
                String attributeId = attributeIndex.getId();

                Attribute theAttribute = theLabel.getAttribute(attributeId);
                if (theAttribute == null)
                    theLabel.addAttribute( this.createAttribute(attributeId));
                else
                    this.initialAttribute(theAttribute,true);

            }
        }

    }

    private void setDeclaration()
            throws FieldTypeNotMarchException, SomeVariableMissingException {
        DeclaratorId setDeclaratorId = aisDeclarator.getDeclaratorId();
        Id primitiveId = setDeclaratorId.getPrimitiveId();
        String primitiveName = primitiveId.getId();

        Label theLabel;
        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_HIER_INDEX)) {
            RIIF2Recorder hierRecorder = this.recorder;
            List<Id> hierfixs = primitiveId.hierPostfixIds();
            if (hierfixs != null && hierfixs.size() > 0) {
                for (Id id : hierfixs) {
                    String hierRecorderName = id.getId();
                    hierRecorder = hierRecorder.getSetRecorder(hierRecorderName);
                    if (hierRecorder == null)
                        throw new SomeVariableMissingException();
                }
            }
            theLabel = hierRecorder.getLabel(primitiveName);
        }else
            theLabel = this.recorder.getSetLabel(primitiveName);

        if (theLabel == null)
            throw new SomeVariableMissingException();

        this.newSetDeclaration( setDeclaratorId , theLabel);

    }

    private void newSetDeclaration(DeclaratorId setDeclaratorId, Label label)
            throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (initializer instanceof Expression){
            Expression expInitializer = (Expression) initializer;

            if (label instanceof Platform){
                if (!Objects.equals(expInitializer.getType(), RIIF2Grammar.USER_DEFINED))
                    throw new FieldTypeNotMarchException();

                if (!this.recorder.containsGlobalComponent(expInitializer.getValue().toString()))
                    throw new SomeVariableMissingException();

                RIIF2Recorder platformRecorder = this.recorder.getImplRecorder( expInitializer.getValue().toString() );
                ((Platform) label).setValue(platformRecorder);
            }
        }

        if (setDeclaratorId.getHierPostfix() == null
                && setDeclaratorId.getAssociativeIndex() == null
                && setDeclaratorId.getAttributeIndex() == null
                && setDeclaratorId.getAisType() == null){

            if (initializer instanceof Expression){
                Expression expInitializer = (Expression) initializer;

                if (!Objects.equals(label.getType(), expInitializer.getType()))
                    throw new FieldTypeNotMarchException();

                label.setValue(expInitializer.getValue());
            }
        }
    }

    private void assignmentDeclaration(/*void*/) throws FieldTypeNotMarchException, SomeVariableMissingException { /*allowed in current component and parent cpomponents */

        DeclaratorId assignmentDeclaratorId = aisDeclarator.getDeclaratorId();
        Id primitiveId = assignmentDeclaratorId.getPrimitiveId();

        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_PRIMITIVE)){
            String labelName = primitiveId.getId();
            Label label = this.recorder.getAssignmentLabel(labelName);

            if (label == null )
                throw new SomeVariableMissingException();


            if (assignmentDeclaratorId.getAttributeIndex() != null){
                Id attributeIndex = assignmentDeclaratorId.getAttributeIndex();
                String attribute = attributeIndex.getId();
                if (label.getAttribute(attribute) == null){
                    label.addAttribute( this.createAttribute( attribute )  );
                }else {
                    Attribute theAttribute = label.getAttribute(attribute);
                    this.initialAttribute(theAttribute,true);
                }
            }
        }
    }

    private Attribute createAttribute(String attributeName ) throws FieldTypeNotMarchException {
        Attribute attribute = new Attribute();

        attribute.setType( RIIF2Grammar.STRING );
        attribute.setId(attributeName);
        this.initialAttribute(attribute,false);

        return attribute;
    }

    private void initialAttribute(Attribute theAttribute, Boolean check) throws FieldTypeNotMarchException {

        if ( initializer instanceof  Expression){
            Expression expInitializer = (Expression) this.declarator.getInitializer();

            if (check) {
                if (!Objects.equals(expInitializer.getType(), theAttribute.getType()))
                    throw new FieldTypeNotMarchException();
            }

            theAttribute.setValue(expInitializer.getValue());
        }
    }

}
