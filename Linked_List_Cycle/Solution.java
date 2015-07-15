/**
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
https://leetcode.com/problems/linked-list-cycle/
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (fastNode != null) {
            fastNode = fastNode.next;
            if (fastNode != null)
                fastNode = fastNode.next;
            slowNode = slowNode.next;
            if (slowNode == fastNode)
                return true;
        }
        return false;
    }
}
