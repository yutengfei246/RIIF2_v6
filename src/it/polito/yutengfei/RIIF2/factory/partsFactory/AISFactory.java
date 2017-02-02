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
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Repository;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AISFactory implements Factory{

    private final String AISType;
    private final ComponentFactory componentFactory;
    private final RIIF2Recorder recorder;

    private DeclaratorId declaratorId;
    private Initializer initializer;

    private Id primitiveId;

    private Label aisLabel = null;

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
    }

    private void aisDeclaration() throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (this.primitiveId != null ) {
            this.positionAisLabelPrimitiveId();
            this.positionAisAssociative();
            this.positionHierPostfix();
            this.positionAttribute();
            this.assignInitializer();
        }
    }

    // position the primitive label if the type is impose and assignment or set
    private void positionAisLabelPrimitiveId()
            throws SomeVariableMissingException, FieldTypeNotMarchException {

        String labelName = primitiveId.getId();

        // if the primitiveId is simple type without hierPostfix
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

        // if the primitiveId is not simple type with hierPostfix
        if (Objects.equals(this.primitiveId.getType(), RIIF2Grammar.TYPE_HIER)){

            RIIF2Recorder theRecorder = null;
            RIIF2Recorder preRecorder = this.recorder;
            int index = -1;

            // get the hierpostfix from the primitiveId
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
    private void positionAisAssociative() throws FieldTypeNotMarchException, SomeVariableMissingException {

        /*
        if ( !this.declaratorId.hasAisType()
                && !this.declaratorId.hasAssociativeIndex())
            this.aisLabels.add(this.aisLabel); */

        // if it is associativeIndex, then get the label, or create a new label put the new label into the associativeLabel and get back.
        if (this.declaratorId.hasAssociativeIndex()) {
            Id associativeId = this.declaratorId.getAssociativeIndex();
            String associativeIndex = associativeId.getId();

            if (!this.aisLabel.isAssociative())
                throw new FieldTypeNotMarchException(associativeIndex,
                        associativeId.getLine(), associativeId.getColumn());

            Label tempLabel = this.aisLabel;

            this.aisLabel = tempLabel.getAssociative(associativeIndex);

            if (this.aisLabel == null) {
                // if not find the label, then create the label
                this.aisLabel = this.createLabel(associativeIndex, tempLabel);
                tempLabel.putAssociative(associativeIndex, this.aisLabel);
            }
        }

        if (this.declaratorId.hasAisType()) {
            RIIF2Type aisType = this.declaratorId.getAisType();
            String type = aisType.getType();

            if (type.equals(RIIF2Grammar.TYPE_FLAT_VECTOR)) {

                Vector vector = aisType.getVector();
                Expression expLeft = vector.getLeft();
                if (!expLeft.getType().equals(RIIF2Grammar.INTEGER))
                    throw new FieldTypeNotMarchException(expLeft.getType(), expLeft.getLine(), expLeft.getColumn());

                Expression expRight = vector.getRight();
                if (!expRight.getType().equals(RIIF2Grammar.INTEGER))
                    throw new FieldTypeNotMarchException(expRight.getType(), expLeft.getLine(), expLeft.getColumn());

                Map.Entry<Expression, Expression> vectorEntry =
                        VectorImpl.createExpressionEntryPair(expLeft, expRight);

                VectorItem label = new VectorItem(this.recorder);

                this.aisLabel.putVectorEntryValue(vectorEntry, label);
                this.aisLabel = label;

            }
        }

    }

    private void positionHierPostfix() throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (this.declaratorId.hasHierPostfix()) {
            Id hierPostfixId = this.declaratorId.getHierPostfix();
            String hierPostfixName = hierPostfixId.getId();

            if (!(this.aisLabel instanceof ChildComponent)) {
                throw new FieldTypeNotMarchException(hierPostfixName,
                        hierPostfixId.getLine(), hierPostfixId.getColumn());
            }

            RIIF2Recorder ccRecorder  = (RIIF2Recorder) (this.aisLabel).getValue();

            this.aisLabel = ccRecorder.getAssignmentLabel(hierPostfixName) != null
                            ? ccRecorder.getAssignmentLabel(hierPostfixName)
                            : ccRecorder.getImposeLabel(hierPostfixName) != null
                            ? ccRecorder.getImposeLabel(hierPostfixName)
                            : null;

            if (this.aisLabel == null)
                throw new SomeVariableMissingException(hierPostfixName,
                        hierPostfixId.getLine(), hierPostfixId.getColumn());

        }
    }

    private void positionAttribute() throws FieldTypeNotMarchException {

        if (this.declaratorId.hasAttributeIndex()){

            Id attributeId = this.declaratorId.getAttributeIndex();
            String attributeIndex = attributeId.getId();

            Label tempLabel;
            tempLabel = this.aisLabel.getAttribute(attributeIndex);

            if (tempLabel == null){
                tempLabel = PreDefinedAttribute.createAttribute(attributeIndex,RIIF2Grammar.STRING,null,this.recorder);
                this.aisLabel.putAttribute(attributeIndex, (Attribute) tempLabel);
            }
            this.aisLabel = tempLabel;
        }
    }


    // pay attention: the ais value should be pushed into a stack
    private void assignInitializer() throws FieldTypeNotMarchException, SomeVariableMissingException {

            // if the initializer is an expression
            if (this.initializer instanceof Expression) {

                Expression expInitializer = (Expression) this.initializer;
                expInitializer.setRecorder(this.recorder);
                expInitializer.setCurrentLabel(this.aisLabel);

                // if the current label is enumType
                if (this.aisLabel.isEnumType()) {
                    if (!expInitializer.type().equals(RIIF2Grammar.USER_DEFINED)
                            && !expInitializer.type().equals(RIIF2Grammar.SELF))
                        throw new FieldTypeNotMarchException(((DeclaratorId) expInitializer.value()).getPrimitiveId().getId(),
                                expInitializer.getLine(), expInitializer.getColumn());

                    // if the it is the USER_DEFINED, set the enumType directly
                    if (expInitializer.type().equals(RIIF2Grammar.USER_DEFINED)) {
                        Id primitiveId = ((DeclaratorId) expInitializer.value()).getPrimitiveId();
                        String refName = primitiveId.getId();

                        if (primitiveId.getType().equals(RIIF2Grammar.TYPE_HIER))
                            throw new FieldTypeNotMarchException(refName, expInitializer.getLine(), expInitializer.getColumn());

                        else if (!this.aisLabel.getEnumType().contains(refName))
                            throw new SomeVariableMissingException(refName,
                                    expInitializer.getLine(), expInitializer.getColumn());
                        else {
                            this.aisLabel.putValue(refName);
                        //    System.out.println("set enum string");
                        }
                    }

                }

                // if it is the SELF, set the self
                if (expInitializer.type().equals(RIIF2Grammar.SELF)) {
                    this.aisLabel.putValue(expInitializer);
                }
                    //if it is the attribute unit
                 else if (this.aisLabel instanceof Attribute &&
                        this.aisLabel.getName().equals(RIIF2Grammar.UNIT) ) {
                  //  System.out.println("current label is an attribute with name " );

                    if (!(expInitializer.value() instanceof DeclaratorId))
                        throw new FieldTypeNotMarchException(expInitializer.value().toString(),
                                expInitializer.getLine(), expInitializer.getColumn());

                    DeclaratorId declaratorId = (DeclaratorId) expInitializer.value();
                    String id = declaratorId.getPrimitiveId().getId();

                    this.aisLabel.putValue(id);

                    //..tableId  = 'Item[][]
                    // should be more tracky to solve
                }else if ((this.aisLabel instanceof Attribute) &&
                        this.aisLabel.getName().equals(RIIF2Grammar.ITEMS) && this.declaratorId.hasTableIndex()){
                 /*
                    Attribute itemsAttribute = (Attribute) this.aisLabel;

                    Id tableId = this.declaratorId.getTableIndex();
                    String tableIndex1 = tableId.getXX();
                    String tableIndex2 = tableId.getYY();

                    // if it is the table sharp

                    if ( tableIndex1.equals(RIIF2Grammar.SHARP) ){

                        //try to find the row number
                        LinkedList<Item> rows = (LinkedList<Item>) this.aisLabel.getValue();
                        int rowNumber = rows.size();

                        //try to find tableIndex2 location start from 0
                        Label<Label> tableLabel = itemsAttribute.getTable();
                        Attribute headerAttribute = tableLabel.getAttribute(RIIF2Grammar.HEADER);
                        LinkedList<String> headerNames = (LinkedList<String>) headerAttribute.getValue();

                        if ( !headerNames.contains(tableIndex2)){
                            throw new SomeVariableMissingException(tableIndex2,tableId.getLine(),tableId.getColumn());
                        }


                        int headerNamePosition = headerNames.indexOf(tableIndex2);

                        //iterative access
                        for (int i=0; i < rowNumber ; i ++){
                            label.set_self1(i);
                            label.set_self2(headerNamePosition );
                            label.setSelfValue(expInitializer.getValue());
                        }
                        label.resetSelf();
                    }
                    */

                }else if (this.aisLabel.getType().equals(RIIF2Grammar.PLATFORM)){

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

                    this.aisLabel.putValue(platformRecorder);

                }else if (expInitializer.getType().equals( this.aisLabel.getType()) ) {
                    this.aisLabel.putValue(expInitializer);
                }else if (expInitializer.getType().equals( RIIF2Grammar.INTEGER)
                        && this.aisLabel.getType().equals(RIIF2Grammar.DOUBLE) ){
                    this.aisLabel.putValue(expInitializer);
                }else
                    throw new FieldTypeNotMarchException( this.aisLabel.getName() + ":" + this.aisLabel.getType() + " , " + expInitializer.getType(),
                            expInitializer.getLine(),
                            expInitializer.getColumn());
            }

            if (this.initializer instanceof ListInitializer){
                ListInitializer listInitializer = (ListInitializer) this.initializer;
                this.aisLabel.setValue(listInitializer );
            }


            // no this case
            if (this.initializer instanceof ArrayInitializer){
                throw new FieldTypeNotMarchException(this.aisLabel.getName(), this.initializer.getLine(),this.initializer.getColumn());
            }

            if (this.initializer instanceof ArrayWrapperInitializer){
                this.aisLabel.putValue(this.initializer);
           //     System.out.println("After assign ");
            }
/*
            // arrayWrapper initially is used in matrix
            if (this.initializer instanceof ArrayWrapperInitializer){
                ArrayWrapperInitializer arrayWrapperInitializer
                        = (ArrayWrapperInitializer) this.initializer;

                if (!this.aisLabel.isVector()
                        && !this.aisLabel.getName().equals(RIIF2Grammar.ITEMS))
                    throw new FieldTypeNotMarchException(RIIF2Grammar.TABLE,
                            arrayWrapperInitializer.getLine(), arrayWrapperInitializer.getColumn());

                if (this.aisLabel.getName().equals(RIIF2Grammar.ITEMS)) {

                    List<Item> items = new LinkedList<>();
                    List<ArrayInitializer> arrayInitializers = arrayWrapperInitializer.getInitializer();

                    final int[] i = {-1};
                    arrayInitializers.forEach(arrayInitializer -> {
                        i[0]++;
                        label.set_self1(i[0]);

                        Item item = new Item();

                        List<Expression> expressions = arrayInitializer.getInitializer();
                        final int[] j = {-1};
                        expressions.forEach(expression -> {
                            j[0]++;
                            expression.setExpressionOperator(this.eo);
                            label.set_self2(j[0]);
                            Item.UnitItem unitItem = null;
                            unitItem = item.createUnitItem(expression.getType(), expression.getValue());
                            item.addUnitItem(unitItem);
                        });

                        items.add(item);
                    });
                    label.setValue(items);
                    label.resetSelf();
                }
            }

            */

            if (this.initializer instanceof TableInitializer){

                TableInitializer tableInitializer
                        = (TableInitializer) this.initializer;

                if (!(this.aisLabel instanceof Attribute)
                        || ( !this.aisLabel.getName().equals(RIIF2Grammar.HEADER)
                             && !this.aisLabel.getName().equals(RIIF2Grammar.ITEMS)
                            )
                        ) {
                    throw new FieldTypeNotMarchException( RIIF2Grammar.ASSIGNMENT,
                            tableInitializer.getLine(),
                            tableInitializer.getColumn());
                }

                this.aisLabel.putValue(tableInitializer);
/*
                List<Item> items = new LinkedList<>();
                final int[] i = {-1};
                tableInitializer.getInitializer()
                        .forEach(row -> {
                            i[0]++;
                            label.set_self1(i[0]);

                            Item item = new Item();
                            if (row.getType() == Row.EXPRESSION) {
                                Expression expression
                                        = (Expression) row.getValue();
                                expression.setExpressionOperator(eo);

                                if (!expression.isArray())
                                    throw new IllegalArgumentException();

                                ArrayInitializer arrayInitializer
                                        = null;
                                // in this case we do not need to manage the operations between arrays
                                arrayInitializer = (ArrayInitializer) expression.value();
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

                label.resetSelf();
                label.setValue(items);

                */
            }

    }

    private Label createLabel(String associativeIndex, Label tempLabel) throws FieldTypeNotMarchException {

        Label<Label> rtnLabel = null;
        if ( tempLabel instanceof Parameter) {
            rtnLabel = new Parameter(this.recorder);
            rtnLabel.setAttribute(true);
            PreDefinedAttribute.FieldAttribute(rtnLabel,this.recorder);
        }
        if (tempLabel instanceof Constant) {
            rtnLabel = new Constant(this.recorder);
            rtnLabel.setAttribute(true);
            PreDefinedAttribute.FieldAttribute(rtnLabel,this.recorder);
        }
        if (tempLabel instanceof FailMode) {
            rtnLabel = new FailMode(this.recorder);
            rtnLabel.setAttribute(true);
            PreDefinedAttribute.FMAttribute( rtnLabel,this.recorder );
        }
        if (tempLabel instanceof ChildComponent) {
            rtnLabel = new ChildComponent(this.recorder);
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
