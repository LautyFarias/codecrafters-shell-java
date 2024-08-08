package builtin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class TypeBuiltin {
    private final String[] args;

    public TypeBuiltin(String[] args) {
        this.args = args;
    }

    /**
     * Find the absolute path of the given binary name.
     *
     * @param binaryFilename A name of the binary to find.
     * @return A real absolute Path to the given binary.
     */
    private Optional<Path> findBinaryAbsPath(String binaryFilename) {
        String pathEnv = System.getenv("PATH");

        for (String dirPath : pathEnv.split(":")) {
            Path absPath = Path.of(dirPath, binaryFilename);

            if (Files.isRegularFile(absPath)) return Optional.of(absPath);
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
