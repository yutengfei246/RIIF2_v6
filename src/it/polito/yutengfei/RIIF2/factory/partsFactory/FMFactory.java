package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.Declarator.FailModeDeclarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.FailMode;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.util.Objects;

public class FMFactory {

    private RIIF2Recorder recorder;
    private Declarator declarator;

    private FailMode fm;

    public FMFactory(RIIF2Recorder recorder) {
        this.recorder = recorder;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void commit() throws VeriableAlreadyExistException {
        this.failModeDeclarator(this.declarator);
    }

    private void failModeDeclarator(Declarator declarator) throws VeriableAlreadyExistException {
        FailModeDeclarator failModeDeclarator
                = (FailModeDeclarator) declarator;

        DeclaratorId declaratorId = failModeDeclarator.getDeclaratorId();
        String identifier = declaratorId.getId();

        if ( !declaratorId.hasAssociativeIndex()
                && !declaratorId.hasAttributeIndex()) {
            if (this.recorder.contains( identifier ) )
                throw new VeriableAlreadyExistException();

            this.createFM(identifier,declaratorId);
        }else
            this.fm = this.recorder.getFailMode( identifier);

        this.newFM(declaratorId);
    }

    private void newFM(DeclaratorId declaratorId) throws VeriableAlreadyExistException {

        if (declaratorId.hasAttributeIndex()){
            Id attributeId = declaratorId.getAttributeIndex();

            /*fail_mode sdf[Ins]'srasd; */
            if (declaratorId.hasAssociativeIndex() ){
                Id associativeId = declaratorId.getAssociativeIndex();
                String id= associativeId.getId();
                if (this.fm.containsAssociativeIndex(id) )
                    throw new VeriableAlreadyExistException();

                FailMode failMode = new FailMode();
                failMode.setName( id );
                failMode.setType( RIIF2Grammar.FAIL_MODE);
                failMode.addAttribute(this.createAttribute(attributeId));
                this.fm.addAssoc(id, failMode);

            }else {
                if (declaratorId.hasTypeType())
                this.fm.addAttribute(this.createAttribute(attributeId));


            }
        }else {
            if (declaratorId.hasAssociativeIndex()){
                Id associativeId = declaratorId.getAssociativeIndex();
                String id= associativeId.getId();
                if (this.fm.containsAssociativeIndex(id) )
                    throw new VeriableAlreadyExistException();

                FailMode failMode = new FailMode();
                failMode.setName( id );
                failMode.setType( RIIF2Grammar.FAIL_MODE);
                this.fm.addAssoc(id, failMode);
            }else
                this.recorder.addLabel( this.fm );
        }




    }

    private Attribute createAttribute(Id attributeId) {

    }

    private void createFM(String identifier, DeclaratorId declaratorId) {
        this.fm = new FailMode();
        this.fm.setName( identifier );
        this.fm.setType( RIIF2Grammar.FAIL_MODE );

        if (declaratorId.hasTypeType()){
            RIIF2Type type = declaratorId.getTypeType();
            if (Objects.equals(type.getType(), RIIF2Grammar.TYPE_ASSOCIATIVE)) {
                this.fm.setAssociative(true);

                if (declaratorId.hasAttributeIndex()){

                }

            }
            if (Objects.equals(type.getType(), RIIF2Grammar.TYPE_VECTOR)){
                this.fm.setVector( type.getVector() );
                for (int i=0 ; i< this.fm.getVectorLength() ; i++)
                    this.fm.addVectorItem( new FailMode() );

                if (declaratorId.hasAttributeIndex()){

                }
            }
        }
    }
}
