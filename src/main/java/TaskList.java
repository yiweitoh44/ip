import java.util.ArrayList;

/**
 * Represents a list of tasks for the Zack application.
 * Provides methods to add, delete, mark/unmark, and search tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with preloaded tasks.
     *
     * @param loadedTasks ArrayList of tasks to initialize with.
     */
    public TaskList(ArrayList<Task> loadedTasks) {
        tasks = loadedTasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task Task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes the task at the given index.
     *
     * @param index Index of the task to delete.
     * @return The removed task.
     * @throws ZackException If the index is invalid.
     */
    public Task deleteTask(int index) throws ZackException {
        if (index < 0 || index >= tasks.size()) {
            throw new ZackException("Invalid task number for delete!");
        }
        return tasks.remove(index);
    }

    /**
     * Marks the task at the given index as done.
     *
     * @param index Index of the task to mark.
     * @throws ZackException If the index is invalid.
     */
    public void markTask(int index) throws ZackException {
        if (index < 0 || index >= tasks.size()) {
            throw new ZackException("Invalid task number for mark!");
        }
        tasks.get(index).markAsDone();
    }

    /**
     * Unmarks the task at the given index (marks as not done).
     *
     * @param index Index of the task to unmark.
     * @throws ZackException If the index is invalid.
     */
    public void unmarkTask(int index) throws ZackException {
        if (index < 0 || index >= tasks.size()) {
            throw new ZackException("Invalid task number for unmark!");
        }
        tasks.get(index).unmark();
    }

    /**
     * Returns all tasks in the list.
     *
     * @return ArrayList of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return Number of tasks.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Finds tasks containing the specified keyword.
     *
     * @param keyword Keyword to search for.
     * @return ArrayList of tasks that match the keyword.
     * @throws ZackException If the keyword is empty.
     */
    public ArrayList<Task> find(String keyword) throws ZackException {
        String trimmed = keyword.trim();
        if (trimmed.isEmpty()) {
            throw new ZackException("The search keyword cannot be empty!");
        }
        ArrayList<Task> matches = new ArrayList<>();
        for (Task task : tasks) {
            if (task.toString().contains(trimmed)) {
                matches.add(task);
            }
        }
        return matches;
    }
}