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
        long leafs = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode);
        assertEquals(1, leafs);

        long leafCount = getLeafCount(rabbitsNode);
        assertEquals(1, leafCount);
    }

    @Test
    public void buildRabbitsThree2() {
        int N = 2; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode);
        assertEquals(1, leafs);

        long leafCount = getLeafCount(rabbitsNode);
        assertEquals(1, leafCount);
    }

    @Test
    public void buildRabbitsThree3() {
        int N = 3; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode);
        assertEquals(2, leafs);

        long leafCount = getLeafCount(rabbitsNode);
        assertEquals(2, leafCount);
    }

    @Test
    public void buildRabbitsThree4() {
        int N = 4; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode);
        assertEquals(2, leafs);

        long leafCount = getLeafCount(rabbitsNode);
        assertEquals(2, leafCount);
    }

    @Test
    public void buildRabbitsThree5() {
        int N = 5; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode);
        assertEquals(3, leafs);

        long leafCount = getLeafCount(rabbitsNode);
        assertEquals(3, leafCount);
    }

    @Test
    public void buildRabbitsThree6() {
        int N = 6; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode);
        assertEquals(4, leafs);

        long leafCount = getLeafCount(rabbitsNode);
        assertEquals(4, leafCount);
    }

    @Test
    public void buildRabbitsThree7() {
        int N = 7; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode);
        assertEquals(5, leafs);

        long leafCount = getLeafCount(rabbitsNode);
        assertEquals(5, leafCount);
    }

    @Test
    public void buildRabbitsThree8() {
        int N = 8; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode);
        assertEquals(7, leafs);

        long leafCount = getLeafCount(rabbitsNode);
        assertEquals(7, leafCount);
    }

    @Test
    public void buildRabbitsThree9() {
        int N = 9; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode);
        assertEquals(9, leafs);

        long leafCount = getLeafCount(rabbitsNode);
        assertEquals(9, leafCount);
    }

//    @Test
    public void buildRabbitsThreeFree() {
        int N = 40; // общий срок расчетов                 //Duration to build tree 8967 milliseconds
        int M = 20; //срок жизни одной пары //max 20
        LocalDateTime before = LocalDateTime.now();
        System.out.println("Before " + before + "\n");

        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, N); //2 because month is two.

        LocalDateTime middle = LocalDateTime.now();
        System.out.println("Middle " + middle + "\n");
        System.out.println("Duration to build tree " + Duration.between(before, middle).toMillis() + " milliseconds" + "\n");

        long leafs = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode);
//        long leafs = getLeafCount(rabbitsNode); //
        System.out.println("Leafs: " + leafs + "\n");

        LocalDateTime after = LocalDateTime.now();
        System.out.println("After " + after + "\n");
        System.out.println("Duration to count leafs " + Duration.between(middle, after).toMillis() + " milliseconds" + "\n");
        System.out.println("Duration full " + Duration.between(before, after).toMillis() + " milliseconds" + "\n");

//        long leafCount = getLeafCount(rabbitsNode);
//        System.out.println("Leafs new: " + leafCount);
//        LocalDateTime afterNew = LocalDateTime.now();
//        System.out.println("After new " + afterNew + "\n");
//        System.out.println("Duration to count leafs New " + Duration.between(after, afterNew).toMillis() + " milliseconds" + "\n");

//        assertEquals(leafs, leafCount);

    }

    /**
     * Before 2018-08-01T14:36:45.546
     *
     *  middleUpperHalfTree 2018-08-01T14:37:42.583
     *
     * Duration to build UPPER HALF tree 57037 milliseconds -> BIGGER PART of tree
     *
     *  middleLowerHalfTree 2018-08-01T14:37:51.037
     *
     * Duration to build LOWER HALF tree 8454 milliseconds
     *
     * WOW!!!
     */
//    @Test
    public void buildRabbitsThreeDivide() {
        int N = 100; // общий срок расчетов
        int M = 3; //срок жизни одной пары
        System.out.println("N = " + N + "\tM = " + M);

//        int N = 8; // общий срок расчетов
//        int M = 3; //срок жизни одной пары

        LocalDateTime before = LocalDateTime.now();
        System.out.println("Before " + before + "\n");

        RabbitsNode rabbitsNode = new RabbitsNode(M);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        addHistoricalPairNode(rabbitsNode.getUpperPairAsSelfLink());//month 3
        addHistoricalPairNode(rabbitsNode.getUpperPairAsSelfLink().getUpperPairAsSelfLink());//month 4
        addHistoricalPairNode(rabbitsNode.getUpperPairAsSelfLink().getLowerPairAsChild());//month 4

        performLeafNodes(rabbitsNode.getUpperPairAsSelfLink().getUpperPairAsSelfLink(), 4, N); //4 because month is four.
        long leafsUpper = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode.getUpperPairAsSelfLink().getUpperPairAsSelfLink());
        // TODO: 01/08/2018 at here we can de-attach upper half of three and throw it away
        rabbitsNode.getUpperPairAsSelfLink().setUpperPairAsSelfLink(null);
        System.gc();

        LocalDateTime middleUpperHalfTree = LocalDateTime.now();
        System.out.println(" middleUpperHalfTree " +  middleUpperHalfTree + "\n");
        System.out.println("Duration to build UPPER HALF tree " + Duration.between(before,  middleUpperHalfTree).toMillis() + " milliseconds" + "\n");


        performLeafNodes(rabbitsNode.getUpperPairAsSelfLink().getLowerPairAsChild(), 4, N); //4 because month is four.
        long leafsLower = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode.getUpperPairAsSelfLink().getLowerPairAsChild());

        LocalDateTime middleLowerHalfTree = LocalDateTime.now();
        System.out.println(" middleLowerHalfTree " +  middleLowerHalfTree + "\n");
        System.out.println("Duration to build LOWER HALF tree " + Duration.between(middleUpperHalfTree,  middleLowerHalfTree).toMillis() + " milliseconds" + "\n");

        long leafs = leafsLower + leafsUpper;

        System.out.println(leafs);
//        assertEquals(leafs, 98130253);
//        assertEquals( 7, leafs);

    }

}