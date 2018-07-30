package bioinf_stronghold._11_hamm;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountingPointMutationsTest {

	@Test
	public void testResolver() {
		//fail("Not yet implemented");
		CountingPointMutations cpm = new CountingPointMutations();
		String one = "GAGCCTACTAACGGGAT";
		String two = "CATCGTAATGACGGCCT";
		cpm.resolver(one, two);
	}
	
	@Test
	public void testResolver1() {
		CountingPointMutations cpm = new CountingPointMutations();
		String one = "GCGCACGCCACGGTCGCTGCCACGATCTATATACTAGGCGTGTCCTGTAGCGTTTCGGACTAAACGATACCAATTCGAGCTCGTAGACTGGTATGACCGCAGATGGCCCGTCACCCACTGTCGTTTTGAACGCGAATAGATCACGGTTCTGAGACTTTGCAACTTCGGTGACAACCCTCAGAATTCTCTATACGAGTTGTGATCACAAGATGGGCCGATAAGCAATACACGGGCACCAAAGGTTTTGCGGGAGCGTGGACCGCGAAACTACGCTCCCTCGTGCTGCTTCAGTTTCCCGGCCCTTGATCGATTACATAGCTGGTACTTATACATCGTCGGGATTTTTAGCGTCCCCCGCTGCTACAATTGACCGACGATGGTCACACCCTGGCCTGCACATCTACTCTAGTACCTGTATTCTGCACTCCAGTAAGGGACGTCCCTTTTTTTTTGGACGGGAAATTTGGTCCCACGTCGAACGGACGGGACCTGGAACGGCCTCCGTGGGGTCTGACGTCCACGGGTCACTACCTGCGTACGAGGGCGGTCTTATTTACGGACCAGTTTTCGGGGGACTTCACCGTAGGAATTCCTTTGATACTTGGGATACCACGTCAACTAATTATCTAGGCTCAAGTTCATTACTTTATGCATAAGCTTCATTTTGATGTGTGCGTAACTCGATGGTCCACCGGCTAGACAATTTCGTCCCCTGGGAGTACTCTTGTGAATATCGCGGTCTTGATGGTGTCTAACTGATCAACGGCAACCCTGTACACGCCTGGTATTAGGTAGCATCCACAGCGTAGCCGTCTGTTCTCGACGACTTTCCATGTTTGTCTGCTTGTCAGCTAGCTCTCGGTAGGGTGAACATGCCTGACGAAAAGCGCCTCAAAGGTACACACAAGGTCCTCGATTCCCTGGCGACGATGAGAGCAACCAGTAATTACAGGCAACAAATGG";
		String two = "GGGCAACGCACGTTGGCAACCAATATCAGCAGGCAGTCCGTCTTCGGTCGTGTTTAAAACTAGACCCAGACATCTACCGCTACCACATGAGTCTAACATCAACTTCTCCGTCCAGCCCTGCCCTACTGATGGCGCAACGAACAAACTGGTCTTCTAGATCCAATTCGGGGCATGCCCCGGGACTCTGTTAATGCAAAGTTAGCCCTAATAATAGCCTCTACTGATTCCACGACCAATCACGGCCCTGTCTAACGATAGATAGGGGCCCTATGGTTGTTCTTTTGACTGAGGCTTCCCCCCCACCGATCGACAAGATAGCGGCAAGCTGCTCATCTCGGGCAACTTTGCTTTCCTCCAGTCATCCAATTATTCGGCGAGACGCACGTACGGGACGGCCCATCCACGGCGGTGCCCTTAACCACCGAGCCGATATCGCTCGTCACGTTTCTTATGGCGGTTAACTTTATACCCGGGGTAATCATCACGTATCCCAAACGGCCGCCTAGCATGCCGACCCCCACGGCTAAACACCCGCGCACATTACAGCTATTAATAATGAATCCATGTTTGGGGCACATGAGCGTAAGGGGTGTATTGCGTGAGGGTTGACCGGATCATTTCATCCTCGAGGTTACAATAGATTACTGAATGCACAGGCCTTGTCTCGCCGTGTTCGATGCTGGACGTTTCACGTGCGTGAAGATTACCTTTCCTGACCGTAGTCCTCCGCATTTCTGCGAATGCGAGGCATTTTCAGAATGTTTCATATACCACTTGACGCTCAGCAGAGGCTCGGGTGGTCCTCATACCCCAAAACGCAATACCCCAATTTAACTATGAGCGCTTCCCAGCTTGCTAGGCTCGGAGCGATCATCGTGGACACTAATAACAGTAAGGATACACACATTAGCCCATTCACTAGTGGGAAGATAACAGTAATCCGGAAGGCCTCTGCATGACTAT";
		cpm.resolver(one, two);
	}

}