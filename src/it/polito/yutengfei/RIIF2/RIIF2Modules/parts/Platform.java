package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;


import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;


public class Platform extends Label<Label>{

    public Platform(RIIF2Recorder recorder) {
        super(recorder);
    }

    @Override
    public void vectorInitializer() {
        int length = super.getVectorLength();

        for ( int i =0 ; i < length ; i++){
            Platform platform = new Platform(super.getRecorder());
            super.assignVectorItem(i,platform);
        }
    }

    public void setPlatform(RIIF2Recorder recorder) {
        try {
            super.setValue(recorder);
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
        }
    }

    public RIIF2Recorder getPlatform() {
        return (RIIF2Recorder) super.getValue();
    }

    @Override
    public void print() {

        System.out.print("Platform " + getName() );
        if (getValue() != null ){
            System.out.print(" Value-Component " + super.getValue());
        }

        System.out.println();

    }
}
