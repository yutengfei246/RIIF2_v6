package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.factory.*;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
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
        String identifier = Identifier.getText().toLowerCase();

        this.componentFactory.start( identifier );
    }

    @Override
    public void enterExtendsList(RIIF2Parser.ExtendsListContext ctx) {
        List<TerminalNode>  Identifiers = ctx.Identifier();

        if( Identifiers.size() != 0)
            this.componentFactory.startImplEx(RIIF2Grammar.COMPONENT);

        for (TerminalNode Identifier : Identifiers){
            String identifier = Identifier.getText().toLowerCase();
            this.componentFactory.setCurrentComponentExtendsIdentifier(identifier);
        }
    }

    @Override
    public void exitExtendsList(RIIF2Parser.ExtendsListContext ctx) {
        this.componentFactory.commitFactory();
    }

    @Override
    public void enterImplementsList(RIIF2Parser.ImplementsListContext ctx) {
        List<TerminalNode> Identifiers = ctx.Identifier();

        if( Identifiers.size() != 0)
            this.componentFactory.startImplEx(RIIF2Grammar.COMPONENT);

        for(TerminalNode Identifier : Identifiers){
            String identifier = Identifier.getText().toLowerCase();
            this.componentFactory.setCurrentComponentImplementsIdentifier(identifier);
        }
    }

    @Override
    public void exitImplementsList(RIIF2Parser.ImplementsListContext ctx) {
        this.componentFactory.commitFactory();
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
        this.componentFactory.setDeclarator( fieldDeclarator );
    }

    @Override
    public void enterChildComponentDeclaration(RIIF2Parser.ChildComponentDeclarationContext ctx) {
        this.componentFactory.startCC(/*child component declaration;*/);
    }

    @Override
    public void exitChildComponentDeclaration(RIIF2Parser.ChildComponentDeclarationContext ctx) {

        Declarator ccDeclarator = getDeclarator(ctx.childComponentDeclarator());
        this.componentFactory.setDeclarator( ccDeclarator );
    }

    @Override
    public void enterFailModeDeclaration(RIIF2Parser.FailModeDeclarationContext ctx) {
        this.componentFactory.startFailMode();
    }

    @Override
    public void exitFailModeDeclaration(RIIF2Parser.FailModeDeclarationContext ctx) {

        Declarator fmDeclarator = getDeclarator(ctx.failModeDeclarator());
        this.componentFactory.setDeclarator( fmDeclarator );
    }

    @Override
    public void enterAssignmentDeclaration(RIIF2Parser.AssignmentDeclarationContext ctx) {
        this.componentFactory.startAIS(RIIF2Grammar.ASSIGNMENT);
    }

    @Override
    public void exitAssignmentDeclaration(RIIF2Parser.AssignmentDeclarationContext ctx) {

        Declarator assignmentDeclarator = getDeclarator(ctx.aisDeclarator());
        this.componentFactory.setDeclarator( assignmentDeclarator );
    }

    @Override
    public void enterSetDeclaration(RIIF2Parser.SetDeclarationContext ctx) {
        this.componentFactory.startAIS(RIIF2Grammar.SET);
    }

    @Override
    public void exitSetDeclaration(RIIF2Parser.SetDeclarationContext ctx) {

        Declarator setDeclarator = getDeclarator(ctx.aisDeclarator());
        this.componentFactory.setDeclarator( setDeclarator );
    }

    @Override
    public void exitComponentBodyElement(RIIF2Parser.ComponentBodyElementContext ctx) {
        this.componentFactory.commitFactory();
    }

    @Override
    public void exitComponentDeclaration(RIIF2Parser.ComponentDeclarationContext ctx) {
        this.componentFactory.commit();
    }

}
