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

    // keeping the tree for listener
    private final ParseTree parseTree;

    private RIIF2Recorder recorder;
    private ComponentParser componentParser ;
    private TemplateParser templateParser ;

    private int moduleCounter = -1;
    private final ParseTreeWalker walker = new ParseTreeWalker();

    public SLV (ParseTree parseTree,  RIIF2Recorder recorder){
        this.parseTree = parseTree;
        this.recorder = recorder;
    }

    @Override
    public Boolean visitComponentDeclaration(RIIF2Parser.ComponentDeclarationContext ctx) {
        super.visitComponentDeclaration(ctx);

        this.recorder.setTemplate(false);
        this.componentParser = new ComponentParser(this.recorder);

        this.moduleCounter++;
        ParseTree componentTree = this.parseTree.getChild(this.moduleCounter);
        walker.walk(this.componentParser,componentTree);

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

        this.recorder = this.recorder.getRIIF2Recorder();
        return true;
    }

    @Override
    public void generateDB(SQLConnector sqlConnector) {

    }

    @Override
    public RIIF2Recorder getRIIF2Recorder() {
        return this.recorder;
    }
}