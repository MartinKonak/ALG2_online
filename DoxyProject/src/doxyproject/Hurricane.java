/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konak_hurricane;

/**
 *
 * @author Martin Koňák
 */
public class Hurricane {
    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;

    public Hurricane(int year, String month, int pressure, int speed, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
    }
    
    public double getSpeedInKmH(){
        return (speed*(1.852));
    }
    
    public int getHurricaneCathegory(){
        double speed = getSpeedInKmH();
        if (speed > 118 && speed < 154) {
            return 1;
        }else if(speed > 153 && speed < 178){
            return 2;
        }else if(speed > 177 && speed < 209){
            return 3;
        }else if(speed > 208 && speed < 252){
            return 4;
        }else if(speed > 251){
            return 5;
        }else{
            return 0;
        }
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }    

    @Override
    public String toString() {
        return String.format("%-6d%-10s%-5d%-4d%-10s", year, month, pressure, speed, name);
    }
    
    
}
