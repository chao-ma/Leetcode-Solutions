import java.util.*;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int retValue = 0;
        if (matrix.length == 0)
            return 0;
        if (matrix[0].length == 0)
            return 0;
        int[] heights = new int[matrix[0].length];
        int[] dp = new int[heights.length];
        int[] lastRow = new int[dp.length];
        int[] swap;
        int i, j, length, edge;
        for (i = 0; i < matrix.length; i++) {
            length = dp[0] = matrix[i][0] - '0';
            retValue = Math.max(retValue, dp[0]);
            for (j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                    length = 0;
                }
                else {
                    heights[j]++;
                    length++;
                }
                edge = Math.min(heights[j], length);
                edge = Math.min(edge, lastRow[j - 1] + 1);
                retValue = Math.max(retValue, edge * edge);
                dp[j] = edge;
            }
            swap = dp;
            dp = lastRow;
            lastRow = swap;
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] raw = {"10100",
                        "10111",
                        "11111",
                        "11111",
                       };

        char[][] matrix = new char[raw.length][];
        for (int i = 0; i < raw.length; i++)
            matrix[i] = raw[i].toCharArray();
        Solution solution = new Solution();
        System.out.println(solution.maximalSquare(matrix));
    }
}
