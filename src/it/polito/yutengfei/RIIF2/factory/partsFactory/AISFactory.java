package it.polito.yutengfei.RIIF2.factory.partsFactory;


import it.polito.yutengfei.RIIF2.Declarator.AisDeclarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.ChildComponent;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Item;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.initializer.*;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Row;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.RowItem;

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
    private Id tableId;

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
        this.tableId = this.declaratorId.getTableId();

    }

    private void aisDeclaration()
            throws FieldTypeNotMarchException, SomeVariableMissingException {

        if (this.primitiveId != null ) {
            this.getAisLabel();
            this.newAISDeclarator();
        }

        if (this.tableId != null ){
            //TODO: table Id
            System.out.println("Table need to be done ...");
        }
    }

    /*declaratorId
    :: primitiveId (aisType|associativeIndex) ? hierPostfix ? attributeIndex?*/
    private void newAISDeclarator()
            throws FieldTypeNotMarchException, SomeVariableMissingException {
         /*vector or associative*/
        if (this.declaratorId.hasAisType()) {
            RIIF2Type aisType = this.declaratorId.getAisType();
            String type = aisType.getType();

            if (type.equals(RIIF2Grammar.TYPE_ASSOCIATIVE)) {
                //TODO: skip
                System.out.println("Going to finish ");
            }

            if (type.equals(RIIF2Grammar.TYPE_FLAT_VECTOR)) {

                if (!this.aisLabel.isVector())
                    throw new FieldTypeNotMarchException();

                Vector vector = aisType.getVector();

                String hierPostfixIndex = this.getHierPostfixIndex();
                if (hierPostfixIndex != null) {

                    String attributeIndex = this.getAttributeIndex();
                    if (attributeIndex != null)
                        this.setVectorHierPostfixAttributeValue(vector, hierPostfixIndex, attributeIndex);
                    else
                        this.setVectorHierPostfixValue(vector, hierPostfixIndex);
                } else {

                    String attributeIndex = this.getAttributeIndex();
                    if (attributeIndex != null)
                        this.setVectorAttributeValue(vector, attributeIndex);
                    else
                        this.setVectorValue(vector);
                }
            }
        } else {

            String hierPostfixIndex = this.getHierPostfixIndex();
            if (hierPostfixIndex != null) {

                String attributeIndex = this.getAttributeIndex();
                if (attributeIndex != null)
                    this.setHierPostfixAttributeValue(hierPostfixIndex, attributeIndex);
                else
                    this.setHierPostfixValue(hierPostfixIndex);
            } else {

                String attributeIndex = this.getAttributeIndex();
                if (attributeIndex != null)
                    this.setAttributeValue(attributeIndex);
                else
                    this.setPureValue();
            }
        }
    }

    private void getAisLabel()
            throws SomeVariableMissingException, FieldTypeNotMarchException {

        String labelName = primitiveId.getId();

        if (Objects.equals(primitiveId.getType(),
                RIIF2Grammar.TYPE_PRIMITIVE)) {

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

            if (this.aisLabel == null)
                throw new SomeVariableMissingException();
        }

        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_HIER)){

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

                    if (  ! (this.aisLabel instanceof ChildComponent) )
                        throw new FieldTypeNotMarchException();
                    break;
                }
            }

            if (theRecorder != null)
                this.aisLabel = theRecorder.getLabel(labelName);
            else {
                while (index+1  <  ids.size() ){
                    index ++ ;
                    System.out.println("Going the check the aisLabel " );
                    if (  ! (this.aisLabel instanceof ChildComponent) )
                        throw new FieldTypeNotMarchException();
                    this.aisLabel
                            = ((RIIF2Recorder) this.aisLabel.getValue() )
                            .getAssignmentLabel( ids.get(index).getId() );
                }
                this.aisLabel
                        = ((RIIF2Recorder)this.aisLabel.getValue()).getLabel(labelName);
            }

            if (this.aisLabel == null )
                throw new SomeVariableMissingException();
        }

    }

    /*From current, extended, to implements....  */
    private Label getUserDefinedLabel( Expression expInitializer ){
        Label rtnLabel  = null;

        if (!Objects.equals(expInitializer.getType(), RIIF2Grammar.USER_DEFINED))
            return null;

        DeclaratorId declaratorId /*ais declaratorId */
                = (DeclaratorId) expInitializer.getValue();
        Id primitiveId = declaratorId.getPrimitiveId();

        String id = primitiveId.getId();
        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_PRIMITIVE))
            rtnLabel = this.recorder.getLabel(id);

        if (Objects.equals(primitiveId.getType(), RIIF2Grammar.TYPE_HIER)){
            List<Id> ids = primitiveId.hierPostfixIds();

            RIIF2Recorder currRecorder, preRecorder;
            currRecorder = this.recorder;
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

    private void setPureValue()
            throws FieldTypeNotMarchException {

        if (this.initializer instanceof Expression){
            Expression expInitializer = (Expression) this.initializer;

            if (!Objects.equals(expInitializer.getType(), this.aisLabel.getType()))
                throw new FieldTypeNotMarchException();

            this.aisLabel.setValue(expInitializer.getValue());
        }

        if (this.initializer instanceof ArrayInitializer){
            //TODO: arrayInitializer
            System.out.println("array need to be finish ");
        }

        if (this.initializer instanceof ListInitializer){
            //TODO: listInitializer
            System.out.println("list need to be finish");
        }


    }

    private void setHierPostfixValue(String hierPostfixIndex)
            throws FieldTypeNotMarchException {

        RIIF2Recorder recorder
                = (RIIF2Recorder) this.aisLabel.getValue();
        this.aisLabel = recorder.getLabel(hierPostfixIndex);

        this.setPureValue();
    }

    private void setAttributeValue(String attributeIndex)
            throws FieldTypeNotMarchException {

        Attribute attribute
                =  this.aisLabel.getAttribute( attributeIndex );

        if (attribute == null) {
            attribute = createAttribute(attributeIndex);
            this.aisLabel.putAttribute(attributeIndex,attribute);
        }else {

            if (attributeIndex.equals( RIIF2Grammar.HEADER) ){

                if ( ! (this.initializer instanceof ListInitializer) )
                    throw new FieldTypeNotMarchException();

                ListInitializer listInitializer =
                        (ListInitializer) this.initializer;

                attribute.setValue( listInitializer.getInitializer() );
            }

            if (attributeIndex.equals( RIIF2Grammar.ITEMS) ){
                if ( ! (this.initializer instanceof TableInitializer)
                        && ! (this.initializer instanceof ArrayWrapperInitializer))
                    throw new FieldTypeNotMarchException();

                if (this.initializer instanceof TableInitializer) {
                    TableInitializer tableInitializer
                            = (TableInitializer) this.initializer;

                    List<Item> items = new LinkedList<>();
                    tableInitializer.getInitializer()
                            .forEach(row -> {

                                Item item = new Item();
                                if (row.getType() == Row.EXPRESSION) {
                                    Expression expression
                                            = (Expression) row.getValue();
                                    ArrayInitializer arrayInitializer
                                            = (ArrayInitializer) expression.getValue();
                                    List<Expression> initializer
                                            = arrayInitializer.getInitializer();

                                    initializer.forEach(expression1 -> {
                                        Item.UnitItem unitItem
                                                = item.createUnitItem(expression1.getType(), expression1.getValue());
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
                    attribute.setValue(items);
                }

                if (this.initializer instanceof ArrayWrapperInitializer){
                    ArrayWrapperInitializer arrayWrapperInitializer
                            = (ArrayWrapperInitializer) this.initializer;

                    List<Item> items = new LinkedList<>();
                    List<ArrayInitializer> arrayInitializers = arrayWrapperInitializer.getInitializer();
                    arrayInitializers.forEach(arrayInitializer -> {

                        Item item = new Item();
                        List<Expression> expressions = arrayInitializer.getInitializer();
                        expressions.forEach(expression -> {
                            Item.UnitItem unitItem
                                    = item.createUnitItem(expression.getType(), expression.getValue());
                            item.addUnitItem(unitItem);
                        });

                        items.add(item);
                    });
                    attribute.setValue(items);
                }
            }

            if (attributeIndex.equals(RIIF2Grammar.UNIT)){
                if (this.initializer instanceof Expression){
                    Expression expression = (Expression) this.initializer;

                    if (!Objects.equals(expression.getType(), RIIF2Grammar.USER_DEFINED))
                        throw new FieldTypeNotMarchException();

                    DeclaratorId declaratorId = (DeclaratorId) expression.getValue();
                    String attributeValue = declaratorId.getPrimitiveId().getId();
                    attribute.setValue( attributeValue);

                }else
                    throw new FieldTypeNotMarchException();
            }
        }
        this.initialAttribute(attribute);
    }


    private void setHierPostfixAttributeValue(String hierPostfixIndex, String attributeIndex) {
        //TODO:: ...
    }

    private void setVectorAttributeValue(Vector vector, String attributeIndex) {
        //TODO:: ...
    }

    public void setVectorValue(Vector vectorValue) {
        //TODO::
    }

    private void setVectorHierPostfixValue(Vector vector, String hierPostfix) {
        //TODO::
    }

    private void setVectorHierPostfixAttributeValue(Vector vector, String hierPostfix, String attributeIndex) {
        //TODO::
    }

    private Attribute createAttribute(String attributeName ) {

        Attribute attribute = new Attribute();

        if (Objects.equals(attributeName, RIIF2Grammar.RATE))
            attribute.setType(RIIF2Grammar.INTEGER);
        else
            attribute.setType( RIIF2Grammar.STRING );
        attribute.setId(attributeName);

        return attribute;
    }

    private void initialAttribute(Attribute attribute)
            throws FieldTypeNotMarchException {

        if (this.initializer instanceof Expression){
            Expression expInitializer = (Expression) this.initializer;

            System.out.println("expInitializer type " + expInitializer.getType() + " attribute type " + attribute.getType() );
            if (!Objects.equals(expInitializer.getType(), RIIF2Grammar.USER_DEFINED)
                    && !Objects.equals(expInitializer.getType(), attribute.getType()) )
                throw new FieldTypeNotMarchException();


            if (Objects.equals(expInitializer.getType(), RIIF2Grammar.USER_DEFINED)){
                Label usedDefinedLabel = this.getUserDefinedLabel(expInitializer);
                if (usedDefinedLabel == null )
                    throw new FieldTypeNotMarchException();

                attribute.setValue( usedDefinedLabel.getValue());
            }
            attribute.setValue( expInitializer.getValue() );
        }

    }


    private String getAttributeIndex() throws SomeVariableMissingException {
        String attribute = null;

        if (this.declaratorId.hasAttributeIndex()){

            Id attributeIndexId  = this.declaratorId.getAttributeIndex();
            attribute = attributeIndexId.getId();
        }

        return attribute;
    }

    private String getHierPostfixIndex() throws FieldTypeNotMarchException {
        String hierPostfix = null ;

        if (this.declaratorId.hasHierPostfix()) {

            if (!(this.aisLabel instanceof ChildComponent))
                throw new FieldTypeNotMarchException();

            Id hierPostfixId = this.declaratorId.getHierPostfix();
            hierPostfix = hierPostfixId.getId();

        }
        return hierPostfix;
    }

    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, InvalidFieldDeclaration, FieldTypeNotMarchException {
        this.initializer();
        this.aisDeclaration();
    }
}
