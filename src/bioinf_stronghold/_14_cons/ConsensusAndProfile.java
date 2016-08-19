package bioinf_stronghold._14_cons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgenii_Lartcev on 8/18/2016.
 */
public class ConsensusAndProfile {
    public void resolve(List<String> list){
        //print a list
        //list.stream().forEach(System.out::println);

        Map<Character, int[]> profileMap = new HashMap<>();
        final int profileRowLength = list.get(0).length();
        profileMap.put('A', new int[profileRowLength]);
        profileMap.put('C', new int[profileRowLength]);
        profileMap.put('T', new int[profileRowLength]);
        profileMap.put('G', new int[profileRowLength]);

        for (String dna : list) {
            for (int i=0; i<dna.length(); i++) {
                final char nucleotide = dna.charAt(i);
                final int[] ints = profileMap.get(nucleotide);
                ints[i] += 1;
            }
        }
        String cons = findConcensus(profileMap, profileRowLength);
        System.out.println(cons);
        printMapOnlyValues(profileMap);

        printToFile(profileMap, cons);
    }

    private String findConcensus(Map<Character, int[]> profileMap, int profileRowLength) {
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;
        int maximum = 0;
        int[] arr_max;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < profileRowLength; i++) {
            arr_max = new int[4];
            a = profileMap.get('A')[i];
            c = profileMap.get('C')[i];
            g = profileMap.get('G')[i];
            t = profileMap.get('T')[i];
            arr_max[0] = a;
            arr_max[1] = c;
            arr_max[2] = g;
            arr_max[3] = t;

            //find max value
            for (int q = 0; q < 4; q++) {
                if (arr_max[q] > maximum) {
                    maximum = arr_max[q];
                }
            }
            //build concensus string
            for (int q = 0; q < 4; q++) {
                if (arr_max[q] == maximum) {
                    if (q == 0) sb.append("A");   //System.out.print("A");
                    if (q == 1) sb.append("C");   //System.out.print("C");
                    if (q == 2) sb.append("G");   //System.out.print("G");
                    if (q == 3) sb.append("T");   //System.out.print("T");
                }
                //System.out.print(arr_max[q] + " ");
            }
            //System.out.print("\t" + "maximum " + maximum + "\n");
            maximum = 0;
        }
        //System.out.println();
        return sb.toString();
    }

    private void printMapOnlyValues(Map<Character, int[]> profileMap) {
        System.out.print("A: ");
        for (int i : profileMap.get('A')) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("C: ");
        for (int i : profileMap.get('C')) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("G: ");
        for (int i : profileMap.get('G')) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("T: ");
        for (int i : profileMap.get('T')) {
            System.out.print(i + " ");
        }
    }

    private void printToFile(Map<Character, int[]> profileMap, String cons) {
        String filename = "src/bioinf_stronghold/_14_cons/cons_out.txt";
        File f = new File(filename);
        try(BufferedWriter br = new BufferedWriter(new FileWriter(f));){

            br.write(cons);
            br.write("\n");

            br.write("A: ");
            for (int i : profileMap.get('A')) {
                br.write(i + " ");
            }
            br.newLine();

            br.write("C: ");
            for (int i : profileMap.get('C')) {
                br.write(i + " ");
            }
            br.newLine();

            br.write("G: ");
            for (int i : profileMap.get('G')) {
                br.write(i + " ");
            }
            br.newLine();

            br.write("T: ");
            for (int i : profileMap.get('T')) {
                br.write(i + " ");
            }
            br.newLine();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
