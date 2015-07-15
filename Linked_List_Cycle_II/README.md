Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?

https://leetcode.com/problems/linked-list-cycle-ii/

My note:
pay attention, for the meetNode, it correspond to a pseudo-node 'root', which
root.next = head. So neet to move meetNode to next, then move together with head until they meet.
