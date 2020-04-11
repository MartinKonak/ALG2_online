/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg06_comparing;

import java.util.ArrayList;

/**
 *
 * @author Martin Koňák
 */
public class Student implements CompareInterface, Comparable<Student>{
    private String firstName;
    private String lastName;
    private int age;
    private int number;
    private double[] marks;//pole známek

    public Student(String firstName, String lastName, int number, int age, double[] marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.number = number;
        this.marks = new double[marks.length];
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", number=" + number + "average" + this.average() + '}';
    }
    public String getMarks(){//vypíše známky
        String line = "[";
        for (int i = 0; i < marks.length; i++) {
            if (i < marks.length - 1) {
                line += marks[i] + ", ";
            }else{
                line += marks[i];
            }
        }
        line += "]";
        return line;
    }

    boolean startLater(Student student) {
        return this.number > student.number;
    }

    boolean isOlder(Student student) {
        return this.age > student.age;
    }
    
    public double[] addMark(double m){//přidání nzámky
        double[] mtmp = this.marks;
        this.marks = new double[mtmp.length + 1];
        for (int i = 0; i < mtmp.length; i++) {
            this.marks[i] = mtmp[i];
        }
        this.marks[this.marks.length - 1] = m;
        return marks;
    }
    
    public double average(){//průměr ze známek
        double average = 0;
        double sum = 0;
        for (double i : marks) {
            sum += i;
        }
        average = sum/marks.length;
        return average;
    }

    @Override
    public boolean isSmaller(CompareInterface o) {
        return this.number > ((Student)o).number;
    }

    @Override                         //upravené compareTo
    public int compareTo(Student o) { //-1, 0, 1
        double a = this.average() - o.average();
        
        if (a > 0) {
            return 1;
        }else if(a < 0){
            return -1;
        }else{
            return 0;
        }
    }
    
/*    public static void main(String[] args){
        double[] m = {1, 2, 3};
        Student s = new Student("Jan", "Malý", 1234, 20, m);
        System.out.println(s.getMarks());
        s.addMark(4);
        s.addMark(3);
        System.out.println(s.getMarks());
        System.out.println("average: " + s.average());
    }*/
}
