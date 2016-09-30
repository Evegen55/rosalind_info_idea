package bioinf_stronghold._14_cons;

import bioinf_stronghold.utils.FileReaderMy;
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

}