# EasyKanban

A Java task-management app with a Swing dialog interface. Users register and sign in, add development tasks with auto-generated task IDs, and run reports and searches across the task board.

Built for PROG5121 at Emeris Durban North (2024).

## Features

- **Registration and login:** usernames must contain an underscore and be at most five characters; passwords need at least eight characters with a capital letter, a number and a special character.
- **Task capture:** each task has a name, description (under 50 characters), developer, duration and status (To Do, Doing or Done).
- **Generated task IDs:** built from the task name, task number and developer name, for example `LO:0:BYN`.
- **Reports and searches:** a full task report, done tasks, the longest task, a search by task name and all tasks for a developer.
- **Task deletion:** remove a task by name.
- **Running total:** total hours across all captured tasks.

## Tech stack

| Area | Technologies |
| --- | --- |
| App | Java 21, Swing (`JOptionPane`) |
| Testing and CI | JUnit 5, GitHub Actions |
| IDE | Apache NetBeans (Ant project) |

## Getting started

### Prerequisites

- JDK 21
- A desktop environment, for the Swing dialogs

### Run locally

```bash
mkdir -p build/classes
javac -d build/classes src/easykanban/*.java
java -cp build/classes easykanban.EasyKanban
```

You can also open the folder as a project in Apache NetBeans.

## Testing

```bash
javac -cp lib/junit-platform-console-standalone-1.6.0.jar:build/classes -d build/classes test/easykanban/*.java
java -jar lib/junit-platform-console-standalone-1.6.0.jar --class-path build/classes --scan-class-path
```

The 15 JUnit tests cover registration and login validation, task descriptions and IDs, task details, total hours, the report, and every search and delete operation. On Windows, use `;` instead of `:` between classpath entries. The GitHub Actions workflow runs the same steps and is set to run manually.

## Project structure

```text
src/easykanban/    Application: registration, login, tasks, searches and the main menu
test/easykanban/   JUnit tests
lib/               JUnit console launcher
nbproject/         NetBeans project settings
```

## Acknowledgements

Documentation and tutorials used in this project are credited in comments in the source files.
