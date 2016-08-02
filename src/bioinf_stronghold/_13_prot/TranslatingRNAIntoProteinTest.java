package bioinf_stronghold._13_prot;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Evegen on 02.08.2016.
 */
public class TranslatingRNAIntoProteinTest {

    TranslatingRNAIntoProtein trp;

    @Before
    public void setUp() throws Exception {
        trp = new TranslatingRNAIntoProtein();
    }

    @Test
    public void resolve() throws Exception {
        String dna = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA";
        String result = trp.resolve(dna);
        assertThat(result, is("MAMAPRTEINSTRING"));
    }

}