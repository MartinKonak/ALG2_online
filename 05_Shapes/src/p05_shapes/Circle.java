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
public class Circle extends Shape {
    //data
    private double r;

    public Circle(double r) {
        this.r = r;
    }
    
    public static Circle getInstanceD(double d){
        return new Circle (d/2);
    }
    public static Circle getInstanceR(double r){
        return new Circle (r);
    }
    
    //TODO udělat pomocí tovární metody
/*    public Circle(double d) {
        this.r = d/2;
    }*/

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle{" + "r=" + r + '}';
    }
    
    @Override
    public double area(){
        return Math.PI*r*r;
    }
    
/*    public static void main(String[] args){
        Circle c = new Circle(2);
        System.out.println(c.area());
    }*/
    
}
