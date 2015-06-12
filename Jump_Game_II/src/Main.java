import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] steps = new int[nums.length];
        int i, j;
        int  max = 1;
        for (i = 0; i < nums.length; i++) {
            for (j = max; j - i <= nums[i] && j < nums.length; j++) {
                steps[j] = steps[i] + 1;
            }
            max = j;
        }
        return steps[nums.length - 1];
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {5,4,3,2,1,1,1};
        Solution solution = new Solution();
        System.out.println(solution.jump(nums));
    }

}
