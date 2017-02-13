package it.polito.yutengfei.RIIF2.util.utilityWrapper;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Platform;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.initializer.ArrayInitializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.EnumType;
import it.polito.yutengfei.RIIF2.recoder.LabelExtractor;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Repository;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;

import java.io.Serializable;
import java.security.cert.Extension;
import java.util.*;

import static it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression.*;

class ExpressionOperator implements Serializable{
    private static final String EXP = "exp function";
    private static final String LOG = "log function";
    private RIIF2Recorder recorder;
    private Label currentLabel = null;

    private Set<Integer> nonCompareOperation = new HashSet<Integer>(){
        {
            add(Expression.OP_PLUS);
            add(Expression.OP_MINUS);
            add(Expression.OP_STAR);
            add(Expression.OP_DIV);
            add(Expression.OP_MOD);
            add(Expression.OP_ASSIGN);
        }
    };

    private Set<Integer> compareOperation = new HashSet<Integer>() {
        {
            add(Expression.OP_BG);
            add(Expression.OP_BG_EQ);
            add(Expression.OP_SM);
            add(Expression.OP_SM_EQ);
            add(Expression.OP_EQ_EQ);
            add(Expression.OP_NOT_EQ);
        }
    };

    ExpressionOperator(){}

    private ExpressionOperator(RIIF2Recorder recorder, Label currentLabel){
        this.recorder = recorder;
        this.currentLabel = currentLabel;
    }

    void setCurrentLabel(Label currentLabel){
        this.currentLabel = currentLabel;
    }

    public String getType(Expression expression) throws FieldTypeNotMarchException {

        return this.findExpressionType(null,expression);
    }

    public Object getValue(Expression expression) throws FieldTypeNotMarchException {
        if (expression.isPerformed()) {
            return expression.value();
        }

        this.runOprQueue(expression);

        return expression.value();
    }

    public List getArray(Expression srcExpression) throws FieldTypeNotMarchException {
        if ( this.isArray(srcExpression) ) {
            Object result = this.getValue(srcExpression);

            if (!( result instanceof ArrayInitializer ) )
                return null;

            List<Expression> array = ((ArrayInitializer) result).getInitializer();

            if (this.currentLabel instanceof TableValueOperator._Row){

                TableValueOperator._Row  row = (TableValueOperator._Row) this.currentLabel;

                for ( int i= 0; i< row.size() ; i ++){
                    Label<Label> label = row.getRowItem(i);
                    Expression expression = array.get(i);

                    expression.setCurrentLabel(label);
                    expression.setRecorder(label.getRecorder());

                    expression.getType();
                }
            }

            return array;
        }


        return null;
    }

    boolean isBoolean(Expression srcExpression) throws FieldTypeNotMarchException {

        String type = this.getType(srcExpression);
        return type.equals(RIIF2Grammar.BOOLEAN);
    }

    boolean isInteger(Expression expression) throws FieldTypeNotMarchException {

        String type = this.getType(expression);
        return type.equals(RIIF2Grammar.INTEGER);
    }

    boolean isArray(Expression expression) throws FieldTypeNotMarchException {

        String type = this.getType(expression);
        return type.equals(RIIF2Grammar.ARRAY);
    }

    boolean isArrayValid(List<Label<Label>> labelList, Expression expression) throws FieldTypeNotMarchException {

        if ( expression.type().equals(RIIF2Grammar.ARRAY) ){
            System.out.print("Going to check array");
            ArrayInitializer arrayInitializer = (ArrayInitializer) expression.value();
            List<Expression> expressionList = arrayInitializer.getInitializer();

            if (expressionList.size() != labelList.size())
                return false;

            for ( int i = 0; i < expressionList.size() ; i ++) {
                Expression exp = expressionList.get(i);
                Label<Label> ll = labelList.get(i);

                if ( !exp.getType().equals(ll.getType()) )
                    return false;
            }
        }

        Iterator<Operation> iterator = expression.getIterator();
        while (iterator.hasNext()){

            Operation operation = iterator.next();
            Expression oprExp = operation.getOprExpression();
            Expression targetExp = operation.getOprTargetExpression();

            if ( oprExp != null && !oprExp.isArrayValid(labelList) ) {
                System.out.println("OprExp is not array valid " + oprExp.value().toString());
                return false;
            }

            if ( targetExp != null && !targetExp.isArrayValid(labelList) ) {
                System.out.println("TargeExp is not array valid ");
                return false;
            }
        }

        return true;
    }

