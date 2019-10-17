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

    public void writeProgramAST() throws IOException {

        //Create the output dir in case of needed
        File dir = new File("output/");
        if(!dir.mkdirs())
            return;

        //The XML file to write into
        File xmlFile = new File(dir, "program_ast.xml");

        //Helper file writer class
        FileWriter fileWriter = new FileWriter(xmlFile);

        //The XML visitor writes to file with the fileWriter
        XMLWriterVisitor xmlVisitor = new XMLWriterVisitor(fileWriter);
        programAST.visit(xmlVisitor, null);

        //Don't forget to close!
        fileWriter.close();
    }

}
