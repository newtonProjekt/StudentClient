package gui;
// THIS CLASS SHOWS THE EXAM-QUESTIONS-TYPES.

import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainWindow extends Application {
	
	
	ToggleGroup toggleCheckBox;
	
	public static int currentQuestionNr=1;
	
	Label lblFragaNr;
	
	int testID=0;
	
	int index2 = -1;
	
	
	
	TextArea txtAnswer;
	
	CheckBox[] cb;
	
	Button btnForra;
	
	BorderPane bordertop;
	BorderPane borderbottom;
	
	//Create object of class Questions.
	Question q = new Question();
	
	List<Question> questionList;
	
	//Create object of MakeTest.
	MakeTest mt = new MakeTest();
	
	//Create a list of AnswerSubmitted.
	List<AnswerSubmited> listAS = new ArrayList<>();
	
	//Create instance of SchoolTest.
	SchoolTest st = new SchoolTest();
	
	int nrOfQuestions = 0;
	
	TextArea txtQuestion;
	Label lblTxtQuestion;
	
	Label response;
	Label selected;
	Label questionText = new Label();
	String svar;
	
	Timeline timeline;
	private static final Integer STARTTIME = 15;
	//private Integer timeSeconds = STARTTIME;
	Label lblTid;
	int testTime =0;
	

	
	FlowPane rootFlow = new FlowPane(Orientation.VERTICAL, 10, 10);
        
        ///////added
        int initListIterator = 0;
        List<Answer> answerlist;
	
	public void setMakeTest(SchoolTest y) {
		this.st = y;
		
	}
		
        ///////added
        public void initAnswerSubList(){
         
                for(int y = 0 ; y<questionList.size() ; y++){
                    AnswerSubmited as = new AnswerSubmited();
                    as.setAnswerString("");
                    listAS.add(as);
                }
                timeline = new Timeline();
                lblTid.setText("Tid kvar:  " +
                        Integer.toString(testTime));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                //new  {
                                new EventHandler<ActionEvent>() {
                        	
                                    // KeyFrame event handler
                                    public void handle(ActionEvent event) {
                                        testTime--;
                                        // update timerLabel
                                        lblTid.setText("Tid kvar: " +
                                                Integer.toString(testTime));
                                        if (testTime <= 0) {
                                            timeline.stop();
                                            System.out.println("Tiden �r slut");
                                        }
                                    }
                                }));
                timeline.playFromStart();        
                    

                    
                    
                      	
            
        }
        
	// Create method to display multiple-question type in GUI.
			public void showQuestionType() {                          
				st = mt.initBigTest();
				testID=st.getId();
				testTime = st.getTestTime()*60;				
				questionList = new ArrayList<>();
                                
                                /////added one line
				answerlist = new ArrayList<Answer>();
				questionList=st.getQuestions();
				nrOfQuestions=questionList.size();
				q=questionList.get(currentQuestionNr-1);
				questionText.setText(q.getQuestionText());
				rootFlow.getChildren().add(questionText);
                                
                                /////added if
                                if(initListIterator==0){
                                    initAnswerSubList();
                                }
                                
				if (q.isMultiQuestion()== true) {
					answerlist = q.getAnswers();
					cb = new CheckBox[answerlist.size()];
					for (int x=0; x<answerlist.size();x++) {
						index2 = x;
						//cb[x].setText(answerlist.get(x).getAnswerText());
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
				lblFragaNr = new Label("Fr�ga " + (currentQuestionNr)  + "/" + questionList.size());
				bordertop.setMargin(lblFragaNr,new Insets (12,12,12,12));
				bordertop.setLeft(lblFragaNr);
                                
                                //////added
                                initListIterator++;
				
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
		bordertop = new BorderPane();
		borderbottom = new BorderPane();
		rootborder.setTop(bordertop);
		rootborder.setBottom(borderbottom);
		
		// To set lblQuestion1 and checkbox questions in center.
		//rootFlow = new FlowPane(Orientation.VERTICAL, 10, 10);
		rootFlow.setAlignment(Pos.CENTER);
		rootborder.setCenter(rootFlow);
		
		// Create a label to a question 1.
		Label lblQuestion1 = new Label("Vad �r JavaFx?");
						
								
		// Create button: "L�mna in prov"
		Button btnInlamning = new Button("L�mna in prov");
		bordertop.setMargin(btnInlamning, new Insets(12,12,12,12));
		bordertop.setRight(btnInlamning);
		btnInlamning.setDisable(true);
		
		//BUTTON:"L�MNA IN PROV".
		btnInlamning.setOnAction(new EventHandler<ActionEvent>() {
	  		public void handle (ActionEvent ae) {
	  			SubmittedTest subTest = new SubmittedTest();
	  			//Ready to send to Server.
	  			subTest.setTestId(testID);;
  				subTest.setAnswersSubmited(listAS);
	  			for (AnswerSubmited answerSave:listAS) {
	  				System.out.println(answerSave.getAnswerString());
	  					  				
	  			}	  				  			
	  				}
		});
				
		// BUTTON: "N�STA".
		Button btnNasta = new Button ("N�sta");
		borderbottom.setMargin(btnNasta, new Insets(12,12,12,12));
		borderbottom.setRight(btnNasta);
		
		// Handle the action event for btnNasta.
		btnNasta.setOnAction(new EventHandler<ActionEvent>() {
	  		public void handle (ActionEvent ae) {
	  			//Show the next exam-question
	  			
	  			{	questionList=st.getQuestions();
	  				for(int i=0; i<cb.length;i++) {
                                            
                                           
                                            
	  					if(questionList.get(currentQuestionNr-1).isMultiQuestion()) {
	  						if(cb[i].isSelected()) {
	  		  					AnswerSubmited as = new AnswerSubmited();
	  		  					as.setQuestionId(currentQuestionNr);
	  		  					as.setAnswerString(cb[i].getText());
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
                                                            as.setQuestionId(currentQuestionNr);
                                                            as.setAnswerString(txtAnswer.getText());
                                                            as.setId(currentQuestionNr);
                                                            ////Added
                                                            listAS.set(currentQuestionNr-1,as);
                                                            break;	
                                                            }
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
                                            as.setQuestionId(currentQuestionNr);
                                            as.setAnswerString("");
                                            as.setId(currentQuestionNr);
                                            listAS.set(currentQuestionNr-1,as);
                                        }
                                        }
                                        /////end of added
                                        
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
                                                
                                                //////added
                                        if(questionList.get(currentQuestionNr-1).isMultiQuestion()) {
                                            for(int y = 0 ; y<answerlist.size() ; y++){
                                                //System.out.println(listAS.get(y).getAnswerString());
                                                //System.out.println(answerlist.get(y).getAnswerText());
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
                                        ////end of added
                                                
		  				lblFragaNr.setText("Fr�ga " + (currentQuestionNr)  + "/" + nrOfQuestions);
	  				}
	  				btnForra.setDisable(false);
                                        
                                        
                                        
	  	  		}	  			
	  			}
	  	  		});
		
		// Create button: "Tillbaka"
		btnForra = new Button ("Tillbaka");
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
	  		  					as.setQuestionId(currentQuestionNr);
	  		  					as.setAnswerString(cb[i].getText());
	  		  					as.setId(currentQuestionNr);
                                                                /////added
	  		  					listAS.set(currentQuestionNr-1,as);
                                                                
	  		  				}
                                                        else{
                                                            
                                                        }
	  					}
	  					else {
                                                        
                                                        if(currentQuestionNr!=nrOfQuestions+1) {
                                                            AnswerSubmited as = new AnswerSubmited();
                                                            as.setQuestionId(currentQuestionNr);
                                                            as.setAnswerString(txtAnswer.getText());
                                                            as.setId(currentQuestionNr);
                                                            ////Added
                                                            listAS.set(currentQuestionNr-1,as);
                                                            break;	
                                                            }
	  					}	  						  				
	  				}
                                        }
                                        ////end of added
                                        
                                        /////added 
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
                                            as.setQuestionId(currentQuestionNr);
                                            as.setAnswerString("");
                                            as.setId(currentQuestionNr);
                                            listAS.set(currentQuestionNr-1,as);
                                        }
                                        }
                                        }
                                        /////end of added
                                        
	  				rootFlow.getChildren().clear();
	  				currentQuestionNr--;
	  				showQuestionType();
                                        
                                        
                                        
	  				lblFragaNr.setText("Fr�ga " + (currentQuestionNr)  + "/" + nrOfQuestions);
	  				if(currentQuestionNr==1) {
	  					btnForra.setDisable(true);
	  				}
	  				btnNasta.setDisable(false);
	  				btnInlamning.setDisable(true);
                                        
                                        //////added
                                        if(questionList.get(currentQuestionNr-1).isMultiQuestion()) {
                                            for(int y = 0 ; y<cb.length ; y++){
                                                //System.out.println(listAS.get(y).getAnswerString());
                                                //System.out.println(answerlist.get(y).getAnswerText());
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
	  
			
		// Create a label for "�terst�ende tid: 27 min.".
		lblTid = new Label ("�terst�ende tid: 27 min");
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


