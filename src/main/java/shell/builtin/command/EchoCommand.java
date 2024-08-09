package shell.builtin.command;

public class EchoCommand extends BuiltinCommand {
    public EchoCommand(String[] args) {
        super(args);
    }

    public void execute() {
        if (args.length < 1) {
            return;
        }

        var text = String.join(" ", args);
        System.out.println(text);
    }
}
