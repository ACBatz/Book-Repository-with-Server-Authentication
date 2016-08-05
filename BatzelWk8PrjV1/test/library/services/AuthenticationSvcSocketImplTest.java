/*
 * Test cases for checking invalid/valid login credentials
 */
package library.services;

import domain.Login;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Andrew
 * @version 1
 * Created:  08/15/2015
 */
public class AuthenticationSvcSocketImplTest {
    
    public AuthenticationSvcSocketImplTest() {
    }

    /**
     * Test of authenticate method, of class AuthenticationSvcSocketImpl.
     */
    @Test
    public void testAuthenticate() throws Exception {
        System.out.println("authenticate");
        //Login login = null;
        Factory factory = new Factory();
        IAuthenticationSvc instance = (IAuthenticationSvc)factory.getService("IAuthenticationSvc");
        Login login = new Login();
        login.setUserName("andrew");
        char[] password = {'1','1','2','3','4','5'};
        login.setPassword(password);
        boolean expResult = false;
        boolean result = instance.authenticate(login);
        // Test for false
        assertEquals(expResult, result);
        char[] password2 = {'0','1','2','3','4','5'};
        login.setPassword(password2);
        result = instance.authenticate(login);
        expResult = true;
        // Test for true
        assertEquals(expResult,result);
    }
    
}
