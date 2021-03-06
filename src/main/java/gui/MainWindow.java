package gui;
// The MainWindow class exhibits the question-types.

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import beans.Answer;
import beans.AnswerSubmited;
import beans.MakeTest;
import beans.Question;
import beans.SchoolTest;
import beans.SubmittedTest;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
// CREATE METHOD TO EITHER SHOW MULTIPLE OR OPEN TEXT QUESTION-TYPES.
/**
 * Gui main class
 */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.App;

public class MainWindow extends Application {
	
	// To keep or control the present exam question number.	
	public static int currentQuestionNr=1;
	
	// To align and display the correct exam question numbers with the correct exam questions.
	Label lblFragaNr;
	
	// Contains an array of exam questions row 190: nrOfQuestions=questionList.size();
	int nrOfQuestions = 0;
	
	// This object is used to keep track of the testID in showQuestionType() method below.
	int testID=-1;
	
	// index2 object is utilised in the showQuestionType() method to generate relevant 
	// amount of checkboxes.
	int index2 = -1;
	
	// txtAnswer is used to display answers written by the student. This variable is used in showQuestionType()
	// and the button btnNasta.
	TextArea txtAnswer;
	
	// Generates new checkboxes. 
	CheckBox[] cb;
	
	// Used as the button "Tillbaka'.
	Button btnForra;
	
	// Setting child nodes such as the buttons i convenient layouts. 
	BorderPane bordertop;
	BorderPane borderbottom;
	
	//Creates object of class Questions.
	Question q = new Question();
	
	//Creates object of MakeTest.
	MakeTest mt = new MakeTest();
	
	// Stores the questions in a list applied in showQuestionType() and initAnswerSubList().
	List<Question> questionList;

	//Create a list of AnswerSubmitted.
	List<AnswerSubmited> listAS = new ArrayList<>();
	
	//Create instance of SchoolTest.
	SchoolTest st = new SchoolTest();
		
	TextArea txtQuestion;
	Label lblTxtQuestion;
	
	Button btnInlamning;
	Button btnNasta;
	
	Label questionText = new Label();
	String svar;
	
	Timeline timeline;

	// Displays how much time is left.
	Label lblTid;
	int testTime =0;
	
	Label tidVarning;
		
	FlowPane rootFlow = new FlowPane(Orientation.VERTICAL, 10, 10);
    App app;
        
        int initListIterator = 0;
        List<Answer> answerlist;
	
	public void setTestAndApp(SchoolTest schooltest, App app) {
		this.st = schooltest;
		this.app = app;
		
	}
		
        // METHOD: Initialises submitted answer-list.
        public void initAnswerSubList(){
         
                for(int y = 0 ; y<questionList.size() ; y++){
                    AnswerSubmited as = new AnswerSubmited();
                    as.setAnswerString("");
                    listAS.add(as);
                }
        }

        // Applies the Timeline's methods in order to display the remaining exam-time once the exam has begun.
        public void countdown() {
        	 timeline = new Timeline();
             lblTid.setText("Tid kvar:  " +
             		setMinSec(testTime));
             timeline.setCycleCount(Timeline.INDEFINITE);
             timeline.getKeyFrames().add(
                     new KeyFrame(Duration.seconds(1),
                             //new  {
                             new EventHandler<ActionEvent>() {
                     	
                                 // KeyFrame event handler
                                 public void handle(ActionEvent event) {
                                     testTime--;                                    
                                     // Update timerLabel
                                     lblTid.setText("Tid kvar: " +
                                             setMinSec(testTime));
                                     if(testTime == 5*60) {
                                    	 tidVarning.setText("OBS! 5 min. kvar");
                                     }
                                     else if (testTime==(5*60)-10) {
                                    	 tidVarning.setText("");
                                     }
                                     if (testTime <= 0) {
                                         timeline.stop();
                                         System.out.println("Tiden är slut");
                                         btnNasta.setDisable(true);
                                    	 btnForra.setDisable(true);
                                    	 tidVarning.setText("Nu är provtiden slut. Vänligen lämna in provet "
                                    	 		+ "genom att klicka på Lämna in prov till höger");
                                    	 questionText.setText("");
                                    	 lblFragaNr.setText("");
                                    	 rootFlow.getChildren().clear();
                                    	 btnInlamning.setDisable(false);
                                    	 
                                     }
                                 }
                             }));
             timeline.play();      	
        }
        
        // METHOD: To convert time to minutes and seconds.
        public String setMinSec(int timeleft) {
        	String tid = "";
        	int nrOfMin = timeleft/60;
        	int nrOfSec = timeleft - (nrOfMin*60);
        	tid = nrOfMin+"min:"+nrOfSec+"sek";
        	return tid;
        }
        
