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
public class WhileLoopCommand extends LoopCommand{
    
    public WhileLoopCommand(Expression eAST, Command cAST, SourcePosition thePosition) {
        super(eAST, cAST, thePosition);
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitWhileLoopCommand(this, o);
    }
}
