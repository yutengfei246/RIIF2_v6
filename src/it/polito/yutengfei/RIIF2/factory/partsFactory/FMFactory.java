package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.FailModeDeclarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.FailMode;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.SomeVariableMissingException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.VeriableAlreadyExistException;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

public class FMFactory implements Factory {

    private final RIIF2Recorder recorder;
    private final ComponentFactory componentFactory;

    private DeclaratorId declaratorId;

    private Label<Label> fm = null;

    public FMFactory(ComponentFactory componentFactory, RIIF2Recorder recorder) {
        this.recorder = recorder;
        this.componentFactory = componentFactory;
    }

    private void initializer() {
        FailModeDeclarator failModeDeclarator = (FailModeDeclarator) this.componentFactory.getDeclarator();
        this.declaratorId  = failModeDeclarator.getDeclaratorId();
    }

    // find the label position
    private void positionFm() throws VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {

        String fmName = this.declaratorId.getId();

        // if it does not have an attributeIndex or does not have an AssociativeIndex, then create a FailMode
        if ( !this.declaratorId.hasAttributeIndex()
                && !this.declaratorId.hasAssociativeIndex() ) {

            if (this.recorder.contains(fmName))
                throw new VeriableAlreadyExistException(fmName,
                        this.declaratorId.getLine(),
                        this.declaratorId.getColumn() );

            this.createFailMode(fmName);

        }else {
            this.fm = this.recorder.getFailMode(fmName);

            if (this.fm == null)
                throw new SomeVariableMissingException(this.declaratorId.getId(),
                        this.declaratorId.getLine(), this.declaratorId.getColumn());
        }

        if (declaratorId.hasAssociativeIndex() )
            this.positionFmForFailModeDeclarator2();
        else
            this.positionFmForFailModeDeclarator1();

    }

    /**
     *  Declarator :: Identifier typeType ? attribute ?
     * */
    private void positionFmForFailModeDeclarator1() throws FieldTypeNotMarchException {

        if (this.declaratorId.hasAttributeIndex()){

            String attributeIndex = this.declaratorId.getAttributeIndex().getId();
            Attribute attribute = PreDefinedAttribute.createAttribute(attributeIndex,
                    RIIF2Grammar.STRING, null,this.recorder);

            this.fm.putAttribute(this.declaratorId.getAttributeIndex().getId(),
                    attribute);
            this.fm = attribute;
        }
    }

    /**
     *  DeclaratorId :: Identifier associativeIndex attributeIndex ?
     *  */
    private void positionFmForFailModeDeclarator2()
            throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {

        String associativeIndex = this.declaratorId.getAssociativeIndex().getId();

        if ( !this.fm.containsAssociative(associativeIndex)){
            Label<Label> associative = this.createLabel(associativeIndex,RIIF2Grammar.FAIL_MODE,null);
            this.fm.putAssociative(associativeIndex,associative);
            this.fm = associative;

        }else
            this.fm = this.fm.getAssociative(associativeIndex);

        if ( !this.declaratorId.hasAssociativeIndex() )
            return;

        if (this.declaratorId.hasAttributeIndex()) {

            String attributeIndex = this.declaratorId.getAttributeIndex().getId();

            // if it is pre-defined attribute, then return other wise
            if (attributeIndex.equals(RIIF2Grammar.RATE)
                    || associativeIndex.equals(RIIF2Grammar.UNIT))
                return;

            // otherwise create an attribute with type Object....
            Attribute attribute
                    = PreDefinedAttribute.createAttribute(attributeIndex, RIIF2Grammar.OBJECT, null, this.recorder);
            this.fm.putAttribute(attributeIndex, attribute);
            this.fm = attribute;
        }
    }

    private Label<Label> createLabel(String associativeIndex, String string, Object o) throws FieldTypeNotMarchException {
        Label<Label> label = new FailMode(this.recorder);
        label.setName(associativeIndex);
        label.setType(string);
        label.setValue(o);

        label.setAttribute(true);
        PreDefinedAttribute.FMAttribute(label,this.recorder);

        return label;
    }

    private void createFailMode(String fmName) throws FieldTypeNotMarchException {
        this.fm = new FailMode(this.recorder);
        this.fm.setType(RIIF2Grammar.FAIL_MODE);
        this.fm.setName(fmName);
        PreDefinedAttribute.FieldAttribute(this.fm,this.recorder);

        if (this.declaratorId.hasTypeType() ){
            RIIF2Type TypeType = this.declaratorId.getTypeType();
            String typeType = TypeType.getType();

            if (typeType.equals(RIIF2Grammar.TYPE_ASSOCIATIVE))
                this.fm.setAssociative(true);

            if (typeType.equals(RIIF2Grammar.TYPE_VECTOR)) {
                Vector  vector = TypeType.getVector();
                Expression left = vector.getLeft();
                Expression right = vector.getRight();

                left.setCurrentLabel(this.fm);
                left.setRecorder(this.recorder);

                right.setCurrentLabel(this.fm);
                right.setRecorder(this.recorder);

                if (!left.isInteger())
                    throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MESSAGE,left.getLine(),left.getColumn());

                if (!right.isInteger())
                    throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MESSAGE,right.getLine(), right.getColumn());

                if ((int)left.getValue()<0 || (int)left.getValue() > (int)right.getValue())
                    throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MESSAGE, left.getLine(),left.getLine());
/*
                if ((int)right.getValue()> this.fm.getVectorLength())
                    throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MESSAGE,right.getLine(), right.getColumn());
*/
                this.fm.setVector(true);
                this.fm.setVectorLength(vector.getLength());
            }
        }

        this.fm.setAttribute(true);
        PreDefinedAttribute.FMAttribute(this.fm,this.recorder);
        this.recorder.addLabel(this.fm);
    }


    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {
        this.initializer();
        this.failModeDeclarator();
    }

    private void failModeDeclarator() throws VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {
        this.positionFm();
    }
}
