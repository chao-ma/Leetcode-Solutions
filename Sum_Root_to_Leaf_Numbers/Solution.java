/**
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Return the sum = 12 + 13 = 25.

https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
    int retValue = 0;
    private void helper(TreeNode root, int addition) {
        if (root.left == null && root.right == null) {
            retValue += addition + root.val;
            return;
        }
        if (root.left != null)
            helper(root.left, (addition + root.val) * 10);
        if (root.right != null)
            helper(root.right, (addition + root.val) * 10);
    }   
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        helper(root, 0);
        return retValue;
    }
}
