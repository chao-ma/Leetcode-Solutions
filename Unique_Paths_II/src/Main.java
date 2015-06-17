import java.util.Arrays;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int nRow = obstacleGrid.length;
        if (nRow == 0)
            return 0;
        int nCol = obstacleGrid[0].length;
        if (nCol == 0)
            return 0;
        int[][] dp = new int[2][nCol];
        int i, j;
        if (obstacleGrid[0][0] == 0)
            dp[0][0] = 1;
        else
            return 0;
        for (j = 1; j < nCol; j++) {
            dp[0][j] = obstacleGrid[0][j - 1] == 0 ? dp[0][j - 1] : 0;
        }
        System.out.println(Arrays.toString(dp[0]));
        for (i = 1; i < nRow; i++) {
            dp[i % 2][0] = obstacleGrid[i - 1][0] == 0 ? dp[(i - 1) % 2][0] : 0;
            for (j = 1; j < nCol; j++) {
                dp[i % 2][j] = (obstacleGrid[i - 1][j] == 0 ? dp[(i - 1) % 2][j] : 0) +
                               (obstacleGrid[i][j - 1] == 0 ? dp[i % 2][j - 1] : 0);
            }
            System.out.println(Arrays.toString(dp[i%2]));
        }
        return dp[(nRow - 1) % 2][nCol - 1];
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] obstacleGrid = {{0,0,0},{0,1,0}, {0,1,0}};
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }

}
