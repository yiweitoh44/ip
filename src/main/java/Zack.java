public class Zack {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Zack(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);

        tasks = new TaskList(storage.load());
        //tasks = new TaskList(); // start empty for testing
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String input = ui.readCommand();
                ParsedInput pi = Parser.parse(input);

                switch (pi.command) {
                case "bye":
                    ui.showGoodbye();
                    isExit = true;
                    break;
                case "list":
                    ui.showTasks(tasks.getTasks());
                    break;
                case "mark":
                    int markIndex = Integer.parseInt(pi.argument) - 1;
                    tasks.markTask(markIndex);
                    ui.showMarkedTask(tasks.getTasks().get(markIndex));
                    storage.save(tasks.getTasks());
                    break;
                case "unmark":
                    int unmarkIndex = Integer.parseInt(pi.argument) - 1;
                    tasks.unmarkTask(unmarkIndex);
                    ui.showUnmarkedTask(tasks.getTasks().get(unmarkIndex));
                    storage.save(tasks.getTasks());
                    break;
                case "delete":
                    int delIndex = Integer.parseInt(pi.argument) - 1;
                    Task removed = tasks.deleteTask(delIndex);
                    ui.showDeletedTask(removed, tasks.size());
                    storage.save(tasks.getTasks());
                    break;
                case "todo":
                    if (pi.argument.trim().isEmpty()) {
                        throw new ZackException("The description of a todo cannot be empty!");
                    }
                    tasks.addTask(new Todo(pi.argument));
                    ui.showAddedTask(tasks.getTasks().get(tasks.size() - 1), tasks.size());
                    storage.save(tasks.getTasks());
                    break;
                case "deadline":
                    String[] parts = pi.argument.split("/by", 2);
                    if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                        throw new ZackException("Deadline format: deadline DESCRIPTION /by TIME");
                    }
                    tasks.addTask(new Deadline(parts[0].trim(), parts[1].trim()));
                    ui.showAddedTask(tasks.getTasks().get(tasks.size() - 1), tasks.size());
                    storage.save(tasks.getTasks());
                    break;
                case "event":
                    String[] parts2 = pi.argument.split("/from|/to");
                    if (parts2.length < 3 || parts2[0].trim().isEmpty() || parts2[1].trim().isEmpty() || parts2[2].trim().isEmpty()) {
                        throw new ZackException("Event format: event DESCRIPTION /from START /to END");
                    }
                    tasks.addTask(new Event(parts2[0].trim(), parts2[1].trim(), parts2[2].trim()));
                    ui.showAddedTask(tasks.getTasks().get(tasks.size() - 1), tasks.size());
                    storage.save(tasks.getTasks());
                    break;
                }

            } catch (ZackException | NumberFormatException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Zack("./data/zack.txt").run();
    }
}