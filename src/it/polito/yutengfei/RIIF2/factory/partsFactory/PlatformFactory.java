package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Platform;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.SomeVariableMissingException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.VeriableAlreadyExistException;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;


public class PlatformFactory implements Factory{
    private final String identifier;
    private RIIF2Recorder recorder;

    public PlatformFactory(String identifier, RIIF2Recorder recorder) {
        this.recorder = recorder;
        this.identifier = identifier;
    }


    private Platform createPlatform() {
        Platform platform = new Platform();
        platform.setName(this.identifier);

        return platform;
    }

    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {

        if (this.recorder.contains(identifier) )
            throw new VeriableAlreadyExistException(identifier);

        this.recorder.setPlatform( this.createPlatform() );
    }
}
