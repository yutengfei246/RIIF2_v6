package it.polito.yutengfei.RIIF2.parser;


import it.polito.yutengfei.RIIF2.RIIF2BaseListener;
import it.polito.yutengfei.RIIF2.RIIF2Parser;
import it.polito.yutengfei.RIIF2.parser.typeUtility.BindContract;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.recoder.Repository;
import org.antlr.v4.runtime.tree.TerminalNode;

public class BindParser extends RIIF2BaseListener{

    private final RIIF2Recorder recorder;
    RIIF2Recorder reRecorder, coRecorder;

    public BindParser(RIIF2Recorder recorder) {
        this.recorder = recorder;
    }


    @Override
    public void exitBindDeclaratorId(RIIF2Parser.BindDeclaratorIdContext ctx) {

        BindContract bindContract = new BindContract();

        TerminalNode requirement = ctx.Identifier(0);
        TerminalNode component= ctx.Identifier(1);

        bindContract.setRequireNode(requirement);
        bindContract.setComponentNode(component);


        if (!Repository.containsRequirement(requirement.getText().toLowerCase())){
            System.out.println("Can not find the Binded requirement " + requirement.getText().toLowerCase() + " in line:colunm " + requirement.getSymbol().getLine() + ":" + component.getSymbol().getCharPositionInLine());
            System.exit(1);
        }

        reRecorder = (RIIF2Recorder) Repository.getDeepCopedRecorderFromRequirementRepository(requirement.getText().toLowerCase());

        if (!Repository.containsComponent(component.getText().toLowerCase())){
            System.out.println("Can not find the Binded component " + component.getText().toLowerCase() + " in line:colunm " + component.getSymbol().getLine() + ":" + component.getSymbol().getCharPositionInLine());
            System.exit(1);
        }

        coRecorder = (RIIF2Recorder) Repository.getDeepCopedRecorderFromComponentRepository(component.getText().toLowerCase());

        this.recorder.setIdentifier(requirement.getText().toLowerCase() + ":" + component.getText().toLowerCase());

    }


    @Override
    public void enterBindContract(RIIF2Parser.BindContractContext ctx) {

        TerminalNode requireLabel = ctx.Identifier(0);
        TerminalNode componentLabel = ctx.Identifier(1);

        String requirementString = requireLabel.getText().toLowerCase();
        String componentString = componentLabel.getText().toLowerCase();

        if (!this.reRecorder.containsAssertion(requirementString)){
            System.out.println("Can not find the Binded requirement " +requirementString + " in line:colunm " + requireLabel.getSymbol().getLine() + ":" + requireLabel.getSymbol().getCharPositionInLine());
            System.exit(1);
        }

        if (!this.coRecorder.contains(componentString)){
            System.out.println("Can not find the Binded component " +componentString+ " in line:colunm " + componentLabel.getSymbol().getLine() + ":" + componentLabel.getSymbol().getCharPositionInLine());
            System.exit(1);
        }
    }

}
