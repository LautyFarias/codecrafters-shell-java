package builtin.command;

public class EchoCommand {
    private final String[] args;

    public EchoCommand(String[] args) {
        this.args = args;
    }

    public void execute() {
        if (args.length < 1) {
            return;
        }

        var text = String.join(" ", args);
        System.out.println(text);
    }
}
