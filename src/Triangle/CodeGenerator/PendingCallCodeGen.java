package Triangle.CodeGenerator;

import Triangle.AbstractSyntaxTrees.Identifier;

public class PendingCallCodeGen {
    private Identifier identifier;
    private int frameLevel;
    private int instrAddress;

    public PendingCallCodeGen(Identifier identifier, int frameLevel, int instrAddress) {
        this.identifier = identifier;
        this.frameLevel = frameLevel;
        this.instrAddress = instrAddress;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public int getFrameLevel() {
        return frameLevel;
    }

    public void setFrameLevel(int frameLevel) {
        this.frameLevel = frameLevel;
    }

    public int getInstrAddress() {
        return instrAddress;
    }

    public void setInstrAddress(int instrAddress) {
        this.instrAddress = instrAddress;
    }
}
