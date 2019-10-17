package Triangle.ProgramWriter;

import Triangle.AbstractSyntaxTrees.*;

import java.io.FileWriter;
import java.io.IOException;

public class XMLWriterVisitor implements Visitor {

    private final FileWriter fileWriter;

    public XMLWriterVisitor(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Commands ">
    ///////////////////////////////////////////////////////////////////////////////
    //
    // COMMANDS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitAssignCommand(AssignCommand ast, Object o) {
      writeToXMLFile("<Assign Command>\n");
        ast.V.visit(this, null);
        ast.E.visit(this, null);
      writeToXMLFile("</Assign Command>\n");
      return null;
    }

    @Override
    public Object visitCallCommand(CallCommand ast, Object o) {
      writeToXMLFile("<Call Command>\n");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
      writeToXMLFile("</Call Command>\n");
      return null;
    }

    @Override
    public Object visitEmptyCommand(EmptyCommand ast, Object o) {
      writeToXMLFile("<Empty Command/>\n");      
      return null;
    }

    @Override
    public Object visitIfCommand(IfCommand ast, Object o) {
      writeToXMLFile("<If Command>\n");
        ast.E.visit(this, null);
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);
      writeToXMLFile("</If Command>\n");
      return null;
    }

    @Override
    public Object visitLetCommand(LetCommand ast, Object o) {
      writeToXMLFile("<Let Command>\n");
        writeToXMLFile("<Declarations>\n");
          ast.D.visit(this, null);
        writeToXMLFile("</Declarations>\n");
        writeToXMLFile("<Command>\n");
          ast.C.visit(this, null);
        writeToXMLFile("</Command>\n");
      writeToXMLFile("</Let Command>\n");
      return null;
    }

    @Override
    public Object visitSequentialCommand(SequentialCommand ast, Object o) {
      writeToXMLFile("<Sequential Command>\n");
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);
      writeToXMLFile("</Sequential Command>\n");
        return null;
    }

    @Override
    public Object visitWhileLoopCommand(LoopCommand ast, Object o) {
      writeToXMLFile("<While Loop Command>\n");
        ast.E.visit(this, null);
        ast.C.visit(this, null);
      writeToXMLFile("</While Loop Command>\n");
        return null;
    }

    @Override
    public Object visitDoWhileLoopCommand(LoopCommand ast, Object o) {
      writeToXMLFile("<Do-While Loop Command>\n");
        ast.E.visit(this, null);
        ast.C.visit(this, null);
      writeToXMLFile("</Do-While Loop Command>\n");
      return null;
    }

    @Override
    public Object visitUntilLoopCommand(LoopCommand ast, Object o) {
      writeToXMLFile("<Until Loop Command>\n");
        ast.E.visit(this, null);
        ast.C.visit(this, null);
      writeToXMLFile("</Until Loop Command>\n");
      return null;
    }

    @Override
    public Object visitDoUntilLoopCommand(LoopCommand ast, Object o) {
      writeToXMLFile("<Do-Until Loop Command>\n");
        ast.E.visit(this, null);
        ast.C.visit(this, null);
      writeToXMLFile("</Do-Until Loop Command>\n");
      return null;
    }

    @Override
    public Object visitForLoopCommand(ForLoopCommand ast, Object o) {
      writeToXMLFile("<For Loop Command>\n");
        ast.Identifier.visit(this, null);
        ast.IdenExpression.visit(this, null);
        ast.E.visit(this, null);
        ast.C.visit(this, null);
      writeToXMLFile("</For Loop Command>\n");
      return null;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Expressions ">
    ///////////////////////////////////////////////////////////////////////////////
    //
    // EXPRESSIONS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitArrayExpression(ArrayExpression ast, Object o) {
      writeToXMLFile("<Array Expression>\n");
        ast.AA.visit(this, null);
        ast.type.visit(this, null);
      writeToXMLFile("</Array Expression>\n");
      return null;
    }

    @Override
    public Object visitBinaryExpression(BinaryExpression ast, Object o) {
      writeToXMLFile("<Binary Expression>\n");
        ast.E1.visit(this, null);
        ast.O.visit(this, null);
        ast.E2.visit(this, null);        
      writeToXMLFile("</Binary Expression>\n");
      return null;
    }

    @Override
    public Object visitCallExpression(CallExpression ast, Object o) {
      writeToXMLFile("<Call Expression>\n");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
      writeToXMLFile("</Call Expression>\n");
      return null;
    }

    @Override
    public Object visitCharacterExpression(CharacterExpression ast, Object o) {
      writeToXMLFile("<Character Expression>\n");
        ast.CL.visit(this, null);
      writeToXMLFile("</Character Expression>\n");
      return null;
    }

    @Override
    public Object visitEmptyExpression(EmptyExpression ast, Object o) {
      writeToXMLFile("<Empty Expression/>\n");
      return null;
    }

    @Override
    public Object visitIfExpression(IfExpression ast, Object o) {
      writeToXMLFile("<If Expression>\n");
        ast.E1.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);
      writeToXMLFile("</If Expression>\n");
      return null;
    }

    @Override
    public Object visitIntegerExpression(IntegerExpression ast, Object o) {
      writeToXMLFile("<Integer Expression>\n");
        ast.IL.visit(this, null);
      writeToXMLFile("</Integer Expression>\n");
      return null;
    }

    @Override
    public Object visitLetExpression(LetExpression ast, Object o) {
      writeToXMLFile("<Let Expression>\n");
        ast.D.visit(this, null);
        ast.E.visit(this, null);
      writeToXMLFile("</Let Expression>\n");
      return null;
    }

    @Override
    public Object visitRecordExpression(RecordExpression ast, Object o) {
      writeToXMLFile("<Record Expression>\n");
        ast.RA.visit(this, null);
      writeToXMLFile("</Record Expression>\n");
      return null;
    }

    @Override
    public Object visitUnaryExpression(UnaryExpression ast, Object o) {
      writeToXMLFile("<Unary Expression>\n");
        ast.O.visit(this, null);
        ast.E.visit(this, null);
      writeToXMLFile("</Unary Expression>\n");
      return null;
    }

    @Override
    public Object visitVnameExpression(VnameExpression ast, Object o) {
      writeToXMLFile("<Vname Expression>\n");
        ast.V.visit(this, null);
      writeToXMLFile("</Vname Expression>\n");
      return null;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Declarations ">
    ///////////////////////////////////////////////////////////////////////////////
    //
    // DECLARATIONS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object o) {
      writeToXMLFile("Binary Operator Declaration>\n");
        ast.ARG1.visit(this, null);
        ast.ARG2.visit(this, null);
        ast.O.visit(this, null);
        ast.RES.visit(this, null);
      writeToXMLFile("</Binary Operator Declaration>\n");
      return null;
    }

    @Override
    public Object visitConstDeclaration(ConstDeclaration ast, Object o) {
      writeToXMLFile("<Const Declaration>\n");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
      writeToXMLFile("</Const Declaration>\n");
      return null;
    }

    @Override
    public Object visitFuncDeclaration(FuncDeclaration ast, Object o) {
      writeToXMLFile("<Func Declaration>\n");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);
        ast.E.visit(this, null);
      writeToXMLFile("</Func Declaration>\n");
      return null;
    }

    @Override
    public Object visitProcDeclaration(ProcDeclaration ast, Object o) {
      writeToXMLFile("<Proc Declaration>\n");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.C.visit(this, null);
      writeToXMLFile("</Proc Declaration>\n");
      return null;
    }

    @Override
    public Object visitSequentialDeclaration(SequentialDeclaration ast, Object o) {
      writeToXMLFile("<Sequential Declaration>\n");
        ast.D1.visit(this, null);
        ast.D2.visit(this, null);
      writeToXMLFile("</Sequential Declaration>\n");
      return null;
    }

    @Override
    public Object visitTypeDeclaration(TypeDeclaration ast, Object o) {
      writeToXMLFile("<Type Declaration>\n");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
      writeToXMLFile("</Type Declaration>\n");
      return null;
    }

    @Override
    public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object o) {
      writeToXMLFile("<Unary Operator Declaration>\n");
        ast.ARG.visit(this, null);
        ast.O.visit(this, null);
        ast.RES.visit(this, null);
      writeToXMLFile("</Unary Operator Declaration>\n");
      return null;
    }

    @Override
    public Object visitVarDeclaration(VarDeclaration ast, Object o) {
      writeToXMLFile("<Var Declaration>\n");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
      writeToXMLFile("</Var Declaration>\n");
      return null;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Aggregates ">
    ///////////////////////////////////////////////////////////////////////////////
    //
    // ARRAY AGGREGATES
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object o) {
      writeToXMLFile("<Multiple Array Aggregate>\n");
        ast.E.visit(this, null);
        ast.AA.visit(this, null);
      writeToXMLFile("</Multiple Array Aggregate>\n");
      return null;
    }

    @Override
    public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object o) {
      writeToXMLFile("<Single Array Aggregate>\n");
        ast.E.visit(this, null);
      writeToXMLFile("</Single Array Aggregate>\n");
      return null;
    }

    @Override
    public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object o) {
      writeToXMLFile("<Multiple Record Aggregate>\n");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        ast.RA.visit(this, null);
      writeToXMLFile("</Multiple Record Aggregate>\n");
      return null;
    }

    @Override
    public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object o) {
      writeToXMLFile("<Single Record Aggregate>\n");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
      writeToXMLFile("</Single Record Aggregate\n>");
      return null;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Parameters ">
    ///////////////////////////////////////////////////////////////////////////////
    //
    // PARAMETERS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitConstFormalParameter(ConstFormalParameter ast, Object o) {
      writeToXMLFile("<Const Formal Parameters>/n");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
      writeToXMLFile("</Const Formal Parameters>/n");
      return null;
    }

    @Override
    public Object visitFuncFormalParameter(FuncFormalParameter ast, Object o) {
      writeToXMLFile("<Func Formal Parameter>\n");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);
      writeToXMLFile("</Func Formal Parameter>\n");
      return null;
    }

    @Override
    public Object visitProcFormalParameter(ProcFormalParameter ast, Object o) {
      writeToXMLFile("<Proc Formal Parameter>\n");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
      writeToXMLFile("</Proc Formal Parameter>\n");
      return null;
    }

    @Override
    public Object visitVarFormalParameter(VarFormalParameter ast, Object o) {
      writeToXMLFile("<Var Formal Parameter>\n");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
      writeToXMLFile("</Var Formal Parameter>\n");
      return null;
    }

    @Override
    public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object o) {
      writeToXMLFile("<Empty Formal Parameter Sequence/>\n");
      return null;
    }

    @Override
    public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object o) {
      writeToXMLFile("<Multiple Formal Parameter Sequence>\n");
        ast.FP.visit(this, null);
        ast.FPS.visit(this, null);
      writeToXMLFile("</Multiple Formal Parameter Sequence>\n");
      return null;
    }

    @Override
    public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object o) {
      writeToXMLFile("<Single Formal Parameter Sequence>\n");
        ast.FP.visit(this, null);
      writeToXMLFile("</Single Formal Parameter Sequence>\n");
      return null;
    }

    @Override
    public Object visitConstActualParameter(ConstActualParameter ast, Object o) {
      writeToXMLFile("<Constant Actual Parameter>\n");
        ast.E.visit(this, null);
      writeToXMLFile("</Constant Actual Parameter>\n");
      return null;
    }

    @Override
    public Object visitFuncActualParameter(FuncActualParameter ast, Object o) {
      writeToXMLFile("<Func Actual Parameter>\n");
        ast.I.visit(this, null);
      writeToXMLFile("</Func Actual Parameter>\n");
      return null;
    }

    @Override
    public Object visitProcActualParameter(ProcActualParameter ast, Object o) {
      writeToXMLFile("<Proc Actual Parameter>\n");
        ast.I.visit(this, null);
      writeToXMLFile("</Proc Actual Parameter>\n");
      return null;
    }

    @Override
    public Object visitVarActualParameter(VarActualParameter ast, Object o) {
      writeToXMLFile("<Var Actual Parameter>\n");
        ast.V.visit(this, null);
      writeToXMLFile("</Var Actual Parameter>\n");
      return null;
    }

    @Override
    public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object o) {
      writeToXMLFile("<Empty Actual Parameter Sequence/>\n");
      return null;
    }

    @Override
    public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object o) {
      writeToXMLFile("<Multiple Actual Parameter Sequence>\n");
        ast.AP.visit(this, null);
        ast.APS.visit(this, null);
      writeToXMLFile("</Multiple Actual Parameter Sequence>\n");
      return null;
    }

    @Override
    public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object o) {
      writeToXMLFile("<Single Actual Parameter Sequence>\n");
        ast.AP.visit(this, null);
      writeToXMLFile("</Single Actual Parameter Sequence>\n");
      return null;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Type Denoters ">
    ///////////////////////////////////////////////////////////////////////////////
    //
    // TYPE-DENOTERS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object o) {
      writeToXMLFile("<Any Type Denoter/>\n");
      return null;
    }

    @Override
    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object o) {
      writeToXMLFile("<Array Type Denoter>\n");
        ast.IL.visit(this, null);
        ast.T.visit(this, null);
      writeToXMLFile("</Array Type Denoter>\n");
      return null;
    }

    @Override
    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object o) {
      writeToXMLFile("<Bool Type Denoter/>\n");
      return null;
    }

    @Override
    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object o) {
      writeToXMLFile("<Char Type Denoter/>\n");
      return null;
    }

    @Override
    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object o) {
      writeToXMLFile("<Error Type Denoter/>\n");
      return null;
    }

    @Override
    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object o) {
      writeToXMLFile("<Simple Type Denoter>\n");
        ast.I.visit(this, null);
      writeToXMLFile("</Simple Type Denoter/>\n");
      return null;
    }

    @Override
    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object o) {
      writeToXMLFile("<Int Type Denoter/>\n");
      return null;
    }

    @Override
    public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object o) {
      writeToXMLFile("<Record Type Denoter>\n");
        ast.FT.visit(this, null);
      writeToXMLFile("</Record Type Denoter>\n");
      return null;
    }

    @Override
    public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object o) {
      writeToXMLFile("<Multiple Field Type Denoter>\n");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        ast.FT.visit(this, null);
      writeToXMLFile("</Multiple Field Type Denoter>\n");
      return null;
    }

    @Override
    public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object o) {
      writeToXMLFile("<Single Field Type Denoter>\n");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
      writeToXMLFile("</Single Field Type Denoter>\n");
      return null;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Literals, Identifiers and Operators ">
    ///////////////////////////////////////////////////////////////////////////////
    //
    // LITERALS
    //
    ///////////////////////////////////////////////////////////////////////////////
    
    @Override
    public Object visitCharacterLiteral(CharacterLiteral ast, Object o) {
      writeToXMLFile("<Charater Literal>".concat(ast.spelling).concat("</Charater Literal>\n"));
      return null;
    }

    @Override
    public Object visitIdentifier(Identifier ast, Object o) {
      writeToXMLFile("<Identifier>".concat(ast.spelling).concat("</Identifier>\n"));
      return null;
    }
    
    @Override
    public Object visitIntegerLiteral(IntegerLiteral ast, Object o) {
      writeToXMLFile("<Integer Literal>".concat(ast.spelling).concat("</Integer Literal>\n"));
      return null;
    }

    @Override
    public Object visitOperator(Operator ast, Object o) {
      writeToXMLFile("<Operator>".concat(ast.spelling).concat("</Operator>\n"));
      return null;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Values or Variables Names ">
    ///////////////////////////////////////////////////////////////////////////////
    //
    // VALUE-OR-VARIABLE NAMES
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitDotVname(DotVname ast, Object o) {
      writeToXMLFile("<Dot Vname>\n");
        ast.I.visit(this, null);
        ast.V.visit(this, null);
      writeToXMLFile("</Dot Vname>\n");
      return null;
    }

    @Override
    public Object visitSimpleVname(SimpleVname ast, Object o) {
      writeToXMLFile("<Simple Vname>\n");
        ast.I.visit(this, null);
      writeToXMLFile("</Simple Vname>\n");
      return null;
    }

    @Override
    public Object visitSubscriptVname(SubscriptVname ast, Object o) {
      writeToXMLFile("<Subscript Vname>\n");
        ast.V.visit(this, null);
        ast.E.visit(this, null);
      writeToXMLFile("</Subscript Vname>\n");
      return null;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Programs ">
    ///////////////////////////////////////////////////////////////////////////////
    //
    // PROGRAMS
    //
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public Object visitProgram(Program ast, Object o) {
      writeToXMLFile("<Program>\n");
        ast.C.visit(this, null);
      writeToXMLFile("</Program>\n");
      return null;
    }

    // </editor-fold>

    private void writeToXMLFile(String content){
        try {
            fileWriter.write(content);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
