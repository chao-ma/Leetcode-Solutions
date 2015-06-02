import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    
    public static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode arg0, ListNode arg1) {
            // neither arg0 nor arg1 can be null
            if (arg0.val < arg1.val) {
                return -1;
            } else if (arg0.val == arg1.val) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1)
            return null;
        ListNodeComparator comparator = new ListNodeComparator();
        PriorityQueue<ListNode> minheap = new PriorityQueue<ListNode>(lists.length, comparator);
        ListNode retValue = null, tail = null;
        for (ListNode head: lists) {
            if (head != null) {
                minheap.add(head);
            }
        }

        while (!minheap.isEmpty()) {
            ListNode node = minheap.poll();
            if (tail==null) {
                retValue = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            node = node.next;
            if (node != null) {
                minheap.add(node);
            }
        }
        return retValue;
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] inputs = {
                {1,1,2,3},
                {2,4,6,8},
                {},
                {0},
                {10},
                {5,5},
        };
        ListNode[] lists = new ListNode[inputs.length];
        for (int i=0; i < lists.length; i++) {
            ListNode head = null, tail = null;
            for (int j: inputs[i]) {
                if (tail == null) {
                    head = tail = new ListNode(j);
                } else {
                    tail.next = new ListNode(j);
                    tail = tail.next;
                }
            }
            lists[i] = head;
        }
        Solution solution = new Solution();
        ListNode res = solution.mergeKLists(new ListNode[0]);
        while (res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
