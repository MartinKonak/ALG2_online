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
        String testMsg = "Zobrazí se postupně 10 otázek,\nna které lze odpovídat zadáním přísluěné odpovědi (a, b, c),\nmáš neomezený čas na splnění testu,\nkaždá otázka = 1 bod (max je tedy 10)";
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
                    score = 0;
                    Timer tm = new Timer();
                    tm.setStartTime(LocalTime.now());
                    System.out.println("Start time: " + tm.getStartTimeString());
                    System.out.println(testMsg + "\n");
                    
                    for (int i = 0; i < 3; i++) {
                        try{
                            p.loadQuestions();        
                        }catch(IOException e){
                            System.out.println("File does not found");
                        }
                        Question q = p.selectQ();
                        System.out.println(q);
                        answer = checkAnswer(1);
                        switch(answer){
                            case "a":
                                if (q.getB1()){
                                    System.out.println("Correct answer, you got 1 point.");
                                    score++;
                                }else{
                                    System.out.println("Incorrect answer!");
                                    System.out.println("Correct was: " + q.findCorrectAnswer());
                                }
                                break;
                            case "b":
                                if (q.getB2()){
                                    System.out.println("Correct answer, you got 1 point.");
                                    score++;
                                }else{
                                    System.out.println("Incorrect answer!");
                                    System.out.println("Correct was: " + q.findCorrectAnswer());
                                }
                                break;
                            case "c":
                                if (q.getB2()){
                                    System.out.println("Correct answer, you got 1 point.");
                                    score++;
                                }else{
                                    System.out.println("Incorrect answer!");
                                    System.out.println("Correct was: " + q.findCorrectAnswer());
                                }
                                break;
                        }
                        System.out.println("\nScore: " + score);
                    }
                    tm.setFinishTime(LocalTime.now());
                    System.out.println("Finish time: " + tm.getFinishTimeString());
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
                    System.out.println("Do you want to sort list? (y/n)");
                    answer = checkAnswer(2);
                    if (answer.equals("y")) {                        
                        System.out.println(printSortedResults(p));
                    }                    
                    System.out.println(menu);                    
                    break;
                default:
                    System.out.println("Wrong choice!");
            } 
            ch = scanInt();
        }
    }
    
    /**
     * 
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
            }
            System.out.println("I don´t understand, try again");            
        }        
        return null;
    }
}
