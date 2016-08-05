/*
 * Class Name:  AuthenticationMgr
 * Description: This class manages the data sent from the presentation layer and utilizes the service layer to login
 */
package library.business;


import domain.Login;
import library.services.Factory;
import library.services.IAuthenticationSvc;

/**
 * @author Andrew
 * @version 1
 * Created:  08/15/2015
 */
public class AuthenticationMgr {
    
    public boolean authenticate(Login login) throws Exception {
        Factory factory = new Factory();
        IAuthenticationSvc authenticationSvc = (IAuthenticationSvc)factory.getService("IAuthenticationSvc");
        return authenticationSvc.authenticate(login);
    }  
}