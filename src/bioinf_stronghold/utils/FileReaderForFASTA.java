package bioinf_stronghold.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Evgenii_Lartcev
 */
public class FileReaderForFASTA {

    /**
     * @param filename the name of file in a FASTA format
     * @return map that contains key as ">Rosalind_9648" and value as "ACTGCGTGCTGCTGA"
     * @see <a href="https://ru.wikipedia.org/wiki/FASTA">WIKIPEDIA</a>
     */
    public static HashMap<String, String> getMapFromFile(String filename) {
        HashMap<String, String> map = new HashMap<String, String>();
        StringBuffer sb = new StringBuffer();
        File f = new File(filename);
        String label = "";
        try (BufferedReader br = new BufferedReader(new FileReader(f));) {
            while (br.ready()) {
                String line = br.readLine();
                if (line.startsWith(">")) {
                    //delete symbol ">"
                    label = line.substring(1);
                    map.put(label, "");
                    sb = new StringBuffer();
                } else {
                    sb.append(line);
                    String dnaPart = sb.toString();
                    map.put(label, dnaPart);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
