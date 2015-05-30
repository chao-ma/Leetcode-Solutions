import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int retValue=0;
        int absDiff = Integer.MAX_VALUE;
        int sum, i=0, j, k;
        Arrays.sort(nums);
        while (i < nums.length - 2) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < absDiff) {
                    absDiff = Math.abs(sum - target);
                    retValue = sum;
                }
                if (sum == target) {
                    return target;
                }
                if (sum < target) {
                    do {
                        j++;
                    } while (j<k && nums[j] == nums[j-1]);
                } else {
                    do {
                        k--;
                    } while (j<k && nums[k] == nums[k+1]);
                }
            }
            do {
                i++;
            } while (i < nums.length && nums[i]==nums[i-1]);
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int nums[] = {-3, -1, -1, 0, 1, 3, 5};
        System.out.println(solution.threeSumClosest(nums, 10));
    }

}
