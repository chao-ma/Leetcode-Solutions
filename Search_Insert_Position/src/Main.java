class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target <= nums[0]) {
            return 0;
        }
        int begin = 1, end = nums.length - 1, mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > target) {
                    if (nums[mid-1] < target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    begin = mid + 1;
                }
            }
        }
        return -1;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, 0));
    }

}
