package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;


import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

public class ChildComponent extends Label<Label> {

    public ChildComponent(RIIF2Recorder recorder) {
        super(recorder);
    }

    @Override
    public void vectorInitializer(String name, String type, Object value) {
        int length = super.getVectorLength();
        try {
            for (int i = 0; i < length; i++) {
                ChildComponent cc = new ChildComponent(super.getRecorder());
                cc.setName(RIIF2Grammar.ARRAY_ITEM);
                cc.setType(type);
                cc.setValue(value);

                super.assignVectorItem(i, cc);
                super.assignVectorValue(i, i, super.getValue());
            }
        }
        catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {


        System.out.println("child_component " + this.getName() + "--------------------------------------" );

        if (this.isAssociative())
            super.printAssociative();

        else if (this.isVector())
            super.printVector();

        else {

            if (  (super.getValue()) != null)
                ((RIIF2Recorder) super.getValue()).print8();
            else
                System.out.print(" null ");
        }

        System.out.println("-------------------------------------------------child_component " + this.getName());
    }

    @Override
    public String getLiteral() {
        return null;
    }
}
