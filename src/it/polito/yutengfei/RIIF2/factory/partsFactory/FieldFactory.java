package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.*;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Constant;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Parameter;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.initializer.ArrayInitializer;
import it.polito.yutengfei.RIIF2.initializer.ArrayWrapperInitializer;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.initializer.ListInitializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/*
*   This class is responsible for creating Parameter/Constant for template or component
* */

public class FieldFactory {

    private RIIF2Recorder recorder = null;

    private RIIF2Type fieldType = null; // parameter / constant

    private Declarator declarator = null;

    private Label<Object> fieldLabel = null;

    public FieldFactory(RIIF2Recorder recorder ) {
        this.recorder = recorder;
    }

    public void setFieldType(RIIF2Type fieldType) {
        this.fieldType = fieldType;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void commit() throws InvalidFieldDeclaration, VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {
        this.setUpDeclarator(); // set those properties to fieldLabel
    }

    private void setUpDeclarator() throws InvalidFieldDeclaration, VeriableAlreadyExistException, SomeVariableMissingException, FieldTypeNotMarchException {

        if (this.declarator instanceof  PrimitiveFieldDeclarator)
            this.primitiveFieldDeclarator( this.declarator );
        if (this.declarator instanceof ListDeclarator )
            this.listDeclarator(this.declarator);
        if (this.declarator instanceof AssociativeDeclarator)
            this.associativeDeclarator(this.declarator);
        if (this.declarator instanceof TableDeclarator)
            this.tableDeclarator(this.declarator);

    }

    private void tableDeclarator(Declarator declarator) throws VeriableAlreadyExistException {
        TableDeclarator tableDeclarator
                = (TableDeclarator) declarator;

        DeclaratorId declaratorId = tableDeclarator.getDeclaratorId();
        String id = declaratorId.getId();

        if (this.recorder.contains(id))
            throw new VeriableAlreadyExistException();

        this.createFieldLabel(declaratorId);
        this.fieldLabel.setType(RIIF2Grammar.TABLE);
        this.recorder.addLabel(this.fieldLabel);

    }

    private void associativeDeclarator(Declarator declarator) throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {
        AssociativeDeclarator associativeDeclarator
                = (AssociativeDeclarator) declarator;

        DeclaratorId declaratorId = associativeDeclarator.getDeclaratorId();
        String id = declaratorId.getId();
        if (Objects.equals(this.fieldType.getType(), RIIF2Grammar.FIELD_PARAMETER)) {
            if (!this.recorder.containsParameter(id))
                throw new SomeVariableMissingException();

            this.fieldLabel = (Label) this.recorder.getParameter(id);
        }

        if (Objects.equals(this.fieldType.getType(), RIIF2Grammar.FIELD_CONSTANT)){
            if (!this.recorder.containsConstant(id))
                throw new SomeVariableMissingException();

            this.fieldLabel = this.recorder.getConstant(id);
        }

        Id associativeId = declaratorId.getAssociativeIndex();
        String associativeIndex = associativeId.getId();

        if ( this.fieldLabel.containsAssociativeIndex(associativeIndex) )
            throw new VeriableAlreadyExistException();

        if (!this.fieldLabel.isAssociative())
            throw new FieldTypeNotMarchException();

        this.newAssociativeDeclarator( associativeDeclarator , associativeIndex );
        this.recorder.addLabel(this.fieldLabel);
    }

    private void newAssociativeDeclarator(AssociativeDeclarator associativeDeclarator, String associativeIndex) throws FieldTypeNotMarchException {

        Initializer initializer = associativeDeclarator.getInitializer();
        if (initializer == null ) {
            this.fieldLabel.addAssoc(associativeIndex, null);
            return;
        }

        if ( initializer instanceof Expression){
            Expression expression = (Expression) initializer;

            if (!Objects.equals(this.fieldLabel.getType(), expression.getType()))
                throw new FieldTypeNotMarchException();

            this.fieldLabel.addAssoc(associativeIndex, expression.getValue());
        }
    }

    private void listDeclarator(Declarator declarator) throws VeriableAlreadyExistException, FieldTypeNotMarchException {
        ListDeclarator listDeclarator
                = (ListDeclarator) declarator;
        DeclaratorId declaratorId = listDeclarator.getDeclaratorId();
        String id = declaratorId.getId();
        if ( this.recorder.contains(id) )
            throw new VeriableAlreadyExistException();

        this.createFieldLabel( declaratorId );
        this.newListFieldDeclarator( listDeclarator );
        this.recorder.addLabel(this.fieldLabel);
    }

    private void newListFieldDeclarator(ListDeclarator listDeclarator) throws FieldTypeNotMarchException {
        this.fieldLabel.setType(RIIF2Grammar.LIST_INITIALIZER);

        Initializer initializer = listDeclarator.getInitializer();

        if (initializer instanceof ListInitializer){
            ListInitializer listInitializer
                    = (ListInitializer) initializer;

            List<String> strings = listInitializer.getInitializer();
            this.fieldLabel.setValue( strings );

        }else
            throw new FieldTypeNotMarchException();
    }

    private void primitiveFieldDeclarator(Declarator declarator) throws FieldTypeNotMarchException, InvalidFieldDeclaration, SomeVariableMissingException, VeriableAlreadyExistException {
        PrimitiveFieldDeclarator primitiveFieldDeclarator
                = (PrimitiveFieldDeclarator) this.declarator;

        DeclaratorId declaratorId = primitiveFieldDeclarator.getDeclaratorId();
        if ( !declaratorId.hasAttributeIndex()
                && !declaratorId.hasAssociativeIndex() ){
                /*only this case to create a new field */
            this.createFieldLabel( declaratorId );
            this.newPrimitiveFieldDeclarator( primitiveFieldDeclarator );
            this.recorder.addLabel(this.fieldLabel);

        }else{
                /*other cases to search in recorder and add those properties into recorder*/
            String id = declaratorId.getId();

            if (Objects.equals(this.fieldType.getType(), RIIF2Grammar.FIELD_CONSTANT)
                    && !this.recorder.containsConstant(id)  )
                throw new InvalidFieldDeclaration();
            else
                this.fieldLabel = this.recorder.getConstant(id);


            if (Objects.equals(this.fieldType.getType(), RIIF2Grammar.FIELD_PARAMETER)
                    && !this.recorder.containsParameter(id) )
                throw new InvalidFieldDeclaration();
            else
                this.fieldLabel = this.recorder.getParameter(id);

            if (declaratorId.hasAssociativeIndex() ){
                Id associativeIndex = declaratorId.getAssociativeIndex();
                String index = associativeIndex.getId();

                if (declaratorId.hasAttributeIndex()) {
                    Id attributeIndex = declaratorId.getAttributeIndex();
                    String atIndex = attributeIndex.getId();

                    if (!this.fieldLabel.containsAssociativeIndex(index)) {
                        throw new SomeVariableMissingException();
                    }
                    if (this.fieldLabel.containsAttributeIndex(atIndex)) {
                        throw new VeriableAlreadyExistException();
                    }

                    this.fieldLabel.addAttribute(new Attribute());
                } else {/*only associativeIndex */


                }
            }
        }
    }

    private void createFieldLabel(DeclaratorId declaratorId) {

        if (Objects.equals(RIIF2Grammar.FIELD_PARAMETER, this.fieldType.getType()))
            this.fieldLabel = new Parameter<>();
        if (Objects.equals(RIIF2Grammar.FIELD_CONSTANT, this.fieldType.getType()))
            this.fieldLabel = new Constant<>();

        String id = declaratorId.getId();
        this.fieldLabel.setName(id);

        if (declaratorId.hasTypeType()){
            RIIF2Type typeType = declaratorId.getTypeType();
            String tt = typeType.getType();

            if (/*is associative declaration*/Objects.equals(tt, RIIF2Grammar.TYPE_ASSOCIATIVE))
                this.fieldLabel.setAssociative( true );

            if (/*is vector declaration*/ Objects.equals(tt, RIIF2Grammar.TYPE_VECTOR)) {
                Vector vector = typeType.getVector();
                this.fieldLabel.setVector(vector);
            }
        }
    }

    private void newPrimitiveFieldDeclarator(PrimitiveFieldDeclarator primitiveFieldDeclarator) throws FieldTypeNotMarchException {

        RIIF2Type declaratorType = primitiveFieldDeclarator.getDeclaratorType();
        String type = declaratorType.getType();
        this.fieldLabel.setType( type );

        Initializer initializer = primitiveFieldDeclarator.getInitializer();

        if (initializer == null)
            return ;

        if (initializer instanceof Expression){
            Expression expression = (Expression) initializer;
            String eType = expression.getType();

            if (!Objects.equals(type, eType))
                throw new FieldTypeNotMarchException();

            this.fieldLabel.setValue( expression.getValue());
        }

        if (initializer instanceof ArrayWrapperInitializer){
            if (this.fieldLabel.isVector())
                throw new FieldTypeNotMarchException();

            ArrayWrapperInitializer arrayWrapperInitializer
                    = (ArrayWrapperInitializer) initializer;

            LinkedList<ArrayInitializer> arrayInitializers
                    = arrayWrapperInitializer.getArrayInitializers();
            for (ArrayInitializer arrayInitializer : arrayInitializers){
                LinkedList<Expression> expressions
                        = arrayInitializer.getExpressions();

                for (Expression expression : expressions){
                    if (!Objects.equals(expression.getType(), type))
                        throw new FieldTypeNotMarchException();

                    this.fieldLabel.addVectorItem(expression.getValue());
                }
            }
        }
    }
}
