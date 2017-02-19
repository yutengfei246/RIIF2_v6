package it.polito.yutengfei.RIIF2.mysql;


import java.sql.*;
import java.util.List;


public class SQLConnector {

    private final static String BO = " ( ";
    private final static String BS = " ) ";
    private final static String DOT = "`";

    private final static String COMMA = ",";

    private final static String INSERT = " INSERT INTO ";
    private final static String SELECT = " SELECT ";
    private final static String FROM = " FROM ";
    private final static String WHERE = " WHERE ";
    private final static String VALUES = " VALUES ";

    private final static String SIN_QU = "'";

    private Connection sql;

    SQLConnector(){

        try {
            String url = "jdbc:mysql://127.0.0.1:3306/RIIF2";
            String user = "root";
            String password = "qwoshixiao123";
            this.sql = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int insert(String tableName, List<String> columnLabels, List<Object> values){
        StringBuilder stringBuffer = new StringBuilder();

        stringBuffer.append(INSERT).append(DOT).append(tableName).append(DOT).append(BO);

        for ( int i = 0; i< columnLabels.size() ; i++ ){
            String s = columnLabels.get(i);
            stringBuffer.append(DOT);
            stringBuffer.append(s);
            stringBuffer.append(DOT);

            if(i!=columnLabels.size()-1)
                stringBuffer.append(COMMA);
        }

        stringBuffer.append(BS).append(VALUES);
        stringBuffer.append(BO);

        for (int i= 0; i< values.size() ; i++){
            stringBuffer.append(SIN_QU).append(values.get(i)).append(SIN_QU);

            if ( i!=values.size()-1)
                stringBuffer.append(COMMA);
        }

        stringBuffer.append(BS).append(";");

        return this.queryUpdate(stringBuffer.toString());
    }

    public ResultSet select(String tableName, List<String> labels, String where){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(SELECT);

        for ( int i = 0; i< labels.size() ; i++ ){
            String s = labels.get(i);
            stringBuilder.append(DOT);
            stringBuilder.append(s);
            stringBuilder.append(DOT);

            if(i!=labels.size()-1)
                stringBuilder.append(COMMA);
        }

        stringBuilder.append(FROM).append(DOT).append(tableName).append(DOT).append(WHERE).append(where);
        return this.querySelect(stringBuilder.toString());
    }

    private ResultSet querySelect(String s) {
        ResultSet resultSet = null;

        if( this.sql!= null){
            try {
                //System.out.println("the string buffer " + meg );
                Statement statement = this.sql.createStatement();
                resultSet = statement.executeQuery(s);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultSet;
    }


    private int queryUpdate(String meg){

        int result = -1 ;

        if( this.sql!= null){
            try {
               // System.out.println("the string buffer " + meg );
                Statement statement = this.sql.createStatement();
                result = statement.executeUpdate(meg, Statement.RETURN_GENERATED_KEYS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