    private void runOprQueue(Expression srcExpression) throws FieldTypeNotMarchException {

        this.resolvedThis(srcExpression);

        Operation currentOperation;
        while ( ( currentOperation = srcExpression.pop() )  != null ){

            Expression oprExpression = currentOperation.getOprExpression();
            Expression targetExpression = currentOperation.getOprTargetExpression();

            if (oprExpression != null) {
                if (srcExpression.getEnumLabel() != null) {
                    oprExpression.setExpressionOperator(
                            new ExpressionOperator(this.recorder, srcExpression.getEnumLabel()));
                }else
                    oprExpression.setExpressionOperator(this);

                srcExpression.setEnumLabel(null);
            }

            if (targetExpression != null ){
                targetExpression.setExpressionOperator(this);
            }


            if ( ( oprExpression != null && oprExpression.isArray() )
                    || srcExpression.type().equals(RIIF2Grammar.ARRAY)  ){

                //TODO: goto Array operation

                if (currentOperation.isOprWithSelf())
                    this.oprArrayWithSelfExpression(currentOperation.getOpr(),
                            srcExpression);

                if (currentOperation.isOprWithTwoExpression())
                    this.oprArrayWithOneExpression(currentOperation.getOpr(),
                            srcExpression,oprExpression);

                if (currentOperation.isOprWithTwoExpression())
                    this.oprArrayWithTwoExpression(currentOperation.getOpr(),
                            srcExpression,oprExpression,targetExpression);
            }

            else {

                if (currentOperation.isOprWithSelf())
                    this.oprWithSelfExpression(currentOperation.getOpr()
                            , srcExpression);

                if (currentOperation.isOprWithOneExpression())
                    this.oprWithOneExpression(currentOperation.getOpr()
                            , srcExpression, oprExpression);

                if (currentOperation.isOprWithTwoExpression())
                    this.oprWithTwoExpression(currentOperation.getOpr()
                            , srcExpression, oprExpression, targetExpression);
            }
        }

        srcExpression.performed();
    }

    private void oprArrayWithSelfExpression(int opr, Expression srcExpression) {

    }

    private void oprArrayWithOneExpression(int opr, Expression srcExpression, Expression oprExpression) {

    }

