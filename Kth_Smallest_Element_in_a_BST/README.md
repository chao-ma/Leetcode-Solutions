Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

```java
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
    private int counter = 0;
    private TreeNode helper(TreeNode root, int k) {
        if (root == null)
            return null;
        TreeNode left = helper(root.left, k);
        if (left != null)
            return left;
        counter++;
        if (counter == k)
            return root;
        return helper(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k).val;
    }
}
```
