Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

https://leetcode.com/problems/binary-tree-paths/

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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<String>();
        if (root.left == null && root.right == null) {
            List<String> retValue = new ArrayList<>();
            retValue.add(String.valueOf(root.val));
            return retValue;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        List<String> retValue = new ArrayList<>();
        for (String s: left)
            retValue.add(String.valueOf(root.val) + "->" + s);
        for (String s: right)
            retValue.add(String.valueOf(root.val) + "->" + s);
        return retValue;
    }
}
```
