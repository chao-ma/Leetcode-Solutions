import java.util.Arrays;

class Solution {
    public int numDistinct(String s, String t) {
        if (t.length() > s.length())
            return 0;
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        int i, j;
        for (i = 0; i < s.length(); i++) {
            for (j = t.length() - 1; j >= 0; j--) {
                if (t.charAt(j) == s.charAt(i)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }
}


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.numDistinct("abcdccbc", "acc"));
    }

}
