/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author christopher.eckles
 */
public class DistractionQuiz {

    private static String wordBank[] = {"String", "String"};

    public static void main(String[] args) {
        Map<String, Map<String, String>> statementMap = new HashMap<>();
        Map<String, String> questionMap = new HashMap<>();
        questionMap.put("Question1", "CorrectAnswer1");
        questionMap.put("Question2", "CorrectAnswer2");

        questionMap = new HashMap<>();
        questionMap.put("Question3", "CorrectAnswer3");
        questionMap.put("Question4", "CorrectAnswer4");

        statementMap.put("This is the first statement", questionMap);

        questionMap = new HashMap<>();
        questionMap.put("Question5", "CorrectAnswer5");
        questionMap.put("Question6", "CorrectAnswer6");

        statementMap.put("This is the second statement", questionMap);

        for (Map.Entry<String, Map<String, String>> entry : statementMap.entrySet()) {
            System.out.println(entry.getKey());
            //time delay
            for (Map.Entry<String, String> questions : entry.getValue().entrySet()) {
                System.out.println("What word was associated with " + questions.getKey() + "?  Answer:" + questions.getValue());
                generatePossibleAnswers(questions.getValue());
            }
        }
    }
    private static void generatePossibleAnswers(String correctAnswer){
        //randomize until 4 answers are generated
        //print the 4 answers with either numbers or lettesr
        ArrayList<String> answers = new ArrayList<>();
           answers.add(correctAnswer);
        while(answers.size() < 4){
        int rand = RandomNumber.generateRandomLocation(wordBank.length);
        boolean add = true;
        String answerToAdd = wordBank[rand];
        for(String answer: answers){
            if(answer.equals(answerToAdd))
                add = false;
        }
        if(add){
          answers.add(wordBank[rand]);
        }
        }
        //todo  while(answers.size)
        
        
    }
    
}
