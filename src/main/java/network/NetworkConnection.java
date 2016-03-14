package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class NetworkConnection implements Runnable {

    private Socket server;
    private boolean disconnect = true;
    private PrintWriter out;
    private CommandHandler commandHandler;

    public NetworkConnection (String IPADRESS, int PORT) {
        try {
            server = new Socket(IPADRESS,PORT);
            out = new PrintWriter(server.getOutputStream(),true);
            disconnect = false;
        } catch (IOException e) {
            System.out.println("NETWORKCONNECTION; Constructor: Unable to connect to server");
        }
    }

    public void setCommandHandler(CommandHandler commandHandler){
        this.commandHandler = commandHandler;
        commandHandler.registerServer(this);
    }

    public void send(String jsonData){
        out.println(jsonData);
    }

    public void run() {
        String logLine;
        while (!disconnect) {
            try {
                Scanner sc = new Scanner(server.getInputStream());

                while (sc.hasNextLine()) {
                    logLine = sc.nextLine();
                    System.out.println("FROM SERVER "+logLine); // TEST
                    commandHandler.parse(logLine);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnectServer(){
        disconnect = true;
    }
}