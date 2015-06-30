/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    private TreeNode helper(int[] inorder, int inorderBegin, int inorderEnd,
                            int[] postorder, int postorderBegin, int postorderEnd) {
        if (postorderBegin >= postorderEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postorderEnd - 1]);
        int i;
        for (i = inorderBegin; inorder[i] != root.val; i++);
        root.left = helper(inorder, inorderBegin, i,
                           postorder, postorderBegin, postorderBegin + i - inorderBegin);
        root.right = helper(inorder, i + 1, inorderEnd,
                            postorder, postorderBegin + i - inorderBegin, postorderEnd - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);        
    }
}
