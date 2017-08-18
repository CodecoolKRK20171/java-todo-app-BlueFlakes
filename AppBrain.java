import java.util.Scanner;

class AppBrain
{
    private Scanner in = new Scanner(System.in);
    private TodoList todoList = new TodoList();
    private ValidateInput ValidateInput = new ValidateInput();

    public void start()
    {
        String userChoice = "begin";

        while (!userChoice.equalsIgnoreCase("shutdown"))
        {
            System.out.print("Please specify a command [list, add, mark, archive, shutdown]: ");
            userChoice = in.nextLine().trim();
            handleMenuOptions(userChoice);

        }
    }

    private void handleMenuOptions(String userChoice)
    {
        if (userChoice.equalsIgnoreCase("add"))
            handleTaskAdding();

        else if (userChoice.equalsIgnoreCase("mark"))
            handleMarkTask();

        else if (userChoice.equalsIgnoreCase("list"))
            handleListAvailableServices();

        else if (userChoice.equalsIgnoreCase("archive"))
            handleArchiveOldTasks();

        else if (userChoice.equalsIgnoreCase("shutdown"))
            handleShutdownApp();

        else
            System.out.println("Wrong key.");
    }

    private void handleTaskAdding()
    {
        System.out.print("Add an item: " );
        String taskDetails = in.nextLine();
        this.todoList.addNewTask(taskDetails);

    }

    private void handleListAvailableServices()
    {
        this.todoList.showExistingTasks();

    }

    private void handleArchiveOldTasks()
    {
        this.todoList.archiveOldTasks();

    }

    private void handleMarkTask()
    {
        this.todoList.showExistingTasks();
        System.out.print("Which one you want to mark as completed: ");
        String index = in.nextLine().trim();

        if (ValidateInput.isInteger(index))
        {
            int parsedIndex = Integer.parseInt(index);
            this.todoList.findAndMarkTask(parsedIndex);

        }
    }

    private void handleShutdownApp()
    {
        System.out.println("Thanks for using our SOFTWARE and have a nice day :)");

    }

}
