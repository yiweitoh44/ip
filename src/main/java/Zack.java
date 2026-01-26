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
                            (i + 1) + ".[" +
                                    tasks[i].getStatusIcon() + "] " +
                                    tasks[i].getDescription()
                    );
                }
            } else if (input.startsWith("mark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  [" + tasks[index].getStatusIcon() + "] "
                        + tasks[index].getDescription());
            } else if (input.startsWith("unmark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].unmark();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  [" + tasks[index].getStatusIcon() + "] "
                        + tasks[index].getDescription());
            } else {
                tasks[taskCount] = new Task(input);
                taskCount++;
                System.out.println("added: " + input);
            }
        }

    }
}
