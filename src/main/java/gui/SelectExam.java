package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SelectExam extends Application {
	
	
	Text text1 = new Text(50, 50,"Vänligen välj ett prov:");
	
	//Textstr�ng som ska l�nkas till uppladdade prov fr�n server.
	Text text2 = new Text(50,50,"Prov i Desktopapplikationer 1");
		
	
	
	public void start (Stage primaryStage)  {
		
		// Give the stage a title.
		primaryStage.setTitle("Newtons prov");
		BorderPane rootborder = new BorderPane();
		
		// Create a scene.
		Scene scene2 = new Scene(rootborder, 750,600, Color.WHITE);
		primaryStage.setFullScreen(true);
		
		Text txtNewton = new Text("Newton");
		txtNewton.setFill(Color.WHITE);
		txtNewton.setFont(new Font("Droid Sans, sans-serif",15));
		
		//Create rounded rectangle to set the Newton Label.
		Rectangle roundRect = new Rectangle();
		roundRect.setX(1); 
		roundRect.setY(1); 
		roundRect.setWidth(180); 
		roundRect.setHeight(120); 
		roundRect.setArcWidth(10); 
		roundRect.setArcHeight(20);
		roundRect.setFill(Color.ORANGE);
		//roundRect.setNo
		
		
		
		//Set the roundRect with Newton label to upper left.
		HBox hBoxLeft = new HBox();
		//rootborder.setLeft(hBoxLeft);
		//hBoxLeft.setAlignment(Pos.TOP_LEFT);
		//hBoxLeft.getChildren().add(roundRect);
		rootborder.getChildren().add(roundRect);
				
		//Change Font and text size: text1.
		text1.setFont(new Font("Arial",20));
		text1.setFill(Color.BLACK);
		
		//Change Font and text size: text2.
		text2.setFont(new Font("Arial",15));
		text2.setFill(Color.ORANGE);
		
		BorderPane bordercenter = new BorderPane();
		BorderPane borderunder = new BorderPane();		
		//Set the text1 in the upper center.
		rootborder.setTop(bordercenter);
		bordercenter.setMargin(text1, new Insets(100,100,100,100));
		bordercenter.setCenter(text1);
		//Set the text2 underneath
		rootborder.setCenter(borderunder);
		borderunder.setMargin(text2,new Insets (10,10,10,10));
		borderunder.setCenter(text2);
				
		// Set the scene on the stage.
		primaryStage.setScene(scene2);
		primaryStage.show();	
		
}

	public static void main(String[] args) {
    Application.launch(args);
    
	}


}
