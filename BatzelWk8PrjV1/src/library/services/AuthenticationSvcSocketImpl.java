/*
 * Class Name:  AuthenticationSvcSocketImpl
 * Description: This class creates a connection to the server application and passes in a Login object
 */
package library.services;

import domain.Login;
import java.io.*;
import java.net.*;

/**
 * @author Andrew
 * @version 1
 * Created:  08/15/2015
 */
public class AuthenticationSvcSocketImpl implements IAuthenticationSvc {
    
    public boolean authenticate(Login login) {
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        boolean loginSuccess = false;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9000);
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(login);
            loginSuccess = (boolean)in.readObject();
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (Exception e) {
                System.out.println("Exception " + e.getMessage());
                        }
            }
        return loginSuccess;
    }
}