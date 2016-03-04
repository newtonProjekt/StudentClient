package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainWindow extends Application {
	
	CheckBox cbramverk;
	CheckBox cbscript;
	CheckBox cbdatatyp;
	CheckBox cbinget;
	
	Label response;
	Label selected;
	
	String svar;
		
		
	
	public void start (Stage primaryStage)  {
		
		// Give the stage a title.
		primaryStage.setTitle("Newtons prov");
		BorderPane rootborder = new BorderPane();
		// Create a scene.
		Scene myScene = new Scene(rootborder, 750,600, Color.WHITE);
					
		primaryStage.setFullScreen(true);
							
			
		// TRY W BorderPane: To set buttons and labels to left and right.
		BorderPane bordertop = new BorderPane();
		BorderPane borderbottom = new BorderPane();
		rootborder.setTop(bordertop);
		rootborder.setBottom(borderbottom);
		

		// To set lblQuestion1 and checkbox questions in center.
		FlowPane rootFlow = new FlowPane(Orientation.VERTICAL, 10, 10);
		rootFlow.setAlignment(Pos.CENTER);
		rootborder.setCenter(rootFlow);
							
		// Create button: "Lämna in prov"
		Button btnInlamning = new Button("Lämna in prov");
		bordertop.setMargin(btnInlamning, new Insets(12,12,12,12));
		bordertop.setRight(btnInlamning);
		
		
		// Create button: "Nästa"
		Button btnNasta = new Button ("Nästa");
		borderbottom.setMargin(btnNasta, new Insets(12,12,12,12));
		borderbottom.setRight(btnNasta);

		
		// Create label for "Fråga 1/20".
		Label lblFragaNr = new Label("Fråga 1/20");
		bordertop.setMargin(lblFragaNr,new Insets (12,12,12,12));
		bordertop.setLeft(lblFragaNr);

		
		// Create button: "Tillbaka"
		Button btnForra = new Button ("Tillbaka");
		borderbottom.setMargin(btnForra, new Insets(12,12,12,12));
		borderbottom.setLeft(btnForra);
		
		// Create a label for "Återstående tid: 27 min.".
		Label lblTid = new Label ("Återstående tid: 27 min");
		borderbottom.setMargin(lblTid, new Insets(12,12,12,12));
		borderbottom.setCenter(lblTid);
						
		// Create a label to a question 1.
		Label lblQuestion1 = new Label("Vad är JavaFx?");
				
		// Create the check boxes.
		cbramverk = new CheckBox("Ett ramverk");
		cbscript = new CheckBox("Ett scripspråk");
		cbdatatyp = new CheckBox("En datatyp");
		cbinget = new CheckBox("Inga av de angivna");
		
		// Handle action events for the check boxes
		//cbramverk.setOnAction(new EventHandler<ActionEvent>(){
			//public void handle (ActionEvent ae) {
				//if(cbramverk.isSelected())
					//response.setText("Du valde ramverk");
					//else
						//response.setText("");
				//showAll();
			//}
		//});
		
		//cbscript.setOnAction(new EventHandler<ActionEvent>() {
			//public void handle (ActionEvent ae) {
				//if(cbscript.isSelected())
					//response.setText("Du valde scriptspråk");
				//else
					//response.setText("");
				//showAll();
			//}
		//});
							
				
		// Set label lblQuestion1 center in FlowPane.
		rootFlow.getChildren().addAll(lblQuestion1, cbramverk, cbscript,
				cbdatatyp, cbinget);
	
		
		// Update and show the selections.
		//void showAll() {
			//svar= " ";
			//if (cbramverk.isSelected())svar = "Ett ramverk";
			//if (cbscript.isSelected()) svar = "Ett scriptspråk";
			//if (cbdatatyp.isSelected()) svar = "En datatyp";
			//if (cbinget.isSelected()) svar = "Inga av de angivna";
			
			//selected.setText("Du svarade:" + svar);
		
		// Set the scene on the stage.
		primaryStage.setScene(myScene);
		primaryStage.show();	
		}
			
	public static void main(String[] args) {
        Application.launch(args);
    }

}
