/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author christopher.eckles
 */
public class DistractionQuiz {
    private static Map<String, Map<String, String>> statementMap = new HashMap<>();
    private static Map<String, String> questionMap = new HashMap<>();
    
    
        
        
    private static final String WORDBANK[] = {"whale", "shark", "sheep","turkey",
        "donkey","dog","cat","pigeon","tiger","elephant","crow","lion","bear",
    "fox","wolf","monkey","peacock","panda","deer","frog","apron","vest",
    "nose","toes","mouth","apple","orange","grapes","cheese","beach","city",
    "town","mountain","lake","forest","school","pencil","rock","tree",
    "computer","book","chair","towel","spoon","arrow","pen","pencil","food",
    "seeds","coconut","chocolate","flower","ball","doll","girl","man","boy",
    "woman", "dolphin", "home", "bed"};

    public static void main(String[] args) {
        statement1();
    }
                
    public static void statement1(){
        

        statementMap.put("Rusy, the big, brown dog went to the beach on sunday. "
                + "When he was there, \nhe met a little girl who was playing with "
                + "a ball. He really wanted to play \nwith her, but he was too "
                + "big and scared her. Rusty went down to the water \nto find "
                + "another friend. Look! He saw a whale searching for food in "
                + "the \nwater. Rusty was hoping to find a dolphin friend but "
                + "instead there is a \nshark! Rusty thinks the beach is scary "
                + "and wants to go home and find a \ntowel. Hopefully the cat "
                + "hasn't stolen his bed again.\n", questionMap);
        
        questionMap.clear();
        questionMap.put("girl", "ball");
        questionMap.put("whale", "food");
        questionMap.put("shark","dolphin");
        questionMap.put("cat","bed");
        
    }//close statement1
    
    public static void statement2(){
        statementMap.put("Statement2", questionMap);
    
        questionMap.clear();
        questionMap.put("Question5", "CorrectAnswer5");
        questionMap.put("Question6", "CorrectAnswer6");
        questionMap.put("Question7", "CorrectAnswer7");
        questionMap.put("Question8", "CorrectAnswer8");
    }//close statement2
    
    public static void statement3(){
        statementMap.put("Statement 3", questionMap);
        
        questionMap.clear();
        questionMap.put("Question9", "CorrectAnswer9");
        questionMap.put("Question10", "CorrectAnswer10");
        questionMap.put("Question11", "CorrectAnswer11");
        questionMap.put("Question12", "CorrectAnswer12");
    }//close statement3
        
    
    /*for (Map.Entry<String, Map<String, String>> entry : statementMap.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<String, String> questions : entry.getValue().entrySet()) {
                System.out.println("What word was associated with " + questions.getKey() + "?");
                generatePossibleAnswers(questions.getValue());
            }
        }
    }*/
    
    
    private static void generatePossibleAnswers(String correctAnswer){
        //randomize until 4 answers are generated for multiple choice list
        ArrayList<String> answers = new ArrayList<>();
           answers.add(correctAnswer);
        while(answers.size() < 4){
            int rand = RandomNumber.generateRandomLocation(WORDBANK.length);
            boolean add = true;
            String answerToAdd = WORDBANK[rand];
            for(String answer: answers){
                if(answer.equals(answerToAdd)){
                    add = false;
                }//close if
            }//close for
            if(add){
                answers.add(WORDBANK[rand]);
            }//close if
        }//close while loop
        
        //shuffle answer order
        Collections.shuffle(answers);
        ListIterator<String> iter = answers.listIterator(0);
        
        //display list of multiple choice answers
        while(iter.hasNext()){
            System.out.println(iter.nextIndex()+1 +"." + iter.next());
        }//close while loop
        
        //collect user answer
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt()-1;
        
        //check for correct answer
        if(answers.get(userChoice).equals(correctAnswer)){
            System.out.println("Correct!");
        }else{System.out.println("Incorrect");
        }//close if/else
        
    }
    
}
