class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] dp = new boolean[2][s2.length() + 1];
        dp[0][0] = true;
        int i, j;
        for (j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (i = 1; i <= s1.length(); i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (j = 1; j <= s2.length(); j++) {
                dp[i % 2][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[(i - 1) % 2][j] ||
                               s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i % 2][j - 1];
            }
        }
        
        return dp[s1.length() % 2][s2.length()];
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

}
