package it.polito.yutengfei.RIIF2.parser.typeUtility;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Item;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Attribute implements Serializable{

    private String type;
    private Object value; // in case is Item or Header, the value is LinkedList instance
    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String  print() {
        if (Objects.equals(this.getId(), RIIF2Grammar.ITEMS)){
            StringBuilder stringBuffer = new StringBuilder();

            stringBuffer.append("{");

            List<Item> items = (List<Item>) this.getValue();
            items.forEach(item -> {
                stringBuffer.append("[");
                int size = item.size();
                int i = 0;
                while (i< size){
                    Item.UnitItem unitItem
                            = item.getUnitItem(i);
                    stringBuffer.append(unitItem.getValue()).append(" ");
                    i++;
                }
                stringBuffer.append("] ");
            });
            stringBuffer.append("}");

            return stringBuffer.toString();
        }

        return (this.getId()
                + " -Type : "
                + this.getType()
                + " -value :"
                + this.getValue() );
    }

}
