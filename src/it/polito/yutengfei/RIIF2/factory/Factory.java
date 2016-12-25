package it.polito.yutengfei.RIIF2.factory;

import it.polito.yutengfei.RIIF2.recoder.Recorder;

/**
 * Created by yutengfei on 09/12/16.
 */
public interface Factory extends Recorder {
    static ComponentFactory newComponentFactory(Recorder recorder) {
        return new ComponentFactory( recorder );
    }
}
