/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retValue = new ArrayList<>();
        if (root != null) {
            List<TreeNode> queue = new ArrayList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                List<TreeNode> children = new ArrayList<>();
                for (TreeNode node: queue) {
                    level.add(node.val);
                    if (node.left != null)
                        children.add(node.left);
                    if (node.right != null)
                        children.add(node.right);
                }
                retValue.add(level);
                queue = children;
            }
        }
        return retValue;
    }
}

