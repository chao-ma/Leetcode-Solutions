class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    
    private boolean isValidBSTHelper(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null)
            return true;
        boolean retValue = (left == null || root.val > left.val) && 
                           (right == null || root.val < right.val);
        retValue = retValue && isValidBSTHelper(root.left, left, root);
        retValue = retValue && isValidBSTHelper(root.right, root, right);
        return retValue;
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
