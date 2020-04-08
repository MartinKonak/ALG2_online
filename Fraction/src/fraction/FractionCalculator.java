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
public class FractionCalculator {
    
    public static int findSameDenominator(int aD, int bD){
        int denom;
        if (aD != bD) {
            denom = aD*bD;
        }else{
            denom = aD;
        }
        return denom;
    }
    
    public static Fraction plus(Fraction a, Fraction b) {
        int denom = findSameDenominator(a.getDenominator(), b.getDenominator());
        int num = ( ((denom/a.getDenominator())*a.getNumerator()) + ((denom/b.getDenominator())*b.getNumerator()) );
        
        return new Fraction(num, denom);
    }
    
    public static Fraction minus(Fraction a, Fraction b) {
        int denom = findSameDenominator(a.getDenominator(), b.getDenominator());
        int num = ( ((denom/a.getDenominator())*a.getNumerator()) - ((denom/b.getDenominator())*b.getNumerator()) );
        
        return new Fraction(num, denom);
    }
    
    public static Fraction multiply(Fraction a, Fraction b) {
        int num = (a.getNumerator()*b.getNumerator());
        int denom = (a.getDenominator()*b.getDenominator());
        return new Fraction(num, denom);
    }
    
    public static Fraction divide(Fraction a, Fraction b) {
        int num = (a.getNumerator()*b.getDenominator());
        int denom = (a.getDenominator()*b.getNumerator());
        return new Fraction(num, denom);
    }
    
    
    
    public static void main(String[] args){
        Fraction a = new Fraction(2, 3);
        Fraction b = new Fraction(4, 3);
        System.out.println((plus(a, b)));
        System.out.println((minus(a, b)));
        System.out.println((multiply(a, b)));
        System.out.println((divide(a, b)));
    }
}
