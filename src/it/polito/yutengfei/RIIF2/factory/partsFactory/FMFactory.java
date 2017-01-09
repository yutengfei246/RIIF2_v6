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
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

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

    private void positionFm() throws VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {

        String fmName = this.declaratorId.getId();

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

        if (declaratorId.hasAssociativeIndex() && declaratorId.hasAttributeIndex())
            this.positionFmForFailModeDeclarator2();
        else
            this.positionFmForFailModeDeclarator1();

    }

    /**
     *  Declarator :: Identifier typeType ? attribute ?
     * */
    private void positionFmForFailModeDeclarator1() {

        if (this.declaratorId.hasAttributeIndex()){

            String attributeIndex = this.declaratorId.getAttributeIndex().getId();
            Attribute attribute = PreDefinedAttribute.createAttribute(attributeIndex,
                    RIIF2Grammar.STRING, null);

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

        if ( !this.fm.containsAssociativeIndex(associativeIndex)){
            Label<Label> associative = this.createLabel(associativeIndex,RIIF2Grammar.FAIL_MODE,null);
            this.fm.putAssoc(associativeIndex,associative);
            this.fm = associative;
        }else
            this.fm = this.fm.getAssociative(associativeIndex);

        if ( !this.declaratorId.hasAssociativeIndex() )
            return;

        String attributeIndex = this.declaratorId.getAttributeIndex().getId();

        if (attributeIndex.equals(RIIF2Grammar.RATE)
                || associativeIndex.equals(RIIF2Grammar.UNIT))
            return;

        Attribute attribute
                = PreDefinedAttribute.createAttribute(attributeIndex,RIIF2Grammar.STRING,null);
        this.fm.putAttribute(attributeIndex,attribute);
        this.fm = attribute;
    }

    private Label<Label> createLabel(String associativeIndex, String string, Object o) {
        Label<Label> label = new FailMode();
        label.setName(associativeIndex);
        label.setType(string);
        label.setValue(o);

        return label;
    }

    private void createFailMode(String fmName) {
        this.fm = new FailMode();
        this.fm.setType(RIIF2Grammar.FAIL_MODE);
        this.fm.setName(fmName);

        if (this.declaratorId.hasTypeType() ){
            RIIF2Type TypeType = this.declaratorId.getTypeType();
            String typeType = TypeType.getType();

            if (typeType.equals(RIIF2Grammar.TYPE_ASSOCIATIVE))
                this.fm.setAssociative(true);

            if (typeType.equals(RIIF2Grammar.TYPE_VECTOR))
                this.fm.setValue(TypeType.getVector());
        }

        PreDefinedAttribute.FMAttribute(this.fm);
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
