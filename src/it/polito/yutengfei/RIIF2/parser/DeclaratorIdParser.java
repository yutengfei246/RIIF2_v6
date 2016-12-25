package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.id.Identifier;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;


abstract class DeclaratorIdParser extends IdParser {

    private ParseTreeProperty<Identifier> identifierParseTreeProperty
            = new ParseTreeProperty<>();

    private void putIdentifier(ParseTree node, Identifier identifier){
        this.identifierParseTreeProperty.put(node,identifier);
    }

    @Override
    Identifier getIdentifier(ParseTree node ){
        return this.identifierParseTreeProperty.get(node);
    }

    @Override
    public void exitPrimitiveFieldDeclaratorId1(RIIF2Parser.PrimitiveFieldDeclaratorId1Context ctx) {
        Identifier identifier = new Identifier();

        TerminalNode Identifier = ctx.Identifier();
        String primitiveId = Identifier.getText();
        identifier.setId( primitiveId );

        if (ctx.typeType() != null) {
            RIIF2Type type = getRIIF2Type(ctx.typeType());
            identifier.setTypeType(type);
        }
        if (ctx.attributeIndex() != null) {
            Id id = getId(ctx.attributeIndex());
            identifier.setAttributeIndex( id );
        }

        this.putIdentifier(ctx,identifier);
    }

    @Override
    public void exitPrimitiveFieldDeclaratorId2(RIIF2Parser.PrimitiveFieldDeclaratorId2Context ctx) {
        Identifier identifier = new Identifier();

        TerminalNode Identifier = ctx.Identifier();
        String primitiveId = Identifier.getText();
        identifier.setId( primitiveId );

        Id id = getId( ctx.associativeIndex() );
        identifier.setAssociativeIndex( id );

        id = getId( ctx.attributeIndex());
        identifier.setAttributeIndex(id);

        this.putIdentifier(ctx,identifier);
    }

    @Override
    public void exitAssociativeIndexDeclaratorId(RIIF2Parser.AssociativeIndexDeclaratorIdContext ctx) {
        Identifier identifier = new Identifier();

        TerminalNode Identifier = ctx.Identifier();
        String associativeIndex = Identifier.getText();
        identifier.setId(associativeIndex);

        Id id = getId(ctx.associativeIndex());
        identifier.setAssociativeIndex( id );

        this.putIdentifier(ctx,identifier);
    }

    @Override
    public void exitTableFieldDeclaratorId(RIIF2Parser.TableFieldDeclaratorIdContext ctx) {
        Identifier identifier = new Identifier();

        TerminalNode Identifier = ctx.Identifier();
        String tableId = Identifier.getText();
        identifier.setId(tableId);

        this.putIdentifier(ctx,identifier);
    }

    @Override
    public void exitListFieldDeclaratorId(RIIF2Parser.ListFieldDeclaratorIdContext ctx) {
        Identifier identifier = new Identifier();

        TerminalNode Identifier = ctx.Identifier();
        String tableId = Identifier.getText();
        identifier.setId(tableId);

        this.putIdentifier(ctx,identifier);
    }

    @Override
    public void exitChildComponentDeclaratorId(RIIF2Parser.ChildComponentDeclaratorIdContext ctx) {
        Identifier identifier = new Identifier();

        TerminalNode Identifier = ctx.Identifier();
        String childId = Identifier.getText();
        identifier.setId(childId);

        if (ctx.typeType() != null){
            RIIF2Type type = getRIIF2Type( ctx.typeType() );
            identifier.setTypeType(type);
        }
        if (ctx.associativeIndex() != null){
            Id id = getId(ctx.associativeIndex());
            identifier.setAssociativeIndex( id );
        }
        if (ctx.attributeIndex() != null){
            Id id = getId( ctx.attributeIndex() );
            identifier.setAttributeIndex( id );
        }

        this.putIdentifier(ctx,identifier);
    }

    @Override
    public void exitFailModeDeclaratorId(RIIF2Parser.FailModeDeclaratorIdContext ctx) {
        Identifier identifier = new Identifier();

        TerminalNode Identifier = ctx.Identifier();
        String childId = Identifier.getText();
        identifier.setId(childId);

        if (ctx.typeType() != null){
            RIIF2Type type = getRIIF2Type( ctx.typeType() );
            identifier.setTypeType(type);
        }
        if (ctx.associativeIndex() != null){
            Id id = getId(ctx.associativeIndex());
            identifier.setAssociativeIndex( id );
        }
        if (ctx.attributeIndex() != null){
            Id id = getId( ctx.attributeIndex() );
            identifier.setAttributeIndex( id );
        }

        this.putIdentifier(ctx,identifier);
    }

    @Override
    public void exitAisDeclaratorId1(RIIF2Parser.AisDeclaratorId1Context ctx) {
        Identifier identifier = new Identifier();

        if (ctx.aisType() != null ){
            RIIF2Type type = getRIIF2Type( ctx.aisType() );
            identifier.setAisType( type );
        }
        if (ctx.associativeIndex() != null){
            Id id = getId(ctx.associativeIndex());
            identifier.setAssociativeIndex( id );
        }
        if (ctx.hierPostfix() != null ) {
            Id id = getId(ctx.hierPostfix());
            identifier.setHierPostfix(id);
        }
        if (ctx.attributeIndex() != null ){
            Id id = getId(ctx.attributeIndex());
            identifier.setAttributeIndex(id);
        }

        this.putIdentifier(ctx,identifier);
    }

    @Override
    public void exitAisDeclaratorId2(RIIF2Parser.AisDeclaratorId2Context ctx) {
        Identifier identifier = new Identifier();

        Id id = getId(ctx.tableId());
        identifier.setTableId( id );
        this.putIdentifier(ctx, identifier);
    }
}