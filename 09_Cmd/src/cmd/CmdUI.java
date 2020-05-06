/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.util.Scanner;

/**
 *
 * @author Martin Koňák
 */
public class CmdUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        //new CmdEditor
        CmdInterface cmd = new CmdEditor();
        
        String line;
        while(cmd.isRunning()){
            System.out.print(cmd.getActualDir() + " $ ");
            line = sc.nextLine();
            try{
                System.out.println(cmd.parseAndExecute(line));
            } catch(RuntimeException e){
                System.out.print(e.getMessage());
            }
        }
    }
    
}
