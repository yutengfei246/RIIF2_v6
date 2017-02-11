package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;


abstract class DeclaratorIdParser extends IdParser {

    private ParseTreeProperty<DeclaratorId> identifierParseTreeProperty
            = new ParseTreeProperty<>();

    private void putDeclaratorId(ParseTree node, DeclaratorId identifier){
        this.identifierParseTreeProperty.put(node,identifier);
    }

    @Override
    DeclaratorId getDeclaratorId(ParseTree node ){
        return this.identifierParseTreeProperty.get(node);
    }

    @Override
    public void exitPrimitiveFieldDeclaratorId1(RIIF2Parser.PrimitiveFieldDeclaratorId1Context ctx) {
        DeclaratorId identifier = new DeclaratorId();
        this.setPosition(ctx,identifier);

        TerminalNode DeclaratorId = ctx.Identifier();
        String primitiveId = DeclaratorId.getText();
        primitiveId = primitiveId.toLowerCase();
        identifier.setId( primitiveId );

        if (ctx.typeType() != null) {
            RIIF2Type type = getRIIF2Type(ctx.typeType());
            identifier.setTypeType(type);
        }
        if (ctx.attributeIndex() != null) {
            Id id = getId(ctx.attributeIndex());
            identifier.setAttributeIndex( id );
        }

        this.putDeclaratorId(ctx,identifier);
    }

    @Override
    public void exitPrimitiveFieldDeclaratorId2(RIIF2Parser.PrimitiveFieldDeclaratorId2Context ctx) {
        DeclaratorId identifier = new DeclaratorId();
        this.setPosition(ctx,identifier);

        TerminalNode DeclaratorId = ctx.Identifier();
        String primitiveId = DeclaratorId.getText();
        primitiveId = primitiveId.toLowerCase();

        identifier.setId( primitiveId);

        Id id = getId( ctx.associativeIndex() );
        identifier.setAssociativeIndex( id );

        if (ctx.attributeIndex() != null) {
            id = getId(ctx.attributeIndex());
            identifier.setAttributeIndex(id);
        }

        this.putDeclaratorId(ctx,identifier);
    }

    @Override
    public void exitFailModeDeclaratorId1(RIIF2Parser.FailModeDeclaratorId1Context ctx) {
        DeclaratorId identifier = new DeclaratorId();
        this.setPosition(ctx,identifier);

        TerminalNode DeclaratorId = ctx.Identifier();

        String primitiveId = DeclaratorId.getText();
        primitiveId = primitiveId.toLowerCase();
        identifier.setId( primitiveId ) ;

        if (ctx.typeType() != null) {
            RIIF2Type type = getRIIF2Type(ctx.typeType());
            identifier.setTypeType(type);
        }
        if (ctx.attributeIndex() != null) {
            Id id = getId(ctx.attributeIndex());
            identifier.setAttributeIndex( id );
        }

        this.putDeclaratorId(ctx,identifier);
    }

    @Override
    public void exitFailModeDeclaratorId2(RIIF2Parser.FailModeDeclaratorId2Context ctx) {
        DeclaratorId identifier = new DeclaratorId();
        this.setPosition(ctx,identifier);

        TerminalNode DeclaratorId = ctx.Identifier();

        String primitiveId = DeclaratorId.getText();
        primitiveId = primitiveId.toLowerCase();
        identifier.setId( primitiveId );

        Id id = getId( ctx.associativeIndex() );
        identifier.setAssociativeIndex( id );

        if (ctx.attributeIndex() != null) {
            id = getId(ctx.attributeIndex());
            identifier.setAttributeIndex(id);
        }

        this.putDeclaratorId(ctx,identifier);
    }

    @Override
    public void exitAssociativeIndexDeclaratorId(RIIF2Parser.AssociativeIndexDeclaratorIdContext ctx) {
        DeclaratorId identifier = new DeclaratorId();
        this.setPosition(ctx,identifier);

        TerminalNode DeclaratorId = ctx.Identifier();

        String associativeIndex = DeclaratorId.getText();
        identifier.setId(associativeIndex);

        Id id = getId(ctx.associativeIndex());
        identifier.setAssociativeIndex( id );

        this.putDeclaratorId(ctx,identifier);
    }

    @Override
    public void exitTableFieldDeclaratorId(RIIF2Parser.TableFieldDeclaratorIdContext ctx) {
        DeclaratorId identifier = new DeclaratorId();
        this.setPosition(ctx,identifier);

        TerminalNode DeclaratorId = ctx.Identifier();

        String tableId = DeclaratorId.getText();
        identifier.setId(tableId);

        this.putDeclaratorId(ctx,identifier);
    }

    @Override
    public void exitListFieldDeclaratorId(RIIF2Parser.ListFieldDeclaratorIdContext ctx) {
        DeclaratorId identifier = new DeclaratorId();
        this.setPosition(ctx,identifier);

        TerminalNode DeclaratorId = ctx.Identifier();

        String tableId = DeclaratorId.getText();
        identifier.setId(tableId);

        this.putDeclaratorId(ctx,identifier);
    }

    @Override
    public void exitChildComponentDeclaratorId(RIIF2Parser.ChildComponentDeclaratorIdContext ctx) {
        DeclaratorId identifier = new DeclaratorId();
        this.setPosition(ctx,identifier);

        TerminalNode DeclaratorId = ctx.Identifier();

        String childId = DeclaratorId.getText();
        childId = childId.toLowerCase();
        identifier.setId(childId );

        if (ctx.typeType() != null){
            RIIF2Type type = getRIIF2Type( ctx.typeType() );
            identifier.setTypeType(type);
        }
        if (ctx.associativeIndex() != null){
            Id id = getId(ctx.associativeIndex());
            identifier.setAssociativeIndex( id );
        }

        this.putDeclaratorId(ctx,identifier);
    }

    @Override
    public void exitAisDeclaratorId(RIIF2Parser.AisDeclaratorIdContext ctx) {
        DeclaratorId identifier = new DeclaratorId();
        this.setPosition(ctx,identifier);

        Id primitiveId = getId(ctx.primitiveId());
        identifier.setPrimitiveId( primitiveId );

        if (ctx.aisType() != null ){
            RIIF2Type type = getRIIF2Type( ctx.aisType() );
            identifier.setAisType( type );
        }

        Id id ;

        if (ctx.associativeIndex() != null ){
            id = getId(ctx.associativeIndex());
            identifier.setAssociativeIndex( id );
        }
        if (ctx.hierPostfix() != null ){
            id = getId(ctx.hierPostfix());
            identifier.setHierPostfix(id);
        }
        if (ctx.attributeIndex() != null ){
            id = getId(ctx.attributeIndex());
            identifier.setAttributeIndex(id);
        }
        if (ctx.tableIndex() != null ){
            id = getId(ctx.tableIndex());
            identifier.setTableIndex(id);
        }
        this.putDeclaratorId(ctx,identifier);
    }

    private void setPosition(ParserRuleContext ctx,  DeclaratorId id ){
        id.setLine( ctx.start.getLine());
        id.setColumn(ctx.start.getCharPositionInLine());
    }

}