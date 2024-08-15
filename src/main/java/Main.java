import shell.Shell;
import shell.builtin.Builtin;
import shell.builtin.command.*;
import shell.util.SystemPath;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        final Shell shell = new Shell(Paths.get(""));

        do {
            shell.printStartLine();

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            String[] tokens = input.split(" ");
            var command = tokens[0];

            try {
                var builtin = Builtin.valueOf(command.toUpperCase());
                var factory = new CommandFactory(builtin);

                var builtinCommand = factory.create(shell, Arrays.copyOfRange(tokens, 1, tokens.length));
                builtinCommand.execute();
            } catch (IllegalArgumentException __) {
                try {
                    new SystemPath().executeBinary(command, Arrays.copyOfRange(tokens, 1, tokens.length));
                } catch (FileNotFoundException ignored) {
                    System.out.printf("%s: command not found%n", input);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (true);
    }
}
