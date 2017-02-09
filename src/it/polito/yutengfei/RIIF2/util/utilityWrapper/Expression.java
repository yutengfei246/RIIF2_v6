package it.polito.yutengfei.RIIF2.util.utilityWrapper;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.initializer.ArrayInitializer;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Expression implements Initializer, Serializable {

    public static final int OP_NEGATIVE = 11;
    public static final int OP_POSITIVE = 12;
    public static final int OP_WAVE = 13;
    public static final int OP_NOT = 14;
    public static final int OP_STAR = 15;
    public static final int OP_DIV = 16;
    public static final int OP_MOD = 17;
    public static final int OP_PLUS = 18;
    public static final int OP_MINUS = 19;
    public static final int OP_SM_EQ = 20;
    public static final int OP_BG_EQ = 21;
    public static final int OP_EQ_EQ = 22;
    public static final int OP_NOT_EQ = 23;
    public static final int OP_BG = 24;
    public static final int OP_SM = 25;
    public static final int OP_SINGLE_AND = 26;
    public static final int OP_SINGLE_OR = 27;
    public static final int OP_SINGLE_POWER = 28;
    public static final int OP_DOUBLE_AND = 29;
    public static final int OP_DOUBLE_OR = 30;
    public static final int OP_ASSIGN = 31;
    public static final int OP_IF_ELSE = 32;

    // properties for the expression type and value
    private String type;
    private Object value;

    // specify the operation has performed or not
    private boolean performed = false;
    // specify the operation queue
    private Queue<Operation> oprQueue = new LinkedList<>();

    // recorder the line and column
    private int line;
    private int column;
    // function arguments (They are expression either )
    private LinkedList<Expression> funcArguments = null ;

    // in this way, we can design the expression Operator out of the framework.
    private ExpressionOperator expressionOperator = new ExpressionOperator();
    private Label enumLabel = null;

    // RIIF2Recorder .
    private RIIF2Recorder recorder;
    private Label currentLabel;

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String type(){
        return this.type;
    }

    public Object value() {
        return this.value;
    }

    public void setExpressionOperator(ExpressionOperator expressionOperator) {
        this.expressionOperator = expressionOperator;
    }

    public Expression operation(int opr) {

        Operation operation = new Operation();

        operation.setOpr(opr);
        this.push(operation);
        return this;
    }

    public Expression operation(int opr, Expression rightExp) {
        Operation operation = new Operation();

        operation.setOpr(opr);
        operation.setOprExpression(rightExp);
        this.push(operation);

        return this;
    }

    public Expression operation(int opIfElse, Expression middleExp, Expression rightExp) {
        Operation operation = new Operation();

        operation.setOpr(opIfElse);
        operation.setOprExpression(middleExp);
        operation.setOprExpression(rightExp);
        this.push(operation);

        return this;
    }

    public boolean isBoolean() {

        try {
            return this.expressionOperator.isBoolean(this);
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
            e.print();
        }

        return false;
    }


    private List getArray() {
        try {
            return this.expressionOperator.getArray(this);
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isInteger() {
        try {
            return this.expressionOperator.isInteger(this);
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
            e.print();
        }
        return false;
    }

    public boolean isArray() {
        try {
            return this.expressionOperator.isArray(this);
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
            e.print();
        }

        return false;
    }

    public boolean isArrayValid(List<Label<Label>> labelList) {
        if (! this.isArray())
            return false;

        try {
            return this.expressionOperator.isArrayValid( labelList ,this);
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
        }

        return  false;
    }

    // this method pop everything and do not keep the operations in the Queue
    public String getType() {

        try {
            return this.expressionOperator.getType( this);
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
            e.print();
        }

        return null;
    }

    public boolean isValid() {

        return this.getType() != null;
    }


    public Object getValue() {

        try {
            return this.expressionOperator.getValue(this);
        } catch (FieldTypeNotMarchException e) {
            e.printStackTrace();
            e.print();
        }

        return null;
    }

    private void push(Operation opr){
        this.oprQueue.add(opr);
        this.performed = false;
    }

    Operation pop(){
        return this.oprQueue.poll();
    }

    public Iterator<Operation> getIterator() {
        return this.oprQueue.iterator();
    }

    boolean performed() {
        return this.performed = true;
    }

    boolean isPerformed() {
        return performed;
    }

    public void addFunctionArgument(Expression funcArgumentExp) {
        if (this.funcArguments == null)
            this.funcArguments = new LinkedList<>();

        this.funcArguments.add( funcArgumentExp );
    }

    List<Expression> getFuncArguments() {
        return this.funcArguments;
    }

    public void setEnumLabel(Label enumLabel) {
        this.enumLabel = enumLabel;
    }

    public Label getEnumLabel() {
        return enumLabel;
    }

    public void setRecorder(RIIF2Recorder recorder) {
        this.recorder = recorder;
        this.expressionOperator.setRecorder(this.recorder);
    }

    public void setCurrentLabel(Label currentLabel) {
        this.currentLabel = currentLabel;
        this.expressionOperator.setCurrentLabel(this.currentLabel);
    }

    @Override
    public void addItem(Object item) { }

    @Override
    public Object getItem(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public LinkedList getInitializer() {

        if (this.isArray()){
            return (LinkedList) this.getArray();
        }else
            return null;
    }

    @Override
    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    // use for debug , print the expression,recursive
    public void print() {
        // for each of the operation, print
        if (this.value() instanceof DeclaratorId) {
            DeclaratorId declaratorId = (DeclaratorId) this.value();
            String id = declaratorId.getPrimitiveId().getId();

            System.out.print(" " + id);

            if (declaratorId.hasAttributeIndex()) {
                String attributeId = declaratorId.getAttributeIndex().getId();
                System.out.print("'" + attributeId + " ");
            }

        }
        else if (this.value() instanceof  Expression ){
            Expression expression = (Expression) this.value;
            expression.print();
        }

        else if (this.value() instanceof ArrayInitializer ) {
            System.out.print(" [ ");
            ArrayInitializer arrayInitializer = (ArrayInitializer) this.value();
            arrayInitializer.getInitializer().forEach(Expression::print);
            System.out.print(" ] ");

        }else if (this.type().equals(RIIF2Grammar.SELF) ){
            System.out.print(" " + this.type + " ");
        } else
            System.out.print( " " + this.value().toString() + " ");

        Iterator<Operation> iterator = this.getIterator();

        while (iterator.hasNext()) {
            Operation operation = iterator.next();

            if (operation.getOpr() == 15 )
                System.out.print(" * " );

            if (operation.getOpr() == 16)
                System.out.print(" \\");

            if (operation.getOpr() == 18)
                System.out.print(" + ");

            if (operation.getOpr() == 19)
                System.out.print( " - ");

            Expression oprExpression = operation.getOprExpression();
            Expression targetExpression = operation.getOprTargetExpression();

            if (oprExpression != null ) {
                oprExpression.setRecorder(this.recorder);
                oprExpression.setCurrentLabel(this.currentLabel);
                oprExpression.print();
            }

            if (targetExpression != null ) {
                targetExpression.setRecorder(this.recorder);
                targetExpression.setCurrentLabel(this.currentLabel);
                targetExpression.print();
            }


        }
    }


    private String xx, yy;

    public void setLocation (String xx, String yy){
        this.xx = xx; this.yy = yy;
    }

    public String getXx(){
        return this.xx;
    }

    public String getYy(){
        return this.yy;
    }
}
