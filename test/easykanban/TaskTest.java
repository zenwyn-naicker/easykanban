/*Author: Zenwyn Naicker*/
package easykanban;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {
    Task tasks = new Task();
    
    @Test
    public void testCheckTaskDescription() {
        //test data for task 1 
        tasks.setTaskDescription("Create Login to authenticate users");
        assertTrue(tasks.checkTaskDescription());
        //test data for task 2
        tasks.setTaskDescription("Create Add Task feature to add task  users");
        assertTrue(tasks.checkTaskDescription());
    }

    @Test
    public void testCreateTaskID() {
        //test data for task 1 
        tasks.setTaskName("Login Feature");
        tasks.setDevName("Robyn");
        tasks.setTaskNumber(0);
        String actual = tasks.createTaskID();
        String expected = "LO:0:BYN";
        assertEquals(expected, actual);
        //test data for task 2
        tasks.setTaskName("Add Task Feature");
        tasks.setDevName("Mike");
        tasks.setTaskNumber(1);
        String actual2 = tasks.createTaskID();
        String expected2 = "AD:1:IKE";
        assertEquals(expected2, actual2);   
    }

    @Test
    public void testPrintTaskDetails() {
        //test data for task 1
        tasks.setTaskName("Login Feature");
        tasks.setTaskNumber(0);
        tasks.setTaskDescription("Create Login to authenticate users");
        tasks.setDevName("Robyn");
        tasks.setDevSurname("Harrison");
        tasks.setTaskDuration(8);
        tasks.createTaskID();
        tasks.setTaskStatus("To Do");
        String actual = tasks.printTaskDetails();
        String expected = "Task Name: Login Feature\n" +
                          "Task Number: 0\n" +
                          "Task Description: Create Login to authenticate users\n" +
                          "Developer Details: Robyn Harrison\n" +
                          "Task Duration: 8.0\n" +
                          "Task ID: LO:0:BYN\n" +
                          "Task Status: To Do"; 
        assertEquals(expected, actual);
        //test data for task 2
        tasks.setTaskName("Add Task Feature");
        tasks.setTaskNumber(1);
        tasks.setTaskDescription("Create Add Task feature to add task  users");
        tasks.setDevName("Mike");
        tasks.setDevSurname("Smith");
        tasks.setTaskDuration(10);
        tasks.createTaskID();
        tasks.setTaskStatus("Doing");
        String actual2 = tasks.printTaskDetails();
        String expected2 = "Task Name: Add Task Feature\n" +
                           "Task Number: 1\n" +
                           "Task Description: Create Add Task feature to add task  users\n" +
                           "Developer Details: Mike Smith\n" +
                           "Task Duration: 10.0\n" +
                           "Task ID: AD:1:IKE\n" +
                           "Task Status: Doing"; 
        assertEquals(expected2, actual2);
    }

    @Test
    public void testReturnTotalHours() {
        //test data for task 1 
        tasks.setTaskDuration(8);
        double totalHours = 0;
        totalHours = totalHours + tasks.getTaskDuration();
        //test data for task 2
        tasks.setTaskDuration(10);
        totalHours = totalHours + tasks.getTaskDuration();
        assertTrue(tasks.returnTotalHours(totalHours) == 18); 
    }
}
