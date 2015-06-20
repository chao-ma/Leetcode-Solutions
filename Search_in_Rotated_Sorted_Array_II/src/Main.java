class Solution {
    public boolean search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1, mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] > nums[begin]) { // left branch
                if (nums[mid] < target) {
                    begin = mid + 1;
                } else {
                    if (nums[begin] > target) {
                        begin = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            } else if (nums[mid] < nums[begin]) { // right branch
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    if (nums[begin] > target) {
                        begin = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            } else { // unknown
                begin++;
            }
        }
        return false;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {4,6,7,7,8,10,1,2,3,3};
        int target = 11;
        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
    }

}
