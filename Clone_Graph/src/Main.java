import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<Integer, List<Integer>> lableToNeighbors = new HashMap<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.remove(0);
            LinkedList<Integer> neighborList = new LinkedList<Integer>();
            lableToNeighbors.put(head.label, neighborList);
            for (UndirectedGraphNode neighbor: head.neighbors) {
                neighborList.add(neighbor.label);
                if (!lableToNeighbors.containsKey(neighbor.label)) {
                    queue.add(neighbor);
                }
            }
        }
        Map<Integer, UndirectedGraphNode> lableToNode = new HashMap<>();
        for (Integer lable: lableToNeighbors.keySet()) {
            lableToNode.put(lable, new UndirectedGraphNode(lable));
        }
        for (Integer lable: lableToNeighbors.keySet()) {
            for (Integer neighborLable: lableToNeighbors.get(lable)) {
                lableToNode.get(lable).neighbors.add(lableToNode.get(neighborLable));
            }
        }
        return lableToNode.get(node.label);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
