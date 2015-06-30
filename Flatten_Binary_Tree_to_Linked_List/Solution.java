/**
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

My note: Declare a collection to collect pre-order traversal is trivial. I want O(N) time complexity and O(Logn) stack complexity. Basically no additional space complexity except for recursion
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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        prev = root;
        TreeNode right = root.right;
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        TreeNode tail = prev;
        tail.right = right;
        flatten(right);
    }
}
