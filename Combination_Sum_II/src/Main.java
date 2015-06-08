import java.util.*;

class Solution {

    List<List<Integer>> retValue = new ArrayList<>();
    
    private void combinationSumHelper(int[] candidates, int index, int target, List<Integer> solution) {
        if (target == 0) {
            retValue.add(new ArrayList<Integer>(solution));
            return;
        }
        int i = index;
        while (i < candidates.length && target >= candidates[i]) {
            solution.add(candidates[i]);
            combinationSumHelper(candidates, i + 1, target - candidates[i], solution);
            solution.remove(solution.size() - 1);
            do {
                i++;
            } while (i < candidates.length && candidates[i] == candidates[i-1]);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> solution = new ArrayList<>();
        combinationSumHelper(candidates, 0, target, solution);
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] candidates = {10,1,1,2,7,6,1,5}; int target = 10;
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        for (List<Integer> s: res)
            System.out.println(s);
    }

}
