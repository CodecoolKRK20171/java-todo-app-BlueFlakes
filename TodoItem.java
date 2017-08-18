/**
 * Class representing a single todo item.
 *
 */


public class TodoItem{
    private boolean isDone;
    private String taskDetails;

    public TodoItem(String aTask)
    {
        this.isDone = false;
        this.taskDetails = aTask;

    }

    public void markTaskAsDone()
    {
        this.isDone = true;

    }

    public boolean getTaskStatus()
    {
        return this.isDone;

    }

    @Override
    public String toString()
    {
        if (this.isDone)
            return "[x] " + this.taskDetails;

        else if (!this.isDone)
            return "[ ] " + this.taskDetails;

        return null;

    }
}
