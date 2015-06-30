/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

My note: this is such a fun problem to work on. Yes, definitely could convert
the linklist to array and use convert array to BST solution. It is O(n) in both time and space complexity.
This is in-order traversal algorithm that requires logn stack space complexity and O(n) time complexity.
*/

/**

 * Definition for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) { val = x; }

 * }

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
    private ListNode tail = null;
    private TreeNode helper(int count) {
        if (count == 0)
            return null;
        int mid = count / 2;
        TreeNode left = helper(mid);
        TreeNode root = new TreeNode(tail.val);
        tail = tail.next;
        root.left = left;
        root.right = helper(count - 1 - mid);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        tail = head;
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return helper(count);
    }
}
