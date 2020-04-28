/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevengame;

import java.util.ArrayList;

/**
 *
 * @author Martin Koňák
 */
public class GameLogic {
    public static ArrayList<Card> l = new ArrayList<Card>();
    public static Card[] board = new Card[9];
    
    public static void setDeck(){
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                l.add(new Card(j, i));
            }
        }
    }    
    public static void shuffle(){
        int a;
        
        ArrayList<Card> savel = new ArrayList<Card>(l);
        l.clear();
        while(savel.size() != 0){
            a = (int)(Math.random()*savel.size());
            l.add(savel.get(a));
            savel.remove(a);
        }
    }    
    public static void setBoard(){
        for (int i = 0; i < 9; i++) {
            board[i] = l.get(i);
            l.remove(i);
        }
    }
    public static void newGame(){
        setDeck();
        shuffle();
        setBoard();
    }
    public static void changeCard(int val, int symbol){
        for (int i = 0; i < board.length; i++) {
            if (board[i].getVal() == val && board[i].getSymbol() == symbol) {
                board[i] = l.get(0);
                l.remove(0);
            }else{
                board[i] = new Card(0, 0);
            }
        }
        /*for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getVal() == val && l.get(i).getSymbol() == symbol) {
                l.remove(i);
            }
        }*/
    }
    public static boolean isEnd(){
        boolean isKing = false;
        boolean isQueen = false;
        boolean isJack = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {                
                if(board[j].getVal() == 11){
                    isJack = true;
                }
                if(board[j].getVal() == 12){
                    isQueen= true;
                }
                if(board[j].getVal() == 13){
                    isKing= true;
                }
                if (isJack && isQueen && isKing) {
                    return false;
                }
                if (board[i].getVal() + board[j].getVal() == 11) {
                    return false;
                }
            }
        }        
        return true;
    }
    
    public static boolean select2(int c1, int c2){
        int val1 = board[c1-1].getVal();
        int val2 = board[c2-1].getVal();
        
        if (val1 + val2 == 11) {
            changeCard(board[c1-1].getVal(), board[c1-1].getSymbol());
            changeCard(board[c2-1].getVal(), board[c2-1].getSymbol());
            return true;
        }else{
            return false;
        }
    }
    public static boolean select3(int c1, int c2, int c3){
        if (isValid(c1) && isValid(c2) && isValid(c3)) {
            changeCard(board[c1-1].getVal(), board[c1-1].getSymbol());
            changeCard(board[c2-1].getVal(), board[c2-1].getSymbol());
            changeCard(board[c3-1].getVal(), board[c3-1].getSymbol());
            return true;
        }else{
            return false;
        }
    }
    public static boolean isValid(int c){
        if (board[c-1].getVal() > 10) {
            return true;
        }else{
            return false;
        }
    }   
    
}
