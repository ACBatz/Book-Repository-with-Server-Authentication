/*
 * Class Name:  SocketMgr
 * Description: This class takes a socket request, casts the stream object to type Login, and verifies that a user name and password match
 */
package server.business;


import domain.Login;
import java.io.*;
import java.net.*;
import java.util.Arrays;

/**
 * @author Andrew
 * @version 2
 * Created:  08/15/2015
 * Modified: 08/19/2015 -> Class now implements Runnable class and has a run method to be used as a Thread
 */
public class SocketMgr implements Runnable {
    private Socket clientSocket = null;
    private String userName = "andrew";
    private char[] password = {'0','1','2','3','4','5'};
    private boolean auth = false;
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;
    private Login login = new Login();
    
    public SocketMgr(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override    
    public void run() {

        try {
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            login = (Login)in.readObject();
            if (userName.contentEquals(login.getUserName()) && Arrays.equals(password, login.getPassword())) {
                auth = true;
                out.writeObject(auth);
            }
            else {
                auth = false;
                out.writeObject(auth);
            }
            out.close();
            in.close();
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println("Authentication exception: " + ex.getMessage());
        }
    }
}