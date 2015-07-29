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

/**
 House Robber II
 Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

https://leetcode.com/problems/house-robber-ii/
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int rob = 0, notrob = 0, max = 0, i, tmp;
        // not rob 0
        for (i = 1; i < nums.length; i++) {
            tmp = rob;
            rob = nums[i] + notrob;
            notrob = Math.max(tmp, notrob);
        }
        max = rob > notrob ? rob : notrob;
        rob = 0; notrob = 0;
        for (i = 2; i < nums.length - 1; i++) {
            tmp = rob;
            rob = nums[i] + notrob;
            notrob = Math.max(tmp, notrob);            
        }
        if (rob + nums[0] > max)
            max = rob + nums[0];
        if (notrob + nums[0] > max)
            max = notrob + nums[0];
        return max;
    }
}
