import java.util.Scanner;
import java.util.ArrayList;

public class Zack {
    public static void main(String[] args) {

        Storage storage = new Storage("./data/zack.txt");
        ArrayList<Task> tasks = storage.load();

        Scanner in = new Scanner(System.in);

        System.out.println("Howdy! I'm Zack");
        System.out.println("What can I do for you?");

        while (true) {
            String input = in.nextLine();

            try {
                if (input.equals("bye")) {
                    System.out.println("Aite ciao!");
                    break;
                } else if (input.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + "." + tasks.get(i));
                    }
                } else if (input.startsWith("mark")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index < 0 || index >= tasks.size()) {
                        throw new ZackException("Invalid task number for mark!");
                    }
                    tasks.get(index).markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + tasks.get(index));
                } else if (input.startsWith("unmark")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index < 0 || index >= tasks.size()) {
                        throw new ZackException("Invalid task number for unmark!");
                    }
                    tasks.get(index).unmark();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + tasks.get(index));
                } else if (input.startsWith("delete")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index < 0 || index >= tasks.size()) {
                        throw new ZackException("Invalid task number for delete!");
                    }
                    Task removed = tasks.remove(index);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println("  " + removed);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");

                } else {
                    if (input.startsWith("todo")) {
                        String desc = input.length() > 4 ? input.substring(4).trim() : ""; // get everything after "todo"
                        if (desc.isEmpty()) {
                            throw new ZackException("The description of a todo cannot be empty!");
                        }
                        tasks.add(new Todo(desc));
                        storage.save(tasks);
                    } else if (input.startsWith("deadline")) {
                        String rest = input.length() > 8 ? input.substring(8).trim() : "";
                        String[] parts = rest.split("/by", 2);
                        if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                            throw new ZackException("Deadline format: deadline DESCRIPTION /by TIME");
                        }
                        tasks.add(new Deadline(parts[0].trim(), parts[1].trim()));
                        storage.save(tasks);
                    } else if (input.startsWith("event")) {
                        String rest = input.length() > 5 ? input.substring(5).trim() : "";
                        String[] parts = rest.split("/from|/to");
                        if (parts.length < 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
                            throw new ZackException("Event format: event DESCRIPTION /from START /to END");
                        }
                        tasks.add(new Event(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                        storage.save(tasks);
                    } else {
                        throw new ZackException("I don't know what that means: " + input);
                    }

                    storage.save(tasks);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + tasks.get(tasks.size() - 1)); // will call toString()
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                }
            } catch (ZackException e) {
                System.out.println("____________________________________________________________");
                System.out.println(" OOPS!!! " + e.getMessage());
                System.out.println("____________________________________________________________");
            } catch (NumberFormatException e) {
                System.out.println("____________________________________________________________");
                System.out.println(" OOPS!!! Invalid number format!");
                System.out.println("____________________________________________________________");
            }
        }

    }
}
