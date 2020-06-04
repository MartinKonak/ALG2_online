/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konak_alg2_sem_autoskola;

import java.util.Comparator;

/**
 *
 * @author Martin Koňák
 */
public class ComparatorByName implements Comparator<Result>{
    
    @Override
    public int compare(Result o1, Result o2){
        if (o1.getName().charAt(0) > o2.getName().charAt(0)) {
            return 1;
        }else{
            return -1;
        }
    }
    
}
