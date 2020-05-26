package pkg08_elevengame;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        programLogic p = new programLogic();
        System.out.println("\nEleven game:\nq - quit\ns2 - select two cards\ns3 - select three cards\n");
        p.newGame();    
        while(p.isLost())
            p.newGame();    
        dispBoard(p);
        String s = sc.next();
        
        while(!"q".equals(s)){
            switch(s){
                case "s2":
                    System.out.println("Select two cards\n0 = ♥, 1 = ♦, 2 = ♣, 3 = ♠\nA, 2-10, J, Q, K\ne.g. 05 3Q");
                    if(!p.select(sc.next(),sc.next()))
                        System.out.println("And now try for a change to select right cards");
                    break;
                case "s3":
                    System.out.println("Select three cards\n0 = ♥, 1 = ♦, 2 = ♣, 3 = ♠\nA, 2-10, J, Q, K\ne.g. 1J 3Q 2K");
                    if(!p.select(sc.next(),sc.next(),sc.next()))
                        System.out.println("And now try for a change to select right cards");
                    break;
                default:
                    System.out.println("You jerk, can't you write a proper command?! Try harder");
            }
            dispBoard(p);
            if(p.isLost()){
                System.out.println("Your a looser... I knew it from the beginning.\nWanna try again? Why should I ask you...\nHere is new deal!");
                p.newGame();
                while(p.isLost())
                    p.newGame();
                dispBoard(p);
            }
            for (int i = 0; i < p.board.length; i++) {
                if(p.board[i]!=null){
                    break;
                }else if (i == p.board.length-1){
                System.out.println("Impossible... you won?\nIt was just a sheer luck, here is a new deal to prove,\nyou're nothing but a looser.");
                p.newGame();
                while(p.isLost())
                    p.newGame();
                dispBoard(p);
                }
            }
            
            s = sc.next();
            
        }
        System.out.println("See u next time!");
        
    }

    public static void dispDeck(programLogic p){
        for (int i = 0; i < p.getCards().size(); i++){
            System.out.println(p.getCards().get(i).name);
        }
    }
    
    public static void dispBoard(programLogic p){
        for (int i = 0; i < 9; i++){
            if(i%3==0)
                System.out.println("");
            if(p.board[i]!=null){
                System.out.print(p.board[i].name+" ");
            }else{
                System.out.print("   ");
            }
        }
        System.out.println("");
    }
}