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
public class Cd extends Command{

    @Override
    public String execute(File actualDir) {
                
        File directory = new File(params[1]).getAbsoluteFile();
        if(!"..".equals(params[1]) && directory.exists()){
            CmdEditor.changeActualDir(directory);
            return "Directory changed";
        }else if(params[1].equals("..")){
            File nDir = actualDir.getParentFile();
            CmdEditor.changeActualDir(nDir);
            return "Directory changed";
        }else{
            return "Selected folder does not exist\n";
            //return directory.getAbsolutePath();
        }
    }
    
}
