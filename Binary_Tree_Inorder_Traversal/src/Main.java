import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    
    private List<Integer> retValue = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cursor = root;
            while (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            }
            while (!stack.isEmpty()) {
                cursor = stack.pop();
                retValue.add(cursor.val);
                cursor = cursor.right;
                while (cursor != null) {
                    stack.push(cursor);
                    cursor = cursor.left;
                }
            }
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        System.out.println(solution.inorderTraversal(root));
    }

}
 