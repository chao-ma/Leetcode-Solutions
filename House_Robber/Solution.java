/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

https://leetcode.com/problems/house-robber/

fun little DP question
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int prevRob = nums[0], prevNotRob = 0;
        int rob, notRob;
        for (int i = 1; i < nums.length; i++) {
            rob = nums[i] + prevNotRob;
            notRob = Math.max(prevRob, prevNotRob);
            prevRob = rob;
            prevNotRob = notRob;
        }
        return Math.max(prevRob, prevNotRob);
    }
}
