import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i, j;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        for (j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                break;
            }
        }
        Arrays.sort(nums, i + 1, nums.length);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1,2,3};
        Solution solution = new Solution();
        for (int i=0;i<10;i++) {
            solution.nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }

}
