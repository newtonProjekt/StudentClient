package gui;

/*
 * This SelectExam class illustrates the links of available exams in which logged in
 * students can choose.
 */

import beans.SchoolTest;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.ListView;



public class SelectExam extends Application {
	
	//Text of "Vänligen välj ett prov"
	Text text1 = new Text(450, 200,"Vänligen välj ett prov:");
	SchoolTest schooltest = new SchoolTest();
	
	
	public SelectExam (Stage primaryStage, List<SchoolTest> testList, App app)  {
		
		
		
		BorderPane rootborder = new BorderPane();
		FlowPane rootFlow = new FlowPane(Orientation.VERTICAL, 10, 10);

		// Give the stage a title.
		primaryStage.setTitle("Newtons prov");

		// Create a scene.
		Scene scene2 = new Scene(rootborder, 1000,800, Color.WHITE);
		primaryStage.setX(0);
		primaryStage.setY(0);
		
		// Add the label and list view to the scene graph.
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
		rootborder.getChildren().add(stackpane);
						
		//Change Font and text size: text1.
		text1.setFont(new Font("Arial",20));
		text1.setFill(Color.BLACK);
		
		// BUTTON: "AVBRYT"
		Button btnAvbryt = new Button("Avbryt");
		
		ObservableList data = 
		        FXCollections.observableArrayList();
		ListView listview = new ListView(data);
		ObservableList<String> items =FXCollections.observableArrayList (
		    );
		
		
		for(int x = 0 ; x < testList.size(); x++){
			
			if(testList.get(x) == null){
				if(app.getTestStarted()==false){
					primaryStage.close();
					Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Info om prov");
						alert.setHeaderText("Inga tillgängliga prov!");
						alert.setContentText("Du har inga tillgängliga prov just nu. Vänligen återkom senare.");

						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK){
							app.closeProgram();
						} 
				}
				else{
					primaryStage.close();
				}
			}
			else{
				items.add(testList.get(x).getName());
			}
		}
		listview.setItems(items);
		
		listview.setPrefSize(225, 225);
		listview.setTranslateX(450);
		listview.setTranslateY(250);
		btnAvbryt.setTranslateX(500);
		btnAvbryt.setTranslateY(350);
		
		Button btnValj = new Button("Välj prov");
		btnValj.setTranslateX(500);
		btnValj.setTranslateY(300);
		
		btnValj.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent ae){
				
				System.out.println(listview.getSelectionModel().getSelectedItem());
				if(listview.getSelectionModel().getSelectedItem()==null){
					
				}
				else{
					StartaProvView spv = new StartaProvView();
					spv.setSchoolTest(schooltest);
					spv.setApp(app);
					spv.start(primaryStage);
				}
				
			}
		});
		
		rootFlow.getChildren().addAll(listview,btnValj,btnAvbryt);
		rootborder.setCenter(rootFlow);	
		
		
		//listener for selecting test
		listview.getSelectionModel().selectedItemProperty().addListener(
			      new ChangeListener() {
			     
				@Override
				public void changed(ObservableValue arg0, Object arg1, Object arg2) {
					
					for(int x = 0 ; x < testList.size(); x++){
						
						if(arg0.getValue().equals(testList.get(x).getName()))
							schooltest = testList.get(x);
					}
					
					
				}});
		
		
		btnAvbryt.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent ae){
				app.closeProgram();
			}
		});
		
		rootborder.getChildren().addAll(text1);
		
		// Set the scene on the stage.
		primaryStage.setScene(scene2);
		//primaryStage.show();	
		
}


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
	}
}


