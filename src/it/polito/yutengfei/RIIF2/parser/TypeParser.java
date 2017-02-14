package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.parser.typeUtility.EnumType;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.parser.typeUtility.UtilityFactory;
import it.polito.yutengfei.RIIF2.parser.typeUtility.Vector;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

abstract class TypeParser extends _RIIF2Parser{

    private ParseTreeProperty<RIIF2Type> riif2TypeParseTreeProperty
            = new ParseTreeProperty<>();


    @Override
    RIIF2Type getRIIF2Type(ParseTree node) {
        return this.riif2TypeParseTreeProperty.get(node);
    }

    private void putRIIF2Type(ParseTree node, RIIF2Type type){
        this.riif2TypeParseTreeProperty.put(node , type );
    }

    @Override
    public void exitPrimitiveType(RIIF2Parser.PrimitiveTypeContext ctx) {

        RIIF2Type type = null;


        if( ctx.TYPE_BOOLEAN() != null )
            type = RIIF2Type.primitiveTypeBoolean(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if( ctx.TYPE_FLOAT() != null)
            type = RIIF2Type.primitiveTypeFloat(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if( ctx.TYPE_INTEGER() != null)
            type = RIIF2Type.primitiveTypeInteger(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if( ctx.TYPE_STRING() != null )
            type = RIIF2Type.primitiveTypeString(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if( ctx.TYPE_TIME() != null)
            type = RIIF2Type.primitiveTypeTime(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if( ctx.enumType() != null)
            type = this.getRIIF2Type(ctx.enumType());
        if( ctx.Identifier() != null) {
            TerminalNode Identifier = ctx.Identifier();
            String identifier = Identifier.getText().toLowerCase();
            Token IdentifierToken = Identifier.getSymbol();

            type = RIIF2Type.primitiveTypeUserDefined( identifier, IdentifierToken.getLine(), IdentifierToken.getCharPositionInLine());
        }

        this.putRIIF2Type(ctx,type);
    }

    @Override
    public void enterEnumType(RIIF2Parser.EnumTypeContext ctx) {

        RIIF2Type type;

        List<TerminalNode> items = ctx.Identifier();
        EnumType enumType = new EnumType();
        for (TerminalNode item : items ) {
            String enumIdentifier = item.getText().toLowerCase();
            enumType.putEnum( enumIdentifier );
        }

        type = RIIF2Type.enumType( enumType ,ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        this.putRIIF2Type(ctx,type);
    }

    @Override
    public void enterAssociativeType(RIIF2Parser.AssociativeTypeContext ctx) {

        RIIF2Type type = RIIF2Type.associativeType(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        this.putRIIF2Type(ctx,type);
    }

    @Override
    public void enterFieldType(RIIF2Parser.FieldTypeContext ctx) {

        RIIF2Type type = null;

        if (ctx.CONSTANT() != null)
            type = RIIF2Type.fieldTypeConstant(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if (ctx.PARAMETER() != null)
            type = RIIF2Type.fieldTypeParameter(ctx.start.getLine(),ctx.start.getCharPositionInLine());


        this.putRIIF2Type(ctx,type);
    }

    @Override
    public void exitVector(RIIF2Parser.VectorContext ctx) {

        RIIF2Type type ;

        RIIF2Parser.ExpressionContext expCtxLeft
                = ctx.expression(0);

        RIIF2Parser.ExpressionContext expCtxRight
                = ctx.expression(1);

        Expression expLeft = getExpression(expCtxLeft);
        Expression expRight = getExpression(expCtxRight);

        Vector vector = UtilityFactory.vector(expLeft , expRight );

        type = RIIF2Type.vectorType(vector);
        this.putRIIF2Type(ctx,type);
    }

    @Override
    public void exitFlatVector(RIIF2Parser.FlatVectorContext ctx) {

        RIIF2Type type;

        RIIF2Parser.ExpressionContext expCL
                = ctx.expression(0);
        RIIF2Parser.ExpressionContext expCR
                = ctx.expression(1);

        Expression expLeft = getExpression(expCL);
        Expression expRight = getExpression(expCR);

        Vector vector = UtilityFactory.vector(expLeft,expRight);

        type = RIIF2Type.flatVectorType(vector);
        this.putRIIF2Type(ctx,type);
    }

    @Override
    public void exitTypeType(RIIF2Parser.TypeTypeContext ctx) {

        RIIF2Type type = null;

        if ( ctx.vector() != null )
            type = this.getRIIF2Type( ctx.vector() );
        if ( ctx.associativeType() != null)
            type = this.getRIIF2Type( ctx.associativeType() );

        this.putRIIF2Type(ctx,type);
    }

    @Override
    public void exitAisType(RIIF2Parser.AisTypeContext ctx) {

        RIIF2Type type = null;

        if ( ctx.associativeType() != null)
            type = this.getRIIF2Type( ctx.associativeType() );
        if ( ctx.flatVector() != null )
            type = this.getRIIF2Type( ctx.flatVector() );

        this.putRIIF2Type(ctx,type);
    }

    @Override
    public void exitChildComponentType(RIIF2Parser.ChildComponentTypeContext ctx) {

        TerminalNode Identifier = ctx.Identifier();
        String identifier = Identifier.getText().toLowerCase();

        Token IdentifierToken = Identifier.getSymbol();

        RIIF2Type type  = RIIF2Type.childComponentType(identifier, IdentifierToken.getLine(), IdentifierToken.getCharPositionInLine());

        this.putRIIF2Type(ctx,type);
    }
}
