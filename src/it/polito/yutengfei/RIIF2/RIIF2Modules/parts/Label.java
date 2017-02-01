package it.polito.yutengfei.RIIF2.RIIF2Modules.parts;

import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.initializer.ListInitializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;
import it.polito.yutengfei.RIIF2.parser.typeUtility.EnumType;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

import java.io.Serializable;
import java.util.*;

public abstract class Label<T extends Label> implements Serializable {

    private final RIIF2Recorder recorder;

    private String name;
    private String type;
    private Object value;

    private VectorImpl<Expression> vectorImpl;
    private Map<String,T> associativeMap;

    private Map<String,Attribute> attributeMap;

    //TODO: the implementation of Table
    private Map<String,List<Object> > sharpMap; // this is used only when the label is Table;

    private EnumType enumType;

    private Stack<Object> valueStack = new Stack<>();

    private int _self1 = -1;
    private int _self2 = -1;

    protected Label(RIIF2Recorder recorder) {
        this.recorder = recorder;
    }

    public void set_self1(int i){
        this._self1 = i;
    }

    public void set_self2(int i){
        this._self2  = i;
    }

    public void resetSelf(){
        this._self1 = -1;
        this._self2 = -1;
    }

    public void printSelf(){
        System.out.println( this._self1  +" " + this._self2);
    }

    public void setSelfValue(Object selfValue){
        if ( this._self1 == -1 && this._self2 == -1 )
            this.value = selfValue;

        LinkedList<Object> lst = (LinkedList<Object>) this.value;
        if (this._self1 != -1 && this._self2 == -1){
            LinkedList<Object> newLst = new LinkedList<>();

            for (int i = 0 ; i < this._self1 ; i++)
                newLst.add(lst.get(i));
            newLst.add(selfValue);
            for (int i = this._self1; i <  lst.size() ; i++)
                newLst.add(lst.get(i));

            this.value = newLst;
        }

        if (this._self1 != -1 && this._self2 != -1){
            Item item = (Item) lst.get(this._self1);
            item.getUnitItem(this._self2).setValue(selfValue);
        }
    }

    public Object getSelfValue(){
        if ( this._self1 == -1 && this._self2 == -1 )
            return this.value;

        if (!(this.getValue() instanceof List))
            return null;

        List lst = (List) this.getValue();
        if (this._self1 != -1 && this._self2 == -1)
            return lst.get(this._self1);

        if (this._self1 != -1 && this._self2 != -1 )
            return ((Item)lst.get(this._self1)).getUnitItem(this._self2).getValue();

        return null;
    }

    public String getSelfValueType(){

        if (this._self1 == -1 && this._self2 == -1)
            return this.type;

        if (this._self1 != -1  && this._self2 == -1){
            //TODO:: reserved

        }

        if (this._self1 != -1 && this._self2 != -1 ){
            return ((Item)((List) this.getValue()).get(this._self1)).getUnitItem(this._self2).getType();
        }

        return null;
    }

    /**
     * valueStack setters and getters
     */
    public void putValue(Object value) throws FieldTypeNotMarchException {
    // TODO: need to check the given value

        if (value == null) return;

        // if it is String, we could have two possibility : Enum and Unit
        if (value instanceof String) {
            String valueString = (String) value;

            if (this.isEnumType())
                this.value = valueString;

            if (this instanceof Attribute && this.getName().equals(RIIF2Grammar.UNIT))
                this.value = valueString;
        }

        // when put value into the stack, we need to check if the given value is good for this label
        if (value instanceof Expression ){
            Expression expValue = (Expression) value;

            if (expValue.getType().equals(this.getType()))
                this.valueStack.push(expValue);
            else
                throw new FieldTypeNotMarchException(this.getName(), expValue.getLine(), expValue.getColumn());
        }


        if (value instanceof ListInitializer ){
            ListInitializer listValue = (ListInitializer) value;
            List<Object> listObject = listValue.getInitializer();
            switch (this.getType()) {
                case RIIF2Grammar.LIST:
                    this.value = listObject; // in this case, it is List<Object>
                    break;
                case RIIF2Grammar.LIST_STRING: {
                    Object find = listObject.stream()
                            .filter(o -> !(o instanceof String))
                            .findAny().orElse(null);

                    // in this case, there are some Item inside the list was not String Type.
                    if (find != null)
                        throw new FieldTypeNotMarchException(this.getName(), listValue.getLine(), listValue.getColumn());
                    else
                        this.valueStack.push(listObject);
                    break;
                }
                case RIIF2Grammar.LIST_INTEGER: {
                    Object find = listObject.stream()
                            .filter(o -> !(o instanceof Integer))
                            .findAny().orElse(null);

                    // in this case, there are some Item inside the list was not Integer Type.
                    if (find != null)
                        throw new FieldTypeNotMarchException(this.getName(), listValue.getLine(), listValue.getColumn());
                    else
                        this.valueStack.push(listObject);
                    break;
                }
                case RIIF2Grammar.LIST_DOUBLE: {
                    Object find = listObject.stream()
                            .filter(o -> !(o instanceof Double))
                            .findAny().orElse(null);

                    // in this case, there are some Item inside the list was not Double Type.
                    if (find != null)
                        throw new FieldTypeNotMarchException(this.getName(), listValue.getLine(), listValue.getColumn());
                    else
                        this.valueStack.push(listObject);
                    break;
                }
                default:
                    throw new FieldTypeNotMarchException(this.getName(), listValue.getLine(), listValue.getColumn());
            }
        }


    }

    public Iterator<Object> getStackValueIterator(){
        return this.valueStack.iterator();
    }

    public Object popValue(){
        return this.valueStack.pop();
    }

