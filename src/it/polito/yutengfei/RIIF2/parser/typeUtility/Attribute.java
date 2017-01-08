package it.polito.yutengfei.RIIF2.parser.typeUtility;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Item;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.util.List;
import java.util.Objects;

public class Attribute extends Label<Object> {

    @Override
    public void setAssociative(Boolean b) {
    }

    @Override
    public void putAttribute(String key, Attribute attribute) {

    }

    @Override
    public void putAssoc(String name, Object assocIndex) {

    }

    @Override
    public ? extends Label getAssociative(String index) {
        return null;
    }

    @Override
    public Attribute getAttribute(String index) {
        return null;
    }

    @Override
    public boolean containsAssociativeIndex(String index) {
        return false;
    }

    @Override
    public boolean containsAttributeIndex(String index) {
        return false;
    }

    @Override
    public void setVector(Vector vector) {

    }

    @Override
    public void addVectorItem(Object value) {

    }

    @Override
    public void setPlatform(RIIF2Recorder recorder) {

    }

    @Override
    public RIIF2Recorder getPlatform() {
        return null;
    }


    public String  print() {
        if (Objects.equals(this.getName(), RIIF2Grammar.ITEMS)){
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

        return (this.getName()
                + " -Type : "
                + this.getType()
                + " -value :"
                + this.getValue() );
    }

}
