package it.polito.yutengfei.RIIF2.visitor;

import it.polito.yutengfei.RIIF2.RIIF2BaseVisitor;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.mysql.SQLConnector;
import it.polito.yutengfei.RIIF2.parser.ComponentParser;
import it.polito.yutengfei.RIIF2.parser.EnvironmentParser;
import it.polito.yutengfei.RIIF2.parser.RequirementParser;
import it.polito.yutengfei.RIIF2.parser.TemplateParser;
import it.polito.yutengfei.RIIF2.parser.BindParser;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Recorder;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Second Level Visitor
 */
public class SLV extends RIIF2BaseVisitor<Boolean> implements Recorder{

    private BindParser bindParser;

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

    @Override
    public Boolean visitEnvironmentDeclaration(RIIF2Parser.EnvironmentDeclarationContext ctx) {
        super.visitEnvironmentDeclaration(ctx);

        this.recorder.setEnvironment(true);

        this.environmentParser = new EnvironmentParser(this.recorder);

        this.moduleCounter++;
        ParseTree environmentTree = this.parseTree.getChild(this.moduleCounter);
        walker.walk(this.environmentParser,environmentTree);

        // set the RIIF2 definition
        this.recorder.setDefinition(this.parser.getTokenStream().getText(ctx));
        // replace the recorder
        this.recorder = this.recorder.getRIIF2Recorder();
        return true;
    }

    @Override
    public Boolean visitRequirementDeclaration(RIIF2Parser.RequirementDeclarationContext ctx) {
        super.visitRequirementDeclaration(ctx);

        this.recorder.setRequirement(true);

        this.requirementParser = new RequirementParser(this.recorder);

        this.moduleCounter++;
        ParseTree requirementParser = this.parseTree.getChild(this.moduleCounter);
        walker.walk(this.requirementParser,requirementParser);

        // set the RIIF2 definition
        this.recorder.setDefinition(this.parser.getTokenStream().getText(ctx));
        // replace the recorder
        this.recorder = this.recorder.getRIIF2Recorder();
        return true;
    }

    @Override
    public Boolean visitBindDeclaration(RIIF2Parser.BindDeclarationContext ctx) {
        super.visitBindDeclaration(ctx);

        this.recorder.setBind(true);
        this.bindParser = new BindParser(this.recorder);

        this.moduleCounter++;
        ParseTree bindParser = this.parseTree.getChild(this.moduleCounter);
        walker.walk(this.bindParser,bindParser);

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
    private EnvironmentParser environmentParser;
    private TemplateParser templateParser ;
    private RequirementParser requirementParser;

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