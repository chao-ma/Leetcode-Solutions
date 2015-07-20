/**
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

My note: the trick is, to test which branch mid is located at, cannot test
mid with value within [begin, end]. It needs to be outside. So in this solution
mid is compared with end + 1, b/c end + 1 to end of array is always sorted

 */
public class Solution {
    public int findMin(int[] nums) {
        int pos = -1;
        if (nums.length == 0)
            return 0;
        int begin = 0, end = nums.length - 2, mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                pos = mid;
                break;
            }
            if (nums[mid] > nums[end + 1])
                begin = mid + 1;
            else
                end = mid - 1;
        }
        return nums[pos + 1];
    }
}
