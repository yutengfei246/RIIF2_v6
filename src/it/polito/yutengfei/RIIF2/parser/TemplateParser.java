package it.polito.yutengfei.RIIF2.parser;

import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Recorder;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by yutengfei on 11/12/16.
 */
public class TemplateParser extends  InitializerParser implements Recorder{

    public TemplateParser(RIIF2Recorder recorder) {

    }

    @Override
    public RIIF2Recorder getRIIF2Recorder() {
        return null;
    }

    @Override
    Expression getExpression(ParseTree node) {
        return null;
    }

    @Override
    void putExpression(ParseTree node, Expression expression) {

    }
}
