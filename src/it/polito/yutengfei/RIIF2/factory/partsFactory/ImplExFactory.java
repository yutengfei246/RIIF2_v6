package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;

import java.util.ArrayList;
import java.util.List;


public class ImplExFactory  {

    private List<String> eXIdentifiers = null ;
    private List<String> implIdentifiers = null;

    private RIIF2Recorder recorder;

    public ImplExFactory(RIIF2Recorder recorder){
        this.recorder = recorder;
    }

    public void addExtendsId(String identifier) {
        if (eXIdentifiers == null)
            this.eXIdentifiers = new ArrayList<>();

        this.eXIdentifiers.add(identifier);
    }

    public void addImplsId(String identifier) {
        if (this.implIdentifiers == null)
            this.implIdentifiers = new ArrayList<>();

        this.implIdentifiers.add(identifier);
    }

    // check if the name has registered in the recorder
    public void commit() throws ImplExIdsNotExistException {

        if ( eXIdentifiers != null) {
            for (String exId : this.eXIdentifiers){
                if (!this.recorder.containsComponent(exId)){
                    throw new ImplExIdsNotExistException( exId );
                }
                this.recorder.seteXIdentifiers( this.eXIdentifiers );
            }
        }

        if ( implIdentifiers != null) {
            for (String implId : this.implIdentifiers){
                if( !this.recorder.containsTemplate(implId)){
                    throw new ImplExIdsNotExistException( implId );
                }
            }
        }
        this.recorder.setImplIdentifiers( this.implIdentifiers );
    }

}
