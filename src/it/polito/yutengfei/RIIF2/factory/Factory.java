package it.polito.yutengfei.RIIF2.factory;

import it.polito.yutengfei.RIIF2.recoder.Recorder;

public interface Factory {
    static ComponentFactory newComponentFactory(Recorder recorder) {
        return new ComponentFactory( recorder );
    }
}
