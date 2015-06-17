class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;
        int[][] dp = new int[2][n];
        int i, j;
        for (j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (i = 1; i < m; i++) {
            dp[i % 2][0] = dp[(i + 1) % 2][0];
            for (j = 1; j < n; j++) {
                dp[i % 2][j] = dp[(i + 1) % 2][j] + dp[i % 2][j - 1];
            }
        }
        return dp[(m - 1) % 2][n - 1];
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(2,3));
    }

}
