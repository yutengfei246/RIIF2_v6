package it.polito.yutengfei.RIIF2.test;

import it.polito.yutengfei.RIIF2.RIIF2Lexer;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.visitor.SLV;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Tester {

    private final InputStream in;

    private Tester(InputStream in) {
        this.in = in ;
    }

    public static void main(String[] args){
        InputStream in = System.in;
        String userDir = System.getProperty("user.dir");
        System.out.println("Userdir is " + userDir);

        if(args.length == 0){}
        else try {
            in = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Tester guiTester
                = new Tester(in);
        guiTester.run();
    }

    private void run() {

        try {
            ANTLRInputStream antlrInputStream = new ANTLRInputStream(this.in);
            RIIF2Lexer riif2Lexer = new RIIF2Lexer(antlrInputStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(riif2Lexer);
            RIIF2Parser parser = new RIIF2Parser(commonTokenStream);

            ParseTree parseTree = parser.program();

           SLV secondLevelVisitor =
                    new SLV(parseTree,parser);

            secondLevelVisitor.visit(parseTree);

            RIIF2Recorder recorder = secondLevelVisitor.getRIIF2Recorder();

            //System.out.println(parseTree.toStringTree());
            recorder.print( 0 );
            System.out.println("Parser OK");

        } catch (IOException ignored) {}
    }
}