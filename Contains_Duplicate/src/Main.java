import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> bst = new TreeSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i: nums) {
            Integer ceiling = bst.ceiling(i);
            if (ceiling != null && ceiling - i <= t) {
                return true;
            }
            Integer floor = bst.floor(i);
            if (floor != null && i - floor <= t) {
                return true;
            }
            bst.add(i);
            queue.add(i);
            if (queue.size() > k) {
                Integer head = queue.remove(0);
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
