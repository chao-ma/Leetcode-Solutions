// Sort a linked list in O(n log n) time using constant space complexity.
// https://leetcode.com/problems/sort-list/

// This is my implementation of merge sort

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode left, right, cursor, retHead = null, retTail = null;
        int counter = 0, i;
        for (cursor = head; cursor != null; cursor = cursor.next, counter++);
        for (i = 1, cursor = head; i < counter / 2; i++, cursor = cursor.next);
        left = head; right = cursor.next; cursor.next = null;
        left = sortList(left);
        right = sortList(right);
        while (left != null && right != null) {
            if (left.val < right.val) {
                cursor = left;
                left = left.next;
            } else {
                cursor = right;
                right = right.next;
            }
            if (retTail == null)
                retHead = retTail = cursor;
            else {
                retTail.next = cursor;
                retTail = cursor;
            }
        }
        retTail.next = left == null ? right : left;
        return retHead;
    }
}