	// METHOD: showQuestionType(). Create method to display multiple-question type in GUI.
			public void showQuestionType() {                          
				
				testID=st.getId();						
				questionList = new ArrayList<>();
                                

				answerlist = new ArrayList<Answer>();
				questionList=st.getQuestions();
				nrOfQuestions=questionList.size();
				q=questionList.get(currentQuestionNr-1);
				questionText.setText(q.getQuestionText());
				rootFlow.getChildren().add(questionText);

                                if(initListIterator==0){
                                    initAnswerSubList();
                                    testTime = st.getTestTime()*60;
                                }
                                
				if (q.isMultiQuestion()== true) {
					answerlist = q.getAnswers();
					cb = new CheckBox[answerlist.size()];
					for (int x=0; x<answerlist.size();x++) {
						index2 = x;						
						cb[x]=new CheckBox(answerlist.get(x).getAnswerText());
						rootFlow.getChildren().add(cb[x]);
						cb[x].setOnAction(new EventHandler<ActionEvent>() {
						public void handle (ActionEvent ae) {
							for(int b=0; b<cb.length;b++) {
								if (ae.getSource()==cb[b]) {
									for(int v = 0 ; v<cb.length ; v++){
										if(v!=b){
											cb[v].setSelected(false);
										}
									}
								}
								
							}							
						}
						});
					}
									
				}else {
					txtAnswer = new TextArea();
					rootFlow.getChildren().add(txtAnswer);
				}
				lblFragaNr = new Label("Fråga " + (currentQuestionNr)  + "/" + questionList.size());
				bordertop.setMargin(lblFragaNr,new Insets (12,12,12,12));
				bordertop.setLeft(lblFragaNr);
                                                              
                                initListIterator++;
				
				tidVarning = new Label("");
				tidVarning.setTextFill(Color.RED);
				bordertop.setCenter(tidVarning);
			}	
				
