package it.polito.yutengfei.RIIF2.recoder;


import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.mysql.MysqlBuilder;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DBReader {

    private final SQLConnector connector;

    public DBReader(SQLConnector connector){
        this.connector = connector;
    }


    public void read(String s) {

        if (s.contains(":")){

            String[] content = s.split(":");

            if (content.length != 2){
                System.err.println("Syntax: error at " + s );
                System.exit(0);
            }

            String modularName = content[0];
            String modularVariable = content[1];

            int definitionId = this.readDefinition(false,modularName);
            RIIF2Recorder recorder = this.readRecorder(definitionId);

            if (recorder == null ) {
                System.out.println("can not found the RIIF2Recorder");
                System.exit(1);
            }

            switch (modularVariable){
                case "parameter":
                    this.print(recorder.getAllParameters());
                    break;
                case "constant":
                    this.print(recorder.getAllConstants());
                    break;
                case "failMode":
                    this.print(recorder.getAllFailModes());
                    break;
                case "childComponent":
                    this.print(recorder.getAllChildComponents());
                    break;
                default:break;
            }
        }

        else this.readDefinition(true,s);
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

    private int queryDefinition(Boolean print,String where) {

        int id = -1 ;

        List<String> label = new LinkedList<String>() {{
            add("id"); add("definition");
        }};

        ResultSet resultSet  = this.connector.select("definitions",label,where);

        try {
            while (resultSet.next()) {

                String definition = resultSet.getString("definition");
                definition = MysqlBuilder.BinaryToString(definition);
                if (print)  System.out.println(definition);
                id = resultSet.getInt("id");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}
