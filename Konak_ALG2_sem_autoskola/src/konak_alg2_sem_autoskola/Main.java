package konak_alg2_sem_autoskola;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Main class of project
 * @author Martin Koňák
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    /**
     * Main method, communication with user
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String menu = "Menu:\n1 - Start test\n2 - Show results tab\n0 - end program";
        String testMsg = "Zobrazí se postupně 10 otázek,\nna které lze odpovídat zadáním přísluěné odpovědi (a, b, c),\nmáš neomezený čas na splnění testu,\nobtížnost se postupně zvyšuje\nmaximální pošet bodů je 19";
        int ch = 1;
        String answer;
        int score;
        ProgramLogic p = new ProgramLogic();
          
        System.out.println(menu);
        ch = scanInt();
        while(ch > 0){
            switch(ch){
                //sputsí test, počítá skóre
                case 1:
                    //start
                    Question q = null;
                    score = 0;
                    Timer tm = new Timer();
                    tm.setStartTime(LocalTime.now());
                    System.out.println("Start time: " + tm.getStartTimeString());
                    System.out.println(testMsg + "\n");  
                    //loading questions
                    try{
                            p.loadQuestions("easyQuestions.txt", "e");
                            p.loadQuestions("mediumQuestions.txt", "m");
                            p.loadQuestions("hardQuestions.txt", "h");
                            p.loadQuestions("healthQuestions.txt", "H");
                        }catch(IOException e){
                            System.out.println("File does not found");
                        }
                    
                    for (int i = 0; i < 3; i++) { // for easy
                        System.out.print((i + 1) + ") "); //number of question
                        q = p.selectQ("e"); // selecting random question
                        System.out.println(q); //printing question
                        answer = checkAnswer(1); //reading and checking answer
                        System.out.println(answering(q, answer)); //printing answer of program
                        if (answering(q, answer).equals("Correct answer, you scored a point.")) { //if right, raise score
                            score++;
                        }
                        System.out.println("\nScore: " + score); //print score
                    }
                    for (int j = 0; j < 3; j++) { //for medium
                        System.out.print((j + 4) + ") ");
                        q = p.selectQ("m");
                        System.out.println(q);
                        answer = checkAnswer(1);
                        System.out.println(answering(q, answer));
                        if (answering(q, answer).equals("Correct answer, you scored a point.")) {
                            score += 2;
                        }
                        System.out.println("\nScore: " + score);
                    }
                    for (int k = 0; k < 3; k++) { //for hard
                        System.out.print((k + 7) + ") ");
                        q = p.selectQ("h");
                        System.out.println(q);
                        answer = checkAnswer(1);
                        System.out.println(answering(q, answer));
                        if (answering(q, answer).equals("Correct answer, scored a point.")) {
                            score += 3;
                        }
                        System.out.println("\nScore: " + score);
                    }           
                    //health question
                    System.out.print("10) ");
                    q = p.selectQ("H");
                    System.out.println(q);
                    answer = checkAnswer(1);
                    System.out.println(answering(q, answer));
                    if (answering(q, answer).equals("Correct answer, scored a point.")) {
                        score++;
                    }
                    System.out.println("\nScore: " + score);
                    //finish
                    tm.setFinishTime(LocalTime.now());
                    System.out.println("Finish time: " + tm.getFinishTimeString());
                    //saving result
                    System.out.println("This was last question.\nYour score is: " + score + "\nIn time: " + tm + "\n\nDo you want to save your result? (y/n)");
                    answer = checkAnswer(2);
                    if (answer.equals("y")) {
                        System.out.println("Enter your name:");
                        answer = checkAnswer(3);
                        Result r = new Result(answer, score, tm.toString());                        
                        savingProcess(p, r);
                    }
                    
                    System.out.println(menu);                    
                    break;
                //vypíše výsledkovou tabulku, dá možnost ji seřadit nebo jít zpět
                case 2:
                    System.out.println(printResults(p));
                    System.out.println("Options:\n1 - sort list\n2 - clear tab\n0 - go back");
                    answer = checkAnswer(4);
                    if (answer.equals("1")) {                        
                        System.out.println(printSortedResults(p));
                    }else if (answer.equals("2")) {
                        System.out.println("Are you sure? (y/n)\ny will delete all results permanently");
                        answer = checkAnswer(2);
                        if (answer.equals("y")) {
                            p.clearResults();
                            p.saveResult(p.resultsToString(p.getResults()));
                            System.out.println(p.getResults());
                        }
                    }
                    System.out.println(menu);                    
                    break;
                default:
                    System.out.println("Wrong choice!");
            } 
            ch = scanInt();
        }
        System.out.println("End program...");
    }
    
    /**
     * Method returns line for answer from input
     * @param q - actual object question
     * @param a - answer from input
     * @return String - right answer
     */
    public static String answering(Question q, String a){
        String answer = "";
        
        switch(a){
            case "a":
                if (q.getB1()){
                    answer = "Correct answer, you scored a point.";
                }else{
                    answer = "Incorrect answer!\nCorrect was: " + q.findCorrectAnswer();
               }
                break;
            case "b":
                if (q.getB2()){
                    answer = "Correct answer, you scored a point.";
                }else{
                    answer = "Incorrect answer!\nCorrect was: " + q.findCorrectAnswer();
                }
                break;
            case "c":
                if (q.getB3()){
                    answer = "Correct answer, you scored a point.";
                }else{
                    answer = "Incorrect answer!\nCorrect was: " + q.findCorrectAnswer();
                }
                break;
            }
        
        return answer;
    }
    
    /**
     * Method runs saving process into text file
     * @param t - instance of logic class
     * @param r - object result
     * @throws IOException 
     */
    public static void savingProcess(ProgramLogic t, Result r) throws IOException{
        t.loadResults();
        StringBuilder results = new StringBuilder(t.resultsToString(t.getResults()));
        t.saveResult(results.toString() + r);
        t.clearResults();
    }
    
    /**
     * Method prints results saved in text file
     * @param t - instance of logic class
     * @return - String value of results
     * @throws IOException 
     */
    public static String printResults(ProgramLogic t) throws IOException{
        t.loadResults();
        StringBuilder results = new StringBuilder(t.resultsToString(t.getResults()));  
        t.clearResults();
        return results.toString();
    }  
    
    /**
     * Method prints sorted results
     * @param t - instance of logic class
     * @return - String value of sorted results
     * @throws IOException 
     */
    public static String printSortedResults(ProgramLogic t) throws IOException{
        return t.resultsToString(t.getComparedResults());
    }
    
    /**
     * Method checks intput if its correct integer
     * @return n - checked integer from input
     */
    public static int scanInt(){
        int n = 0;
        boolean correct = false;   
        while(!correct){
            try{
                n = sc.nextInt();
                correct = true;
            }catch(Exception e){
                System.out.println("Wrong input format!");
                sc.next();
            }
        }
        
        return n;
    }
    
    /**
     * Method checks String input
     * @param switcher - changes way of checking
     * @return - checked String from input
     */
    public static String checkAnswer(int switcher){        
        boolean correct = false;
        String[] ZOT = {"0", "1", "2"};
        String[] corAns = {"a", "b", "c"};
        String[] question = {"y", "n"};
        String a = "e";
        
        while(!correct){
            try{
                a = sc.next();
            }catch(Exception e){
                System.out.println("Wrong input format!");
                sc.next();
            }
            switch(switcher){
                //pro odpovědi v testu
                case 1:
                    for (String i : corAns) {
                        if (a.equals(i)) {
                        correct = true;
                        return a;
                        }
                    }
                    break;
                //pro odpovědi ano/ne
                case 2:
                    for (String i : question) {
                        if (a.equals(i)) {
                        correct = true;
                        return a;
                        }
                    }
                    break;
                //pro uložení jména
                case 3:
                    return a;
                //pro odpovědi v testu
                case 4:
                    for (String i : ZOT) {
                        if (a.equals(i)) {
                        correct = true;
                        return a;
                        }
                    }
                    break;
            }
            System.out.println("I don´t understand, try again");            
        }        
        return null;
    }
}
