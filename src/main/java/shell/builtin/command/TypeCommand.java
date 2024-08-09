package shell.builtin.command;

import shell.builtin.Builtin;
import shell.util.SystemPath;

import java.nio.file.Path;
import java.util.Optional;

public class TypeCommand extends BuiltinCommand {
    public TypeCommand(String[] args) {
        super(args);
    }

    public void execute() {
        if (args.length < 1) {
            return;
        }

        String arg = args[0];

        try {
            Builtin.valueOf(arg.toUpperCase());
            System.out.printf("%s is a shell builtin%n", arg);
        } catch (IllegalArgumentException e) {
            Optional<Path> binaryPath = new SystemPath().findBinary(arg);

            if (binaryPath.isPresent()) {
                System.out.printf("%s is %s%n", arg, binaryPath.get());
                return;
            }

            System.out.printf("%s: not found%n", arg);
        }
    }
}
