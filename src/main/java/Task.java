public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void unmark() {
        isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    public String getTypeIcon() {
        return " ";
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] "
                + description;
    }
}
