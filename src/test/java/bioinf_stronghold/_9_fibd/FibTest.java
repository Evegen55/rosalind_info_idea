package bioinf_stronghold._9_fibd;

import org.junit.Test;

import java.math.BigInteger;

import static bioinf_stronghold._9_fibd.Fib.*;
import static org.junit.Assert.*;

public class FibTest {

    @Test
    public void testFibRecursive() {
        int N = 42; //max depth of fibonacci for long type.
        System.out.println("N = " + N);
        System.out.println("Long.MAX_VALUE = \n" + Long.MAX_VALUE);

        long fib = fibRecursive(N);
        System.out.println("Fibonacci with fibRecursive for  " + N + "-th value = \n" + fib);
    }

    @Test
    public void testFibRecursiveImproved() {
        int N = 92; //max depth of fibonacci for long type.
        System.out.println("N = " + N);
        System.out.println("Long.MAX_VALUE = \n" + Long.MAX_VALUE);
        initFibArray();
        long fibImproved = fibRecursiveImproved(N);
        System.out.println("Fibonacci with fibRecursiveImproved for " + N + "-th value = \n" + fibImproved);
        System.out.println();
        for (long l : fibonacci) {
            System.out.println(l);
        }
    }

    @Test
    public void testFibRecursiveImprovedBigs() {
        int NBig = 150;
        System.out.println("N = " + NBig);
        System.out.println("Long.MAX_VALUE = \n" + Long.MAX_VALUE);
        initFibArrayBigs();
        BigInteger fibImprovedBigs = fibRecursiveImprovedBigs(NBig);
        System.out.println("Fibonacci with fibRecursiveImproved for " + NBig + "-th value = \n" + fibImprovedBigs);
        System.out.println();
        for (BigInteger l : fibonacciBigs) {
            System.out.println(l);
        }
    }
}