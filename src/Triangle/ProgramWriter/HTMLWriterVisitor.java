package Triangle.ProgramWriter;

import Triangle.AbstractSyntaxTrees.*;

import java.io.FileWriter;

public class HTMLWriterVisitor implements Visitor {

    private FileWriter fileWriter;

    public HTMLWriterVisitor(FileWriter fileWriter){
        this.fileWriter = fileWriter;
    }

    @Override
    public Object visitAssignCommand(AssignCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitCallCommand(CallCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitEmptyCommand(EmptyCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitIfCommand(IfCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitLetCommand(LetCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitSequentialCommand(SequentialCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitWhileLoopCommand(LoopCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitDoWhileLoopCommand(LoopCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitUntilLoopCommand(LoopCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitDoUntilLoopCommand(LoopCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitForLoopCommand(ForLoopCommand ast, Object o) {
        return null;
    }

    @Override
    public Object visitArrayExpression(ArrayExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitBinaryExpression(BinaryExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitCallExpression(CallExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitCharacterExpression(CharacterExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitEmptyExpression(EmptyExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitIfExpression(IfExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitIntegerExpression(IntegerExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitLetExpression(LetExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitRecordExpression(RecordExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitUnaryExpression(UnaryExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitVnameExpression(VnameExpression ast, Object o) {
        return null;
    }

    @Override
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object o) {
        return null;
    }

    @Override
    public Object visitConstDeclaration(ConstDeclaration ast, Object o) {
        return null;
    }

    @Override
    public Object visitFuncDeclaration(FuncDeclaration ast, Object o) {
        return null;
    }

    @Override
    public Object visitProcDeclaration(ProcDeclaration ast, Object o) {
        return null;
    }

    @Override
    public Object visitSequentialDeclaration(SequentialDeclaration ast, Object o) {
        return null;
    }

    @Override
    public Object visitTypeDeclaration(TypeDeclaration ast, Object o) {
        return null;
    }

    @Override
    public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object o) {
        return null;
    }

    @Override
    public Object visitVarDeclaration(VarDeclaration ast, Object o) {
        return null;
    }

    @Override
    public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object o) {
        return null;
    }

    @Override
    public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object o) {
        return null;
    }

    @Override
    public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object o) {
        return null;
    }

    @Override
    public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object o) {
        return null;
    }

    @Override
    public Object visitConstFormalParameter(ConstFormalParameter ast, Object o) {
        return null;
    }

    @Override
    public Object visitFuncFormalParameter(FuncFormalParameter ast, Object o) {
        return null;
    }

    @Override
    public Object visitProcFormalParameter(ProcFormalParameter ast, Object o) {
        return null;
    }

    @Override
    public Object visitVarFormalParameter(VarFormalParameter ast, Object o) {
        return null;
    }

    @Override
    public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object o) {
        return null;
    }

    @Override
    public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object o) {
        return null;
    }

    @Override
    public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object o) {
        return null;
    }

    @Override
    public Object visitConstActualParameter(ConstActualParameter ast, Object o) {
        return null;
    }

    @Override
    public Object visitFuncActualParameter(FuncActualParameter ast, Object o) {
        return null;
    }

    @Override
    public Object visitProcActualParameter(ProcActualParameter ast, Object o) {
        return null;
    }

    @Override
    public Object visitVarActualParameter(VarActualParameter ast, Object o) {
        return null;
    }

    @Override
    public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object o) {
        return null;
    }

    @Override
    public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object o) {
        return null;
    }

    @Override
    public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object o) {
        return null;
    }

    @Override
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitCharacterLiteral(CharacterLiteral ast, Object o) {
        return null;
    }

    @Override
    public Object visitIdentifier(Identifier ast, Object o) {
        return null;
    }

    @Override
    public Object visitIntegerLiteral(IntegerLiteral ast, Object o) {
        return null;
    }

    @Override
    public Object visitOperator(Operator ast, Object o) {
        return null;
    }

    @Override
    public Object visitDotVname(DotVname ast, Object o) {
        return null;
    }

    @Override
    public Object visitSimpleVname(SimpleVname ast, Object o) {
        return null;
    }

    @Override
    public Object visitSubscriptVname(SubscriptVname ast, Object o) {
        return null;
    }

    @Override
    public Object visitProgram(Program ast, Object o) {
        return null;
    }
}