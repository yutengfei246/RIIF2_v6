package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.ChildComponentDeclarator;
import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.ChildComponent;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.util.Objects;

public class CCFactory {
    private RIIF2Recorder recorder;
    private Declarator declarator;

    private Label<ChildComponent> ccLabel;

    public CCFactory(RIIF2Recorder recorder) {
        this.recorder = recorder;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void commit() throws VeriableAlreadyExistException, SomeVariableMissingException {
        this.setUpDeclarator();
    }

    private void setUpDeclarator() throws VeriableAlreadyExistException, SomeVariableMissingException {
        ChildComponentDeclarator childComponentDeclarator
                = (ChildComponentDeclarator) this.declarator;

        RIIF2Type type = childComponentDeclarator.getCCType();
        String typeCcId = type.getCcId();

        if ( ! this.recorder.containsGlobalComponent(typeCcId))
            throw new SomeVariableMissingException();

        DeclaratorId declaratorId = childComponentDeclarator.getDeclaratorId();
        String id = declaratorId.getId();

        if ( !declaratorId.hasAssociativeIndex() )
            this.createCCLabel(id);
        else {
            if ( ! this.recorder.containsChildComponent(id))
                throw new SomeVariableMissingException();
            this.ccLabel = this.recorder.getChildComponent(id);
        }
        this.newCCDeclarator(childComponentDeclarator);
    }

    private void createCCLabel(String id) {
        this.ccLabel = new ChildComponent();

        this.ccLabel.setName(id);
        this.ccLabel.setType(RIIF2Grammar.TYPE_CC);
    }

    private void newCCDeclarator(ChildComponentDeclarator childComponentDeclarator) throws SomeVariableMissingException {
        DeclaratorId declaratorId
                = childComponentDeclarator.getDeclaratorId();

        if (declaratorId.hasAssociativeIndex()){
            Id associativeIndex = declaratorId.getAssociativeIndex();
            String id = associativeIndex.getId();

            if ( !this.ccLabel.isAssociative()
                    || this.ccLabel.containsAssociativeIndex(id) )
                throw new SomeVariableMissingException();

            ChildComponent childComponent = new ChildComponent();
            childComponent.setType(RIIF2Grammar.TYPE_CC);
            childComponent.setName( id );

            this.ccLabel.addAssoc(id, childComponent );
        }

        if (declaratorId.hasTypeType()){
            RIIF2Type typeType = declaratorId.getTypeType();
            if (Objects.equals(typeType.getType(), RIIF2Grammar.TYPE_VECTOR)){
                Vector vector =typeType.getVector();
                this.ccLabel.setVector(vector);

                for (int i= 0; i < this.ccLabel.getVectorLength(); i++)
                    this.ccLabel.addVectorItem( new ChildComponent());

            }
            if (Objects.equals(typeType.getType(), RIIF2Grammar.TYPE_ASSOCIATIVE)){
                this.ccLabel.setAssociative(true);
            }

            this.recorder.addLabel(this.ccLabel);
        }
    }
}
