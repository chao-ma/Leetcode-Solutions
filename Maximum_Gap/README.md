Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

https://leetcode.com/problems/maximum-gap/

My note:
I started to think as a DP problem, no clue. Then started divide and conqure, realizing it is
at least O(NlogN). Then it is the same as sorting. It seems sorting is required. Then how about sorting in linear time?
Bucket sort, count sort, radix sort. Then the question itself gives clue, linear time and memory
complexity. So, solution is radix sort.

Here is my implementation of radix sort. Assuming inputs are 32-bit unsigned integers,
bucket size is 16, use 0x0000000f as mask, looping 8 times
space complexity is N + 16
time complexity is O(N)
