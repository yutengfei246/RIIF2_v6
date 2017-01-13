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

    public boolean isBoolean(Expression expression) throws FieldTypeNotMarchException {
        if (expression.isPerformed())
            return expression.type().equals(RIIF2Grammar.BOOLEAN);

        this.runOprQueue(expression);
        return expression.type().equals(RIIF2Grammar.BOOLEAN);
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


    private void runOprQueue(Expression srcExpression) throws FieldTypeNotMarchException {

        this.resolvedThis(srcExpression);

        Operation currentOperation;
        while ( ( currentOperation = srcExpression.pop() )  != null ){

            Expression oprExpression = currentOperation.getOprExpression();

            if (oprExpression != null) {
                this.resolvedThis(oprExpression);
                oprExpression.setExpressionOperator(this);
            }

            if (currentOperation.isOprWithSelf())
                this.oprWithSelfExpression(currentOperation.getOpr()
                        ,srcExpression);

            if (currentOperation.isOprWithOneExpression())
                this.oprWithOneExpression(currentOperation.getOpr()
                        ,srcExpression,oprExpression);

            if (currentOperation.isOprWithTwoExpression())
                this.oprWithTwoExpression(currentOperation.getOpr()
                        ,srcExpression,oprExpression,currentOperation.getOprTargetExpression());



        }

        srcExpression.performed();
    }

    private void oprWithSelfExpression(int op, Expression srcExpression) throws FieldTypeNotMarchException {


        if (op == OP_POSITIVE
                || op == OP_NEGATIVE){

            if ( !srcExpression.type().equals(RIIF2Grammar.INTEGER)
                    && !srcExpression.type().equals(RIIF2Grammar.DOUBLE) )
                throw new FieldTypeNotMarchException(srcExpression.value().toString(),
                        srcExpression.getLine(),srcExpression.getColumn());

            switch (op){
                case OP_POSITIVE:
                    srcExpression.setValue(srcExpression.value());
                    break;

                case OP_NEGATIVE:
                    if (srcExpression.type().equals(RIIF2Grammar.INTEGER))
                        srcExpression.setValue(0 - (int) srcExpression.value());

                    if (srcExpression.type().equals(RIIF2Grammar.DOUBLE))
                        srcExpression.setValue(0 - (double) srcExpression.value());
                    break;

                default:break;
            }

        }

        if (op == OP_NOT ){

            if (!srcExpression.type().equals(RIIF2Grammar.BOOLEAN))
                throw new FieldTypeNotMarchException(srcExpression.value().toString(),
                        srcExpression.getLine(),srcExpression.getColumn());

            srcExpression.setValue( !(Boolean)srcExpression.value());
        }

        if (op == OP_WAVE){
            //TODO: wave
        }

    }

    private void oprWithOneExpression(int op, Expression srcExpression, Expression oprExpression) throws FieldTypeNotMarchException {

        if (op == OP_ASSIGN){

            if (!srcExpression.type().equals(oprExpression.getType()))
                throw new FieldTypeNotMarchException(srcExpression.value().toString(),
                        srcExpression.getLine(), srcExpression.getColumn());

            srcExpression.setValue( oprExpression.getValue() );
        }

        if (op == OP_EQ_EQ || op == OP_NOT_EQ) {

            Boolean res = false;
            switch (op){

                case OP_EQ_EQ:
                    res = srcExpression.value() == oprExpression.getValue();
                    break;

                case OP_NOT_EQ:
                    res = srcExpression.value() != oprExpression.getValue();
                    break;
                default:
                    break;
            }

            srcExpression.setType(RIIF2Grammar.BOOLEAN);
            srcExpression.setValue(res);
        }

        if( op == OP_DOUBLE_AND || op == OP_DOUBLE_OR
                || op == OP_SINGLE_AND || op == OP_SINGLE_OR) {

            if (!srcExpression.type().equals(RIIF2Grammar.BOOLEAN)
                    ||!oprExpression.getType().equals(RIIF2Grammar.BOOLEAN))
                throw new FieldTypeNotMarchException(srcExpression.value().toString(),
                        srcExpression.getLine(),srcExpression.getColumn());

            Boolean res = false;

            switch (op){
                case OP_SINGLE_AND:
                    res = (Boolean)srcExpression.value() & (Boolean)srcExpression.getValue();
                    break;

                case OP_DOUBLE_AND:
                    res = (Boolean)srcExpression.value() && (Boolean)srcExpression.getValue();
                    break;

                case OP_SINGLE_OR:
                    res = (Boolean)srcExpression.value() | (Boolean)srcExpression.getValue();
                    break;

                case OP_DOUBLE_OR:
                    res = (Boolean)srcExpression.value() || (Boolean)srcExpression.getValue();
                    break;
            }

            srcExpression.setType(RIIF2Grammar.BOOLEAN);
            srcExpression.setValue(res);
        }


        if (op == OP_BG || op == OP_BG_EQ
                || op == OP_SM || op == OP_SM_EQ) {

            if (  (!srcExpression.type().equals(RIIF2Grammar.INTEGER)
                        && !srcExpression.type().equals(RIIF2Grammar.DOUBLE))
                    ||
                    (!oprExpression.getType().equals(RIIF2Grammar.INTEGER)
                        && !oprExpression.getType().equals(RIIF2Grammar.DOUBLE)))

                throw new FieldTypeNotMarchException(srcExpression.value().toString(),
                        srcExpression.getLine(),srcExpression.getColumn());

            Boolean res = false ;
            switch (op) {
                case OP_BG:
                    res = (double)srcExpression.value() > (double)oprExpression.getValue();
                    break;

                case OP_BG_EQ:
                    res = (double)srcExpression.value() >= (double)oprExpression.getValue();
                    break;

                case OP_SM:
                    res = (double)srcExpression.value() < (double)oprExpression.getValue();
                    break;

                case OP_SM_EQ:
                    res = (double)srcExpression.value() <= (double)oprExpression.getValue();
                    break;

                case OP_EQ_EQ:
                    res = (double)srcExpression.value() == (double)oprExpression.getValue();
                    break;

                case OP_NOT_EQ:
                    res = (double)srcExpression.value() != (double)oprExpression.getValue();
                    break;

                default:
                    break;
            }

            srcExpression.setValue(res);
            srcExpression.setType(RIIF2Grammar.BOOLEAN);
        }

        if (op == OP_PLUS || op == OP_MINUS
                || op == OP_STAR || op == OP_MOD
                || op == OP_DIV || op == OP_SINGLE_POWER) {

            this.expressionRunTimeCheck(srcExpression, oprExpression);

            if (srcExpression.type().equals(RIIF2Grammar.INTEGER)
                    && oprExpression.getType().equals(RIIF2Grammar.INTEGER)) {

                int res = 0;
                switch (op) {
                    case OP_PLUS:
                        res = (int) srcExpression.value() + (int) oprExpression.getValue();
                        break;
                    case OP_MINUS:
                        res = (int) srcExpression.value() - (int) oprExpression.getValue();
                        break;
                    case OP_STAR:
                        res = (int) srcExpression.value() * (int) oprExpression.getValue();
                        break;
                    case OP_DIV:
                        res = (int) srcExpression.value() / (int) oprExpression.getValue();
                        break;
                    case OP_MOD:
                        res = (int) srcExpression.value() % (int) oprExpression.getValue();
                        break;
                    case OP_SINGLE_POWER:
                        res = (int) srcExpression.value() ^ (int) oprExpression.getValue();
                        break;
                    default:
                        break;
                }
                srcExpression.setValue(res);
            }

            if (srcExpression.type().equals(RIIF2Grammar.DOUBLE)
                    && oprExpression.getType().equals(RIIF2Grammar.DOUBLE)) {

                double res = 0.0;
                switch (op) {
                    case OP_PLUS:
                        res = (double) srcExpression.value() * (double) oprExpression.getValue();
                        break;
                    case OP_MINUS:
                        res = (double) srcExpression.value() - (double) oprExpression.getValue();
                        break;
                    case OP_STAR:
                        res = (double) srcExpression.value() * (double) oprExpression.getValue();
                        break;
                    case OP_DIV:
                        res = (double) srcExpression.value() / (double) oprExpression.getValue();
                        break;
                    case OP_MOD:
                        res = (double) srcExpression.value() % (double) oprExpression.getValue();
                        break;
                    default:
                        break;
                }
                srcExpression.setValue(res);
            }
        }

    }

    private void oprWithTwoExpression(int opr, Expression srcExpression, Expression oprExpression, Expression targetExpression) throws FieldTypeNotMarchException {

        if (opr == OP_IF_ELSE) {
            if (!srcExpression.type().equals(RIIF2Grammar.BOOLEAN)
                    || !oprExpression.isBoolean()
                    || !targetExpression.isBoolean())
                throw new FieldTypeNotMarchException(RIIF2Grammar.BOOLEAN,
                        srcExpression.getLine(), srcExpression.getColumn());

            if ((Boolean) srcExpression.value())
                srcExpression.setValue(oprExpression.getValue());
            else
                srcExpression.setValue(targetExpression.getValue());
        }

    }

    private void expressionRunTimeCheck(Expression srcExpression, Expression oprExpression) throws FieldTypeNotMarchException {
        if (srcExpression.type().equals(RIIF2Grammar.DOUBLE)
                && oprExpression.getType().equals(RIIF2Grammar.INTEGER)) {

            Double db = (double) (int) oprExpression.getValue();
            oprExpression.setValue(db);
            oprExpression.setType(RIIF2Grammar.DOUBLE);
        }

        if (srcExpression.type().equals(RIIF2Grammar.INTEGER)
                && oprExpression.getType().equals(RIIF2Grammar.DOUBLE)){

            Double db = (double) (int) srcExpression.value();
            srcExpression.setValue(db);
            srcExpression.setType(RIIF2Grammar.DOUBLE);
        }

        if ( !srcExpression.type().equals(oprExpression.getType()))
            throw new FieldTypeNotMarchException(srcExpression.getValue().toString(),
                    srcExpression.getLine(),srcExpression.getColumn());
    }

    private void resolvedThis(Expression srcExpression) throws FieldTypeNotMarchException {

        if ( srcExpression.type().equals(RIIF2Grammar.USER_DEFINED)){
            List<Label> labels = LabelRetriever.Retriever(srcExpression,this.recorder);

            if (labels == null || labels.size() == 0)
                throw new FieldTypeNotMarchException(srcExpression.value().toString(),
                        srcExpression.getLine(), srcExpression.getColumn());

            if (labels.size() == 1) {
                Label label = labels.get(0);
                srcExpression.setValue(label.getValue());
                srcExpression.setType(label.getType());
            }

            if (labels.size() > 1){

                //TODO:: which is an special case
            }

        }

        if ( srcExpression.type().equals(RIIF2Grammar.SELF) ){

            if (this.currentLabel == null )
                System.exit(1);

            srcExpression.setValue( currentLabel.getValue() );
            srcExpression.setType( currentLabel.getType() );
        }

        if (srcExpression.type().equals(RIIF2Grammar.FUNC_AGG_SINGLE)){
            this.funcAggSignal(srcExpression);
        }

        if (srcExpression.type().equals(RIIF2Grammar.FUNC_GT_N_FAIL)){
            this.funcGtNFail(srcExpression);
        }

        if (srcExpression.type().equals(RIIF2Grammar.FUNC_EXP)){
            this.funcExpLog(srcExpression,EXP);
        }

        if (srcExpression.type().equals(RIIF2Grammar.FUNC_LOG))
            this.funcExpLog(srcExpression,LOG);
    }

    private void funcExpLog(Expression srcExpression, String expLog) throws FieldTypeNotMarchException {

        List<Expression> arguments= srcExpression.getFuncArguments();
        if (arguments.size() != 1)
            throw new FieldTypeNotMarchException(RIIF2Grammar.FUNC_EXP,
                    srcExpression.getLine(),srcExpression.getColumn() );


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

        srcExpression.setValue(res);
        srcExpression.setType(RIIF2Grammar.DOUBLE);
    }

    private void funcGtNFail(Expression srcExpression) {

        //.........
        srcExpression.setType(RIIF2Grammar.DOUBLE);
        srcExpression.setValue(10.0);
    }

    private void funcAggSignal(Expression srcExpression) {

        //....................
        srcExpression.setType(RIIF2Grammar.DOUBLE);
        srcExpression.setValue(10.0); // for now
    }
}
