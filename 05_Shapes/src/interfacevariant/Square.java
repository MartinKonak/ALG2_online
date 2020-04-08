/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p05_shapes;

/**
 *
 * @author Martin Koňák
 */
public class Square extends Rectangle{
    //bere ho jako čtverec se stejnyma stranama -- dědičnonst; platí vztah IS A
    //vždy se dá dědit jen z jednoho předka
    private double a;
    
    public Square (double a){
        super(a, a); // volam konstuktor rectangle namisto a b mu davam 2x a
    }
    
    
/*    public static void main(String[] args){
        Square s = new Square(4);
        System.out.println(s.area());
        System.out.println(s);
    }*/

    @Override
    public String toString() {
        return "Square{" + "a=" + a + '}';
    }
    
}
