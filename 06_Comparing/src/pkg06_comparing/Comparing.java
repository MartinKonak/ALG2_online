/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg06_comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Martin Koňák
 */
public class Comparing {
    public static void main(String[] args){
        Student[] students = DataSource.loadDataAsArray();
        print(students);
        System.out.println("Sort by average");
        Arrays.sort(students);
        print(students);
        System.out.println("");
        List<Student> students1 = DataSource.loadDataAsList();
        print(students1);
        System.out.println("Sort by average");
        Collections.sort(students1);
        print(students1);
    }
    
    public static void print(Student[] array){
        for (Object o : array) {
            System.out.println(o);
        }
    }
    
    public static void print(List array){
        for (Object o : array) {
            System.out.println(o);
        }
    }
}
