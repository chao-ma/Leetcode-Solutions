class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    
    // [[first_head, first_tail], [second_head, seocnd_tail]]
    private ListNode[][] buff = new ListNode[2][2];
    private int HEAD = 0;
    private int TAIL = 1;
    
    private void build(int index, ListNode node) {
        if (buff[index][TAIL] == null) {
            buff[index][HEAD] = buff[index][TAIL] = node;
        } else {
            buff[index][TAIL].next = node;
            buff[index][TAIL] = node;
        }
    }
    
    public ListNode partition(ListNode head, int x) {
        while (head != null) {
            if (head.val < x)
                build(0, head);
            else
                build(1, head);
            head = head.next;
        }
        if (buff[0][HEAD] == null)
            return buff[1][HEAD];
        else if (buff[1][HEAD] == null)
            return buff[0][HEAD];
        else {
            buff[0][TAIL].next = buff[1][HEAD];
            buff[1][TAIL].next = null;
            return buff[0][HEAD];
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {3,5,4,1,2};
        ListNode head = null, tail = null;
        for (int i: nums) {
            if (tail == null) {
                head = tail = new ListNode(i);
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
        }
        ListNode res = solution.partition(head, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

}
