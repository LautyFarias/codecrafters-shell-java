import builtin.Builtin;
import builtin.command.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        do {
            System.out.print("$ ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            String[] tokens = input.split(" ");

            try {
                var builtin = Builtin.valueOf(tokens[0].toUpperCase());
                var factory = new CommandFactory(builtin);

                var builtinCommand = factory.create(Arrays.copyOfRange(tokens, 1, tokens.length));
                builtinCommand.execute();
            } catch (IllegalArgumentException e) {
                System.out.printf("%s: command not found%n", input);
            }
        } while (true);
    }
}
