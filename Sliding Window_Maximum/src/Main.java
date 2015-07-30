import java.util.*;

class Solution {
    private void addIndex(int[] nums, int index, List<Integer> queue) {
        while (!queue.isEmpty() && nums[index] > nums[queue.get(queue.size() - 1)])
            queue.remove(queue.size() - 1);
        queue.add(index);
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[] {};
        int[] retValue = new int[nums.length - k + 1];
        int cursor = 0, i;
        List<Integer> queue = new ArrayList<>();
        for (i = 0; i < k - 1; i++)
            addIndex(nums, i, queue);
        for (; i < nums.length; i++) {
            addIndex(nums, i, queue);
            retValue[cursor++] = nums[queue.get(0)];
            if (i - queue.get(0) >= k - 1)
                queue.remove(0);
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

}
