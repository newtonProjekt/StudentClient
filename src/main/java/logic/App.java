package logic;

import beans.Login;
import beans.SchoolTest;
import gui.LoginBox;
import gui.SelectExam;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import network.CommandHandler;
import network.NetworkConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Application entry class. Starts network and login routines.
 * <p>
 * Created by Johan Lindström (jolindse@hotmail.com) on 2016-03-11.
 */
public class App extends Application {
    private SelectExam selectEx;
    private SchoolTest currTest;
    private CommandHandler ch;
    private LoginBox loginBox;
    private Stage primaryStage ;
    private String loginName, password;
    private NetworkConnection nc;

    private boolean loggedIn = false;
    private boolean testStarted = false;
    private boolean loginFlag = true;

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
        initNetwork();
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
			if(testStarted == false){
				SelectExam selectGui = new SelectExam(primaryStage, availableTests, this);
			}
		});
	}

  

    // LOGIN METHODS

    /**
     * Send logincommand if user is not allready logged in.
     *
     * @param persNumber
     * @param password
     */
    public void doLogin(String persNumber, String password,boolean loginFlag) {
        loginName = persNumber;
        this.password = password;
        this.loginFlag = loginFlag;
        //if (!loggedIn) {
            Login currLogin = new Login(loginName, this.password, this.loginFlag);
            ch.send("login", currLogin);
        //}
    }

    /**
     * Sets the login ok.
     */
    public void loginOk() {
        loggedIn = true;
        Platform.runLater(() -> {
            loginBox.close();
            if(testStarted==false){
            	primaryStage.show();
            }
        });

    }

    /**
     * Shows error message if login failed.
     */
    public void loginFailed() {
        loginBox.setErrorLabel("Login misslyckades.");
    }

    public void doTest(SchoolTest test) {
        currTest = test;

    }
    
    /**
     * Initializes the networkconnection and starts the newtwork-thread.
     */
    public void initNetwork() {
        nc = new NetworkConnection("localhost", 3004);
        ch = new CommandHandler(this);
        nc.setCommandHandler(ch);
        Thread networkThread = new Thread(nc);
        networkThread.start();
    }

    /**
     * sends a disconnect message to server to drop the connection.
     * disconnects the student
     */
    public void dropClient(){
    	
    	ch.send("disconnect", "");
    	nc.disconnectServer();
    	System.out.println("client disconnected!");
    	
    }
    
    /**
     * calls the dropclient-method and closes the program.
     */
    public void closeProgram(){
    	dropClient();
    	System.exit(0);
    }
    
    public String getPersNr(){
    	return loginName;
    }
    public String getPassword(){
    	return password;
    }
    public CommandHandler getCh(){
    	return ch;   
    }
    public boolean getloggedIn(){
    	return loggedIn;   
    }
    public boolean getTestStarted(){
    	return testStarted;
    }
    public void setTestStarted(boolean flag){
    	testStarted = flag;
    }
    
    public void displayDialogBox(){
    	//primaryStage.close();
    	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Info om Inlämning");
			alert.setHeaderText("Prov inlämnad");
			alert.setContentText("Ditt prov är nu inlämnad. Feedback kommer!");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				
				closeProgram();
			} 
    }
    
}
