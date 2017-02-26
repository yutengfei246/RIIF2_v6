package it.polito.yutengfei.RIIF2.parser.typeUtility;

import org.antlr.v4.runtime.tree.TerminalNode;

public class BindContract {
    private TerminalNode requireNode;

    public TerminalNode getComponentNode() {
        return componentNode;
    }

    private TerminalNode componentNode;

    public void setRequireNode(TerminalNode requireNode) {
        this.requireNode = requireNode;
    }

    public void setComponentNode(TerminalNode componentNode) {
        this.componentNode = componentNode;
    }
}
