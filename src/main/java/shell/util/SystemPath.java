package shell.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public void executeBinary(String binaryFilename, String[] args) throws IOException, InterruptedException {
        Optional<Path> absBinaryPath = findBinary(binaryFilename);

        if (absBinaryPath.isEmpty()) throw new FileNotFoundException();

        var binary = absBinaryPath.get().toString();

        List<String> command = new ArrayList<>(List.of(binary));
        command.addAll(Arrays.asList(args));

        var pb = new ProcessBuilder(command);
        var process = pb.start();

        var reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        process.waitFor();
    }
}
