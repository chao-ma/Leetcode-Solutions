class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return head;
        // Given n is always valid, two pointer solution
        ListNode cursorHead = head;
        ListNode cursorTail = head;
        for (int i = 0; i < n; i++) {
            cursorTail = cursorTail.next;
        }
        if (cursorTail == null) {
            return head.next;
        }
        while (cursorTail.next != null) {
            cursorHead = cursorHead.next;
            cursorTail = cursorTail.next;
        }
        cursorHead.next = cursorHead.next.next;
        return head;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode res = solution.removeNthFromEnd(head, 1);
        while (res != null) {
            System.out.print(res.val); System.out.print("->");
            res = res.next;
        }
    }

}
