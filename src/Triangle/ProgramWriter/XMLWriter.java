package Triangle.ProgramWriter;

import Triangle.AbstractSyntaxTrees.Program;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLWriter{

    private Program programAST;

    public XMLWriter(Program programAST) {
        this.programAST = programAST;
    }

    public void writeProgramAST(String sourceName) {

        //Create the output dir in case of needed
        File dir = new File("output" + File.separator);
        dir.mkdirs();

        //The XML file to write into
        //File htmlFile = new File(dir, "source_program.html");
        File xmlFile = new File(dir, sourceName.concat(".xml"));

        //Helper file writer class
        try (FileWriter fileWriter = new FileWriter(xmlFile)) {
            //The XML visitor writes to file with the fileWriter
            XMLWriterVisitor xmlVisitor = new XMLWriterVisitor(fileWriter);
            programAST.visit(xmlVisitor, null);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
