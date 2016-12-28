package it.polito.yutengfei.RIIF2.recoder;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;

import java.util.*;

public class RIIF2Recorder implements Recorder{

    private Map<String,RIIF2Recorder> tempRecorderMap = new HashMap<>();
    private Map<String,RIIF2Recorder> componentRecorderMap = new HashMap<>();

    private String identifier = null;
    private Boolean template = null;

    private List<String> eXIdentifiers = null ;
    private List<String> implIdentifiers = null;

    private List<Parameter> parameters = new LinkedList<>();
    private List<Constant> constants = new LinkedList<>();

    private List<ChildComponent> childComponents = new LinkedList<>();
    private List<FailMode> failModes = new LinkedList<>();

    private RIIF2Recorder flash() {
        RIIF2Recorder retRecord = new RIIF2Recorder();

        retRecord.record(this);

        return retRecord;
    }

    private void record(RIIF2Recorder recorder) {
        this.tempRecorderMap.putAll( recorder.getTempRecorderMap() );
        this.componentRecorderMap.putAll( recorder.getComponentRecorderMap() );

        if (recorder.isTemplate())
            this.tempRecorderMap.put( recorder.getIdentifier(), recorder);
        else
            this.componentRecorderMap.put( recorder.getIdentifier(), recorder);
    }

    public void setIdentifier( String identifier ) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public boolean containsComponent(String exId) {
        return this.componentRecorderMap.containsKey(exId);
    }

    public boolean containsTemplate(String implId){
        return this.tempRecorderMap.containsKey(implId);
    }

    private Map<String,RIIF2Recorder> getTempRecorderMap() {
        return tempRecorderMap;
    }

    private Map<String,RIIF2Recorder> getComponentRecorderMap() {
        return componentRecorderMap;
    }

    public boolean isTemplate() {
        return template;
    }

    public void seteXIdentifiers(List<String> eXIdentifiers) {
        this.eXIdentifiers = eXIdentifiers;
    }

    public void setImplIdentifiers(List<String> implIdentifiers) {
        this.implIdentifiers = implIdentifiers;
    }

    public void setTemplate(boolean template) {
        this.template = template;
    }

    private void addParameter(Label<Object> fieldLabel) {
        this.parameters.add((Parameter) fieldLabel);
    }

    private void addConstant(Label<Object> fieldLabel) {
        this.constants.add((Constant) fieldLabel);
    }

    public boolean containsParameter(String id) {
        if (this.parameters == null)

        for (Parameter parameter : this.parameters){
            String name = parameter.getName();
            if (Objects.equals(name, id)){
                return true;
            }
        }
        return false;
    }

    public boolean containsConstant(String id ){
        for (Constant constant : this.constants){
            String name = constant.getName();
            if (Objects.equals(name, id)){
                return true;
            }
        }
        return false;
    }

    public Constant getConstant(String id) {
        for (Constant constant : this.constants){
            String name = constant.getName();
            if (Objects.equals(name, id)){
                return constant;
            }
        }
        return null;
    }

    public boolean contains(String id) {
        return this.containsParameter(id) || this.containsConstant(id) || this.containsChildComponent(id);
    }

    public Parameter getParameter(String id) {
        for (Parameter parameter : this.parameters){
            String name = parameter.getName();
            if (Objects.equals(name, id)){
                return  parameter;
            }
        }
        return null;

    }

    public void addLabel(Label fieldLabel) {

        if (fieldLabel instanceof Constant)
            this.addConstant( fieldLabel );

        if (fieldLabel instanceof Parameter)
            this.addParameter( fieldLabel );

        if (fieldLabel instanceof ChildComponent)
            this.addChildComponent( fieldLabel );
    }

    private void addChildComponent(Label<Object> fieldLabel) {
        this.childComponents.add((ChildComponent) fieldLabel);
    }

    public void print(int level){

        if (this.componentRecorderMap.size() != 0){
            System.out.println("there are components that appeared before ... size is "   + this.componentRecorderMap.size());
            for (Map.Entry<String, RIIF2Recorder> entry : this.componentRecorderMap.entrySet() ){
                System.out.println(" Going to print the recorder with name " + entry.getValue());
                entry.getValue().print8();

                System.out.println("----------------------------------------------------------");
            }
        }
    }

    private void print8(){
        System.out.println("Current Recorder'identifier is  " + this.getIdentifier() );

        if (this.eXIdentifiers != null && this.eXIdentifiers.size() != 0){
            for (String ex : this.eXIdentifiers)
                System.out.println( this.getIdentifier() + " Recorder extends  " + ex);
        }

        if (this.implIdentifiers != null && this.implIdentifiers.size() != 0){
            for (String imp : this.implIdentifiers)
                System.out.println( this.getIdentifier() + " Recorder implements " + imp);
        }

        if (this.parameters != null && this.parameters.size() != 0){
            System.out.println( this.getIdentifier() + " Recorder has parameters number "
                    + this.parameters.size());
            for (Parameter parameter : this. parameters)
                parameter.print();
        }

        if (this.constants != null && this.constants.size() != 0){
            System.out.println( this.getIdentifier() + "Recorder has constants number "
                    + this.constants.size() );
            for (Constant constant : this.constants )
                constant.print();
        }

        if (this.childComponents != null && this.childComponents.size() != 0){
            System.out.println( this.getIdentifier() + " Recorder has Child component number "
                    + this.childComponents.size() );
            for (ChildComponent childComponent : this.childComponents){
                childComponent.print();
            }
        }
    }

    @Override
    public RIIF2Recorder getRIIF2Recorder() {
        if( this.getIdentifier() == null)
            return this;
        return this.flash();
    }

    public boolean containsChildComponent(String id) {
        for (ChildComponent cc : this.childComponents){
            if (Objects.equals(cc.getName(), id))
                return true;
        }

        return false;
    }

    public ChildComponent getCC(String id) {
        for (ChildComponent cc : this.childComponents){
            if (Objects.equals(cc.getName(), id))
                return cc;
        }
        return  null;
    }

    public boolean containsGlobalComponent(String typeCcId) {
        for (Map.Entry<String,RIIF2Recorder> entry : this.componentRecorderMap.entrySet())
            if (Objects.equals(entry.getKey(), typeCcId))
                return true;

        return false;
    }


}
