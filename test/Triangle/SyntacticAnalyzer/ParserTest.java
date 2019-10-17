/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.SyntacticAnalyzer;

import Triangle.ErrorReporter;
import java.nio.file.Path;
import java.nio.file.Paths;
import junit.framework.TestCase;

/**
 *
 * @author Esteban
 */
public class ParserTest extends TestCase {
    
    public ParserTest(String testName) {
        super(testName);
    }
    
    public void testFullProgram() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        ErrorReporter errorReporter = new ErrorReporter();
        Parser parser = new Parser(new Scanner(new SourceFile(s.concat("\\test\\Triangle\\SyntacticAnalyzer\\testProgram.tri"))), errorReporter);
        parser.parseProgram();
        assertEquals(0, errorReporter.getNumErrors());
    }
    
    public void testIfProgram() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        ErrorReporter errorReporter = new ErrorReporter();
        Parser parser = new Parser(new Scanner(new SourceFile(s.concat("\\test\\Triangle\\SyntacticAnalyzer\\testIf.tri"))), errorReporter);
        parser.parseProgram();
        assertEquals(0, errorReporter.getNumErrors());
    }
    
    public void testWhileProgram() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        ErrorReporter errorReporter = new ErrorReporter();
        Parser parser = new Parser(new Scanner(new SourceFile(s.concat("\\test\\Triangle\\SyntacticAnalyzer\\testWhileLoop.tri"))), errorReporter);
        parser.parseProgram();
        assertEquals(0, errorReporter.getNumErrors());
        
        currentRelativePath = Paths.get("");
        s = currentRelativePath.toAbsolutePath().toString();
        errorReporter = new ErrorReporter();
        parser = new Parser(new Scanner(new SourceFile(s.concat("\\test\\Triangle\\SyntacticAnalyzer\\testWhileLoop2.tri"))), errorReporter);
        parser.parseProgram();
        assertEquals(0, errorReporter.getNumErrors());
    }
    
    public void testUntilProgram() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        ErrorReporter errorReporter = new ErrorReporter();
        Parser parser = new Parser(new Scanner(new SourceFile(s.concat("\\test\\Triangle\\SyntacticAnalyzer\\testUntilLoop.tri"))), errorReporter);
        parser.parseProgram();
        assertEquals(0, errorReporter.getNumErrors());
        
        currentRelativePath = Paths.get("");
        s = currentRelativePath.toAbsolutePath().toString();
        errorReporter = new ErrorReporter();
        parser = new Parser(new Scanner(new SourceFile(s.concat("\\test\\Triangle\\SyntacticAnalyzer\\testUntilLoop2.tri"))), errorReporter);
        parser.parseProgram();
        assertEquals(0, errorReporter.getNumErrors());
    }
    
    public void testForLoopProgram() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        ErrorReporter errorReporter = new ErrorReporter();
        Parser parser = new Parser(new Scanner(new SourceFile(s.concat("\\test\\Triangle\\SyntacticAnalyzer\\testForLoop.tri"))), errorReporter);
        parser.parseProgram();
        assertEquals(0, errorReporter.getNumErrors());
    }
    
    public void testSkip() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        ErrorReporter errorReporter = new ErrorReporter();
        Parser parser = new Parser(new Scanner(new SourceFile(s.concat("\\test\\Triangle\\SyntacticAnalyzer\\testSkip.tri"))), errorReporter);
        parser.parseProgram();
        assertEquals(0, errorReporter.getNumErrors());
    }
    
    public void testBadPrograms(){
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        ErrorReporter errorReporter = new ErrorReporter();
        Parser parser = new Parser(new Scanner(new SourceFile(s.concat("\\test\\Triangle\\SyntacticAnalyzer\\testBegin.tri"))), errorReporter);
        parser.parseProgram();
        assertTrue(errorReporter.getNumErrors() > 0);
        
        currentRelativePath = Paths.get("");
        s = currentRelativePath.toAbsolutePath().toString();
        errorReporter = new ErrorReporter();
        parser = new Parser(new Scanner(new SourceFile(s.concat("\\test\\Triangle\\SyntacticAnalyzer\\testEmpty.tri"))), errorReporter);
        parser.parseProgram();
        assertTrue(errorReporter.getNumErrors() > 0);
    }
}
