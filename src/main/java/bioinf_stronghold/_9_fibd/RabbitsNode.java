package bioinf_stronghold._9_fibd;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class RabbitsNode {

    private boolean isPairAlive = true;

    private long pairAbsoluteCounter; //in month

    private long pairLiveCounter; //in month

    private RabbitsNode lowerPairAsChild;

    private RabbitsNode upperPairAsSelfLink;

    public RabbitsNode() {
    }

    public RabbitsNode(long pairLiveCounter) {
        pairAbsoluteCounter = pairLiveCounter;
        this.pairLiveCounter = pairLiveCounter;
    }

    public RabbitsNode getLowerPairAsChild() {
        return lowerPairAsChild;
    }

    public RabbitsNode getUpperPairAsSelfLink() {
        return upperPairAsSelfLink;
    }

    public void setLowerPairAsChild(RabbitsNode lowerPairAsChild) {
        this.lowerPairAsChild = lowerPairAsChild;
    }

    public void setUpperPairAsSelfLink(RabbitsNode upperPairAsSelfLink) {
        this.upperPairAsSelfLink = upperPairAsSelfLink;
    }

    public void setPairAbsoluteCounter(long pairAbsoluteCounter) {
        this.pairAbsoluteCounter = pairAbsoluteCounter;
    }

    public void setPairLiveCounter(long pairLiveCounter) {
        this.pairLiveCounter = pairLiveCounter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RabbitsNode{");
        sb.append("isPairAlive=").append(isPairAlive);
        sb.append(", pairAbsoluteCounter=").append(pairAbsoluteCounter);
        sb.append(", pairLiveCounter=").append(pairLiveCounter);
        sb.append(", lowerPairAsChild=").append(lowerPairAsChild);
        sb.append(", upperPairAsSelfLink=").append(upperPairAsSelfLink);
        sb.append('}');
        return sb.toString();
    }

    public static void addHistoricalPairNode(RabbitsNode rabbitsNode) {
        if (rabbitsNode != null) {
            if (rabbitsNode.isPairAlive) {
                long tempCounter = rabbitsNode.pairLiveCounter - 1;
                if (rabbitsNode.pairLiveCounter == rabbitsNode.pairAbsoluteCounter) { //момент когда пара создана
                    final RabbitsNode upperPairAsSelfLink = new RabbitsNode();
                    upperPairAsSelfLink.setPairAbsoluteCounter(rabbitsNode.pairAbsoluteCounter);
                    upperPairAsSelfLink.setPairLiveCounter(tempCounter);
                    rabbitsNode.upperPairAsSelfLink = upperPairAsSelfLink; //ссылка на копию себя
                    rabbitsNode.lowerPairAsChild = null; // потомок не производится
                } else if (rabbitsNode.pairLiveCounter > 1) {
                    final RabbitsNode upperPairAsSelfLink = new RabbitsNode();
                    upperPairAsSelfLink.setPairAbsoluteCounter(rabbitsNode.pairAbsoluteCounter);
                    upperPairAsSelfLink.setPairLiveCounter(tempCounter);
                    rabbitsNode.upperPairAsSelfLink = upperPairAsSelfLink; //ссылка на копию себя
                    rabbitsNode.lowerPairAsChild = new RabbitsNode(rabbitsNode.pairAbsoluteCounter); // потомок производится
                } else if (rabbitsNode.pairLiveCounter == 1) {
                    rabbitsNode.isPairAlive = false; //кролики сдохли
                    rabbitsNode.upperPairAsSelfLink = null; //кроликов больше нету
                    rabbitsNode.lowerPairAsChild = new RabbitsNode(rabbitsNode.pairAbsoluteCounter); // потомок производится
                }
                rabbitsNode.pairLiveCounter = tempCounter; //уменьшили счетчик жизни
            }
        }
    }

    public static void performLeafNodes(RabbitsNode rabbitsNode, int counter, int MONTHS) {
        if (counter >= MONTHS) {
            return;
        }
        counter += 1;
        RabbitsNode upperPairAsSelfLink_month2 = rabbitsNode.getUpperPairAsSelfLink();
        if (upperPairAsSelfLink_month2 != null) {
            addHistoricalPairNode(upperPairAsSelfLink_month2);
            performLeafNodes(upperPairAsSelfLink_month2, counter, MONTHS);
        }
        RabbitsNode lowerPairAsChild_month2 = rabbitsNode.getLowerPairAsChild();
        if (lowerPairAsChild_month2 != null) {
            addHistoricalPairNode(lowerPairAsChild_month2);
            performLeafNodes(lowerPairAsChild_month2, counter, MONTHS);
        }
    }

    public static long countLeafsAtTreeAtMaximumDepthBFS(RabbitsNode rabbitsNode) {
        long result = 0;
        final LinkedList<RabbitsNode> queue = new LinkedList<>();
        queue.addLast(rabbitsNode);
        while (!queue.isEmpty()) {
            RabbitsNode rabbitsNodeFromQueue = queue.removeFirst();
            if (rabbitsNodeFromQueue.getLowerPairAsChild() == null && rabbitsNodeFromQueue.getUpperPairAsSelfLink() == null) { //the lowest leaf
                result += 1;
            }
            if (rabbitsNodeFromQueue.getLowerPairAsChild() != null) {
                queue.addLast(rabbitsNodeFromQueue.getLowerPairAsChild());
            }
            if (rabbitsNodeFromQueue.getUpperPairAsSelfLink() != null) {
                queue.addLast(rabbitsNodeFromQueue.getUpperPairAsSelfLink());
            }
        }
        return result;
    }

    public static long getLeafCount(RabbitsNode rabbitsNode) {
        if (rabbitsNode == null)
            return 0;
        if (rabbitsNode.getLowerPairAsChild() == null && rabbitsNode.getUpperPairAsSelfLink() == null)
            return 1;
        else
            return getLeafCount(rabbitsNode.getLowerPairAsChild()) + getLeafCount(rabbitsNode.getUpperPairAsSelfLink());
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // общий срок расчетов                 //Duration to build tree 8967 milliseconds
        int M = Integer.parseInt(args[1]); //срок жизни одной пары //max 20
        System.out.println("N = " + N + "\tM = " + M);
//        oldStyle(N, M);
        countByBranchesWithDeletingBranch(N, M);
    }

    private static void countByBranchesWithDeletingBranch(int n, int m) {
        LocalDateTime before = LocalDateTime.now();
        System.out.println("Before " + before + "\n");

        RabbitsNode rabbitsNode = new RabbitsNode(m);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        addHistoricalPairNode(rabbitsNode.getUpperPairAsSelfLink());//month 3
        addHistoricalPairNode(rabbitsNode.getUpperPairAsSelfLink().getUpperPairAsSelfLink());//month 4
        addHistoricalPairNode(rabbitsNode.getUpperPairAsSelfLink().getLowerPairAsChild());//month 4

        performLeafNodes(rabbitsNode.getUpperPairAsSelfLink().getUpperPairAsSelfLink(), 4, n); //4 because month is four.
        long leafsUpper = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode.getUpperPairAsSelfLink().getUpperPairAsSelfLink());
        rabbitsNode.getUpperPairAsSelfLink().setUpperPairAsSelfLink(null);
        System.gc();

        LocalDateTime middleUpperHalfTree = LocalDateTime.now();
        System.out.println(" middleUpperHalfTree " +  middleUpperHalfTree + "\n");
        System.out.println("Duration to build UPPER HALF tree " + Duration.between(before,  middleUpperHalfTree).toMillis() + " milliseconds" + "\n");


        performLeafNodes(rabbitsNode.getUpperPairAsSelfLink().getLowerPairAsChild(), 4, n); //4 because month is four.
        long leafsLower = countLeafsAtTreeAtMaximumDepthBFS(rabbitsNode.getUpperPairAsSelfLink().getLowerPairAsChild());

        LocalDateTime middleLowerHalfTree = LocalDateTime.now();
        System.out.println(" middleLowerHalfTree " +  middleLowerHalfTree + "\n");
        System.out.println("Duration to build LOWER HALF tree " + Duration.between(middleUpperHalfTree,  middleLowerHalfTree).toMillis() + " milliseconds" + "\n");

        long leafs = leafsLower + leafsUpper;

        System.out.println(leafs);
    }

    private static void oldStyle(int n, int m) {
        LocalDateTime before = LocalDateTime.now();
        System.out.println("Before " + before + "\n");

        RabbitsNode rabbitsNode = new RabbitsNode(m);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, n); //2 because month is two.

        LocalDateTime middle = LocalDateTime.now();
        System.out.println("Middle " + middle + "\n");
        System.out.println("Duration to build tree " + Duration.between(before, middle).toMillis() + " milliseconds" + "\n");

        long leafs = getLeafCount(rabbitsNode);
        System.out.println("Leafs: " + leafs + "\n");

        LocalDateTime after = LocalDateTime.now();
        System.out.println("After " + after + "\n");
        System.out.println("Duration to count leafs " + Duration.between(middle, after).toMillis() + " milliseconds" + "\n");
        System.out.println("Duration full " + Duration.between(before, after).toMillis() + " milliseconds" + "\n");
    }
}
