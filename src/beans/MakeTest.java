package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reza
 */
public class MakeTest {



    public SchoolTest initTest(){

        SchoolTest schooltest = new SchoolTest();
        Question q1 = new Question();
        q1.setQuestionText("Huvudstaden i Spanien?");
        q1.setPoints(1);
        q1.setVgQuestion(false);
        q1.setMultiQuestion(true);
        List<Answer> list = new ArrayList<Answer>();
        Answer a1 = new Answer();
        a1.setAnswerText("barcelona");
        a1.setCorrectAnswer(false);
        Answer a2 = new Answer();
        a2.setAnswerText("rom");
        a2.setCorrectAnswer(false);
        Answer a3 = new Answer();
        a3.setAnswerText("madrid");
        a3.setCorrectAnswer(true);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        q1.setAnswers(list);

        Question q2 = new Question();
        q2.setQuestionText("Världens högsta berg?");
        q2.setPoints(2);
        q2.setVgQuestion(true);
        q2.setMultiQuestion(true);
        List<Answer> list2 = new ArrayList<Answer>();
        Answer a4 = new Answer();
        a4.setAnswerText("kilimanjaro");
        a4.setCorrectAnswer(false);
        Answer a5 = new Answer();
        a5.setAnswerText("mount everest");
        a5.setCorrectAnswer(true);
        Answer a6 = new Answer();
        a6.setAnswerText("mount blanc");
        a6.setCorrectAnswer(false);
        list2.add(a4);
        list2.add(a5);
        list2.add(a6);
        q2.setAnswers(list2);

        Question q3 = new Question();
        q3.setQuestionText("Världens folkrikaste land?");
        q3.setMultiQuestion(false);
        q3.setPoints(1);
        q3.setVgQuestion(false);
        Answer a7 = new Answer();
        a7.setAnswerText("kina");

        List<Question> listOfQuestions = new ArrayList<Question>();
        listOfQuestions.add(q1);
        listOfQuestions.add(q2);
        listOfQuestions.add(q3);

        schooltest.setId(1);
        schooltest.setName("Reza Test");
        schooltest.setQuestions(listOfQuestions);

        return schooltest;

    }




}
