package it.polito.yutengfei.RIIF2.recoder;

import com.sun.corba.se.impl.orbutil.ObjectWriter;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public String getDefinition() {
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

    public boolean containsImplRecorder(String implNameRecorderName ){
        return this.implRecorderMap.containsKey(implNameRecorderName);
    }

    public boolean containsExRecorder(String exNameRecorderName){
        return this.exRecorderMap.containsKey(exNameRecorderName);
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

        // first generate the Definition table
        int indexOfDefinition = this.generateDefinitionDB(connector);
        System.out.println(" index of definitions " + indexOfDefinition);


        this.implRecorderMap.forEach((s, recorder) -> recorder.generateDB(connector));
        this.exRecorderMap.forEach((s, recorder) -> recorder.generateDB(connector));

        List<String> selectLabels = new LinkedList<String>(){{
            add("id");
        }};

        String where = "name = " + "\"" + this.identifier +   "\"" + ";";
        //first I need to retrieve the recorder id from recorder table
        ResultSet resultSet = connector.select("recorder",selectLabels,where);
        try {
            if (resultSet.next()) {
                int recorderNumber= resultSet.getInt("id");
                this.generateParameterDB(connector,recorderNumber);
                this.generateConstantDB(connector,recorderNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int generateDefinitionDB(SQLConnector connector) {
        List<String> labels = new LinkedList<String>(){{
            add("name"); add("definition");
        }};

        List<Object> values = new LinkedList<Object>(){{
            add(RIIF2Recorder.this.identifier); add(RIIF2Recorder.this.getDefinition().getBytes());
        }};

        return connector.insert("definitions", labels, values);
    }



    // this method responsible for storing the parameters into parameters table
    private void generateParameterDB(SQLConnector connector, int recorderNumber) {

        // prepare the list name
        List<String> listName = new LinkedList<String>() {{
            add("name");
            add("type");
            add("value");
            add("recorder");
        }};

        // for each parameter
        this.parameters.forEach(parameter -> {

            String name = parameter.getName();
            String type = parameter.getType();
            Object value = parameter.getValue();
            int recorder = recorderNumber;

            // prepare the parameter values
            List<Object> listValues = new LinkedList<Object>() {{
                add(name);
                add(type);
                add(parameter.getLiteral());
                add(recorder);
            }};
            System.out.println(listValues);
            connector.insert("parameters", listName, listValues);
        });
    }


    private void generateConstantDB(SQLConnector connector, int recorderNumber) {
        // prepare the list name
        List<String> listName = new LinkedList<String>() {{
            add("name");
            add("type");
            add("value");
            add("recorder");
        }};

        // for each parameter
        this.constants.forEach(constant -> {

            String name = constant.getName();
            String type = constant.getType();
            Object value = constant.getValue();
            int recorder = recorderNumber;

            // prepare the parameter values
            List<Object> listValues = new LinkedList<Object>() {{
                add(name);
                add(type);
                add(constant.getLiteral());
                add(recorder);
            }};
            System.out.println(listValues);
            connector.insert("constants", listName, listValues);
        });
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
