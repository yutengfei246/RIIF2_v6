package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.id.Id;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;


abstract class IdParser extends TypeParser {

    private ParseTreeProperty<Id> idParseTreeProperty = new ParseTreeProperty<>();

    @Override
    Id getId(ParseTree node) {
        return this.idParseTreeProperty.get(node);
    }

    private void putId(ParseTree node, Id id ) {
        this.idParseTreeProperty.put(node , id);
    }

    @Override
    public void enterAttributeIndex(RIIF2Parser.AttributeIndexContext ctx) {

        Id id;

        TerminalNode Identifier = ctx.Identifier();
        String identifier = Identifier.getText();

        Token IdentifierToken = Identifier.getSymbol();

        id = Id.attributeIndex(identifier, IdentifierToken.getLine(), IdentifierToken.getCharPositionInLine());
        this.putId(ctx,id);
    }

    @Override
    public void enterAssociativeIndex(RIIF2Parser.AssociativeIndexContext ctx) {

        Id id;

        TerminalNode Identifier = ctx.Identifier();
        String identifier = Identifier.getText();

        Token IdentifierToken = Identifier.getSymbol();

        id = Id.associativeIndex(identifier, IdentifierToken.getLine(), IdentifierToken.getCharPositionInLine());
        this.putId(ctx,id);
    }

    @Override
    public void enterHierPostfix(RIIF2Parser.HierPostfixContext ctx) {

        Id id;

        TerminalNode Identifier = ctx.Identifier();
        String identifier = Identifier.getText();

        Token IdentifierToken = Identifier.getSymbol();

        id = Id.hierIndex(identifier, IdentifierToken.getLine(), IdentifierToken.getCharPositionInLine());
        this.putId(ctx,id);
    }

    @Override
    public void exitPrimitiveIdIdentifier(RIIF2Parser.PrimitiveIdIdentifierContext ctx) {

        Id id;

        TerminalNode Identifier = ctx.Identifier();
        String identifier = Identifier.getText();

        Token IdentifierToken = ctx.Identifier().getSymbol();

        id = Id.primitiveId(identifier, IdentifierToken.getLine(), IdentifierToken.getCharPositionInLine() );
        this.putId(ctx,id);
    }

    @Override
    public void exitPrimitiveIdId(RIIF2Parser.PrimitiveIdIdContext ctx) {

        Id id;

        Id primitiveId = getId(ctx.primitiveId());
        Id hierPostfixId = getId(ctx.hierPostfix());

        id= Id.primitiveIdId(primitiveId, hierPostfixId);
        this.putId(ctx,id);
    }

    @Override
    public void exitAssociativeId(RIIF2Parser.AssociativeIdContext ctx) {

        Id id;

        Id primitiveId = getId( ctx.primitiveId() );
        Id associativeIndex = getId( ctx.associativeIndex() );

        id = Id.associativeId( primitiveId, associativeIndex);
        this.putId(ctx,id);

    }

    @Override
    public void exitAttributePrimitiveIdIndex(RIIF2Parser.AttributePrimitiveIdIndexContext ctx) {

        Id id;

        Id primitiveId = getId( ctx.primitiveId() );
        Id attributeIndex = getId( ctx.attributeIndex() );

        id = Id.attributeId( primitiveId, attributeIndex);
        this.putId(ctx,id);
    }

    @Override
    public void exitAttributeAssociativeIdIndex(RIIF2Parser.AttributeAssociativeIdIndexContext ctx) {

        Id id;

        Id associativeId = getId( ctx.associativeId() );
        Id attributeIndex = getId( ctx.attributeIndex());

        id = Id.attributeId( associativeId, attributeIndex);
        this.putId(ctx,id);
    }

    @Override
    public void exitVariableId(RIIF2Parser.VariableIdContext ctx) {

        Id id = null;

        if (ctx.primitiveId() != null )
            id =  getId(ctx.primitiveId());
        if (ctx.associativeId() != null)
            id = getId(ctx.associativeId());
        if (ctx.attributeId() != null )
            id = getId(ctx.attributeId());
        if (ctx.tableId() != null)
            id = getId(ctx.tableId());

        this.putId(ctx,id);

    }

    @Override
    public void exitTableId(RIIF2Parser.TableIdContext ctx) {

        Id id;

        Id attributeId = getId(ctx.attributeId());

        List<TerminalNode> Identifiers = ctx.Identifier();

        int line = ctx.start.getLine();
        int column = ctx.start.getCharPositionInLine();
        if (Identifiers.size() == 1){
            TerminalNode Identifier = ctx.Identifier(0);
            String identifier = Identifier.getText();

            id = Id.tableId(attributeId,"#",identifier, line, column);
            this.putId(ctx,id);
        }
        else {
            TerminalNode Identifier1 = ctx.Identifier(0);
            TerminalNode Identifier2 = ctx.Identifier(1);

            String identifier1 = Identifier1.getText();
            String identifier2 = Identifier2.getText();

            id = Id.tableId(attributeId, identifier1, identifier2, line, column);
            this.putId(ctx,id);
        }
    }

    @Override
    public void exitTableIndex(RIIF2Parser.TableIndexContext ctx) {

        Id id;

        List<TerminalNode> Identifiers = ctx.Identifier();


        int line = ctx.start.getLine();
        int column = ctx.start.getCharPositionInLine();

        if (Identifiers.size() == 1){
            TerminalNode Identifier = ctx.Identifier(0);

            String identifier = Identifier.getText();

            id = Id.tableId("#", identifier,line,column);
        }else {
            TerminalNode Identifier1 = ctx.Identifier(0);
            TerminalNode Identifier2 = ctx.Identifier(1);

            String identifier1 = Identifier1.getText();
            String identifier2 = Identifier2.getText();

            id = Id.tableId(identifier1, identifier2, line,column);
        }

        this.putId(ctx,id);
    }
}
