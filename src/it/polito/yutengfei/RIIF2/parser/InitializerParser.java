package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.ArrayItem;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Row;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.RowItem;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

abstract class InitializerParser extends ExpressionParser {

    // list initializer parser

    private ParseTreeProperty<String> listItemTree = new ParseTreeProperty<>();
    private List<String> listInitializer = null;

    private void putListItemString(ParseTree node, String value ){
        this.listItemTree.put(node,value);
    }

    private String getListItemString(ParseTree node){
        return this.listItemTree.get(node);
    }

    public List<String> getListInitializer(){
        List<String> returnedList = this.listInitializer;
        this.cleanListInitializer();
        return returnedList;
    }

    private void cleanListInitializer(){
        this.listItemTree = new ParseTreeProperty<>();
        this.listItemTree = null;
    }

    @Override
    public void exitListItemDecimalLiteral(RIIF2Parser.ListItemDecimalLiteralContext ctx) {
        TerminalNode DecimalToken = ctx.DecimalLiteral();
        String decimalToken = DecimalToken.getText();

        this.putListItemString(ctx,decimalToken);
    }

    @Override
    public void exitListItemFloatingPointLiteral(RIIF2Parser.ListItemFloatingPointLiteralContext ctx) {
        TerminalNode FloatingPointToken = ctx.FloatingPointLiteral();
        String floatingPointToken = FloatingPointToken.getText();

        this.putListItemString(ctx,floatingPointToken);
    }

    @Override
    public void exitListItemIdentifier(RIIF2Parser.ListItemIdentifierContext ctx) {
        TerminalNode TextToken = ctx.Identifier();
        String textToken = TextToken.getText();

        this.putListItemString(ctx,textToken);
    }

    @Override
    public void exitListInitializer(RIIF2Parser.ListInitializerContext ctx) {
        List<RIIF2Parser.ListItemContext> listItemContexts
                = ctx.listItem();

        List<String> currentListInitializer = new ArrayList<>();
        for (RIIF2Parser.ListItemContext listItemContext : listItemContexts){
            String listItem = this.getListItemString(listItemContext);
            currentListInitializer.add(listItem);
        }
        this.listInitializer = currentListInitializer;
    }

    // array initializer parser

    private ParseTreeProperty<ArrayItem> arrayItemTree = new ParseTreeProperty<>();
    private List<ArrayItem> arrayInitializer = null;

    public List<ArrayItem> getArrayInitializer(){
        List<ArrayItem> returnedList = this.arrayInitializer;
        this.cleanArrayInitializer();
        return returnedList;
    }

    private void cleanArrayInitializer(){
        this.arrayInitializer = null;
        this.arrayItemTree = new ParseTreeProperty<>();
    }

    private void putArrayItem(ParseTree node , ArrayItem value){
        this.arrayItemTree.put(node,value);
    }

    private ArrayItem getArrayItem(ParseTree node){
        return this.arrayItemTree.get(node);
    }

    @Override
    public void exitArrayItem(RIIF2Parser.ArrayItemContext ctx) {
        RIIF2Parser.ExpressionContext expressionContext
                = ctx.expression();

        Expression expression = getExpression(expressionContext);

        ArrayItem arrayItem = new ArrayItem();
        arrayItem.setItem(expression);

        this.putArrayItem(ctx,arrayItem);
    }

    @Override
    public void exitArrayInitializer(RIIF2Parser.ArrayInitializerContext ctx) {
        List<RIIF2Parser.ArrayItemContext> arrayItemContexts
            = ctx.arrayItem();

        List<ArrayItem> currentArrayInitializer = new ArrayList<>();
        for (RIIF2Parser.ArrayItemContext arrayItemContext : arrayItemContexts){
            ArrayItem arrayItem = this.getArrayItem(arrayItemContext);
            currentArrayInitializer.add(arrayItem);
        }

        this.arrayInitializer = currentArrayInitializer;

        ParserRuleContext parentContext = ctx.getParent();
        if(parentContext instanceof RIIF2Parser.PrimaryContext){
            Expression expression = new Expression();
            expression.setType(RIIF2Grammar.ARRAY);
            expression.setValue(this.getArrayInitializer());
            putExpression(ctx,expression);
        }

        if(parentContext instanceof RIIF2Parser.ArrayInitializerWrapperContext){
            this.putArrayWrapperListInitializer(ctx,this.getArrayInitializer());
        }

    }

    // array wrapper initializer

    private ParseTreeProperty< List<ArrayItem> > arrayWrapperParseTreeProperty
            = new ParseTreeProperty<>();

    private List< List<ArrayItem> > arrayWrapperInitializer = null;

    private List<ArrayItem> getArrayWrapperListInitializer( ParseTree node ){
        return  this.arrayWrapperParseTreeProperty.get(node);
    }

