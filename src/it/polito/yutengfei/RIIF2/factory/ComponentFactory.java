package it.polito.yutengfei.RIIF2.factory;

import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.factory.partsFactory.*;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Recorder;


public class ComponentFactory {

    private Factory factory;

    private RIIF2Recorder recorder;

    private RIIF2Type fieldType;
    private Declarator declarator;

    ComponentFactory(Recorder recorder) {
        this.recorder = (RIIF2Recorder) recorder;
    }

    public void start(String identifier) {
        this.recorder.setIdentifier( identifier );
    }

    public void startImplEx() {
        this.factory = new ImplExFactory(this.recorder);
    }

    public void setCurrentComponentExtendsIdentifier(String identifier) {
        ((ImplExFactory)this.factory).addExtendsId(identifier);
    }

    public void setCurrentComponentImplementsIdentifier(String identifier) {
        ((ImplExFactory)this.factory).addImplsId(identifier);
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public Declarator getDeclarator(){
        return this.declarator;
    }

    public void startField() {
        this.factory = new FieldFactory(this,this.recorder);
    }

    public void setFieldType(RIIF2Type fieldType /*Parameter or Constant*/) {
        this.fieldType = fieldType;
    }

    public RIIF2Type getFieldType() {
        return this.fieldType;
    }

    public void startCC() {
        this.factory = new CCFactory(this,this.recorder);
    }

    public void startFailMode() {
        this.factory = new FMFactory( this,this.recorder );
    }

    public void startAIS(String assignment) {
        this.factory = new AISFactory(this, assignment, this.recorder);
    }

    public void startPlatform(String identifier) {
        this.factory = new PlatformFactory(identifier, this.recorder);
    }

    public void commitFactory(/*void*/) { /*checker and updater*/
        try {
            this.factory.commit();
        } catch (SomeVariableMissingException
                | VeriableAlreadyExistException
                | FieldTypeNotMarchException
                | InvalidFieldDeclaration e) {
            e.printStackTrace();
        }
        this.factory = null /*Reset the fieldFactory*/;
        this.fieldType = null;
    }

    public void commit() {
        this.productComponent();
    }

    private void productComponent() {

    }



}
