package shell.builtin.command;

import shell.Shell;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class CdCommand extends BuiltinCommand {
    private final Shell shell;

    protected CdCommand(Shell shell, String[] args) {
        super(args);
        this.shell = shell;
    }

    @Override
    public void execute() {
        String arg;

        if (args.length == 0) {
            arg = "~";
        } else {
            arg = args[0];
        }

        if (Objects.equals(arg, "~")) {
            shell.setWorkingDirectory(Path.of(System.getenv("HOME")));
            return;
        }

        Path path = shell.getWorkingDirectory().resolve(Path.of(arg));

        if (!Files.exists(path)) {
            System.out.printf("cd: %s: No such file or directory%n", arg);
            return;
        }

        shell.setWorkingDirectory(path);
    }
}
