import java.util.*;

class Solution {
    
    private int findNextIndex(int currentIndex, int[] nums, int direction) {
        int retValue = currentIndex;
        do {
            retValue += direction;
        } while (retValue < nums.length && retValue >= 0 && nums[retValue]==nums[retValue-direction]);
        return retValue;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> retValue = new ArrayList<>();
        int i, j, k, l, sum;
        Arrays.sort(nums);
        for (i = 0; i < nums.length; i = findNextIndex(i, nums, 1)) {
            for (j = i + 1; j < nums.length; j = findNextIndex(j, nums, 1)) {
                k = j + 1;
                l = nums.length - 1;
                while (k < l) {
                    sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum==target) {
                        List<Integer> solution = new ArrayList<>();
                        solution.add(nums[i]);
                        solution.add(nums[j]);
                        solution.add(nums[k]);
                        solution.add(nums[l]);
                        retValue.add(solution);
                    }
                    if (sum >= target) {
                        l = findNextIndex(l, nums, -1);
                    }
                    if (sum <= target) {
                        k = findNextIndex(k, nums, 1);
                    }
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
        int[] nums = {1,1, 0,0,0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> res = solution.fourSum(nums, target);
        for (List<Integer> i: res) {
            for (Integer j: i) {
                System.out.print(j);System.out.print(",");
            }
            System.out.println();
        }
    }

}
