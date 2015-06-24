class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private TreeNode prev = null;
    private TreeNode current = null;
    private TreeNode[] nodes = new TreeNode[4];
    private int nodeCount = 0;
    
    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        prev = current;
        current = root;
        if (prev != null) {
            if (current.val < prev.val && nodeCount < 3) {
                nodes[nodeCount] = prev;
                nodes[nodeCount + 1] = current;
                nodeCount += 2;
            }
        }
        traverse(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        int tmp;
        traverse(root);
        if (nodeCount > 0) {
            tmp = nodes[0].val;
            nodes[0].val = nodes[nodeCount - 1].val;
            nodes[nodeCount - 1].val = tmp;
        }
    }
}
 
public class Main {
    
    private static void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(9); // swapped
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4); // swapped
        Solution solution = new Solution();
        solution.recoverTree(root);
        traverse(root);
    }

}
