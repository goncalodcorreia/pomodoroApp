package Functionality;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by Correia on 24/06/2017.
 */
public class Task {
    private String taskName;
    private int defaultPomodoros;
    private int donePomodoros;
    private LinkedList<String> tags;

    public Task(String taskName, int defaultPomodoros, int donePomodoros, LinkedList<String>tags){
        this.taskName = taskName;
        this.defaultPomodoros = defaultPomodoros;
        this.donePomodoros = donePomodoros;
        this.tags = tags;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getDefaultPomodoros() {
        return defaultPomodoros;
    }

    public void setDefaultPomodoros(int defaultPomodoros) {
        this.defaultPomodoros = defaultPomodoros;
    }

    public int getDonePomodoros() {
        return donePomodoros;
    }

    public void setDonePomodoros(int donePomodoros) {
        this.donePomodoros = donePomodoros;
    }

    public LinkedList<String> getTags() {
        return tags;
    }

    public void setTags(LinkedList<String> tags) {
        this.tags = tags;
    }
}
