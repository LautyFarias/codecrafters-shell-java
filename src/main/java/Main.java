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

            switch (tokens[0]) {
                case "exit":
                    var exit = new ExitCommand(Arrays.copyOfRange(tokens, 1, tokens.length));
                    exit.execute();
                case "echo":
                    var echo = new EchoCommand(Arrays.copyOfRange(tokens, 1, tokens.length));
                    echo.execute();
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
