package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.util.ArrayList;

public class Vector<T extends Label> {

    private int length;

    private ArrayList<T> arrayList;

    private Expression rightExpression;

    private Expression leftExpression;

    public Vector(){
        this.arrayList = new ArrayList<>();
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public T get(int index ){
        return this.arrayList.get(index);
    }

    public void add(T item){
        this.arrayList.add(item);
    }

    public void print() {
        this.arrayList.forEach(Label::print);
    }

    public void setLeftExpression( Expression expression) {
        this.leftExpression = expression;
    }

    public void setRightExpression( Expression expression) {
        this.rightExpression = expression;
    }

    public Expression getLeftExpression (){
        return this.leftExpression;
    }

    public Expression getRightExpression(){
        return this.rightExpression;
    }

    public void assignFlatItem(int index, T label){
        this.arrayList.add(index,label);
    }

    public void assignFlatValue(int left, int right, Object value) throws FieldTypeNotMarchException {
        if (right < left || right > this.length)
            return;

        for ( int i= 0; i<= right - left ; i++){
            Label label = this.arrayList.get(left+i);
            label.setValue(value);
        }
    }
}
