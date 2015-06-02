class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode retValue = null, tail = null;
        ListNode cursorHead = head, cursorTail = head;
        ListNode rev, cur, next;
        int i, j;
        while (cursorHead != null) {
            for (i = 0; i < k && cursorTail != null; i++) {
                cursorTail = cursorTail.next;
            }
            if (i == k) { // enough points to reverse
                rev = null;
                cur = cursorHead;
                for (i = 0; i < k; i++) {
                    next = cur.next;
                    cur.next = rev;
                    rev = cur;
                    cur = next;
                }
            } else { // partial list to reverse
                rev = cursorHead;
            }
            if (retValue == null) {
                retValue = tail = rev;
            } else {
                tail.next = rev;
            }
            while (tail != null && tail.next!=null) {
                tail = tail.next;
            }
            cursorHead = cursorTail;
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        Solution solution = new Solution();
        ListNode res = solution.reverseKGroup(head,7);
        while(res!=null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

}
