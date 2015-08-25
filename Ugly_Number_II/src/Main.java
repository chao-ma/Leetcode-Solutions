import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> seq = new ArrayList<>();
        seq.add(1);
        int[] factors = {0, 0, 0};
        int min, idx;
        while (seq.size() < n) {
            min = seq.get(factors[0]) * 2;
            idx = 0;
            if (seq.get(factors[1]) * 3 <  min) {
                min = seq.get(factors[1]) * 3;
                idx = 1;
            }
            if (seq.get(factors[2]) * 5 <  min) {
                min = seq.get(factors[2]) * 5;
                idx = 2;
            }
            if (min > seq.get(seq.size() - 1))
                seq.add(min);
            factors[idx]++;
        }
        System.out.println(seq);
        return seq.get(n - 1);
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(20));
    }

}
