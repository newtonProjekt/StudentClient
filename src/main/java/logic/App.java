package logic;

import beans.Login;
import gui.LoginBox;
import javafx.application.Application;
import javafx.stage.Stage;
import network.CommandHandler;
import network.NetworkConnection;

/**
 * Created by Johan Lindström (jolindse@hotmail.com) on 2016-03-11.
 */
public class App extends Application{

	private CommandHandler ch;

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// Initialize network and parsing
		NetworkConnection nc = new NetworkConnection("127.0.0.1",3004);
		ch = new CommandHandler();
		nc.setCommandHandler(ch);
		Thread networkThread = new Thread(nc);
		networkThread.start();

		// Display login window
		LoginBox loginBox = new LoginBox(this);
		loginBox.showAndWait();

	}

	public void doLogin(String persNumber, String password){
		Login currLogin = new Login(persNumber,password,true);
		ch.send("login",currLogin);
	}

}
