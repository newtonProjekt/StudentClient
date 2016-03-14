package logic;

import beans.Login;
import beans.SchoolTest;
import gui.LoginBox;
import gui.SelectExam;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import network.CommandHandler;
import network.NetworkConnection;

import java.util.List;

/**
 * Application entry class. Starts network and login routines.
 *
 * Created by Johan Lindström (jolindse@hotmail.com) on 2016-03-11.
 */
public class App extends Application{

	private SchoolTest currTest;
	private CommandHandler ch;
	private LoginBox loginBox;
	private Stage primaryStage;
	private String loginName, password;

	private boolean loggedIn = false;

	public static void main(String[] args) {
		launch(args);
	}


	/**
	 * Inits the network loop and commandhandler.
	 *
	 * @throws Exception
	 */
	@Override
	public void init() throws Exception {
		super.init();
		NetworkConnection nc = new NetworkConnection("127.0.0.1",3004);
		ch = new CommandHandler(this);
		nc.setCommandHandler(ch);
		Thread networkThread = new Thread(nc);
		networkThread.start();
	}

	/**
	 * Shows loginbox and waits for login.
	 *
	 * @param primaryStage
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		loginBox = new LoginBox(this);
		loginBox.showAndWait();


	}

	/**
	 * Should send the list of available tests to the selectexam routine.
	 *
	 * @param availableTests
	 */
	public void showTestBox(List<SchoolTest> availableTests){
		Platform.runLater(() ->{
			SelectExam selectGui = new SelectExam(primaryStage, availableTests);
		});
	}

	// LOGIN METHODS

	/**
	 * Send logincommand if user is not allready logged in.
	 *
	 * @param persNumber
	 * @param password
	 */
	public void doLogin(String persNumber, String password){
		loginName = persNumber;
		this.password = password;
		if (!loggedIn) {
			Login currLogin = new Login(loginName, this.password, true);
			ch.send("login", currLogin);
		}
	}

	/**
	 * Sets the login ok.
	 */
	public void loginOk(){
		loggedIn=true;
		Platform.runLater(() ->{
			loginBox.close();
		});

	}

	/**
	 * Shows error message if login failed.
	 */
	public void loginFailed(){
		loginBox.setErrorLabel("Login misslyckades.");
	}

	public void doTest(SchoolTest test){
		currTest = test;

	}

}
