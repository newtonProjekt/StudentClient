package gui;
/*
 * This SelectExam class illustrates the links of available exams in which logged in
 * students can choose.
 */

import beans.SchoolTest;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class SelectExam {
	
	//Text of "V�nligen v�lj ett prov"
	Text text1 = new Text(450, 200,"V�nligen v�lj ett prov:");
	
	//Textstr�ng som ska l�nkas till uppladdade prov fr�n server.
	Text text2 = new Text(450,230,"Prov i Desktopapplikationer 1");
	
	TableRow table1;
		
	
	
	public SelectExam (Stage primaryStage, List<SchoolTest> testList)  {
		
		// Give the stage a title.
		primaryStage.setTitle("Newtons prov");
		BorderPane rootborder = new BorderPane();
		
		// Create a scene.
		Scene scene2 = new Scene(rootborder, 750,600, Color.WHITE);
		primaryStage.setFullScreen(true);
		
		//Modified text of Newton, set on the roundRect rectangle as Newton label.
		Text txtNewton = new Text("Newton");
		txtNewton.setFill(Color.WHITE);
		txtNewton.setFont(new Font("Sans-serif, bold",30));

		//Create rounded rectangle to set the Newton Label.
		Rectangle roundRect = new Rectangle();
		roundRect.setX(1); 
		roundRect.setY(1); 
		roundRect.setWidth(2800); 
		roundRect.setHeight(120); 
		roundRect.setArcWidth(10); 
		roundRect.setArcHeight(20);
		roundRect.setFill(Color.ORANGE);

		//Set the roundRect with Newton label to upper left.
		StackPane stackpane = new StackPane();
		stackpane.getChildren().addAll(roundRect,txtNewton);
		stackpane.setLayoutX(65);
		stackpane.setLayoutY(65);
		rootborder.getChildren().addAll(stackpane);
						
		//Change Font and text size: text1.
		text1.setFont(new Font("Arial",20));
		text1.setFill(Color.BLACK);

		//Change Font and text size: text2.
		text2.setFont(new Font("Arial",15));
		text2.setFill(Color.ORANGE);
		
		// BUTTON: "AVBRYT"
		Button btnAvbryt = new Button("Avbryt");
		VBox vbox1 = new VBox();
		vbox1.setPadding(new Insets(3));
		vbox1.setMargin(btnAvbryt, new Insets(400,450,450,450));
		vbox1.getChildren().add(btnAvbryt);
		rootborder.setCenter(vbox1);		
		btnAvbryt.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent ae){
				primaryStage.close();
			}
		});
		
		rootborder.getChildren().addAll(text1, text2);
		
				
		// Set the scene on the stage.
		primaryStage.setScene(scene2);
		primaryStage.show();	
		
}


}
