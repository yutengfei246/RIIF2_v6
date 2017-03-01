package it.polito.yutengfei.RIIF2.recoder;

import it.polito.yutengfei.RIIF2.mysql.SQLConnector;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.TableValueOperator;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public interface Repository {

    /*Repository ...*/
    Map<String,Recorder> tempRecorderMap = new LinkedHashMap<>();
    Map<String,Recorder> componentRecorderMap = new LinkedHashMap<>();
    Map<String,Recorder> envRecorderMap = new LinkedHashMap<>();
    Map<String,Recorder> requirementRecorderMap  = new LinkedHashMap<>();
    Map<String,Recorder> bindRecorderMap = new LinkedHashMap<>();

    static void putTemp(String key, Recorder value){
        tempRecorderMap.put(key,value);
    }

    static void putComponent(String key, Recorder value){
        componentRecorderMap.put(key, value);
    }

    static void putEnv(String identifier, Recorder recorder) {
        envRecorderMap.put(identifier, recorder);
    }

    static void putRequirement(String key, Recorder recorder ) {
        requirementRecorderMap.put(key, recorder);
    }

    static void putBind(String key, Recorder recorder) {
        bindRecorderMap.put(key, recorder);
    }

    static Recorder getRecorderFromTemplateRepository(String key){
        return tempRecorderMap.get(key);
    }

    static Recorder getRecorderFromComponentRepository(String key){
        return componentRecorderMap.get(key);
    }

    static Recorder getRecorderFromEnvRepository(String key) {
        return envRecorderMap.get(key);
    }

    static Recorder getRecorderFormRequirementRepository(String key) {
        return requirementRecorderMap.get(key);
    }

    static Boolean containsComponent(String key){
        return componentRecorderMap.containsKey(key);
    }

    static Boolean containsTemplate(String key){
        return tempRecorderMap.containsKey(key);
    }

    static Boolean containsEnvironment(String key ) {
        return envRecorderMap.containsKey(key);
    }

    static Boolean containsRequirement(String key) {
        return requirementRecorderMap.containsKey(key);
    }

    static boolean containsBind(String key) {
        return bindRecorderMap.containsKey(key);
    }

    static Recorder getDeepCopedRecorderFromTemplateRepository(String key) {
        return DeepCopy.copy(getRecorderFromTemplateRepository(key));
    }

    static Recorder getDeepCopedRecorderFromComponentRepository(String key) {
        return DeepCopy.copy(getRecorderFromComponentRepository(key));
    }

    static Recorder getDeepCopedRecorderFromEnvRepository(String key) {
        return DeepCopy.copy(getRecorderFromEnvRepository(key));
    }

    static Recorder getDeepCopedRecorderFromRequirementRepository(String key){
        return DeepCopy.copy(getRecorderFormRequirementRepository(key));
    }

    static Map<String,Recorder> getTemplateRepository(){
        return tempRecorderMap;
    }

    static Map<String,Recorder> getComponentRepository(){
        return componentRecorderMap;
    }

    static Map<String,Recorder> getEnvRepository() {
        return envRecorderMap;
    }

    static Map<String,Recorder> getRequirementRepository() {
        return requirementRecorderMap;
    }

    static Map<String,Recorder> getBindRepository() {
        return bindRecorderMap;
    }
    class DeepCopy{

        static Recorder copy(Recorder orig) {
            Recorder obj = null;
            try {
                obj = (Recorder) deepCopy(orig);
            }
            catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return obj;
        }

        public static TableValueOperator copy(TableValueOperator tableValueOperator){
            TableValueOperator tableValueOperator1 = null;
            try {
                tableValueOperator1 = (TableValueOperator) deepCopy(tableValueOperator);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return tableValueOperator1;
        }

        static Object deepCopy(Object o) throws IOException, ClassNotFoundException {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(o);
            out.flush();
            out.close();

            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            return in.readObject();

        }
    }

    /* the method for generating the class , each class has the name that stored in recorder*/
    static void generateDB(SQLConnector sqlConnector) {

        // generate template
        tempRecorderMap.forEach((s, recorder) -> recorder.generateDB(sqlConnector));

        // generate component
        componentRecorderMap.forEach((s, recorder) -> recorder.generateDB(sqlConnector));

        // generate environment
        envRecorderMap.forEach((s, recorder) -> recorder.generateDB(sqlConnector));

        // generate requirement
        requirementRecorderMap.forEach((s, recorder) -> recorder.generateDB(sqlConnector));

        // generate bind
        bindRecorderMap.forEach((s, recorder) -> recorder.generateDB(sqlConnector));

    }
}
