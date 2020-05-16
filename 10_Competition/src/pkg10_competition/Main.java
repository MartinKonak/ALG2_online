package pkg10_competition;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Martin Koňák
 */
public class Main {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Zadej jmena vstupnich souboru: ");
        Competition c = new Competition();
        String startFile = sc.next();
        String finishFile = sc.next();
        try{
            while(true){
                try{
                    c.load(startFile, finishFile);
                    break;
                }catch(FileNotFoundException e){
                    System.out.println("Neexistujici soubor/y. Zadej znovu");
                }
            }
            System.out.println(c.getResults());
            System.out.println("Zadej jmeno souboru s vysledky: ");
            String resultFile = sc.next();
            c.saveResults(resultFile);
        }catch(Exception e){
            System.out.println("Nepovedlo se.");
        }
    }
    
}
