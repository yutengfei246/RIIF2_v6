package it.polito.yutengfei.RIIF2.parser;


import it.polito.yutengfei.RIIF2.RIIF2BaseListener;
import it.polito.yutengfei.RIIF2.RIIF2Parser;

public class RequirementParser extends RIIF2BaseListener {

    @Override
    public void enterRequirementDeclaration(RIIF2Parser.RequirementDeclarationContext ctx) {
        System.out.println("start parsing the requirement "+ ctx.Identifier().getText());
    }

    @Override
    public void exitRequirementDeclaration(RIIF2Parser.RequirementDeclarationContext ctx) {
        System.out.println("finish parsing the requrement");
    }
}
