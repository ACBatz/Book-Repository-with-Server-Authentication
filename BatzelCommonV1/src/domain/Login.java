/*
 * Class Name:  Login
 * Description: This class is common to the library and server applications and contains attributes that are common to loggin into a system.
 */

package domain;

import java.io.Serializable;

/**
 * @author Andrew
 * @version 1
 * Created:  08/14/2015
 */
public class Login implements Serializable {
    private String userName;
    private char[] password;
    
    public Login() {
        userName = null;
        password = null;
    }
    
    public Login(String userName, char[] password) {
        this.userName = userName;
        this.password = password;
    }
    
    public String getUserName () {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public char[] getPassword() {
        return password;
    }
    
    public void setPassword(char[] password) {
        this.password = password;
    }
}