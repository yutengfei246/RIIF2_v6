package it.polito.yutengfei.RIIF2.factory.partsFactory;

import it.polito.yutengfei.RIIF2.Declarator.AssertionDeclarator;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Assertion;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.factory.ComponentFactory;
import it.polito.yutengfei.RIIF2.factory.Exceptions.FieldTypeNotMarchException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.SomeVariableMissingException;
import it.polito.yutengfei.RIIF2.factory.Exceptions.VeriableAlreadyExistException;
import it.polito.yutengfei.RIIF2.factory.Factory;
import it.polito.yutengfei.RIIF2.id.Id;
import it.polito.yutengfei.RIIF2.recoder.RIIF2Recorder;
import it.polito.yutengfei.RIIF2.util.RIIF2Grammar;
import it.polito.yutengfei.RIIF2.util.utilityWrapper.Expression;

public class AssertionFactory implements Factory{


    private final RIIF2Recorder recorder;
    private final ComponentFactory componentFactory;

    private AssertionDeclarator declarator;

    private Label<Label> assertion;

    public AssertionFactory(ComponentFactory componentFactory, RIIF2Recorder recorder) {
        this.recorder = recorder;
        this.componentFactory = componentFactory;
    }

    @Override
    public void commit() throws SomeVariableMissingException, VeriableAlreadyExistException, FieldTypeNotMarchException {
        this.initializer();
        this.idLegit();
        this.createAssertion();
        this.expressionLegit();
    }

    private void initializer() {
        this.declarator = (AssertionDeclarator) this.componentFactory.getDeclarator();
    }

    private void expressionLegit() throws FieldTypeNotMarchException {
        Expression expression = this.declarator.getExpression();
        expression.setCurrentLabel(this.assertion);
        expression.setRecorder(this.recorder);

        if (!expression.getType().equals(RIIF2Grammar.INTEGER ) && !expression.getType().equals(RIIF2Grammar.DOUBLE))
            throw new FieldTypeNotMarchException(FieldTypeNotMarchException.MARCHED, expression.toString(),expression.getLine(),expression.getColumn());

        this.assertion.setValue(expression);
    }

    private void idLegit() throws FieldTypeNotMarchException, VeriableAlreadyExistException {

        Id assertId = this.declarator.getAttributeId();

        /*
        if (!assertId.getType().equals(RIIF2Grammar.ID_ATTRIBUTE))
            throw new FieldTypeNotMarchException(FieldTypeNotMarchException.NOT_MARCHED,assertId.toString(), assertId.getLine(), assertId.getColumn());

        */

        if (!assertId.getType().equals(RIIF2Grammar.ID_ATTRIBUTE) || !assertId.getAttributeIndex().getId().equals(RIIF2Grammar.RATE))
            throw new FieldTypeNotMarchException(FieldTypeNotMarchException.NOT_MARCHED,assertId.toString(), assertId.getLine(), assertId.getColumn());

        if (this.recorder.containsAssertion(assertId.getId()))
            throw new VeriableAlreadyExistException(assertId.getId(), assertId.getLine(), assertId.getColumn());
    }

    private void createAssertion() throws FieldTypeNotMarchException {
        this.assertion = new Assertion(this.recorder);

        String assertionName = this.declarator.getAttributeId().getId();
        this.assertion.setName(assertionName);

        String oper = this.declarator.getOper();

        ((Assertion)this.assertion).setOper(oper);

        this.assertion.setAttribute(true);
        PreDefinedAttribute.Assertion(this.assertion, this.declarator.getUnit(), this.recorder);

        this.recorder.addLabel(this.assertion);
        this.assertion = this.assertion.getAttribute(RIIF2Grammar.RATE);
    }
}
