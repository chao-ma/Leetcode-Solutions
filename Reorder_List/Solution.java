/**
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

https://leetcode.com/problems/reorder-list/
 */

//Constant memory solution
//O(N-square) time complexity
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        ListNode newHead = null, newTail = null, tail = head, chunk;
        ListNode cursor, prev;
        while (tail != null) {
            if (tail == null || tail.next == null || tail.next.next == null) {
                chunk = tail;
                tail = null;
            } else {
                prev = tail;
                cursor = tail.next;
                while (cursor.next != null) {
                    prev = prev.next;
                    cursor = cursor.next;
                }
                chunk = tail;
                tail = tail.next;
                chunk.next = cursor;
                prev.next = null;
            }
            if (newTail == null)
                newHead = newTail = chunk;
            else
                newTail.next = chunk;
            while (newTail.next != null)
                newTail = newTail.next;
        }
    }
}

//O(N) space complexity, O(N) time complexity
public class Solution {
    public void reorderList(ListNode head) {
        ListNode cursor = head;
        List<ListNode> buffer = new ArrayList<>();
        while (cursor != null) {
            buffer.add(cursor);
            cursor = cursor.next;
        }
        int i = 0, j = buffer.size() - 1;
        cursor = null;
        while (i < j) {
            buffer.get(i).next = buffer.get(j);
            buffer.get(j).next = null;
            if (cursor != null)
                cursor.next = buffer.get(i);
            cursor = buffer.get(j);
            i++;
            j--;
        }
        if (i == j && cursor != null) {
            cursor.next = buffer.get(i);
            cursor.next.next = null;
        }
    }
}
