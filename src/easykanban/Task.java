/*Author: Zenwyn Naicker*/
package easykanban;
public class Task 
{
    //global variables
    private String taskName;
    private int taskNumber;
    private String taskDescription;    
    private boolean isLessThan50Char;
    private String devName;
    private String devSurname;
    private double taskDuration;
    private String taskID;
    private String taskStatus; 
    private double totalHours; 
    //constructor with default values
    public Task()
    {
    taskName = "";
    taskNumber = 0;
    taskDescription = "";
    isLessThan50Char = false;
    devName = "";
    devSurname = "";
    taskDuration = 0;
    taskID = "";
    taskStatus = "";
    }
    //set task name
    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }
    //get task name
        public String getTaskName() 
    {
        return taskName;
    }
    //set task number
    public void setTaskNumber(int taskNumber) 
    {
        this.taskNumber = taskNumber;
    }
    //get task number
    public int getTaskNumber() 
    {
        return taskNumber;
    }
    //set task description
    public void setTaskDescription(String taskDescription)
    {
        this.taskDescription = taskDescription;
    }
    //get task description
    public String getTaskDescription() 
    {
        return taskDescription;
    }
    //set dev name
    public void setDevName(String devName) 
    {
        this.devName = devName;
    }
    //get dev name
    public String getDevName()
    {
        return devName;
    }
    //set dev surname
    public void setDevSurname(String devSurname)
    {
        this.devSurname = devSurname;
    }
    //get dev surname
    public String getDevSurname() 
    {
        return devSurname;
    }
    //set task duration
    public void setTaskDuration(double taskDuration) 
    {
        this.taskDuration = taskDuration;
    }
    //get task duration
    public double getTaskDuration() 
    {
        return taskDuration;
    }
    //set task status
    public void setTaskStatus(String taskStatus) 
    {
        this.taskStatus = taskStatus;
    }
    //get task status
    public String getTaskStatus() 
    {
        return taskStatus;
    }
    //ensures that the task description is not more than 50 characters
    public boolean checkTaskDescription()
    {
        final int MAX_LENGTH = 50;
        int length = taskDescription.length();
        if (length < MAX_LENGTH)
        {
            this.isLessThan50Char = true;
        }
        else
        {
            this.isLessThan50Char = false;
        }
        return this.isLessThan50Char;
    }
    //creates and returns the taskID
    public String createTaskID()
    {
        String substringTaskName = taskName.substring(0, 2);
        String substringDevName = devName.substring(devName.length() - 3);
        taskID = substringTaskName + ":" + taskNumber + ":" + substringDevName;
        taskID = taskID.toUpperCase();
        return taskID;
    }
    //returns the full task details of each task
    public String printTaskDetails()
    {
        String taskDetails = "Task Name: " + taskName
                            + "\nTask Number: " + taskNumber
                            + "\nTask Description: " + taskDescription
                            + "\nDeveloper Details: " + devName + " " + devSurname
                            + "\nTask Duration: " + taskDuration
                            + "\nTask ID: " + taskID
                            + "\nTask Status: " + taskStatus;
        return taskDetails;
    }  
    //returns the total combined hours of all entered tasks
    public double returnTotalHours(double totalHours)
    {
       this.totalHours = totalHours;
       return this.totalHours;
    } 
}
    /*************************************************************************************************************
    * ***********************************************************************************************************
    * Title: Substring in Java
    * Author: GeeksforGeeks
    * Date: 2023
    * Availability: https://www.geeksforgeeks.org/substring-in-java/
    * ***********************************************************************************************************
    *************************************************************************************************************/   