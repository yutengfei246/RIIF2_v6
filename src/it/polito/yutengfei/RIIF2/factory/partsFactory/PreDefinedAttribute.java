package it.polito.yutengfei.RIIF2.factory.partsFactory;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.ChildComponent;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.List;
import java.util.Objects;

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

    /*From current, extended, to implements....  */
    static Label getUserDefinedLabel( Expression expInitializer , RIIF2Recorder recorder){
        Label rtnLabel  = null;

        if (!Objects.equals(expInitializer.getType(), RIIF2Grammar.USER_DEFINED))
            return null;

        DeclaratorId declaratorId /*ais declaratorId */
                = (DeclaratorId) expInitializer.getValue();
        Id primitiveId = declaratorId.getPrimitiveId();

        String id = primitiveId.getId();
        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_PRIMITIVE))

            rtnLabel = recorder.getLabel(id) != null
                    ? recorder.getLabel(id)
                    : recorder.getAssignmentLabel(id) != null
                    ? recorder.getAssignmentLabel(id)
                    : recorder.getImposeLabel(id) != null
                    ? recorder.getImposeLabel(id)
                    : null ;

        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_HIER)){
            List<Id> ids = primitiveId.hierPostfixIds();

            RIIF2Recorder currRecorder, preRecorder;
            currRecorder = recorder;
            int i = -1 ;

            for (Id id1 : ids){
                i++;
                /*current recorder*/
                rtnLabel = currRecorder.getLabel(id1.getId());
                if (rtnLabel == null){
                    /*go extended recorder*/
                    System.out.println("Going to find ");
                    preRecorder = currRecorder;
                    currRecorder = currRecorder.getExRecorder(id1.getId());

                    if (currRecorder == null){
                        System.out.println("Going to not find ");
                        currRecorder = preRecorder.getImplRecorder(id1.getId());
                        if (currRecorder == null)
                            return null;
                    }

                }

                if (i < ids.size() ){
                    if ( rtnLabel != null )
                        if (! (rtnLabel instanceof ChildComponent) )
                            return null;
                        else
                            currRecorder = (RIIF2Recorder) rtnLabel.getValue();
                }
            }
            System.out.println("Return find ");
            rtnLabel = currRecorder.getLabel(id);
        }
        return rtnLabel;
    }
}
