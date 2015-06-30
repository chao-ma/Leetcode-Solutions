/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retValue = new ArrayList<>();
        boolean leftToRight = true;
        if (root != null) {
            List<TreeNode> queue = new ArrayList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                List<TreeNode> children = new ArrayList<>();
                for (int i = queue.size() - 1; i >= 0; i--) {
                    TreeNode node = queue.get(i);
                    level.add(node.val);
                    if (leftToRight) {
                        if (node.left != null)
                            children.add(node.left);
                        if (node.right != null)
                            children.add(node.right);
                    } else {
                        if (node.right != null)
                            children.add(node.right);
                        if (node.left != null)
                            children.add(node.left);
                    }
                }
                retValue.add(level);
                queue = children;
                leftToRight = !leftToRight;
            }
        }
        return retValue;
    }
}