    private void oprArrayWithTwoExpression(int opr, Expression srcExpression, Expression oprExpression, Expression oprTargetExpression) throws FieldTypeNotMarchException {

        if (opr == OP_IF_ELSE) {

            System.out.println("oper");

            if (!srcExpression.type().equals(RIIF2Grammar.BOOLEAN) )
                throw new FieldTypeNotMarchException(RIIF2Grammar.BOOLEAN,
                        srcExpression.getLine(), srcExpression.getColumn());

            if ((Boolean) srcExpression.value()) {
                srcExpression.setValue(oprExpression.getValue());
                srcExpression.setType(oprExpression.getType());
            }

            else {
                srcExpression.setValue(oprTargetExpression.getValue());
                srcExpression.setType(oprExpression.getType());
            }
        }
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
                    res = srcExpression.value().equals(oprExpression.getValue() ) ;
                    break;

                case OP_NOT_EQ:
                    res = ! srcExpression.value().equals(oprExpression.getValue());
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
                        res = (double) srcExpression.value() + (double) oprExpression.getValue();
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
            if (!srcExpression.type().equals(RIIF2Grammar.BOOLEAN) )
                throw new FieldTypeNotMarchException(RIIF2Grammar.BOOLEAN,
                        srcExpression.getLine(), srcExpression.getColumn());

            if ((Boolean) srcExpression.value()) {
                srcExpression.setValue(oprExpression.getValue());
                srcExpression.setType(oprExpression.getType());
            }
            else {
                srcExpression.setValue(targetExpression.getValue());
                srcExpression.setType(oprExpression.getType());
            }
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
        LabelExtractor labelExtractor = new LabelExtractor(srcExpression,this.recorder);

        if ( srcExpression.type().equals(RIIF2Grammar.USER_DEFINED)){

            DeclaratorId Id = (DeclaratorId) srcExpression.value();
            String id = Id.getPrimitiveId().getId();

            if (this.currentLabel.isEnumType() ){
                srcExpression.setType(RIIF2Grammar.STRING);
                srcExpression.setValue(id);
            }

            else {
                Label<Label> extractedLabel  = labelExtractor.extractor();

                if (extractedLabel== null )
                    throw new FieldTypeNotMarchException(id, srcExpression.getLine(), srcExpression.getColumn());


                srcExpression.setValue(extractedLabel.getValue());
                srcExpression.setType(extractedLabel.getType());

                if (extractedLabel.isEnumType()){
                    srcExpression.setEnumLabel(extractedLabel);
                }
            }
        }

        if ( srcExpression.type().equals(RIIF2Grammar.SELF) ){

            if (this.currentLabel == null )
                System.exit(1);

            srcExpression.setValue(this.currentLabel.getValue());
            srcExpression.setType(this.currentLabel.getType());

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

    private String findExpressionType(List<Label<Label>> labelList, Expression srcExpression) throws FieldTypeNotMarchException {

        //TODO: pay attention, should not consider the Array Type, or We could consider Array and also the operation on Array
        // srcExpression's type
        String srcType = this.typeResolver(labelList, srcExpression);

        if ( srcType == null)
            throw new FieldTypeNotMarchException( srcExpression.value().toString() ,srcExpression.getLine(),srcExpression.getColumn());

        Iterator<Operation> iterator = srcExpression.getIterator();

        while (iterator.hasNext()) {

            Operation currentOperation = iterator.next();

            Expression oprExpression = currentOperation.getOprExpression();
            Expression targetExpression = currentOperation.getOprTargetExpression();

            if (oprExpression != null) {
                if (srcExpression.getEnumLabel() != null) {
                    oprExpression.setExpressionOperator(
                            new ExpressionOperator(this.recorder, srcExpression.getEnumLabel()));
                } else
                    oprExpression.setExpressionOperator(this);

                srcExpression.setEnumLabel(null);
            }

            if (targetExpression != null) {
                targetExpression.setExpressionOperator(this);
            }

            // the operation with expression self, the type should not change
            if (currentOperation.isOprWithSelf())
                continue;


            // the operation with one expression
            if (currentOperation.isOprWithOneExpression()) {

                assert oprExpression != null;
                String oprType = oprExpression.getType();

                int opr = currentOperation.getOpr();

                assert oprType != null;



                if (!srcType.equals(oprType)) {

                    if ( (srcType.equals(RIIF2Grammar.DOUBLE) && oprType.equals(RIIF2Grammar.INTEGER) ) ||
                            (srcType.equals(RIIF2Grammar.INTEGER) && oprType.equals(RIIF2Grammar.DOUBLE)) ){
                        srcType = RIIF2Grammar.DOUBLE;
                    }
                    else throw new FieldTypeNotMarchException(FieldTypeNotMarchException.OPERATION, oprType, oprExpression.getLine(), oprExpression.getColumn());
                }
                if (this.nonCompareOperation.contains(opr))
                    continue;

                else if (this.compareOperation.contains(opr)) {
                    srcType = RIIF2Grammar.BOOLEAN;
                    continue;
                }
                else
                    throw new FieldTypeNotMarchException(oprType,oprExpression.getLine(),oprExpression.getColumn());
            }

            // the operation with two expression ? :
            if (currentOperation.isOprWithTwoExpression()) {
                if (!srcType.equals(RIIF2Grammar.BOOLEAN))
                    throw new FieldTypeNotMarchException(srcType, srcExpression.getLine(), srcExpression.getColumn());

                assert oprExpression != null;
                String oprType = oprExpression.getType();

                assert targetExpression != null;
                String targetType = targetExpression.getType();

                assert oprType != null;
                assert targetType != null;

                if (!oprType.equals(targetType))
                    throw new FieldTypeNotMarchException(targetType, targetExpression.getLine(), targetExpression.getColumn());

                srcType = oprType;
            }
        }

        return srcType;
    }

    // the method return the given expression type, not store it into the expression
    private String typeResolver(List<Label<Label>> labelList, Expression expression) throws FieldTypeNotMarchException {


        if (labelList != null )
            System.out.println("the labelList is not null in this case --" + expression.type() + " " + expression.value().toString());

        if ( labelList != null && expression.type().equals(RIIF2Grammar.ARRAY) ) {

            ArrayInitializer arrayInitializer = (ArrayInitializer) expression.value();
            List<Expression> expressionList = arrayInitializer.getInitializer();

            for (int i = 0; i < expressionList.size(); i++) {

                Expression expItem =  expressionList.get(i);
                expItem.setRecorder(this.recorder);
                expItem.setCurrentLabel(this.currentLabel);

                Label<Label> labelLabel = labelList.get(i);

                if (!labelLabel.getType().equals(expItem.getType()))
                    throw new FieldTypeNotMarchException(this.currentLabel.getName(), expItem.getLine(), expItem.getColumn());
            }
        }

        if ( expression.type().equals(RIIF2Grammar.SELF)){
            expression.setValue(this.currentLabel.getValue());
            expression.setType(this.currentLabel.getType());
            return this.currentLabel.getType();
        }

        // the type is assigned to unit
        if ( this.currentLabel.getName().equals(RIIF2Grammar.UNIT)) {
            return expression.type();
        }

        // goto the function arguments and check if those function arguments are valid
        if ( expression.type().equals(RIIF2Grammar.FUNC_EXP) ){

            for (Expression expression1 : expression.getFuncArguments()) {
                expression1.setCurrentLabel(this.currentLabel);
                expression1.setRecorder(this.recorder);

                if (!expression1.isValid())
                    throw new FieldTypeNotMarchException(this.currentLabel.getName(),expression1.getLine(), expression1.getColumn());
            }

            return RIIF2Grammar.DOUBLE;
        }

        if (expression.type().equals(RIIF2Grammar.FUNC_AGG_SINGLE)){

            /*
            for (Expression expression1 : expression.getFuncArguments()) {
                expression1.setCurrentLabel(this.currentLabel);
                expression1.setRecorder(this.recorder);

                if (!expression1.isValid())
                    throw new FieldTypeNotMarchException(this.currentLabel.getName(),expression1.getLine(), expression1.getColumn());
            }
            */



            return RIIF2Grammar.DOUBLE;
        }

        if (expression.type().equals(RIIF2Grammar.FUNC_GT_N_FAIL)){

            /*
            for (Expression expression1 : expression.getFuncArguments()) {
                expression1.setCurrentLabel(this.currentLabel);
                expression1.setRecorder(this.recorder);

                if (!expression1.isValid())
                    throw new FieldTypeNotMarchException(this.currentLabel.getName(),expression1.getLine(), expression1.getColumn());
            }

*/


            return RIIF2Grammar.DOUBLE;
        }

        if (this.currentLabel instanceof Platform){
            if (Repository.containsComponent(expression.value().toString())){
                return RIIF2Grammar.PLATFORM;
            }
            return null;
        }

        if ( !expression.type().equals(RIIF2Grammar.USER_DEFINED))
            return expression.type();

        DeclaratorId declaratorId = (DeclaratorId) expression.value();
        String id = declaratorId.getPrimitiveId().getId();

        if ( this.currentLabel.isEnumType() ){
            EnumType enumType = this.currentLabel.getEnumType();
            enumType.contains(id);

            return RIIF2Grammar.ENUM;
        }

        LabelExtractor labelExtractor = new LabelExtractor(expression,this.recorder);
        Label<Label> extractedLabel = labelExtractor.extractor();

        if (extractedLabel == null) {
            System.out.println("EvtractedLabel is null ");
            return null;
        }

        if ( extractedLabel.isEnumType() )
            expression.setEnumLabel(extractedLabel);

        return extractedLabel.getType();
    }

    public void setRecorder(RIIF2Recorder recorder) {
        this.recorder = recorder;
    }
}
