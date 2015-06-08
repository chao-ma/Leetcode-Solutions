class Solution {
    public int firstMissingPositive(int[] nums) {
        int i, swap, tmp;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                swap = nums[i];
                nums[i] = -1;
            } else {
                continue;
            }
            while (swap > 0 && swap <= nums.length && nums[swap - 1] != swap) {
                tmp = nums[swap - 1];
                nums[swap - 1] = swap;
                swap = tmp;
            }
        }
        for (i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != i)
                break;
        }
        return i;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //int[] nums = {0,1,2};
        int[] nums = {0,-2,2};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(nums));
    }

}
