class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tail = head;
        if (head == null)
            return null;
        ListNode cursor = head.next;
        tail.next = null;
        while (cursor != null) {
            if (tail.val != cursor.val) {
                tail.next = cursor;
                tail = cursor;
                cursor = cursor.next;
                tail.next = null;
            } else {
                cursor = cursor.next;
            }
        }
        return head;
    }
}
 
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        Solution solution= new Solution();
        ListNode res = solution.deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
