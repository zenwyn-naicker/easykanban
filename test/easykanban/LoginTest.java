/*Author: Zenwyn Naicker*/
package easykanban;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    Login login = new Login();
    Register register = new Register();
 
    @Test
    public void testLoginUser() {
        //login username and password correct
        register.setUsername("Kyl_1");
        register.setPassword("Ch&&sec@ke99!");
        login.setUsername("Kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        assertTrue(login.loginUser(register.getUsername(), register.getPassword()));
        //login username and password incorrect
        login.setUsername(" ");
        login.setPassword(" ");
        assertFalse(login.loginUser(register.getUsername(), register.getPassword()));
    }

    @Test
    public void testReturnLoginStatus() {
        //login username and password correct
        register.setUsername("Kyl_1");
        register.setPassword("Ch&&sec@ke99!");
        register.setName("Zenwyn");
        register.setSurname("Naicker");
        register.checkUserName();
        register.checkPasswordComplexity();
        login.setUsername("Kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.loginUser(register.getUsername(), register.getPassword());
        String expected = "Login successful" +
                        "\nwelcome " + register.getName() + ", " + register.getSurname() + " it's great to see you again.";
        String actual = login.returnLoginStatus(register.getName(),register.getSurname());
        assertEquals(expected, actual); 
        //login username and password incorrect
        register.setUsername("Kyl_1");
        register.setPassword("Ch&&sec@ke99!");
        register.setName("Zenwyn");
        register.setSurname("Naicker");
        register.checkUserName();
        register.checkPasswordComplexity();
        login.setUsername(" ");
        login.setPassword(" ");
        login.loginUser(register.getUsername(), register.getPassword());
        String expected2 = "Login failed" +
                        "\nUsername or password incorrect, please try again";
        String actual2 = login.returnLoginStatus(register.getName(),register.getSurname());
        assertEquals(expected2, actual2); 
    }
    
}