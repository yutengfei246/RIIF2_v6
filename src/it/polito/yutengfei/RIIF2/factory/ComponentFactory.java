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

    private RIIF2Recorder recorder;

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
        try {
            this.implExFactory.commit();
        } catch (ImplExIdsNotExistException e) {
            e.printStackTrace();
            System.exit(0);
        }
        this.implExFactory = null;
    }

    public void startField() {
        this.fieldFactory = new FieldFactory(this.recorder);
    }

    public void setFieldType(RIIF2Type fieldType /*Parameter or Constant*/) {
        this.fieldFactory.setFieldType( fieldType );
    }

    public void setFieldDeclarator(Declarator fieldDeclarator) {
        this.fieldFactory.setDeclarator( fieldDeclarator );
    }

    public void commitField(/*void*/) { /*checker and updater*/
        try {
            try {
                this.fieldFactory.commit();
            } catch (InvalidFieldDeclaration invalidFieldDeclaration) {
                invalidFieldDeclaration.printStackTrace();
            } catch (VeriableAlreadyExistException e) {
                e.printStackTrace();
            } catch (SomeVariableMissingException e) {
                e.printStackTrace();
            }
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
        }
        this.fieldFactory = null /*Reset the fieldFactory*/;
    }

    public void commit() {
        this.productComponent();
    }

    private void productComponent() {
    }

}
