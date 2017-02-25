package it.polito.yutengfei.RIIF2.factory;

import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.SomeVariableMissingException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.VeriableAlreadyExistException;
import it.polito.yutengfei.RIIF2.factory.partsFactory.EnvironmentFactory;
import it.polito.yutengfei.RIIF2.recoder.Recorder;

public interface Factory {
    static ComponentFactory newComponentFactory(Recorder recorder) {
        return new ComponentFactory( recorder );
    }

    static EnvironmentFactory newEnvironmentFactory(Recorder recorder) {
        return new EnvironmentFactory(recorder);
    }

    void commit() throws SomeVariableMissingException, VeriableAlreadyExistException,  FieldTypeNotMarchException;
}
