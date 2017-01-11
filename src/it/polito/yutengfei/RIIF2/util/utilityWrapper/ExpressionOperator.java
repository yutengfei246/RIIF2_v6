package it.polito.yutengfei.RIIF2.util.utilityWrapper;


import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import static it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression.*;

public class ExpressionOperator {
    private final RIIF2Recorder recorder;

    public ExpressionOperator(RIIF2Recorder recorder) {
        this.recorder = recorder;
    }

    public String getType(Expression expression) {
        if ( expression.isPerformed() )
            return expression.type();

        this.runOprQueue(expression);
        return expression.type();
    }

    public Object getValue(Expression expression) {
        if (expression.isPerformed())
            return expression.value();

        this.runOprQueue(expression);
        return expression.value();
    }

    boolean isInteger(Expression expression) {
        if (expression.isPerformed())
            return expression.type().equals(RIIF2Grammar.INTEGER);

        this.runOprQueue(expression);
        return expression.type().equals(RIIF2Grammar.INTEGER);
    }

    boolean isArray(Expression expression) {
        if (expression.isPerformed())
            return expression.type().equals(RIIF2Grammar.ARRAY);

        this.runOprQueue(expression);
        return expression.type().equals(RIIF2Grammar.ARRAY);
    }


    private void runOprQueue(Expression oprExpression)  {

        Operation currentOperation;
        while ( ( currentOperation = oprExpression.pop() )  != null ){
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

        oprExpression.performed();
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

}
