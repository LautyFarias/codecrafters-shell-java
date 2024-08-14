package shell.builtin.command;

import shell.Shell;

import java.nio.file.Path;

public class CdCommand extends BuiltinCommand {
    private final Shell shell;

    protected CdCommand(Shell shell, String[] args) {
        super(args);
        this.shell = shell;
    }

    @Override
    public void execute() {
        shell.setWorkingDirectory(Path.of(args[0]).toAbsolutePath());
    }
}
