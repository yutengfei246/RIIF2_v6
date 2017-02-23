package it.polito.yutengfei.RIIF2.recoder;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.mysql.MysqlBuilder;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DBReader {

    private final SQLConnector connector;

    public DBReader(SQLConnector connector){
        this.connector = connector;
    }

    boolean hasDefinitionInDB(String s) {
        return this.readDefinition(false, s) != -1;
    }

    public void read(String s) {

        if (s.contains(":")){
            String[] content = s.split(":");

            if ((content.length == 2)) {

                String modularName = content[0].toLowerCase();
                String modularVariable = content[1].toLowerCase();

                this.library(modularName,modularVariable,true);
            }

            else if (content.length == 3) {
                String name = content[0].toLowerCase();
                String type = content[1].toLowerCase();
                String variable = content[2].toLowerCase();

                this.library(name,type,variable);
            }

            else {
                System.err.println("Syntax: error at " + s);
                System.exit(0);
            }
        }

        else this.readDefinition(true,s);
    }


    private List<Label> library(String modularName, String modularVariable , Boolean print) {
        List<Label> rtnList = new LinkedList<>();

        List<Integer> recorderIdList  = new LinkedList<>();

        if (modularName.equals("template") || modularName.equals("component")) {
            List<Integer> allDefinitionId = this.readAllDefinitions(false);
            recorderIdList.addAll(allDefinitionId);
        }
        else {
            int definitionId = this.readDefinition(false, modularName);
            recorderIdList.add(definitionId);
        }

        for (Integer integer : recorderIdList) {

            RIIF2Recorder recorder = this.readRecorder(integer);

            if (recorder == null) {
                System.out.println("can not found the RIIF2Recorder");
                System.exit(1);
            }

            switch (modularVariable) {
                case "parameter":
                    rtnList.addAll(recorder.getAllParameters());
                    if (print) this.print(recorder.getAllParameters());
                    break;
                case "constant":
                    rtnList.addAll(recorder.getAllConstants());
                    if (print) this.print(recorder.getAllConstants());
                    break;
                case "failMode":
                    rtnList.addAll(recorder.getAllFailModes());
                    if (print) this.print(recorder.getAllFailModes());
                    break;
                case "childComponent":
                    rtnList.addAll(recorder.getAllChildComponents());
                    if (print) this.print(recorder.getAllChildComponents());
                    break;
                default:
                    break;
            }
        }

        return rtnList;
    }

    private void library(String name, String type, String variable) {

        List<Label> labels = this.library(name,type,false);

        if (labels == null || labels.size() == 0){
            System.out.println(">> " + name + ":" + type + ":" + variable + "can not be found !" );
            System.exit(1);
        }

        List<String> selectedRecorder = new LinkedList<>();

        labels.forEach(label -> {

            if (label.getName().equals(variable)){
                if (!selectedRecorder.contains(label.getRecorder().getIdentifier())) selectedRecorder.add(label.getRecorder().getIdentifier());
            }
        });

        if (selectedRecorder.size() != 0)  selectedRecorder.forEach(System.out::println);
    }

    private List<Integer> readAllDefinitions(boolean b) {

        List<Integer> definitionId = new LinkedList<>();

        List<String> label = new LinkedList<String>() {{
            add("id"); add("definition");
        }};

        ResultSet resultSet  = this.connector.select("definitions",label,"1");

        try {
            while (resultSet.next()) {
                String definition = resultSet.getString("definition");
                definition = new String (Hex.decodeHex(definition.toCharArray()) );
                if (b){
                    System.out.println(definition);
                    System.out.println("");
                }
                definitionId.add( resultSet.getInt("id") );
            }
            resultSet.close();

        } catch (SQLException | DecoderException e) {
            e.printStackTrace();
        }

        return definitionId;
    }

    private void print(List labels) {

        if (labels == null || labels.size() == 0 ) {
            return;
        }

        labels.forEach(o -> ((Label)o).print() ) ;
    }


    private RIIF2Recorder readRecorder(int id ){
        RIIF2Recorder recorder = null;

        List<String> labels = new LinkedList<String>() {{
            add("value");
        }};

        String where = "recorder = " + id;

        //System.out.println(" " + where);
        ResultSet resultSet = this.connector.select("RIIF2Recorder", labels, where);

        try {
            if (resultSet.next()){

                String recorderString  = resultSet.getString("value");

                recorder = (RIIF2Recorder) Base64.decodeToObject(recorderString);
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return recorder;
    }



    // read the stored definition
    private int readDefinition(Boolean b ,String name) {

        switch (name) {
            case "all":
                return this.queryDefinition(b,"1");
            case "template":
                return this.queryDefinition(b, "type = '" +  "template" + "'");
            case "component":
                return this.queryDefinition(b, "type = '" + "component" + "'");
            default:
                return this.queryDefinition(b, "name ='" + name + "'" );
        }
    }


    public void readHier(String s) {

        try {

            Stack<Integer> stackEx = new Stack<>();
            int exIndex = 0;
            Stack<Integer> stackImpl = new Stack<>();
            int implIndex = 0;

            List<Integer> tempList = new LinkedList<>();
            int definitionId = this.queryDefinition(false," name = '" +s + "'");

            stackEx.add(definitionId); exIndex++;
            tempList.add(definitionId);

            for (int i = 0 ; i < tempList.size() ; i ++) {
                List<String> exImp = this.queryExImpIds(tempList.get(i));

                String ex = exImp.get(0);
                String imp =  exImp.get(1);

                if (ex != null  ) {
                    String[] exA = ex.split(",");
                    for (String s1 : exA) {
                        if (!s1.equals("")) {
                            stackEx.add(Integer.parseInt(s1));
                            exIndex++;
                            tempList.add(Integer.parseInt(s1));
                        }
                    }
                }

                if (imp != null ) {
                    String[] impA = imp.split(",");
                    for (String s1 : impA) {
                        if (!s1.equals("")) {
                            stackImpl.add(Integer.parseInt(s1));
                            implIndex++;
                            tempList.add(Integer.parseInt(s1));
                        }
                    }
                }
            }

            while ( --implIndex > -1  ) {
                int implId = stackImpl.pop();
                this.queryDefinition(true," id = " + implId);
            }

            while ( --exIndex > -1 ) {
                int exId = stackEx.pop();
                this.queryDefinition(true," id = " + exId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private List<String> queryExImpIds(int definitionIds) throws SQLException {
        List<String> labels = new LinkedList<String>() {{
            add("extendsIds"); add("implementsIds");
        }};

        String where = " definitionId = " + definitionIds ;

        ResultSet resultSet = this.connector.select("recorders", labels, where);

        List<String> vector = new LinkedList<>();

        while (resultSet.next()){
            String exString = resultSet.getString("extendsIds");
            String implString = resultSet.getString("implementsIds");

            vector.add(exString);
            vector.add(implString);
        }

        return vector;
    }


    private int queryDefinition(Boolean print,String where) {

        int id = -1 ;

        List<String> label = new LinkedList<String>() {{
            add("id"); add("definition");
        }};

        ResultSet resultSet  = this.connector.select("definitions",label,where);

        try {

            while (resultSet.next()) {
                String definition = resultSet.getString("definition");
                byte[] bytes = Hex.decodeHex(definition.toCharArray());

                if (print){
                    System.out.println(new String (bytes) );
                    System.out.println("");
                }
                id = resultSet.getInt("id");
            }
            resultSet.close();

        } catch (SQLException | DecoderException e) {
            e.printStackTrace();
        }

        return id;
    }

    public void delete(String s) {

        // delete all modulars in the database
        if (s.equals("all")) {
            this.connector.delete("definitions", "1");
            this.connector.delete("recorders", "1");
            this.connector.delete("RIIF2Recorder", "1");
        }

        // delete specific modular in the database
        else {

            // first read the id from definitions and then delete it from recorders and RIIF2Recorder

            int definitionId ;

            List<String> labels = new LinkedList<String>(){{
                add("id");
            }};

            ResultSet resultSet = this.connector.select("definitions", labels, " name = '" + s +"'" );

            try {
                while (resultSet.next()){
                    definitionId = resultSet.getInt("id");

                    this.connector.delete("definitions", " id = " + definitionId);
                    this.connector.delete("recorders" , " definitionId = " + definitionId);
                    this.connector.delete("RIIF2Recorder" , " definitionId = " + definitionId);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
