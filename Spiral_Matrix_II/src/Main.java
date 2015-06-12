import java.util.Arrays;

class Solution {
    
    private void generateMatrixHelper(int[][] matrix, int index, int num) {
        if (index == matrix.length / 2) {
            if (matrix.length % 2 == 1) {
                matrix[index][index] = num;
            }
            return;
        }
        int i, j;
        for (i = index; i < matrix.length - index; i++) {
            matrix[index][i] = num++;
        }
        for (i = index + 1; i < matrix.length - index - 1; i ++) {
            matrix[i][matrix.length - index - 1] = num++;
        }
        for (i = matrix.length - index - 1; i >= index; i--) {
            matrix[matrix.length - index - 1][i] = num++;
        }
        for (i = matrix.length - index - 2; i > index; i--) {
            matrix[i][index] = num++;
        }
        generateMatrixHelper(matrix, index+1, num);
    }
    
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        generateMatrixHelper(matrix, 0, 1);
        return matrix;
    }
}


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[][] matrix = solution.generateMatrix(6);
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}
