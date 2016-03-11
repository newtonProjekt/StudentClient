package beans;


import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean class for questions that contains the answers refering to the tests, question type (multi or text), question
 * text and optionally question image.
 */

public class Question {

    private int id;
    private boolean multiQuestion;
    private boolean vgQuestion;
    private int points;
    private String questionImage;
    private Image questionImageFile;
    private String questionText;
    private List<Answer> answers;

    public Question() {
        answers = new ArrayList<Answer>();
    }

    public Question(String questionText, int points, boolean multiQuestion) {
        this.multiQuestion = multiQuestion;
        this.points = points;
        this.questionText = questionText;
        if (multiQuestion) {
            answers = new ArrayList<Answer>();
        }
    }

    public Question(String questionText, int points, boolean multiQuestion, boolean vgQuestion) {
        this.multiQuestion = multiQuestion;
        this.vgQuestion = vgQuestion;
        this.points = points;
        this.questionText = questionText;
        if (multiQuestion) {
            answers = new ArrayList<Answer>();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMultiQuestion() {
        return multiQuestion;
    }

    public void setMultiQuestion(boolean multiQuestion) {
        this.multiQuestion = multiQuestion;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getQuestionImage() {
        return questionImage;
    }

    public void setQuestionImage(String questionImage) {
        this.questionImage = questionImage;
    }

    public boolean isVgQuestion() {
        return vgQuestion;
    }

    public void setVgQuestion(boolean vgQuestion) {
        this.vgQuestion = vgQuestion;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer currAnswer) {
        if (multiQuestion) {
            answers.add(currAnswer);
        }
    }

    public void removeAnswer(Answer currAnswer) {
        if (multiQuestion) {
            answers.remove(currAnswer);
        }
    }

    public Image getQuestionImageFile() {
        return questionImageFile;
    }

    public void setQuestionImageFile(Image questionImageFile) {
        this.questionImageFile = questionImageFile;
    }
}
