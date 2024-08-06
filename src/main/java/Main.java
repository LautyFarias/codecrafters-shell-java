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
                default:
                    System.out.printf("%s: command not found%n", input);
            }
        } while (true);
    }
}
