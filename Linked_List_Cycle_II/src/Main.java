class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        ListNode meetNode = null;
        while (fastNode != null && meetNode == null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode != null)
                fastNode = fastNode.next;
            if (fastNode == slowNode)
                meetNode = slowNode;
        }
        if (meetNode != null) {
            slowNode = head;
            meetNode = meetNode.next;
            while(meetNode != slowNode) {
                meetNode = meetNode.next;
                slowNode = slowNode.next;
            }
        }
        return meetNode;
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(solution.detectCycle(head).val);
    }

}
