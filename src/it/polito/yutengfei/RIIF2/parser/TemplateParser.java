package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
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
        String identifier = Identifier.getText().toLowerCase();

        this.componentFactory.start(identifier);
    }

    @Override
    public void enterExtendsList(RIIF2Parser.ExtendsListContext ctx) {
        List<TerminalNode> eXs =ctx.Identifier();

        if (eXs != null && eXs.size() != 0 )
            this.componentFactory.startImplEx(RIIF2Grammar.TEMPLATE);

        assert eXs != null; //?

        for (TerminalNode exIdentifier : eXs ){
            String identifier = exIdentifier.getText().toLowerCase();
            this.componentFactory.setCurrentComponentExtendsIdentifier(identifier);
        }
    }

    @Override
    public void exitExtendsList(RIIF2Parser.ExtendsListContext ctx) {
        this.componentFactory.commitFactory();
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
        this.componentFactory.setDeclarator( fieldDeclarator );
    }

    @Override
    public void enterAbstractFailModeDeclaration(RIIF2Parser.AbstractFailModeDeclarationContext ctx) {
        this.componentFactory.startFailMode();
    }

    @Override
    public void exitFailModeDeclaration(RIIF2Parser.FailModeDeclarationContext ctx) {

        Declarator fmDeclarator = getDeclarator(ctx.failModeDeclarator());
        this.componentFactory.setDeclarator( fmDeclarator );
    }

    @Override
    public void enterAbstractChildComponentDeclaration(RIIF2Parser.AbstractChildComponentDeclarationContext ctx) {
        this.componentFactory.startCC();
    }

    @Override
    public void exitChildComponentDeclaration(RIIF2Parser.ChildComponentDeclarationContext ctx) {

        Declarator ccDeclarator = getDeclarator(ctx.childComponentDeclarator());
        this.componentFactory.setDeclarator( ccDeclarator );
    }

    @Override
    public void enterAbstractPlatformDeclaration(RIIF2Parser.AbstractPlatformDeclarationContext ctx) {
        TerminalNode Identifier = ctx.Identifier();
        String identifier = Identifier.getText();

        this.componentFactory.startPlatform(identifier);
    }

    @Override
    public void enterImposeDeclaration(RIIF2Parser.ImposeDeclarationContext ctx) {
        this.componentFactory.startAIS(RIIF2Grammar.IMPOSE);
    }

    @Override
    public void exitImposeDeclaration(RIIF2Parser.ImposeDeclarationContext ctx) {

        Declarator imposeDeclarator = getDeclarator(ctx.aisDeclarator());
        this.componentFactory.setDeclarator(imposeDeclarator);
    }

    @Override
    public void exitTemplateBodyElement(RIIF2Parser.TemplateBodyElementContext ctx) {
        this.componentFactory.commitFactory();
    }
}
