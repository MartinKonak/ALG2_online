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
        return o1.getScoreString().compareTo(o2.getScoreString());
    }
}
