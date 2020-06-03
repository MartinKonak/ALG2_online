package competition.app;

import competition.utils.IllegalFilenameException;
import competition.filehandling.BinaryWriter;
import competition.filehandling.TextWriter;
import competition.filehandling.Writer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Martin Koňák
 */
public class Competition {

    private ArrayList<Runner> runners = new ArrayList<>();

    public void load(String startFilepath, String finishFilepath) throws FileNotFoundException, IOException {
        if(!startFilepath.contains("start")){
            throw new IllegalFilenameException("Start soubor musi obsahovat start."); //vyhození vlastní výjimky
        }
        
        //nacitani pomoci Scanner
        File startFile = new File(startFilepath);
        try (Scanner inStart = new Scanner(startFile)) {
            while (inStart.hasNext()) {
                int number = inStart.nextInt();
                String firstname = inStart.next();
                String lastname = inStart.next();
                String startTime = inStart.next();
                Runner r = new Runner(number, firstname, lastname);
                r.setStartTime(startTime);
                runners.add(r);
            }
        }

        //nacitani pomoci BufferedReader
        File finishFile = new File(finishFilepath);
        BufferedReader inFinish = null;
        try {
            inFinish = new BufferedReader(new FileReader(finishFile));
            String line;
            while ((line = inFinish.readLine()) != null) {
                String[] parts = line.split("[ ]+");
                try {
                    Runner r = findRunner(Integer.parseInt(parts[0]));
                    r.setFinishTime(parts[1]);
                } catch (NoSuchElementException e) {
                    System.err.print(e.getMessage());
                }
            }
        }finally{
            if(inFinish != null) inFinish.close();
        }
    }

    private Runner findRunner(int number) {
        for (Runner runner : runners) {
            if (runner.getNumber() == number) {
                return runner;
            }
        }
        throw new NoSuchElementException("Bezec s cislem " + number + " nebyl na startu."); //vyhozeni výjimky
    }

    public String getResults() {
        Collections.sort(runners);
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        for (Runner runner : runners) {
            sb.append(String.format("%-2d. %s%n", n, runner));
            n++;
        }
        return sb.toString();
    }

    public void saveResults(String resultFilepath) throws IOException {
        Collections.sort(runners);
        Writer w = null;
        if (resultFilepath.endsWith(".txt")) {
            w = new TextWriter();
        } else if (resultFilepath.endsWith(".dat")) {
            w = new BinaryWriter();
        } else {
            throw new IllegalArgumentException("Nepodporovana pripona souboru");
        }
        w.saveResults(resultFilepath, runners);
    }
}
