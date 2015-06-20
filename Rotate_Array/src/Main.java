import java.util.Arrays;

// [1,2,3,4,5] k = 2
// [4,5,3,1,2]

// [1,2,3,4,5] k = 3
// [3,4,1,2,5]


class Solution {
    /*
     * start is inclusive, end is exclusive
     */
    private void rotateHelper(int[] nums, int start, int end, int k) {
        if (start >= end)
            return;
        k = k % (end - start);
        if (k == 0)
            return;
        int remaining = end - start - k, i, tmp;
        for (i = 0; i < Math.min(k, remaining); i++) {
            tmp = nums[start + i];
            nums[start + i] = nums[end - k + i];
            nums[end - k + i] = tmp;
        }
        if (remaining >= k ) {
            rotateHelper(nums, start + k, end, k);
        } else {
            rotateHelper(nums, start + remaining, end, k - remaining);
        }
    }
    
    public void rotate(int[] nums, int k) {
        rotateHelper(nums, 0, nums.length, k);
    }
}


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1};
        int k = 7;
        Solution solution = new Solution();
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

}
