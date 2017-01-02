package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class TemplateParser extends DeclaratorParser{

    private ComponentFactory componentFactory = null;

    public TemplateParser(RIIF2Recorder recorder) {
        this.componentFactory = Factory.newComponentFactory(recorder);
    }

    @Override
    public void enterTemplateDeclaration(RIIF2Parser.TemplateDeclarationContext ctx) {

        TerminalNode Identifier = ctx.Identifier();
        String identifier = Identifier.getText();

        this.componentFactory.start(identifier);
    }

    @Override
    public void enterExtendsList(RIIF2Parser.ExtendsListContext ctx) {
        List<TerminalNode> eXs =ctx.Identifier();

        if (eXs != null && eXs.size() != 0 )
            this.componentFactory.startImplEx();

        for (TerminalNode exIdentifier : eXs ){
            String identifier = exIdentifier.getText();
            this.componentFactory.setCurrentComponentExtendsIdentifier(identifier);
        }
    }

    @Override
    public void exitExtendsList(RIIF2Parser.ExtendsListContext ctx) {
        this.componentFactory.commitImplEx();
    }

    @Override
    public void enterAbstractFieldDeclaration(RIIF2Parser.AbstractFieldDeclarationContext ctx) {
        this.componentFactory.startField();
    }

    @Override
    public void exitFieldDeclaration(RIIF2Parser.FieldDeclarationContext ctx) {

        RIIF2Type fieldType = getRIIF2Type( ctx.fieldType() );

        Declarator fieldDeclarator = getDeclarator( ctx.fieldDeclaratorType() );

        this.componentFactory.setFieldType( fieldType );
        this.componentFactory.setFieldDeclarator( fieldDeclarator );
    }

    @Override
    public void exitAbstractFieldDeclaration(RIIF2Parser.AbstractFieldDeclarationContext ctx) {
        this.componentFactory.commitField();
    }

    @Override
    public void enterAbstractFailModeDeclaration(RIIF2Parser.AbstractFailModeDeclarationContext ctx) {
        this.componentFactory.startFailMode();
    }

    @Override
    public void exitFailModeDeclaration(RIIF2Parser.FailModeDeclarationContext ctx) {

        Declarator fmDeclarator = getDeclarator(ctx.failModeDeclarator());
        this.componentFactory.setFailModeDeclarator( fmDeclarator );
    }

    @Override
    public void exitAbstractFailModeDeclaration(RIIF2Parser.AbstractFailModeDeclarationContext ctx) {
        this.componentFactory.commitFM();
    }

    @Override
    public void enterAbstractChildComponentDeclaration(RIIF2Parser.AbstractChildComponentDeclarationContext ctx) {
        this.componentFactory.startCC();
    }

    @Override
    public void exitChildComponentDeclaration(RIIF2Parser.ChildComponentDeclarationContext ctx) {

        Declarator ccDeclarator = getDeclarator(ctx.childComponentDeclarator());
        this.componentFactory.setCCDeclarator( ccDeclarator );
    }

    @Override
    public void exitAbstractChildComponentDeclaration(RIIF2Parser.AbstractChildComponentDeclarationContext ctx) {
        this.componentFactory.commitCC();
    }

    @Override
    public void enterAbstractPlatformDeclaration(RIIF2Parser.AbstractPlatformDeclarationContext ctx) {
        TerminalNode Identifier = ctx.Identifier();
        String identifier = Identifier.getText();

        this.componentFactory.startPlatform(identifier);
    }

    @Override
    public void exitAbstractPlatformDeclaration(RIIF2Parser.AbstractPlatformDeclarationContext ctx) {
        this.componentFactory.commitPlatform();
    }

    @Override
    public void enterImposeDeclaration(RIIF2Parser.ImposeDeclarationContext ctx) {
        this.componentFactory.startAIS(RIIF2Grammar.IMPOSE);
    }

    @Override
    public void exitImposeDeclaration(RIIF2Parser.ImposeDeclarationContext ctx) {

        Declarator imposeDeclarator = getDeclarator(ctx.aisDeclarator());
        this.componentFactory.setAISDeclarator(imposeDeclarator);

        this.componentFactory.commitAIS();
    }
}
