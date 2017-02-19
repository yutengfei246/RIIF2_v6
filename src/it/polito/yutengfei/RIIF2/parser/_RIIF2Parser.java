package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.RIIF2BaseListener;
import it.polito.yutengfei.RIIF2.id.DeclaratorId;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.initializer.ArrayInitializer;
import it.polito.yutengfei.RIIF2.initializer.Initializer;
import it.polito.yutengfei.RIIF2.parser.typeUtility.RIIF2Type;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.Serializable;

abstract class _RIIF2Parser extends RIIF2BaseListener implements Serializable{

    abstract Expression getExpression(ParseTree node);

    abstract DeclaratorId getDeclaratorId(ParseTree node);

    abstract RIIF2Type getRIIF2Type(ParseTree node);

    abstract Id getId(ParseTree node);

    abstract ArrayInitializer getArrayInitializer();

}
