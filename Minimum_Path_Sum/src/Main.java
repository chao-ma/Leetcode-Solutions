import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int nRow = grid.length;
        if (nRow == 0) {
            return 0;
        }
        int nCol = grid[0].length;
        if (nCol == 0) {
            return 0;
        }
        int[][] dp = new int[2][nCol];
        int i, j;
        dp[0][0] = grid[0][0];
        for (j = 1; j < nCol; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (i = 1; i < nRow; i++) {
            dp[i % 2][0] = dp[(i + 1) % 2][0] + grid[i][0];
            for (j = 1; j < nCol; j++) {
                dp[i % 2][j] = Math.min(dp[(i + 1) % 2][j], dp[i % 2][j - 1] ) + grid[i][j];
            }
        }
        return dp[(nRow + 1) % 2][nCol - 1];
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] grid = {
                {1,3,2,2,5},
                {4,3,1,3,4},
                {2,3,1,1,3},
                {1,3,2,2,1},
        };
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(grid));
    }

}
