package bioinf_stronghold._14_cons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgenii_Lartcev on 8/18/2016.
 */
public class ConsensusAndProfile {
    public void resolve(List<String> list){
        //print a list
        list.stream().forEach(System.out::println);

        Map<Character, int[]> profileMap = new HashMap<>();
        final int profileRowLength = list.get(0).length();
        final int[] ints1 = new int[profileRowLength];
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

        printMapOnlyValues(profileMap);
        findConcensus(profileMap, profileRowLength);

        throw new UnsupportedOperationException("\n TODO");
    }

    private void findConcensus(Map<Character, int[]> profileMap, int profileRowLength) {
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;
        int maximum = 0;
        int[] arr_max;

        System.out.println();
        System.out.println();
        for (int i = 0; i < profileRowLength; i++) {
            arr_max = new int[4];
            int indexOfMax = 0;
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

            System.out.print(a + " " + c + " " + g + " " + t + "\t" + "maximum " + maximum + "\n");
            maximum = 0;


        }
        //System.out.println();
    }

    private void printMapOnlyValues(Map<Character, int[]> profileMap) {
        for (int i : profileMap.get('A')) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : profileMap.get('C')) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : profileMap.get('G')) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : profileMap.get('T')) {
            System.out.print(i + " ");
        }
    }
}
