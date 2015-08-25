Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

https://leetcode.com/problems/single-number-iii/

Using ^ operator, C = A ^ B where A and B are unique numbers.
Find a bit in C that A and B are different, and split the array in this way,
And run ^ again to get the result.
