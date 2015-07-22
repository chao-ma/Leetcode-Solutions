/**
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.

https://leetcode.com/problems/find-peak-element/

My note: this is such a fun problem. Here is the thought:
There must be a peak if num[-1] = -infinite num[n] = -infinite
Othersie the array must be ascendingly sorted to avoid peak forward, and be descendinly sorted backward
Then all values must be equal, which is contradictory of num[n] != num[n - 1]
So there must be a peak.

We want to find a case like:

   mid
    .
.       .
and return mid. otherwise

  case 1        case 2           case 3
   mid            mid             mid
        .      .              .        .
    .              .            
.                      .           .
for case 1 and 2, there must be a solution and the ascending site, i.e. on the right for case 1
and on the left on case 2. The proof is similar to what have been argued.
(e.g. if there is no peak on the right of mid for case 1, value must be sorted ascendingly forward
and must be sorted descendingly backward. Then there must be a peak)
And for case 3, either side is ok as on the left, it is sorted descendingly and on the right it is sorted ascendingly

Here is my solution: start with handling edge cases, then binary search O(logN)
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;
        int begin = 1, end = nums.length - 2, mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])
                return mid;
            if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1])
                end = mid - 1;
            else
                begin = mid + 1;
        }
        return -1;
    }
}
