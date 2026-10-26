/*Author: Zenwyn Naicker*/
package easykanban;

import org.junit.Test;
import static org.junit.Assert.*;

public class SearchTest {
    Search search = new Search();

    @Test
    public void testReturnDoneTasks() {
        search.setAllArraysSize(4);
        //task 1
        search.populateDeveloper(0, "Mike");
        search.populateTaskNames(0, "Create Login");
        search.populateTaskDuration(0, 5);
        search.populateTaskStatus(0, "To Do");
        //task 2
        search.populateDeveloper(1, "Edward");
        search.populateTaskNames(1, "Create Add Features");
        search.populateTaskDuration(1, 8);
        search.populateTaskStatus(1, "Doing");
        //task 3
        search.populateDeveloper(2, "Samantha");
        search.populateTaskNames(2, "Create Reports");
        search.populateTaskDuration(2, 2);
        search.populateTaskStatus(2, "Done");
        //task 4
        search.populateDeveloper(3, "Glenda");
        search.populateTaskNames(3, "Add Arrays");
        search.populateTaskDuration(3, 11);
        search.populateTaskStatus(3, "To Do");
        String expected = "Developer: " + "Samantha" + "\n" + "Task Name: " + "Create Reports" + "\n" + "Task Duration: " + 2.0 + "\n" ;
        String actual = search.returnDoneTasks();
        assertEquals(actual,expected);
    }

    @Test
    public void testReturnLongestTask() {
        search.setAllArraysSize(4);
        //task 1
        search.populateDeveloper(0, "Mike");
        search.populateTaskNames(0, "Create Login");
        search.populateTaskDuration(0, 5);
        search.populateTaskStatus(0, "To Do");
        //task 2
        search.populateDeveloper(1, "Edward");
        search.populateTaskNames(1, "Create Add Features");
        search.populateTaskDuration(1, 8);
        search.populateTaskStatus(1, "Doing");
        //task 3
        search.populateDeveloper(2, "Samantha");
        search.populateTaskNames(2, "Create Reports");
        search.populateTaskDuration(2, 2);
        search.populateTaskStatus(2, "Done");
        //task 4
        search.populateDeveloper(3, "Glenda");
        search.populateTaskNames(3, "Add Arrays");
        search.populateTaskDuration(3, 11);
        search.populateTaskStatus(3, "To Do");
        String expected = "Developer: " + "Glenda" + "\nTask Duration: " + 11.0;
        String actual = search.returnLongestTask();
        assertEquals(actual,expected);
    }

    @Test
    public void testSearchForTask() {
        search.setAllArraysSize(4);
        //task 1
        search.populateDeveloper(0, "Mike");
        search.populateTaskNames(0, "Create Login");
        search.populateTaskDuration(0, 5);
        search.populateTaskStatus(0, "To Do");
        //task 2
        search.populateDeveloper(1, "Edward");
        search.populateTaskNames(1, "Create Add Features");
        search.populateTaskDuration(1, 8);
        search.populateTaskStatus(1, "Doing");
        //task 3
        search.populateDeveloper(2, "Samantha");
        search.populateTaskNames(2, "Create Reports");
        search.populateTaskDuration(2, 2);
        search.populateTaskStatus(2, "Done");
        //task 4
        search.populateDeveloper(3, "Glenda");
        search.populateTaskNames(3, "Add Arrays");
        search.populateTaskDuration(3, 11);
        search.populateTaskStatus(3, "To Do");
        String expected = "Task Name: " + "Add Arrays" + "\nDeveloper: " + "Glenda" + "\nTask Duration: " + 11.0 ;
        String actual = search.searchForTask("Add Arrays");
        assertEquals(actual,expected);
    }

