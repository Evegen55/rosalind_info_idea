package bioinf_stronghold.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileReaderForFASTA {

	/**
	 * 
	 * @param filename
	 * @return map that contains Key as ">Rosalind_9648" and value as "ACTGCGTGCTGCTGA"
	 */
	public static HashMap<String, String> getMapFromFile(String filename) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		StringBuffer sb = new StringBuffer();
		
		File f = new File(filename);
		String label = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader(f));){
			
			while(br.ready()) {
				String line = br.readLine();
				
				if (line.startsWith(">")) {
					//delete symbol ">"
					label = line.substring(1);
					map.put(label, "");
					//System.out.println(line);
					sb = new StringBuffer();
					
				} else {
					sb.append(line);
					String dnaPart = sb.toString();
					map.put(label, dnaPart);
					//System.out.println(label + " =========== " + actg);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return map;
	}

}
