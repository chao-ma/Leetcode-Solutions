import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private List<TreeNode> generateTreesHelper(int from, int to) {
        List<TreeNode> retValue = new ArrayList<>();
        if (from > to) {
            retValue.add(null);
            return retValue;
        }
        if (from == to) {
            retValue.add(new TreeNode(to));
            return retValue;
        }
        for (int i = from; i <= to; i++) {
            List<TreeNode> lefts = generateTreesHelper(from, i - 1);
            List<TreeNode> rights = generateTreesHelper(i + 1, to);
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    retValue.add(root);
                }
            }
        }
        return retValue;
    }
    
    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }
}
 
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
