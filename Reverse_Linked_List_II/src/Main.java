class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode retValue = head;
        ListNode firstSegTail = null, secondSegTail = null;
        ListNode current = null, prev = null, tmp = null;
        for (int i = 1; i < m; i++) {
            if (firstSegTail == null)
                firstSegTail = head;
            else
                firstSegTail = firstSegTail.next;
        }
        if (firstSegTail == null) {
            current = head;
        } else {
            current = firstSegTail.next;
        }
        secondSegTail = current;
        for (int i = m; i <= n; i++) {
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        if (firstSegTail == null) {
            retValue = prev;
            secondSegTail.next = current;
        }
        else {
            firstSegTail.next = prev;
            secondSegTail.next = current;
        }   
        return retValue;
    }
}
 
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        ListNode head = null, tail = null;
        int[] nums = {1};
        for (int i: nums) {
            if (tail == null) {
                head = tail = new ListNode(i);
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
        }
        ListNode res = solution.reverseBetween(head, 1, 1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
