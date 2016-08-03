package client;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Madhavi Ruwandika on 8/2/2016.
 */
public class TCPClient {

    private  Socket clientSocket;
    private  DataOutputStream outToServer;

    public TCPClient(){
    }

    // method for send Action
    public  void sendAction(Derection d){
        String msg = getValue(d);
        try {
            outToServer.writeBytes(msg + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // start client
    public  void startClient(){
        try {
            clientSocket = new Socket("localhost", 6789);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // close the client
    public  void CloseClient(){
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get value of the action
    public static String getValue(Derection d){
        String a = "";
        switch (d){
            case UP:
                a=Derection.UP.msg;
                break;
            case DOWN:
                a=Derection.DOWN.msg;
                break;
            case LEFT:
                a=Derection.LEFT.msg;
                break;
            case RIGHT:
                a=Derection.RIGHT.msg;
                break;
            default:
                break;
        }
        return a;
    }

    // Derection
    public enum Derection{
        // constants
        UP("UP"),DOWN("DOWN"),LEFT("LEFT"),RIGHT("RIGHT");
        String msg;
        Derection(String msg){
            this.msg = msg;
        }
    }

}


