Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

https://leetcode.com/problems/palindrome-linked-list/

For the follow up, it can if it is double linked list. O/w I don't see a solution

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> l = new ArrayList<>();
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }
        int i = 0, j = l.size() - 1;
        while (i < j) {
            if (!l.get(i).equals(l.get(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
```
