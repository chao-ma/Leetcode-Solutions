class Solution {
    public int search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1, mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Need to consider 3 variables, M nums[mid], T target and B nums[begin]
            // 1 means the first sorted array, 2 means the second
            // a) M > T >= B, M is on 1, and T is on 1, left
            // b) M >= B > T, M is on 1, and T is on 2, right
            // c) B > M > T, M is on 2, T is on 2, left
            // d) T > M > B, M is on 1, T is on 1, right
            // e) T >= B > M, M is on 2, T is on 1, left
            // f) B > T > M, M is on 2, T is on 2, right
            if (nums[mid] > target) {
                if (nums[begin] > target && nums[mid] >= nums[begin]) { //case b
                    begin = mid + 1;
                } else {                    //case a,c
                    end = mid - 1;
                }
            } else {
                if (nums[mid] < nums[begin] && target >= nums[begin]) { // case e
                    end = mid - 1;
                } else { // case d,f
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
        Solution solution = new Solution();
        int[] nums = {5,1,2,3,4};
        //for (int i=0;i<10;i++)
            System.out.println(solution.search(nums, 1));
    }

}
