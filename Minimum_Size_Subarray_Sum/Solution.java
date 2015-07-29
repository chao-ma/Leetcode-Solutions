/**
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

https://leetcode.com/problems/minimum-size-subarray-sum/
nlogn solution would be loop over n plus binary search
*/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int retValue = 0;
        int sum = 0, begin = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                if (retValue == 0 || retValue > i + 1 - begin)
                    retValue = i + 1 - begin;
                sum -= nums[begin++];
            }
        }
        return retValue;
    }
}
