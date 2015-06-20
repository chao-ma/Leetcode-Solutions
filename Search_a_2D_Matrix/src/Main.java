class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nRow = matrix.length;
        if (nRow == 0)
            return false;
        int nCol = matrix[0].length;
        if (nCol == 0)
            return false;
        int begin = 0, end = nRow * nCol - 1, mid;
        int row, col;
        while (begin <= end) {
            mid = (begin + end) / 2;
            row = mid / nCol;
            col = mid % nCol;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                end = mid - 1;
            else
                begin = mid + 1;
        }
        return false;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = {
                {1,3,4},
                {4,8,9},
                {10,14,15},
                {17,20,22},
        };
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, 20));
    }

}
