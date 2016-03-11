package network;

import beans.Message;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Johan Lindström (jolindse@hotmail.com) on 2016-03-11.
 */
public class CommandHandler {

    private Gson gson = new Gson();
    private NetworkConnection server;


    public CommandHandler() {
        gson = new Gson();
    }

    public void registerServer(NetworkConnection server){
        this.server = server;
    }

    public <T> void send(String cmd, T cmdData) {
        Message currMessage = new Message(cmd, cmdData);

        System.out.println(currMessage);
        server.send(gson.toJson(currMessage));
    }

    public void parse(String jsonData) {
        Message currMessage = gson.fromJson(jsonData, Message.class);
        List<String> cmdData = currMessage.getCommandData();

        switch (currMessage.getCommand()) {

            case "getalltests":
                System.out.println("Hej?");
                cmdData.forEach(test -> {
//                    SchoolTest schoolTest = gson.fromJson(test, SchoolTest.class);
                    System.out.println(test+"\n");
                    //adminController.addTest(schoolTest);

                });
                break;



        }
    }
}