package gui;

import beans.MakeTest;
import beans.SchoolTest;

// THIS CLASS SHOWS THE EXAM SELECTIONS WHICH THE STUDENT CAN SELECT.

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.App;

public class StartaProvView extends Application {
	
		protected static final String MainWindow = null;

		// Create instance of the MainWindow.java class
		MainWindow mw = new MainWindow();		
		// Create instance of Maketest.
		MakeTest mt = new MakeTest();
		// Create instance of SchoolTest.
		SchoolTest schooltest = new SchoolTest();
		//public static Stage stage;
		
		App app;
		// "Start prov" knappen
		Button btnStart = new Button ("Starta provet");
			
public void start (Stage primaryStage)  {
		
		
		// Give the stage a title.
		primaryStage.setTitle("Newtons prov");
		BorderPane rootborder = new BorderPane();
		// Create a scene.
		Scene scene3 = new Scene(rootborder, 750,600, Color.WHITE);
					
		primaryStage.setFullScreen(true);
												
		BorderPane bordercenter = new BorderPane();
		// Set the button "Starta prov".
		rootborder.setBottom(bordercenter);
		bordercenter.setMargin(btnStart, new Insets (90,90,90,90));
		bordercenter.setCenter(btnStart);
				
		// Create TextArea to set info about the Exam.
		TextArea txtInfo = new TextArea();
		int maxGpoang = 0;
		int maxVGpoang = 0;
		for(int x =0 ; x<schooltest.getQuestions().size() ; x++){
			maxGpoang += schooltest.getQuestions().get(x).getPoints();
			if(schooltest.getQuestions().get(x).isVgQuestion()){
				maxVGpoang += 1 ;
			}
			
		}
		String info = "Testnamn: " + schooltest.getName() + "\nMax G-poäng: " + maxGpoang + 
				"\nMax VG-poäng: " + maxVGpoang +   
				"\nTid för testet: " + schooltest.getTestTime() + " minuter";
		txtInfo.setText(info);
		
				
		// To set the TextArea with the Exam-rules.
		FlowPane rootFlow = new FlowPane(Orientation.VERTICAL, 10, 10);
		rootFlow.setAlignment(Pos.CENTER);
		rootborder.setCenter(rootFlow);
		rootFlow.getChildren().add(txtInfo);
		
		// BUTTON: STARTA PROV.
  		btnStart.setOnAction(new EventHandler<ActionEvent>() {
  		public void handle (ActionEvent ae) {
  			primaryStage.close();
  			//Stage stage = new Stage();
  		    // Create instance of the MainWindow.java class
  			  MainWindow mw = new MainWindow();
  			  mw.setTestAndApp(schooltest,app);
  			  mw.start(primaryStage);
  			  mw.showQuestionType();
  			  mw.countdown();
  			  app.getCh().send("starttest", schooltest.getId());
  			  app.dropClient();
  			  app.setTestStarted(true);
  			
  		}
  		});
				
		// Set the scene on the stage.
		primaryStage.setScene(scene3);
		primaryStage.show();
	}

	 
     
	public void setSchoolTest(SchoolTest schooltest){
		this.schooltest = schooltest;
	}
      
	public void setApp(App app){
		this.app = app;
	}


}
