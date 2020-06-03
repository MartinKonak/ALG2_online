/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition.filehandling;

import competition.app.Runner;
import static competition.filehandling.Writer.dataDirectory;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Martin Koňák
 */
public class BinaryWriter extends Writer {

    @Override
    public void saveResults(String resultFilepath, List<Runner> runners) throws IOException {
        File resultFile = new File(dataDirectory, resultFilepath);
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFile))){
            dos.writeUTF("Nove vysledky");
            int n = 1;
            for (Runner runner : runners) {
                dos.writeInt(n);
                //dos.writeChar('.'); //zapisuju jenom data bez mezer, nových řádků a znaků důležitých pro výpis
                //dos.writeUTF(resultFilepath); //binarni soubory jsou primárne určené k uložení a ne prohlížení
                dos.writeUTF(runner.getFirstname());
                int nChars = runner.getLastname().length(); //simulace writeUTF, uložím počet znaků Stringu až pak String 
                dos.writeInt(nChars);
                for (int i = 0; i < nChars; i++) {
                    dos.writeChar(runner.getLastname().charAt(i));
                }
                dos.writeLong(runner.runningTime().toNanoOfDay()); //čas vhodné uložit jako nanosekundy, ne String
                n++;
            }
        }
    }
    
}
