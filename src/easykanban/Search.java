/*Author: Zenwyn Naicker*/
package easykanban;
public class Search 
{
    //global arrays
    String[] developer = null;
    String[] taskNames = null;
    String[] taskID = null;
    double[] taskDuration = null;
    String[] taskStatus = null;
    //set all arrays size
    public void setAllArraysSize(int numTasks) 
    {
        developer = new String[numTasks];
        taskNames = new String[numTasks];
        taskID = new String[numTasks];
        taskDuration = new double[numTasks];
        taskStatus = new String[numTasks];
    }
    //populate developer array
    public void populateDeveloper(int index, String dev) 
    {
        developer[index] = dev;
    }
    //populate TaskNames array
    public void populateTaskNames(int index, String name) 
    {
        taskNames[index] = name;
    }
    //populate taskID array
    public void populateTaskID(int index, String id) 
    {
        taskID[index] = id;
    }
    //populate TaskDuration array
    public void populateTaskDuration(int index, double duration) 
    {
        taskDuration[index] = duration;
    }
    //populate taskStatus array
    public void populateTaskStatus(int index, String status) 
    {
        taskStatus[index] = status;
    }
    //Display the Developer, Task Names and Task Duration for all tasks with the status of done
    public String returnDoneTasks ()
    {
        String doneTasks = "";
        for (int j = 0; j < taskStatus.length; j++)
        {
            if (taskStatus[j].equalsIgnoreCase("done"))
            {
                doneTasks = doneTasks + "Developer: " + developer[j] + "\n" + "Task Name: " + taskNames[j] + "\n" + "Task Duration: " + taskDuration[j] + "\n" ;
            }
        }
        return doneTasks;
    }
    //Display the Developer and Duration of the task with the longest duration
    public String returnLongestTask ()
    {
        int position = 0;
        for (int j = 0; j < taskDuration.length - 1; j++)
        {
            if (taskDuration[j] < taskDuration[j + 1])
            {
                position = j+1;
            }
            else
            {
                position = j;
            }
        }
        String longestTask = "Developer: " + developer[position] + "\nTask Duration: " + taskDuration[position];  
        return longestTask;
    }
    //Search for a task with a Task Name and display the Task Name, Developer and Task Status
    public String searchForTask(String taskName)
    {
        String task = "";
        for (int j = 0; j < taskNames.length; j++)
        {
            if (taskNames[j].equalsIgnoreCase(taskName))
            {
                task = "Task Name: " + taskNames[j] + "\nDeveloper: " + developer[j] + "\nTask Duration: " + taskDuration[j] ;
            }
        }
        return task;
    }
    //Search for all tasks assigned to a developer and display the Task Name and Task Status    ****
    public String searchForAllDevTasks(String devName)
    {
        String dev = "";
        for (int j = 0; j < developer.length; j++)
        {
            if (developer[j].equalsIgnoreCase(devName))
            {
                dev = dev + "Task Name: " + taskNames[j] + "\nTask status: " + taskStatus[j] + "\n";
            }
        }
        return dev;
    }
    //Delete a task using the Task Name
    public String deleteTask(String taskName)
    {
        String message = "Task successfully deleted";
        int position = 0; 
        //find position of elements to delete from all arrays
        for (int j = 0; j < taskNames.length; j++)
        {
            if (taskNames[j].equalsIgnoreCase(taskName))
            {
                position = j;
            }
        } 
        int size = taskNames.length;
        //declaring new arrays resized to not store the removed elements
        String[] devArray = new String[size-1];
        String[] taskNameArray = new String[size-1];
        String[] taskIDArray = new String[size-1];
        double[] durationArray = new double[size-1];
        String[] statusArray = new String[size-1]; 
        //populate the new arrays with all elements except the element being deleted
        for (int i = 0, k = 0; i < size; i++) 
        { 
            if (i == position) 
            { 
                continue; 
            }
            devArray[k] = developer[i]; 
            taskNameArray[k] = taskNames[i]; 
            taskIDArray[k] = taskID[i]; 
            durationArray[k] = taskDuration[i]; 
            statusArray[k] = taskStatus[i]; 
            k++;
        } 
        developer = devArray;
        taskNames = taskNameArray;
        taskID = taskIDArray;
        taskDuration = durationArray;
        taskStatus = statusArray;
        return message;
    }
    //Display a report that lists the full details of all captured tasks     ***
    public String displayReport ()
    {
        String report = "";
        for (int j = 0; j < developer.length; j++)
        {
            report = report +"\nDeveloper: "+ developer[j] +"\nTask Name: "+ taskNames[j] +"\nTask ID: "+ taskID[j] +"\nTask Duration: "+ taskDuration[j] +"\nTask Status: "+ taskStatus[j] +"\n";
        }
        return report;
    }
}
        /*************************************************************************************************************
         * ***********************************************************************************************************
         * Title: JRemove an Element at Specific Index from an Array in Java
         * Author: GeeksforGeeks
         * Date: 2023
         * Availability: https://www.geeksforgeeks.org/remove-an-element-at-specific-index-from-an-array-in-java/
         * ***********************************************************************************************************
         *************************************************************************************************************/