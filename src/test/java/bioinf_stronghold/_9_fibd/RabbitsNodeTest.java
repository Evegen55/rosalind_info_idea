package bioinf_stronghold._9_fibd;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static bioinf_stronghold._9_fibd.RabbitsNode.addHistoricalPairNode;
import static bioinf_stronghold._9_fibd.RabbitsNode.countLeafsAtTreeAtMaximumDepth;
import static bioinf_stronghold._9_fibd.RabbitsNode.performLeafNodes;
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

    @Test
    public void buildRabbitsThreeFree() {
        int N = 40; // общий срок расчетов                 //Duration to build tree 8967 milliseconds
        int M = 10; //срок жизни одной пары
        LocalDateTime before = LocalDateTime.now();
        System.out.println("Before " + before + "\n");

        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.

        LocalDateTime middle = LocalDateTime.now();
        System.out.println("Middle " + middle + "\n");
        System.out.println("Duration to build tree " + Duration.between(before, middle).toMillis() + " milliseconds" + "\n");

//        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
//        System.out.println("Leafs: " + leafs + "\n");

        LocalDateTime after = LocalDateTime.now();
        System.out.println("After " + after + "\n");
        System.out.println("Duration to count leafs " + Duration.between(middle, after).toMillis() + " milliseconds" + "\n");
        System.out.println("Duration full " + Duration.between(before, after).toMillis() + " milliseconds" + "\n");
    }

}