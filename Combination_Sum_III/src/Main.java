import java.util.*;

class Solution {
    List<List<Integer>> retValue = new ArrayList<>();
    private void helper(int min, int path[], int depth, int sum) {
        if (min > 9 || sum < 1 || sum < min || depth == path.length)
            return;
        if (depth == path.length - 1) {
            if (sum >= min && sum < 10) {
                path[depth] = sum;
                List<Integer> sol = new ArrayList<>();
                for (int i: path)
                    sol.add(i);
                retValue.add(sol);
            }
            return;
        }
        for (int j = min; j < 10; j++) {
            path[depth] = j;
            helper(j + 1, path, depth + 1, sum - j);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] path = new int[k];
        helper(1, path, 0, n);
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 20));
    }

}
