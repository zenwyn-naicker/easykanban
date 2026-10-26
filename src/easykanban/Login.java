/*Author: Zenwyn Naicker*/
package easykanban;
public class Login 
{
    //data field
    private String username;
    private String password;
    private boolean isLoginSuccessful;
    private String loginStatus;
    //constructor
    public Login()
    {
        this.username = "";
        this.password = "";
        this.isLoginSuccessful = false;
        this.loginStatus = "";
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
    //methods checks if Login username and password match Register username and password
    public boolean loginUser(String username, String password)
    {
        //checks if login is successful or not
        if (this.username.equals(username) && this.password.equals(password))
        {
            isLoginSuccessful = true;
        }
        else
        {
            isLoginSuccessful = false;
        }
        return isLoginSuccessful;
    }
    //method checks login status and returns it as a String
    public String returnLoginStatus(String name, String surname)
    {
        //login successful
        if (isLoginSuccessful)
        {
            loginStatus = "Login successful" +
                        "\nwelcome " + name + ", " + surname + " it's great to see you again.";
        }
        //login failed
        else
        {
            loginStatus = "Login failed" +
                        "\nUsername or password incorrect, please try again";
        }
        return loginStatus;
    } 
}

