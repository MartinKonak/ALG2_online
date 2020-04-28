/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevengame;

import java.util.Scanner;


/**
 *
 * @author Martin Koňák
 */
public class ElevenGame extends GameLogic{
    //public static final String ANSI_RESET = "\u001B[0m";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = "2 - select 2 cards\n3 - select 3 cards\n0 - quit";
        System.out.println("Eleven Game");   
        
        newGame();
        displayBoard();
        System.out.println(menu);        
        
        int ch = sc.nextInt();       
        
        while(ch > 0){
            
            switch(ch){
                case 2:                    
                    if (!select2(sc.nextInt(), sc.nextInt())) {
                        System.out.println("Wrong choice");
                        displayBoard();
                        break;
                    }else{
                        System.out.println("OK, continue");
                        displayBoard();
                        break;
                    }
                case 3:
                    if (!select3(sc.nextInt(), sc.nextInt(), sc.nextInt())) {
                        System.out.println("Wrong choice");
                        displayBoard();
                        break;
                    }else{
                        System.out.println("OK, continue");
                        displayBoard();
                        break;
                    }
                case 0:
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            if (isEnd()) {
                System.out.println("Game Over");
                ch = 0;
            }else{
                System.out.println(menu);
                ch = sc.nextInt();
            }           
        }       
    }
    
    
/*    public static void displayDeck(){
        int c = 0;
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i).getName() + " ");
            c++;
            if (c == 13) {
                System.out.println();
                c = 0;
            }
        }
    }*/

    public static void displayBoard(){
        String numbers = "  1   2   3   4   5   6   7   8   9";
        String line = "+---+---+---+---+---+---+---+---+---+";
        System.out.println(numbers);
        System.out.println(line);
        for (int i = 0; i < 9; i++) {            
            if (board[i].getVal() != 0) {
                System.out.print("|" + board[i].getName());
            }else{
                System.out.print("|   ");
            }            
        }
        System.out.print("|");
        System.out.println();
        System.out.print(line);
        System.out.println();
    }
}
