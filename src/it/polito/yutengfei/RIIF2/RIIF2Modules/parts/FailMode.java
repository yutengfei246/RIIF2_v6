package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;


import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;

public class FailMode extends Label<Label> {

    public FailMode(RIIF2Recorder recorder) {
        super(recorder);
    }

    @Override
    public void setPlatform(RIIF2Recorder recorder) {

    }

    @Override
    public RIIF2Recorder getPlatform() {
        return null;
    }

    @Override
    public void print() {
        System.out.print("Fail_Mode ");

        System.out.println("<----Start Attribute--->");
        super.printAttribute();
        System.out.println("<-----End Attribute --->");

        System.out.println("<----Start Associative --->");
        super.printAssociative();
        System.out.println("<-----End Associative --->");
    }
}
