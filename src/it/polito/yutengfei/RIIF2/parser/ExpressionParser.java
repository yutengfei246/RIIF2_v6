package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;


abstract class ExpressionParser extends DeclaratorIdParser {

    private ParseTreeProperty<Expression> expTree = new ParseTreeProperty<>();

    @Override
    Expression getExpression(ParseTree node) {
        return this.expTree.get(node);
    }

    void putExpression(ParseTree node, Expression expression){
        this.expTree.put(node,expression);
    }

    private void setPosition(ParserRuleContext ctx, Expression exp){
        exp.setLine( ctx.start.getLine());
        exp.setColumn(ctx.start.getCharPositionInLine());
    }

    @Override
    public void exitLiteralString(RIIF2Parser.LiteralStringContext ctx) {
        Expression expression = new Expression();
        this.setPosition(ctx,expression);

        String value = ctx.getText();
        expression.setType(RIIF2Grammar.STRING);
        expression.setValue(value);

        this.putExpression(ctx,expression);
    }

    @Override
    public void exitLiteralDecimal(RIIF2Parser.LiteralDecimalContext ctx) {
        Expression expression = new Expression();
        this.setPosition(ctx,expression);

        int value = Integer.valueOf( ctx.getText() );
        expression.setType(RIIF2Grammar.INTEGER);
        expression.setValue(value);

        this.putExpression(ctx,expression);
    }

    @Override
    public void exitLiteralFloatingPoint(RIIF2Parser.LiteralFloatingPointContext ctx) {
        Expression expression = new Expression();
        this.setPosition(ctx,expression);

        Double value = Double.valueOf( ctx.getText() );
        expression.setType(RIIF2Grammar.DOUBLE);
        expression.setValue(value);

        this.putExpression(ctx,expression);
    }

    @Override
    public void exitPrimaryLiteral(RIIF2Parser.PrimaryLiteralContext ctx) {
        Expression expression = this.getExpression(ctx.literal());
        this.putExpression(ctx,expression);
    }

    @Override
    public void exitPrimaryParentheses(RIIF2Parser.PrimaryParenthesesContext ctx) {
        Expression expression = this.getExpression(ctx.expression());
        this.putExpression(ctx,expression);
    }

    @Override
    public void exitPrimaryFalse(RIIF2Parser.PrimaryFalseContext ctx) {
        Expression expression = new Expression();
        this.setPosition(ctx,expression);

        expression.setType(RIIF2Grammar.BOOLEAN);
        expression.setValue(false);

        this.putExpression(ctx,expression);
    }

    @Override
    public void exitPrimaryTrue(RIIF2Parser.PrimaryTrueContext ctx) {
        Expression expression = new Expression();
        this.setPosition(ctx,expression);

        expression.setType(RIIF2Grammar.BOOLEAN);
        expression.setValue(true);

        this.putExpression(ctx,expression);
    }

    @Override
    public void exitPrimarySelf(RIIF2Parser.PrimarySelfContext ctx) {
        Expression expression = new Expression();
        this.setPosition(ctx,expression);

        expression.setType(RIIF2Grammar.SELF);

        this.putExpression(ctx,expression);
    }

    @Override
    public void exitFuncName(RIIF2Parser.FuncNameContext ctx) {
        Expression expression = new Expression();
        this.setPosition(ctx,expression);

        if (ctx.FUNC_EXP() != null)
            expression.setType(RIIF2Grammar.FUNC_EXP);
        if (ctx.FUNC_LOG() != null)
            expression.setType(RIIF2Grammar.FUNC_LOG);
        if (ctx.FUNC_AGG_SINGLE() != null )
            expression.setType(RIIF2Grammar.FUNC_AGG_SINGLE);
        if (ctx.FUNC_GT_N_FAIL() != null )
            expression.setType(RIIF2Grammar.FUNC_GT_N_FAIL);

        this.putExpression(ctx,expression);
    }

    @Override
    public void exitFuncArg(RIIF2Parser.FuncArgContext ctx) {
        Expression expression = null;

        if (ctx.expression() != null )
            expression = this.getExpression(ctx.expression());

        if (ctx.aisDeclaratorId() != null) {
            DeclaratorId declaratorId = this.getDeclaratorId(ctx.aisDeclaratorId());
            expression = new Expression();
            expression.setType(RIIF2Grammar.USER_DEFINED);
            expression.setValue(declaratorId);
            expression.setColumn(ctx.start.getCharPositionInLine());
            expression.setLine(ctx.start.getLine());
        }

        this.putExpression(ctx,expression);
    }

