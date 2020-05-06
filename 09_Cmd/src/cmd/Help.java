/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;

/**
 *
 * @author Martin Koňák
 */
public class Help extends Command{

    @Override
    public String execute(File actualDir) {
        String help = "HELP\n" + String.format("%-7s %s\n", "help", "Displays help")
                               + String.format("%-7s %s\n", "dir", "Displays list of files and folders")
                               + String.format("%-7s %s\n", "exit", "Exits cmd");
        return help;
    }
    
}
