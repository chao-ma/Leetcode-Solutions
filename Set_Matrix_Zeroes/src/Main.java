import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        int markCol = -1, markRow = -1;
        int i, j;
        for (i = 0; i < matrix.length && markCol < 0; i++) {
            for (j = 0; j < matrix[i].length && markCol < 0; j++) {
                if (matrix[i][j] == 0) {
                    markRow = i;
                    markCol = j;
                }
            }
        }
        if (markCol < 0)
            return;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[markRow][j] = 0;
                    matrix[i][markCol] = 0;
                }
            }
        }
        for (i = 0; i < matrix.length; i++) {
            if (i == markRow)
                continue;
            if (matrix[i][markCol] == 0) {
                for (j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (j = 0; j < matrix[markRow].length; j++) {
            if (j == markCol)
                continue;
            if (matrix[markRow][j] == 0) {
                for (i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (i = 0; i < matrix.length; i++) {
            matrix[i][markCol] = 0;
        }
        for (j = 0; j < matrix[markRow].length; j++) {
            matrix[markRow][j] = 0;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = {{3,2,0},
                          //{1,0,0},
                          //{1,2,1},
                          //{2,2,0}
                        };
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        for(int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}
