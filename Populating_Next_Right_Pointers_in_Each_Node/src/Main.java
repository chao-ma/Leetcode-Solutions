import java.util.*;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode prevHead = root;
        TreeLinkNode curHead;
        while (prevHead != null) {
            curHead = prevHead.left;
            while (prevHead != null) {
                if (prevHead.left == null)
                    break;
                prevHead.left.next = prevHead.right;
                if (prevHead.next != null) {
                    prevHead.right.next = prevHead.next.left;
                }
                prevHead = prevHead.next;
            }
            prevHead = curHead;
        }
    }
}

public class Main {
    public static int experiment(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        int[] prevRow = new int[triangle.size()];
        int[] curRow = new int[prevRow.length];
        int count = 0, i;
        for (List<Integer> row: triangle) {
            count++; // num of elements
            i = 0;
            for (Integer v: row) {
                if (i == 0) {
                    curRow[0] = v + prevRow[0];
                } else if (i == count - 1) {
                    curRow[i] = v + prevRow[i - 1];
                } else {
                    curRow[i] = v + Math.min(prevRow[i - 1], prevRow[i]);
                }
                i++;
            }
            for (i = 0; i < count; i++)
                prevRow[i] = curRow[i];
        }
        int retValue = prevRow[0];
        for (i = 1; i < prevRow.length; i++)
            retValue = Math.min(retValue, prevRow[i]);
        return retValue;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeLinkNode root = new TreeLinkNode(0);
        root.left = new TreeLinkNode(1);
        root.right = new TreeLinkNode(2);
        root.left.left = new TreeLinkNode(3);
        root.left.right = new TreeLinkNode(4);
        root.right.left = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(6);
        Solution solution = new Solution();
        solution.connect(root);
        TreeLinkNode tail = root.left.left;
        while (tail != null) {
            System.out.println(tail.val);
            tail = tail.next;
        }
        Integer[] a = {1,2,3};
        Integer[] lastRow = null;
        System.out.println(Arrays.asList(a));
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(new Integer[] {1,2,3}));
    }

}
