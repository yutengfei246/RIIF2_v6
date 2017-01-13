package it.polito.yutengfei.RIIF2.util.utilityWrapper;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.recoder.LabelRetriever;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.util.List;
import java.util.Objects;

import static it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression.*;

public class ExpressionOperator {
    private static final String EXP = "exp function";
    private static final String LOG = "log function";
    private final RIIF2Recorder recorder;
    private Label currentLabel = null;

    public ExpressionOperator(RIIF2Recorder recorder) {
        this(recorder,null);
    }

    public ExpressionOperator(RIIF2Recorder recorder, Label currentLabel ){
        this.recorder = recorder;
        this.currentLabel = currentLabel;
    }

    public void setCurrentLabel( Label currentLabel ){
        this.currentLabel = currentLabel;
    }

    public String getType(Expression expression) throws FieldTypeNotMarchException {

        this.resolvedThis(expression);
        return expression.type();
    }

    public Object getValue(Expression expression) throws FieldTypeNotMarchException {
        if (expression.isPerformed()) {
            return expression.value();
        }

        this.runOprQueue(expression);
        return expression.value();
    }

    boolean isInteger(Expression expression) throws FieldTypeNotMarchException {
        if (expression.isPerformed())
            return expression.type().equals(RIIF2Grammar.INTEGER);

        this.runOprQueue(expression);
        return expression.type().equals(RIIF2Grammar.INTEGER);
    }

    boolean isArray(Expression expression) throws FieldTypeNotMarchException {
        if (expression.isPerformed())
            return expression.type().equals(RIIF2Grammar.ARRAY);

        this.runOprQueue(expression);
        return expression.type().equals(RIIF2Grammar.ARRAY);
    }


    private void runOprQueue(Expression oprExpression) throws FieldTypeNotMarchException {

        this.resolvedThis(oprExpression);

        Operation currentOperation;
        while ( ( currentOperation = oprExpression.pop() )  != null ){
            Expression expression = currentOperation.getOprExpression();

            if (expression != null) {
                this.resolvedThis(expression);
                expression.setExpressionOperator(this);
            }

            switch (currentOperation.getOpr()){
                case OP_PLUS: this.oprPlus( expression );break;
                case OP_MINUS:this.oprMinus( expression );break;
                case OP_STAR:this.oprStarDiv(OP_STAR,oprExpression, expression );break;
                case OP_DIV:this.oprStarDiv(OP_DIV, oprExpression, expression );break;
                case OP_MOD:this.oprMod( expression );break;
                case OP_BG:this.oprBig( expression );break;
                case OP_BG_EQ:this.oprBigEq( expression );break;
                case OP_SM:this.oprSm( expression );break;
                case OP_SM_EQ:this.oprSmEq( expression );break;
                case OP_ASSIGN:this.oprAssign( expression );break;
                case OP_EQ_EQ:this.oprEqEq( expression );break;
                case OP_DOUBLE_AND:this.oprDoubleAnd( expression );break;
                case OP_DOUBLE_OR:this.oprDoubleOr( expression );break;
                case OP_NOT:this.oprNot( expression );break;
                case OP_NOT_EQ:this.oprNotEq( expression );break;
                case OP_NEGATIVE:this.oprNegative( oprExpression);break;
                case OP_POSITIVE:this.oprPositive( expression );break;
                case OP_SINGLE_AND:this.oprSingleAnd( expression );break;
                case OP_SINGLE_OR:this.oprSingleOr( expression );break;
                case OP_SINGLE_POWER:this.oprSinglePower( expression );break;
                case OP_WAVE:this.oprWave( expression );break;
                case OP_IF_ELSE:this.oprIfElse( oprExpression,expression , currentOperation.getOprTargetExpression() );break;
                default:break;
            }
        }

        oprExpression.performed();
    }

