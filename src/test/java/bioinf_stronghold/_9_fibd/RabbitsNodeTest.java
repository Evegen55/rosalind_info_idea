package bioinf_stronghold._9_fibd;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static bioinf_stronghold._9_fibd.RabbitsNode.*;
import static org.junit.Assert.assertEquals;

public class RabbitsNodeTest {

    // month 2, leafs 1
    // month 3, leafs 2
    // month 4, leafs 4
    // month 5, leafs 3
    // month 6, leafs 4
    // month 7, leafs 5
    // month 8, leafs 7
    // month 9, leafs 9

    @Test
    public void buildRabbitsThree1() {
        int N = 1; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
        assertEquals(1, leafs);
    }

    @Test
    public void buildRabbitsThree2() {
        int N = 2; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
        assertEquals(1, leafs);
    }

    @Test
    public void buildRabbitsThree3() {
        int N = 3; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
        assertEquals(2, leafs);
    }

    @Test
    public void buildRabbitsThree4() {
        int N = 4; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
        assertEquals(2, leafs);
    }

    @Test
    public void buildRabbitsThree5() {
        int N = 5; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
        assertEquals(3, leafs);
    }

    @Test
    public void buildRabbitsThree6() {
        int N = 6; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
        assertEquals(4, leafs);
    }

    @Test
    public void buildRabbitsThree7() {
        int N = 7; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
        assertEquals(5, leafs);
    }

    @Test
    public void buildRabbitsThree8() {
        int N = 8; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
        assertEquals(7, leafs);
    }

    @Test
    public void buildRabbitsThree9() {
        int N = 9; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
        assertEquals(9, leafs);
    }

    /**
     * -Xmx12G
     * <p>
     * Before 2018-08-01T01:10:53.303983
     * <p>
     * Middle 2018-08-01T01:11:03.382539
     * <p>
     * Duration to build tree 10078 milliseconds
     * <p>
     * Leafs: 90815799
     * <p>
     * After 2018-08-01T01:12:16.618869
     * <p>
     * Duration to count leafs 73236 milliseconds
     * <p>
     * Duration full 83314 milliseconds
     * <p>
     * <p>
     * Process finished with exit code 0
     */
    @Test
    public void buildRabbitsThreeFree() {
        int N = 40; // общий срок расчетов                 //Duration to build tree 8967 milliseconds
        int M = 13; //срок жизни одной пары
        LocalDateTime before = LocalDateTime.now();
        System.out.println("Before " + before + "\n");

        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.

        LocalDateTime middle = LocalDateTime.now();
        System.out.println("Middle " + middle + "\n");
        System.out.println("Duration to build tree " + Duration.between(before, middle).toMillis() + " milliseconds" + "\n");

        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode); // TODO: 01.08.18 MULTITHREADING??
        System.out.println("Leafs: " + leafs + "\n");

        LocalDateTime after = LocalDateTime.now();
        System.out.println("After " + after + "\n");
        System.out.println("Duration to count leafs " + Duration.between(middle, after).toMillis() + " milliseconds" + "\n");
        System.out.println("Duration full " + Duration.between(before, after).toMillis() + " milliseconds" + "\n");
    }

    /*
int N = 40;

int M = 12;

Before 2018-08-01T01:14:05.987745

Middle 2018-08-01T01:14:16.034387

Duration to build tree 10046 milliseconds

Leafs: 98130253

After 2018-08-01T01:16:09.389341

Duration to count leafs 113354 milliseconds

Duration full 123401 milliseconds

===========================================


     */

}