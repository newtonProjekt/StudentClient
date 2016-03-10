package gui;
// THIS CLASS SHOWS THE EXAM-QUESTIONS-TYPES.

import java.util.ArrayList;
import java.util.List;

import beans.Answer;
import beans.MakeTest;
import beans.Question;
import beans.SchoolTest;
// CREATE METHOD TO EITHER SHOW MULTIPLE OR OPEN TEXT QUESTION-TYPES.
/**
 * Gui main class
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainWindow extends Application {
	//Create object of class Prov.
	Prov p = new Prov();
	
	public static int currentQuestionNr=0;
	
	//Create object of class Questions.
	Question q = new Question();
	
	//Create object of MakeTest.
	MakeTest mt = new MakeTest();
	
	//Create instance of SchoolTest.
	SchoolTest st = new SchoolTest();
	
	
	
	//Create a Array to keep the no. of check-boxes.
	//CheckBox cb[] = new CheckBox[3];
	
	
	CheckBox cbramverk;
	CheckBox cbscript;
	CheckBox cbdatatyp;
	CheckBox cbinget;
	
	TextArea txtQuestion;
	Label lblTxtQuestion;
	
	Label response;
	Label selected;
	Label questionText = new Label();
	String svar;
	
	FlowPane rootFlow = new FlowPane(Orientation.VERTICAL, 10, 10);
	
	public void setMakeTest(SchoolTest y) {
		this.st = y;
		
	}
	
	
	// Create method to display multiple-question type in GUI.
			public void showQuestionType() {
				st = mt.initTest();
				List<Question> questionList = new ArrayList<>();
				List<Answer> answerlist = new ArrayList<Answer>();
				questionList=st.getQuestions();
				q=questionList.get(currentQuestionNr);
				questionText.setText(q.getQuestionText());
				rootFlow.getChildren().add(questionText);
				if (q.isMultiQuestion()== true) {
					answerlist = q.getAnswers();
					CheckBox cb[] = new CheckBox[answerlist.size()];
					for (int x=0; x<answerlist.size();x++) {
						//cb[x].setText(answerlist.get(x).getAnswerText());
						cb[x]=new CheckBox(answerlist.get(x).getAnswerText());
						rootFlow.getChildren().add(cb[x]);						
					}
					
				}else {
					TextArea txtAnswer = new TextArea();
					rootFlow.getChildren().add(txtAnswer);
				}
				
				//rootFlow.getChildren().addAll(cb);
			}
	
	
			
	public void start (Stage primaryStage)  {
		
		// Give the stage a title.
		primaryStage.setTitle("Newtons prov");
		BorderPane rootborder = new BorderPane();
		// Create a scene.
		Scene scene3 = new Scene(rootborder, 750,600, Color.WHITE);
					
		primaryStage.setFullScreen(true);
							
			
		// TRY W BorderPane: To set buttons and labels to left and right.
		BorderPane bordertop = new BorderPane();
		BorderPane borderbottom = new BorderPane();
		rootborder.setTop(bordertop);
		rootborder.setBottom(borderbottom);
		
		// To set lblQuestion1 and checkbox questions in center.
		//rootFlow = new FlowPane(Orientation.VERTICAL, 10, 10);
		rootFlow.setAlignment(Pos.CENTER);
		rootborder.setCenter(rootFlow);
		
		// Create a label to a question 1.
		Label lblQuestion1 = new Label("Vad är JavaFx?");
						
		// Create the check boxes.
		cbramverk = new CheckBox("Ett ramverk");
		cbscript = new CheckBox("Ett scripspråk");
		cbdatatyp = new CheckBox("En datatyp");
		cbinget = new CheckBox("Inga av de angivna");
				
		// Set label lblQuestion1 center in FlowPane.
		//10 mars: rootFlow.getChildren().addAll(lblQuestion1, cbramverk, cbscript,
		//10 mars: cbdatatyp, cbinget);
		
		//10 mars: Set the showMultiQuestion() method in flowPane.
		//rootFlow.getChildren().addAll(showMultiquestion());
		
		//Set txtQuestion and lblTxtQuestion in center.
		//FlowPane txtRootFlow = new FlowPane(Orientation.VERTICAL,10,10);
		//txtRootFlow.setAlignment(Pos.CENTER);
		//rootborder.setCenter(txtRootFlow);
		//txtRootFlow.getChildren().addAll(lblTxtQuestion,txtQuestion);
							
		// Create button: "Lämna in prov"
		Button btnInlamning = new Button("Lämna in prov");
		bordertop.setMargin(btnInlamning, new Insets(12,12,12,12));
		bordertop.setRight(btnInlamning);
				
		// BUTTON: "Nästa"
		Button btnNasta = new Button ("Nästa");
		borderbottom.setMargin(btnNasta, new Insets(12,12,12,12));
		borderbottom.setRight(btnNasta);
		
		// Handle the action event for btnNasta.
		btnNasta.setOnAction(new EventHandler<ActionEvent>() {
	  		public void handle (ActionEvent ae) {
	  			//Show the next exam-question
	  			{
	  	  			//primaryStage.close();
	  	  			//Stage stage = new Stage();
	  	  		    // Create instance of the MainWindow.java class
	  	  			//MainWindow mw = new MainWindow();
	  	  			//mw.start(stage);
	  	  			//showQuestionType();
	  				rootFlow.getChildren().clear();
	  				currentQuestionNr++;
	  				showQuestionType();
	  	  		}
	  			}
	  	  		});
		
		// Create button: "Tillbaka"
		Button btnForra = new Button ("Tillbaka");
		borderbottom.setMargin(btnForra, new Insets(12,12,12,12));
		borderbottom.setLeft(btnForra);
		
		btnForra.set
	  			
		// Create label for "Fråga 1/20".
		Label lblFragaNr = new Label("Fråga 1/" + p.getExQuestions());
		bordertop.setMargin(lblFragaNr,new Insets (12,12,12,12));
		bordertop.setLeft(lblFragaNr);
		
		
		
		// Create a label for "Återstående tid: 27 min.".
		Label lblTid = new Label ("Återstående tid: 27 min");
		borderbottom.setMargin(lblTid, new Insets(12,12,12,12));
		borderbottom.setCenter(lblTid);
										
		// Set the scene on the stage.
		primaryStage.setScene(scene3);
		primaryStage.show();	
		}
	
			
	public static void main(String[] args) {
        Application.launch(args);
    }

	
}

//Handle action events for the check boxes
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
		
		// Handle the action events for the "Starta Prov"-button.
		//public String multiChoiceShow() {
		//if (spv.btnStart)
			
		//}
		
														
		// Update and show the selections.
		//void showAll() {
			//svar= " ";
			//if (cbramverk.isSelected())svar = "Ett ramverk";
			//if (cbscript.isSelected()) svar = "Ett scriptspråk";
			//if (cbdatatyp.isSelected()) svar = "En datatyp";
			//if (cbinget.isSelected()) svar = "Inga av de angivna";
			
			//selected.setText("Du svarade:" + svar);
