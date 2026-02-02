import java.util.Scanner;

public class Zack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Howdy! I'm Zack");
        System.out.println("What can I do for you?");

        Task[] tasks = new Task[100];
        int taskCount = 0;

        while (true) {
            String input = in.nextLine();

            if (input.equals("bye")) {
                System.out.println("Aite ciao!");
                break;
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println(
                            (i + 1) + "." +
                                    tasks[i]
                    );
                }
            } else if (input.startsWith("mark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + tasks[index]);
            } else if (input.startsWith("unmark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].unmark();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + tasks[index]);
            } else {
                if (input.startsWith("todo ")) {
                    tasks[taskCount] = new Todo(input.substring(5)); // remove "todo "
                } else if (input.startsWith("deadline ")) {
                    String[] parts = input.substring(9).split("/by", 2);
                    tasks[taskCount] = new Deadline(parts[0].trim(), parts[1].trim());
                } else if (input.startsWith("event ")) {
                    String[] parts = input.substring(6).split("/from|/to");
                    tasks[taskCount] = new Event(parts[0].trim(), parts[1].trim(), parts[2].trim());
                } else {
                    tasks[taskCount] = new Task(input);
                }
                taskCount++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + tasks[taskCount-1]); // will call toString()
                System.out.println("Now you have " + taskCount + " tasks in the list.");
            }
        }

    }
}
