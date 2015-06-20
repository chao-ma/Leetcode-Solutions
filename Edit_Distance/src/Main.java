class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[2][word2.length() + 1];
        int i, j;
        for (j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (i = 1; i <= word1.length(); i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + 1;
            for (j = 1; j <= word2.length(); j++) {
                dp[i % 2][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ?
                        dp[(i - 1) % 2][j - 1]: dp[(i - 1) % 2][j - 1] + 1;
                dp[i % 2][j] = Math.min(dp[i % 2][j], dp[(i - 1) % 2][j] + 1);
                dp[i % 2][j] = Math.min(dp[i % 2][j], dp[i % 2][j - 1] + 1);
            }
        }
        return dp[word1.length() % 2][word2.length()];
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        String word1 = "acc", word2 = "aaaaacc";
        System.out.println(solution.minDistance(word1, word2));
    }

}
