import java.util.*;

class Solution {
    
    List<List<Integer>> retValue = new ArrayList<>();
    
    private void combinationSumHelper(int[] candidates, int index, int target, List<Integer> solution) {
        if (target == 0) { // a solution is found
            retValue.add(new ArrayList<>(solution)); // make a copy of it
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                solution.add(candidates[i]);
                combinationSumHelper(candidates, i, target - candidates[i], solution);
                solution.remove(solution.size() - 1);
            } else {
                break;
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> solution = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0, target, solution);
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] candidates = {2,3,6,7}; int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        for (List<Integer> s: res) {
            System.out.println(s);
        }
    }

}
