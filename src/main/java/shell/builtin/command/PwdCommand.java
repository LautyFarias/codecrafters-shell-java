package shell.builtin.command;

import shell.Shell;

public class PwdCommand extends BuiltinCommand {
    private final Shell shell;

    protected PwdCommand(Shell shell, String[] args) {
        super(args);
        this.shell = shell;
    }

    @Override
    public void execute() {
        System.out.println(shell.getWorkingDirectory());
    }
}
