Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

https://leetcode.com/problems/product-of-array-except-self/

```java
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0)
            return nums;
        int[] dp = new int[nums.length];
        dp[dp.length - 1] = 1;
        int i;
        for (i = nums.length - 2; i >= 0; i--)
            dp[i] = dp[i + 1] * nums[i + 1];
        int agg = 1;
        for (i = 0; i < dp.length; i++) {
            dp[i] = dp[i] * agg;
            agg *= nums[i];
        }
        return dp;
    }
}
```
