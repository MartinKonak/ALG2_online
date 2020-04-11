/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg06_comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Martin Koňák
 */
public class DataSource {   
    static double [] m1 = {1, 3, 5, 5}; //přidaná pole známek
    static double [] m2 = {1, 2, 5, 4};
    static double [] m3 = {3, 2, 3, 1};
    
    private static Student[] data = {
        new Student("Jan", "Malý", 1234, 20, m1),
        new Student("Alice", "Velká", 1136, 19, m2),
        new Student("Bob", "Pech", 1954, 18, m3)
    };
    
    public static Student[] loadDataAsArray(){
        return Arrays.copyOf(data, data.length);
    }
    
    public static List<Student> loadDataAsList(){
        return Arrays.asList(data);
    }
}
