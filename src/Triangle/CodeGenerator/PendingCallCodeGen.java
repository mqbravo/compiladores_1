package Triangle.CodeGenerator;

import Triangle.AbstractSyntaxTrees.Identifier;

public class PendingCallCodeGen {
    private Frame frame;
    private Identifier identifier;
    private int instrAddress;

    public PendingCallCodeGen(Frame frame, Identifier identifier, int instrAddress) {
        this.frame = frame;
        this.identifier = identifier;
        this.instrAddress = instrAddress;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public int getInstrAddress() {
        return instrAddress;
    }

    public void setInstrAddress(int instrAddress) {
        this.instrAddress = instrAddress;
    }
}
