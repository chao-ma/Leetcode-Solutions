/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> levelStack = new Stack<>();
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
                queue = children;
                levelStack.push(level);
            }
        }
        while (!levelStack.isEmpty())
            retValue.add(levelStack.pop());
        return retValue;
    }
}
