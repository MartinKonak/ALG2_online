/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevengame;

/**
 *
 * @author Martin Koňák
 */
public class Card {
    private int val; //A=1
    private int symbol;//0 = hearts, 1 = diamonds, 2 = clubs, 3 = spades
    private int points;
    private String name = "";
    
    public Card(int val, int symbol){
        this.val = val;
        this.symbol = symbol;
        name = makeName();
        points = setPoints();
    }

    public int getVal() {
        return val;
    }
    public int getSymbol() {
        return symbol;
    }    
    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }
    
    public int setPoints(){
        if (val < 11) {
            points = val;
        }else{
            val = 0;
        }        
        return points;
    }    
    public String makeName() {
        switch(symbol){
            case 0:
                name = "S";
                break;
            case 1:
                name = "G";
                break;
            case 2:
                name = "K";
                break;
            case 3:
                name = "Z";
                break;
        }
        switch(val){
            case 1:
                name += " A";
                break;
            case 2:
                name += " 2";
                break;
            case 3:
                name += " 3";
                break;
            case 4:
                name += " 4";
                break;
            case 5:
                name += " 5";
                break;
            case 6:
                name += " 6";
                break;
            case 7:
                name += " 7";
                break;
            case 8:
                name += " 8";
                break;
            case 9:
                name += " 9";
                break;
            case 10:
                name += "10";
                break;
            case 11:
                name += " J";
                break;
            case 12:
                name += " Q";
                break;
            case 13:
                name += " K";
                break;
        }        
        
        return name;
    }

    
    
    
}
