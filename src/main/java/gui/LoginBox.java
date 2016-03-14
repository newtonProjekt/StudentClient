package gui;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.App;

/**
 * Loginbox based on loginbox from AdminClient.
 * <p>
 * Created by Johan Lindström (jolindse@hotmail.com) on 2016-03-11.
 */
public class LoginBox extends Stage {

	private App controller;

	//Components:
	private String userNameInput;
	private String passwordInput;
	private Text scenetitle = new Text("Studentlogin");
	private Image loginImage = new Image("file:images/logo-loginbox.png");
	private ImageView imageView = new ImageView(loginImage);
	private Label userNameLabel = new Label("Personnummer:");
	private Label passwordLabel = new Label("Lösenord:");
	private Label errorLabel = new Label();
	private TextField userTextField = new TextField();
	private PasswordField passwordField = new PasswordField();
	private Button loginButton = new Button("Logga in");
	private Button cancelButton = new Button("Avbryt");
	private HBox buttonHbox = new HBox(10);
	private Stage window;
	private GridPane grid = new GridPane();

	public LoginBox(App controller) {
		this.controller = controller;
		window = this;
		//the loginbox is in focus, the other stages is disabled:
		window.initModality(Modality.APPLICATION_MODAL);
		//No frame and no frame-buttons around the loginbox:
		window.initStyle(StageStyle.UNDECORATED);

		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		errorLabel.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
		errorLabel.setTextFill(Color.RED);
		userTextField.setPrefWidth(175);
		passwordField.setPrefWidth(175);

		//Add buttons to Hbox:
		buttonHbox.setAlignment(Pos.BOTTOM_RIGHT);
		buttonHbox.getChildren().addAll(cancelButton, loginButton);

		//Init gridpane:
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		//Add components to gridpane:
		grid.add(scenetitle, 0, 0);
		grid.add(imageView, 0, 5);
		grid.add(userNameLabel, 0, 1);
		grid.add(userTextField, 1, 1);
		grid.add(passwordLabel, 0, 2);
		grid.add(passwordField, 1, 2);
		grid.add(errorLabel, 1, 4);
		grid.add(buttonHbox, 1, 5);

		//Actionlistener for cancelbutton:
		cancelButton.setOnAction(event -> {
			System.exit(0);
			Platform.exit();
		});

		// Set action to login button
		loginButton.setOnAction((e) -> {
			controller.doLogin(userTextField.getText(), passwordField.getText());
		});

		Scene scene = new Scene(grid);
		window.setScene(scene);
	}

	public void setErrorLabel(String message) {
		Platform.runLater(() -> {
			errorLabel.setText(message);
		});
	}

	public void closeLogin(){
		Platform.runLater(() ->{
			window.close();
		});
	}

}
