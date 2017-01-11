package it.polito.yutengfei.RIIF2.util.utilityWrapper;


import it.polito.yutengfei.RIIF2.initializer.Initializer;

import java.util.LinkedList;
import java.util.Queue;

public class Expression implements Initializer {

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

    private String type;
    private Object value;


    private boolean performed = true;

    private Queue<Operation> oprQueue = new LinkedList<>();

    private int line;
    private int column;
    private ExpressionOperator expressionOperator = null;

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String type(){
        return this.type;
    }

    public Object value(){
        return this.value;
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

    public void setExpressionOperator(ExpressionOperator expressionOperator) {
        this.expressionOperator = expressionOperator;
    }

    public boolean isInteger() {
        return this.expressionOperator.isInteger(this);
    }

    boolean isArray() {
        return this.expressionOperator.isArray(this);
    }

    public String getType() {
        return this.expressionOperator.getType(this);
    }


    //TODO: change getValue implementation in all of the project
    public Object getValue() {
        return this.expressionOperator.getValue(this);
    }

    private void push(Operation opr){
        this.oprQueue.add(opr);
        this.performed = false;
    }

    Operation pop(){
        return this.oprQueue.poll();
    }

    boolean performed() {
        return this.performed = true;
    }


    public  boolean isPerformed() {
        return performed;
    }


    @Override
    public void addItem(Object item) {
    }

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

}