    private void putArrayWrapperListInitializer(ParseTree node, List<ArrayItem> value ){
        this.arrayWrapperParseTreeProperty.put(node, value);
    }

    public List< List<ArrayItem> > getArrayWrapperInitializer(){
        List< List<ArrayItem> > returnedInitializer = this.arrayWrapperInitializer;
        this.cleanArrayWrapperInitializer();
        return returnedInitializer;
    }

    private void cleanArrayWrapperInitializer() {
        this.arrayWrapperParseTreeProperty = new ParseTreeProperty<>();
        this.arrayWrapperInitializer = null;
    }

    @Override
    public void exitArrayInitializerWrapper(RIIF2Parser.ArrayInitializerWrapperContext ctx) {
        List<RIIF2Parser.ArrayInitializerContext> arrayInitializerContexts
                = ctx.arrayInitializer();

        List< List<ArrayItem> > currentArrayWrapperInitializer
                = new ArrayList<>();
        for(RIIF2Parser.ArrayInitializerContext arrayInitializerContext : arrayInitializerContexts){
            List<ArrayItem> arrayListInitializer = this.getArrayWrapperListInitializer(arrayInitializerContext);
            currentArrayWrapperInitializer.add(arrayListInitializer);
        }

        this.arrayWrapperInitializer = currentArrayWrapperInitializer;
    }



    //table Item Initializer

    private ParseTreeProperty<Row> rowParseTreeProperty = new ParseTreeProperty<>();
    private ParseTreeProperty<RowItem> rowItemParseTreeProperty = new ParseTreeProperty<>();
    private List<Row> tableInitializer = null;

    private void putRowParseTree(ParseTree node , Row value ){
        this.rowParseTreeProperty.put(node,value);
    }

    private Row getRowParseTree(ParseTree node ){
        return this.rowParseTreeProperty.get(node );
    }

    private void putRowItemParseTree(ParseTree node ,RowItem value){
        this.rowItemParseTreeProperty.put(node,value);
    }

    private RowItem getRowItemParseTree(ParseTree node){
        return this.rowItemParseTreeProperty.get(node );
    }

    public List<Row> getTableInitializer(){
        List<Row> returnedTable = this.tableInitializer;
        this.cleanTable();
        return returnedTable;
    }

    private void cleanTable(){
        this.rowItemParseTreeProperty = new ParseTreeProperty<>();
        this.rowParseTreeProperty = new ParseTreeProperty<>();
        this.tableInitializer = null;
    }

    @Override
    public void exitRowItemExpression(RIIF2Parser.RowItemExpressionContext ctx) {
        RIIF2Parser.ExpressionContext expressionContext
                = ctx.expression();

        Expression expression = getExpression(expressionContext);

        RowItem rowItem = new RowItem();
        rowItem.setType(RowItem.EXPRESSION);
        rowItem.setValue(expression);

        this.putRowItemParseTree(ctx,rowItem);
    }

    @Override
    public void exitRowItemListInitializer(RIIF2Parser.RowItemListInitializerContext ctx) {
        List<String> list = this.getListInitializer();

        RowItem rowItem = new RowItem();
        rowItem.setType(RowItem.LIST_STRING);
        rowItem.setValue(list);

        this.putRowItemParseTree(ctx,rowItem);
    }

    @Override
    public void exitRowExpression(RIIF2Parser.RowExpressionContext ctx) {
        RIIF2Parser.ExpressionContext expressionContext
                = ctx.expression();

        Expression expression = getExpression(expressionContext);

        if (!expression.isArray()){
            //TODO: exception
            return;
        }

        Row row = new Row();
        row.setType(Row.EXPRESSION);
        row.setValue(expression);

        this.putRowParseTree(ctx,row);
    }

    @Override
    public void exitRowArray(RIIF2Parser.RowArrayContext ctx) {
        List<RIIF2Parser.RowItemContext> rowItemContexts
                = ctx.rowItem();

        List<RowItem> rowItems = new ArrayList<>();
        for (RIIF2Parser.RowItemContext rowItemContext : rowItemContexts){
            RowItem rowItem = this.getRowItemParseTree(rowItemContext);
            rowItems.add(rowItem);
        }

        Row row = new Row();
        row.setType(Row.ROW_ITEMS_ARRAY);
        row.setValue(rowItems);

        this.putRowParseTree(ctx,row);
    }

    @Override
    public void exitTableItemInitializer(RIIF2Parser.TableItemInitializerContext ctx) {
        List<RIIF2Parser.RowContext> rowContexts
                = ctx.row();

        List<Row> currentTableInitializer = new ArrayList<>();
        for (RIIF2Parser.RowContext rowContext : rowContexts){
            Row row = this.getRowParseTree(rowContext);
            currentTableInitializer.add(row);
        }
        this.tableInitializer = currentTableInitializer;
    }
}
