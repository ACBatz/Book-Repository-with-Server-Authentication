/*
 * Class Name:  AuthenticationServer
 * Description: This class in ran in conjunction with the library application to simulate the communication between a client application and a server.
 */
package server.business;

import java.io.IOException;

/**
 * @author Andrew
 * @version 1
 * Created: 08/15/2015
 */
public class AuthenticationServer { 
    
    /**
     * the main method is contained here and will initiate a the connections required to simulate the server
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ConnectionMgr connectionMgr = new ConnectionMgr();
        connectionMgr.listen();
    }   
}