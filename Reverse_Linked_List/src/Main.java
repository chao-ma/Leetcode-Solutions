class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode tmp;
        while (current != null) {
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
