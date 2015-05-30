class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    
    private ListNode retValue = null;
    private ListNode head = null;
    
    private void build(ListNode l) {
        if (head == null) {
            retValue = head = l;
        } else {
            head.next = l;
            head = head.next;
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode smallNode = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                smallNode = l1;
                l1 = l1.next;
            } else {
                smallNode = l2;
                l2 = l2.next;
            }
            build(smallNode);
        }
        smallNode = l1 == null? l2: l1;
        build(smallNode);
        return retValue;
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);
        
        Solution solution = new Solution();
        ListNode merged = solution.mergeTwoLists(l1, l2);
        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
    }

}
