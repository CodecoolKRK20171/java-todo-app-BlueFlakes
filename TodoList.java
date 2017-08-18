/**
 * Class representing a todo list.
 * TodoList object should aggregate TodoItem objects.
 */

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class TodoList{
    private LinkedList<TodoItem> taskList;

    public TodoList()
    {
        this.taskList = new LinkedList<>();

    }

    public void addNewTask(String deliveredTaskDetails)
    {
        if (!deliveredTaskDetails.isEmpty())
        {
            this.taskList.add(new TodoItem(deliveredTaskDetails));

        }
        else
        {
            System.out.println("handle empty task details");

        }
    }

    public void archiveOldTasks()
    {
        List<Integer> indexesToDelete = getItemsIndexToDelete();
        int index;

        for(int i = 0; i < indexesToDelete.size(); i++)
        {
            index = indexesToDelete.get(i);
            taskList.remove((int) index);

        }
    }

    private List<Integer> getItemsIndexToDelete()
    {
        List<Integer> indexesList = new ArrayList<>();
        TodoItem task;

        for(int i = 0; i < this.taskList.size(); i++)
        {
            task = this.taskList.get(i);

            if (task.getTaskStatus())
                indexesList.add(i);
        }

        return indexesList;
    }

    public void showExistingTasks()
    {
        for(int i = 0; i < this.taskList.size(); i++)
        {
            String index = Integer.toString(i+1);
            TodoItem task = this.taskList.get(i);
            System.out.println(index + ". " + task);
        }

    }

}
