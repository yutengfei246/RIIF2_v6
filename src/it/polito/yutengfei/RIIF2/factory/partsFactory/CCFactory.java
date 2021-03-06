package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.ChildComponentDeclarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.ChildComponent;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.SomeVariableMissingException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.VeriableAlreadyExistException;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Repository;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

public class CCFactory implements Factory {
    private final ComponentFactory componentFactory;
    private final RIIF2Recorder recorder;

    private Label<Label> ccLabel;

    private DeclaratorId declaratorId;
    private RIIF2Type ccType;

    public CCFactory(ComponentFactory componentFactory, RIIF2Recorder recorder) {
        this.componentFactory = componentFactory;
        this.recorder = recorder;
    }

    private void initializer() {
        ChildComponentDeclarator childComponentDeclarator = (ChildComponentDeclarator) this.componentFactory.getDeclarator();
        this.declaratorId = childComponentDeclarator.getDeclaratorId();
        this.ccType = childComponentDeclarator.getCCType();
    }

    private void positionCC() throws SomeVariableMissingException, FieldTypeNotMarchException {
        String typeCcId = this.ccType.getValue();

        if ( !Repository.containsComponent(typeCcId))
            throw new SomeVariableMissingException(typeCcId,
                    this.ccType.getLine(), this.ccType.getColumn());

        RIIF2Recorder recorder
                = (RIIF2Recorder) Repository.getDeepCopedRecorderFromComponentRepository( typeCcId );

        String id = this.declaratorId.getId();

        if ( !this.declaratorId.hasAssociativeIndex()  ) {
            this.createCCLabel(id, recorder);

        } else{
            if ( !this.recorder.containsChildComponent(id))
                throw new SomeVariableMissingException(id,
                        this.declaratorId.getLine(), this.declaratorId.getColumn());

            this.ccLabel = this.recorder.getChildComponent(id);

            String associativeIndex = this.declaratorId.getAssociativeIndex().getId();
            if ( !this.ccLabel.isAssociative()
                    || this.ccLabel.containsAssociativeIndex(associativeIndex) )
                throw new FieldTypeNotMarchException(id,
                        this.declaratorId.getLine(), this.declaratorId.getColumn());

            Label<Label> associativeLabel
                    = this.createCCLabel1(associativeIndex,recorder);

            this.ccLabel.putAssoc(associativeIndex,associativeLabel);
        }


    }

    private Label<Label> createCCLabel1(String associativeIndex, RIIF2Recorder recorder) {
        Label<Label> label = new ChildComponent();

        label.setName(associativeIndex);
        label.setType(RIIF2Grammar.TYPE_CC);
        label.setValue(recorder);

        return label;
    }

    private void createCCLabel(String id, RIIF2Recorder recorder) throws FieldTypeNotMarchException {
        this.ccLabel = new ChildComponent();

        this.ccLabel.setName(id);
        this.ccLabel.setType(RIIF2Grammar.TYPE_CC);
        this.ccLabel.setValue(recorder);

        if ( this.declaratorId.hasTypeType() ){

            RIIF2Type TypeType = this.declaratorId.getTypeType();
            String typeType = TypeType.getType();

            if (typeType.equals(RIIF2Grammar.TYPE_ASSOCIATIVE))
                this.ccLabel.setAssociative(true);

            if (typeType.equals(RIIF2Grammar.TYPE_VECTOR) )
                this.ccLabel.setVector(TypeType.getVector(),this.recorder);
        }

        this.recorder.addLabel(this.ccLabel);
    }

    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {
        this.initializer();
        this.childComponentDeclarator();
    }

    private void childComponentDeclarator() throws VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {

        this.positionCC();
    }
}
