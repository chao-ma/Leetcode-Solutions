/*
Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    
    private TreeNode helper(int[] preorder, int preorderBegin, int preorderEnd,
                            int[] inorder, int inorderBegin, int inorderEnd) {
        if (preorderBegin >= preorderEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preorderBegin]);
        int i;
        for (i = inorderBegin; inorder[i] != root.val; i++);
        root.left = helper(preorder, preorderBegin + 1, preorderBegin + 1 + i - inorderBegin,
                           inorder, inorderBegin, i);
        root.right = helper(preorder, preorderBegin + 1 + i - inorderBegin, preorderEnd,
                            inorder, i + 1, inorderEnd);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
}
