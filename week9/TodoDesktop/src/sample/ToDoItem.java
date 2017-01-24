package sample;

/**
 * Created by jeff on 1/24/17.
 */
public class ToDoItem {
    private String text;
    private boolean isDone;

    public ToDoItem(String text) {
        this.text = text;
        isDone = false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return text + (isDone ? " (done)" : "");
    }
}