    @Override
    public void exitFuncCall(RIIF2Parser.FuncCallContext ctx) {
        Expression funcName = this.getExpression(ctx.funcName());

        ctx.funcArg().forEach(funcArgContext -> {
            Expression funcArgumentExp = this.getExpression(funcArgContext);
            funcName.addFunctionArgument(funcArgumentExp);
        });

        this.putExpression(ctx,funcName);
    }

    @Override
    public void exitPrimaryFuncCall(RIIF2Parser.PrimaryFuncCallContext ctx) {
        Expression expression = this.getExpression(ctx.funcCall());
        this.putExpression(ctx,expression);
    }

    @Override
    public void exitPrimaryAisDeclaratorId(RIIF2Parser.PrimaryAisDeclaratorIdContext ctx) {
        Expression expression = new Expression();
        this.setPosition(ctx,expression);

        DeclaratorId declaratorId = super.getDeclaratorId(ctx.aisDeclaratorId());
        expression.setType(RIIF2Grammar.USER_DEFINED);
        expression.setValue(declaratorId);

        this.putExpression(ctx,expression);
    }

    @Override
    public void exitPrimaryArrayInitializer(RIIF2Parser.PrimaryArrayInitializerContext ctx) {
        Expression expression = this.getExpression(ctx.arrayInitializer());
        this.putExpression(ctx,expression);
    }

    @Override
    public void exitExpPrimary(RIIF2Parser.ExpPrimaryContext ctx) {
        Expression expression = this.getExpression(ctx.primary());
        this.putExpression(ctx,expression);
    }

    @Override
    public void exitExpPositiveOrNegative(RIIF2Parser.ExpPositiveOrNegativeContext ctx) {
        Expression expression = this.getExpression(ctx.expression());

        Expression newExpression = null;

        if ( ctx.op.getType() == RIIF2Parser.T__15){
            newExpression = expression.operation(Expression.OP_POSITIVE);
        }

        if (ctx.op.getType() == RIIF2Parser.T__16){
            newExpression = expression.operation(Expression.OP_NEGATIVE);
        }

        this.setPosition(ctx,newExpression);

        this.putExpression(ctx,newExpression);
    }

    @Override
    public void exitExpWaveOrNot(RIIF2Parser.ExpWaveOrNotContext ctx) {
        Expression expression = this.getExpression(ctx.expression());
        if (ctx.op.getType() == RIIF2Parser.T__17){
            expression.operation(Expression.OP_WAVE);
        }

        if ( ctx.op.getType() == RIIF2Parser.T__18){
            expression.operation(Expression.OP_NOT);
        }

        this.setPosition(ctx,expression);

        this.putExpression(ctx,expression);
    }

    @Override
    public void exitExpStarOrDivOrMod(RIIF2Parser.ExpStarOrDivOrModContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression rightExp = this.getExpression(ctx.expression(1));

        Expression expression = null ;
        try {
            if (ctx.op.getType() == RIIF2Parser.T__19) {
                expression = leftExp.operation(Expression.OP_STAR, rightExp);
                return;
            }

            if (ctx.op.getType() == RIIF2Parser.T__20) {
                expression = leftExp.operation(Expression.OP_DIV, rightExp);
                return;
            }

            if (ctx.op.getType() == RIIF2Parser.T__21) {
                expression = leftExp.operation(Expression.OP_MOD, rightExp);
            }
        }finally {

            assert expression != null;
            this.setPosition(ctx,expression);

            this.putExpression(ctx,expression);
        }
    }

    @Override
    public void exitExpMinusOrPlus(RIIF2Parser.ExpMinusOrPlusContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression rightExp = this.getExpression(ctx.expression(1));

        Expression expression = null;
        try {
            if (ctx.op.getType() == RIIF2Parser.T__15) {
                expression = leftExp.operation(Expression.OP_PLUS, rightExp);
            }
            if (ctx.op.getType() == RIIF2Parser.T__16) {
                expression = leftExp.operation(Expression.OP_MINUS, rightExp);
            }

        }finally {

            assert expression != null;
            this.setPosition(ctx,expression);

            this.putExpression(ctx,expression);
        }
    }

