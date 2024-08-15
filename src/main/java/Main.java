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
            System.out.println("$ ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            String[] tokens = input.split(" ");
            var command = tokens[0];

            Builtin builtin;
            try {
                builtin = Builtin.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException __) {
                try {
                    new SystemPath().executeBinary(command, Arrays.copyOfRange(tokens, 1, tokens.length));
                } catch (FileNotFoundException ignored) {
                    System.out.printf("%s: command not found%n", input);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                continue;
            }

            var factory = new CommandFactory(builtin);

            BuiltinCommand builtinCommand = factory.create(shell, Arrays.copyOfRange(tokens, 1, tokens.length));
            builtinCommand.execute();
        } while (true);
    }
}
