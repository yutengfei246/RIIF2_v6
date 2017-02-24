package it.polito.yutengfei.RIIF2.recoder;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.mysql.MysqlBuilder;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DBReader {

    private final SQLConnector connector;

    public DBReader(SQLConnector connector){
        this.connector = connector;
    }

    boolean hasDefinitionInDB(String s) {
        ResultSet resultSet = this.queryDefinition(" name = '" + s + "'");

        try {
            if (resultSet.next() ) {
                resultSet.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void read(String s) {

        if (s.contains(":")){
            String[] content = s.split(":");

            if ((content.length == 2)) {

                String command = content[0].toLowerCase();
                String parameter = content[1].toLowerCase();

                // first level command
                switch (command) {
                    case "def":
                        // second level command
                        System.out.format("%-35s%s \n", "<Type>", "<Name>");
                        switch (parameter) {
                            case "all":
                                ResultSet allResult = this.queryDefinition("1");
                                List<Integer> allIds = this.readDefinitionResult(allResult, "definition");
                                if (allIds == null)
                                    System.err.println("Warning : Database currently is empty. (no data) ");
                                break;
                            case "templates" :
                                ResultSet templatesResult = this.queryDefinition(" type='template'" );
                                List<Integer> templatesIds = this.readDefinitionResult(templatesResult, "definition");
                                if (templatesIds == null)
                                    System.err.println("Warning : Database currently not contains templates ");
                                break;

                            case "components" :
                                ResultSet componentTemplate = this.queryDefinition(" type='component'" );
                                List<Integer> componentIds= this.readDefinitionResult(componentTemplate, "definition");
                                if (componentIds == null)
                                    System.err.println("Warning : Database currently not contains templates ");
                                break;

                            default: {
                                ResultSet resultSet = this.queryDefinition("name ='" + parameter + "'");
                                List<Integer> ids = this.readDefinitionResult(resultSet, "definition");
                                if (ids == null)
                                    System.err.println("Warning : Can not find the definition. ");
                            }
                        }
                        break;

                    default:
                        System.out.format("%-35s%s \n", "<Type>", "<Name>");
                        this.library(command,parameter);
                }
            }

            else {
                System.err.println("Syntax: error at " + s);
                System.err.println("Type : -h go to help");
                System.exit(0);
            }
        }

        else {
            switch (s) {
                case "list":
                    System.out.format("%-35s%s \n", "<Type>", "<Name>");
                    this.readDefinitionResult( this.queryDefinition("1"), "type" ,"name" );
                    break;

                case "templates":
                    System.out.println("<Template>");
                    this.readDefinitionResult( this.queryDefinition("type = '" +  "template" + "'") , "name" );
                    break;

                case "components":
                    System.out.println("<Component>");
                    this.readDefinitionResult( this.queryDefinition("type = '" + "component" + "'") , "name" );
                    break;

                default:
                    System.err.println("Invalid command : Type -h go to help");
                    System.exit(1);
                    //this.readDefinitionResult( this.queryDefinition("name ='" + s + "'" ) );
            }
        }
    }

    public void delete(String s) {

        switch (s){
            case "all":
                this.connector.delete("definitions","1");
                break;
            default:
                this.connector.delete("definitions", " name = '" + s + "'");
        }
    }


    private List<Label> library(String command,String parameter ) {
        List<Label> rtnList = new LinkedList<>();

        List<Integer> recorderIdList  = new LinkedList<>();

        switch (parameter) {

            case "all" : {
                List<Integer> allDefinitionId = this.readDefinitionResult(this.queryDefinition("1"));
                assert allDefinitionId != null;
                recorderIdList.addAll(allDefinitionId);
                break;
            }

            case "templates": {
                List<Integer> allDefinitionId = this.readDefinitionResult(this.queryDefinition("type = '" + "template" + "'"));
                assert allDefinitionId != null;
                recorderIdList.addAll(allDefinitionId);
                break;
            }

            case "components": {
                List<Integer> allDefinitionId = this.readDefinitionResult(this.queryDefinition("type = '" + "component" + "'"));
                this.readDefinitionResult(this.queryDefinition("type = '" + "component" + "'"));
                assert allDefinitionId != null;
                recorderIdList.addAll(allDefinitionId);
                break;
            }

            default:
                ResultSet resultSet = this.queryDefinition(" name = '" + parameter + "'");
                List<Integer> definitionIds = this.readDefinitionResult(resultSet);

                if (definitionIds == null || definitionIds.size() == 0){
                    System.err.println("Invalid label name: " + parameter );
                    System.exit(1);
                }

                recorderIdList.addAll(definitionIds);
                break;
        }

        for (Integer integer : recorderIdList) {

            ResultSet resultSet;
            switch (command) {
                case "parameters":
                    resultSet = this.queryParameterConstant(MysqlBuilder.PARAMETER,"definitionId = " + integer);
                    this.readParameterConstantResult(false,MysqlBuilder.PARAMETER,resultSet, "type" ,"name");
                    break;
                case "constants":
                    resultSet = this.queryParameterConstant(MysqlBuilder.CONSTANTS,"definitionId = " + integer);
                    this.readParameterConstantResult(false,MysqlBuilder.PARAMETER,resultSet, "type" ,"name");
                    break;
                case "failmodes":
                    resultSet = this.queryFM(MysqlBuilder.FAILMODE,"definitionId = " + integer);
                    this.readFMResult(false,MysqlBuilder.FAILMODE,resultSet, "type" ,"name" );
                    break;
                case "childcomponents":
                    resultSet = this.queryChildComponent(MysqlBuilder.CHILDCOMPONENT, "definitionId = " + integer );
                    this.readCCResult(false,MysqlBuilder.CHILDCOMPONENT,resultSet, "type", "name");
                    break;
                default:
                    System.err.println("Error: invalid command. ");
                    System.err.println("Type -h to go to help page");
                    break;
            }
        }
        return rtnList;
    }

    private List<Integer> readDefinitionResult(ResultSet resultSet, String... print) {

        List<Integer> definitionIds = new LinkedList<>();

        int i = 0;

        try {

            while (resultSet.next()) {
                i++;
                int id = resultSet.getInt("id");
                byte[] bytes = Hex.decodeHex(resultSet.getString("definition").toCharArray());
                String definition = new String(bytes);
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");

                // definitions
                definitionIds.add(id);

                for (String s : print) {

                    switch (s) {
                        case "name":
                            System.out.format("%s", name);
                            break;
                        case "type":
                            System.out.format("%-35s", type);
                            break;
                        case "definition":
                            System.out.println(definition);
                            break;
                    }
                }

                if (print.length != 0)
                    System.out.format("%n");
            }

            resultSet.close();

        } catch (SQLException|DecoderException e) {
            e.printStackTrace();
        }

        if ( i == 0){
            return null;
        }
        return definitionIds;
    }

    private List<Integer> readParameterConstantResult(Boolean isAssociativeLevel, String tableName, ResultSet resultSet, String... print) {

        List<Integer> Ids = new LinkedList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String value = resultSet.getString("value");
                int isAssociative = resultSet.getInt("isAssociative");
                int associativeId = resultSet.getInt("associativeId");
                int arrayLength = resultSet.getInt("arrayLength");
               // int definitionId = resultSet.getInt("definitionId");

                // definitions
                Ids.add(id);

                if (associativeId != 0 && !isAssociativeLevel)
                    continue;


                for (String s : print) {

                    switch (s) {

                        case "name" :
                            if (isAssociativeLevel)
                                System.out.print(name + "]");
                            else
                                System.out.format("%s " ,  name );
                            break;

                        case "type" :
                            if (isAssociative == 1) {
                                System.out.format("%-35s",  type+ "[]");
                            }

                            else if (arrayLength != 0)
                                System.out.format( "%-35s",  type + "[1:" + arrayLength +"]");

                            else {
                                if (isAssociativeLevel)
                                    System.out.print("[" );
                                else System.out.format( "%-35s",type);
                            }
                            break;

                        case "value" :
                            System.out.print("  " + value );
                            break;

                        default:break;
                    }
                }

                if (isAssociative == 1 ){
                    ResultSet resultSet1 = this.queryParameterConstant(tableName, " associativeId = " + id);
                    this.readParameterConstantResult(true, tableName,resultSet1,print);
                }

                if (print.length != 0 && !isAssociativeLevel )
                    System.out.println(" ");
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Ids;
    }

    private List<Integer> readCCResult (Boolean isAssociativeLevel,String tableName,ResultSet resultSet, String... print) {
        List<Integer> Ids = new LinkedList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int type = resultSet.getInt("type");
                ResultSet definition = this.queryDefinition(" id = " +  type);

                String componentType = null;
                if (definition.next()){
                    componentType = definition.getString("name");
                }

                int isAssociative = resultSet.getInt("isAssociative");
                int associativeId = resultSet.getInt("associativeId");
                int arrayLength = resultSet.getInt("arrayLength");
               // int definitionId = resultSet.getInt("definitionId");

                // definitions
                Ids.add(id);

                if (associativeId != 0 && !isAssociativeLevel)
                    continue;

                for (String s : print) {

                    switch (s) {

                        case "name" :
                            System.out.format(" %s " ,  name );
                            break;

                        case "type" :

                            if (isAssociative == 1) {
                                System.out.print("Associative_Array Child_Component " + componentType);
                            }

                            else if (arrayLength != 0)
                                System.out.print( "Child_Components [1:" + arrayLength +"]");

                            else {
                                if (isAssociativeLevel)
                                    System.out.print("--" );
                                else System.out.print("Child_Component " + componentType);
                            }
                            break;

                        default:break;
                    }
                }

                if (isAssociative == 1 ){
                    ResultSet resultSet1 = this.queryChildComponent(tableName, " associativeId = " + id);
                    this.readCCResult(true, tableName,resultSet1,print);
                }

                if (print.length != 0 && !isAssociativeLevel )
                    System.out.println(" ");
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Ids;
    }

    private List<Integer> readFMResult(Boolean isAssociativeLevel,String tableName,ResultSet resultSet, String... print) {

        List<Integer> Ids = new LinkedList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int isAssociative = resultSet.getInt("isAssociative");
                int associativeId = resultSet.getInt("associativeId");
                int arrayLength = resultSet.getInt("arrayLength");
             //   int definitionId = resultSet.getInt("definitionId");

                // definitions
                Ids.add(id);

                if (associativeId != 0 && !isAssociativeLevel)
                    continue;

                for (String s : print) {

                    switch (s) {

                        case "name" :
                            System.out.format(" %s " ,  name );
                            break;

                        case "type" :

                            if (isAssociative == 1) {
                                System.out.print("Associative_Array Fail_Mode");
                            }

                            else if (arrayLength != 0)
                                System.out.print( "Fail_Mode[1:" + arrayLength +"]");

                            else {
                                if (isAssociativeLevel)
                                    System.out.print("--" );
                                else System.out.print("Fail_Mode");
                            }
                            break;

                        default:break;
                    }
                }

                if (isAssociative == 1 ){
                    ResultSet resultSet1 = this.queryFM(tableName, " associativeId = " + id);
                    this.readFMResult(true, tableName,resultSet1,print);
                }

                if (print.length != 0 && !isAssociativeLevel )
                    System.out.println(" ");
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Ids;

    }


    private ResultSet queryChildComponent(String tableName, String s) {

        List<String> label = new LinkedList<String>() {{
            add("id"); add("name"); add("type"); add("isAssociative"); add("associativeId"); add("arrayLength");add("definitionId");
        }};

        return this.connector.select(tableName,label,s);
    }
    private ResultSet queryFM(String tableName, String s) {

        List<String> label = new LinkedList<String>() {{
            add("id"); add("name"); add("isAssociative"); add("associativeId"); add("arrayLength");add("definitionId");
        }};

        return this.connector.select(tableName,label,s);
    }

    private ResultSet queryDefinition(String where) {

        List<String> label = new LinkedList<String>() {{
            add("id"); add("name"); add("definition"); add("type");
        }};

        return this.connector.select("definitions",label,where);
    }

    private ResultSet queryParameterConstant(String tableName, String s) {

        List<String> label = new LinkedList<String>() {{
            add("id"); add("name");add("type"); add("value"); add("isAssociative"); add("associativeId"); add("arrayLength");add("definitionId");
        }};

        return this.connector.select(tableName,label,s);

    }
}
