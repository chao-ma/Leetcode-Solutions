class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode retValue = null, tail = null;
        ListNode cursor = head;
        while (cursor != null) {
            if (cursor.next == null || cursor.val != cursor.next.val) {
                if (tail == null) {
                    retValue = tail = cursor;
                } else {
                    tail.next = cursor;
                    tail = tail.next;
                }
                cursor = cursor.next;
            } else {
                ListNode tmp = cursor.next;
                while (tmp != null && tmp.val == cursor.val) {
                    tmp = tmp.next;
                }
                cursor = tmp;
            }
        }
        if (tail != null)
            tail.next = null;
        return retValue;
    }
}
 
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {1,1,2,2,3,4,4,4,5,5,5,6};
        ListNode head = null, tail = null;
        for (int i: nums) {
            if (tail == null) {
                head = tail = new ListNode(i);
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
        }
        ListNode res = solution.deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
