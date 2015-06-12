class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return true;
        int max = 1;
        for (int i = 0; i < nums.length && i < max; i++) {
            if (nums[i] + i + 1 >= max) {
                max = nums[i] + i + 1;
            }
        }
        return max >= nums.length;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {3,2,1,0,4};
        System.out.println(solution.canJump(nums));
    }

}
