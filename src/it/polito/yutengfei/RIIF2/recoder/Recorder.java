package it.polito.yutengfei.RIIF2.recoder;

import it.polito.yutengfei.RIIF2.mysql.SQLConnector;

public interface Recorder extends Repository{

    static void record(Recorder recorder){
        if (recorder instanceof RIIF2Recorder){
            if (((RIIF2Recorder) recorder).isTemplate()) Repository.putTemp(((RIIF2Recorder) recorder).getIdentifier(),recorder);
            else if (((RIIF2Recorder) recorder).isEnvironment()) Repository.putEnv(((RIIF2Recorder) recorder).getIdentifier(),recorder);
            else if (((RIIF2Recorder) recorder).isRequirement()) Repository.putRequirement(((RIIF2Recorder) recorder).getIdentifier(),recorder);
            else if (((RIIF2Recorder) recorder).isBind()) Repository.putBind(((RIIF2Recorder) recorder).getIdentifier(),recorder);
            else  Repository.putComponent(((RIIF2Recorder) recorder).getIdentifier(),recorder);
        }
    }

    void generateDB(SQLConnector sqlConnector);
    RIIF2Recorder getRIIF2Recorder();


}
