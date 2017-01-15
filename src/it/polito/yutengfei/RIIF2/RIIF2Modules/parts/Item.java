package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Item implements Serializable{

    private List<UnitItem> unitItems = new LinkedList<>();

    public void addUnitItem(UnitItem unitItem) {
        this.unitItems.add(unitItem);
    }

    public UnitItem getUnitItem(int index) {
        return this.unitItems.get(index);
    }

    public UnitItem createUnitItem(String type, Object value){
        return new UnitItem(type, value);
    }

    public int size(){
        return this.unitItems.size();
    }


    public class UnitItem implements Serializable{

        private String type;
        private Object value;


        UnitItem(String type, Object value) {
            this.type = type;
            this.value = value;
        }

        public String getType(){
            return this.type;
        }

        public Object getValue(){
            return this.value;
        }

        public void setType(String type ) {
            this.type = type;
        }

        public void setValue(Object value){
            this.value = value;
        }
    }
}
