import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> bst = new TreeSet<>();
        LinkedList<Long> queue = new LinkedList<>();
        long gap = t;
        for (int i: nums) {
            long val = i;
            Long ceiling = bst.ceiling(val);
            if (ceiling != null && ceiling - val <= gap) {
                return true;
            }
            Long floor = bst.floor(val);
            if (floor != null && val - floor <= gap) {
                return true;
            }
            bst.add(val);
            queue.add(val);
            if (queue.size() > k) {
                Long head = queue.remove(0);
                bst.remove(head);
            }
        }
        return false;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {1,4,7,2,0,9,0};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, 3, 1));
    }

}
