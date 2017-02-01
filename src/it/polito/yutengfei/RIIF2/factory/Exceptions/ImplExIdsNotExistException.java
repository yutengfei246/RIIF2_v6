package it.polito.yutengfei.RIIF2.factory.Exceptions;

import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

public class ImplExIdsNotExistException extends Throwable {
    public ImplExIdsNotExistException(String exId) {

    }


    private void oprExpressionRunTimeCheck(Expression srcExpression, Expression oprExpression) throws FieldTypeNotMarchException {
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



}
