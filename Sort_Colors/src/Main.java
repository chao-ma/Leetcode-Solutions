import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1, k = 0, swap;
        while (k <= j) {
            switch (nums[k]) {
            case 0:
                swap = nums[i];
                nums[i] = nums[k];
                nums[k] = swap;
                i++;
                k++;
                break;
            case 2:
                swap = nums[j];
                nums[j] = nums[k];
                nums[k] = swap;
                j--;
                break;
            default:
                k++;
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {0,1,2,0,1,2,0,2,1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        // Collections.reverseOrder();
    }

}
