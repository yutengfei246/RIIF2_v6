package it.polito.yutengfei.RIIF2.test;

import it.polito.yutengfei.RIIF2.RIIF2Lexer;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.mysql.MysqlBuilder;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Repository;
import it.polito.yutengfei.RIIF2.visitor.SLV;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RIIF2 {

    private final String[] inputs;

    public RIIF2(String[] args) {
        this.inputs = args;
    }

    public static void main(String[] args) {

        RIIF2 riif2Compiler = new RIIF2(args);

        try {
            riif2Compiler.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // iteratively access inputStream in order to have some separated data files
    // pay attention : need to translate the RIIF2 recorder from one to others.
    private void run() throws IOException {

        InputStream in ;
        RIIF2Recorder recorder = new RIIF2Recorder();


        int i = 0;

        do {
            if (i < this.inputs.length && !this.inputs[i].startsWith("-"))  in = new FileInputStream(this.inputs[i++] );
            else break;

            ANTLRInputStream antlrInputStream = new ANTLRInputStream(in);
            RIIF2Lexer riif2Lexer = new RIIF2Lexer(antlrInputStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(riif2Lexer);
            RIIF2Parser parser = new RIIF2Parser(commonTokenStream);

            ParseTree parseTree = parser.program();

            SLV secondLevelVisitor = new SLV(parseTree, recorder);
            secondLevelVisitor.visit(parseTree);

            recorder = secondLevelVisitor.getRIIF2Recorder();

        } while (true);


        while (i< this.inputs.length && this.inputs[i].startsWith("-")){
            switch (this.inputs[i++]){
                case "-s":
                    this.toDB();
                    break;
                case "-p":
                    this.print();
                    break;
                case "-ps":
                    this.print();
                    this.toDB();
                    break;
                case "-sp":
                    this.toDB();
                    this.print();
                    break;
                case "-h":
                    this.help();
                    break;
                default: break;
            }
        }
    }

    private void help() {
        System.out.println(" -s: store template/component into Database, if success.");
        System.out.println(" -p: literally print out the parse result.");
        System.out.println(" -h: show help.");
    }

    //print all the information into stdout in repository.
    private void print() {

        Repository.getTemplateRepository()
                .forEach((s, recorder1) -> {
                    System.out.println(" <--------------------RECORDER " + s + " ----------------------------------->");
                    ((RIIF2Recorder) recorder1).print8();
                    System.out.println("----------------------------------------");
                    System.out.println("");
                });

        Repository.getComponentRepository()
                .forEach((s2, recorder2) -> {
                    System.out.println(" <--------------------RECORDER " + s2 + " ------------------------------------>");
                    ((RIIF2Recorder) recorder2).print8();
                    System.out.println("----------------------------------------");
                    System.out.println("");
                });
    }

    private void toDB(){
        SQLConnector sqlConnector = MysqlBuilder.getNewSQLConnector();
        Repository.generateDB(sqlConnector);
    }
}