    private void oprIfElse(Expression oprExpression, Expression expression, Expression targetExpression){

        //TODO:: from here


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

    private void oprNegative(Expression oprExpression) throws FieldTypeNotMarchException {

        if ( !oprExpression.getType().equals(RIIF2Grammar.INTEGER)
                && !oprExpression.getType().equals(RIIF2Grammar.DOUBLE) )
            throw new FieldTypeNotMarchException(oprExpression.value().toString(),
                    oprExpression.getLine(),oprExpression.getColumn());

        if (oprExpression.getType().equals(RIIF2Grammar.INTEGER))
            oprExpression.setValue(0 - (int) oprExpression.getValue() );

        if (oprExpression.getType().equals(RIIF2Grammar.DOUBLE))
            oprExpression.setValue( 0 - (double) oprExpression.getValue() );
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


    private void oprStarDiv(int op, Expression oprExpression, Expression expression) throws FieldTypeNotMarchException {

        this.expressionRunTimeCheck(oprExpression,expression);

        if (oprExpression.type().equals(RIIF2Grammar.INTEGER)
                && expression.getType().equals(RIIF2Grammar.INTEGER) ){

            int res = 0 ;
            switch (op){
                case OP_STAR:
                    res = (int)oprExpression.value() * (int)expression.getValue();
                    break;
                case OP_DIV:
                    res = (int)oprExpression.value() / (int)expression.getValue();
                    break;
                default:
                    break;
            }
            oprExpression.setValue(res);
        }

        if (oprExpression.type().equals(RIIF2Grammar.DOUBLE)
                && expression.getType().equals(RIIF2Grammar.DOUBLE) ) {

            double res = 0.0 ;
            switch (op) {
                case OP_STAR:
                    res = (double) oprExpression.value() * (double) expression.getValue();
                    break;
                case OP_DIV:
                    res = (double) oprExpression.value() / (double) expression.getValue();
                    break;
                default:
                    break;
            }
            oprExpression.setValue(res);
        }

    }

    private void oprMinus(Expression oprExpression) {

    }

    private void oprPlus(Expression oprExpression) {
    }

    private void expressionRunTimeCheck(Expression oprExpression, Expression expression) throws FieldTypeNotMarchException {
        if (oprExpression.type().equals(RIIF2Grammar.DOUBLE)
                && expression.getType().equals(RIIF2Grammar.INTEGER)) {

            Double db = (double) (int) expression.getValue();
            expression.setValue(db);
            expression.setType(RIIF2Grammar.DOUBLE);
        }

        if (oprExpression.type().equals(RIIF2Grammar.INTEGER)
                && expression.getType().equals(RIIF2Grammar.DOUBLE)){

            Double db = (double) (int) oprExpression.value();
            oprExpression.setValue(db);
            oprExpression.setType(RIIF2Grammar.DOUBLE);
        }

        if ( !oprExpression.type().equals(expression.getType()))
            throw new FieldTypeNotMarchException(oprExpression.getValue().toString(),
                    oprExpression.getLine(),oprExpression.getColumn());

    }

    private void resolvedThis(Expression oprExpression) throws FieldTypeNotMarchException {

        if ( oprExpression.type().equals(RIIF2Grammar.USER_DEFINED)){
            List<Label> labels = LabelRetriever.Retriever(oprExpression,this.recorder);

            if (labels == null || labels.size() == 0)
                throw new FieldTypeNotMarchException(oprExpression.value().toString(),
                        oprExpression.getLine(), oprExpression.getColumn());

            if (labels.size() == 1) {
                Label label = labels.get(0);
                oprExpression.setValue(label.getValue());
                oprExpression.setType(label.getType());
            }

            if (labels.size() > 1){

                //TODO:: which is an special case
            }

        }

        if ( oprExpression.type().equals(RIIF2Grammar.SELF) ){

            if (this.currentLabel == null )
                System.exit(1);

            oprExpression.setValue( currentLabel.getValue() );
            oprExpression.setType( currentLabel.getType() );
        }

        if (oprExpression.type().equals(RIIF2Grammar.FUNC_AGG_SINGLE)){
            this.funcAggSignal(oprExpression);
        }

        if (oprExpression.type().equals(RIIF2Grammar.FUNC_GT_N_FAIL)){
            this.funcGtNFail(oprExpression);
        }

        if (oprExpression.type().equals(RIIF2Grammar.FUNC_EXP)){
            this.funcExpLog(oprExpression,EXP);
        }

        if (oprExpression.type().equals(RIIF2Grammar.FUNC_LOG))
            this.funcExpLog(oprExpression,LOG);
    }

    private void funcExpLog(Expression oprExpression, String expLog) throws FieldTypeNotMarchException {

        List<Expression> arguments= oprExpression.getFuncArguments();
        if (arguments.size() != 1)
            throw new FieldTypeNotMarchException(RIIF2Grammar.FUNC_EXP,
                    oprExpression.getLine(),oprExpression.getColumn() );


        Expression expression = arguments.get(0);
        expression.setExpressionOperator(this);

        if ( !expression.getType().equals(RIIF2Grammar.INTEGER)
                && ! expression.getType().equals(RIIF2Grammar.DOUBLE) )
            throw new IllegalArgumentException();

        Double res = 0.0;

        if (Objects.equals(expLog, EXP))
            res = Math.exp((double)  expression.getValue());
        if (Objects.equals(expLog, LOG))
            res = Math.log((double) expression.getValue());

        oprExpression.setValue(res);
        oprExpression.setType(RIIF2Grammar.DOUBLE);
    }

    private void funcGtNFail(Expression oprExpression) {

        //.........
        oprExpression.setType(RIIF2Grammar.DOUBLE);
        oprExpression.setValue(10.0);
    }

    private void funcAggSignal(Expression oprExpression) {

        //....................
        oprExpression.setType(RIIF2Grammar.DOUBLE);
        oprExpression.setValue(10.0); // for now
    }

}
