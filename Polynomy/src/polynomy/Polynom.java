/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomy;

import java.util.Arrays;

/**
 *
 * @author Martin Koňák
 */
public class Polynom {

    private static String toString(String[] pol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //0 1 2 3 // index reprezentují exponenty
    //3 0 2 5 /// hodnoty reprezentují koeficienty
    
    //data
    private static double[] coef;
    
    //constructor
/*    5 2 0 3
    [5, 2, 0, 3]
    3 0 2 5
    [3, 0, 2, 5]
    5x3 + 2x2 + 3*/
    
    private Polynom(double[] coef){ //defenzivní kopie
        double[] coefTemp = new double [coef.length];
        System.arraycopy(coef, 0, coefTemp, 0, coef.length);
        this.coef = coefTemp;
    }
    
    //tovarni factory metoda
    public static Polynom getInstanceReverted(double[] coef){ //[3, 0, 2, 5]
        return new Polynom(coef);
    }
    
    public static Polynom getInstance(double[] coef){ //[5, 2, 0, 3]
        double[] coefTemp = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            coefTemp[coef.length-1-i] = coef[i];
        }
        return new Polynom(coefTemp);
    }
    
    //metody
    public int getDegree(){
        return coef.length - 1;
    }
    
    public double getCoefAt (int exponent){
        return coef[exponent];
    }
    
    public double[] getCoef(){ 
        return Arrays.copyOf(coef, coef.length); //defenzivní kopie
    }
    
    public Polynom derivate(){
        double[] derivation = new double[coef.length-1];
        for (int i = 0; i < derivation.length; i++) {
            derivation[i] = coef[i+1]*(i+1);
        }
        return new Polynom(derivation);
    }
    
    //TODO
    public static double computeValue(double x){
        double val = 0;
        val = val + coef[0];
        val = val + x*coef[1];
        for (int i = 2; i < coef.length; i++) {
            val = val + coef[i]*makeX(x, i);
        }
        return val;
    }
    public static double makeX(double x, int k){
        double xNew = 1;
        for (int i = 0; i < k; i++) {
            xNew = xNew * x;
        }
        return x;
    }
    
    //TODO bodus
    public double integrate (double a, double b){
        return 0;
    }
    
    //TODO vypsat matematicky správně
    @Override
    public String toString(){
        String[] pol = new String [coef.length];
        //od začátku
        for (int i = coef.length-1; i > 1; i--) {
            if (i == coef.length-1 && coef[i] > 0) {
                pol[pol.length - i - 1] = coef[i] + "x^" + i;
            }
            if (i != coef.length-1 && coef[i] > 0) {
                pol[pol.length - i - 1] = " + " + coef[i] + "x^" + i;
            }
            if (coef[i] < 0) {
                pol[pol.length - i - 1] = " - " + Math.abs(coef[i]) + "x^" + i;
            }
            if (coef[i] == 0) {
                pol[pol.length - i - 1] = "";
            }
        }
        //pro x
        if (coef[1] > 0) {
            pol[pol.length - 2] = " + " + coef[1] + "x";
        }
        if (coef[1] < 0) {
            pol[pol.length - 2] = " - " + Math.abs(coef[1]) + "x";
        }
        if (coef[1] == 0) {
            pol[pol.length - 2] = "";
        }
        //pro lin. člen
        if (coef[0] > 0) {
            pol[pol.length - 1] = " + " + coef[0];
        }
        if (coef[0] < 0) {
            pol[pol.length - 1] = " - " + Math.abs(coef[0]);
        }
        if (coef[0] == 0) {
            pol[pol.length - 1] = "";
        }
        
        String polynom = "";
        for (int i = 0; i < pol.length; i++) {
            polynom = polynom + pol[i];
        }
        return polynom;
    }
    
    public static void main(String[] args){
        double[] coef = {3, 0, 2, 5};
        Polynom p = Polynom.getInstanceReverted(coef);
        System.out.println(p);
        //System.out.println(p.derivate());
        System.out.println(computeValue(1));
    }
}
