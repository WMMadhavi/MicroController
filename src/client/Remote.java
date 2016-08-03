package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Madhavi Ruwandika on 8/3/2016.
 */
public class Remote {
    private JButton button;
    private JPanel panel1;
    static TCPClient tcpClient;

    public Remote() {
        // create communicator to send message
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tcpClient.startClient();
                tcpClient.sendAction(TCPClient.Derection.DOWN);
                tcpClient.CloseClient();
            }
        });
    }

    public static void main(String[] args) {

        tcpClient = new TCPClient();
        JFrame frame = new JFrame("Remote");
        frame.setContentPane(new Remote().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
