package it.polito.yutengfei.RIIF2.recoder;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public interface Repository {
    /*Repository ...*/
    Map<String,Recorder> tempRecorderMap = new LinkedHashMap<>();
    Map<String,Recorder> componentRecorderMap = new LinkedHashMap<>();

    static void putTemp(String key, Recorder value){
        tempRecorderMap.put(key,value);
    }

    static void putComponent(String key, Recorder value){
        componentRecorderMap.put(key, value);
    }

    static Recorder getRecorderFromTemplateRepository(String key){
        return tempRecorderMap.get(key);
    }

    static Recorder getRecorderFromComponentRepository(String key){
        return componentRecorderMap.get(key);
    }

    static Boolean containsComponent(String key){
        return componentRecorderMap.containsKey(key);
    }

    static Boolean containsTemplate(String key){
        return tempRecorderMap.containsKey(key);
    }

    static Recorder getDeepCopedRecorderFromTemplateRepository(String key){
        return DeepCopy.copy(getRecorderFromTemplateRepository(key));
    }

    static Recorder getDeepCopedRecorderFromComponentRepository(String key){
        return DeepCopy.copy(getRecorderFromComponentRepository(key));
    }

    static Map<String,Recorder> getTemplateRepository(){
        return tempRecorderMap;
    }

    static Map<String,Recorder> getComponentRepository(){
        return componentRecorderMap;
    }

    class DeepCopy{

        public static Recorder copy(Recorder orig) {
            Recorder obj = null;
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(bos);
                out.writeObject(orig);
                out.flush();
                out.close();

                ObjectInputStream in = new ObjectInputStream(
                        new ByteArrayInputStream(bos.toByteArray()));
                obj = (Recorder) in.readObject();
            }
            catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return obj;
        }
    }
}
