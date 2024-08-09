package shell.builtin.command;

import shell.builtin.Builtin;

public class CommandFactory {
    private final Builtin builtin;

    public CommandFactory(Builtin builtin) {
        this.builtin = builtin;
    }

    public BuiltinCommand create(String[] args) {
        BuiltinCommand command;

        switch (builtin) {
            case ECHO -> command = new EchoCommand(args);
            case TYPE -> command = new TypeCommand(args);
            case EXIT -> command = new ExitCommand(args);
            default -> throw new IllegalArgumentException("Unknown builtin: " + builtin);
        }

        return command;
    }
}
