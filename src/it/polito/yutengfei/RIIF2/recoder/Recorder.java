package it.polito.yutengfei.RIIF2.recoder;

public interface Recorder extends Repository{

    static void record(Recorder recorder){
        if (recorder instanceof RIIF2Recorder){
            if (((RIIF2Recorder) recorder).isTemplate()) Repository.putTemp(((RIIF2Recorder) recorder).getIdentifier(),recorder);
            else Repository.putComponent(((RIIF2Recorder) recorder).getIdentifier(),recorder);
        }
    }

    void javaBean();
    RIIF2Recorder getRIIF2Recorder();
}
