package it.polito.yutengfei.RIIF2.recoder;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.ChildComponent;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.VectorImpl;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.VectorItem;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.List;
import java.util.Map;

/**
 * An extractor class that used to extract an Label from recorder
 */
public class LabelExtractor {

    private RIIF2Recorder recorder;
    private Expression expression;

    public LabelExtractor (RIIF2Recorder recorder){
        this(null,recorder);
    }

    public LabelExtractor (Expression expression, RIIF2Recorder recorder) {
        this.expression = expression;
        this.recorder = recorder;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    /* AisDeclaratorID : primitiveId (aisType | associativeIndex)? (hierPostfix)? (attributeIndex)? (tableIndex)? */
    public Label<Label> extractor(){

        if (expression == null)
            return null;

        DeclaratorId declaratorId = (DeclaratorId) this.expression.value();
        Id primitiveId = declaratorId.getPrimitiveId();

        Label<Label> label1 = this.primitiveIdExtractor(primitiveId); //primitiveId
        Label<Label> label2 = this.aisTypeAssociativeIndexExtractor(label1 ,declaratorId); //(aisType|associativeIndex) ?
        Label<Label> label3 = this.hierPostfixExtractor(label2,declaratorId); // (hierPostfix) ?
        //TODO: need to consider <tableIndex>

        return this.attributeExtractor(label3,declaratorId);
    }


    /* primitiveId : Identifier
                   | primitiveId (.hierPostfix )
    */
    public Label<Label> primitiveIdExtractor(Id primitiveId){
        Label<Label> rtnLabel = null;

        String id = primitiveId.getId();

        if (primitiveId.getType().equals(RIIF2Grammar.TYPE_PRIMITIVE)) {
            // if it is a primitive Type, then simply returned from the current Recorder
            rtnLabel = recorder.getAISLabel(id);
        }

        if (primitiveId.getType().equals(RIIF2Grammar.TYPE_HIER)) {
            // if it has qualified name, it should check each time and find out where to go
            List<Id> ids = primitiveId.hierPostfixIds();
            RIIF2Recorder currRecorder, preRecorder;
            currRecorder = recorder;
            int i = -1;

            for (Id id1 : ids) {
                i++;
                /*current recorder*/
                rtnLabel = currRecorder.getLabel(id1.getId());
                if (rtnLabel == null) {
                    /*go extended recorder*/
                    preRecorder = currRecorder;
                    currRecorder = preRecorder.getExRecorder(id1.getId());

                    if (currRecorder == null) {
                        /*go implemented recorder*/
                        currRecorder = preRecorder.getImplRecorder(id1.getId());
                        if (currRecorder == null)
                            return null;
                    }
                }
            }
            rtnLabel = currRecorder.getLabel(id);
        }
        return rtnLabel;
    }

    // ( aisType | associativeIndex ) ?
    public  Label<Label> aisTypeAssociativeIndexExtractor(Label<Label> theLabel, DeclaratorId declaratorId) {

        if (theLabel == null)
            return null;

        if (declaratorId.hasAisType()) {
            RIIF2Type aisType = declaratorId.getAisType();
            String type = aisType.getType();

            switch (type) {
                case RIIF2Grammar.TYPE_ASSOCIATIVE:
                    return null;
                case RIIF2Grammar.TYPE_FLAT_VECTOR:

                    // this is a special one, because we create a Label and return the label, not the one
                    // that already in the RIIF2Recorder. Since I could not know the flatVector at parsing time
                    // and this is also a kind of challenge for implementation of this RIIF2Language by this cord.
                    Vector vector = aisType.getVector();
                    if (!theLabel.isVector())
                        return null;

                    Expression expLeft = vector.getLeft();
                    if (!expLeft.getType().equals(RIIF2Grammar.INTEGER))
                        return null;

                    Expression expRight = vector.getRight();
                    if (!expRight.getType().equals(RIIF2Grammar.INTEGER))
                        return null;

                    Map.Entry<Expression, Expression> vectorEntry =
                            VectorImpl.createExpressionEntryPair(expLeft, expRight);

                    VectorItem label = new VectorItem(this.recorder);

                    theLabel.putVectorEntryValue(vectorEntry, label);

                    return label;

                default:
                    return null;
            }

        } else if ( declaratorId.hasAssociativeIndex() ){
            Id associativeId = declaratorId.getAssociativeIndex();
            String associativeIndex = associativeId.getId();

            if (!theLabel.isAssociative())
                return null;

            theLabel = theLabel.getAssociative(associativeIndex);

            if (theLabel == null)
                return null;

            return theLabel;

        }else return theLabel;
    }

    // hierPostfix
    public  Label<Label> hierPostfixExtractor(Label<Label> label2, DeclaratorId declaratorId) {

        if (label2 == null)
            return null;

        if (declaratorId.hasHierPostfix()) {

            if (!(label2 instanceof ChildComponent))
                return null;

            Id hierPostfix = declaratorId.getHierPostfix();
            String hierPostfixIndex = hierPostfix.getId();

            RIIF2Recorder riif2Recorder = (RIIF2Recorder) label2.getValue();

            return riif2Recorder.getAssignmentLabel(hierPostfixIndex) != null
                    ? riif2Recorder.getAssignmentLabel(hierPostfixIndex)
                    : riif2Recorder.getImposeLabel(hierPostfixIndex) != null
                    ? riif2Recorder.getImposeLabel(hierPostfixIndex)
                    : null;

        }else return label2;
    }

    // attributeIndex
    public Label<Label> attributeExtractor(Label<Label> label3, DeclaratorId declaratorId) {

        if (label3 == null)
            return null;

        if ( declaratorId.hasAttributeIndex() ){
            Id attributeId = declaratorId.getAttributeIndex();
            String attributeIndex = attributeId.getId();

            return label3.getAttribute(attributeIndex);

        }else return label3;
    }






}
