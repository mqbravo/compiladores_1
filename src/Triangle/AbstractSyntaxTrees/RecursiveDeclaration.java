package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RecursiveDeclaration extends Declaration{
    public Declaration procFuncAST;
    public RecursiveDeclaration(Declaration procFuncAST, SourcePosition thePosition) {
        super (thePosition);
        this.procFuncAST = procFuncAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRecursiveDeclaration(this, o);
    }
}
