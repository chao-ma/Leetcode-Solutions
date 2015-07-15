// Sort a linked list using insertion sort.
// https://leetcode.com/problems/insertion-sort-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode retHead = null, tail = null, cursor = head, tmp, node;
        while (cursor != null) {
            tmp = cursor.next;
            cursor.next = null;
            if (tail == null) {
                retHead = tail = cursor;
            } else if (cursor.val <= retHead.val) {
                cursor.next = retHead;
                retHead = cursor;
            } else {
                for (node = retHead; node.next != null && cursor.val > node.next.val; node = node.next);
                cursor.next = node.next;
                node.next = cursor;
            }
            cursor = tmp;
        }
        return retHead;
    }
}
