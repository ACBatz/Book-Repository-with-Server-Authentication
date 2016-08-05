/*
 * Test case for invalid/valid login credentials
 */
package library.business;

import domain.Login;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Andrew
 * @version 1
 * Created:  08/15/2015
 */
public class AuthenticationMgrTest {
    
    public AuthenticationMgrTest() {
    }

    /**
     * Test of authenticate method, of class AuthenticationMgr.
     */
    @Test
    public void testAuthenticate() throws Exception {
        System.out.println("authenticate");
        //Login login = null;
        Login login = new Login();
        login.setUserName("andrew");
        char[] password = {'1','1','2','3','4','5'};
        login.setPassword(password);
        AuthenticationMgr instance = new AuthenticationMgr();
        boolean expResult = false;
        boolean result = instance.authenticate(login);
        // Test for true
        assertEquals(expResult, result);
        char[] password2 = {'0','1','2','3','4','5'};
        login.setPassword(password2);
        expResult = true;
        result = instance.authenticate(login);
        // Test for true
        assertEquals(expResult, result);
    }
}