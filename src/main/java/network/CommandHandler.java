package network;

import beans.Message;
import beans.SchoolTest;
import com.google.gson.Gson;
import logic.App;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Johan Lindström (jolindse@hotmail.com) on 2016-03-11.
 */
public class CommandHandler {

    private Gson gson = new Gson();
    private NetworkConnection server;
    private App controller;

    public CommandHandler(App controller) {
        this.controller = controller;
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

            case "gettestlist":

                List<SchoolTest> testList = gson.fromJson(cmdData.get(0),List.class);

                controller.showTestBox(testList);
                break;
            case "loginok":
                controller.loginOk();
                break;
            case "loginfailed":
                controller.loginFailed();
                break;
            default:
                // do nothing
        }
    }
}