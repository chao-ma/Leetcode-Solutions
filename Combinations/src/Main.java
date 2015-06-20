import java.util.*;

class Solution {
    
    List<List<Integer>> retValue = new ArrayList<>();
    
    private void combineHelper(Integer[] helper, int start, int end, int level) {
        if (level == helper.length) {
            List<Integer> solution = new ArrayList<>();
            for (Integer j: helper)
                solution.add(j);
            retValue.add(solution);
            return;
        }
        for (int i = start; i <= end - (helper.length - 1 - level); i++) {
            helper[level] = i;
            combineHelper(helper, i + 1, end, level + 1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        if (k > 0 && n >= k) {
            Integer[] helper = new Integer[k];
            combineHelper(helper, 1, n, 0);
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combine(6, 3);
        for (List<Integer> row: res) {
            System.out.println(row);
        }
    }

}
