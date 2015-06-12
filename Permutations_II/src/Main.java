import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> retValue = new ArrayList<>();
        if (nums.length == 0)
            return retValue;
        List<Integer> solution = new ArrayList<>();
        solution.add(nums[0]);
        retValue.add(solution);
        int i, j, k, count;
        for (i = 1; i < nums.length; i++) {
            count = retValue.size();
            List<List<Integer>> tmp = new ArrayList<>();
            for (j = 0; j < count; j++) {
                List<Integer> prevSolution = retValue.get(j);
                for (k = 0; k <= prevSolution.size(); k++) {
                    if (k == 0 || nums[i] != prevSolution.get(k - 1)) {
                        solution = new ArrayList<Integer>(prevSolution);
                        solution.add(k, nums[i]);
                        tmp.add(solution);
                    } else {
                        break;
                    }
                }
                System.out.println();
            }
            
            retValue = tmp;
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {1,1,0,0,1,-1,-1,1};
        List<List<Integer>> res = solution.permuteUnique(nums);
        String[] s = new String[res.size()];
        for (int i=0; i< res.size();i++) {
            s[i] = res.get(i).toString();
        }
        Arrays.sort(s);
        for (String i: s)
            System.out.println(i);
        System.out.println(s.length);
    }

}
