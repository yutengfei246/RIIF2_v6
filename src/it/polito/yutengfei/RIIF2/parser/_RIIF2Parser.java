package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.RIIF2BaseListener;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.id.Identifier;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import org.antlr.v4.runtime.tree.ParseTree;

abstract class _RIIF2Parser extends RIIF2BaseListener{

    abstract Expression getExpression(ParseTree node);

    abstract Identifier getIdentifier(ParseTree node);

    abstract RIIF2Type getRIIF2Type(ParseTree node);

    abstract Id getId(ParseTree node);
}
