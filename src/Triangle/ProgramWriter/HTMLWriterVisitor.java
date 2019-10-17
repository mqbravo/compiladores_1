package Triangle.ProgramWriter;

import Triangle.AbstractSyntaxTrees.*;

import java.io.FileWriter;
import java.io.IOException;

public class HTMLWriterVisitor implements Visitor {

    private FileWriter fileWriter;

    public HTMLWriterVisitor(FileWriter fileWriter){
        this.fileWriter = fileWriter;
    }

    ///////////////////////////////////////////////////////////////////////////////
    //
    // COMMANDS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitAssignCommand(AssignCommand ast, Object o) {
        ast.V.visit(this,null);
        writeToHTMLFile(":=");
        ast.E.visit(this,null);

        return null;
    }

    @Override
    public Object visitCallCommand(CallCommand ast, Object o){
        ast.I.visit(this, null);
        writeToHTMLFile("(");
        ast.APS.visit(this, null);
        writeToHTMLFile(")");

        return null;}

    @Override
    public Object visitEmptyCommand(EmptyCommand ast, Object o) {
        writeToHTMLFile("\n<b>skip</b> \n");
        return null;
    }

    @Override
    public Object visitIfCommand(IfCommand ast, Object o) {
        writeToHTMLFile("\n<b> if </b>");

        ast.E.visit(this,null);

        writeToHTMLFile("<br> <b>then</b>");

        writeToHTMLFile("<br>");
        ast.C1.visit(this,null);

        writeToHTMLFile("<br> <b>else</b>");

        writeToHTMLFile("<br>");
        ast.C2.visit(this,null);


        writeToHTMLFile("<br> <b> end </b>");
        return null;
    }

    @Override
    public Object visitLetCommand(LetCommand ast, Object o) {
        writeToHTMLFile("<p>\n <b> let </b> \n</p>");
        ast.D.visit(this,null);
        writeToHTMLFile("<p>\n <b> in </b> \n</p>");
        ast.C.visit(this, null);
        writeToHTMLFile("<p>\n <b> end </b> \n</p>");
        return null;
    }

    @Override
    public Object visitSequentialCommand(SequentialCommand ast, Object o) {
        writeToHTMLFile("<p>");
        ast.C1.visit(this,null);
        writeToHTMLFile(";");
        writeToHTMLFile("</p>");
        ast.C2.visit(this,null);
        return null;
    }

    @Override
    public Object visitWhileLoopCommand(LoopCommand ast, Object o) {
        writeToHTMLFile("<b> loop while </b>");
        ast.E.visit(this, null);
        writeToHTMLFile("<b> do </b>");

        writeToHTMLFile("<br>");
        ast.C.visit(this, null);

        writeToHTMLFile("<br> <b> repeat </b>");

        return null;
    }

    @Override
    public Object visitDoWhileLoopCommand(LoopCommand ast, Object o) {
        writeToHTMLFile("<b> loop do </b>");

        writeToHTMLFile("<br>");
        ast.C.visit(this, null);

        writeToHTMLFile("<br>");
        writeToHTMLFile("<b> while </b>");
        ast.E.visit(this, null);

        return null;
    }

    @Override
    public Object visitUntilLoopCommand(LoopCommand ast, Object o) {
        writeToHTMLFile("<b> loop until </b>");
        ast.E.visit(this, null);
        writeToHTMLFile("<b> do </b>");

        writeToHTMLFile("<br>");
        ast.C.visit(this, null);

        writeToHTMLFile("<br> <b> repeat </b>");

        return null;
    }

    @Override
    public Object visitDoUntilLoopCommand(LoopCommand ast, Object o) {
        writeToHTMLFile("<b> loop do </b>");

        writeToHTMLFile("<br>");
        ast.C.visit(this, null);

        writeToHTMLFile("<br>");
        writeToHTMLFile("<b> until </b>");
        ast.E.visit(this, null);

        return null;
    }

    @Override
    public Object visitForLoopCommand(ForLoopCommand ast, Object o) {
        writeToHTMLFile("<b> loop for </b>");
        ast.Identifier.visit(this, null);
        writeToHTMLFile("~");
        ast.IdenExpression.visit(this, null);
        writeToHTMLFile("<b> to </b>");
        ast.E.visit(this, null);
        writeToHTMLFile("<b> do </b>");

        writeToHTMLFile("<br>");
        ast.C.visit(this, null);

        writeToHTMLFile("<br>");
        writeToHTMLFile("<b> repeat </b>");

        return null;
    }

    ///////////////////////////////////////////////////////////////////////////////
    //
    // EXPRESSIONS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitArrayExpression(ArrayExpression ast, Object o) {
        writeToHTMLFile("[");
        ast.AA.visit(this, null);
        writeToHTMLFile("]");

        return null;
    }

    @Override
    public Object visitBinaryExpression(BinaryExpression ast, Object o) {
        ast.E1.visit(this, null);
        ast.O.visit(this, null);
        ast.E2.visit(this, null);
        return null;
    }

    @Override
    public Object visitCallExpression(CallExpression ast, Object o) {
        ast.I.visit(this, null);
        writeToHTMLFile("(");
        ast.APS.visit(this, null);
        writeToHTMLFile(")");

        return null;
    }

    @Override
    public Object visitCharacterExpression(CharacterExpression ast, Object o) {
        ast.CL.visit(this, null);
        return null;
    }

    @Override
    public Object visitEmptyExpression(EmptyExpression ast, Object o) {
        //TODO
        return null;
    }

    @Override
    public Object visitIfExpression(IfExpression ast, Object o) {
        writeToHTMLFile("\n<b> if </b>");

        ast.E1.visit(this,null);

        writeToHTMLFile("<br> <b>then</b>");

        writeToHTMLFile("<br>");
        ast.E2.visit(this,null);

        writeToHTMLFile("<br> <b>else</b>");

        writeToHTMLFile("<br>");
        ast.E3.visit(this,null);
        return null;
    }

    @Override
    public Object visitIntegerExpression(IntegerExpression ast, Object o) {
        ast.IL.visit(this, null);
        return null;
    }

    @Override
    public Object visitLetExpression(LetExpression ast, Object o) {
        writeToHTMLFile("<p>\n <b> let </b> \n</p>");
        ast.D.visit(this,null);
        writeToHTMLFile("<p>\n <b> in </b> \n</p>");
        ast.E.visit(this, null);
        writeToHTMLFile("<p>\n <b> end </b> \n</p>");

        return null;
    }

    @Override
    public Object visitRecordExpression(RecordExpression ast, Object o) {
        writeToHTMLFile("{");
        ast.RA.visit(this, null);
        writeToHTMLFile("}");

        return null;
    }

    @Override
    public Object visitUnaryExpression(UnaryExpression ast, Object o) {
        //TODO
        return null;
    }

    @Override
    public Object visitVnameExpression(VnameExpression ast, Object o) {
        ast.V.visit(this, null);
        return null;
    }


    ///////////////////////////////////////////////////////////////////////////////
    //
    // DECLARATIONS
    //
    ///////////////////////////////////////////////////////////////////////////////

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
        writeToHTMLFile("<p>\n<b> var </b>\n");
        ast.I.visit(this,null);
        writeToHTMLFile(" : ");
        ast.T.visit(this,null);
        writeToHTMLFile("</p>");
        return null;
    }

    ///////////////////////////////////////////////////////////////////////////////
    //
    // ARRAY AGGREGATES
    //
    ///////////////////////////////////////////////////////////////////////////////

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

    ///////////////////////////////////////////////////////////////////////////////
    //
    // PARAMETERS
    //
    ///////////////////////////////////////////////////////////////////////////////

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

    ///////////////////////////////////////////////////////////////////////////////
    //
    // TYPE-DENOTERS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object o) {
        writeToHTMLFile("<b> Array </b>");
        return null;
    }

    @Override
    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object o) {
        writeToHTMLFile("<b> Boolean </b>");

        return null;
    }

    @Override
    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object o) {
        writeToHTMLFile("<b> Char </b>");
        return null;
    }

    @Override
    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object o) {
        return null;
    }

    @Override
    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object o) {
        writeToHTMLFile("<b>");
        ast.I.visit(this,null);
        writeToHTMLFile("</b>");
        return null;
    }

    @Override
    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object o) {
        writeToHTMLFile("<b> Integer </b>");
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


    ///////////////////////////////////////////////////////////////////////////////
    //
    // LITERALS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitCharacterLiteral(CharacterLiteral ast, Object o) {

        return null;
    }

    @Override
    public Object visitIntegerLiteral(IntegerLiteral ast, Object o) {

        return null;
    }


    ///////////////////////////////////////////////////////////////////////////////
    //
    // VALUE-OR-VARIABLE NAMES
    //
    ///////////////////////////////////////////////////////////////////////////////

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


    ///////////////////////////////////////////////////////////////////////////////
    //
    // PROGRAMS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitProgram(Program ast, Object o) {
        writeToHTMLFile("<!DOCTYPE html>");
        writeToHTMLFile("\n");
        writeToHTMLFile("<html>");
        writeToHTMLFile("\n");

        ast.C.visit(this,null);

        writeToHTMLFile("</html>");
        return null;
    }

    ///////////////////////////////////////////////////////////////////////////////
    //
    // OTHER
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitIdentifier(Identifier ast, Object o) {
        writeToHTMLFile(ast.spelling);
        return null;
    }

    @Override
    public Object visitOperator(Operator ast, Object o) {
        return null;
    }


    private void writeToHTMLFile(String content){
        try {
            fileWriter.write(content);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}