package it.polito.yutengfei.RIIF2.factory.partsFactory;


import it.polito.yutengfei.RIIF2.Declarator.AisDeclarator;
import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.SomeVariableMissingException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.VeriableAlreadyExistException;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.initializer.*;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.LabelRetriever;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Repository;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.ExpressionOperator;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Row;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.RowItem;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class AISFactory implements Factory{

    private final String AISType;
    private final ComponentFactory componentFactory;
    private final RIIF2Recorder recorder;

    private DeclaratorId declaratorId;
    private Initializer initializer;

    private Id primitiveId;

    private Label aisLabel = null;
    private List<Label> aisLabels = new LinkedList<>();
    private ExpressionOperator eo;

    public AISFactory(ComponentFactory componentFactory, String assignment, RIIF2Recorder recorder) {
        this.componentFactory = componentFactory;
        this.recorder = recorder;
        this.AISType = assignment;
    }

    private void initializer() {
        AisDeclarator aisDeclarator
                = (AisDeclarator) this.componentFactory.getDeclarator();
        this.initializer = aisDeclarator.getInitializer();
        this.declaratorId = aisDeclarator.getDeclaratorId();

        this.primitiveId = this.declaratorId.getPrimitiveId();

        this.eo = new ExpressionOperator(this.recorder);

    }

    private void aisDeclaration() throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (this.primitiveId != null ) {
            this.positionAisLabelPrimitiveId();
            this.positionAisLabel1();
            this.assignInitializer();
        }
    }

    private void positionAisLabelPrimitiveId()
            throws SomeVariableMissingException, FieldTypeNotMarchException {

        String labelName = primitiveId.getId();

        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_PRIMITIVE)) {

            switch (this.AISType){
                case RIIF2Grammar.IMPOSE:
                    this.aisLabel = this.recorder.getImposeLabel(labelName);
                    break;
                case RIIF2Grammar.ASSIGNMENT:
                    this.aisLabel = this.recorder.getAssignmentLabel(labelName);
                    break;
                case RIIF2Grammar.SET:
                    this.aisLabel = this.recorder.getSetLabel(labelName);
                    break;
                default:
                    this.aisLabel = null;
                    break;
            }
        }

        if (Objects.equals(this.primitiveId.getType(), RIIF2Grammar.TYPE_HIER)){

            RIIF2Recorder theRecorder = null;
            RIIF2Recorder preRecorder = this.recorder;
            int index = -1;

            List<Id> ids = this.primitiveId.hierPostfixIds();
            for (Id id: ids) {
                index++;
                String idName = id.getId();

                assert preRecorder != null;

                switch (this.AISType){
                    case RIIF2Grammar.IMPOSE:
                        theRecorder = preRecorder.getExRecorder(idName);
                        break;
                    case RIIF2Grammar.ASSIGNMENT:
                        theRecorder = preRecorder.getExRecorder(idName);
                        break;
                    case RIIF2Grammar.SET:
                        theRecorder = preRecorder.getImplRecorder(idName);
                        break;
                    default:
                        theRecorder = null;
                }

                if (theRecorder != null )
                    preRecorder = theRecorder;
                else {
                    this.aisLabel = preRecorder.getAssignmentLabel(idName);
                    break;
                }
            }

            if (theRecorder != null)
                this.aisLabel = theRecorder.getAssignmentLabel(labelName);
            else {
                while (index+1  <  ids.size() ){
                    Id id = ids.get(index);

                    if (this.aisLabel == null )
                        throw new SomeVariableMissingException(id.getId(),
                                id.getLine() , id.getColumn());
                    if (  ! (this.aisLabel instanceof ChildComponent) )
                        throw new FieldTypeNotMarchException(id.getId(),
                                id.getLine(), id.getColumn());

                    index ++ ;
                    this.aisLabel = ((RIIF2Recorder) this.aisLabel.getValue() )
                            .getAssignmentLabel( ids.get(index).getId() );
                }
                this.aisLabel
                        = ((RIIF2Recorder)this.aisLabel.getValue()).getLabel(labelName);
            }

        }

        if (this.aisLabel == null )
            throw new SomeVariableMissingException(labelName,
                    this.primitiveId.getLine(),this.primitiveId.getColumn());
    }

    /**
     * declaratorId ::
     * primitiveId (aisType|associativeIndex) ? hierPostfix ? attributeIndex?
     * */
    private void positionAisLabel1() throws FieldTypeNotMarchException, SomeVariableMissingException {


        if ( !this.declaratorId.hasAisType()
                && !this.declaratorId.hasAssociativeIndex())
            this.aisLabels.add(this.aisLabel);


        if (this.declaratorId.hasAssociativeIndex()){
            Id associativeId = this.declaratorId.getAssociativeIndex();
            String associativeIndex = associativeId.getId();

            if (!this.aisLabel.isAssociative())
                throw new FieldTypeNotMarchException(associativeIndex,
                        associativeId.getLine(), associativeId.getColumn());

            Label tempLabel = this.aisLabel;

            this.aisLabel = tempLabel.getAssociative(associativeIndex);


            if (this.aisLabel == null){
                this.aisLabel = this.createLabel(associativeIndex,tempLabel);
                tempLabel.putAssoc(associativeIndex,this.aisLabel);
            }

            this.aisLabels.add(this.aisLabel);
        }

        if (this.declaratorId.hasAisType()){
            RIIF2Type aisType = this.declaratorId.getAisType();
            String type = aisType.getType();

            if (type.equals(RIIF2Grammar.TYPE_ASSOCIATIVE)){
                //TODO:: skip
            }
            else if (type.equals(RIIF2Grammar.TYPE_FLAT_VECTOR)){

                Vector vector = aisType.getVector();
                if ( !this.aisLabel.isVector()
                        || this.aisLabel.getVectorLength() < vector.getLength(new ExpressionOperator(this.recorder)))
                    throw new FieldTypeNotMarchException(this.aisLabel.getName(),
                            aisType.getLine(), aisType.getColumn() );

                Expression expression = vector.getLeft();
                expression.setExpressionOperator(this.eo);

                int i = (int) expression.getValue();

                expression = vector.getRight();
                expression.setExpressionOperator(this.eo);
                int j = (int) expression.getValue();

                for (; i <= j ; i ++){
                    Label label = this.aisLabel.getVector(i);
                    this.aisLabels.add(label);
                }
            }else
                this.aisLabels.add(this.aisLabel);
        }

        if (this.declaratorId.hasHierPostfix()){
            Id hierPostfixId = this.declaratorId.getHierPostfix();
            String hierPostfixName = hierPostfixId.getId();

            List<Label> aisLabels = new LinkedList<>();
            for (Label label : this.aisLabels) {

                if (!(label instanceof ChildComponent)) {
                    throw new FieldTypeNotMarchException(hierPostfixName,
                            hierPostfixId.getLine(), hierPostfixId.getColumn());
                }

                RIIF2Recorder ccRecorder
                        = (RIIF2Recorder) (label).getValue();

                label = ccRecorder.getAssignmentLabel(hierPostfixName) != null
                        ? ccRecorder.getAssignmentLabel(hierPostfixName)
                        : ccRecorder.getImposeLabel(hierPostfixName) != null
                        ? ccRecorder.getImposeLabel(hierPostfixName)
                        : null;

                if (label == null)
                    throw new SomeVariableMissingException(hierPostfixName,
                            hierPostfixId.getLine(), hierPostfixId.getColumn());

                aisLabels.add(label);
            }
            this.aisLabels = aisLabels;
        }

        if (this.declaratorId.hasAttributeIndex()){

            Id attributeId = this.declaratorId.getAttributeIndex();
            String attributeIndex = attributeId.getId();

            List<Label> aisLabels = new LinkedList<>();
            for (Label label : this.aisLabels) {
                Label tempLabel;
                tempLabel = label.getAttribute(attributeIndex);
                if (tempLabel == null){
                    tempLabel
                            = PreDefinedAttribute.createAttribute(attributeIndex,RIIF2Grammar.STRING,null);
                    label.putAttribute(attributeIndex, (Attribute) tempLabel);
                }
                aisLabels.add(tempLabel);
            }
            this.aisLabels = aisLabels;
        }

        //TODO:: how to decide when to use the table index?
        // set table'Items[#][column] =  arrayWrapperInitializer
        if (this.declaratorId.hasTableIndex()){

            Id tableId = this.declaratorId.getTableId();
            String tableIndex1 = tableId.getXX();
            String tableIndex2 = tableId.getYY();

            if (!this.aisLabel.getType().equals(RIIF2Grammar.ITEMS)
                    || !(this.aisLabel instanceof Attribute) )
                throw new FieldTypeNotMarchException(tableIndex1,
                        tableId.getLine(),tableId.getColumn() );

            Attribute itemAttribute = (Attribute) this.aisLabel;
            //TODO: start from here
            if (tableIndex1.equals(RIIF2Grammar.SHARP)){


            } else{


            }

        }
    }

    private void assignInitializer() throws FieldTypeNotMarchException, SomeVariableMissingException {

        for (Label label : this.aisLabels) {

            this.eo.setCurrentLabel(label);
            if (this.initializer instanceof Expression) {

                Expression expInitializer = (Expression) this.initializer;
                expInitializer.setExpressionOperator( this.eo ) ;

                if (label.isEnumType()){
                    if ( !expInitializer.type().equals(RIIF2Grammar.USER_DEFINED)
                            && !expInitializer.type().equals(RIIF2Grammar.SELF) )
                        throw new FieldTypeNotMarchException((  (DeclaratorId)expInitializer.value()).getPrimitiveId().getId(),
                                expInitializer.getLine(),expInitializer.getColumn());

                    if (expInitializer.type().equals(RIIF2Grammar.USER_DEFINED)){
                        String refName = ((DeclaratorId) expInitializer.value() ).getPrimitiveId().getId();

                        if(!label.getEnumType().contains(refName) )
                            throw new SomeVariableMissingException(refName,
                                    expInitializer.getLine(),expInitializer.getColumn());
                        else label.setValue(refName);
                    }
                    if (expInitializer.type().equals(RIIF2Grammar.SELF)) {
                        label.setValue( expInitializer.getValue());
                    }

                } else if (label.getName().equals(RIIF2Grammar.UNIT) ) {
                    if (!(expInitializer.value() instanceof DeclaratorId))
                        throw new FieldTypeNotMarchException(expInitializer.value().toString(),
                                expInitializer.getLine(), expInitializer.getColumn());

                    String type = ((DeclaratorId) expInitializer.value()).getPrimitiveId().getId();
                    label.setValue(type);

                }else if (label.getType().equals(RIIF2Grammar.PLATFORM)){

                    if ( !expInitializer.type().equals(RIIF2Grammar.USER_DEFINED) )
                        throw new FieldTypeNotMarchException(RIIF2Grammar.ASSIGNMENT,
                                expInitializer.getLine(),expInitializer.getColumn());

                    String componentId
                            =  ( (DeclaratorId)expInitializer.value()).getPrimitiveId().getId();
                    //try to find the component recorder
                    if (!Repository.containsComponent(componentId))
                        throw new SomeVariableMissingException(componentId,expInitializer.getLine(),
                                expInitializer.getColumn());

                    RIIF2Recorder platformRecorder
                            = (RIIF2Recorder) Repository.getDeepCopedRecorderFromComponentRepository(componentId);

                    label.setPlatform(platformRecorder);

                }else if (expInitializer.getType().equals( label.getType()) ) {
                    label.setValue(expInitializer.getValue());
                }else if (expInitializer.getType().equals( RIIF2Grammar.INTEGER)
                        && label.getType().equals(RIIF2Grammar.DOUBLE) ){
                    label.setValue((double) (int) expInitializer.getValue());
                }else
                    throw new FieldTypeNotMarchException( label.getName() + ":" + label.getType() + " , " + expInitializer.getType(),
                            expInitializer.getLine(),
                            expInitializer.getColumn());
            }

            if (this.initializer instanceof ListInitializer){

                ListInitializer listInitializer = (ListInitializer) this.initializer;
                label.setValue(listInitializer.getInitializer());
            }


            if (this.initializer instanceof ArrayInitializer){

            }

            if (this.initializer instanceof ArrayWrapperInitializer){
                ArrayWrapperInitializer arrayWrapperInitializer
                        = (ArrayWrapperInitializer) this.initializer;

                if (!label.isVector()
                        && !label.getName().equals(RIIF2Grammar.ITEMS))
                    throw new FieldTypeNotMarchException(RIIF2Grammar.TABLE,
                            arrayWrapperInitializer.getLine(), arrayWrapperInitializer.getColumn());


                List<Item> items = new LinkedList<>();
                List<ArrayInitializer> arrayInitializers = arrayWrapperInitializer.getInitializer();

                arrayInitializers.forEach(arrayInitializer -> {

                    Item item = new Item();
                    List<Expression> expressions = arrayInitializer.getInitializer();
                    expressions.forEach(expression -> {
                        expression.setExpressionOperator(this.eo);
                        Item.UnitItem unitItem = null;
                        unitItem = item.createUnitItem(expression.getType(), expression.getValue());
                        item.addUnitItem(unitItem);
                    });

                    items.add(item);
                });
                label.setValue(items);
            }

            if (this.initializer instanceof TableInitializer){
                TableInitializer tableInitializer
                        = (TableInitializer) this.initializer;

                if (!(label instanceof Attribute)
                        || ( !label.getName().equals(RIIF2Grammar.HEADER)
                             && !label.getName().equals(RIIF2Grammar.ITEMS)
                            )
                        ) {
                    throw new FieldTypeNotMarchException( RIIF2Grammar.ASSIGNMENT,
                            tableInitializer.getLine(),
                            tableInitializer.getColumn());
                }

                List<Item> items = new LinkedList<>();
                tableInitializer.getInitializer()
                        .forEach(row -> {

                            Item item = new Item();
                            if (row.getType() == Row.EXPRESSION) {
                                Expression expression
                                        = (Expression) row.getValue();
                                expression.setExpressionOperator(eo);

                                /*
                                if (!expression.isArray())
                                    throw new IllegalArgumentException();
                                                                           */
                                ArrayInitializer arrayInitializer
                                        = null;
                                arrayInitializer = (ArrayInitializer) expression.getValue();
                                List<Expression> initializer
                                        = arrayInitializer.getInitializer();

                                initializer.forEach(expression1 -> {
                                    expression1.setExpressionOperator(eo);
                                    Item.UnitItem unitItem
                                            = null;
                                    unitItem = item.createUnitItem(expression1.getType(), expression1.getValue());
                                    item.addUnitItem(unitItem);
                                });
                            }

                            if (row.getType() == Row.ROW_ITEMS_ARRAY) {
                                List<RowItem> rowItems
                                        = (List<RowItem>) row.getValue();

                                rowItems.forEach(rowItem -> {

                                    String unitItemType = null;
                                    Object unitItemValue = null;
                                    if (rowItem.getType() == RowItem.EXPRESSION) {
                                        Expression expression
                                                = (Expression) rowItem.getValue();
                                        expression.setExpressionOperator(eo);

                                        unitItemType = expression.getType();
                                        unitItemValue = expression.getValue();

                                    }

                                    if (rowItem.getType() == RowItem.LIST_STRING) {
                                        ListInitializer listInitializer
                                                = (ListInitializer) rowItem.getValue();
                                        unitItemType = RIIF2Grammar.LIST;
                                        unitItemValue = listInitializer.getInitializer();
                                    }
                                    Item.UnitItem unitItem
                                            = item.createUnitItem(unitItemType, unitItemValue);
                                    item.addUnitItem(unitItem);
                                });
                            }
                            items.add(item);
                        });

                label.setValue(items);
            }
        }
    }

    private Label createLabel(String associativeIndex, Label tempLabel) {

        Label<Label> rtnLabel = null;
        if ( tempLabel instanceof Parameter) {
            rtnLabel = new Parameter();
            PreDefinedAttribute.FieldAttribute(rtnLabel);
        }
        if (tempLabel instanceof Constant) {
            rtnLabel = new Constant();
            PreDefinedAttribute.FieldAttribute(rtnLabel);
        }
        if (tempLabel instanceof FailMode) {
            rtnLabel = new FailMode();
            PreDefinedAttribute.FMAttribute( rtnLabel );
        }
        if (tempLabel instanceof ChildComponent) {
            rtnLabel = new ChildComponent();
            rtnLabel.setValue(tempLabel.getValue());
        }

        assert rtnLabel != null;
        rtnLabel.setName(associativeIndex);
        rtnLabel.setType(tempLabel.getType());

        return rtnLabel;
    }


    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {
        this.initializer();
        this.aisDeclaration();
    }
}
