/**
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

https://leetcode.com/problems/binary-tree-right-side-view/
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> retValue = new LinkedList<>();
        List<TreeNode> queue = new ArrayList<>();
        List<TreeNode> buffer = new ArrayList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            retValue.add(queue.get(queue.size() - 1).val);
            while (!queue.isEmpty()) {
                TreeNode head = queue.remove(0);
                if (head.left != null)
                    buffer.add(head.left);
                if (head.right != null)
                    buffer.add(head.right);
            }
            List<TreeNode> tmp = buffer;
            buffer = queue;
            queue = tmp;
        }
        return retValue;
    }
}
