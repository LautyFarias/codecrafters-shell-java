import builtin.command.TypeCommand;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        do {
            System.out.print("$ ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "exit":
                    if (tokens.length > 1) {
                        int exitCode = Integer.parseInt(tokens[1]);
                        System.exit(exitCode);
                    }

                    System.exit(0);
                    break;
                case "echo":
                    if (tokens.length > 1) {
                        System.out.println(String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length)));
                    }
                    break;
                case "type":
                    var type = new TypeCommand(Arrays.copyOfRange(tokens, 1, tokens.length));
                    type.execute();
                    break;
                default:
                    System.out.printf("%s: command not found%n", input);
            }
        } while (true);
    }
}
