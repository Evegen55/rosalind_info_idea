package bioinf_stronghold._14_cons;

import bioinf_stronghold._6_gc.FileReaderMy;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Evgenii_Lartcev on 8/18/2016.
 */
public class ConsensusAndProfileTest {
    ConsensusAndProfile cap;
    String filename;
    List<String> list;

    private final String example = "ATGCAACT";
    private final String exampleA = "A: 5 1 0 0 5 5 0 0";
    private final String exampleC = "C: 0 0 1 4 2 0 6 1";
    private final String exampleG = "G: 1 1 6 3 0 1 0 0";
    private final String exampleT = "T: 1 5 0 0 0 1 1 6";

    @Test
    public void resolve() throws Exception {
        filename = "src/bioinf_stronghold/_14_cons/cons.txt";
        list = FileReaderMy.getMapFromFile(filename)
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        cap = new ConsensusAndProfile();
        cap.resolve(list);

        assertThat(cap.getConcensus(), is(example));
        assertThat(cap.getA_string(), is(exampleA));
        assertThat(cap.getC_string(), is(exampleC));
        assertThat(cap.getG_string(), is(exampleG));
        assertThat(cap.getT_string(), is(exampleT));

    }

    @Test
    public void resolveWithPrintToFile() throws Exception {
        filename = "src/bioinf_stronghold/_14_cons/cons1.txt";
        list = FileReaderMy.getMapFromFile(filename)
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        cap = new ConsensusAndProfile();
        cap.resolve(list);

        assertThat(cap.getConcensus(), is(example));
        assertThat(cap.getA_string(), is(exampleA));
        assertThat(cap.getC_string(), is(exampleC));
        assertThat(cap.getG_string(), is(exampleG));
        assertThat(cap.getT_string(), is(exampleT));

        cap.printToFileAll(filename, cap.getConcensus(), cap.getA_string(), cap.getC_string(), cap.getG_string(), cap.getT_string());
    }

    @Test
    public void resolveBig() throws Exception {
        filename = "src/bioinf_stronghold/_14_cons/rosalind_cons.txt";
        list = FileReaderMy.getMapFromFile(filename)
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        cap = new ConsensusAndProfile();
        cap.resolve(list);
        cap.printToFileAll(filename, cap.getConcensus(), cap.getA_string(), cap.getC_string(), cap.getG_string(), cap.getT_string());
    }

    @Test
    public void resolveBigExample() throws Exception {
        filename = "src/bioinf_stronghold/_14_cons/cons_bigtest.txt";
        list = FileReaderMy.getMapFromFile(filename)
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        cap = new ConsensusAndProfile();
        cap.resolve(list);

        final String example1 = "GCGTGGGCTACCACCCAACAACCATACTGGGGTAGATATAGTAAAACGGCCACAAACATA";
        final String exampleA1 = "A: 1 2 2 1 0 1 1 2 2 2 1 2 3 2 1 0 2 3 2 3 3 1 1 4 1 3 1 2 2 2 0 2 0 2 0 4 1 3 2 3 0 0 3 3 3 2 2 2 2 1 2 2 1 5 3 3 1 4 0 2";
        final String exampleC1 = "C: 2 3 1 0 2 0 1 3 0 1 3 3 2 3 2 3 2 2 3 1 2 4 2 2 2 1 4 0 0 0 1 0 1 2 2 0 0 0 1 0 2 1 2 1 1 1 3 0 0 4 4 1 3 1 1 1 3 0 2 1";
        final String exampleG1 = "G: 3 1 3 1 3 5 3 0 2 2 1 1 1 2 2 2 1 0 0 1 2 1 2 0 1 1 1 2 3 3 3 3 2 2 3 1 2 3 1 2 3 2 1 3 0 2 2 3 3 1 1 2 2 1 0 1 1 2 2 2";
        final String exampleT1 = "T: 1 1 1 5 2 1 2 2 3 2 2 1 1 0 2 2 2 2 2 2 0 1 2 1 3 2 1 3 2 2 3 2 4 1 2 2 4 1 3 2 2 4 1 0 3 2 0 2 2 1 0 2 1 0 3 2 2 1 3 2";

        assertThat(cap.getConcensus(), is(example1));
        assertThat(cap.getA_string(), is(exampleA1));
        assertThat(cap.getC_string(), is(exampleC1));
        assertThat(cap.getG_string(), is(exampleG1));
        assertThat(cap.getT_string(), is(exampleT1));
    }

}