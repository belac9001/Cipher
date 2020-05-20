package org.cipher.cipher.utility;

import java.io.*;

public class CipherLogger
{
    private File file;
    
    public void log(String input)
    {
        file = new File("src/main/resources/log.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        String inputNewLine = input + System.getProperty("line.separator");

        try
        {
            fr = new FileWriter(file, true);
            br = new BufferedWriter(fr);
            br.write(inputNewLine);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
                fr.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
