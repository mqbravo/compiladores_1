/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.SyntacticAnalyzer;

import junit.framework.TestCase;

/**
 *
 * @author Esteban
 */
public class TokenTest extends TestCase {
    
    public TokenTest(String testName) {
        super(testName);
    }
    
    public void testTokens(){
        //Los tokens nuevos: and, for, init, local, loop, recursive, repeat, skip, to, until
        assertEquals(Token.AND, new Token(Token.IDENTIFIER, "and", new SourcePosition()).kind);
        assertEquals(Token.FOR, new Token(Token.IDENTIFIER, "for", new SourcePosition()).kind);
        assertEquals(Token.INIT, new Token(Token.IDENTIFIER, "init", new SourcePosition()).kind);
        assertEquals(Token.LOCAL, new Token(Token.IDENTIFIER, "local", new SourcePosition()).kind);
        assertEquals(Token.LOOP, new Token(Token.IDENTIFIER, "loop", new SourcePosition()).kind);
        assertEquals(Token.RECURSIVE, new Token(Token.IDENTIFIER, "recursive", new SourcePosition()).kind);
        assertEquals(Token.REPEAT, new Token(Token.IDENTIFIER, "repeat", new SourcePosition()).kind);
        assertEquals(Token.SKIP, new Token(Token.IDENTIFIER, "skip", new SourcePosition()).kind);
        assertEquals(Token.TO, new Token(Token.IDENTIFIER, "to", new SourcePosition()).kind);
        assertEquals(Token.UNTIL, new Token(Token.IDENTIFIER, "until", new SourcePosition()).kind);
        
        //Eliminamos el token de begin
        assertEquals(Token.IDENTIFIER, new Token(Token.IDENTIFIER, "begin", new SourcePosition()).kind);
    }
}
