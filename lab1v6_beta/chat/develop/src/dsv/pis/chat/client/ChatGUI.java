package dsv.pis.chat.client;

import dsv.pis.chat.client.ChatClient;
import dsv.pis.chat.server.ChatServerInterface;
import dsv.pis.chat.server.ChatServer;
import dsv.pis.chat.server.ChatNotification;

import javax.swing.*;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

public class ChatGUI extends ChatClient{

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;

    private JPanel controlPanel;

    public static JLabel messagesLabel;
    public static JButton sendButton;

    public JTextArea msgTextArea;
    public static boolean sendButtonPressed = false;

    public static JScrollPane scrollPane;

    private String myName;
    private dsv.pis.chat.server.ChatServerInterface myServer;
    /**
     * Creates a new ChatClient instance.
     */
    public ChatGUI(String _myName, dsv.pis.chat.server.ChatServerInterface _myServer)
            throws IOException, ClassNotFoundException, RemoteException {
        myName = _myName;
        myServer = _myServer;
        init();
    }

    //public msgTextArea

    public void init(){
        System.out.println("Inne i chatgui!!!!");
        System.out.println("myName: " + myName);
        mainFrame = new JFrame("@Chat room");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        messagesLabel = new JLabel("",JLabel.CENTER);
        messagesLabel.setBackground(Color.blue);
        messagesLabel.setOpaque(true);

        msgTextArea = new JTextArea("", 5, 10);
        sendButton = new JButton("Send message bro");

        scrollPane = new JScrollPane(msgTextArea);

        statusLabel.setSize(350,100);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.add(messagesLabel);
        controlPanel.add(scrollPane);
        controlPanel.add(sendButton);

        mainFrame.setVisible(true);
        controlPanel.setVisible(true);

        writeMSG();

    }
    void writeMSG(){
        //headerLabel.setText("Control in action: JTextArea");
        //sendButton.addActionListener(e -> statusLabel.setText(msgTextArea.getText()));
        System.out.println("before");
        sendButton.addActionListener(e -> {
            sendButtonPressed = true;
            //System.out.println("inside: " + this.myName + " " + msgTextArea.getText());
            //sendToChat(myName + ": " + msgTextArea.getText());
            sendToReadLoop(msgTextArea.getText());
        });
        System.out.println("after");
        mainFrame.setVisible(true);
        controlPanel.setVisible(true);
    }
    public boolean isNewMSG(){
        if(sendButtonPressed) {
            sendButtonPressed = false;
            return true;
        }
        else return false;
    }
    //add a message to the label. Add linebreak between every msg
    static void addMSG(String msg){
        String current2 = formatString(messagesLabel.getText());
        messagesLabel.setText("<html>" + current2 + "<br>" + msg + "</html>");
    }
    //Substring away the html parts
    public static String formatString(String str){
        if (str.length() > 0){
            return(str.substring(6, str.length() - 6));
        }
        else {
            return "";
        }
    }
}
