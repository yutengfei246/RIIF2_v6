package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.ChildComponentDeclarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.ChildComponent;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Repository;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.util.Objects;

public class CCFactory implements Factory {
    private final ComponentFactory componentFactory;
    private final RIIF2Recorder recorder;

    private Label<ChildComponent> ccLabel;

    private ChildComponentDeclarator childComponentDeclarator;
    private DeclaratorId declaratorId;

    public CCFactory(ComponentFactory componentFactory, RIIF2Recorder recorder) {
        this.componentFactory = componentFactory;
        this.recorder = recorder;
    }

    private void initializer() {
        this.childComponentDeclarator = (ChildComponentDeclarator) this.componentFactory.getDeclarator();
        this.declaratorId = this.childComponentDeclarator.getDeclaratorId();
    }



    private void childComponentDeclarator() throws VeriableAlreadyExistException, SomeVariableMissingException {

        RIIF2Type type = childComponentDeclarator.getCCType();
        String typeCcId = type.getValue();

        if ( !Repository.containsComponent(typeCcId))
            throw new SomeVariableMissingException();

        RIIF2Recorder recorder
                = (RIIF2Recorder) Repository.getDeepCopedRecorderFromComponentRepository( typeCcId );

        String id = declaratorId.getId();
        /* child_component cc cc1 */
        /* child_component cc cc1[] */
        /* child_component cc cc1[1:6] */
        if ( !declaratorId.hasAssociativeIndex()  ) {
            this.createCCLabel(id,recorder);

            if (declaratorId.hasTypeType()) {
                RIIF2Type typeType = declaratorId.getTypeType();
                String typeName = typeType.getType();
                if (Objects.equals(typeName, RIIF2Grammar.TYPE_ASSOCIATIVE))
                    this.ccLabel.setAssociative(true);
                if (Objects.equals(typeName, RIIF2Grammar.TYPE_VECTOR)) {
                    Vector vector = typeType.getVector();
                    this.ccLabel.setValue(vector);
                }
            }

            this.recorder.addLabel(this.ccLabel);

        }else { /*child_component cc cc1[index] */
            if ( ! this.recorder.containsChildComponent(id))
                throw new SomeVariableMissingException();

            this.ccLabel = this.recorder.getChildComponent(id);
            this.newChildComponentIndex(recorder);
        }
    }

    private void newChildComponentIndex(RIIF2Recorder recorder)
            throws SomeVariableMissingException {

            Id associativeIndex = declaratorId.getAssociativeIndex();
            String id = associativeIndex.getId();

            if ( !this.ccLabel.isAssociative()
                    || this.ccLabel.containsAssociativeIndex(id) )
                throw new SomeVariableMissingException();

            ChildComponent childComponent = new ChildComponent();
            childComponent.setType(RIIF2Grammar.TYPE_CC);
            childComponent.setName( id );
            childComponent.setValue(recorder);
            this.ccLabel.putAssoc(id, childComponent);

    }

    private void createCCLabel(String id, RIIF2Recorder recorder) {
        this.ccLabel = new ChildComponent();

        this.ccLabel.setName(id);
        this.ccLabel.setType(RIIF2Grammar.TYPE_CC);
        this.ccLabel.setValue(recorder);
    }

    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException {
        this.initializer();
        this.childComponentDeclarator();
    }
}
