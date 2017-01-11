package it.polito.yutengfei.RIIF2.parser.typeUtility;

import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

public class UtilityFactory {

    /*Handle not march exception*/
    public static Vector vector(Expression expLeft, Expression expRight) {
        try {
            try {
                return new Vector(expLeft,expRight);
            } catch (FieldTypeNotMarchException e) {
                e.printStackTrace();
            }
        } catch (ExpressionTypeNotMarchException e) {
            e.printStackTrace();
        }

        return null;
    }


}
