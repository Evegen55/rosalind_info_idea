/*
 * Copyright (C) 2016 Lartsev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
        HashMap<String, String> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        File f = new File(filename);
        String label = "";
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
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
