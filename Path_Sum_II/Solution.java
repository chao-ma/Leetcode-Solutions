/**
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
https://leetcode.com/problems/path-sum-ii/
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
    List<Integer> solution = new ArrayList<>();
    List<List<Integer>> retValue = new ArrayList<>();
    private void helper(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> entry = new ArrayList<>(solution);
                entry.add(sum);
                retValue.add(entry);
            }
            return;
        }
        solution.add(root.val);
        if (root.left != null)
            helper(root.left, sum - root.val);
        if (root.right != null)
            helper(root.right, sum - root.val);
        solution.remove(solution.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            helper(root, sum);
        }
        return retValue;
    }
}
