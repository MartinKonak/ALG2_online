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
public class Cd extends Command {

    @Override
    public String execute(File actualDir) {

        File directory = new File(actualDir.getAbsolutePath(), params[1]);

        if (params.length == 2) {
            if (!"..".equals(params[1]) && directory.exists()) {
                CmdEditor.changeActualDir(directory);
                return "Directory changed";
            } else if (params[1].equals("..")) {
                CmdEditor.changeActualDir(actualDir.getParentFile());
                return "Directory changed";
            } else {
                return "Selected folder does not exist";
            }
        }else{
            return "Selected folder does not exist";
        }
    }
}
