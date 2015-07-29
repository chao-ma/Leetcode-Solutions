/**
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

https://leetcode.com/problems/remove-linked-list-elements/
*/
/**

 * Definition for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) { val = x; }

 * }

 */

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode retHead = null, tail = null, cursor = head, tmp;
        while (cursor != null) {
            tmp = cursor.next;
            if (cursor.val != val) {
                if (tail == null) {
                    retHead = tail = cursor;
                } else {
                    tail.next = cursor;
                    tail = tail.next;
                }
                tail.next = null;
            }
            cursor = tmp;
        }
        return retHead;
    }
}
