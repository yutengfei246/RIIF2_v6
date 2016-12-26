package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.Declarator.Declarator;
import it.polito.yutengfei.RIIF2.Declarator.PrimitiveFieldDeclarator;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.id.Identifier;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

abstract class DeclaratorParser extends InitializerParser {

    private ParseTreeProperty<Declarator> declaratorParseTreeProperty
            = new ParseTreeProperty<>();

    public Declarator getDeclarator(ParseTree node){
        return this.declaratorParseTreeProperty.get(node);
    }

    private void putDeclarator(ParseTree node, Declarator declarator){
        this.declaratorParseTreeProperty.put(node, declarator);
    }

    @Override
    public void exitPrimitiveFieldDeclarator(RIIF2Parser.PrimitiveFieldDeclaratorContext ctx) {

        PrimitiveFieldDeclarator primitiveFieldDeclarator
                = new PrimitiveFieldDeclarator();

        Identifier declaratorId = getIdentifier(ctx.primitiveFieldDeclaratorId());
        primitiveFieldDeclarator.setDeclaratorId( declaratorId );

        RIIF2Type declaratorType = getRIIF2Type(ctx.primitiveType());
        primitiveFieldDeclarator.setDeclaratorType( declaratorType );

        if (ctx.fieldInitializer() != null) {
            Initializer initializer = getInitializer(ctx.fieldInitializer());
            primitiveFieldDeclarator.setInitializer(initializer);
        }

        this.putDeclarator(ctx,primitiveFieldDeclarator);
    }

    @Override
    public void exitFieldDeclaratorType(RIIF2Parser.FieldDeclaratorTypeContext ctx) {

        Declarator declarator = null;
        if (ctx.primitiveFieldDeclarator() != null)
            declarator = getDeclarator( ctx.primitiveFieldDeclarator() );

        this.putDeclarator(ctx,declarator);
    }
}
