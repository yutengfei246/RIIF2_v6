package it.polito.yutengfei.RIIF2.recoder;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;

import java.io.Serializable;
import java.util.*;

public class RIIF2Recorder implements Recorder, Serializable {

    private Boolean template = false;

    private String identifier = null;

    /*deep copy*/
    private Map<String,RIIF2Recorder> exRecorderMap = new HashMap<>();
    private Map<String,RIIF2Recorder> implRecorderMap = new HashMap<>();

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

        if (fieldLabel instanceof FailMode)
            this.addFailMode(fieldLabel);
    }

    private void addFailMode(Label fieldLabel) {
        this.failModes.add((FailMode) fieldLabel);
    }

    private void addChildComponent(Label<ChildComponent> fieldLabel) {
        this.childComponents.add((ChildComponent) fieldLabel);
    }

    public void print(int level){

        if (componentRecorderMap.size() != 0){
            System.out.println("there are components that appeared before ... size is "   + componentRecorderMap.size());
            for (Map.Entry<String, Recorder> entry : componentRecorderMap.entrySet() ){
                System.out.println(" Going to print the recorder with name " + entry.getValue());
                ((RIIF2Recorder)entry.getValue()).print8();

                System.out.println("----------------------------------------------------------");
            }
        }

        if (tempRecorderMap.size() != 0){
            System.out.println("there are templates that appeared befor ... size is " + tempRecorderMap.size());
            for (Map.Entry<String, Recorder> entry : tempRecorderMap.entrySet() ){
                System.out.println(" Going to print the recorder with name " + entry.getValue());
                ((RIIF2Recorder)entry.getValue()).print8();

                System.out.println("--------------------------------------------------------------");
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
            this.parameters.forEach(Parameter::print);
        }

        if (this.constants != null && this.constants.size() != 0){
            System.out.println( this.getIdentifier() + "Recorder has constants number "
                    + this.constants.size() );
            this.constants.forEach(Constant::print);
        }

        if (this.childComponents != null && this.childComponents.size() != 0){
            System.out.println( this.getIdentifier() + " Recorder has Child component number "
                    + this.childComponents.size() );
            this.childComponents.forEach(ChildComponent::print);
        }

        if (this.failModes != null && this.failModes.size() != 0){
            System.out.println( this.getIdentifier() + " Recorder has FailMode number " + this.failModes.size());
            this.failModes.forEach(FailMode::print);
        }
    }

    @Override
    public RIIF2Recorder getRIIF2Recorder() {
        if( this.getIdentifier() == null)
            return this;

        Recorder.record(this);
        return new RIIF2Recorder();
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
        return componentRecorderMap.containsKey(typeCcId);
    }


    public FailMode getFailMode(String identifier) {
        for (FailMode failMode : this.failModes){
            if (Objects.equals(failMode.getName(), identifier))
                return failMode;
        }
        return null;
    }

    public Label getAssignmentLabel(String labelName) {
        /*only can find in this recorder or parent recorder */
        if ( this.getLabelFromThisRecorder(labelName) == null ) {

            for (String eXname : this.eXIdentifiers) {
                RIIF2Recorder riif2Recorder = (RIIF2Recorder) Recorder.getRecorderFromComponentRepository(eXname);
                if (riif2Recorder.getLabelFromThisRecorder(labelName) != null)
                    return riif2Recorder.getLabelFromThisRecorder(labelName );
            }
        }

        return this.getLabelFromThisRecorder(labelName);
    }

    public Label getLabelFromThisRecorder(String labelName ){

        if (this.getParameter(labelName ) != null )
            return this.getParameter( labelName );
        if (this.getConstant( labelName ) != null )
            return this.getConstant( labelName );
        if (this.getCC(labelName) != null )
            return this.getCC(labelName);
        if (this.getFailMode( labelName) != null )
            return this.getFailMode(labelName);

        return null;
    }

    public RIIF2Recorder getSetRecorder(String hierRecorderName) {
        return tempRecorderMap.get(hierRecorderName);
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Label getLabelParentToAncestor(String primitiveName, Boolean fromTemplate) {

        if (fromTemplate){
            for (String implName : this.implIdentifiers){
                RIIF2Recorder temRecorder = (RIIF2Recorder) Recorder.getRecorderFromTemplateRepository(implName);
                if (temRecorder.getLabelFromThisRecorder(primitiveName) != null )
                    return temRecorder.getLabelFromThisRecorder(primitiveName);
            }

        }else{
            for (String eXName : this.eXIdentifiers){
                RIIF2Recorder eXRecorder = (RIIF2Recorder) Recorder.getRecorderFromComponentRepository(eXName);
                if (eXRecorder.getLabelFromThisRecorder(primitiveName) != null )
                    return eXRecorder.getLabelFromThisRecorder(primitiveName);
            }
        }

        return null;
    }

    public RIIF2Recorder getGlobalComponent(String s) {
        Map<String,RIIF2Recorder> components = new HashMap<>( componentRecorderMap );
        return components.get(s);
    }
}
