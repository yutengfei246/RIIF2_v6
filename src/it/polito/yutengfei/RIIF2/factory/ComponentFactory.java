package it.polito.yutengfei.RIIF2.factory;

import it.polito.yutengfei.RIIF2.RIIF2Modules.Component;
import it.polito.yutengfei.RIIF2.factory.partsFactory.FieldFactory;
import it.polito.yutengfei.RIIF2.factory.partsFactory.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.factory.partsFactory.ImplExFactory;
import it.polito.yutengfei.RIIF2.factory.partsFactory.ImplExIdsNotExistException;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Recorder;


public class ComponentFactory implements Factory {
    private Component component = null;

    private ImplExFactory implExFactory = null;
    private FieldFactory fieldFactory = null;

    private RIIF2Recorder recorder;

    ComponentFactory(Recorder recorder) {
        this.recorder = (RIIF2Recorder) recorder;
    }

    public void start() {
        this.component = new Component();
    }

    public void setCurrentComponentIdentifier(String identifier) {
        this.component.setIdentifier( identifier );
        this.recorder.setIdentifier(identifier);
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
        this.recorder = this.implExFactory.getRIIF2Recorder();
        this.implExFactory = null;
    }

    public void startField() {
        this.fieldFactory = new FieldFactory(this.recorder);
    }

    public void setFieldType( int fieldType /*Parameter or Constant*/) {
        this.fieldFactory.setFieldType( fieldType );
    }

    public void setFieldIdentifier(String identifier) {
        this.fieldFactory.setIdentifier(identifier);
    }

    public void setFieldTypeType(int type /*Assoc Vector*/) {
        this.fieldFactory.setTypeType(type);
    }

    public void setFieldVector(int vecLeft, int vecRight) {
        this.fieldFactory.setVector(vecLeft,vecRight);
    }

    public void setFieldAttribute(boolean b) {
        this.fieldFactory.setAttribute( b );
    }

    public void setFieldAttributeIndex(String attributeIndex){
            this.fieldFactory.setAttributeIndex( attributeIndex );
    }

    public void setFieldAssociative(boolean b) {
        this.fieldFactory.setAssociative(b);
    }

    public void setFieldAssociativeIndex(String identifier) {
        this.fieldFactory.setAssociativeIndex( identifier );
    }

    public void setFieldVariableType(String type /*boolean double integer ...*/) {
        this.fieldFactory.setType(type);
    }

    public void setFieldVariableType(String userDefined, String identifier) {
        this.fieldFactory.setType(userDefined,identifier);
    }

    public void addFieldEnumType(String entityEnum) {
        this.fieldFactory.addEnumType( entityEnum );
    }

    public void setFieldInitializerType(int initializerType /*List Array Expression*/) {
        this.fieldFactory.setInitializerType( initializerType );
    }

    public void setFieldInitializer(Object entityInitializer) {
        this.fieldFactory.setInitializer( entityInitializer );
    }

    public void commitField(/*void*/) { /*checker and updater*/
        try {
            this.fieldFactory.commit();
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
        }
        this.recorder = this.fieldFactory.getRIIF2Recorder();
        this.fieldFactory = null /*Reset the fieldFactory*/;
    }

    public void commit() {
    }

    @Override
    public RIIF2Recorder getRIIF2Recorder() {
        return this.recorder;
    }

    public void productComponent() {
    }

    public static class Self {
    }


}
