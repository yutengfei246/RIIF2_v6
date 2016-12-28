package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.factory.*;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;


public class ComponentParser extends DeclaratorParser {

    private ComponentFactory componentFactory = null;

    public ComponentParser(RIIF2Recorder recorder){
        this.componentFactory = Factory.newComponentFactory(recorder);
    }

    @Override
    public void enterComponentDeclaration(RIIF2Parser.ComponentDeclarationContext ctx) {

        TerminalNode Identifier = ctx.Identifier();
        String identifier = Identifier.getText();

        this.componentFactory.start( identifier );
    }

    @Override
    public void enterExtendsList(RIIF2Parser.ExtendsListContext ctx) {
        List<TerminalNode>  Identifiers = ctx.Identifier();

        if( Identifiers.size() != 0)
            this.componentFactory.startImplEx();

        for (TerminalNode Identifier : Identifiers){
            String identifier = Identifier.getText();
            this.componentFactory.setCurrentComponentExtendsIdentifier(identifier);
        }
    }

    @Override
    public void enterImplementsList(RIIF2Parser.ImplementsListContext ctx) {
        List<TerminalNode> Identifiers = ctx.Identifier();
        for(TerminalNode Identifier : Identifiers){
            String identifier = Identifier.getText();
            this.componentFactory.setCurrentComponentImplementsIdentifier(identifier);
        }
    }

    @Override
    public void exitImplementsList(RIIF2Parser.ImplementsListContext ctx) {
        this.componentFactory.commitImplEx();
    }

    @Override
    public void enterFieldDeclaration(RIIF2Parser.FieldDeclarationContext ctx) {
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
    public void enterChildComponentDeclaration(RIIF2Parser.ChildComponentDeclarationContext ctx) {
        this.componentFactory.startCC(/*child component declaration;*/);
    }

    @Override
    public void exitChildComponentDeclaration(RIIF2Parser.ChildComponentDeclarationContext ctx) {

        Declarator ccDeclarator = getDeclarator(ctx.childComponentDeclarator());
        this.componentFactory.setCCDeclarator( ccDeclarator );
    }

    @Override
    public void enterFailModeDeclaration(RIIF2Parser.FailModeDeclarationContext ctx) {
        this.componentFactory.startFailMode();
    }

    @Override
    public void exitFailModeDeclaration(RIIF2Parser.FailModeDeclarationContext ctx) {

        Declarator fmDeclarator = getDeclarator(ctx.failModeDeclarator());
        this.componentFactory.setFailModeDeclarator( fmDeclarator );
    }

    @Override
    public void exitComponentBodyElement(RIIF2Parser.ComponentBodyElementContext ctx) {

        if (ctx.fieldDeclaration() != null)
            this.componentFactory.commitField();
        if (ctx.childComponentDeclaration() != null)
            this.componentFactory.commitCC();
        if (ctx.failModeDeclaration() != null)
            this.componentFactory.commitFM();
    }

    @Override
    public void exitComponentDeclaration(RIIF2Parser.ComponentDeclarationContext ctx) {
        this.componentFactory.commit();
    }

}
