/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraction;

/**
 *
 * @author Martin Koňák
 */
public class Fraction {
    private int numerator;
    private int denominator;
    
    public Fraction (int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public int getNumerator(){
        return numerator;
    }
    
    public int getDenominator(){
        return denominator;
    }
    
    public void simple(){
        int h;
        int n = this.numerator;
        int d = this.denominator;
        
        //najde společné
        while(d != 0) {
            h = d;
            d = n%d;
            n = h;
        }
        // upraví
        this.numerator = this.numerator / n;
        this.denominator = this.denominator / n;
    }
    
    @Override
    public String toString(){
        return numerator + "/" + denominator;
    }
}
