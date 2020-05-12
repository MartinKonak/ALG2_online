package konak_hurricane;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Martin Koňák
 */
public class HurricaneUI {
    static Scanner sc = new Scanner (System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){        
        DataEditor e = new DataEditor();
        int ch = 0;
        try{
            e.load();
        }catch(IOException f){
            System.out.println("File does not found");
            ch = -1;
        }
        String menu = "Menu:\n1 - Hurricanes between years\n2 - About Hurricane\n3 - not now\n-1 - end program";        
        
        System.out.println(menu);
        
        while(ch > -1){            
            switch(ch){
                case 1:
                    System.out.println("Enter years:");
                    int y1 = sc.nextInt();
                    int y2 = sc.nextInt();
                    System.out.println(e.hurricanesInYears(y1, y2));
                    System.out.println(menu);
                    break;
                case 2:
                    System.out.println("Enter Hurricane name:");
                    String name = sc.next();
                    System.out.println(e.hurricaneByName(name));
                    System.out.println(menu);
                    break;
                case 3:
                    System.out.println("Unsupported function now.");
                    System.out.println(menu);
                    break;
            }
            ch = scanInt();
        }
    }
    
    public static int scanInt(){
        int n = 0;
        boolean error = true;
        
        do {
            try{
                n = sc.nextInt();
                error = false;
            }
            catch(Exception e){
                System.out.println("Invalid input!");
                sc.next();
            }
        } while (error);        
        
        return n;
    }
    
}
