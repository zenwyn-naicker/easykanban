/*Author: Zenwyn Naicker*/
package easykanban;
public class Register 
{
    //data field
    private String username;
    private String password;
    private String name;
    private String surname;
    private boolean isUsernameFormatCorrect;
    private boolean isPasswordFormatCorrect;
    //constructor
    public Register()
    {
        this.username = "";
        this.password = "";
        this.name = "";
        this.surname = "";
        this.isUsernameFormatCorrect = false;
        this.isPasswordFormatCorrect = false;
    } 
    //method sets username
    public void setUsername(String username)
    {
        this.username = username;
    }
    //method gets username
    public String getUsername()
    {
       return username;
    }
    //method sets password
    public void setPassword(String password)
    {
        this.password = password;
    }
    //method gets password
    public String getPassword()
    {
        return password;
    }
    //method sets name
    public void setName(String name)
    {
        this.name = name;
    }
    //method gets name
    public String getName()
    {
       return name;
    }
    //method sets surname
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    //method gets name
    public String getSurname()
    {
       return surname;
    }
    //method checks username for underscore and length
    public boolean checkUserName()
    {   
        final int MAX_LENGTH_5 = 5;
        boolean hasUnderscore = username.contains("_");
        int length = username.length();
        //checks if username format is correct
        if (hasUnderscore && length <= MAX_LENGTH_5)
        {
            isUsernameFormatCorrect = true;
        }
        else
        {
            isUsernameFormatCorrect = false;
        }
        return isUsernameFormatCorrect;
    }
    //method checks if password is at least 8 characters, has a capital letter, number and special character 
    public boolean checkPasswordComplexity()
    {
        final int MIN_LENGTH_8 = 8;
        int length = password.length();
        boolean hasCapitalLetter = !(password.equals(password.toLowerCase()));
        boolean hasNumber = false;
        boolean hasSymbol = false;
        int digitCounter = 0;
        int symbolCounter = 0;
        //loop checks each character and adds 1 to the counter if it is a digit
        for (int i = 0; i < length; i++)
        {
            if (Character.isDigit(password.charAt(i)))
            {
                digitCounter++;
            }
        }
        //does not contain a digit
        if (digitCounter == 0)
        {
            hasNumber = false;
        }
        //does contain a digit
        else
        {
            hasNumber = true;
        }            
        //loop checks each character and adds 1 to the counter if it is not a digit, a letter and a whitespace 
        for (int i = 0; i < length; i++)
        {
            if (!Character.isDigit(password.charAt(i))
                 && !Character.isLetter(password.charAt(i))
                 && !Character.isWhitespace(password.charAt(i)))
            {
                symbolCounter++;
            }    
        }
        //does not contain special character
        if (symbolCounter == 0 )
        {
            hasSymbol = false;
        }
        //does contain special character
        else
        {
            hasSymbol = true;
        }
        //checks if password format is correct
        if (length >= MIN_LENGTH_8 && hasCapitalLetter && hasNumber && hasSymbol)
        {
            isPasswordFormatCorrect = true;
        }
        else
        {
            isPasswordFormatCorrect = false;
        }
        return isPasswordFormatCorrect;
    }
    //method checks registration status and returns it as a String
    public String registerUser()
    {
        String registrationStatus = "";
        //Username successfully captured or not
        if (isUsernameFormatCorrect)
        {
            registrationStatus = "Username successfully captured";
        }
        else
        {
            registrationStatus = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } 
        //Password successfully captured or not
        if (isPasswordFormatCorrect)
        {
            registrationStatus += "\nPassword successfully captured";
        }
        else
        {
            registrationStatus += "\nPassword is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        //registration successfull or not
        if (isUsernameFormatCorrect && isPasswordFormatCorrect)
        {
            registrationStatus += "\nRegistration Successful";
        }
        else
        {
            registrationStatus += "\nRegistration Failed";
        }
        return registrationStatus;
    }
}
        /*************************************************************************************************************
         * ***********************************************************************************************************
         * Title: How to check if a string contains uppercase java
         * Author: Maurice
         * Date: 2020
         * Availability: https://stackoverflow.com/questions/60764388/how-to-check-if-a-string-contains-uppercase-java
         * ***********************************************************************************************************
         *************************************************************************************************************/

         /*************************************************************************************************************
         * ***********************************************************************************************************
         * Title: How to check if string contains only digits in Java
         * Author: GeeksforGeeks
         * Date: 2024
         * Availability: https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/
         * ***********************************************************************************************************
         *************************************************************************************************************/
         
         /**********************************************************************************************************************
         * ********************************************************************************************************************
         * Title: Java Program to Check Whether the String Consists of Special Characters
         * Author: GeeksforGeeks
         * Date: 2024
         * Availability: https://www.geeksforgeeks.org/java-program-to-check-whether-the-string-consists-of-special-characters/
         * ********************************************************************************************************************
         **********************************************************************************************************************/