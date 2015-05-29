import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retValue = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j, k;
        int target;
        int sum;
        while (i < nums.length) {
            target = -nums[i];
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                sum = nums[j] + nums[k];
                if (sum == target) {
                    List<Integer> solution = new ArrayList<>();
                    solution.add(nums[i]);
                    solution.add(nums[j]);
                    solution.add(nums[k]);
                    retValue.add(solution);
                }
                if (sum >= target) {
                    do {
                        k--;
                    } while (k > j && nums[k] == nums[k+1]);
                }
                if (sum <= target) {
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j-1]);
                }
            }
            do {
                i++;
            } while (i < nums.length && nums[i] == nums[i-1]);
                
        }
        return retValue;
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(nums);
        System.out.println("solutions");
        for (List<Integer> i: res) {
            for (Integer j: i) {
                System.out.print(j);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

}
