package builtin;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class TypeBuiltin {
    private final String[] args;

    public TypeBuiltin(String[] args) {
        this.args = args;
    }

    /**
     * Find the absolute path of the given binary name.
     *
     * @param binary A name of the binary to find.
     * @return A real absolute Path to the given binary.
     */
    private Optional<Path> findBinaryAbsPath(String binary) {
        String pathEnv = System.getenv("PATH");

        for (String path : pathEnv.split(":")) {
            Path absPath = Paths.get(path).resolve(binary);

            try {
                return Optional.of(absPath.toRealPath());
            } catch (IOException | DirectoryIteratorException ignored) {
            }
        }

        return Optional.empty();
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
            Optional<Path> binaryPath = findBinaryAbsPath(arg);

            if (binaryPath.isPresent()) {
                System.out.printf("%s is %s%n", arg, binaryPath.get());
                return;
            }

            System.out.printf("%s: not found%n", arg);
        }
    }
}
