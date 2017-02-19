package it.polito.yutengfei.RIIF2.visitor;

import it.polito.yutengfei.RIIF2.RIIF2BaseVisitor;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;
import it.polito.yutengfei.RIIF2.parser.ComponentParser;
import it.polito.yutengfei.RIIF2.parser.TemplateParser;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Recorder;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Second Level Visitor
 */
public class SLV extends RIIF2BaseVisitor<Boolean> implements Recorder{

    public SLV(ParseTree parseTree, RIIF2Recorder recorder, RIIF2Parser parser){
        this.parseTree = parseTree;
        this.recorder = recorder;
        this.parser = parser;
    }

    @Override
    public Boolean visitComponentDeclaration(RIIF2Parser.ComponentDeclarationContext ctx) {
        super.visitComponentDeclaration(ctx);

        this.recorder.setTemplate(false);
        this.componentParser = new ComponentParser(this.recorder);

        this.moduleCounter++;
        ParseTree componentTree = this.parseTree.getChild(this.moduleCounter);
        walker.walk(this.componentParser,componentTree);

        // set the RIIF2 definition
        this.recorder.setDefinition(this.parser.getTokenStream().getText(ctx));
        // replace the recorder
        this.recorder = this.recorder.getRIIF2Recorder();
        return true;
    }

    @Override
    public Boolean visitTemplateDeclaration(RIIF2Parser.TemplateDeclarationContext ctx) {
        super.visitTemplateDeclaration(ctx);

        this.recorder.setTemplate(true);
        this.templateParser = new TemplateParser(this.recorder);

        this.moduleCounter++;
        ParseTree templateTree = this.parseTree.getChild(this.moduleCounter);
        walker.walk(this.templateParser,templateTree);

        // set the RIIF2 definition
        this.recorder.setDefinition(this.parser.getTokenStream().getText(ctx));
        // replace the recorder
        this.recorder = this.recorder.getRIIF2Recorder();
        return true;
    }


    // keeping the tree for listener
    private final ParseTree parseTree;

    // keeping the parser : RIIF2 definition
    private final RIIF2Parser parser;
    private RIIF2Recorder recorder;
    private ComponentParser componentParser ;

    private TemplateParser templateParser ;
    private int moduleCounter = -1;

    private final ParseTreeWalker walker = new ParseTreeWalker();

    @Override
    public void generateDB(SQLConnector sqlConnector) {

    }

    @Override
    public RIIF2Recorder getRIIF2Recorder() {
        return this.recorder;
    }
}