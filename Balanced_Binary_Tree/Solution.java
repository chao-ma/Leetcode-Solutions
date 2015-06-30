/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

// My note: use negative to indicate if the subtree is balanced. positive means the height of subtree

/**

 * Definition for a binary tree node.

 * public class TreeNode {

 *     int val;

 *     TreeNode left;

 *     TreeNode right;

 *     TreeNode(int x) { val = x; }

 * }

 */

public class Solution {
    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        if (left < 0)
            return left;
        int right = height(root.right);
        if (right < 0)
            return right;
        if (left > right + 1 || right > left + 1)
            return -1;
        return Math.max(left, right) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
}
