/*Author: Zenwyn Naicker*/
package easykanban;
import javax.swing.JOptionPane;
public class EasyKanban 
{
    //main method
    public static void main(String[] args) 
    {   
        //instantiate objects
        Register register = new Register();
        Login login = new Login();
        //***register feature***
        //prompt and set username
        register.setUsername(JOptionPane.showInputDialog(null, "Enter a username: ", "Register", JOptionPane.PLAIN_MESSAGE));
        //prompt and set password
        register.setPassword(JOptionPane.showInputDialog(null, "Enter a password: ", "Register" , JOptionPane.PLAIN_MESSAGE));
        //prompt and set name
        register.setName(JOptionPane.showInputDialog(null, "Enter your name: ", "Register" , JOptionPane.PLAIN_MESSAGE));
        //prompt and set surname
        register.setSurname(JOptionPane.showInputDialog(null, "Enter your surname: ", "Register" , JOptionPane.PLAIN_MESSAGE));
        //check username format
        register.checkUserName();
        //check password format
        register.checkPasswordComplexity();
        //display if registration successful or not
        JOptionPane.showMessageDialog(null, register.registerUser(), "Register" , JOptionPane.PLAIN_MESSAGE);
        //try again to register until username and password formats are correct
        while (register.checkUserName() == false || register.checkPasswordComplexity() == false) 
        {
            //prompt and set username
            register.setUsername(JOptionPane.showInputDialog(null, "Enter a username: ", "Register" , JOptionPane.PLAIN_MESSAGE));
            //prompt and set password
            register.setPassword(JOptionPane.showInputDialog(null, "Enter a password: ", "Register" , JOptionPane.PLAIN_MESSAGE));
            //check username format
            register.checkUserName();
            //check password format
            register.checkPasswordComplexity();
            //display if registration successful or not
            JOptionPane.showMessageDialog(null, register.registerUser(), "Register" , JOptionPane.PLAIN_MESSAGE);
        }    
        //***login feature***
        //prompt and set username
        login.setUsername(JOptionPane.showInputDialog(null, "Enter your username: ", "Login" , JOptionPane.PLAIN_MESSAGE));
        //prompt and set password
        login.setPassword(JOptionPane.showInputDialog(null, "Enter your password: ", "Login" , JOptionPane.PLAIN_MESSAGE));
        //check if login successful or not
        login.loginUser(register.getUsername(), register.getPassword());
        //display login status
        JOptionPane.showMessageDialog(null, login.returnLoginStatus(register.getName(), register.getSurname()), "Login" , JOptionPane.PLAIN_MESSAGE);
        //try again to login util username and password are correct
        while (login.loginUser(register.getUsername(), register.getPassword()) == false) 
        {
            //prompt and set username
            login.setUsername(JOptionPane.showInputDialog(null, "Enter your username: ", "Login" , JOptionPane.PLAIN_MESSAGE));
            //prompt and set password
            login.setPassword(JOptionPane.showInputDialog(null, "Enter your password: ", "Login" , JOptionPane.PLAIN_MESSAGE));
            //check if login successful or not
            login.loginUser(register.getUsername(), register.getPassword());
            //display login status
            JOptionPane.showMessageDialog(null, login.returnLoginStatus(register.getName(), register.getSurname()), "Login" , JOptionPane.PLAIN_MESSAGE);
        }
        //***task feature***
        //objects
        Task tasks = new Task();
        Search search = new Search();
        //welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban", "EasyKanban", JOptionPane.PLAIN_MESSAGE);
        //options menu
        String strSelection = JOptionPane.showInputDialog(null, "Select an option (enter corresponding number):" +
                                                                "\n\n1.Add tasks" +
                                                                "\n2.Show report" +
                                                                "\n3.Search for done tasks" +
                                                                "\n4.Search for longest task" +
                                                                "\n5.Search for a task by name" +
                                                                "\n6.Search all tasks by developer" +
                                                                "\n7.Delete a task" +
                                                                "\n8.Exit", "EasyKanban", JOptionPane.PLAIN_MESSAGE);
        int intSelection = Integer.parseInt(strSelection);
        int numTasks = 0;
        double totalHours;           
        while (intSelection != 8) 
        {
            switch (intSelection) 
            {
                case 1:
                    //number of tasks to enter
                    numTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of tasks: ", "Tasks", JOptionPane.PLAIN_MESSAGE));
                    totalHours = 0;
                    //set size of all arrays
                    search.setAllArraysSize(numTasks);
                    for (int i = 0; i < numTasks; i++) 
                    {
                        //autogenerate task number
                        tasks.setTaskNumber(i);
                        int tasknum = tasks.getTaskNumber();
                        //prompt for task name
                        tasks.setTaskName(JOptionPane.showInputDialog(null, "Task name: ", "Task " + tasknum, JOptionPane.PLAIN_MESSAGE));
                        //prompt for task description
                        tasks.setTaskDescription(JOptionPane.showInputDialog(null, "Task decription: ", "Task " + tasknum, JOptionPane.PLAIN_MESSAGE));
                        tasks.checkTaskDescription();
                        //loop till task description is max 50 char in length
                        while (!tasks.checkTaskDescription()) 
                        {
                            tasks.setTaskDescription(JOptionPane.showInputDialog(null, "Please enter a task description of less than 50 characters", "Task " + tasknum, JOptionPane.PLAIN_MESSAGE));
                            tasks.checkTaskDescription();
                        }
                        JOptionPane.showMessageDialog(null, "Task description successfully captured", "Task " + tasknum, JOptionPane.PLAIN_MESSAGE);
                        //prompt for dev name
                        tasks.setDevName(JOptionPane.showInputDialog(null, "Developer name: ", "Task " + tasknum, JOptionPane.PLAIN_MESSAGE));
                        //prompt for dev surname
                        tasks.setDevSurname(JOptionPane.showInputDialog(null, "Developer surname: ", "Task " + tasknum, JOptionPane.PLAIN_MESSAGE));
                        //prompt for task duration
                        tasks.setTaskDuration(Double.parseDouble(JOptionPane.showInputDialog(null, "Task duration: ", "Task " + tasknum, JOptionPane.PLAIN_MESSAGE)));
                        //accumulate the total combined hours of all entered tasks
                        totalHours = totalHours + tasks.getTaskDuration();
                        //auto generate task ID
                        tasks.createTaskID();
                        //prompt for task status
                        tasks.setTaskStatus(JOptionPane.showInputDialog(null, "Task status (to do/doing/done): ", "Task " + tasknum, JOptionPane.PLAIN_MESSAGE));
                        //print task details
                        JOptionPane.showMessageDialog(null,tasks.printTaskDetails() , "Task " + tasknum, JOptionPane.PLAIN_MESSAGE);      
                        //populate developer array
                        search.populateDeveloper(i, tasks.getDevName()); 
                        //populate taskName array
                        search.populateTaskNames(i, tasks.getTaskName());
                        //populate taskID array
                        search.populateTaskID(i, tasks.createTaskID());
                        //populate TaskDuration array
                        search.populateTaskDuration(i, tasks.getTaskDuration()); 
                        //populate taskStatus array
                        search.populateTaskStatus(i, tasks.getTaskStatus());                          
                    }
                    //total combined hours for all tasks
                    JOptionPane.showMessageDialog(null, tasks.returnTotalHours(totalHours) + " hours", "Total combined hours for all tasks: ", JOptionPane.PLAIN_MESSAGE);           
                    break;
                case 2:
                    //display report
                    JOptionPane.showMessageDialog(null, search.displayReport(), "Report", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 3: 
                    //search for all done tasks
                    JOptionPane.showMessageDialog(null, search.returnDoneTasks(), "Done Tasks", JOptionPane.PLAIN_MESSAGE);
                    break;
                    //display error if input is invalid 
                case 4:
                    //search for task with the longest duration
                    JOptionPane.showMessageDialog(null, search.returnLongestTask(), "Longest task", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 5:
                    //search for a task by task name
                    String searchTaskName = JOptionPane.showInputDialog(null, "Enter task name: ", "Search for a task by task name", JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(null, search.searchForTask(searchTaskName), "Search for a task by task name", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 6:
                    //search for all tasks by developer
                    String searchDev = JOptionPane.showInputDialog(null, "Enter developer name: ", "Search for all tasks by developer", JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(null, search.searchForAllDevTasks(searchDev), "Search for all tasks by developer name", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 7:
                    //delete task 
                    String deleteTask = JOptionPane.showInputDialog(null, "Enter task name: ", "Delete a task", JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(null, search.deleteTask(deleteTask), "Delete a task", JOptionPane.PLAIN_MESSAGE);
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "Invalid option", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            //options menu
            strSelection = JOptionPane.showInputDialog(null, "Select an option (enter corresponding number):" +
                                                             "\n\n1.Add tasks" +
                                                             "\n2.Show report" +
                                                             "\n3.Search for all done tasks" +
                                                             "\n4.Search for longest task" +
                                                             "\n5.Search for a task by task name" +
                                                             "\n6.Search all tasks by developer" +
                                                             "\n7.Delete a task" +
                                                             "\n8.Exit", "EasyKanban", JOptionPane.PLAIN_MESSAGE);
            intSelection = Integer.parseInt(strSelection);
        } 
        //quit
        JOptionPane.showMessageDialog(null, "Thank you", "Quit", JOptionPane.PLAIN_MESSAGE);
    }
}
        /*************************************************************************************************************
         * ***********************************************************************************************************
         * Title: Java JOptionPane
         * Author: GeeksforGeeks
         * Date: 2024
         * Availability: https://www.geeksforgeeks.org/java-joptionpane/
         * ***********************************************************************************************************
         *************************************************************************************************************/

        /*************************************************************************************************************
         * ***********************************************************************************************************
         * Title: Switch Statements in Java
         * Author: GeeksforGeeks
         * Date: 2024
         * Availability: https://www.geeksforgeeks.org/switch-statement-in-java/
         * ***********************************************************************************************************
         *************************************************************************************************************/

        /*************************************************************************************************************
         * ***********************************************************************************************************
         * Title: Arrays in Java
         * Author: GeeksforGeeks
         * Date: 2024
         * Availability: https://www.geeksforgeeks.org/arrays-in-java/
         * ***********************************************************************************************************
         *************************************************************************************************************/
