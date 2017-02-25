package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.Recorder;

public class EnvironmentFactory extends ComponentFactory{

    RIIF2Type inputOutput ;

    public EnvironmentFactory(Recorder recorder) {
        super(recorder);
    }

    public void setInputOutput(RIIF2Type riif2Type){
        this.inputOutput = riif2Type;
    }

    public RIIF2Type getInputOutput() {
        return this.inputOutput;
    }


}
