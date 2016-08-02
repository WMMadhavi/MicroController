package client;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import static client.TCPClient.Derection.*;

/**
 * Created by Madhavi Ruwandika on 8/2/2016.
 */
public class TCPClient {

    public static void main(String argv[]) throws Exception
    {
        String sentence;
        ArrayList<Derection> myArray = new ArrayList<>();
        myArray.add(Derection.DOWN);
        myArray.add(Derection.DOWN);
        myArray.add(UP);
        myArray.add(Derection.LEFT);
        myArray.add(Derection.RIGHT);

        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        for( Derection d : myArray){
            sentence = getValue(d);
            outToServer.writeBytes(sentence + '\n');
        }
        clientSocket.close();
    }

    public enum Derection{
        UP("UP"),DOWN("DOWN"),LEFT("LEFT"),RIGHT("RIGHT");
        String msg;
        Derection(String msg){this.msg = msg;}

    }

    public static String getValue(Derection d){
        String a = "";
        switch (d){
            case UP:
                a=UP.msg;
                break;
            case DOWN:
                a=DOWN.msg;
                break;
            case LEFT:
                a=LEFT.msg;
                break;
            case RIGHT:
                a=RIGHT.msg;
                break;
            default:
                break;
        }
        return a;
    }

}


