package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;


import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;

public class ChildComponent extends Label<Label> {

    public ChildComponent(RIIF2Recorder recorder) {
        super(recorder);
    }


    @Override
    public void print() {
        System.out.println("child component " + this.getName() + " --------->>");

        ((RIIF2Recorder)super.getValue()).print8();

        System.out.println(" <<-----------child component " + this.getName());
    }
}