    @Override
    public void exitExpCmp(RIIF2Parser.ExpCmpContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression rightExp = this.getExpression(ctx.expression(1));

        Expression expression = null;
        try {
            if (ctx.op.getType() == RIIF2Parser.T__22) {
                expression = leftExp.operation(Expression.OP_SM_EQ, rightExp);
                return;
            }
            if (ctx.op.getType() == RIIF2Parser.T__23) {
                expression = leftExp.operation(Expression.OP_BG_EQ, rightExp);
                return;
            }
            if (ctx.op.getType() == RIIF2Parser.T__1) {
                expression = leftExp.operation(Expression.OP_SM, rightExp);
            }
            if (ctx.op.getType() == RIIF2Parser.T__2) {
                expression = leftExp.operation(Expression.OP_BG, rightExp);
            }
        }finally {

            assert expression != null;
            this.setPosition(ctx,expression);

            this.putExpression(ctx,expression);
        }
    }

    @Override
    public void exitExpEqOrNotEq(RIIF2Parser.ExpEqOrNotEqContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression rightExp = this.getExpression(ctx.expression(1));

        Expression expression = null;
        try {
            if (ctx.op.getType() == RIIF2Parser.T__24) {
                expression = leftExp.operation(Expression.OP_EQ_EQ, rightExp);
                return;
            }
            if (ctx.op.getType() == RIIF2Parser.T__25) {
                expression = leftExp.operation(Expression.OP_NOT_EQ, rightExp);
            }
        }finally {

            assert expression != null;
            this.setPosition(ctx,expression);

            this.putExpression(ctx,expression);
        }
    }

    @Override
    public void exitExpSingleAnd(RIIF2Parser.ExpSingleAndContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression rightExp = this.getExpression(ctx.expression(1));

        Expression expression = null;
        try {
            if (ctx.op.getType() == RIIF2Parser.T__26) {
                expression = leftExp.operation(Expression.OP_SINGLE_AND, rightExp);
            }
        }finally {

            assert expression != null;
            this.setPosition(ctx,expression);

            this.putExpression(ctx,expression);
        }
    }

    @Override
    public void exitExpPower(RIIF2Parser.ExpPowerContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression rightExp = this.getExpression(ctx.expression(1));

        Expression expression = null;
        try {
            if (ctx.op.getType() == RIIF2Parser.T__27) {
                expression = leftExp.operation(Expression.OP_SINGLE_POWER, rightExp);
            }

        }finally {

            assert expression != null;
            this.setPosition(ctx,expression);

            this.putExpression(ctx,expression);
        }
    }

    @Override
    public void exitExpSingleOr(RIIF2Parser.ExpSingleOrContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression rightExp = this.getExpression(ctx.expression(1));

        Expression expression = null;
        try {
            if (ctx.op.getType() == RIIF2Parser.T__28) {
                expression = leftExp.operation(Expression.OP_SINGLE_OR, rightExp);
            }

        }finally {

            assert expression != null;
            this.setPosition(ctx,expression);

            this.putExpression(ctx,expression);
        }
    }

    @Override
    public void exitExpDoubleAnd(RIIF2Parser.ExpDoubleAndContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression rightExp = this.getExpression(ctx.expression(1));

        Expression expression = null;
        try {
            if (ctx.op.getType() == RIIF2Parser.T__29) {
                expression = leftExp.operation(Expression.OP_DOUBLE_AND, rightExp);
            }

        }finally {

            assert expression != null;
            this.setPosition(ctx,expression);

            this.putExpression(ctx,expression);
        }
    }

    @Override
    public void exitExpDoubleOr(RIIF2Parser.ExpDoubleOrContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression rightExp = this.getExpression(ctx.expression(1));

        Expression expression = null;
        try {
            if (ctx.op.getType() == RIIF2Parser.T__30) {
                expression = leftExp.operation(Expression.OP_DOUBLE_OR, rightExp);
            }

        }finally {

            assert expression != null;
            this.setPosition(ctx,expression);

            this.putExpression(ctx,expression);
        }
    }

    @Override
    public void exitExpAssign(RIIF2Parser.ExpAssignContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression rightExp = this.getExpression(ctx.expression(1));

        leftExp.operation(Expression.OP_ASSIGN, rightExp);
        this.setPosition(ctx,leftExp);

        this.putExpression(ctx,leftExp);
    }

    @Override
    public void exitExpIfElse(RIIF2Parser.ExpIfElseContext ctx) {
        Expression leftExp = this.getExpression(ctx.expression(0));
        Expression middleExp = this.getExpression(ctx.expression(1));
        Expression rightExp = this.getExpression(ctx.expression(2));

        Expression expression;

        expression = leftExp.operation(Expression.OP_IF_ELSE, middleExp,rightExp);
        this.setPosition(ctx,expression);

        this.putExpression(ctx,expression);

    }
}

