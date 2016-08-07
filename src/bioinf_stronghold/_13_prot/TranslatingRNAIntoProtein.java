
package bioinf_stronghold._13_prot;

/**
 * Created by Evegen on 02.08.2016.
 */
public class TranslatingRNAIntoProtein {

    /**
     * A table indicating the translation of individual RNA codons
     * into amino acids for the purpose of protein creation.
     *
     * @param codon
     * @return The 20 commonly occurring amino acids are abbreviated
     *          by using 20 letters from the English alphabet
     *          (all letters except for B, J, O, U, X, and Z)
     *          0 if STOP
     *          1 if error
     */
    public static char makeAminoAcidFromCodon(String codon) {
        if(codon.equals("GCA") || codon.equals("GCC") || codon.equals("GCG") || codon.equals("GCU")) return 'A';
        if(codon.equals("UGC") || codon.equals("UGU")) return 'C';
        if(codon.equals("GAC") || codon.equals("GAU")) return 'D';
        if(codon.equals("GAA") || codon.equals("GAG")) return 'E';
        if(codon.equals("UUC") || codon.equals("UUU")) return 'F';
        if(codon.equals("GGA") || codon.equals("GGC") || codon.equals("GGG") || codon.equals("GGU")) return 'G';
        if(codon.equals("CAC") || codon.equals("CAU")) return 'H';
        if(codon.equals("AUA") || codon.equals("AUC") || codon.equals("AUU")) return 'I';
        if(codon.equals("AAA") || codon.equals("AAG")) return 'K';
        if(codon.equals("CUA") || codon.equals("CUC") || codon.equals("CUG") || codon.equals("CUU")
                || codon.equals("UUA")|| codon.equals("UUG")) return 'L';
        if(codon.equals("AUG")) return 'M';
        if(codon.equals("AAC") || codon.equals("AAU")) return 'N';
        if(codon.equals("CCA") || codon.equals("CCC") || codon.equals("CCG") || codon.equals("CCU")) return 'P';
        if(codon.equals("CAA") || codon.equals("CAG")) return 'Q';
        if(codon.equals("AGA") || codon.equals("AGG") || codon.equals("CGA") || codon.equals("CGC")
                || codon.equals("CGG")|| codon.equals("CGU")) return 'R';
        if(codon.equals("AGC") || codon.equals("AGU") || codon.equals("UCA") || codon.equals("UCC")
                || codon.equals("UCG")|| codon.equals("UCU")) return 'S';
        if(codon.equals("ACA") || codon.equals("ACC") || codon.equals("ACG") || codon.equals("ACU")) return 'T';
        if(codon.equals("GUA") || codon.equals("GUC") || codon.equals("GUG") || codon.equals("GUU")) return 'V';
        if(codon.equals("UGG")) return 'W';
        if(codon.equals("UAC") || codon.equals("UAU")) return 'Y';
        if(codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA") || codon.equals("CCU")) return 0; //STOP
        return 1; //ERROR
    }
    public String resolve(String dna){
        int wordLength = dna.length();
        int codonLenght = 3;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<wordLength; i +=3) {
            if(codonLenght+i <= wordLength) {
                String s = dna.substring(i, i+3);
                //System.out.println(s);
                char ch = makeAminoAcidFromCodon(s);
                if (ch != 0 && ch != 1) {
                    sb.append(ch);
                }
            }

        }
        return sb.toString();
    }
}
