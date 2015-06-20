import java.util.*;

class Solution {

    List<List<Integer>> retValue = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<Integer> solution = new ArrayList<>();
        retValue.add(solution);
        for (int i: nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> j: retValue) {
                tmp.add(new ArrayList<Integer>(j));
            }
            for (List<Integer> j: tmp) {
                j.add(i);
            }
            retValue.addAll(tmp);
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = solution.subsets(nums);
        for (List<Integer> i: res) {
            System.out.println(i);
        }
    }

}
