package Triangle.ContextualAnalyzer;

import Triangle.AbstractSyntaxTrees.Expression;
import Triangle.AbstractSyntaxTrees.TypeDenoter;

public class FutureCallExpression {
    private TypeDenoter typeDenoterToCheck;
    private Expression E;

    public FutureCallExpression(TypeDenoter typeDenoterToCheck, Expression e) {
        this.typeDenoterToCheck = typeDenoterToCheck;
        E = e;
    }

    public TypeDenoter getTypeDenoterToCheck() {
        return typeDenoterToCheck;
    }

    public void setTypeDenoterToCheck(TypeDenoter typeDenoterToCheck) {
        this.typeDenoterToCheck = typeDenoterToCheck;
    }

    public Expression getE() {
        return E;
    }

    public void setE(Expression e) {
        E = e;
    }
}
