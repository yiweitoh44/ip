import java.util.Scanner;

/**
 * Handles user interaction for the Zack application.
 * Provides methods to display messages, errors, tasks, and read user input.
 */
public class Ui {
    private Scanner scanner;

    /**
     * Constructs a Ui instance and initialises the input scanner.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /** Displays a welcome message to the user. */
    public void showWelcome() {
        System.out.println("Howdy! I'm Zack");
        System.out.println("What can I do for you?");
    }

    /**
     * Reads a line of input from the user.
     *
     * @return User input as a String.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays all tasks in the list.
     *
     * @param tasks ArrayList of tasks to display.
     */
    public void showTasks(java.util.ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
    }

    /**
     * Displays an error message with formatting.
     *
     * @param msg Error message to display.
     */
    public void showError(String msg) {
        System.out.println("____________________________________________________________");
        System.out.println(" OOPS!!! " + msg);
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message indicating that a task has been added.
     *
     * @param task Task that was added.
     * @param totalTasks Total number of tasks in the list.
     */
    public void showAddedTask(Task task, int totalTasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
    }

    /**
     * Displays a message indicating that a task has been deleted.
     *
     * @param task Task that was deleted.
     * @param totalTasks Total number of tasks remaining.
     */
    public void showDeletedTask(Task task, int totalTasks) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
    }

    /** Displays a goodbye message to the user. */
    public void showGoodbye() {
        System.out.println("Aite ciao!");
    }

    /**
     * Displays a message indicating that a task has been marked as done.
     *
     * @param task Task that was marked.
     */
    public void showMarkedTask(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
    }

    /**
     * Displays a message indicating that a task has been unmarked.
     *
     * @param task Task that was unmarked.
     */
    public void showUnmarkedTask(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
    }

    /**
     * Displays tasks matching a search keyword.
     * If no tasks are found, shows a message indicating this.
     *
     * @param tasks ArrayList of tasks matching the search.
     */
    public void showFoundTasks(java.util.ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("  No matching tasks found.");
            return;
        }
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
    }
}