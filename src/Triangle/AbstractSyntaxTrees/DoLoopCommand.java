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
public abstract class DoLoopCommand extends LoopCommand{
    
    public DoLoopCommand(Expression eAST, Command cAST, SourcePosition thePosition) {
        super(eAST, cAST, thePosition);
    }

    @Override
    public abstract Object visit(Visitor v, Object o);
}
