import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retValue = new ArrayList<>();
        List<Integer> solution;
        if (nums.length == 0)
            return retValue;
        solution = new ArrayList<Integer>();
        solution.add(nums[0]);
        retValue.add(solution);
        int count = 1, j, k;
        for (int i = 1; i < nums.length; i++) {
            count = retValue.size();
            for (j = 0; j < count; j++) {
                List<Integer> prevSolution = retValue.remove(0);
                for (k = 0; k <= prevSolution.size(); k++) {
                    solution = new ArrayList<>(prevSolution);
                    solution.add(k, nums[i]);
                    retValue.add(solution);
                }
            }
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permute(nums);
        for(List<Integer> s: res)
            System.out.println(s);
    }

}
