package it.polito.yutengfei.RIIF2.factory.partsFactory;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

class PreDefinedAttribute {

    static void FieldAttribute(Label<Label> fieldLabel) {
        Attribute attributeMin = createAttribute(RIIF2Grammar.MIN,RIIF2Grammar.DOUBLE,null);
        Attribute attributeMax = createAttribute(RIIF2Grammar.MAX,RIIF2Grammar.DOUBLE,null);
        Attribute attributeUnit = createAttribute(RIIF2Grammar.UNIT,RIIF2Grammar.USER_DEFINED,null);

        fieldLabel.putAttribute(RIIF2Grammar.MAX, attributeMax);
        fieldLabel.putAttribute(RIIF2Grammar.MIN,attributeMin);
        fieldLabel.putAttribute(RIIF2Grammar.UNIT,attributeUnit);
    }


    static void TableAttribute(Label<Label> fieldLabel){
        Attribute header = createAttribute(RIIF2Grammar.HEADER,RIIF2Grammar.LIST,null);
        Attribute items = createAttribute(RIIF2Grammar.ITEMS, RIIF2Grammar.JSON, null);

        fieldLabel.putAttribute(RIIF2Grammar.HEADER, header);
        fieldLabel.putAttribute(RIIF2Grammar.ITEMS, items);
    }

    static void FMAttribute(Label<Label> fmLabel){
        Attribute rate = createAttribute(RIIF2Grammar.RATE,RIIF2Grammar.DOUBLE,null);
        Attribute unit = createAttribute(RIIF2Grammar.UNIT,RIIF2Grammar.USER_DEFINED,null);

        fmLabel.putAttribute(RIIF2Grammar.RATE,rate);
        fmLabel.putAttribute(RIIF2Grammar.UNIT,unit);

    }
    static Attribute createAttribute(String Id, String type, Object value) {
        Attribute attribute = new Attribute();
        attribute.setName(Id);
        attribute.setType(type);
        attribute.setValue(value);

        return attribute;
    }

    static void ListAttribute(Label<Label> fieldLabel) {

    }
}
