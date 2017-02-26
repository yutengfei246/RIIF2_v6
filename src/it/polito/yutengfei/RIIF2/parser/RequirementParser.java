package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.factory.RequirementFactory;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;

public class RequirementParser extends DeclaratorParser{

    private final RequirementFactory requirementFactory;

    public RequirementParser(RIIF2Recorder recorder ) {
        this.requirementFactory= Factory.newRequirementFactory(recorder);
    }

    @Override
    public void enterRequirementDeclaration(RIIF2Parser.RequirementDeclarationContext ctx) {
        this.requirementFactory.start(ctx.Identifier().getText().toLowerCase());
    }

    @Override
    public void enterAssertion(RIIF2Parser.AssertionContext ctx) {
        this.requirementFactory.startAssertion();
    }

    @Override
    public void exitAssertion(RIIF2Parser.AssertionContext ctx) {

        Declarator assertionDeclarator = getDeclarator(ctx.assertionDeclarator());

        this.requirementFactory.setDeclarator(assertionDeclarator);
        this.requirementFactory.commitFactory();
    }

    @Override
    public void exitRequirementDeclaration(RIIF2Parser.RequirementDeclarationContext ctx) {
    }
}