    @Test
    public void testSearchForAllDevTasks() {
        search.setAllArraysSize(4);
        //task 1
        search.populateDeveloper(0, "Mike");
        search.populateTaskNames(0, "Create Login");
        search.populateTaskDuration(0, 5);
        search.populateTaskStatus(0, "To Do");
        //task 2
        search.populateDeveloper(1, "Edward");
        search.populateTaskNames(1, "Create Add Features");
        search.populateTaskDuration(1, 8);
        search.populateTaskStatus(1, "Doing");
        //task 3
        search.populateDeveloper(2, "Samantha");
        search.populateTaskNames(2, "Create Reports");
        search.populateTaskDuration(2, 2);
        search.populateTaskStatus(2, "Done");
        //task 4
        search.populateDeveloper(3, "Glenda");
        search.populateTaskNames(3, "Add Arrays");
        search.populateTaskDuration(3, 11);
        search.populateTaskStatus(3, "To Do");
        String expected = "Task Name: " + "Add Arrays" + "\nTask status: " + "To Do" + "\n";
        String actual = search.searchForAllDevTasks("Glenda");
        assertEquals(actual,expected);
    }

    @Test
    public void testDeleteTask() {
        search.setAllArraysSize(4);
        //task 1
        search.populateDeveloper(0, "Mike");
        search.populateTaskNames(0, "Create Login");
        search.populateTaskDuration(0, 5);
        search.populateTaskStatus(0, "To Do");
        //task 2
        search.populateDeveloper(1, "Edward");
        search.populateTaskNames(1, "Create Add Features");
        search.populateTaskDuration(1, 8);
        search.populateTaskStatus(1, "Doing");
        //task 3
        search.populateDeveloper(2, "Samantha");
        search.populateTaskNames(2, "Create Reports");
        search.populateTaskDuration(2, 2);
        search.populateTaskStatus(2, "Done");
        //task 4
        search.populateDeveloper(3, "Glenda");
        search.populateTaskNames(3, "Add Arrays");
        search.populateTaskDuration(3, 11);
        search.populateTaskStatus(3, "To Do");
        String actualMessage = search.deleteTask("Add Arrays");
        String expectedReport = "";
        for (int j = 0; j < 3; j++)
        {
            expectedReport = expectedReport +"\nDeveloper: "+ search.developer[j] +"\nTask Name: "+ search.taskNames[j] +"\nTask ID: "+ search.taskID[j] +"\nTask Duration: "+ search.taskDuration[j] +"\nTask Status: "+ search.taskStatus[j] +"\n";
        }
        String actualReport = search.displayReport();
        //checks if the report displays without the deleted task 
        assertEquals(actualReport,expectedReport);
        String expectedMessage  = "Task successfully deleted";
        //checks that a message is returned stating that the task was deleted
        assertEquals(actualMessage ,expectedMessage );
    }

    @Test
    public void testDisplayReport() {
        search.setAllArraysSize(4);
        //task 1
        search.populateDeveloper(0, "Mike");
        search.populateTaskNames(0, "Create Login");
        search.populateTaskDuration(0, 5);
        search.populateTaskStatus(0, "To Do");
        //task 2
        search.populateDeveloper(1, "Edward");
        search.populateTaskNames(1, "Create Add Features");
        search.populateTaskDuration(1, 8);
        search.populateTaskStatus(1, "Doing");
        //task 3
        search.populateDeveloper(2, "Samantha");
        search.populateTaskNames(2, "Create Reports");
        search.populateTaskDuration(2, 2);
        search.populateTaskStatus(2, "Done");
        //task 4
        search.populateDeveloper(3, "Glenda");
        search.populateTaskNames(3, "Add Arrays");
        search.populateTaskDuration(3, 11);
        search.populateTaskStatus(3, "To Do");
        String expected = "";
        for (int j = 0; j < 4; j++)
        {
            expected = expected +"\nDeveloper: "+ search.developer[j] +"\nTask Name: "+ search.taskNames[j] +"\nTask ID: "+ search.taskID[j] +"\nTask Duration: "+ search.taskDuration[j] +"\nTask Status: "+ search.taskStatus[j] +"\n";
        }
        String actual = search.displayReport();
        assertEquals(actual,expected);
    }
    
}