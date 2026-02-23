public class Parser {

    public static ParsedInput parse(String input) throws ZackException {
        String[] words = input.split(" ", 2);
        String command = words[0];
        String argument = words.length > 1 ? words[1] : "";

        switch (command) {
        case "bye":
        case "list":
        case "mark":
        case "unmark":
        case "delete":
        case "todo":
        case "deadline":
        case "event":
        case "find":
            return new ParsedInput(command, argument);
        default:
            throw new ZackException("I don't know what that means: " + input);
        }
    }
}

// simple data holder
class ParsedInput {
    public String command;
    public String argument;

    public ParsedInput(String command, String argument) {
        this.command = command;
        this.argument = argument;
    }
}