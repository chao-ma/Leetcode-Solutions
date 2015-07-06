/**
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
https://leetcode.com/problems/binary-tree-maximum-path-sum/

My note: a path from any node to any node can be simplified to one node to any of its child node on the left and another on the right.
So the recursion protocol should return the best path from root to any of its child node. And visitor function simply combines both.
*/
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
    
    int retValue = 0; // records the best path sum during recursion
    
    /*
     * returns the best sum of path from root to its child node/leaf
     */
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        retValue = Math.max(retValue, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
    
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        retValue = root.val;
        helper(root);
        return retValue;
    }
}
