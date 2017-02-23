package it.polito.yutengfei.RIIF2.recoder;



import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.*;
import it.polito.yutengfei.RIIF2.mysql.MysqlBuilder;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Attribute;

import org.apache.commons.codec.binary.Hex;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

// in this generating DB, the array structure does not generate new rows, on the other hand, the associative index generating another rows and pointed by the associativeIds
class DBGenerator {
    private final SQLConnector connector;
    private final RIIF2Recorder recorder;
    private final DBReader reader;

    DBGenerator(SQLConnector connector, RIIF2Recorder recorder) {
        this.connector = connector;
        this.recorder = recorder;

        this.reader = new DBReader(connector);
    }

    void generate(){

        if (this.reader.hasDefinitionInDB(this.recorder.getIdentifier())){
            System.err.println("the targeted <" + this.recorder.getIdentifier() + "> has already stored in the DB");
            System.exit(1);
        }

        int generatedId;

        // create the RIIF2 definition into the definitions table in DB
        generatedId = this.generateRIIF2Definition();

        try {
            // generates RIIF2's indexes into recorders table in DB
            this.generateRIIF2Index(generatedId);

            // generates the RIIF2's variable parameters into the parameters table in DB
            this.generateRIIF2Parameters(generatedId);

            // generate the RIIF2's variable constants into the constants table in the DB
            this.generateRIIF2Constants(generatedId);

            // generate the RIIF2's variable childComponent into the childComponents tables in the DB
           // this.generateRIIF2ChildComponent(generatedId);

            // generate the RIIF2's variable failMode into the failMode table in the DB
            this.generateRIIF2FailMode(generatedId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void generateRIIF2recorder(int generatedId) throws IOException {

        List<String> labels = new LinkedList<String>() {{
            add("value"); add("definitionId");
        }};

        String recorder = Base64.encodeObject(this.recorder);

        List<Object> values = new LinkedList<Object>() {{
            add(recorder); add(generatedId);
        }};

        this.connector.insert("RIIF2Recorder", labels, values );
    }

    // two possibilities, one for associativeArray , one for pure
    private Boolean generateRIIF2FailMode(int definitionId) {

        List<FailMode> failModes = this.recorder.getAllFailModes();
        if(failModes == null || failModes.size() == 0)
            return false;

        failModes.forEach(failMode -> this.fmGenerator(failMode,definitionId));
        return true;
    }



    // this method has two possibilities and has same situation with the method that precedes this
    private Boolean generateRIIF2ChildComponent(int definitionId) throws SQLException {

        List<ChildComponent> childComponentList = this.recorder.getAllChildComponents();

        if (childComponentList == null || childComponentList.size() == 0)
            return false;

        for (ChildComponent childComponent : childComponentList)
            this.childComponentGenerator(childComponent,definitionId);

        return true;
    }

    private Boolean generateRIIF2Constants(int definitionId ) {

        // store every constants in the constantsList
        List<Constant> constantList = this.recorder.getAllConstants();
        if (constantList == null || constantList.size() == 0)
            return false;

        constantList.forEach(constant -> this.parameterAndConstantGenerator(constant,MysqlBuilder.CONSTANTS, definitionId));

        return true;
    }


    // the given parameter is the generatedId for the recorder
    private boolean generateRIIF2Parameters(int definitionId) {

        // store every parameter in the parameterList
        List<Parameter> parameterList = this.recorder.getAllParameters();
        if (parameterList == null || parameterList.size() == 0)
            return false;

        parameterList.forEach(parameter -> this.parameterAndConstantGenerator(parameter,MysqlBuilder.PARAMETER,definitionId));

        return true;
    }

    private void fmGenerator(FailMode fm , int definitionId ){

        List<String> labels = new LinkedList<String>() {{
            add("name"); add("isAssociative"); add("associativeId"); add("arrayLength"); add("definitionId");
        }};

        if (fm.isAssociative()) {
            int associativeId = this.connector.insert(MysqlBuilder.FAILMODE,labels , new LinkedList<Object>(){{
                add(fm.getName()); add(1); add(0); add(0); add(definitionId);
            }});

            if (fm.getAssociatives() == null)
                System.out.println("fm associative is null " + fm.getName());

            fm.getAssociatives().forEach(label -> {

                this.connector.insert(MysqlBuilder.FAILMODE,labels, new LinkedList<Object>() {{
                    add(label.getName()); add(0); add(associativeId); add(0); add(definitionId);
                }});
            });
        }

        else if ( fm.isVector() )
            this.connector.insert(MysqlBuilder.FAILMODE, labels, new LinkedList<Object>() {{
                add(fm.getName()); add(0); add(0); add(fm.getVectorLength()); add(definitionId);
            }});

        else
            this.connector.insert(MysqlBuilder.FAILMODE, labels, new LinkedList<Object>() {{
                add(fm.getName()); add(0); add(0); add(0); add(definitionId);
            }});
    }


    private void childComponentGenerator(ChildComponent cc , int definitionId) throws SQLException {

        List<String> labels = new LinkedList<String>() {{
            add("name"); add("type"); add("isAssociative"); add("associativeId"); add("arrayLength"); add("definitionId");
        }};

        if (cc.isAssociative()) {
            final int[] associativeId = {-1};

            for (Label label : cc.getAssociatives()) {

                List<Integer> type = null;
                if (associativeId[0] == -1) {
                    List<String> definitionIds = new LinkedList<String>() {{
                        add(label.getRecorder().getIdentifier());
                    }};

                    type = this.getDefinitionIds(definitionIds);
                    List<Integer> finalType = type;
                    associativeId[0] = this.connector.insert(MysqlBuilder.CHILDCOMPONENT, labels, new LinkedList<Object>() {{
                        add(cc.getName());
                        addAll(finalType);
                        add(1);
                        add(0);
                        add(0);
                        add(definitionId);
                    }});
                }

                List<Integer> finalType1 = type;
                this.connector.insert(MysqlBuilder.CHILDCOMPONENT, labels, new LinkedList<Object>() {{
                    add(label.getName());
                    add(finalType1);
                    add(0);
                    add(associativeId[0]);
                    add(0);
                    add(definitionId);
                }});

                associativeId[0]++;
            }
        }

        else if ( cc.isVector() ) {
            this.connector.insert(MysqlBuilder.CHILDCOMPONENT, labels, new LinkedList<Object>() {{
                add(cc.getName()); add(cc.getVectorItem(1).getRecorder().getIdentifier()) ; add(0); add(0) ; add(cc.getVectorLength()) ; add(definitionId);
            }});
        }

        else
            this.connector.insert(MysqlBuilder.CHILDCOMPONENT, labels, new LinkedList<Object>() {{
                add(cc.getName()); add(cc.getVectorItem(1).getRecorder().getIdentifier()) ; add(0); add(0) ; add(0) ; add(definitionId);
            }});
    }

    // first insert the labels and get the generated Id, if it is associative array, then generate all subsequnce element
    private void parameterAndConstantGenerator(Label label, String tableName, int definitionId) {

        List<String> labels = new LinkedList<String>() {{
            add("name"); add("type"); add("value"); add("isAssociative"); add("associativeId");add("arrayLength");add("definitionId");
        }};

        if (label.isAssociative())  {
            int associativeId = this.connector.insert(tableName, labels, new LinkedList<Object>() {{
                add(label.getName()); add(label.getType()); add(label.getValue()); add(1);add(0);add(0); add(definitionId);
            }});

            label.getAssociatives().forEach(o -> {

                if (o instanceof Label) {
                    Label cvtLabel = (Label) o;
                    this.connector.insert(tableName, labels, new LinkedList<Object>() {{
                        add(cvtLabel.getName()); add(cvtLabel.getType()); add(cvtLabel.getValue()); add(0); add(associativeId); add(0); add(definitionId);
                    }});
                }
            });
        }

        else if (label.isVector()) {
             this.connector.insert(tableName, labels, new LinkedList<Object>() {{
                add(label.getName()); add(label.getType()); add(label.getValue()); add(0);add(0);add(label.getVectorLength()); add(definitionId);
            }});
        }

        else
            this.connector.insert(tableName, labels, new LinkedList<Object>() {{
            add(label.getName()); add(label.getType()); add(label.getValue()); add(0);add(0);add(0); add(definitionId);
        }});
    }

    /*generating data into recorder table*/
    private void generateRIIF2Index(int definitionId) throws SQLException {

        List<String> labels = new LinkedList<String>(){{
            add("definitionId"); add("eiDefinitionId"); add("type");
        }};

        // prepare eiDefinitionId
        List<Integer> eiDefinitionIds = this.getDefinitionIds (this.recorder.getExtendsRecorder());
        List<Integer> impDefinitionIds = this.getDefinitionIds (this.recorder.getImplementsRecorder());

        if (eiDefinitionIds != null && eiDefinitionIds.size() != 0) {
            for (Integer eiDefinitionId : eiDefinitionIds)
                this.connector.insert(MysqlBuilder.RECORDER, labels, new LinkedList<Object>(){{ add(definitionId); add(eiDefinitionId) ; add(MysqlBuilder.EXTENDS);}});

        }

        if (impDefinitionIds != null && impDefinitionIds.size() != 0) {
            for (Integer impDefinitionId : impDefinitionIds) {
                this.connector.insert(MysqlBuilder.RECORDER, labels, new LinkedList<Object>(){{ add(definitionId); add(impDefinitionId); add(MysqlBuilder.IMPLEMENTS);}} );
            }
        }
    }

    /*getting all ids from definitions table*/
    private List<Integer> getDefinitionIds(List<String> definitionNames) throws SQLException {
        List<Integer> rtnList = new LinkedList<>();

        if (definitionNames== null || definitionNames.size() == 0)
            return null;


        List<String> labels = new LinkedList<String>() {{add("id");}};

        for (String name : definitionNames) {
            String where = "name = '" + name + "'";
            ResultSet resultSet = this.connector.select(MysqlBuilder.DEFINITIONS,labels, where);

            while (resultSet.next()){
                int definitionId = resultSet.getInt("id");
                rtnList.add(definitionId);
            }
        }
        return rtnList;
    }

    /* storing the definitions into the definitions table */
    private int generateRIIF2Definition() {
        // definitions
        List<String> labels = new LinkedList<String>() {{
            add("name");
            add("definition");
            add("type");
        }};

        List<Object> values = new LinkedList<>();

        String name = this.recorder.getIdentifier();
        String definition = this.recorder.getDefinition();
        definition = Hex.encodeHexString(definition.getBytes());

        String type ;

        if (this.recorder.isTemplate() ){
            type = MysqlBuilder.TEMPLATE;
        }else
            type = MysqlBuilder.COMPONENT;

        values.add(name); values.add(definition); values.add(type);

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