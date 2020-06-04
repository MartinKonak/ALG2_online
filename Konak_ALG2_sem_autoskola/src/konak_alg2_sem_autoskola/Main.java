package konak_alg2_sem_autoskola;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;

/**
 * Main class of project
 *
 * @author Martin Koňák
 */
public class Main {

    final static int nOeQ = 3;
    final static int nOmQ = 3;
    final static int nOhQ = 3;
    final static int nOHQ = 1;
    final static String eQ = "easyQuestions.txt";
    final static String mQ = "mediumQuestions.txt";
    final static String hQ = "hardQuestions.txt";
    final static String HQ = "healthQuestions.txt";
    final static String eS = "e";
    final static String mS = "m";
    final static String hS = "h";
    final static String HS = "H";
    static int score;

    static Scanner sc = new Scanner(System.in);

    /**
     * Main method, communication with user
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws javax.mail.MessagingException
     */
    public static void main(String[] args) throws IOException, MessagingException {
        //menu vypisovaná při každém opětovném spuštění programu
        String menu = "Menu:\n1 - Start test\n2 - Show results tab\n0 - end program";
        //zpráva, která se vypíše na začátko každého testu
        String testMsg = "Zobrazí se postupně 10 otázek,\nna které lze odpovídat zadáním přísluěné odpovědi (a, b, c),\nmáš neomezený čas na splnění testu,\nobtížnost se postupně zvyšuje\nmaximální pošet bodů je 19";
        //umožňuje výběr funkcí programu
        int ch = 1;
        //odpověď, je kontrolovaná metodami níže podle konkrétních požadavků
        String answer;
        //instance logické třídy
        ProgramLogic p = new ProgramLogic();

        System.out.println(menu);
        ch = scanInt();
        while (ch > 0) {
            switch (ch) {
                //sputsí test, počítá skóre
                case 1:
                    //start
                    score = 0;
                    Timer tm = new Timer();
                    tm.setStartTime(LocalTime.now());
                    System.out.println("Start time: " + tm.getStartTimeString());
                    System.out.println(testMsg + "\n");
                    //loading questions

                    if (checkFiles(eQ) && checkFiles(mQ) && checkFiles(hQ) && checkFiles(HQ)) {

                        try {
                            p.loadQuestions(eQ, eS);
                            p.loadQuestions(mQ, mS);
                            p.loadQuestions(hQ, hS);
                            p.loadQuestions(HQ, HS);

                            //testing
                            int qcnt = 0;
                            printQuestions(p, "e", nOeQ, qcnt);
                            qcnt += nOeQ;
                            printQuestions(p,"m", nOmQ, qcnt);
                            qcnt += nOmQ;
                            printQuestions(p,"h", nOhQ, qcnt);
                            qcnt += nOhQ;
                            printQuestions(p,"H", nOHQ, qcnt);

                            //finish
                            tm.setFinishTime(LocalTime.now());
                            System.out.println("Finish time: " + tm.getFinishTimeString());
                            //saving result
                            System.out.println("This was last question.\nYour score is: " + score + "\nIn time: " + tm + "\n\nDo you want to save your result? (y/n)");
                            answer = checkAnswer(2);
                            Result r = null;
                            if (answer.equals("y")) {
                                System.out.println("Enter your name:");
                                answer = checkAnswer(3);
                                r = new Result(answer, score, tm.toString());
                                savingProcess(p, r);
                            }
                            //sending result
                            System.out.println("Do you want to send result on email? (y/n)");
                            answer = checkAnswer(2);
                            if (answer.equals("y")) {
                                System.out.println("Entter your email address:");
                                answer = checkAnswer(3);
                                if (p.sendingEmail(answer, r.toString())){
                                    System.out.println("Emeil succesfuly sent.");
                                }else{
                                    System.out.println("An error occured while configuring email.");
                                }
                            }

                        } catch (IOException e) {//catch až na konci práce se soubory
                            System.out.println("An error occured, test failed.");
                        }

                    }else{
                        System.out.println("Wrong names of text files!");
                    }

                    System.out.println(menu);
                    break;
                //vypíše výsledkovou tabulku, dá možnost ji seřadit nebo jít zpět
                case 2:
                    System.out.println(printResults(p));//výpis
                    System.out.println("Options:\n1 - sort list\n2 - clear tab\n0 - go back");//nabídka
                    answer = checkAnswer(4);
                    if (answer.equals("1")) {
                        System.out.println("By name or by score? n/s");
                        String answr = checkAnswer(5);
                        System.out.println(printSortedResults(p, 2, answr));//seřazené výsledky
                    } else if (answer.equals("2")) { //úplné smazání tabulky
                        System.out.println("Are you sure? (y/n)\ny will delete all results permanently");
                        answer = checkAnswer(2);
                        if (answer.equals("y")) { // finální ujištění
                            p.clearResults();
                            p.saveResult(p.resultsToString(p.getResults()));
                            System.out.println(p.getResults());
                        }
                    }
                    System.out.println(menu);
                    break;
                default: // při špatném vstupu
                    System.out.println("Wrong choice!");
            }
            ch = scanInt(); //nčítání každé odpovědi při výběru v menu
        }
        System.out.println("End program...");//last message
    }
    /**
     * Method checks file with regular expresion, if it is a test file
     * @param s - name of file
     * @return 
     */
    public static boolean checkFiles(String s) {
        Pattern p = Pattern.compile(".txt$");
        Matcher m = p.matcher(s);
        if (m.find()) {
            return true;
        }else{
            return false;
        }
    }
    /**
     * Method print questions in selected order
     * @param p - programLogic
     * @param ch - choice - type of questions
     * @param times - int - how many questions
     * @param qcnt - int - counter of questions
     */
    public static void printQuestions(ProgramLogic p,String ch, int times, int qcnt) {
        Question q = null;
        String answer;
        for (int i = 0; i < times; i++) { // for easy
            System.out.print((i + qcnt + 1) + ") ");
            q = p.selectQ(ch); // selecting random question
            System.out.println(q); //printing question
            answer = checkAnswer(1); //reading and checking answer
            System.out.println(answering(q, answer)); //printing answer of program
            if (answering(q, answer).equals("Correct answer, you scored a point.")) { //if right, raise score
                switch (ch) {
                    case "e":
                        score++;
                        break;
                    case "m":
                        score += 2;
                        break;
                    case "h":
                        score += 3;
                        break;
                    case "H":
                        score++;
                        break;
                }
            }
            System.out.println("\nScore: " + score); //print score
        }
    }

