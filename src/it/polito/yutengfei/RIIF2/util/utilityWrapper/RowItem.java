package it.polito.yutengfei.RIIF2.util.utilityWrapper;

/**
 * Created by yutengfei on 10/12/16.
 */
public class RowItem {
    public static final int LIST_STRING = 0;
    public static final int EXPRESSION = 1;

    private Object value;
    private int type;

    public Object getValue() {
        return value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setValue( Object value){ this.value = value ;}


}
