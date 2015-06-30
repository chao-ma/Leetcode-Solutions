/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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

    

    private boolean helper(TreeNode left, TreeNode right) {

        if (left == null ^ right == null)

            return false;

        if (left == null)

            return true;

        return left.val == right.val && helper(left.right, right.left) && helper(left.left, right.right);

    }

    

    public boolean isSymmetric(TreeNode root) {

        if (root == null)

            return true;

        return helper(root.left, root.right);

    }

}
