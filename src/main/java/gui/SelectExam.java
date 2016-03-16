package gui;
/*
 * This SelectExam class illustrates the links of available exams in which logged in
 * students can choose.
 */

import beans.SchoolTest;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ListView;



public class SelectExam extends Application {
	
	//Text of "Vï¿½nligen vï¿½lj ett prov"
	Text text1 = new Text(450, 200,"Vänligen välj ett prov:");
	
	//Textstrï¿½ng som ska lï¿½nkas till uppladdade prov frï¿½n server.
	//Text text2 = new Text(450,230,"Prov i Desktopapplikationer 1");
	
	TableRow table1;
	SchoolTest schooltest = new SchoolTest();
	
	
	public SelectExam (Stage primaryStage, List<SchoolTest> testList)  {
		
		BorderPane rootborder = new BorderPane();
		FlowPane rootFlow = new FlowPane(Orientation.VERTICAL, 10, 10);
		
		
		
		
		// Give the stage a title.
		primaryStage.setTitle("Newtons prov");
		
		
		// Create a scene.
		Scene scene2 = new Scene(rootborder, 750,600, Color.WHITE);
		//primaryStage.setFullScreen(true);
		primaryStage.setFullScreen(true);
		
		/*
		// Create an ObservableList of entries for the list view.
		ObservableList<String> examToSelect =
				FXCollections.observableArrayList(".Net","Databasteknik","Desktopapplikationer");
		
		// Create the ListView that displays the items in examToSelect.
		ListView<String> examTypes = new ListView<String>(examToSelect);
		
		// Set the preferred height and width.
		examTypes.setPrefSize(100, 70);
		
		// Get the list view selection model.
		MultipleSelectionModel<String> lvSelModel = 
											examTypes.getSelectionModel();
		
		// Use a change listener to respond to a change of selection 
		// within a list view.
		lvSelModel.selectedItemProperty().addListener(
										  new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> changed,
										String oldVal, String newVal){
				// Display the selection model.
				//responselable.setText("sdfsdf" + newVal);
			}			
			});
		
		*/
		
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

		//Change Font and text size: text2.
		//text2.setFont(new Font("Arial",15));
		//text2.setFill(Color.ORANGE);
		
		// BUTTON: "AVBRYT"
		Button btnAvbryt = new Button("Avbryt");
		VBox vbox1 = new VBox();
		//*vbox1.setPadding(new Insets(3));
		//vbox1.setMargin(btnAvbryt, new Insets(400,450,450,450));
		
		ObservableList data = 
		        FXCollections.observableArrayList();
		ListView listview = new ListView(data);
		ObservableList<String> items =FXCollections.observableArrayList (
		    );
		//"Single", "Double", "Suite", "Family App"
		
		for(int x = 0 ; x < testList.size(); x++){
			
			//System.out.println(testList.get(x).getName());
			items.add(testList.get(x).getName());
		}
		listview.setItems(items);
		//listview.setPrefHeight(items.size());
		//listview.setPrefSize(20, 30);
		//rootborder.setCenter(listview);
		listview.setPrefSize(225, 225);
		listview.setTranslateX(450);
		listview.setTranslateY(250);
		btnAvbryt.setTranslateX(500);
		btnAvbryt.setTranslateY(350);
		
		Button btnValj = new Button("Välj Prov");
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
					spv.start(primaryStage);
				}
				
			}
		});
		
		//vbox1.getChildren().add(listview);
		rootFlow.getChildren().addAll(listview,btnValj,btnAvbryt);
		rootborder.setCenter(rootFlow);	
		//rootborder.setRight(btnAvbryt);
		
		
		
		listview.getSelectionModel().selectedItemProperty().addListener(
			      new ChangeListener() {
			     
				@Override
				public void changed(ObservableValue arg0, Object arg1, Object arg2) {
					
					for(int x = 0 ; x < testList.size(); x++){
						
						if(arg0.getValue().equals(testList.get(x).getName()))
							schooltest = testList.get(x);
					}
					
					//System.out.println(arg0.getValue());
					
				}});
		
		
		btnAvbryt.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent ae){
				primaryStage.close();
			}
		});
		
		rootborder.getChildren().addAll(text1);
		
		
		
				
		// Set the scene on the stage.
		primaryStage.setScene(scene2);
		primaryStage.show();	
		
}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}


	



	/*@Override
	public void start(Stage arg0) throws Exception {
		//Stage s = new Stage();
		List<SchoolTest> testList = new ArrayList<>();
		SelectExam examselect = new SelectExam(arg0,testList);
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}
		
} 
*/
