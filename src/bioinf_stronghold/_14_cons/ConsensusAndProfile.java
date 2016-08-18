package bioinf_stronghold._14_cons;

import java.util.ArrayList;
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

        throw new UnsupportedOperationException("\n TODO");
    }
}
