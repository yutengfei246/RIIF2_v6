package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.*;

/**
 * This is the vector class that used to store the vector length and the assignment after the declarator of this
 */

public class VectorImpl<T > {

    private List<T> vector = new LinkedList<>();

    // record the length of this vector
    private Expression length;

    // record the assignment
    private Map<Map.Entry<Expression,Expression>, VectorItem> vectorRecorder
            = new LinkedHashMap<>();


    public void setLength(Expression length){
        this.length = length;
    }

    public Expression getLength(){
        return this.length;
    }

    public void addVectorItem(T item){
        this.vector.add(item);
    }

    public T getVectorItem(int index){
        return this.vector.get(index);
    }


    public void putEntryValue(Map.Entry<Expression,Expression> entry , VectorItem value){
        this.vectorRecorder.put(entry,value);
    }

    public Map<Map.Entry<Expression,Expression>, VectorItem> getEntryValueMap(){
        return this.vectorRecorder;
    }

    public static Map.Entry<Expression,Expression> createExpressionEntryPair(Expression expLeft, Expression expRight) {
        return new AbstractMap.SimpleEntry<Expression, Expression>(expLeft,expRight);
    }

    //TODO :: implement here
    public List<T> getEntryValue(Map.Entry<Expression, Expression> entry) {
        return null;
    }
}
