package shell;

import java.nio.file.Path;

public class Shell {
    private Path workingDirectory;

    public Shell(Path workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    public Path getWorkingDirectory() {
        return workingDirectory;
    }

    public void setWorkingDirectory(Path workingDirectory) {
    }

    public void printStartLine() {
        System.out.printf("$ (%s): ", getWorkingDirectory());
    }
}
