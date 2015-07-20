/**
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
https://leetcode.com/problems/maximum-product-subarray/

My notes: here is the thoughts,
Dynamic programming, maxPos[i] saves the best product ending at i.
If nums[i] is positive, then maxPos[i] = max(maxPos[i-1]*nums[i], nums[i])
if nums[i] is negative, maxPos[i] = maxNeg[i-1]*nums[i]
use 0 to indicate a max positive or max negative does not exist. The only problem
is 0 may potential go into return value. But an Array of two numbers have at least non-negative solution. So this 0 indicator won't affect results.

*/
public class Solution {
    public int maxProduct(int[] nums) {
        int retValue = nums[0];
        int[] maxPos = new int[nums.length];
        int[] maxNeg = new int[nums.length];
        if (retValue >= 0) {
            maxPos[0] = retValue;
            maxNeg[0] = 0;
        } else {
            maxPos[0] = 0;
            maxNeg[0] = retValue;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxPos[i] = Math.max(maxPos[i - 1] * nums[i], nums[i]);
                maxNeg[i] = maxNeg[i - 1] * nums[i];
            } else {
                maxPos[i] = maxNeg[i - 1] * nums[i];
                maxNeg[i] = Math.min(maxPos[i - 1] * nums[i], nums[i]);
            }
            retValue = Math.max(retValue, maxPos[i]);
        }
        return retValue;
    }
}
