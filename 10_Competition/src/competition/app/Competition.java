package competition.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Martin Koňák
 */
public class Competition {
    private ArrayList<Runner> runners = new ArrayList<Runner>();

    public void load(String startFile, String finishFile) throws FileNotFoundException, IOException {
        // nacitani pomoci Scanneru
        File startFileF = new File(startFile);
        Scanner inStart = new Scanner(startFileF);
        while(inStart.hasNext()){
            int number = inStart.nextInt();
            String firstName = inStart.next();
            String lastName = inStart.next();
            String numbertName = inStart.next();
            Runner r = new Runner(firstName, lastName, number);
            r.setStartTime(startFile);
            runners.add(r);
        }
        
        //nacitani BufferedReader
        File finishFileF = new File(finishFile);
        BufferedReader inFinish = null;
        try{
            inFinish = new BufferedReader(new FileReader(finishFileF));
            String line;
            while((line = inFinish.readLine()) != null){
                String[] parts = line.split("[ ]+");
                Runner r = findRunner(Integer.parseInt(parts[0]));
                r.setFinishTime(parts[1]);
            }
        }finally{
            if(inFinish != null){
                inFinish.close();
            }
        }
    }
    
    private Runner findRunner(int number){
        
        return null;
    }

    public String getResults() {
        Collections.sort(runners);
        Iterator<Runner> iterator = runners.iterator();
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        while(iterator.hasNext()){
            Runner r = iterator.next();
            sb.append(String.format("%-4d. %s", n, r));
            n++;
        }
        return sb.toString();
    }

    public void saveResults(String resultFile) {
        
    }

    @Override
    public String toString() {
        return runners.toString();
    }    
    
    /*public static void main(String[] args){
        Competition c = new Competition();
        try{
            c.load("start.txt", "finish.txt");
            System.out.println(c);
        }catch(FileNotFoundException e){
            System.out.println("Nenalezen soubor.");
        }
        //System.out.println(c.getResults());
    }*/
    
}
