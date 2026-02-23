import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> loadedTasks) {
        tasks = loadedTasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task deleteTask(int index) throws ZackException {
        if (index < 0 || index >= tasks.size()) {
            throw new ZackException("Invalid task number for delete!");
        }
        return tasks.remove(index);
    }

    public void markTask(int index) throws ZackException {
        if (index < 0 || index >= tasks.size()) {
            throw new ZackException("Invalid task number for mark!");
        }
        tasks.get(index).markAsDone();
    }

    public void unmarkTask(int index) throws ZackException {
        if (index < 0 || index >= tasks.size()) {
            throw new ZackException("Invalid task number for unmark!");
        }
        tasks.get(index).unmark();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int size() {
        return tasks.size();
    }

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