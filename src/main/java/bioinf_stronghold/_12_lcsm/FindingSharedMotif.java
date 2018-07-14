
package bioinf_stronghold._12_lcsm;

import java.util.List;

public class FindingSharedMotif {
	/**
	 *
	 * @param word
	 * @param dna
     * @return 1 if find FIRST equals part in a DNA
     */
	public int findFirst(String word, String dna){
		int wordLength = word.length();
		int dnaLength = dna.length();
		for (int k = 0; k<dnaLength; k++) {
			if(wordLength+k <= dnaLength) {
				String s = dna.substring(k, wordLength+k);
				if(word.equals(s)) {
					//System.out.println(s);
					return 1;
				}
			}
		}
		return 0;
	}

	/**
	 *
	 * @param word small part of dna
	 * @param list  of DNA strings
     * @return
     */
	public boolean findFirstThrueListOfStrings(String word, List<String> list) {
		for(String dna: list) {
			if(findFirst(word, dna) == 0) return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param list of DNA strings
	 */
	public void findAllPossibleWithFirstWord(List<String> list){
		
		int count = 2;
		String wordFromList = list.get(0);
		int lengts = wordFromList.length();
		for (int i = lengts; i>=0; i--) {
			count = getCountByInnerCycle(list, count, wordFromList, i);
		}
	}

	/**
	 *
	 * @param list of DNA strings
	 */
	public void findAllPossible(List<String> list){

		int count = 2;
		int BigCounter = 0;
		for(String word : list) {
			int lengts = word.length();
			for (int i = lengts; i>=0; i--) {
				count = getCountByInnerCycle(list, count, word, i);
				BigCounter = count;
			}
			count = BigCounter;
		}

	}

	private int getCountByInnerCycle(List<String> list, int count, String word, int i) {
		for (int k = 0; k<i-count; k++) {
            boolean bool = findFirstThrueListOfStrings(word.substring(k, i), list);
            int newCount = i-k;
            if(bool && newCount>count) {
                count = newCount;
                System.out.println(word.substring(k, i) + "\t" + count);
            }
        }
		return count;
	}
}

