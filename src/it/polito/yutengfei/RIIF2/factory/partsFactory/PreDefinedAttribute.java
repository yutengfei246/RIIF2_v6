package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

public class PreDefinedAttribute {

    static void FieldAttribute(Label<Label> fieldLabel, RIIF2Recorder recorder) throws FieldTypeNotMarchException {
        Attribute attributeMin = createAttribute(RIIF2Grammar.MIN,RIIF2Grammar.DOUBLE,null,recorder);
        Attribute attributeMax = createAttribute(RIIF2Grammar.MAX,RIIF2Grammar.DOUBLE,null,recorder);
        Attribute attributeUnit = createAttribute(RIIF2Grammar.UNIT,RIIF2Grammar.USER_DEFINED,null,recorder);

        fieldLabel.putAttribute(RIIF2Grammar.MAX, attributeMax);
        fieldLabel.putAttribute(RIIF2Grammar.MIN,attributeMin);
        fieldLabel.putAttribute(RIIF2Grammar.UNIT,attributeUnit);
    }


    static void TableAttribute(Label<Label> fieldLabel,RIIF2Recorder recorder) throws FieldTypeNotMarchException {
        Attribute header = createAttribute(RIIF2Grammar.HEADER,RIIF2Grammar.LIST_STRING,null,recorder);
        Attribute items = createAttribute(RIIF2Grammar.ITEMS, RIIF2Grammar.JSON, null,recorder);

        header.setTable(fieldLabel);
        items.setTable(fieldLabel);

        fieldLabel.putAttribute(RIIF2Grammar.HEADER, header);
        fieldLabel.putAttribute(RIIF2Grammar.ITEMS, items);
    }

    static void FMAttribute(Label<Label> fmLabel, RIIF2Recorder recorder) throws FieldTypeNotMarchException {
        Attribute rate = createAttribute(RIIF2Grammar.RATE,RIIF2Grammar.DOUBLE,null,recorder);
        Attribute unit = createAttribute(RIIF2Grammar.UNIT,RIIF2Grammar.USER_DEFINED,null,recorder);

        fmLabel.putAttribute(RIIF2Grammar.RATE,rate);
        fmLabel.putAttribute(RIIF2Grammar.UNIT,unit);

    }
    static Attribute createAttribute(String Id, String type, Object value,RIIF2Recorder recorder) throws FieldTypeNotMarchException {
        Attribute attribute = new Attribute(recorder);
        attribute.setName(Id);
        attribute.setType(type);
        attribute.putValue(value);

        return attribute;
    }

    static void ListAttribute(Label<Label> fieldLabel) {

    }
}
