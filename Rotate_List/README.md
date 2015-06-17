Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

https://leetcode.com/problems/rotate-list/

My note: use circular linked list is another way to solve this. simply tail -> head, then move len(list) - k % len(list) steps
