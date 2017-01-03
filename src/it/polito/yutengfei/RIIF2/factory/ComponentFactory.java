package it.polito.yutengfei.RIIF2.factory;

import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.Component;
import it.polito.yutengfei.RIIF2.factory.partsFactory.*;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Recorder;


public class ComponentFactory {

    private Component component = null;

    private ImplExFactory implExFactory = null;
    private FieldFactory fieldFactory = null;
    private CCFactory ccFactory = null;
    private FMFactory fmFactory = null;
    private AISFactory AISFactoy = null;
    private PlatformFactory platformFactory;

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
        this.implExFactory = new ImplExFactory(this.recorder);
    }

    public void setCurrentComponentExtendsIdentifier(String identifier) {
        this.implExFactory.addExtendsId(identifier);
    }

    public void setCurrentComponentImplementsIdentifier(String identifier) {
        this.implExFactory.addImplsId(identifier);
    }

    public void commitImplEx(/*void*/) { /*checker and updater*/
        this.implExFactory.commit();
        this.implExFactory = null;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public Declarator getDeclarator(){
        return this.declarator;
    }

    public void startField() {
        this.fieldFactory = new FieldFactory(this,this.recorder);
    }

    public void setFieldType(RIIF2Type fieldType /*Parameter or Constant*/) {
        this.fieldType = fieldType;
    }

    public RIIF2Type getFieldType() {
        return this.fieldType;
    }

    public void commitField(/*void*/) { /*checker and updater*/
        try {
            try {
                this.fieldFactory.commit();
            } catch (InvalidFieldDeclaration | VeriableAlreadyExistException | SomeVariableMissingException invalidFieldDeclaration) {
                invalidFieldDeclaration.printStackTrace();
            }
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
        }
        this.fieldFactory = null /*Reset the fieldFactory*/;
        this.fieldType = null;
    }

    public void startCC() {
        this.ccFactory = new CCFactory(this.recorder);
    }

    public void commitCC() {
        try {
            this.ccFactory.commit();
        } catch (VeriableAlreadyExistException | SomeVariableMissingException e) {
            e.printStackTrace();
        }
        this.ccFactory = null ;
    }

    public void startFailMode() {
        this.fmFactory = new FMFactory( this.recorder );
    }

    public void commitFM() {
        try {
            this.fmFactory.commit();
        } catch (VeriableAlreadyExistException e) {
            e.printStackTrace();
        }
        this.fmFactory = null;
    }

    public void startAIS(String assignment) {
        this.AISFactoy = new AISFactory(assignment, this.recorder);
    }

    public void commitAIS() {
        try {
            this.AISFactoy.commit();
        } catch (FieldTypeNotMarchException | SomeVariableMissingException e) {
            e.printStackTrace();
        }
        this.AISFactoy = null;
    }

    public void startPlatform(String identifier) {
        this.platformFactory = new PlatformFactory(identifier, this.recorder);
    }

    public void commitPlatform() {
        try {
            this.platformFactory.commit();
        } catch (VeriableAlreadyExistException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        this.productComponent();
    }

    private void productComponent() {

    }



}
