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
            String oldDir = actualDir.getAbsolutePath();
            System.out.println("1");
            System.out.println(oldDir);
            String[] p = oldDir.split("\\");
            System.out.println("2");
            String finalDir = p[p.length-2];
            System.out.println("3");
            File fDir = new File(finalDir).getAbsoluteFile();
            System.out.println("4");
            CmdEditor.changeActualDir(fDir);
            System.out.println("5");
            return "Directory changed2";
        }else{
            return "Selected folder does not exist\n";
            //return directory.getAbsolutePath();
        }
    }
    
}
