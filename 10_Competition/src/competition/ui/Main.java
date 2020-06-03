package competition.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import competition.app.Competition;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Martin Koňák
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Competition c = new Competition();
        System.out.println("Zadej nazvy vstupnich souboru");
        try{
            while(true){
                try {
                    String startFile = sc.next();
                    String finishFile = sc.next();
                    c.load(startFile, finishFile);
                    break;
                }catch(FileNotFoundException e){
                    System.out.println("Zadany neexistujici subor. Zadej znovu.");
                }
            }
                System.out.println(c.getResults());
                System.out.println("Zadej nazev vystupniho souboru");
                String resultFile = sc.next();
                c.saveResults(resultFile);
                System.out.println("Data byla ulozena");
        }catch(IOException e){
            System.out.println("Chyba pri cteni a zapisu");
        }
    }
}
