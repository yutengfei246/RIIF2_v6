package it.polito.yutengfei.RIIF2.parser;


import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.factory.partsFactory.EnvironmentFactory;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import org.antlr.v4.runtime.tree.TerminalNode;

public class EnvironmentParser extends DeclaratorParser {

    private final EnvironmentFactory environmentFactory ;

    public EnvironmentParser(RIIF2Recorder recorder ) {
        this.environmentFactory = Factory.newEnvironmentFactory(recorder);
    }


    @Override
    public void enterEnvironmentDeclaration(RIIF2Parser.EnvironmentDeclarationContext ctx) {

        TerminalNode Identifier = ctx.Identifier();
        String environmentName = Identifier.getText().toLowerCase();

        this.environmentFactory.start(environmentName);
    }

    @Override
    public void enterEnvParameterDeclaration(RIIF2Parser.EnvParameterDeclarationContext ctx) {
        this.environmentFactory.startField();
    }

    @Override
    public void exitEnvParameterDeclaration(RIIF2Parser.EnvParameterDeclarationContext ctx) {

        RIIF2Type inputOutput = getRIIF2Type(ctx.inputOutput());
        RIIF2Type fieldType = getRIIF2Type( ctx.fieldType());

        Declarator fieldDeclarator = getDeclarator(ctx.primitiveFieldDeclarator());
        this.environmentFactory.setInputOutput( inputOutput ) ;
        this.environmentFactory.setFieldType( fieldType );
        this.environmentFactory.setDeclarator( fieldDeclarator );

    }

    @Override
    public void enterAssignment(RIIF2Parser.AssignmentContext ctx) {
        this.environmentFactory.startAIS(RIIF2Grammar.ASSIGNMENT);
    }

    @Override
    public void exitAssignment(RIIF2Parser.AssignmentContext ctx) {
        Declarator assign = getDeclarator(ctx.aisDeclarator());
        this.environmentFactory.setDeclarator(assign);
    }

    @Override
    public void exitEnvironmentBodyElement(RIIF2Parser.EnvironmentBodyElementContext ctx) {
        this.environmentFactory.commitFactory();
    }
}
