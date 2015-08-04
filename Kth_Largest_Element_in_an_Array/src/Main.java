import java.util.*;

class Solution {
    public static class IntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
        
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new IntegerComparator());
        for (int i: nums) {
            if (heap.size() < k)
                heap.add(i);
            else {
                if (i > heap.peek()) {
                    heap.add(i);
                    heap.remove();
                }
            }
        }
        return heap.peek();
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(solution.findKthLargest(nums, 1));
    }

}
