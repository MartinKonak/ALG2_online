package pkg08_elevengame;

import java.util.ArrayList;

public class programLogic{
    public static ArrayList<Card> cards = new ArrayList<Card>();
    public static Card[] board = new Card[9];
    
    public static void setDeck(){
        for (int i = 1; i < 14; i++){
            for (int j = 0; j < 4; j++){
                cards.add(new Card(i,j));
            }
        }
    }
    
    public static void setBoard(){
        for (int i = 0; i < 9; i++){
            board[i] = cards.get(0);
            cards.remove(0);
        }
    }
    
    public static void shuffle(){
        int a;
        
        ArrayList<Card> savel = new ArrayList<Card>(cards);
        cards.clear();
        while(savel.size()!=0){
            a = (int)(Math.random()*savel.size());
            cards.add(savel.get(a));
            savel.remove(a);
        }
    }
    
    public static void replaceCard(int val, int sym){
        for (int i = 0; i < board.length; i++){
            if(board[i]!=null&&board[i].val==val&&board[i].symbol==sym){
                if(cards.size()>0){
                    board[i]=cards.get(0);
                    cards.remove(0);
                }else{
                    board[i]=null;
                }
            }
        }
    }
    
    public static boolean isLost(){
        boolean isKing = false;
        boolean isQueen = false;
        boolean isJack = false;
        boolean allNull = true;
        for (int i = 0; i < board.length; i++){
            for (int j = i; j < board.length; j++){
                if(board[i]==null||board[j]==null)
                    continue;
                else
                    allNull = false;
                if(board[i].val+board[j].val==11)
                    return false;
                if(board[i].val==11)
                    isJack = true;
                if(board[i].val==12)
                    isQueen= true;
                if(board[i].val==13)
                    isKing = true;
                if(isJack && isQueen && isKing)
                    return false;
            }
        }
        if(allNull){
            return false;
        }else{
            return true;
        }
    }
    
    public static void newGame(){
        setDeck();
        shuffle();
        setBoard();
    }
    
    public static boolean select(String s1, String s2){
        int sym1 = Character.getNumericValue(s1.charAt(0));
        int val1;
        if(s1.endsWith("10"))
            val1=10;
        else if (s1.endsWith("J"))
            val1 = 11;
        else if (s1.endsWith("Q"))
            val1 = 12;
        else if (s1.endsWith("K"))
            val1 = 13;
        else if (s1.endsWith("A"))
            val1 = 1;
        else
            val1 = Character.getNumericValue(s1.charAt(1));
        
        int sym2 = Character.getNumericValue(s2.charAt(0));
        int val2;
        if(s2.endsWith("10"))
            val2=10;
        else if (s2.endsWith("J"))
            val2 = 11;
        else if (s2.endsWith("Q"))
            val2 = 12;
        else if (s2.endsWith("K"))
            val2 = 13;
        else if (s2.endsWith("A"))
            val2 = 1;
        else
            val2 = Character.getNumericValue(s2.charAt(1));
        if(val1+val2!=11)
            return false;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if(board[i]!=null&&board[j]!=null&&board[i].val == val1 && board[i].symbol == sym1&&board[j].val == val2 && board[j].symbol == sym2){
                    replaceCard(val1, sym1);
                    replaceCard(val2, sym2);
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean select(String s1, String s2, String s3){
        int sym1 = Character.getNumericValue(s1.charAt(0));
        int val1;
        if(s1.endsWith("10"))
            val1=10;
        else if (s1.endsWith("J"))
            val1 = 11;
        else if (s1.endsWith("Q"))
            val1 = 12;
        else if (s1.endsWith("K"))
            val1 = 13;
        else if (s1.endsWith("A"))
            val1 = 1;
        else
            val1 = Character.getNumericValue(s1.charAt(1));
        
        int sym2 = Character.getNumericValue(s2.charAt(0));
        int val2;
        if(s2.endsWith("10"))
            val2=10;
        else if (s2.endsWith("J"))
            val2 = 11;
        else if (s2.endsWith("Q"))
            val2 = 12;
        else if (s2.endsWith("K"))
            val2 = 13;
        else if (s2.endsWith("A"))
            val2 = 1;
        else
            val2 = Character.getNumericValue(s2.charAt(1));
        
        int sym3 = Character.getNumericValue(s3.charAt(0));
        int val3;
        if(s3.endsWith("10"))
            val3=10;
        else if (s3.endsWith("J"))
            val3 = 11;
        else if (s3.endsWith("Q"))
            val3 = 12;
        else if (s3.endsWith("K"))
            val3 = 13;
        else if (s3.endsWith("A"))
            val3 = 1;
        else
            val3 = Character.getNumericValue(s3.charAt(1));
        if(!((val1==11||val2==11||val3==11)&&(val1==12||val2==12||val3==12)&&(val1==13||val2==13||val3==13)))
            return false;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                for (int k = 0; k < board.length; k++){
                    if(board[i]!=null&&board[k]!=null&&board[j]!=null&&board[i].val == val1 && board[i].symbol == sym1&&board[j].val == val2 && board[j].symbol == sym2&&board[k].val == val3 && board[k].symbol == sym3){
                        replaceCard(val1, sym1);
                        replaceCard(val2, sym2);
                        replaceCard(val3, sym3);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }
}