    /**
     * name value type setters and getters
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue(){
        return this.value;
    }

    // TODO: need to check the given value
    public void setValue(Object value) throws FieldTypeNotMarchException {

        if (value == null)
            return;

        // if it is String, we could have two possibility : Enum and Unit
        if (value instanceof String) {
            String valueString = (String) value;

            if (this.isEnumType())
                this.value = valueString;

            if (this instanceof Attribute && this.getName().equals(RIIF2Grammar.UNIT))
                this.value = valueString;
        }

        if (value instanceof RIIF2Recorder){
            RIIF2Recorder recorder = (RIIF2Recorder) value;

            if ( this instanceof ChildComponent )
                this.value = recorder;
        }

        // check the given value if it is an Expression, we should check it is an valid one
        if (value instanceof Expression) {
            Expression expValue = (Expression) value;

            if ( expValue.getType().equals(this.getType()) )
                this.value = value;
            else
                throw new FieldTypeNotMarchException(this.getName(),expValue.getLine(),expValue.getColumn());
        }

        if (value instanceof ListInitializer ){
            ListInitializer listValue = (ListInitializer) value;
            List<Object> listObject = listValue.getInitializer();

            switch (this.getType()) {
                case RIIF2Grammar.LIST:
                    this.value = listObject; // in this case, it is List<Object>
                    break;
                case RIIF2Grammar.LIST_STRING: {
                    Object find = listObject.stream()
                            .filter(o -> !(o instanceof String))
                            .findAny().orElse(null);

                    // in this case, there are some Item inside the list was not String Type.
                    if (find != null)
                        throw new FieldTypeNotMarchException(this.getName(), listValue.getLine(), listValue.getColumn());
                    else
                        this.value = listObject;

                    break;
                }
                case RIIF2Grammar.LIST_INTEGER: {
                    Object find = listObject.stream()
                            .filter(o -> !(o instanceof Integer))
                            .findAny().orElse(null);

                    // in this case, there are some Item inside the list was not Integer Type.
                    if (find != null)
                        throw new FieldTypeNotMarchException(this.getName(), listValue.getLine(), listValue.getColumn());
                    else
                        this.value = listObject;
                    break;
                }
                case RIIF2Grammar.LIST_DOUBLE: {
                    Object find = listObject.stream()
                            .filter(o -> !(o instanceof Double))
                            .findAny().orElse(null);

                    // in this case, there are some Item inside the list was not Double Type.
                    if (find != null)
                        throw new FieldTypeNotMarchException(this.getName(), listValue.getLine(), listValue.getColumn());
                    else
                        this.value = listObject;
                    break;
                }
                default:
                    throw new FieldTypeNotMarchException(this.getName(), listValue.getLine(), listValue.getColumn());
            }
        }


    }

    /**
     * enumType setters and getters
     */
    public void setEnumType(EnumType enumType) {
        this.enumType = enumType;
    }

    public EnumType getEnumType(){
        return this.enumType;
    }

    public boolean isEnumType(){
        return this.getEnumType() != null ;
    }

    /**
     * attribute setters and getters
     */
    public void setAttribute(Boolean b ) {
        if (b) this.attributeMap = new HashMap<>();
    }

    public Boolean hasAttribute() {
        return this.attributeMap != null;
    }

    public void putAttribute(String attributeName, Attribute attribute) {
        this.attributeMap.put(attributeName,attribute);
    }

    public Attribute getAttribute(String attributeName) {
        return this.attributeMap.get(attributeName);
    }

    public Boolean containsAttribute(String attributeName) {
        return this.attributeMap.containsKey(attributeName);
    }

    /**
     * associative setters and getters
     */
    public Boolean isAssociative() {
        return this.associativeMap != null;
    } // specify this label is a associativeLabel

    public void setAssociative(Boolean b) {
        if (b) this.associativeMap = new HashMap<>();
    }

    public void putAssociative(String associativeName, T entry){
        this.associativeMap.put(associativeName, entry);
    }

    public T getAssociative(String associativeName) {
        return this.associativeMap.get(associativeName);
    }

    public Boolean containsAssociative(String associativeName) {
        return this.associativeMap.containsKey(associativeName);
    }

    /**
     * vector setters and getters
     */
    public void setVector(Boolean b) {
        if (b) this.vectorImpl = new VectorImpl<>();
    }

    public Boolean isVector() {
        return this.vectorImpl != null;
    }

    public void setVectorLength(Expression expression) {
        this.vectorImpl.setLength(expression);
    }

    public Expression getVectorLength() {
        return this.vectorImpl.getLength();
    }

    public void putVectorEntryValue(Map.Entry<Expression,Expression> entry, VectorItem object ) {
        this.vectorImpl.putEntryValue(entry, object);
    }

    public List<Expression> getVectorEntryValue(Map.Entry<Expression,Expression> entry) {
        return this.vectorImpl.getEntryValue(entry);
    }

    public void addVectorItem(Expression item){
        this.vectorImpl.addVectorItem(item);
    }

    public Expression getVectorItem(int index){
        return this.vectorImpl.getVectorItem(index);
    }


    /***********************************************************************************/

    public abstract void setPlatform(RIIF2Recorder recorder);

    public abstract RIIF2Recorder getPlatform();

    public abstract void print();

    public void printAttribute(){
        if (this.hasAttribute()) {
            System.out.println("----------------");
            this.attributeMap.forEach((s, attribute) -> {
                attribute.print();
            });
            System.out.println("-----------------");
        }
    }

    public  void printAssociative(){

        if (this.isAssociative()) {


            this.associativeMap.forEach((s, t) -> {
                System.out.println("----------------start associative " + s + "--------------------");
                t.print();
                System.out.println("----------------end associative " + s + "--------------------");
            });

        }

    }
}
