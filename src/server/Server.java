package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    Server(int port)
    {
        try {
            serverSocket = new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                serve(socket);
            }
        } catch (Exception e){
            System.out.println("In server constructor: exception caught: " + e);
        }
    }

    void serve(Socket socket){
        NetworkUtil nc = new NetworkUtil(socket);
        new Thread(() -> {
            while(true)
                nc.read();
        }).start();
        /*new Thread(() -> {
            while(true)
                nc.write();
        }).start();*/
    }

    public static void main(String[] args) throws Exception {
	    // write your code here
        Server server = new Server(6987);
    }
}
