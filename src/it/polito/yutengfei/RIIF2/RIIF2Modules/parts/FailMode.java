package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;


import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;

public class FailMode extends Label<Label> {

    public FailMode(RIIF2Recorder recorder) {
        super(recorder);
    }


    @Override
    public void print() {
        System.out.print("Fail_Mode " + this.getName());

        super.printAttribute();
        super.printAssociative();
    }
}
