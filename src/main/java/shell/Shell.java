package shell;

import java.nio.file.Path;

public class Shell {
    private Path workingDirectory;

    public Shell(Path workingDirectory) {
        setWorkingDirectory(workingDirectory);
    }

    public Path getWorkingDirectory() {
        return workingDirectory.toAbsolutePath().normalize();
    }

    public void setWorkingDirectory(Path workingDirectory) {
        this.workingDirectory = workingDirectory.toAbsolutePath().normalize();
    }

    public void printStartLine() {
        System.out.printf("$ (%s): ", getWorkingDirectory());
    }
}
