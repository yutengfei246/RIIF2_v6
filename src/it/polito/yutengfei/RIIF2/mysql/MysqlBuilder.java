package it.polito.yutengfei.RIIF2.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlBuilder {

    public static final String TEMPLATE = "template";
    public static final String COMPONENT = "component";
    public static final String DEFINITIONS = "definitions";
    public static final String RECORDER = "recorder";
    public static final String EXTENDS =  "extends";
    public static final String IMPLEMENTS = "implements";
    public static final String PARAMETER = "parameters";
    public static final String CONSTANTS = "constants";
    public static final String CHILDCOMPONENT = "childComponents";
    public static final String FAILMODE = "failModes";

    public static SQLConnector getNewSQLConnector(){


        try {
            String url = "jdbc:mysql://127.0.0.1:3306/RIIF2";
            String user = "root";
            String password = "qwoshixiao123";
            Connection sql = DriverManager.getConnection(url, user, password);
            return new SQLConnector(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String stringToBinary(String text) {

        String bString="";
        String temp ;

        for(int i=0;i<text.length();i++) {

            temp=Integer.toBinaryString(text.charAt(i));

            for(int j=temp.length();j<8;j++) {
                temp="0"+temp;
            }

            bString+=temp+" ";
        }

        //System.out.println(bString);
        return bString;
    }

    public static String BinaryToString(String binaryCode) {

        String[] code = binaryCode.split(" ");
        String word="";

        for (String aCode : code) {
            word += (char) Integer.parseInt(aCode, 2);
        }
        //System.out.println(word);
        return word;
    }


}
