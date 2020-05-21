package konak_alg2_sem_autoskola;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Method contains logic parts of code
 * @author Martin Koňák
 */
public class ProgramLogic{
    ArrayList<Question> questions = new ArrayList<Question>();
    ArrayList<Result> results = new ArrayList<Result>();
    
    /**
     * Method load questions from text file into ArrayList
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void loadQuestions() throws FileNotFoundException, IOException{
        File quests = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "questions.txt");
        Scanner loadQuestions = new Scanner(quests);
        while(loadQuestions.hasNext()){
            String q = loadQuestions.nextLine();
            String a1 = loadQuestions.nextLine();
            String a2 = loadQuestions.nextLine();
            String a3 = loadQuestions.nextLine();
            Question qe = new Question(q, a1, a2, a3);
            questions.add(qe);
        }
    }
    
    /**
     * Method picks one question at random
     * @return Object type Question
     */
    public Question selectQ(){
        int rnd = (int)(Math.random()*(questions.size()-2)+1);
        questions.remove(rnd);
        return questions.get(rnd);
    }
    
    /**
     * Method loads results form text file into ArrayList
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void loadResults() throws FileNotFoundException, IOException{
        File user = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "results.txt");
        Scanner loadResult = new Scanner(user);
        while(loadResult.hasNext()){
            String line = loadResult.nextLine();
            String[] r = line.split(" +");
            Result u = new Result(r[1], Integer.parseInt(r[3]), r[5]);
            results.add(u);
        }
    }
    
    /**
     * Mathod transforms ArrayList of Results into String
     * @param results - concrete ArrayList you want to transform
     * @return String line of results
     */
    public String resultsToString(ArrayList<Result> results){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < results.size(); i++) {
            sb.append(results.get(i) + "\n");
        }        
        return sb.toString();
    }
    
    /**
     * Method saves Result into text file
     * @param s - Result in String
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveResult(String s) throws FileNotFoundException, IOException{
        try{
            FileWriter writer = new FileWriter(System.getProperty("user.dir") + File.separator + "data" + File.separator + "results.txt");
            PrintWriter printResult = new PrintWriter(writer);
            printResult.print(s);
            printResult.close();
        }catch(Exception e){
            throw new IOException("An error occured");
        }
        
    } 
    
    /**
     * Getter to results
     * @return results in ArrayList
     */
    public ArrayList<Result> getResults() {
        return results;
    }
    
    /**
     * This method clears results ArrayList
     */
    public void clearResults(){
        results = new ArrayList<Result>();
    }          
    
    /**
     * Method returns sorted results
     * @return sorted ArrayList of results
     * @throws IOException 
     */
    public ArrayList<Result> getComparedResults() throws IOException {
        loadResults();
        Result[] res = new Result[results.size()];
        for (int i = 0; i < results.size(); i++) {
            res[i] = results.get(i);
        }
        sort(res);
        ArrayList<Result>comparedResults = new ArrayList<Result>();
        for (Result i : res) {
            comparedResults.add(i);
        }
        clearResults();
        return comparedResults;
    }
    
    /**
     * Sorting method (bubble sort concretly)
     * @param array - array of objects
     */
    public void sort(ComparingInterface[] array){for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if (array[j-1].isSmaller(array[j])) {
                    ComparingInterface temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}
