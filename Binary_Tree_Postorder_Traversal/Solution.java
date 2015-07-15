/**
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

https://leetcode.com/problems/binary-tree-postorder-traversal/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> retValue = new LinkedList<>();
        TreeNode head;
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Map<TreeNode, Boolean> mark = new HashMap<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                head = stack.peek();
                if (mark.containsKey(head)) {
                    if (mark.get(head)) {
                        retValue.add(stack.pop().val);
                    } else {
                        mark.put(head, true);
                        if (head.right != null)
                            stack.push(head.right);
                    }
                } else {
                    mark.put(head, false);
                    if (head.left != null)
                        stack.push(head.left);
                }
            }
        }
        return retValue;
    }
}
