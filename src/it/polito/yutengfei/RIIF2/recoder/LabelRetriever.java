package it.polito.yutengfei.RIIF2.recoder;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.ChildComponent;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.ExpressionOperator;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LabelRetriever {

    public static List<Label> Retriever(Expression expression, RIIF2Recorder recorder) throws FieldTypeNotMarchException {
        List<Label> rtnLabels = new LinkedList<>();
        Label rtnLabel = null;


        if (!expression.type().equals(RIIF2Grammar.USER_DEFINED))
            return null;

        DeclaratorId declaratorId = (DeclaratorId) expression.value();
        Id primitiveId = declaratorId.getPrimitiveId();
        String id = primitiveId.getId();

        if (primitiveId.getType().equals(RIIF2Grammar.TYPE_PRIMITIVE)) {

            rtnLabel = recorder.getLabel(id) != null
                    ? recorder.getLabel(id)
                    : recorder.getAssignmentLabel(id) != null
                    ? recorder.getAssignmentLabel(id)
                    : recorder.getImposeLabel(id) != null
                    ? recorder.getImposeLabel(id)
                    : recorder.getSetLabel(id) != null
                    ? recorder.getSetLabel(id)
                    : null;
        }

        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_HIER)) {

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
                        currRecorder = preRecorder.getImplRecorder(id1.getId());
                        if (currRecorder == null)
                            return null;
                    }
                }

                if (i < ids.size()) {
                    if (rtnLabel != null)
                        if (!(rtnLabel instanceof ChildComponent))
                            return null;
                        else
                            currRecorder = (RIIF2Recorder) rtnLabel.getValue();
                }
            }

            rtnLabel = currRecorder.getLabel(id);
        }

        return RestOfAisDeclaratorId(rtnLabel, rtnLabels, declaratorId, recorder);


    }


    private static List<Label> RestOfAisDeclaratorId(Label rtnLabel, List<Label> rtnLabels, DeclaratorId declaratorId, RIIF2Recorder recorder) throws FieldTypeNotMarchException {

        if (rtnLabel == null)
            return rtnLabels;

        ExpressionOperator eo = new ExpressionOperator(recorder);

        if (!declaratorId.hasAisType()
                && !declaratorId.hasAssociativeIndex())
            rtnLabels.add(rtnLabel);

        if (declaratorId.hasAisType()) {
            RIIF2Type aisType = declaratorId.getAisType();
            String type = aisType.getType();

            if (type.equals(RIIF2Grammar.TYPE_ASSOCIATIVE)) {
                //TODO:: skip
            } else if (type.equals(RIIF2Grammar.TYPE_FLAT_VECTOR)) {

                Vector vector = aisType.getVector();
                if (!rtnLabel.isVector()
                        || rtnLabel.getVectorLength() < vector.getLength(eo))
                    throw new FieldTypeNotMarchException(rtnLabel.getName(),
                            aisType.getLine(), aisType.getColumn());

                Expression expression = vector.getLeft();
                expression.setExpressionOperator(eo);

                int i = (int) expression.getValue();

                expression = vector.getRight();
                expression.setExpressionOperator(eo);
                int j = (int) expression.getValue();

                for (; i <= j; i++) {
                    Label label = rtnLabel.getVector(i);
                    rtnLabels.add(label);
                }
            } else
                rtnLabels.add(rtnLabel);
        }

        if (declaratorId.hasAssociativeIndex()) {
            Id associativeId = declaratorId.getAssociativeIndex();
            String associativeIndex = associativeId.getId();

            if (rtnLabel.isAssociative())
                throw new FieldTypeNotMarchException(associativeIndex,
                        associativeId.getLine(), associativeId.getColumn());

            rtnLabel = rtnLabel.getAssociative(associativeIndex);

            if (rtnLabel == null)
                return rtnLabels;

            rtnLabels.add(rtnLabel);

        }

        if (declaratorId.hasHierPostfix()) {
            Id hierPostfixId = declaratorId.getHierPostfix();
            String hierPostfixName = hierPostfixId.getId();

            List<Label> aisLabels = new LinkedList<>();
            for (Label label : rtnLabels) {

                if (!(label instanceof ChildComponent)) {
                    return null;
                }

                RIIF2Recorder ccRecorder
                        = (RIIF2Recorder) (label).getValue();

                label = ccRecorder.getAssignmentLabel(hierPostfixName) != null
                        ? ccRecorder.getAssignmentLabel(hierPostfixName)
                        : ccRecorder.getImposeLabel(hierPostfixName) != null
                        ? ccRecorder.getImposeLabel(hierPostfixName)
                        : null;

                if (label == null) {
                    return null;
                }


                aisLabels.add(label);
            }
            rtnLabels = aisLabels;
        }


        if (declaratorId.hasAttributeIndex()) {

            Id attributeId = declaratorId.getAttributeIndex();
            String attributeIndex = attributeId.getId();

            List<Label> aisLabels = new LinkedList<>();
            for (Label label : rtnLabels) {
                Label tempLabel;
                tempLabel = label.getAttribute(attributeIndex);

                if (tempLabel == null) {
                    return null;
                }
                aisLabels.add(tempLabel);
            }
            rtnLabels = aisLabels;
        }

        //TODO: table index

        return rtnLabels;
    }

}

