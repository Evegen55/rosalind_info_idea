package bioinf_stronghold._12_lcsm;

import bioinf_stronghold.utils.FileReaderMy;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class FindingSharedMotifTest {

	FindingSharedMotif fm;
	String filename;
	List<String> list;

	//@Ignore
	@Test
	public void testfindFirst(){
		String word = "AC";
		String dna = "GATTACA";
		fm = new FindingSharedMotif();
		int i = fm.findFirst(word, dna);
		assertTrue(i == 1);
	}
	//@Ignore
	@Test
	public void testFindFirstThrueListOfStrings() {
		fm = new FindingSharedMotif();
		filename = "src/bioinf_stronghold/_12_lcsm/lcsm.txt";
		//create a list with only DNA - strings
		list = FileReaderMy.getMapFromFile(filename)
				.entrySet()
				.stream()
				.map(e -> e.getValue())
				.collect(Collectors.toList());
		String word = "AC";
		boolean bool = fm.findFirstThrueListOfStrings(word, list);
		assertTrue(bool);
	}
	//@Ignore
	@Test
	public void testFindFirstThrueListOfStrings1() {
		fm = new FindingSharedMotif();
		filename = "src/bioinf_stronghold/_12_lcsm/lcsm.txt";
		//create a list with only DNA - strings
		list = FileReaderMy.getMapFromFile(filename)
				.entrySet()
				.stream()
				.map(e -> e.getValue())
				.collect(Collectors.toList());
		String word = "ATT";
		boolean bool = fm.findFirstThrueListOfStrings(word, list);
		assertTrue(!bool);
	}
	//@Ignore
	@Test
	public void testFindFirstThrueListOfStringsBigList() {
		fm = new FindingSharedMotif();
		filename = "src/bioinf_stronghold/_12_lcsm/rosalind_lcsm.txt";
		//create a list with only DNA - strings
		list = FileReaderMy.getMapFromFile(filename)
				.entrySet()
				.stream()
				.map(e -> e.getValue())
				.collect(Collectors.toList());
		String word = "AC";
		boolean bool = fm.findFirstThrueListOfStrings(word, list);
		assertTrue(bool);
	}
	//@Ignore
	@Test
	public void testFindFirstThrueListOfStringsBigListBigWord() {
		fm = new FindingSharedMotif();
		filename = "src/bioinf_stronghold/_12_lcsm/rosalind_lcsm.txt";
		//create a list with only DNA - strings
		list = FileReaderMy.getMapFromFile(filename)
				.entrySet()
				.stream()
				.map(e -> e.getValue())
				.collect(Collectors.toList());
		String word = "CTATAG";
		boolean bool = fm.findFirstThrueListOfStrings(word, list);
		assertTrue(!bool);
	}
	
	//@Ignore
	@Test
	public void testFindAllPossibleSmallList(){
		fm = new FindingSharedMotif();
		filename = "src/bioinf_stronghold/_12_lcsm/lcsm.txt";
		//create a list with only DNA - strings
		list = FileReaderMy.getMapFromFile(filename)
				.entrySet()
				.stream()
				.map(e -> e.getValue())
				.collect(Collectors.toList());
		fm.findAllPossibleWithFirstWord(list);
	}
	
	//@Ignore
	@Test
	public void testFindAllPossibleBiglList(){
		fm = new FindingSharedMotif();
		filename = "src/bioinf_stronghold/_12_lcsm/rosalind_lcsm.txt";
		//create a list with only DNA - strings
		list = FileReaderMy.getMapFromFile(filename)
				.entrySet()
				.stream()
				.map(e -> e.getValue())
				.collect(Collectors.toList());
		fm.findAllPossibleWithFirstWord(list);
	}

    @Ignore
    @Test
    public void testFindAllPossible(){
        fm = new FindingSharedMotif();
        filename = "src/bioinf_stronghold/_12_lcsm/rosalind_lcsm.txt";
        //create a list with only DNA - strings
        list = FileReaderMy.getMapFromFile(filename)
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList());
        fm.findAllPossible(list);
    }

    @Ignore
    @Test
    public void testFindAllPossibleWithMeasurement(){
        fm = new FindingSharedMotif();
        String filename = "src/bioinf_stronghold/_12_lcsm/rosalind_lcsm.txt";
        //create a list with only DNA - strings
        list = FileReaderMy.getMapFromFile(filename)
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList());
		//measure time
        long start = System.nanoTime();
        fm.findAllPossible(list);
        long end = System.nanoTime();
        double estTime = ((end-start)/(Math.pow(10, 9)));
        double finalValue = Math.round( estTime * 1000.0 ) / 1000.0;
        System.out.print(finalValue + "\t");
    }


}
