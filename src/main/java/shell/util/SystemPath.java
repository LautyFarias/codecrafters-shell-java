package shell.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class SystemPath {
    private final String[] pathDirs;

    public SystemPath() {
        String pathEnv = System.getenv("PATH");
        pathDirs = pathEnv.split(":");
    }

    /**
     * Find the absolute path of the given binary name.
     *
     * @param binaryFilename A name of the binary to find.
     * @return A real absolute Path to the given binary.
     */
    public Optional<Path> findBinary(String binaryFilename) {
        for (String dir : pathDirs) {
            Path absPath = Path.of(dir, binaryFilename);

            if (Files.isRegularFile(absPath)) return Optional.of(absPath);
        }

        return Optional.empty();
    }
}
