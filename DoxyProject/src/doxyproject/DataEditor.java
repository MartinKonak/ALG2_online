/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konak_hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Martin Koňák
 */
public class DataEditor implements HurricaneInterface{
    
    ArrayList<Hurricane> hurricanes = new ArrayList<Hurricane>();
    
    @Override
    public void load() throws FileNotFoundException, IOException{
        File hurData = new File("hurricanedata.txt");
        Scanner load = new Scanner(hurData);
        while(load.hasNext()){
            int year = load.nextInt();
            String month = load.next();
            int pressure = load.nextInt();
            int speed = load.nextInt();
            String name = load.next();
            Hurricane h = new Hurricane(year, month, pressure, speed, name);
            hurricanes.add(h);
        }          
    }
    
    @Override
    public String hurricanesInYears(int y1, int y2){
        StringBuilder sb = new StringBuilder("");
        
        for (Hurricane h : hurricanes) {
            if (h.getYear() >= y1 && h.getYear() <= y2) {
                sb.append(h + "\n");
            }
        }
        return sb.toString();
    }
    
    @Override
    public String hurricaneByName(String name){
        for (Hurricane h : hurricanes) {
            if (h.getName().equals(name)) {
                return "Cathegory: " + h.getHurricaneCathegory() + ", Speed: " + h.getSpeedInKmH();
            }
        }
        return "Hurricane does not found";
    }
    
    
}
