package it.polito.yutengfei.RIIF2.recoder;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;

import java.io.Serializable;
import java.util.*;

public class RIIF2Recorder implements Recorder, Serializable {

    private Boolean template = false;

    private String identifier = null;

    /*deep copy*/
    private Map<String,RIIF2Recorder> exRecorderMap = new LinkedHashMap<>();
    private Map<String,RIIF2Recorder> implRecorderMap = new LinkedHashMap<>();

    private List<Parameter> parameters = new LinkedList<>();
    private List<Constant> constants = new LinkedList<>();

    private List<ChildComponent> childComponents = new LinkedList<>();
    private List<FailMode> failModes = new LinkedList<>();

    private Platform platform = null;


    /***********************************Setters and Getters************************************/

    public void setIdentifier( String identifier ) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setTemplate(boolean template) {
        this.template = template;
    }

    public boolean isTemplate() {
        return template;
    }

    public void putExRecorder(String key,RIIF2Recorder value ) {
        this.exRecorderMap.put(key,value);
    }

    public void putImplRecorder(String key, RIIF2Recorder value) {
        this.implRecorderMap.put(key, value);
    }

    public RIIF2Recorder getImplRecorder(String hierRecorderName) {
        return this.implRecorderMap.get(hierRecorderName);
    }

    public RIIF2Recorder getExRecorder(String key ){
        return this.exRecorderMap.get(key);
    }

    public Map<String,RIIF2Recorder> getExRecorderMap() {
        return this.exRecorderMap;
    }

    public Map<String,RIIF2Recorder> getImplRecorderMap() {
        return this.implRecorderMap;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Platform getPlatform(){
        return this.platform;
    }

    private void addParameter(Parameter fieldLabel) {
        this.parameters.add(fieldLabel);
    }

    private void addConstant(Constant fieldLabel) {
        this.constants.add(fieldLabel);
    }

    private void addFailMode(FailMode fieldLabel) {
        this.failModes.add(fieldLabel);
    }

    private void addChildComponent(ChildComponent fieldLabel) {
        this.childComponents.add( fieldLabel);
    }

    public void addLabel(Label fieldLabel) {

        if (fieldLabel instanceof Constant)
            this.addConstant((Constant) fieldLabel);

        if (fieldLabel instanceof Parameter)
            this.addParameter((Parameter) fieldLabel);

        if (fieldLabel instanceof ChildComponent)
            this.addChildComponent((ChildComponent) fieldLabel);

        if (fieldLabel instanceof FailMode)
            this.addFailMode((FailMode) fieldLabel);
    }

    public boolean containsParameter(String id) {
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

    public boolean containsChildComponent(String id) {
        for (ChildComponent cc : this.childComponents){
            if (Objects.equals(cc.getName(), id))
                return true;
        }
        return false;
    }

    public boolean containsFailMode(String id){
        for (FailMode failMode : this.failModes){
            if (Objects.equals(failMode.getName(),id))
                return true;
        }
        return false;
    }

    public boolean contains(String id) {
        return this.containsParameter(id)
                || this.containsConstant(id)
                || this.containsChildComponent(id)
                || this.containsFailMode(id);
    }

    public Constant getConstant(String id) {
        return this.constants.stream()
                .filter(c -> c.getName().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Parameter getParameter(String id) {
        return this.parameters.stream()
                .filter(p -> p.getName().equals(id))
                .findFirst()
                .orElse(null);
    }

    public FailMode getFailMode(String identifier) {
        return this.failModes.stream()
                .filter(fm -> fm.getName().equals(identifier))
                .findFirst()
                .orElse(null);
    }

    public ChildComponent getChildComponent(String id) {
        return this.childComponents.stream()
                .filter( cc -> cc.getName().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Label<Label> getLabel(String labelName ){
        return this.getParameter(labelName) != null
                ? this.getParameter(labelName)
                : this.getConstant(labelName) != null
                ? this.getConstant(labelName)
                : this.getChildComponent(labelName) != null
                ? this.getChildComponent(labelName)
                : this.getFailMode(labelName) != null
                ? this.getFailMode(labelName)
                : null ;
    }

    /*only can find in this recorder or parent recorder */
    public Label getAssignmentLabel(String labelName) {
        if (this.getLabel(labelName) != null )
            return this.getLabel(labelName);

        for (Map.Entry<String,RIIF2Recorder> entry : this.exRecorderMap.entrySet()){
            if (entry.getValue().getAssignmentLabel(labelName) != null)
                return entry.getValue().getAssignmentLabel(labelName);
        }

        return null;
    }
    public Label getImposeLabel(String labelName) {
        if (this.getLabel(labelName) != null )
            return this.getLabel(labelName);

        for (Map.Entry<String,RIIF2Recorder> entry : this.implRecorderMap.entrySet()){
            if (entry.getValue().getImposeLabel(labelName) != null)
                return entry.getValue().getImposeLabel(labelName);
        }

        return null;
    }

    public Label getSetLabel(String labelName){

        if (this.isTemplate()){

            for (Map.Entry<String, RIIF2Recorder > entry : this.exRecorderMap.entrySet() ){

                if (entry.getValue().getLabel(labelName) != null)
                    return entry.getValue().getLabel(labelName);

                if (entry.getValue().getSetLabel(labelName) != null)
                    return entry.getValue().getSetLabel(labelName);
            }
        }
        if ( !this.isTemplate() ) {

            for (Map.Entry<String, RIIF2Recorder> entry : this.implRecorderMap.entrySet()) {

                if (entry.getValue().getLabel(labelName) != null)
                    return entry.getValue().getLabel(labelName);


                if (entry.getValue().getSetLabel(labelName) != null)
                    return entry.getValue().getSetLabel(labelName);
            }
        }

        return null;
    }


    @Override
    public RIIF2Recorder getRIIF2Recorder() {
        if( this.getIdentifier() == null)
            return this;

        Recorder.record(this);
        return new RIIF2Recorder();
    }

    @Override
    public void javaBean() {

    }


    public void print8(){
        this.implRecorderMap.forEach((s, riif2Recorder) -> riif2Recorder.print8());
        this.exRecorderMap.forEach((s, riif2Recorder) -> riif2Recorder.print8());
        this.print();
    }

    private void print(){
        this.parameters.forEach(Parameter::print);
        this.constants.forEach(Constant::print);
        this.failModes.forEach(FailMode::print);
        this.childComponents.forEach(ChildComponent::print);
    }
}
