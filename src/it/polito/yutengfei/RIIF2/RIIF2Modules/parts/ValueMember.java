package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.initializer.ArrayInitializer;
import it.polito.yutengfei.RIIF2.initializer.ArrayWrapperInitializer;
import it.polito.yutengfei.RIIF2.initializer.ListInitializer;
import it.polito.yutengfei.RIIF2.initializer.TableInitializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.test.RIIF2;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.TableValueOperator;

import java.io.Serializable;
import java.util.List;

class ValueMember implements Serializable {

    private String type;
    private Object value;


    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setValue(Object value) throws FieldTypeNotMarchException {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Label label, Object value, RIIF2Recorder theRecorder) throws FieldTypeNotMarchException {

        // when the value is missed
        if (value == null)
            return;

        // if value is String, we could have two possibility : Enum and Unit
        else if (value instanceof String) {
            String valueString = (String) value;

            // is a enumType Label
            if (label.isEnumType())
                this.value = valueString;

            // is a unit attribute label
            if (label instanceof Attribute && label.getName().equals(RIIF2Grammar.UNIT))
                this.value = valueString;
        }

        // if is RIIF-2 Recorder
        else if (value instanceof RIIF2Recorder) {
            RIIF2Recorder recorder = (RIIF2Recorder) value;

            if ( label instanceof ChildComponent )
                this.value = recorder;

            if (label.getType().equals(RIIF2Grammar.ENV))
                this.value = recorder;

        }

        // if the given value is Expression
        else if (value instanceof Expression) {
            Expression expValue = (Expression) value;

            if ( expValue.getXx() != null && expValue.getYy() != null ){
                String xx = expValue.getXx();
                String yy = expValue.getYy();

                if ( (label instanceof Attribute) && label.getName().equals(RIIF2Grammar.ITEMS) ){

                    if (xx.equals(RIIF2Grammar.SHARP)) {
                        TableValueOperator tableValueOperator = (TableValueOperator) label.getValue();
                        tableValueOperator.sharpOperation(yy, expValue);
                    }
                }
            }

            // if the expression type == the label type
            else if ( expValue.getType().equals(label.getType()) ) {

                //if (label.getName().equals(RIIF2Grammar.ITEMS))
                  //  expValue.print();

                this.value = expValue;
            }

            // else if the expression type is integer and label type is double
            else if (expValue.getType().equals(RIIF2Grammar.INTEGER) && label.getType().equals(RIIF2Grammar.DOUBLE))
                this.value = expValue;

            else
                throw new FieldTypeNotMarchException( FieldTypeNotMarchException.MARCHED, label.getName(),expValue.getLine(),expValue.getColumn());
        }

        // if the given value is a arrayInitializer
        else if (value instanceof ArrayInitializer) {
            ArrayInitializer arrayInitializer = (ArrayInitializer) value;
            List<Expression> expressionList = arrayInitializer.getInitializer();

            final int[] i = {0};
            expressionList.forEach(expression -> {
                expression.setCurrentLabel(label);
                expression.setRecorder(theRecorder);

                try {
                    label.setVectorValue(i[0]++ ,expression);
                } catch (FieldTypeNotMarchException e) {
                    e.printStackTrace();
                }
            });


        }

        // if the given value is list initializer
        else if (value instanceof ListInitializer) {
            ListInitializer listValue = (ListInitializer) value;
            List<Object> listObject = listValue.getInitializer();

            // in this case, need to create tableValueOperator class
            if (label instanceof Attribute && label.getName().equals(RIIF2Grammar.HEADER)) {
                Label itemLabel = ((Attribute) label).getTable().getAttribute(RIIF2Grammar.ITEMS);

                Object find = listObject.stream().filter(o -> !(o instanceof String) ).findFirst().orElse(null);
                if (find != null)
                    throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MARCHED, label.getName(), listValue.getLine(),listValue.getColumn());

                TableValueOperator tableValueOperator = new TableValueOperator(listObject,itemLabel);
                itemLabel.setValue(tableValueOperator);
            }

            switch (label.getType()) {

                // in label case, it is List<Object>
                case RIIF2Grammar.LIST:
                    this.value = listObject;
                    break;

                case RIIF2Grammar.LIST_STRING: {

                    Object find = listObject.stream()
                            .filter(o -> !(o instanceof String))
                            .findAny().orElse(null);

                    // in this case, there are some Items inside the list was not String Type.
                    if (find != null)
                        throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MARCHED, label.getName(), listValue.getLine(), listValue.getColumn());
                    else
                        this.value = listObject;
                    break;
                }

                case RIIF2Grammar.LIST_INTEGER: {

                    Object find = listObject.stream()
                            .filter(o -> !(o instanceof Integer))
                            .findAny().orElse(null);

                    // in this case, there are some Items inside the list was not Integer Type.
                    if (find != null)
                        throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MARCHED, label.getName(), listValue.getLine(), listValue.getColumn());
                    else
                        this.value = listObject;
                    break;

                }

