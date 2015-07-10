/**
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

https://leetcode.com/problems/single-number/

My note: I saw this question at career cup 150. and remembered the XOR trick
 */

public class Solution {
    public int singleNumber(int[] nums) {
        int s = 0, i;
        for (i = 0; i < nums.length; i++)
            s ^= nums[i];
        return s;
    }
}