    /**
     * Method returns line for answer from input
     *
     * @param q - actual object question
     * @param a - answer from input
     * @return String - right answer
     */
    public static String answering(Question q, String a) {
        String answer = "";

        switch (a) {
            case "a":
                if (q.getB1()) {
                    answer = "Correct answer, you scored a point.";
                } else {
                    answer = "Incorrect answer!\nCorrect was: " + q.findCorrectAnswer();
                }
                break;
            case "b":
                if (q.getB2()) {
                    answer = "Correct answer, you scored a point.";
                } else {
                    answer = "Incorrect answer!\nCorrect was: " + q.findCorrectAnswer();
                }
                break;
            case "c":
                if (q.getB3()) {
                    answer = "Correct answer, you scored a point.";
                } else {
                    answer = "Incorrect answer!\nCorrect was: " + q.findCorrectAnswer();
                }
                break;
        }

        return answer;
    }

    /**
     * Method runs saving process into text file
     *
     * @param t - instance of logic class
     * @param r - object result
     * @throws IOException
     */
    public static void savingProcess(ProgramLogic t, Result r) throws IOException {
        t.loadResults();
        StringBuilder results = new StringBuilder(t.resultsToString(t.getResults()));
        t.saveResult(results.toString() + r);
        t.clearResults();
    }

    /**
     * Method prints results saved in text file
     *
     * @param t - instance of logic class
     * @return - String value of results
     * @throws IOException
     */
    public static String printResults(ProgramLogic t) throws IOException {
        t.loadResults();
        StringBuilder results = new StringBuilder(t.resultsToString(t.getResults()));
        t.clearResults();
        return results.toString();
    }

    /**
     * Method prints sorted results
     *
     * @param t - instance of logic class
     * @param s - switcher - 1: comaringInterface; 2: comparator
     * @return - String value of sorted results
     * @throws IOException
     */
    public static String printSortedResults(ProgramLogic t, int s, String sw) throws IOException {
        switch(s){
            //comparingInterface
            case 1:
                return t.resultsToString(t.getComparedResults());
            //comparator
            case 2:
                return t.resultsToString(t.comparatorUse(sw));
            default:
                return "Wrong parameter!";        
        }               
    }

    /**
     * Method checks intput if its correct integer
     *
     * @return n - checked integer from input
     */
    public static int scanInt() {
        int n = 0;
        boolean correct = false;
        while (!correct) {
            try {
                n = sc.nextInt();
                correct = true;
            } catch (Exception e) {
                System.out.println("Wrong input format!");
                sc.next();
            }
        }

        return n;
    }

    /**
     * Method checks String input
     *
     * @param switcher - changes way of checking
     * @return - checked String from input
     */
    public static String checkAnswer(int switcher) {
        boolean correct = false;
        String[] ZOT = {"0", "1", "2"};
        String[] corAns = {"a", "b", "c"};
        String[] question = {"y", "n"};
        String[] comp = {"n", "s"};
        String a = "e";        

        while (!correct) {
            try {
                a = sc.next();
            } catch (Exception e) {
                System.out.println("Wrong input format!");
                sc.next();
            }
            switch (switcher) {
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
                //s/n
                case 5:
                    for (String i : comp) {
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
