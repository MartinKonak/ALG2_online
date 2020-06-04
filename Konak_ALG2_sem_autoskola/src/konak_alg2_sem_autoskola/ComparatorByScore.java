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
public class ComparatorByScore implements Comparator<Result>{
    
    @Override
    public int compare(Result o1, Result o2) {
        if (o1.getScore() < o2.getScore()) {
            return 1;
        }else{
            return -1;
        }
    }
}
