package bioinf_stronghold._9_fibd;

import java.math.BigInteger;

public class Fib {

    //        VERY SLOW, LOTS OF RECURSIVE INVOCATIONS
    public static long fibRecursive(long n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    //==============================================
    //        VERY FAST, BUT only for 92-th fibonacci number
    public final static long[] fibonacci = new long[100];
    static int MaxN = 0;

    public static void initFibArray() {
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        MaxN = 1;
    }
    public static long fibRecursiveImproved(int n) {
        if (MaxN < n ) {
            fibonacci[n] = fibRecursiveImproved(n - 1) + fibRecursiveImproved(n - 2);
            MaxN = n;
        }
        return fibonacci[n];
    }


    //==============================================
    public final static BigInteger[] fibonacciBigs = new BigInteger[151]; //for 100 fibs
    private static int MaxNBigs = 0;

    public static void initFibArrayBigs() {
        fibonacciBigs[0] = BigInteger.valueOf(0);
        fibonacciBigs[1] = BigInteger.valueOf(1);
        MaxNBigs = 1;
    }
    public static BigInteger fibRecursiveImprovedBigs(int n) {
        if (MaxNBigs < n ) {
            fibonacciBigs[n] = fibRecursiveImprovedBigs(n - 1).add(fibRecursiveImprovedBigs(n - 2));
            MaxNBigs = n;
        }
        return fibonacciBigs[n];
    }
}
