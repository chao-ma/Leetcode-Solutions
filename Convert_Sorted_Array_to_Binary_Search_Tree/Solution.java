/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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
    private TreeNode helper(int[] nums, int begin, int end) {
        if (begin >= end)
            return null;
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, begin, mid);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }
}
