import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retValue = new ArrayList<>();
        retValue.add(new ArrayList<Integer>());
        int i, j = 0, k;
        Arrays.sort(nums);
        for (i = 0; i < nums.length; i = j) {
            for (j = i + 1; j < nums.length && nums[j] == nums[i]; j++);
            List<List<Integer>> tmp = new ArrayList<>();
            List<Integer> seq = new ArrayList<>();
            for (k = i; k < j; k++) {
                seq.add(nums[k]);
                tmp.add(new ArrayList<Integer>(seq));
            }
            int total = retValue.size();
            for (k = 0; k < total; k++) {
                for (List<Integer> v: tmp) {
                    seq = new ArrayList<Integer>(retValue.get(k));
                    seq.addAll(v);
                    retValue.add(seq);
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
        int[] nums = {3,2,2,1};
        List<List<Integer>> res = solution.subsetsWithDup(nums);
        for (List<Integer> i: res)
            System.out.println(i);
    }

}
