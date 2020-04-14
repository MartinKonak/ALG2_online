/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalendar;

import java.util.Scanner;

/**
 *
 * @author Martin Koňák
 */
public class Kalendar {
    //static data
    private static final String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    
    final static String line = "+--+--+--+--+--+--+--+\n";
    
    //calendar method
    public static String makeCal(int d, int m, int y){
        String cal = "";
        
        if (isP(y)) {
            days[1] = 29;
        }else{
            days[1] = 28;
        }
        
        int k;
        if (days[m - 1] == 28 && zeller(1, m, y) == 1) {
            k = 4;
        }else if(days[m - 1] == 30 && zeller(1, m, y) >= 7 || days[m - 1] == 31 && zeller(1, m, y) >= 6){
            k = 6;
        }else{
            k = 5;
        }
        
        int counter = 0;
        int[][] month = new int[k][7];
        //načte datumy do pole
        read:
        for (int i = 0; i < month.length; i++) {
            for (int j = 0; j < month[0].length; j++) {
                if (j+1 < zeller(1, m, y) && i == 0) {
                    month[i][j] = 0;
                }else{                    
                    counter++;
                    if (counter > days[m-1]) {
                        break read;
                    }
                    month[i][j] = counter;
                }
            }
        }
        //připíše jednotlivě do stringu
        cal +=  monthName[m-1] + " " + y + ":\n" + " M  T  W  T  F  ST SN \n" + line;
        for (int i = 0; i < month.length; i++) {
            for (int j = 0; j < month[0].length; j++) {
                cal += ANSI_RESET + "|";
                if (month[i][j] == 0) {
                    cal += "  ";
                }else{
                    if (month[i][j] == d) {
                        if (j == month[0].length - 1) {
                            if (month[i][j] < 10) {
                                cal += (ANSI_YELLOW_BACKGROUND + ANSI_RED + " " + month[i][j]);
                            }else{
                                cal += (ANSI_YELLOW_BACKGROUND + ANSI_RED + month[i][j]);
                            }
                        }else{
                            if (month[i][j] < 10) {
                                cal += (ANSI_RESET + ANSI_YELLOW_BACKGROUND + " " + month[i][j]);
                            }else{
                                cal += (ANSI_RESET + ANSI_YELLOW_BACKGROUND + month[i][j]);
                            }
                            
                        }
                    }else{
                        if (j == month[0].length - 1) {
                            if (month[i][j] < 10) {
                               cal += (ANSI_WHITE_BACKGROUND + ANSI_RED + " " + month[i][j]);
                            }else{
                                cal += (ANSI_WHITE_BACKGROUND + ANSI_RED + month[i][j]);
                            }
                        }else{
                            if (month[i][j] < 10) {
                                cal += (ANSI_BLACK_BACKGROUND + ANSI_RESET + " " + month[i][j]);
                            }else{
                                cal += (ANSI_BLACK_BACKGROUND + ANSI_RESET + month[i][j]);
                            }
                        }
                    }
                }
            }
            cal += ANSI_RESET + "|\n" + line;
        }
        
        return cal;
    }
    
    
    //přestupný rok
    public static boolean isP(int year){
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    //počet dnů v roce
    public static int daysInYear(int year){
        if (isP(year)) {
             return 366;
        }else{
            return 365;
        }
    }
    //zellerův algoritmus na den týdnu
    public static int zeller(int d, int m, int y){
        if (m == 1) {
            m = 13;
            y = y - 1;
        }
        if (m == 2) {
            m = 14;
            y = y - 1;
        }
        int dayNum;
        dayNum = (d + ((13*(m+1))/5) + (y%100) + ((y%100)/4) + ((y/100)/4) - (2*(y/100))) % 7;
        dayNum = ((dayNum + 5)%7)+1;
        return dayNum;
    }    
    
    public static void main(String[] args) {
        String menu = "Menu:\n 1 = next day\n 2 = prev day\n 3 = next month\n 4 = prev month\n 5 = next year\n 6 = prev year\n 7 = go to date\n 0 = end program";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Calendar - enter date in format dd mm yyyy:");
        int d = sc.nextInt();
        int m = sc.nextInt();
        int y = sc.nextInt();
        
        System.out.println(makeCal(d, m, y));
        System.out.println(menu);
        
        int choice = sc.nextInt();
        
        while(choice >= 0){
            switch(choice){
                case 1:
                    d += 1;
                    if (d > days[m-1]) {
                        m +=1;
                    }
                    if (m > 12) {
                        m = 1;
                        y = y + 1;
                    }
                    System.out.println(makeCal(d, m, y));
                    System.out.println(menu);
                    break;
                case 2: 
                    d -= 1;
                    if (d < 1) {
                        m -=1;
                    }
                    if (m < 1) {
                        m = 12;
                        y = y - 1;
                    }
                    System.out.println(makeCal(d, m, y));
                    System.out.println(menu);
                    break;
                case 3:
                    m += 1;
                    if (m > 12) {
                        m = 1;
                        y = y + 1;
                    }
                    System.out.println(makeCal(d, m, y));
                    System.out.println(menu);
                    break;
                case 4:
                    m -= 1;
                    if (m < 1) {
                        m = 12;
                        y = y - 1;
                    }
                    System.out.println(makeCal(d, m, y));
                    System.out.println(menu);
                    break;
                case 5:
                    y += 1;
                    System.out.println(makeCal(d, m, y));
                    System.out.println(menu);
                    break;
                case 6:
                    y -= 1;
                    System.out.println(makeCal(d, m, y));
                    System.out.println(menu);
                    break;
                case 7:
                    System.out.println("Enter date:");
                    d = sc.nextInt();
                    m = sc.nextInt();
                    y = sc.nextInt();
                    System.out.println(makeCal(d, m, y));
                    System.out.println(menu);
                    break;
                default:
                    System.out.println("Try again");
            }
            choice = sc.nextInt();
        }
        
    }
    
}
