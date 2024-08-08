package builtin.command;

public abstract class BuiltinCommand {
    protected final String[] args;

    protected BuiltinCommand(String[] args) {
        this.args = args;
    }

    public abstract void execute();
}
