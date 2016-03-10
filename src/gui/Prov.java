package gui;

import java.util.ArrayList;
import java.util.List;

import beans.MakeTest;
import beans.SchoolTest;

// THIS CLASS CONTAINS METHODS TO GET THE RIGHT EXAM-NAME, EXAM-QUESTIONS AND EXAM-QUESTION-TYPES.

public class Prov {
	
	public static int nrOfQuestions = 0;
	//Create object of the SchoolTest.
	SchoolTest st = new SchoolTest();
	
	//Create object of MakeTest.
	MakeTest mt = new MakeTest();
	
	//Constructor to initialise the methods from MakeTest and the SchoolTest.
	public  Prov () {
		st = mt.initTest();
		nrOfQuestions = st.getQuestions().size();		
	}
	
	//Method to get the number of questions/nrOfQuestions.
	public  int getExQuestions() {
		return nrOfQuestions;
	}
	
	
	//Create method to get the relevant Exam-question-type.
	
	//Create method to get the relevant Exam-questions.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
