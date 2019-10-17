package Triangle.ProgramWriter;

import Triangle.AbstractSyntaxTrees.Program;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLWriter {

    private Program programAST;

    public HTMLWriter(Program programAST) {
        this.programAST = programAST;
    }

    public void writeSourceProgram(){

        //Create the output dir in case of needed
        File dir = new File("output/");
        dir.mkdirs();

        //The HTML file to write into
        File htmlFile = new File(dir, "source_program.html");

        //Helper file writer class
        try (FileWriter fileWriter = new FileWriter(htmlFile)) {
            //The HTML visitor writes to file with the fileWriter
            HTMLWriterVisitor htmlVisitor = new HTMLWriterVisitor(fileWriter);
            programAST.visit(htmlVisitor, null);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
