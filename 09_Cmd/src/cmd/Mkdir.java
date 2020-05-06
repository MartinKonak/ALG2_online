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
public class Mkdir extends Command{
    
    @Override
    public String execute(File actualDir) {
        File dir = new File(params[1]);
        if (dir.mkdir()) {
            return "Folder created: " + params[1];
        }else{
            return "This folder already exists";
        }
    }
}
