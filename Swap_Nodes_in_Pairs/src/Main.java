
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    
    int K = 2;
    
    public ListNode swapPairs(ListNode head) {
        ListNode retValue = null, tail = null;
        ListNode cursorHead = head, cursorTail = head;
        ListNode tmpNode;
        int i;
        ListNode[] nodes = new ListNode[K];
        while (cursorHead != null) {
            for (i = 0; i < K && cursorTail != null; i++) {
                nodes[i] = cursorTail;
                cursorTail = cursorTail.next;
            }
            if (i == K) { // enough points to reverse
                for (i = K-1; i>0; i--) {
                    nodes[i].next = nodes[i-1];
                }
                nodes[0].next = null;
                if (retValue==null) {
                    retValue = nodes[K-1];
                    tail = nodes[0];
                } else {
                    tail.next = nodes[K-1];
                    tail = nodes[0];
                }
            } else { // partial list to reverse
                if (retValue==null) {
                    retValue = nodes[0];
                } else {
                    tail.next = nodes[0];
                }
            }
            cursorHead = cursorTail;
        }
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
        //head.next.next.next.next.next = new ListNode(6);
        Solution solution = new Solution();
        ListNode res = solution.swapPairs(head.next.next);
        while(res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
