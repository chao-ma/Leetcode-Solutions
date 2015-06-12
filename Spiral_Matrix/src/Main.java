import java.util.*;

class Solution {
    
    private void spiralOrderHelper(int index, int width, int height, int[][] matrix, List<Integer> s) {
        int i;
        if (width == 0 || height == 0) {
            return;
        }
        if (width == 1) {
            for (i = 0; i < height; i++) {
                s.add(matrix[index+i][index]);
            }
        } else if (height == 1) {
            for (i = 0; i < width; i++) {
                s.add(matrix[index][index+i]);
            }
        } else {
            for (i = 0; i < width - 1; i++) {
                s.add(matrix[index][index + i]);
            }
            for (i = 0; i < height - 1; i++) {
                s.add(matrix[index+i][index + width - 1]);
            }
            for (i = width - 1; i > 0; i--) {
                s.add(matrix[index + height - 1][index + i]);
            }
            for (i = height - 1; i > 0; i--) {
                s.add(matrix[index + i][index]);
            }
            spiralOrderHelper(index + 1, width - 2, height - 2, matrix, s);
        }
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> retValue = new ArrayList<>();
        int nRow = matrix.length;
        if (nRow==0) {
            return retValue;
        }
        int nCol = matrix[0].length;
        spiralOrderHelper(0, nCol, nRow, matrix, retValue);
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = {{1,2,3,4,10},
                          {4,5,6,5,11},
                          {4,5,6,5,11},
                          {7,8,9,6,12},
        };
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(matrix));
    }

}
