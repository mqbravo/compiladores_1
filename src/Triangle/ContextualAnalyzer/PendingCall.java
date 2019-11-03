package Triangle.ContextualAnalyzer;

import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.AbstractSyntaxTrees.Visitor;

public abstract class PendingCall {
    private IdentificationTable callContextIdTable;

    public PendingCall(IdentificationTable callContextIdTable) {
        setCallContextIdTable(callContextIdTable);
    }

    public abstract void visitPendingCall(Visitor v, Object o);

    public abstract Identifier getProcFuncIdentifier();

    public IdentificationTable getCallContextIdTable() {
        return callContextIdTable;
    }

    public void setCallContextIdTable(IdentificationTable callContextIdTable) {
        this.callContextIdTable = callContextIdTable;
    }
}
