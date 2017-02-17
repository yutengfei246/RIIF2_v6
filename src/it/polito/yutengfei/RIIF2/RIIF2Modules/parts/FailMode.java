package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;


import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;

public class FailMode extends Label<Label> {

    public FailMode(RIIF2Recorder recorder) {
        super(recorder);
    }

    @Override
    public void vectorInitializer(String name, String type, Object value ) {
        int length = super.getVectorLength();

        for (int i= 0; i < length ; i++ ) {
            FailMode fm = new FailMode(super.getRecorder());
            fm.setName(name);
            fm.setType(type);
            super.assignVectorItem(i, fm);
        }
    }


    @Override
    public void print() {
        System.out.print("Fail_Mode " + this.getName());

        super.printAttribute();
        super.printAssociative();
    }

    @Override
    public String getLiteral() {
        return null;
    }
}
