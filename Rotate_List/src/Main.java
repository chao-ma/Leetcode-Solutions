class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode retValue = head;
        ListNode cursor = head, cursor1 = head, cursor2 = head;
        int i = 0;
        int count = 0;
        while (cursor != null) {
            cursor = cursor.next;
            count++;
        }
        if (count <= 1)
            return retValue;
        k = k % count;
        if (k == 0)
            return head;
        while (i < k && cursor2 != null) {
            cursor2 = cursor2.next;
            i++;
        }
        while (cursor2.next != null) {
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
        }
        retValue = cursor1.next;
        cursor1.next = null;
        cursor2.next = head;
        return retValue;
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
        ListNode res = solution.rotateRight(head, 6);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
