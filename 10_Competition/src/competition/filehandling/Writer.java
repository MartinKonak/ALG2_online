/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition.filehandling;

import competition.app.Runner;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Martin Koňák
 */
public abstract class Writer {
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
    
    public abstract void saveResults(String resultFilepath, List<Runner> runners) throws IOException;
}