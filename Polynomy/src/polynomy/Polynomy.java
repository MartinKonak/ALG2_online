/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomy;

/**
 * Library knihovní třída
 * @author Martin Koňák
 */
public class Polynomy {

    private Polynomy(){
        //prázdný konstruktor, nelze vytvořit objekt z této třídy
    }
    
    public static Polynom sum(Polynom a, Polynom b){
        //5x3 + 2x2 + 0 + 3
        // 0  + 4x2 + x + 2
        //-----------------
        //5x3 + 6x2 + x + 5
        Polynom max = a.getDegree() > b.getDegree()? a : b;
        Polynom min = a.getDegree() < b.getDegree()? a : b;
        double[] sum = new double[max.getDegree() + 1];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = max.getCoefAt(i);
        }
        for (int i = 0; i < min.getDegree() + 1; i++) {
            sum[i] = sum[i] + min.getCoefAt(i);
        }
        return Polynom.getInstanceReverted(sum);
    }
    
/*    public static Polynom multiply(){
       
    }*/
    
    public static void main(String[] args){
        double[] a = {3, 0, 2, 5};
        double[] b = {2, 1, 4};
        Polynom p1 = Polynom.getInstanceReverted(a);
        Polynom p2 = Polynom.getInstanceReverted(b);
        System.out.println(sum(p1, p2));
    }
            
}
