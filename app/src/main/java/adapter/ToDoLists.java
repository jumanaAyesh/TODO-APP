package adapter;

public class ToDoLists {

    private String nameList;
    private int numTask;

    public ToDoLists(String nameList, int numTask) {
        this.nameList = nameList;
        this.numTask = numTask;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public int getNumTask() {
        return numTask;
    }

    public void setNumTask(int numTask) {
        this.numTask = numTask;
    }
}
