package bioinf_stronghold._9_fibd;

public class PairOfRabbits {

    private static long totalCounter = 0;

    private boolean isPairAlive = true;

    private long pairLiveCounter; //in month
    private final long pairAbsoluteCounter;

    public PairOfRabbits(long pairLiveCounter) {
        System.out.println("New pair of rabbits " + toString()+ "\n");
        this.pairLiveCounter = pairLiveCounter;
        pairAbsoluteCounter = pairLiveCounter;
        totalCounter += 1; //increase total counter when born
    }

    public PairOfRabbits produceNewRabbitsOrDie() {
        PairOfRabbits pairOfRabbitsChildren = null;
        if (pairLiveCounter == 0) {
            isPairAlive = false;
            totalCounter -= 1; //decrease when died
            System.out.println("rabbits " + toString() + " died" + ", totalCounter is: " + totalCounter + "\n");
        } else {
            long month = pairAbsoluteCounter - pairLiveCounter + 1;
            System.out.println("rabbits " + toString() + " alive" + ", month of pair's life is " + month + " totalCounter is: " + totalCounter + "\n");

            if (pairLiveCounter == pairAbsoluteCounter) {
                System.out.println("rabbits " + toString() + " is too young" + ", month of pair's life is " + month + " totalCounter is: " + totalCounter + "\n");
            } else {
                System.out.print("rabbits " + toString() + " start new pair" + ", month of pair's life is " + month + " totalCounter is: " + totalCounter + "\t");
                pairOfRabbitsChildren = new PairOfRabbits(pairAbsoluteCounter);
            }
            pairLiveCounter -= 1;
        }
        return pairOfRabbitsChildren;
    }

    public static long getTotalCounter() {
        return totalCounter;
    }

    public boolean isPairAlive() {
        return isPairAlive;
    }

    public static void main(String[] args) {

        PairOfRabbits pairOfRabbits = new PairOfRabbits(3);
        long c1 = 0;
        while (pairOfRabbits.isPairAlive()) {
            PairOfRabbits pairOfRabbits1 = pairOfRabbits.produceNewRabbitsOrDie();
            c1 += 1;
            if (pairOfRabbits1 != null) {
                c1 += 1;
                while (pairOfRabbits1.isPairAlive()) {
                    PairOfRabbits pairOfRabbits2 = pairOfRabbits1.produceNewRabbitsOrDie();
                }
            }
        }

        System.out.println("total: " + PairOfRabbits.getTotalCounter());
        System.out.println("months: " + c1);
    }

}