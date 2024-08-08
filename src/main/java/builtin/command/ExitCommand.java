package builtin.command;

public class ExitCommand extends BuiltinCommand {
    public ExitCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute() {
        int exitCode = 0;

        if (args.length > 0) {
            exitCode = Integer.parseInt(args[1]);
        }

        System.exit(exitCode);
    }
}
