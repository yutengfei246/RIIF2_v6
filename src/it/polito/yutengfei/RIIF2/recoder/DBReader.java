package it.polito.yutengfei.RIIF2.recoder;


import it.polito.yutengfei.RIIF2.mysql.MysqlBuilder;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DBReader {

    private final SQLConnector connector;

    public DBReader(SQLConnector connector){
        this.connector = connector;
    }

    // read the stored definition
    public void readDefinition(String name) {

        switch (name) {
            case "all":
                this.queryDefinition("1");
                break;
            default:
                this.queryDefinition("name ='" + name +"'" );
                break;
        }

    }

    public void queryDefinition(String where) {

        List<String> label = new LinkedList<String>() {{
            add("definition");
        }};

        ResultSet resultSet  = this.connector.select("definitions",label,where);

        try {
            while (resultSet.next()) {

                String definition = resultSet.getString("definition");
                definition = MysqlBuilder.BinaryToString(definition);
                System.out.println(definition);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
