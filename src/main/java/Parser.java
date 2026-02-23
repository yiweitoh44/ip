/**
 * Parser class for Zack application.
 * Parses user input into a command and its argument.
 */
public class Parser {

    /**
     * Parses the given user input string.
     * Returns a ParsedInput object containing the command and argument.
     *
     * @param input User input string.
     * @return ParsedInput object containing command and argument.
     * @throws ZackException If the command is unknown.
     */
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

/**
 * Data holder for a parsed command.
 * Stores the command word and its argument (if any).
 */
class ParsedInput {
    /** Command word. */
    public String command;

    /** Argument for the command. */
    public String argument;

    /**
     * Constructs a ParsedInput object.
     *
     * @param command Command word.
     * @param argument Argument string.
     */
    public ParsedInput(String command, String argument) {
        this.command = command;
        this.argument = argument;
    }
}