	public void start (Stage primaryStage)  {
		
		// Give the stage a title.
		primaryStage.setTitle("Newtons prov");
		BorderPane rootborder = new BorderPane();
		
		// Create a scene.
		Scene scene3 = new Scene(rootborder, 750,600, Color.WHITE);
					
		primaryStage.setFullScreen(true);
					
		// To set buttons and labels to left and right. Background color on top and bottom.
		bordertop = new BorderPane();
		borderbottom = new BorderPane();
		bordertop.setBackground(new Background(new BackgroundFill		(Color.LAVENDER,CornerRadii.EMPTY,Insets.EMPTY)));
		borderbottom.setBackground(new Background(new BackgroundFill		(Color.LAVENDER,CornerRadii.EMPTY,Insets.EMPTY)));
		rootborder.setTop(bordertop);
		rootborder.setBottom(borderbottom);
		
		// To set lblQuestion1 and checkbox questions in center. Background fill white in rootFlow.
		rootFlow.setAlignment(Pos.CENTER);
		rootFlow.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
		rootborder.setCenter(rootFlow);
																
		// Create button: "LÄMNA IN PROV". The font changed.
		btnInlamning = new Button("Lämna in prov");
		btnInlamning.setFont(Font.font("Tahoma",FontWeight.BOLD,15));
		bordertop.setRight(btnInlamning);
		bordertop.setMargin(btnInlamning, new Insets(40,40,40,40));
		btnInlamning.setDisable(true);
		
		
		//lblFragaNr.setFont(new Font("Arial",20));

		//BUTTON:"LÄMNA IN PROV".
		btnInlamning.setOnAction(new EventHandler<ActionEvent>() {
	  		public void handle (ActionEvent ae) {
	  			
	  			SubmittedTest subTest = new SubmittedTest();
	  			//Ready to send to Server.
	  			rootFlow.getChildren().clear();
	  			
	  			primaryStage.close();
	  			
	  			subTest.setTestId(testID);
  				subTest.setAnswersSubmited(listAS);
  				
  				app.initNetwork();
  				app.doLogin(app.getPersNr(), app.getPassword(),false);
  				app.getCh().send("submit", subTest);
  				
  				
  				
  				app.displayDialogBox();
  				

  				/*
	  			rootFlow.getChildren().clear();
	  			btnNasta.setDisable(true);
	  			btnForra.setDisable(true);
	  			timeline.getKeyFrames().clear();
	  			lblTid.setText("");
	  			lblFragaNr.setText("");
	  			btnInlamning.setDisable(true);

	  			primaryStage.close();*/
	  			
	  				}
		});
				
		// BUTTON: "NÄSTA". The font changed.
		btnNasta = new Button ("Nästa");
		btnNasta.setFont(Font.font("Tahoma",FontWeight.BOLD,10));
		borderbottom.setMargin(btnNasta, new Insets(12,12,12,12));
		borderbottom.setRight(btnNasta);
		
		// Handle the action event for btnNasta.
		btnNasta.setOnAction(new EventHandler<ActionEvent>() {
	  		public void handle (ActionEvent ae) {
	  			//Show the next exam-question	  			
	  			{	questionList=st.getQuestions();

	  				if(cb!=null){
	  				for(int i=0; i<cb.length;i++) {
                                            
                                           
                                            
	  					if(questionList.get(currentQuestionNr-1).isMultiQuestion()) {
	  						if(cb[i].isSelected()) {
	  		  					AnswerSubmited as = new AnswerSubmited();
	  		  					as.setQuestionId(st.getQuestions().get(currentQuestionNr-1).getId());
	  		  					as.setAnswerString(cb[i].getText());
	  		  					as.setTestId(testID);
	  		  					as.setId(currentQuestionNr);
                                                                /////added
	  		  					listAS.set(currentQuestionNr-1,as);                                                                
	  		  				}                                                       
                                                        else{                                                                
                                                        }
	  					}
	  					else {
                                                        ////Added if
                                                        if(currentQuestionNr!=nrOfQuestions+1) {
                                                            AnswerSubmited as = new AnswerSubmited();
                                                            as.setQuestionId(st.getQuestions().get(currentQuestionNr-1).getId());
                                                            as.setAnswerString(txtAnswer.getText());
                                                            as.setTestId(testID);
                                                            as.setId(currentQuestionNr);
                                                            ////Added
                                                            listAS.set(currentQuestionNr-1,as);
                                                            break;	
                                                            }
	  					}	  						  				
	  				}}
	  				else{
	  					if(currentQuestionNr!=nrOfQuestions+1) {
                            AnswerSubmited as = new AnswerSubmited();
                            as.setQuestionId(st.getQuestions().get(currentQuestionNr-1).getId());
                            as.setAnswerString(txtAnswer.getText());
                            as.setTestId(testID);
                            as.setId(currentQuestionNr);
                            ////Added
                            listAS.set(currentQuestionNr-1,as);

                            }
	  				}


                                        /////added 
                                        if(questionList.get(currentQuestionNr-1).isMultiQuestion()) {
                                        boolean cbMarked = false;
                                        for(int d = 0 ; d<cb.length ; d++){
                                            if(cb[d].isSelected()){
                                                cbMarked = true;
                                                break;
                                            }
                                        }
                                        
                                        if(cbMarked == false){
                                            AnswerSubmited as = new AnswerSubmited();
                                            as.setQuestionId(st.getQuestions().get(currentQuestionNr-1).getId());
                                            as.setAnswerString("");
                                            as.setTestId(testID);
                                            as.setId(currentQuestionNr);
                                            listAS.set(currentQuestionNr-1,as);
                                        }
                                        }
	  				rootFlow.getChildren().clear();
	  				currentQuestionNr++;
	  				if(currentQuestionNr==nrOfQuestions+1) {
	  					btnNasta.setDisable(true);
	  					lblFragaNr.setText("Sista sidan");
	  					btnInlamning.setDisable(false);
	  					questionText.setText("Granskning av test:");
	  					rootFlow.getChildren().add(questionText);
	  					txtAnswer = new TextArea();
						rootFlow.getChildren().add(txtAnswer);
						for(int i=0; i<questionList.size();i++) {
							txtAnswer.setText(txtAnswer.getText()+ (i+1)+ ")" + questionList.get(i).getQuestionText()+"\n");
							txtAnswer.setText(txtAnswer.getText()+ "svar " + (i+1) +": " +listAS.get(i).getAnswerString()+ "\n");
						}
	  				}
	  				else{
	  					showQuestionType();

                                        if(questionList.get(currentQuestionNr-1).isMultiQuestion()) {
                                            for(int y = 0 ; y<answerlist.size() ; y++){
                                                if(listAS.get(currentQuestionNr-1).getAnswerString().equals(answerlist.get(y).getAnswerText())){
                                                    cb[y].setSelected(true);
                                               }
                                           }
                                        }
                                        else{
                                            if (!listAS.get(currentQuestionNr-1).getAnswerString().equals("")){
                                                txtAnswer.setText(listAS.get(currentQuestionNr-1).getAnswerString());
                                            }
                                            else{
                                             
                                            if(currentQuestionNr!=nrOfQuestions+1) {
                                                txtAnswer.setText(listAS.get(currentQuestionNr-1).getAnswerString());
                                            }
                                            }
                                        }
		  				lblFragaNr.setText("Fråga " + (currentQuestionNr)  + "/" + nrOfQuestions);
	  				}
	  				btnForra.setDisable(false);                                       
                                        
	  	  		}	  			
	  			}
	  	  		});
		
		// Create button: "Tillbaka". The font changed.
		btnForra = new Button ("Tillbaka");
		btnForra.setFont(Font.font("Tahoma",FontWeight.BOLD,10));
		borderbottom.setMargin(btnForra, new Insets(12,12,12,12));
		borderbottom.setLeft(btnForra);
		btnForra.setDisable(true);
		
		//BUTTON: "TILLBAKA".
		btnForra.setOnAction(new EventHandler<ActionEvent>() {
	  		public void handle (ActionEvent ae) {
	  			
	  			{	  	
                                        ////added
                                        if(currentQuestionNr!=nrOfQuestions+1) {
                                        questionList=st.getQuestions();
	  				for(int i=0; i<cb.length;i++) {
                                                                                        
	  					if(questionList.get(currentQuestionNr-1).isMultiQuestion()) {
	  						if(cb[i].isSelected()) {
	  		  					AnswerSubmited as = new AnswerSubmited();
	  		  					as.setQuestionId(st.getQuestions().get(currentQuestionNr-1).getId());
	  		  					as.setAnswerString(cb[i].getText());
	  		  					as.setTestId(testID);
	  		  					as.setId(currentQuestionNr);
	  		  					listAS.set(currentQuestionNr-1,as);
                                                                
	  		  				}
                                                        else{
                                                            
                                                        }
	  					}
	  					else {
                                                        
                                                        if(currentQuestionNr!=nrOfQuestions+1) {
                                                            AnswerSubmited as = new AnswerSubmited();
                                                            as.setQuestionId(st.getQuestions().get(currentQuestionNr-1).getId());
                                                            as.setAnswerString(txtAnswer.getText());
                                                            as.setTestId(testID);
                                                            as.setId(currentQuestionNr);
                                                            listAS.set(currentQuestionNr-1,as);
                                                            break;	
                                                            }
	  					}	  						  				
	  				}
                                        }
                                        if (currentQuestionNr!=nrOfQuestions+1){
                                        if((questionList.get(currentQuestionNr-1).isMultiQuestion()) ) {
                                        boolean cbMarked = false;
                                        for(int d = 0 ; d<cb.length ; d++){
                                            if(cb[d].isSelected()){
                                                cbMarked = true;
                                                break;
                                            }
                                        }
                                        
                                        if(cbMarked == false){
                                            AnswerSubmited as = new AnswerSubmited();
                                            as.setQuestionId(st.getQuestions().get(currentQuestionNr-1).getId());
                                            as.setAnswerString("");
                                            as.setTestId(testID);
                                            as.setId(currentQuestionNr);
                                            listAS.set(currentQuestionNr-1,as);
                                        }
                                        }
                                        }
	  				rootFlow.getChildren().clear();
	  				currentQuestionNr--;
	  				showQuestionType();
                                                                               
	  				lblFragaNr.setText("Fråga " + (currentQuestionNr)  + "/" + nrOfQuestions);
	  				if(currentQuestionNr==1) {
	  					btnForra.setDisable(true);
	  				}
	  				btnNasta.setDisable(false);
	  				btnInlamning.setDisable(true);
                                        if(questionList.get(currentQuestionNr-1).isMultiQuestion()) {
                                            for(int y = 0 ; y<cb.length ; y++){
                                                if(listAS.get(currentQuestionNr-1).getAnswerString().equals(answerlist.get(y).getAnswerText())){
                                                    cb[y].setSelected(true);
                                                }
                                            }
                                        }
                                        else{
                                            if (!listAS.get(currentQuestionNr-1).getAnswerString().equals("")){
                                                txtAnswer.setText(listAS.get(currentQuestionNr-1).getAnswerString());
                                            }
                                            else{
                                             
                                            if(currentQuestionNr!=nrOfQuestions+1) {
                                                txtAnswer.setText(listAS.get(currentQuestionNr-1).getAnswerString());
                                            }
                                            }
                                        }
                                        }
	  			}
	  	  		});

		// Create a label for "Tid kvar". The font changed.
		lblTid = new Label ("");
		lblTid.setFont(Font.font("Tahoma",FontWeight.BOLD,15));
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


