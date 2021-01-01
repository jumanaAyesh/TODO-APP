package adapter;

public class Task {
    private String taskName;
    private boolean taskCheck;

    public Task(String taskName, boolean taskCheck) {
        this.taskName = taskName;
        this.taskCheck = taskCheck;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isTaskCheck() {
        return taskCheck;
    }

    public void setTaskCheck(boolean taskCheck) {
        this.taskCheck = taskCheck;
    }
}
