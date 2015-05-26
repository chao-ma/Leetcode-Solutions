
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        int add = 0;
        ListNode retValue = null;
        ListNode resCursor = null;
        int value1 = 0;
        int value2 = 0;
        int digitSum;
        while (cursor1 != null || cursor2 != null) {
        	if (cursor1 != null) {
        		value1 = cursor1.val;
        		cursor1 = cursor1.next;
        	} else {
        		value1 = 0;
        	}
        	if (cursor2 != null) {
        		value2 = cursor2.val;
        		cursor2 = cursor2.next;
        	} else {
        		value2 = 0;
        	}
        	digitSum = value1 + value2 + add;
        	add = digitSum / 10;
        	digitSum = digitSum % 10;
        	if (resCursor == null) {
        		retValue = resCursor = new ListNode(digitSum);
        	} else {
        		resCursor.next = new ListNode(digitSum);
        		resCursor = resCursor.next;
        	}
        }
        if (add > 0) {
        	resCursor.next = new ListNode(add);
        }
        
        return retValue;
    }
}

public class Main {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(8);
		
		Solution solution = new Solution();
		ListNode res = solution.addTwoNumbers(l1, l2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
