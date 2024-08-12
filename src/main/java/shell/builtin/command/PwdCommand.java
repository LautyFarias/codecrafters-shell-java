package shell.builtin.command;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PwdCommand extends BuiltinCommand {
    protected PwdCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute() {
        Path currentDir = Paths.get("");

        System.out.println(currentDir.toAbsolutePath());
    }
}
