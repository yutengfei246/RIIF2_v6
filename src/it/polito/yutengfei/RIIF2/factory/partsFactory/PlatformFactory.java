package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Platform;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;


public class PlatformFactory {
    private final String identifier;
    private RIIF2Recorder recorder;

    public PlatformFactory(String identifier, RIIF2Recorder recorder) {
        this.recorder = recorder;
        this.identifier = identifier;
    }

    public void commit() throws VeriableAlreadyExistException {

        if (this.recorder.contains(identifier) )
            throw new VeriableAlreadyExistException();

        this.recorder.setPlatform( this.createPlatform() );
    }

    private Platform createPlatform() {
        Platform platform = new Platform();
        platform.setName(this.identifier);

        return platform;
    }
}
