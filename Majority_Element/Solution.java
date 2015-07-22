/**
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

https://leetcode.com/problems/majority-element/

My note: later I learnt Moore's voting algorithm. My solution is not optimal but original
It is constant space and linear time

The idea is to let non-equal elements cancel each other, then the left ones are the majority.
treat it as a binary tree

             X
           /    \   (Solution)
  X       2      3      3
 / \     / \    / \    / \
1   3   2   2  3   3  3   3

Each iteration climbs up tree by 1 level. If the number of nodes is odd, then the first one
is "pushed into stack". If no high level nodes exist, the top of stack value represents the most
common elements and is the return value.
In other words, it is to find the tallest subtrees in which all values are the same.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int start = 0, end = nums.length, i, index;
        while (start < end) {
            if ((end - start) % 2 == 1)
                start++;
            for (index = i = start; i < end; i += 2)
                if (nums[i] == nums[i + 1])
                    nums[index++] = nums[i];
            end = index;
        }
        return nums[start - 1];
    }
}
