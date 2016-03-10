package beans;



import java.util.ArrayList;
import java.util.List;

/**
 * The entity class that represents the tests. Contains the type of test and the questions in the test.
 */

public class SchoolTest {

	
	private int id;
	private String name;
	private List<Question> questions;
	
	public SchoolTest(){
		questions = new ArrayList<Question>();
	}

	public SchoolTest(String name){
		this.name = name;
		questions = new ArrayList<Question>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String type) {
		this.name = type;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public void addQuestion(Question currQuestion){
		questions.add(currQuestion);
	}

	public void removeQuestion(Question currQuestion){
		questions.remove(currQuestion);
	}
}
