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
public interface CmdInterface {

    boolean isRunning();
    
    String getActualDir();

    String parseAndExecute(String line);
    
}
