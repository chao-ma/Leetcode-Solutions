import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length==0)
            return;
        int n = matrix.length; // matrix is n * n square matrix
        int i, j, swap;
        for (i = 0; i < n / 2; i++) {
            for (j = i; j < n - i - 1; j++) {
                swap = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] =  matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = swap;                
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 4;
        int[][] matrix = new int[n][n];
        for (int i=0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i;
            }
        }
        Solution solution = new Solution();
        for (int[] x: matrix)
            System.out.println(Arrays.toString(x));
        solution.rotate(matrix);
        System.out.println();
        for (int[] x: matrix)
            System.out.println(Arrays.toString(x));
    }

}
