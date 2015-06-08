import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] retValue = {-1, -1};
        int begin = 0, end = nums.length - 1, mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
                    retValue[0] = mid;
                    break;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        if (retValue[0] >= 0) {
            begin = retValue[0];
            end = nums.length - 1;
            while (begin <= end) {
                mid = (begin + end) / 2;
                if (nums[mid] == target) {
                    if (mid == nums.length - 1 || nums[mid+1] > nums[mid]) {
                        retValue[1] = mid;
                        break;
                    } else {
                        begin = mid + 1;
                    }
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
        }
        return retValue;
    }
}


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {1,1,2,2,2,3,4,5,6,6};
        System.out.println(Arrays.toString(solution.searchRange(nums, 1)));
    }

}
