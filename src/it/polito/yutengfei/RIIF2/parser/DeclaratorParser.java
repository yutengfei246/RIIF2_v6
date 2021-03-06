package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.Declarator.*;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

abstract class DeclaratorParser extends InitializerParser {

    private ParseTreeProperty<Declarator> declaratorParseTreeProperty
            = new ParseTreeProperty<>();

    Declarator getDeclarator(ParseTree node){
        return this.declaratorParseTreeProperty.get(node);
    }

    private void putDeclarator(ParseTree node, Declarator declarator){
        this.declaratorParseTreeProperty.put(node, declarator);
    }

    @Override
    public void exitPrimitiveFieldDeclarator(RIIF2Parser.PrimitiveFieldDeclaratorContext ctx) {

        PrimitiveFieldDeclarator primitiveFieldDeclarator
                = new PrimitiveFieldDeclarator();

        DeclaratorId declaratorId = getDeclaratorId(ctx.primitiveFieldDeclaratorId());
        primitiveFieldDeclarator.setDeclaratorId( declaratorId );

        RIIF2Type primitiveType = getRIIF2Type(ctx.primitiveType());
        primitiveFieldDeclarator.setPrimitiveType( primitiveType);

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
        if (ctx.associativeIndexDeclarator() != null)
            declarator = getDeclarator( ctx.associativeIndexDeclarator() );
        if (ctx.tableFieldDeclarator() != null )
            declarator = getDeclarator( ctx.tableFieldDeclarator());
        if (ctx.listFieldDeclarator() != null)
            declarator = getDeclarator( ctx.listFieldDeclarator());

        this.putDeclarator(ctx,declarator);
    }

    @Override
    public void exitAssociativeIndexDeclarator(RIIF2Parser.AssociativeIndexDeclaratorContext ctx) {

        AssociativeDeclarator associativeDeclarator
                = new AssociativeDeclarator();

        DeclaratorId declaratorId = getDeclaratorId( ctx.associativeIndexDeclaratorId() );
        associativeDeclarator.setDeclaratorId( declaratorId );

        if (ctx.fieldInitializer() != null )
            associativeDeclarator.setInitializer( getInitializer( ctx.fieldInitializer() ));

        this.putDeclarator(ctx,associativeDeclarator);
    }

    @Override
    public void exitTableFieldDeclarator(RIIF2Parser.TableFieldDeclaratorContext ctx) {

        TableDeclarator tableDeclarator =
                new TableDeclarator();

        DeclaratorId declaratorId = getDeclaratorId( ctx.tableFieldDeclaratorId() );
        tableDeclarator.setDeclaratorId(declaratorId);

        this.putDeclarator(ctx,tableDeclarator);
    }

    @Override
    public void exitListFieldDeclarator(RIIF2Parser.ListFieldDeclaratorContext ctx) {

        ListDeclarator listDeclarator
                = new ListDeclarator();

        DeclaratorId declaratorId = getDeclaratorId(ctx.listFieldDeclaratorId());
        listDeclarator.setDeclaratorId( declaratorId );

        Initializer initializer = getListInitializer();

        listDeclarator.setInitializer( initializer );
        this.putDeclarator(ctx,listDeclarator);
    }

    @Override
    public void exitChildComponentDeclarator(RIIF2Parser.ChildComponentDeclaratorContext ctx) {

        ChildComponentDeclarator childComponentDeclarator
                = new ChildComponentDeclarator();

        RIIF2Type type = getRIIF2Type( ctx.childComponentType() );
        childComponentDeclarator.setCCType( type);

        DeclaratorId declaratorId = getDeclaratorId(ctx.childComponentDeclaratorId());
        childComponentDeclarator.setDeclaratorId(declaratorId);

        this.putDeclarator(ctx,childComponentDeclarator);
    }

    @Override
    public void exitFailModeDeclarator(RIIF2Parser.FailModeDeclaratorContext ctx) {

        FailModeDeclarator failModeDeclarator
                = new FailModeDeclarator();

        DeclaratorId declaratorId = getDeclaratorId(ctx.failModeDeclaratorId());
        failModeDeclarator.setDeclaratorId(declaratorId);

        this.putDeclarator(ctx,failModeDeclarator);
    }

    @Override
    public void exitAisDeclarator(RIIF2Parser.AisDeclaratorContext ctx) {

        AisDeclarator aisDeclarator
                = new AisDeclarator();

        DeclaratorId declaratorId = getDeclaratorId(ctx.aisDeclaratorId());
        aisDeclarator.setDeclaratorId(declaratorId);

        Initializer initializer = getInitializer(ctx.aisInitializer());
        aisDeclarator.setInitializer( initializer );

        this.putDeclarator(ctx, aisDeclarator );
    }
}
