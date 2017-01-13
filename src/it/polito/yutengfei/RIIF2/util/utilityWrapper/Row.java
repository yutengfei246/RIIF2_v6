package it.polito.yutengfei.RIIF2.util.utilityWrapper;

public class Row {


    public static final int EXPRESSION = 1;
    public static final int ROW_ITEMS_ARRAY = 2;

    private int type;
    private Object value;

    public int getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
