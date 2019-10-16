/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Esteban
 */
public class ForLoopCommand extends LoopCommand{
    
    
    /**
   * This creates a new LoopCommand AST
   * @param identifier The identifier for this loop's immutable identifier
   * @param idenExpression The expression from which the identifier will be made of
   * @param eAST It's control expression
   * @param cAST It's command
   * @param thePosition Where it can be found in the source
   */
  public ForLoopCommand (Identifier identifier, Expression idenExpression, Expression eAST, Command cAST, SourcePosition thePosition) {
    super (eAST, cAST, thePosition);
    Identifier = identifier;
    IdenExpression = idenExpression;
  }

  @Override
  public Object visit(Visitor v, Object o) {
    return v.visitForLoopCommand(this, o);
  }

  public Identifier Identifier;
  public Expression IdenExpression;
}
