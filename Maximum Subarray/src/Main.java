class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int i;
        for (i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
        }
        int retValue = dp[0];
        for (i = 1; i < nums.length; i++) {
            retValue = Math.max(retValue, dp[i]);
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }

}
