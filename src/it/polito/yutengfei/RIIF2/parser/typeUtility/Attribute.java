package it.polito.yutengfei.RIIF2.parser.typeUtility;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Item;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.util.List;
import java.util.Objects;

public class Attribute extends Label<Label> {

    private Label<Label> table;

    public Label<Label> getTable(){
        return table;
    }

    public  void setTable(Label table){
        this.table = table;
    }

    @Override
    public void setAssociative(Boolean b) {
    }

    @Override
    public void putAttribute(String key, Attribute attribute) {

    }

    @Override
    public void putAssoc(String name, Label assocIndex) {

    }

    @Override
    public Label getAssociative(String index) {
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
    public void setVector(Vector vector, RIIF2Recorder recorder) {

    }

    @Override
    public void addVectorItem(Label value) {

    }

    @Override
    public Label getVector(int index) {
        return null;
    }

    @Override
    public void setPlatform(RIIF2Recorder recorder) {

    }

    @Override
    public RIIF2Recorder getPlatform() {
        return null;
    }

    @Override
    public void print() {
        if (Objects.equals(this.getName(), RIIF2Grammar.ITEMS)
                && this.getValue() != null ){
            StringBuilder stringBuffer = new StringBuilder();

            stringBuffer.append(getName()+" {");

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

            System.out.println(stringBuffer);
        }else

            System.out.println(this.getName()
                    + " -Type : "
                    + this.getType()
                    + " -value :"
                    + this.getValue());
    }

}
