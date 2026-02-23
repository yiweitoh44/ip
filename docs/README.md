# Zack User Guide

## Introduction
Zack is a command-line chatbot that helps you manage tasks efficiently.

## Features
- Add tasks (todo, deadline, event)
- Mark/unmark tasks
- Delete tasks
- Search tasks with the find command
- View all tasks

## How To Use Zack
### Adding Tasks
#### Add Todo
Adds a simple task to the task list without a time constraint.

Example: `todo Buy groceries`

The task is added to the list and the total task count increases.
```
Got it. I've added this task:
  [T][ ] Buy groceries
Now you have 1 tasks in the list.
```

#### Add Deadline
Adds a task with a specific deadline.

Example: `deadline Submit report /by 2026-02-25`

The task is added with the specified deadline and total task count updates.
```
Got it. I've added this task:
  [D][ ] Submit report (by: 2026-02-25)
Now you have 2 tasks in the list.
```

#### Add Event
Adds a task that occurs over a period of time.

Example: `event Team meeting /from 14:00 /to 15:00`

The event task is added with start and end times.
```
Got it. I've added this task:
  [E][ ] Team meeting (from: 14:00 to: 15:00)
Now you have 3 tasks in the list.
```

### Listing Tasks
Displays all tasks currently in the task list.

Example: `list`

Outputs all tasks with their status and type.
```
Here are the tasks in your list:
1.[T][ ] Buy groceries
2.[D][ ] Submit report (by: 2026-02-25)
3.[E][ ] Team meeting (from: 14:00 to: 15:00)
```

### Mark Task As Done
Marks the specified task as completed.

Example: `mark 2`

The task status is updated to done.
```
Nice! I've marked this task as done:
  [D][X] Submit report (by: 2026-02-25)
```

### Unmark Task
Marks the specified task as not completed.

Example: `unmark 2`

The task status is reverted to not done.
```
OK, I've marked this task as not done yet:
  [D][ ] Submit report (by: 2026-02-25)
```

### Delete Task
Removes the specified task from the list.

Example: `delete 1`

The task is removed and the total task count decreases.
```
Noted. I've removed this task:
  [T][ ] Buy groceries
Now you have 2 tasks in the list.
```

### Find Tasks
Searches tasks that contain a keyword in their description.

Example: `find report`

Outputs all tasks matching the keyword.
```
Here are the matching tasks in your list:
1.[D][ ] Submit report (by: 2026-02-25)
```

### Exit Zack
Exits the chatbot program.

Example: `bye`

The program stops and displays a goodbye message.
```
Aite ciao!
```
