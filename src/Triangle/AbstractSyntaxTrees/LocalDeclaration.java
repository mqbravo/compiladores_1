package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LocalDeclaration extends Declaration{
    public Declaration dAST1;
    public Declaration dAST2;

    public LocalDeclaration(Declaration dAST1, Declaration dAST2, SourcePosition thePosition){
        super(thePosition);
        this.dAST1 = dAST1;
        this.dAST2 = dAST2;
    }
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitLocalDeclaration(this, o);
    }
}
