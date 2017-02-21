package it.polito.yutengfei.RIIF2.mysql;

public class MysqlBuilder {

    public static SQLConnector getNewSQLConnector(){
        return new SQLConnector();
    }

    public static String stringToBinary(String text) {

        String bString="";
        String temp="";

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
