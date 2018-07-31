package bioinf_stronghold._9_fibd;

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

    public void setPairAbsoluteCounter(long pairAbsoluteCounter) {
        this.pairAbsoluteCounter = pairAbsoluteCounter;
    }

    public void setPairLiveCounter(long pairLiveCounter) {
        this.pairLiveCounter = pairLiveCounter;
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
                } else
                if (rabbitsNode.pairLiveCounter > 1) {
                    final RabbitsNode upperPairAsSelfLink = new RabbitsNode();
                    upperPairAsSelfLink.setPairAbsoluteCounter(rabbitsNode.pairAbsoluteCounter);
                    upperPairAsSelfLink.setPairLiveCounter(tempCounter);
                    rabbitsNode.upperPairAsSelfLink = upperPairAsSelfLink; //ссылка на копию себя
                    rabbitsNode.lowerPairAsChild = new RabbitsNode(rabbitsNode.pairAbsoluteCounter); // потомок производится
                } else
                if (rabbitsNode.pairLiveCounter == 1) {
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

    public static long countLeafsAtTreeAtMaximumDepth(RabbitsNode rabbitsNode) {
        long result = 0;
        final LinkedList<RabbitsNode> queue = new LinkedList<>();
        queue.addLast(rabbitsNode);
        while (!queue.isEmpty()) {
            RabbitsNode rabbitsNodeFromQueue = queue.removeFirst();
            RabbitsNode lowerPairAsChild = rabbitsNodeFromQueue.getLowerPairAsChild();
            RabbitsNode upperPairAsSelfLink = rabbitsNodeFromQueue.getUpperPairAsSelfLink();

            if (lowerPairAsChild == null && upperPairAsSelfLink == null) { //the lowest leaf
                result += 1;
            }
            if (lowerPairAsChild != null) {
                queue.addLast(lowerPairAsChild);
            }
            if (upperPairAsSelfLink != null) {
                queue.addLast(upperPairAsSelfLink);
            }
            rabbitsNodeFromQueue.lowerPairAsChild = null;
            rabbitsNodeFromQueue.upperPairAsSelfLink = null;
            lowerPairAsChild = null;
            upperPairAsSelfLink = null;
        }
        return result;
    }

    public static void main(String[] args) {
        int MONTHS = 9;
        RabbitsNode rabbitsNode = new RabbitsNode(3);  //month 1
        addHistoricalPairNode(rabbitsNode);//month 2
        performLeafNodes(rabbitsNode, 2, MONTHS); //2 because month is two.
        long leafs = countLeafsAtTreeAtMaximumDepth(rabbitsNode);
        System.out.println(leafs);
    }
}
