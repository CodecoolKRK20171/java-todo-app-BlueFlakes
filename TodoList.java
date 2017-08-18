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
            System.out.println("Error: next time please provide any details.");

        }

        System.out.println();
    }

    public void findAndMarkTask(int index)
    {
        if (index > 0 && index <= this.taskList.size())
        {
            TodoItem task = this.taskList.get(index - 1);
            task.markTaskAsDone();

        }
        else
            System.out.println("Error: index out of range.");

        System.out.println();
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

        System.out.println("Succesfuly archived.");
        System.out.println();
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
        if (this.taskList.size() > 0)
        {
            for(int i = 0; i < this.taskList.size(); i++)
            {
                String index = Integer.toString(i+1);
                TodoItem task = this.taskList.get(i);
                System.out.println("\t" + index + ". " + task);

            }
        }
        else
        {
            System.out.println("Empty list.");

        }

        System.out.println();
    }
}
