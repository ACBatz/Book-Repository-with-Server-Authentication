/*
 * Class Name:  IAuthenticationSvc
 * Description: This is an interface to that captures what this service does without how the action is performed
 */
package library.services;

import domain.Login;

/**
 * @author Andrew
 * @version 1
 * Created:  08/15/2015
 */
public interface IAuthenticationSvc extends IService {
    
    public boolean authenticate(Login login) throws Exception;
}