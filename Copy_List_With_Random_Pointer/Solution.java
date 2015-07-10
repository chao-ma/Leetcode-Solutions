/**
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

https://leetcode.com/problems/copy-list-with-random-pointer/
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode tail = head;
        Map<RandomListNode, RandomListNode> oldNodeToNewNode = new HashMap<>();
        while (tail != null) {
            oldNodeToNewNode.put(tail, new RandomListNode(tail.label));
            tail = tail.next;
        }
        tail = head;
        while (tail != null) {
            if (tail.random != null)
                oldNodeToNewNode.get(tail).random = oldNodeToNewNode.get(tail.random);
            if (tail.next != null)
                oldNodeToNewNode.get(tail).next = oldNodeToNewNode.get(tail.next);
            tail = tail.next;
        }
        return oldNodeToNewNode.get(head);
    }
}
