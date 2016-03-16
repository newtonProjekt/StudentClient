/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        
        
        List<Question> listOfQuestions = new ArrayList<Question>();
        listOfQuestions.add(q1);
        listOfQuestions.add(q2);
        listOfQuestions.add(q3);
        
        schooltest.setId(1);
        schooltest.setName("Test 1");
        schooltest.setQuestions(listOfQuestions);
        schooltest.setgThreshold(50);
        schooltest.setVgThreshold(50);
        schooltest.setTestTime(5);
        
        return schooltest;
        
    }
    
    
    public SchoolTest initBigTest(){
        
        SchoolTest schooltest = new SchoolTest();
        
        Question q1 = new Question();
        q1.setQuestionText("Vad är huvudstaden i Italien?");
        q1.setPoints(1);
        q1.setVgQuestion(false);
        q1.setMultiQuestion(true);
        List<Answer> list1 = new ArrayList<Answer>();
        Answer a1 = new Answer();
        a1.setAnswerText("aten");
        a1.setCorrectAnswer(false);
        Answer a2 = new Answer();
        a2.setAnswerText("belgrad");
        a2.setCorrectAnswer(false);
        Answer a3 = new Answer();
        a3.setAnswerText("rom");
        a3.setCorrectAnswer(true);
        Answer a4 = new Answer();
        a4.setAnswerText("paris");
        a4.setCorrectAnswer(false);
        list1.add(a1);
        list1.add(a2);
        list1.add(a3);
        list1.add(a4);
        q1.setAnswers(list1);
        
        Question q2 = new Question();
        q2.setQuestionText("Världens högsta berg?");
        q2.setPoints(2);
        q2.setVgQuestion(true);
        q2.setMultiQuestion(true);
        List<Answer> list2 = new ArrayList<Answer>();
        Answer a5 = new Answer();
        a5.setAnswerText("kilimanjaro");
        a5.setCorrectAnswer(false);
        Answer a6 = new Answer();
        a6.setAnswerText("mount everest");
        a6.setCorrectAnswer(true);
        Answer a7 = new Answer();
        a7.setAnswerText("mount blanc");
        a7.setCorrectAnswer(false);
        list2.add(a5);
        list2.add(a6);
        list2.add(a7);
        q2.setAnswers(list2);
        
        Question q3 = new Question();
        q3.setQuestionText("Vad heter världens största sjö?");
        q3.setMultiQuestion(false);
        q3.setPoints(2);
        q3.setVgQuestion(true);
        //Answer a8 = new Answer();
        //a8.setAnswerText("kaspiska havet");
        //List<Answer> list3 = new ArrayList<Answer>();
        //list3.add(a8);
        //q3.setAnswers(list3);
        
        Question q4 = new Question();
        q4.setQuestionText("Vilken är måttenheten för energi?");
        q4.setPoints(2);
        q4.setVgQuestion(false);
        q4.setMultiQuestion(true);
        List<Answer> list4 = new ArrayList<Answer>();
        Answer a9 = new Answer();
        a9.setAnswerText("joule");
        a9.setCorrectAnswer(true);
        Answer a10 = new Answer();
        a10.setAnswerText("lux");
        a10.setCorrectAnswer(false);
        Answer a11 = new Answer();
        a11.setAnswerText("decibel");
        a11.setCorrectAnswer(false);
        list4.add(a9);
        list4.add(a10);
        list4.add(a11);
        q4.setAnswers(list4);
        
        Question q5 = new Question();
        q5.setQuestionText("Vad kallas den flytande stenmassa som strömmar ut ur en vulkan vid ett utbrott?");
        q5.setPoints(1);
        q5.setVgQuestion(false);
        q5.setMultiQuestion(true);
        List<Answer> list5 = new ArrayList<Answer>();
        Answer a12 = new Answer();
        a12.setAnswerText("granit");
        a12.setCorrectAnswer(false);
        Answer a13 = new Answer();
        a13.setAnswerText("lava");
        a13.setCorrectAnswer(true);
        Answer a14 = new Answer();
        a14.setAnswerText("pimpsten");
        a14.setCorrectAnswer(false);
        list5.add(a12);
        list5.add(a13);
        list5.add(a14);
        q5.setAnswers(list5);
        
        Question q6 = new Question();
        q6.setQuestionText("Vad kallar man ett stort snöskred med ett annat ord?");
        q6.setPoints(1);
        q6.setVgQuestion(false);
        q6.setMultiQuestion(true);
        List<Answer> list6 = new ArrayList<Answer>();
        Answer a15 = new Answer();
        a15.setAnswerText("tsunami");
        a15.setCorrectAnswer(false);
        Answer a16 = new Answer();
        a16.setAnswerText("tornado");
        a16.setCorrectAnswer(false);
        Answer a17 = new Answer();
        a17.setAnswerText("lavin");
        a17.setCorrectAnswer(true);
        list6.add(a15);
        list6.add(a16);
        list6.add(a17);
        q6.setAnswers(list6);
        
        Question q7 = new Question();
        q7.setQuestionText("Vad kallas de elektriska urladdningar som förekommer i samband med åskväder?");
        q7.setPoints(1);
        q7.setVgQuestion(false);
        q7.setMultiQuestion(true);
        List<Answer> list7= new ArrayList<Answer>();
        Answer a18 = new Answer();
        a18.setAnswerText("ledare");
        a18.setCorrectAnswer(false);
        Answer a19 = new Answer();
        a19.setAnswerText("gnistor");
        a19.setCorrectAnswer(false);
        Answer a20 = new Answer();
        a20.setAnswerText("blixtar");
        a20.setCorrectAnswer(true);
        list7.add(a18);
        list7.add(a19);
        list7.add(a20);
        q7.setAnswers(list7);
        
        Question q8 = new Question();
        q8.setQuestionText("Vad kallas en person, som studerar väderförhållanden och förutsäger vädret?");
        q8.setPoints(1);
        q8.setVgQuestion(false);
        q8.setMultiQuestion(true);
        List<Answer> list8= new ArrayList<Answer>();
        Answer a21 = new Answer();
        a21.setAnswerText("meterolog");
        a21.setCorrectAnswer(true);
        Answer a22 = new Answer();
        a22.setAnswerText("geolog");
        a22.setCorrectAnswer(false);
        Answer a23 = new Answer();
        a23.setAnswerText("glaciolog");
        a23.setCorrectAnswer(false);
        list8.add(a21);
        list8.add(a22);
        list8.add(a23);
        q8.setAnswers(list8);
        
        Question q9 = new Question();
        q9.setQuestionText("Hur stor del av jordens yta är täckt av vatten?");
        q9.setPoints(2);
        q9.setVgQuestion(true);
        q9.setMultiQuestion(true);
        List<Answer> list9= new ArrayList<Answer>();
        Answer a24 = new Answer();
        a24.setAnswerText("20 %");
        a24.setCorrectAnswer(false);
        Answer a25 = new Answer();
        a25.setAnswerText("50 %");
        a25.setCorrectAnswer(false);
        Answer a26 = new Answer();
        a26.setAnswerText("70 %");
        a26.setCorrectAnswer(true);
        list9.add(a24);
        list9.add(a25);
        list9.add(a26);
        q9.setAnswers(list9);
        
        Question q10 = new Question();
        q10.setQuestionText("Världens folkrikaste land?");
        q10.setMultiQuestion(false);
        q10.setPoints(1);
        q10.setVgQuestion(false);
        
        Question q11 = new Question();
        q11.setQuestionText("Vad kallas den linje som går från norr till söder på jorden, och som går genom staden Greenwich i utkanten av London?");
        q11.setPoints(2);
        q11.setVgQuestion(false);
        q11.setMultiQuestion(true);
        List<Answer> list11= new ArrayList<Answer>();
        Answer a28 = new Answer();
        a28.setAnswerText("datumlinjen");
        a28.setCorrectAnswer(false);
        Answer a29 = new Answer();
        a29.setAnswerText("ekvatorn");
        a29.setCorrectAnswer(false);
        Answer a30 = new Answer();
        a30.setAnswerText("nollmeridianen");
        a30.setCorrectAnswer(true);
        list11.add(a28);
        list11.add(a29);
        list11.add(a30);
        q11.setAnswers(list11);
        
        Question q12 = new Question();
        q12.setQuestionText("Vilket land drabbas med jämna mellanrum av enorma skogsbränder, som breder ut sig över tusentals kvadratkilometer?");
        q12.setPoints(1);
        q12.setVgQuestion(false);
        q12.setMultiQuestion(true);
        List<Answer> list12= new ArrayList<Answer>();
        Answer a31 = new Answer();
        a31.setAnswerText("australien");
        a31.setCorrectAnswer(true);
        Answer a32 = new Answer();
        a32.setAnswerText("argentina");
        a32.setCorrectAnswer(false);
        Answer a33 = new Answer();
        a33.setAnswerText("brasilien");
        a33.setCorrectAnswer(false);
        list12.add(a31);
        list12.add(a32);
        list12.add(a33);
        q12.setAnswers(list12);
        
        Question q13 = new Question();
        q13.setQuestionText("Vad är natriumklorid?");
        q13.setPoints(1);
        q13.setVgQuestion(false);
        q13.setMultiQuestion(true);
        List<Answer> list13= new ArrayList<Answer>();
        Answer a34 = new Answer();
        a34.setAnswerText("detsamma som koksalt");
        a34.setCorrectAnswer(true);
        Answer a35 = new Answer();
        a35.setAnswerText("ett ofta använt bakpulver");
        a35.setCorrectAnswer(false);
        Answer a36 = new Answer();
        a36.setAnswerText("ett tillsatsmedel till bensin");
        a36.setCorrectAnswer(false);
        list13.add(a34);
        list13.add(a35);
        list13.add(a36);
        q13.setAnswers(list13);
        
        Question q14 = new Question();
        q14.setQuestionText("Vad kallas den fysikaliska lag som säger att en flytande kropp undantränger sin egen vikt i vätska?");
        q14.setPoints(1);
        q14.setVgQuestion(true);
        q14.setMultiQuestion(true);
        List<Answer> list14= new ArrayList<Answer>();
        Answer a37 = new Answer();
        a37.setAnswerText("Newtons lag");
        a37.setCorrectAnswer(false);
        Answer a38 = new Answer();
        a38.setAnswerText("Arkimedes lag");
        a38.setCorrectAnswer(true);
        Answer a39 = new Answer();
        a39.setAnswerText("Keplers lag");
        a39.setCorrectAnswer(false);
        list14.add(a37);
        list14.add(a38);
        list14.add(a39);
        q14.setAnswers(list14);
        
        Question q15 = new Question();
        q15.setQuestionText("Vilken är summan av vinklarnas gradtal i en triangel?");
        q15.setPoints(2);
        q15.setVgQuestion(false);
        q15.setMultiQuestion(true);
        List<Answer> list15= new ArrayList<Answer>();
        Answer a40 = new Answer();
        a40.setAnswerText("90 grader");
        a40.setCorrectAnswer(false);
        Answer a41 = new Answer();
        a41.setAnswerText("180 grader");
        a41.setCorrectAnswer(true);
        Answer a42 = new Answer();
        a42.setAnswerText("360 grader");
        a42.setCorrectAnswer(false);
        list15.add(a40);
        list15.add(a41);
        list15.add(a42);
        q15.setAnswers(list15);
        
        Question q16 = new Question();
        q16.setQuestionText("Hur ändras volymen av vatten, när det fryser till is?");
        q16.setPoints(2);
        q16.setVgQuestion(false);
        q16.setMultiQuestion(true);
        List<Answer> list16= new ArrayList<Answer>();
        Answer a43 = new Answer();
        a43.setAnswerText("Den ökar");
        a43.setCorrectAnswer(true);
        Answer a44 = new Answer();
        a44.setAnswerText("Den minskar");
        a44.setCorrectAnswer(false);
        Answer a45 = new Answer();
        a45.setAnswerText("Den ändras inte");
        a45.setCorrectAnswer(false);
        list16.add(a43);
        list16.add(a44);
        list16.add(a45);
        q16.setAnswers(list16);
        
        Question q17 = new Question();
        q17.setQuestionText("Vilken form har en pentagon?");
        q17.setPoints(1);
        q17.setVgQuestion(false);
        q17.setMultiQuestion(true);
        List<Answer> list17= new ArrayList<Answer>();
        Answer a46 = new Answer();
        a46.setAnswerText("Den är rund");
        a46.setCorrectAnswer(false);
        Answer a47 = new Answer();
        a47.setAnswerText("Den är femkantig");
        a47.setCorrectAnswer(true);
        Answer a48 = new Answer();
        a48.setAnswerText("Den er sexkantig");
        a48.setCorrectAnswer(false);
        list17.add(a46);
        list17.add(a47);
        list17.add(a48);
        q17.setAnswers(list17);
        
        Question q18 = new Question();
        q18.setQuestionText("Vem uppfann telefonen?");
        q18.setPoints(1);
        q18.setVgQuestion(false);
        q18.setMultiQuestion(true);
        List<Answer> list18= new ArrayList<Answer>();
        Answer a49 = new Answer();
        a49.setAnswerText("Thomas Edison");
        a49.setCorrectAnswer(false);
        Answer a50 = new Answer();
        a50.setAnswerText("Leonardo da Vinci");
        a50.setCorrectAnswer(false);
        Answer a51 = new Answer();
        a51.setAnswerText("Alexander Graham Bell");
        a51.setCorrectAnswer(true);
        Answer a52 = new Answer();
        a52.setAnswerText("Albert Einstein");
        a52.setCorrectAnswer(false);
        list18.add(a49);
        list18.add(a50);
        list18.add(a51);
        list18.add(a52);
        q18.setAnswers(list18);
        
        List<Question> listOfQuestions = new ArrayList<Question>();
        listOfQuestions.add(q1);
        listOfQuestions.add(q2);
        listOfQuestions.add(q3);
        listOfQuestions.add(q4);
        listOfQuestions.add(q5);
        listOfQuestions.add(q6);
        listOfQuestions.add(q7);
        listOfQuestions.add(q8);
        listOfQuestions.add(q9);
        listOfQuestions.add(q10);
        listOfQuestions.add(q11);
        listOfQuestions.add(q12);
        listOfQuestions.add(q13);
        listOfQuestions.add(q14);
        listOfQuestions.add(q15);
        listOfQuestions.add(q16);
        listOfQuestions.add(q17);
        listOfQuestions.add(q18);
        
        schooltest.setId(2);
        schooltest.setName("Test 2");
        schooltest.setQuestions(listOfQuestions);
        schooltest.setgThreshold(50);
        schooltest.setVgThreshold(50);
        schooltest.setTestTime(30);
        
        return schooltest;
        
    }
    
    
    
}




 













 
 























