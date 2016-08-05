/*
 * Class Name:  ConnectionMgr
 * Description: This class initiates a listening port and delegates requests
 */
package server.business;

import java.io.*;
import java.net.*;

/**
 * @author Andrew
 * @version 2
 * Created:  08/15/2015
 * Modified: 08/19/2015 -> Class is now suitable to run multiple threads
 */
public class ConnectionMgr {
    
    public void listen() throws IOException {
       ServerSocket server = null;
       boolean exit = false;
        try {
            server = new ServerSocket(9000, 100);
            while (!exit) {
                SocketMgr socketMgr;
                socketMgr = new SocketMgr(server.accept());
                Thread thread = new Thread(socketMgr);
                thread.start();
            }
        }
        catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            System.exit(-1);
        }
        finally {
            server.close();
        }
    }   
}