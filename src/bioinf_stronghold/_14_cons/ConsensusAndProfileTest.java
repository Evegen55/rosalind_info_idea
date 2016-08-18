package bioinf_stronghold._14_cons;

import bioinf_stronghold._6_gc.FileReaderMy;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by Evgenii_Lartcev on 8/18/2016.
 */
public class ConsensusAndProfileTest {
    ConsensusAndProfile cap;
    String filename;
    List<String> list;


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

    }

}