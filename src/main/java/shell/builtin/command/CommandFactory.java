package shell.builtin.command;

import shell.Shell;
import shell.builtin.Builtin;

public class CommandFactory {
    private final Builtin builtin;

    public CommandFactory(Builtin builtin) {
        this.builtin = builtin;
    }

    public BuiltinCommand create(Shell shell, String[] args) {
        BuiltinCommand command;

        switch (builtin) {
            case ECHO -> command = new EchoCommand(args);
            case TYPE -> command = new TypeCommand(args);
            case EXIT -> command = new ExitCommand(args);
            case PWD -> command = new PwdCommand(shell, args);
            case CD -> command = new CdCommand(shell, args);
            default -> throw new Error("Unknown builtin: " + builtin);
        }

        return command;
    }
}
