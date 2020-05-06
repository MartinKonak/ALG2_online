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
public class CmdEditor implements CmdInterface {
    private static boolean isRunning;
    private static File actualDir;
    private Command command;
    
    public CmdEditor(){
        isRunning = true;
        actualDir = new File(System.getProperty("user.dir"));
    }
    
    @Override
    public boolean isRunning() {
        return isRunning;
    }
    
    public static void changeRunning() {
        isRunning = !(isRunning);
    }
    
    public static void changeActualDir(File path){
        actualDir = path;
    }
    
    @Override
    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    @Override
    public String parseAndExecute(String line) {
        //parse
        command = Parser.parse(line);
        //execute
        return command.execute(actualDir);
    }
}
