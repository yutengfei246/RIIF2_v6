package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.FailModeDeclarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.FailMode;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.util.Objects;

public class FMFactory implements Factory {

    private final RIIF2Recorder recorder;
    private final ComponentFactory componentFactory;

    private DeclaratorId declaratorId;

    private FailMode fm;

    public FMFactory(ComponentFactory componentFactory, RIIF2Recorder recorder) {
        this.recorder = recorder;
        this.componentFactory = componentFactory;
    }

    private void initializer() {
        FailModeDeclarator failModeDeclarator = (FailModeDeclarator) this.componentFactory.getDeclarator();
        this.declaratorId  = failModeDeclarator.getDeclaratorId();
    }


    //Done
    private void failModeDeclarator()
            throws FieldTypeNotMarchException ,
                    InvalidFieldDeclaration,
                    SomeVariableMissingException,
                    VeriableAlreadyExistException {

        String fmName = this.declaratorId.getId();

        /*fail_mode fm fail_mode fm[]  fail_mode[1:6] */
        if ( !declaratorId.hasAttributeIndex() && !declaratorId.hasAssociativeIndex() ) {

            if (this.recorder.contains(fmName))
                throw new VeriableAlreadyExistException();

            this.createFailMode(fmName);
            this.recorder.addLabel(this.fm);
        }else {
            /*other cases to search in recorder and add those properties into recorder*/
            if (!this.recorder.containsFailMode(fmName))
                throw new SomeVariableMissingException();

            this.fm = this.recorder.getFailMode(fmName);
        }

        if (declaratorId.hasAssociativeIndex() && declaratorId.hasAttributeIndex())
            this.newFailModeDeclarator2();
        else
            this.newFailModeDeclarator1();
    }

    /*Identifier typeType ? attribute ?*/
    private void newFailModeDeclarator1() {

        if (!this.declaratorId.hasAttributeIndex()){
            /*in this case we need to create associated typeType to the label*/
            if (this.declaratorId.hasTypeType()){
                RIIF2Type typeType = this.declaratorId.getTypeType();
                if (Objects.equals(typeType.getType(), RIIF2Grammar.TYPE_ASSOCIATIVE))
                    this.fm.setAssociative(true);

                if (Objects.equals(typeType.getType(), RIIF2Grammar.TYPE_VECTOR)) {
                    Vector vector = typeType.getVector();
                    this.fm.setVector(vector);
                }
            }

        }else{
            //TODO:: has attribute
            if (this.declaratorId.hasTypeType()){

            }else{

            }
        }
    }

    /*DeclaratorId :: Identifier associativeIndex attributeIndex*/
    /*Initializer :: list expression array*/
    //Done
    private void newFailModeDeclarator2()
            throws SomeVariableMissingException,
            VeriableAlreadyExistException,
            FieldTypeNotMarchException {
         /*retrieve the associativeIndex from the label if not exits throw an exception*/
        Id associativeIndexId = declaratorId.getAssociativeIndex();
        String associativeIndex  = associativeIndexId.getId();

        if (!this.fm.containsAssociativeIndex(associativeIndex))
            throw new SomeVariableMissingException();

        this.fm = this.fm.getAssociative(associativeIndex);

        Id attributeIndexId = declaratorId.getAttributeIndex();
        String attributeIndex = attributeIndexId.getId();

        if (this.fm.containsAttributeIndex(attributeIndex))
            throw new VeriableAlreadyExistException();

        Attribute attribute = new Attribute();
        this.initialAttribute(attribute,attributeIndex);

        this.fm.putAttribute(attributeIndex,attribute);
    }

    private void createFailMode(String fmName) {
        this.fm = new FailMode();
        this.fm.setType(RIIF2Grammar.FAIL_MODE);
        this.fm.setName(fmName);
    }

    private void initialAttribute(Attribute attribute, String attributeIndex) throws FieldTypeNotMarchException {

        attribute.setId(attributeIndex);
        if (Objects.equals(attributeIndex, RIIF2Grammar.RATE))
            attribute.setType(RIIF2Grammar.DOUBLE);
        else attribute.setType(RIIF2Grammar.STRING);
    }

    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, InvalidFieldDeclaration, FieldTypeNotMarchException {
        this.initializer();
        this.failModeDeclarator();
    }
}
