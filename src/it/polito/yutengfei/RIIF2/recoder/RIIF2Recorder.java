package it.polito.yutengfei.RIIF2.recoder;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;

import java.io.*;
import java.util.*;

public class RIIF2Recorder implements Recorder, Serializable {

    private Boolean template ;
    private String identifier ;

    /*RIIF2 definition*/
    private String definition;

    /*deep copy*/
    private Map<String,RIIF2Recorder> exRecorderMap = new LinkedHashMap<>();
    private Map<String,RIIF2Recorder> implRecorderMap = new LinkedHashMap<>();

    /*RIIF2 variables*/
    private List<Parameter> parameters = new LinkedList<>();
    private List<Constant> constants = new LinkedList<>();

    private List<ChildComponent> childComponents = new LinkedList<>();
    private List<FailMode> failModes = new LinkedList<>();

    private List<Platform> platforms = new LinkedList<>();

    /***********************************Setters and Getters************************************/

    public void setDefinition(String definition){
        this.definition = definition;
    }

    String getDefinition() {
        return this.definition;
    }

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

    public boolean containsImplRecorder(String implNameRecorderName ) {
        return this.implRecorderMap.containsKey(implNameRecorderName);
    }

    public boolean containsExRecorder(String exNameRecorderName){
        return this.exRecorderMap.containsKey(exNameRecorderName);
    }

    public List<Parameter> getParameters() {
        return this.parameters;
    }

    public List<Constant> getConstants() {
        return this.constants;
    }

    public List<Parameter> getAllParameters() {
        List<Parameter> parameterList = new LinkedList<>();

        this.exRecorderMap.forEach((s, recorder) -> parameterList.addAll(recorder.getAllParameters()));
        this.implRecorderMap.forEach((s, recorder) -> parameterList.addAll(recorder.getAllParameters()));

        parameterList.addAll(this.getParameters());

        return parameterList;
    }

    public List<Constant> getAllConstants() {
        List<Constant> constantList = new LinkedList<>();

        this.exRecorderMap.forEach((s, recorder) -> constantList.addAll(recorder.getAllConstants()));
        this.implRecorderMap.forEach((s, recorder) -> constantList.addAll(recorder.getAllConstants()));

        constantList.addAll(this.getConstants());

        return constantList;
    }


    public List<ChildComponent> getChildComponents() {
        return childComponents;
    }

    public List<FailMode> getFailModes() {
        return this.failModes;
    }

    public List<FailMode> getAllFailModes() {
        List<FailMode> failModeList = new LinkedList<>();

        this.exRecorderMap.forEach((s, recorder) -> failModeList.addAll(recorder.getAllFailModes()));
        this.implRecorderMap.forEach((s, recorder) -> failModeList.addAll(recorder.getAllFailModes()));

        failModeList.addAll(this.getFailModes());

        return failModeList;
    }

    public List<ChildComponent> getAllChildComponents() {
        List<ChildComponent> childComponentList = new LinkedList<>();

        this.exRecorderMap.forEach((s, recorder) -> childComponentList.addAll(recorder.getAllChildComponents()));
        this.implRecorderMap.forEach((s, recorder) -> childComponentList.addAll(recorder.getAllChildComponents()));

        childComponentList.addAll(this.getChildComponents());

        return childComponentList;
    }


    public List<String> getImplementsRecorder(){
        List<String> list = new LinkedList<>();

        this.implRecorderMap.forEach((s, recorder) -> list.add(s));

        return list;
    }

    public List<String> getExtendsRecorder(){
        List<String> list = new LinkedList<>();

        this.exRecorderMap.forEach((s, recorder) ->  list.add(s));

        return list;
    }

    public void addPlatform(Platform platform) {
        this.platforms.add(platform);
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

    public boolean containsPlatform(String id){
        for (Platform platform : this.platforms){
            if (Objects.equals(platform.getName(), id))
                return true;
        }
        return false;
    }

    public boolean contains(String id) {
        return this.containsParameter(id)
                || this.containsConstant(id)
                || this.containsChildComponent(id)
                || this.containsFailMode(id)
                || this.containsPlatform(id);
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

    public Platform getPlatform(String labelName) {
        return this.platforms.stream()
                .filter(platform -> platform.getName().equals(labelName))
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
                : this.getPlatform(labelName) != null
                ? this.getPlatform(labelName)
                : null;
    }

    // for this the extends has highest priority.
    public Label<Label> getAISLabel(String labelName){

        if (this.getLabel(labelName) != null )
            return this.getLabel(labelName);

        for (Map.Entry<String,RIIF2Recorder> entry : this.exRecorderMap.entrySet()) {
            if (entry.getValue().getAISLabel(labelName)  != null )
                return entry.getValue().getAISLabel(labelName);
        }

        for (Map.Entry<String,RIIF2Recorder> entry : this.implRecorderMap.entrySet()) {
            if (entry.getValue().getAISLabel(labelName) != null )
                return entry.getValue().getAISLabel(labelName);
        }

        return null;
    }

    /*only can find in this recorder or parent recorder */
    public Label<Label> getAssignmentLabel(String labelName) {
        if (this.getLabel(labelName) != null )
            return this.getLabel(labelName);

        for (Map.Entry<String,RIIF2Recorder> entry : this.exRecorderMap.entrySet()){
            if (entry.getValue().getAssignmentLabel(labelName) != null)
                return entry.getValue().getAssignmentLabel(labelName);
        }

        return null;
    }

    public Label<Label> getImposeLabel(String labelName) {
        if (this.getLabel(labelName) != null )
            return this.getLabel(labelName);

        for (Map.Entry<String,RIIF2Recorder> entry : this.implRecorderMap.entrySet()){
            if (entry.getValue().getImposeLabel(labelName) != null)
                return entry.getValue().getImposeLabel(labelName);
        }

        return null;
    }

    public Label<Label> getSetLabel(String labelName){

        /* in template */
        if (this.isTemplate()){
            for (Map.Entry<String, RIIF2Recorder > entry : this.exRecorderMap.entrySet() ){
                if (entry.getValue().getLabel(labelName) != null)
                    return entry.getValue().getLabel(labelName);

                if (entry.getValue().getSetLabel(labelName) != null)
                    return entry.getValue().getSetLabel(labelName);
            }
        }

        /* in component */
        if ( !this.isTemplate() ) {
            for (Map.Entry<String,RIIF2Recorder> entry : this.exRecorderMap.entrySet())
                if (entry.getValue().getSetLabel(labelName) != null )
                    return entry.getValue().getSetLabel(labelName);

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
        //System.out.println("Going to store the record with name " + this.getIdentifier() + " in to repository ");
        return new RIIF2Recorder();
    }

    @Override // stores into parameters table, and remember to get the recorder id according to the recorder that it exists.
    public void generateDB(SQLConnector connector) {

        DBGenerator generator = new DBGenerator(connector,this);
        generator.generate();
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
        this.platforms.forEach(Platform::print);
    }

}
