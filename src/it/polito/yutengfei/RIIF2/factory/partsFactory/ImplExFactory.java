package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Repository;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.util.ArrayList;
import java.util.List;


public class ImplExFactory  implements Factory{

    private final String key;

    private List<String> eXIdentifiers = null ;
    private List<String> implIdentifiers = null;

    private RIIF2Recorder recorder;

    public ImplExFactory(String key, RIIF2Recorder recorder){
        this.recorder = recorder;
        this.key = key;
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
    @Override
    public void commit() {
        if (key.equals(RIIF2Grammar.COMPONENT) ) {

            if (eXIdentifiers != null) {
                this.eXIdentifiers.forEach(s -> {
                    if (!Repository.containsComponent(s))
                        throw new IllegalArgumentException();

                    RIIF2Recorder recorder
                            = (RIIF2Recorder) Repository.getDeepCopedRecorderFromComponentRepository(s);
                    this.recorder.putExRecorder(s, recorder);
                });
            }

            if (implIdentifiers != null) {
                this.implIdentifiers.forEach(s -> {
                    if (!Repository.containsTemplate(s))
                        throw new IllegalArgumentException();

                    RIIF2Recorder recorder
                            = (RIIF2Recorder) Repository.getDeepCopedRecorderFromTemplateRepository(s);
                    this.recorder.putImplRecorder(s, recorder);
                });
            }
        }

        if (key.equals(RIIF2Grammar.TEMPLATE)){

            if (eXIdentifiers != null){

                this.eXIdentifiers.forEach(s -> {
                    if (!Repository.containsTemplate(s))
                        throw new IllegalArgumentException();

                    RIIF2Recorder recorder
                            = (RIIF2Recorder) Repository.getDeepCopedRecorderFromTemplateRepository(s);
                    this.recorder.putExRecorder(s, recorder);

                });
            }
        }
    }


}
