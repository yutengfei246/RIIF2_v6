package it.polito.yutengfei.RIIF2.recoder;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;
import it.polito.yutengfei.RIIF2.mysql.MysqlBuilder;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

// in this generating DB, the array structure does not generate new rows, on the other hand, the associative index generating another rows and pointed by the associativeIds
class DBGenerator {
    private final SQLConnector connector;
    private final RIIF2Recorder recorder;

    DBGenerator(SQLConnector connector, RIIF2Recorder recorder) {
        this.connector = connector;
        this.recorder = recorder;
    }

    void generate(){
        try {

            int generatedId;

            // create the RIIF2 definition into the definitions table in DB
            generatedId = this.generateRIIF2Definition();

            // generates RIIF2's indexes into recorders table in DB
            generatedId = this.generateRIIF2Index(generatedId);

            // generates the RIIF2's variable parameters into the parameters table in DB
            this.generateRIIF2Parameters(generatedId);

            // generate the RIIF2's variable constants into the constants table in the DB
            this.generateRIIF2Constants(generatedId);

            // generate the RIIF2's variable childComponent into the childComponents tables in the DB
            this.generateRIIF2ChildComponent(generatedId);

            // generate the RIIF2's variable failMode into the failMode table in the DB
            this.generateRIIF2FailMode(generatedId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // two possibilities, one for associativeArray , one for pure
    private Boolean generateRIIF2FailMode(int generatedId) {

        List<FailMode> failModes = this.recorder.getAllFailModes();

        List<String> labels = new LinkedList<String>(){{
            add("name"); add("recorder"); add("isAssociative"); add("associativeIds"); add("attributeIds");
        }};

        for (FailMode failMode : failModes) {
            String name = failMode.getName();

            if (failMode.isAssociative()) {

                List<Integer> integers = new LinkedList<>();

                Collection<Label> labelCollection = failMode.getAssociatives();

                if (labelCollection != null ) {

                    for (Label label : labelCollection) {

                        List<Integer> integerList = this.generateAttribute(label);
                        String assocName = label.getName();

                        int length = 0;
                        if (label.isVector())
                            length = label.getVectorLength();

                        int finalLength = length;
                        List<Object> assocValues = new LinkedList<Object>() {{
                            add(assocName);
                            add(generatedId);
                            add(false);
                            add(null);
                            add(integerList);
                            add(finalLength);
                        }};

                        int id = this.connector.insert("failModes", labels, assocValues);
                        integers.add(id);
                    }
                }

                int length = 0;

                if (failMode.isVector())
                    length = failMode.getVectorLength();

                int finalLength = length;
                List<Object> values = new LinkedList<Object>() {{
                    add(name); add(generatedId);add(true); add(integers);add(null); add(finalLength);
                }};

                this.connector.insert("failModes",labels,values);
            }

            else {

                int length = 0;
                if (failMode.isVector())
                    length = failMode.getVectorLength();

                List<Integer> integerList = this.generateAttribute(failMode);

                int finalLength = length;
                List<Object> values = new LinkedList<Object>(){{
                    add(name); add(generatedId); add(false); add(null); add(integerList); add(finalLength);
                }};

                this.connector.insert("failModes",labels,values);
            }
        }
        return null;
    }


    // this method has two possibilities and has same situation with the method that precedes this
    private Boolean generateRIIF2ChildComponent(int generatedId) throws SQLException {

        List<ChildComponent> childComponentList = this.recorder.getAllChildComponents();

        List<String> labels = new LinkedList<String>() {{
            add("name"); add("value"); add("recorder"); add("isAssociative"); add("associativeIds"); add("arrayLength");
        }};

        for (ChildComponent childComponent : childComponentList) {

            String name = childComponent.getName();

            // here the childComponent is an associative array
            if (childComponent.isAssociative()){

                // create the associative array Index set
                List<Integer> associativeArrayIndex = new LinkedList<>();

                for (Label label : childComponent.getAssociatives()) {

                    String associativeName = label.getName();
                    RIIF2Recorder associativeRecorder = (RIIF2Recorder) label.getValue();
                    String recorderName  = associativeRecorder.getIdentifier();

                    int length = 0;
                    if (label.isVector())
                        length = label.getVectorLength();

                    // going to find the definition id in the definitions table in the DB
                    List<String> idLabel = new LinkedList<String>() {{
                        add("id");
                    }};

                    String where = "name = '" + recorderName + "'";
                    ResultSet resultSet = this.connector.select("definitions", idLabel, where);

                    int value = -1 ;
                    while (resultSet.next()) {
                        value = resultSet.getInt("id");
                    }

                    resultSet.close();


                    int finalValue = value;
                    int finalLength = length;
                    List<Object> associativeValues = new LinkedList<Object>() {{
                        add(associativeName); add(finalValue); add(generatedId); add(false); add(null);add(finalLength);
                    }};

                    int id = this.connector.insert("childComponents", labels, associativeValues);
                    associativeArrayIndex.add(id);
                }

                int length = 0;
                if (childComponent.isVector())
                    length = childComponent.getVectorLength();

                int finalLength = length;
                List<Object> values = new LinkedList<Object>() {{
                    add(name); add(-1); add(generatedId); add("true"); add(associativeArrayIndex); add(finalLength);
                }};

                this.connector.insert("childComponents", labels, values);
            }

            // the childComponent is not associative array
            else {

                int value = -1;

                RIIF2Recorder ccRecorder = (RIIF2Recorder) childComponent.getValue();

                String recorderName = ccRecorder.getIdentifier();

                // going to find the definition id in the definitions table in the DB
                List<String> idLabel = new LinkedList<String>() {{
                    add("id");
                }};

                String where = "name = '" + recorderName + "'";
                ResultSet resultSet = this.connector.select("definitions", idLabel, where);

                while (resultSet.next()) {
                    value = resultSet.getInt("id");
                }

                resultSet.close();

                int length = 0;

                if (childComponent.isVector())
                    length = childComponent.getVectorLength();

                int finalValue = value;
                int finalLength = length;
                List<Object> values = new LinkedList<Object>() {{
                    add(name); add(finalValue); add(generatedId); add("false"); add(null); add(finalLength);
                }};

                this.connector.insert("childComponents", labels, values);
            }
        }
        return true;
    }

    private Boolean generateRIIF2Constants(int generatedId) {

        // store every constants in the constantsList
        List<Constant> ConstantList = this.recorder.getAllConstants();

        // prepare the labels
        List<String> labels = new LinkedList<String>() {{
            add("name");add("value");add("recorder"); add("isAssociative"); add("associativeIds"); add("attributeIds"); add("arrayLength");
        }};


        // we have two possibilities.
        // One is the constants is not associative array.
        // Other one is the constants is an associative array
        ConstantList.forEach(constant -> {
            String name = constant.getName();
            Object value = constant.getValue();


            if (value != null ){
                value = value.toString();
            }

            // this is the second possibility
            if (constant.isAssociative()) {

                // first by adding the associatived elements
                List<Integer> associativeIds = new LinkedList<>();

                constant.getAssociatives().forEach(label -> {

                    List<Integer> integerList = this.generateAttribute(label);
                    String usedName = label.getName();
                    Object usedValue = label.getValue();

                    int length = 0;
                    if (label.isVector())
                        length = label.getVectorLength();

                    if (usedValue != null) {
                        usedValue = usedValue.toString();
                    }

                    Object finalUsedValue = usedValue;
                    int finalLength = length;
                    List<Object> associativeValues = new LinkedList<Object>(){{
                        add(usedName); add(finalUsedValue); add(generatedId); add("false"); add(null); add(integerList);add(finalLength);
                    }};

                    int associativeId = this.connector.insert("constants",labels, associativeValues);
                    associativeIds.add(associativeId);

                });

                int length = 0;
                if (constant.isVector())
                    length = constant.getVectorLength();

                Object finalValue = value;
                int finalLength = length;
                List<Object> values = new LinkedList<Object>() {{
                    add(name); add(finalValue); add(generatedId); add("true"); add(associativeIds); add(null); add(finalLength);
                }};

                this.connector.insert("constants",labels,values);
            }

            // this is the first possibility
            else {


                int length =0;

                if (constant.isVector())
                    length = constant.getVectorLength();

                List<Integer> integerList = this.generateAttribute(constant);

                Object finalValue = value;
                int finalLength = length;
                List<Object> values = new LinkedList<Object>(){{
                    add(name); add(finalValue); add(generatedId); add("false"); add(null); add(integerList); add(finalLength);
                }};

                this.connector.insert("constants",labels,values);
            }

        });

        return true;
    }

    // the given parameter is the generatedId for the recorder
    private boolean generateRIIF2Parameters(int generatedId) {

        // store every parameter in the parameterList
        List<Parameter> parameterList = this.recorder.getAllParameters();

        // prepare the labels
        List<String> labels = new LinkedList<String>() {{
            add("name");add("value");add("recorder"); add("isAssociative"); add("associativeIds"); add("attributeIds"); add("arrayLength");
        }};

        // we have two possibilities.
        // One is the parameter is not associative array.
        // Other one is the parameter is an associative array
        parameterList.forEach(parameter -> {
            String name = parameter.getName();
            Object value = parameter.getValue();

            if (value != null ){
                value = value.toString();
            }

            // this is the second possibility
            if (parameter.isAssociative()) {

                // first by adding the associatived elements
                List<Integer> associativeIds = new LinkedList<>();

                parameter.getAssociatives().forEach(label -> {

                    List<Integer> integerList = this.generateAttribute(label);

                    String usedName = label.getName();
                    Object usedValue = label.getValue();

                    if (usedValue != null) {
                        usedValue = usedValue.toString();
                    }

                    int length = 0;
                    if (label.isVector()){
                        length = label.getVectorLength();
                    }

                    Object finalUsedValue = usedValue;
                    int finalLength = length;
                    List<Object> associativeValues = new LinkedList<Object>(){{
                        add(usedName); add(finalUsedValue); add(generatedId); add(false); add(null); add(integerList); add(finalLength);
                    }};

                    int associativeId = this.connector.insert("parameters",labels, associativeValues);
                    associativeIds.add(associativeId);

                });

                int length = 0;
                if (parameter.isVector())
                    length = parameter.getVectorLength();

                Object finalValue = value;
                int finalLength = length;
                List<Object> values = new LinkedList<Object>() {{
                    add(name); add(finalValue); add(generatedId); add(true); add(associativeIds); add(null); add(finalLength);
                }};

                this.connector.insert("parameters",labels,values);
            }

            // this is the first possibility
            else {

                int length = 0;
                if (parameter.isVector())
                    length = parameter.getVectorLength();

                List<Integer> integerList = this.generateAttribute(parameter);

                Object finalValue = value;
                int finalLength = length;
                List<Object> values = new LinkedList<Object>(){{
                    add(name); add(finalValue); add(generatedId); add("false"); add(null); add(integerList); add(finalLength);
                }};

                this.connector.insert("parameters",labels,values);
            }

        });

        return true;
    }

    private int generateRIIF2Index(int generatedId) throws SQLException {

        // prepare extendsIds
        List<String> extendsName = this.recorder.getExtendsRecorder();
        List<Integer> extendsIds = new LinkedList<>();

        for (String intendedName : extendsName) {
            ResultSet resultSet = this.connector.select("definitions", new LinkedList<String>() {{add("id"); }}, " name = '" + intendedName + "'" );

            while(resultSet.next()){
                int i = resultSet.getInt(1);
                extendsIds.add(i);
            }

            resultSet.close();
        }

        // prepare implementsIds
        List<String> implementsNames = this.recorder.getImplementsRecorder();
        List<Integer> implementIds = new LinkedList<>();

        for (String intendedName : implementsNames) {
            ResultSet resultSet = this.connector.select("definitions", new LinkedList<String>() {{add("id");}}, " name = '" +  intendedName + "'");

            while(resultSet.next()) {
                int i = resultSet.getInt(1);
                implementIds.add(i);
            }
            resultSet.close();

        }

        // start creation
        List<String> labels = new LinkedList<String>(){{
            add("definitionId");
            add("extendsIds");
            add("implementsIds");
        }};

        List<Object> values = new LinkedList<Object>(){{
            add(generatedId); add(extendsIds.toString()); add(implementIds.toString());
        }};

        return this.connector.insert("recorders",labels,values);
    }


    private int generateRIIF2Definition() {

        // generates those definitions
        List<String> labels = new LinkedList<String>() {{
            add("name");
            add("definition");
        }};

        List<Object> values = new LinkedList<>();

        String name = this.recorder.getIdentifier();
        String definition = this.recorder.getDefinition();
        definition = MysqlBuilder.stringToBinary(definition);

        values.add(name); values.add(definition);

        return connector.insert("definitions", labels, values);
    }

    // generate attributes for each label and store the attribute into attribtues table in DB and return back the generated I
    private List<Integer> generateAttribute(Label theLabel){
        List<Integer> integers = new LinkedList<>();

        List<String> labels = new LinkedList<String>() {{
            add("name"); add("type"); add("value");
        }};

        Collection<Attribute> attributes = theLabel.getAttributes();

        if (attributes != null) {

            attributes.forEach(attribute -> {
                String name = attribute.getName();
                String type = attribute.getType();
                Object value = attribute.getValue();

                int id = this.connector.insert("attributes",labels, new LinkedList<Object>() {{add(name); add(type) ; add(value); }});

                integers.add(id);
            });
        }

        return integers;
    }

}