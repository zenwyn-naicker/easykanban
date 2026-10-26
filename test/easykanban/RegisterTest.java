/*Author: Zenwyn Naicker*/
package easykanban;

import org.junit.Test;
import static org.junit.Assert.*;

public class RegisterTest {
    Register register = new Register();

    @Test
    public void testCheckUserName() {
        register.setUsername("Kyl_1");
        assertTrue(register.checkUserName());
        register.setUsername("Kyle!!!!!!");
        assertFalse(register.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity() {
        register.setPassword("Ch&&sec@ke99!");
        assertTrue(register.checkPasswordComplexity());
        register.setPassword("password");
        assertFalse(register.checkPasswordComplexity());
    }

    @Test
    public void testRegisterUser() {
        //correct username and password formats
        register.setUsername("Kyl_1");
        register.setPassword("Ch&&sec@ke99!");
        register.checkUserName();
        register.checkPasswordComplexity();
        String expected = "Username successfully captured" +
                        "\nPassword successfully captured" +
                        "\nRegistration Successful";
        String actual = register.registerUser();
        assertEquals(expected, actual);
        //Incorrect username and password formats
        register.setUsername("Kyle!!!!!!");
        register.setPassword("password");
        register.checkUserName();
        register.checkPasswordComplexity();
        String expected2 = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length." +
                        "\nPassword is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character." +
                        "\nRegistration Failed";
        String actual2 = register.registerUser();
        assertEquals(expected2, actual2);
    }
    
}