/**
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

My note: the trick is to clarify loop invariant. Solution is within [begin, end]
[end + 1, end of array] is sorted. If duplicate exists, the only difference
is to test equal case on testing left/right branch. Just make sure "end" is not a solution, and shrink search space by 1.

 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0)
            return 0;
        int begin = 0, end = nums.length - 2,  mid;
        int pos = -1;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                pos = mid;
                break;
            }
            if (nums[mid] > nums[end + 1]) {
                begin = mid + 1;
            } else if (nums[mid] < nums[end + 1]) {
                end = mid - 1;
            } else {
                if (nums[end] > nums[end + 1]) {
                    pos = end;
                    break;
                } else {
                    end--;
                }
            }
        }
        return nums[pos + 1];
    }
}
