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
                tasks.get(index).markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + tasks.get(index));
            } else if (input.startsWith("unmark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks.get(index).unmark();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + tasks.get(index));
            } else {
                if (input.startsWith("todo ")) {
                    tasks.add(new Todo(input.substring(5)));
                } else if (input.startsWith("deadline ")) {
                    String[] parts = input.substring(9).split("/by", 2);
                    tasks.add(new Deadline(parts[0].trim(), parts[1].trim()));
                } else if (input.startsWith("event ")) {
                    String[] parts = input.substring(6).split("/from|/to");
                    tasks.add(new Event(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                } else {
                    System.out.println("Unknown command");
                }
                storage.save(tasks);
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + tasks.get(tasks.size()-1));
                System.out.println("Now you have " + tasks.size() + " tasks in the list.");
            }
        }

    }
}
