package it.polito.yutengfei.RIIF2.parser.typeUtility;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EnumType implements Serializable {

    private List<String> enums = new ArrayList<>();

    public void putEnum(String e){
        this.enums.add(e);
    }

    public boolean contains(String e){
        return this.enums.contains(e);
    }

    public List<String> getEnums() {
        return this.enums;
    }
}