                case RIIF2Grammar.LIST_DOUBLE: {

                    Object find = listObject.stream()
                            .filter(o -> !(o instanceof Double))
                            .findAny().orElse(null);

                    // in label case, there are some Item inside the list was not Double Type.
                    if (find != null)
                        throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MARCHED, label.getName(), listValue.getLine(), listValue.getColumn());
                    else
                        this.value = listObject;
                    break;

                }

                default: throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MARCHED, label.getName(), listValue.getLine(), listValue.getColumn());
            }
        }


        // if the value is arrayWrapperInitializer
        if (value instanceof ArrayWrapperInitializer) {

            ArrayWrapperInitializer arrayWrapperInitializer = (ArrayWrapperInitializer) value;

            // if the label is not attribute or the label has no ITEM name
            if ( !(label instanceof Attribute) || !label.getName().equals(RIIF2Grammar.ITEMS) )
                throw new FieldTypeNotMarchException(label.getName(), arrayWrapperInitializer.getLine(), arrayWrapperInitializer.getColumn());

            // cast the label to attribute label
            Attribute attributeLabel = (Attribute)label;

            // create operator
            List headers = (List) attributeLabel.getTable(/*Get table label*/).getAttribute(RIIF2Grammar.HEADER).getValue();

            // get the arrayInitializer instance from arrayWrapperInitializer
            List<ArrayInitializer> arrayInitializerList = arrayWrapperInitializer.getInitializer();
            TableValueOperator tableValueOperator = new TableValueOperator(headers,label);

            for (ArrayInitializer arrayInitializer : arrayInitializerList) {

                List<Expression> expressionList = arrayInitializer.getInitializer();
                for (Expression expression : expressionList ){
                    expression.setRecorder(attributeLabel.getRecorder());
                    expression.setCurrentLabel(label);
                    if ( !expression.isValid() )
                        throw new FieldTypeNotMarchException(label.getName(),arrayInitializer.getLine(), arrayInitializer.getColumn());
                }
                if (!tableValueOperator.setRows(arrayInitializer))
                    throw new FieldTypeNotMarchException(label.getName(),arrayInitializer.getLine(),arrayInitializer.getColumn());
            }
            tableValueOperator.newTableInitializer(arrayWrapperInitializer);

            this.value = tableValueOperator;
        }

        // table Initializer
        if (value instanceof TableInitializer) {

            TableInitializer tableInitializer = (TableInitializer) value;

            if (!(label instanceof Attribute) || !label.getName().equals(RIIF2Grammar.ITEMS))
                throw new FieldTypeNotMarchException(label.getName(), tableInitializer.getLine(), tableInitializer.getColumn());

            TableValueOperator tableValueOperator = (TableValueOperator) label.getValue();

            if (tableValueOperator == null)
                throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MESSAGE,"The table header have not defined " + label.getName(), tableInitializer.getLine(),tableInitializer.getColumn());

            tableValueOperator.newTableInitializer( tableInitializer );
        }

        if (value instanceof TableValueOperator) {
            this.value = value;
        }
    }

}
