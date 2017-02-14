package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;


import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

public class ChildComponent extends Label<Label> {

    public ChildComponent(RIIF2Recorder recorder) {
        super(recorder);
    }

    @Override
    public void vectorInitializer() {
        int length = super.getVectorLength();

        for ( int i =0 ; i< length ; i++) {
            ChildComponent cc = new ChildComponent(super.getRecorder());
            cc.setName(RIIF2Grammar.ARRAY_ITEM);
            super.assignVectorItem(i,cc);
            try {
                super.assignVectorValue(i,i,super.getValue());
            } catch (FieldTypeNotMarchException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void print() {
        System.out.println("child component " + this.getName() + " --------->>");

        if (this.isVector())
            super.printVector();
        else {

            if (  (super.getValue()) != null)
                ((RIIF2Recorder) super.getValue()).print8();
            else
                System.out.print(" null ");
        }

        System.out.println(" <<-----------child component " + this.getName());
    }

    @Override
    public String getLiteral() {
        return null;
    }
}
