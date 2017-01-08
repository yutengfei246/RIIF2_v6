package it.polito.yutengfei.RIIF2.util.utilityWrapper;


import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This expression is lazy mode, which means that only you invoke the method runOperator
 *
 * in this class you be able to get the result, Pay attention there may be SELF in this class
 *
 * and the exception may be thrown due to the fact that current Type are not suitable to
 *
 * perform the operation that in the operation stack.
 */
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

    private Queue<Operation> oprQueue = new LinkedList<>();
    private boolean performed = false;
    private int line;
    private int column;

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(Object value) {
        this.value = value;
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
        operation.setOprExpression( rightExp );
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

    public boolean isInteger() {
        return this.type == RIIF2Grammar.INTEGER ? true : false ;
    }

    public boolean isArray() {
        return this.type == RIIF2Grammar.ARRAY ? true : false ;
    }

    public Object getValue() {
        this.runOprQueue();

        return this.value;
    }

    public String getType() {
        return type;
    }

    private void push(Operation opr){
        this.oprQueue.add(opr);

        this.performed = false;
    }


    public boolean isPositiveInteger() {
        this.runOprQueue();

        if( this.type == RIIF2Grammar.INTEGER && ( (Integer)this.value ) > 0)
            return true;

        return false;
    }

    private Operation pop(){
        return this.oprQueue.poll();
    }

    public void runOprQueue(){
        if( this.performed )
            return ;

        Operation currentOperation;
        while ( ( currentOperation = this.pop() )  != null ){
            Expression expression = currentOperation.getOprExpression();
            switch (currentOperation.getOpr()){
                case OP_PLUS:
                    this.oprPlus( expression );
                    break;
                case OP_MINUS:
                    this.oprMinus( expression );
                    break;
                case OP_STAR:
                    this.oprStar( expression );
                    break;
                case OP_DIV:
                    this.oprDiv( expression );
                    break;
                case OP_MOD:
                    this.oprMod( expression );
                    break;
                case OP_BG:
                    this.oprBig( expression );
                    break;
                case OP_BG_EQ:
                    this.oprBigEq( expression );
                    break;
                case OP_SM:
                    this.oprSm( expression );
                    break;
                case OP_SM_EQ:
                    this.oprSmEq( expression );
                    break;
                case OP_ASSIGN:
                    this.oprAssign( expression );
                    break;
                case OP_EQ_EQ:
                    this.oprEqEq( expression );
                    break;
                case OP_DOUBLE_AND:
                    this.oprDoubleAnd( expression );
                    break;
                case OP_DOUBLE_OR:
                    this.oprDoubleOr( expression );
                    break;
                case OP_NOT:
                    this.oprNot( expression );
                    break;
                case OP_NOT_EQ:
                    this.oprNotEq( expression );
                    break;
                case OP_NEGATIVE:
                    this.oprNegative( expression );
                    break;
                case OP_POSITIVE:
                    this.oprPositive( expression );
                    break;
                case OP_SINGLE_AND:
                    this.oprSingleAnd( expression );
                    break;
                case OP_SINGLE_OR:
                    this.oprSingleOr( expression );
                    break;
                case OP_SINGLE_POWER:
                    this.oprSinglePower( expression );
                    break;
                case OP_WAVE:
                    this.oprWave( expression );
                    break;
                case OP_IF_ELSE:
                    this.oprIfElse( expression , currentOperation.getOprTargetExpression() );
                    break;
                default:
                    break;
            }
        }

        this.performed = true;
    }

    private void oprIfElse(Expression expression , Expression targetExpression ){

    }

    private void oprDoubleOr(Expression expression) {

    }

    private void oprEqEq(Expression expression) {

    }

    private void oprSmEq(Expression expression) {

    }

    private void oprAssign(Expression expression) {

    }

    private void oprBigEq(Expression expression) {

    }

    private void oprBig(Expression expression) {

    }

    private void oprSm(Expression expression) {

    }

    private void oprNot(Expression expression) {

    }

    private void oprNotEq(Expression expression) {

    }

    private void oprNegative(Expression expression) {

    }

    private void oprPositive(Expression expression) {

    }

    private void oprSingleAnd(Expression expression) {

    }

    private void oprSingleOr(Expression expression) {

    }

    private void oprSinglePower(Expression expression) {

    }

    private void oprWave(Expression expression) {

    }

    private void oprDoubleAnd(Expression expression) {

    }

    private void oprMod(Expression expression) {

    }

    private void oprDiv(Expression expression) {

    }

    private void oprStar(Expression expression) {

    }

    private void oprMinus(Expression oprExpression) {

    }

    private void oprPlus(Expression oprExpression) {
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

    public void setLine(int line) {
        this.line = line;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}
