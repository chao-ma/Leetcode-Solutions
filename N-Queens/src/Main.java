import java.util.*;

class Solution {

    List<String[]> retValue = new ArrayList<>();
    
    private void solveNQueensHelper(int index, int n, int[] solution) {
        int i, j;
        if (index == n) {
            char[] row = new char[n];
            String[] board = new String[n];
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j ++) {
                    row[j] = '.';
                }
                row[solution[i]] = 'Q';
                board[i] = String.copyValueOf(row);
            }
            retValue.add(board);
            return;
        }
        boolean collision = false;
        for (i = 0; i < n; i++) {
            collision = false;
            for (j = 0; j < index && !collision; j++) {
                if (solution[j] == i || index - j == solution[j] - i ||
                        index - j == i -solution[j]) {
                    collision = true;
                }
            }
            if (!collision) {
                solution[index] = i;
                solveNQueensHelper(index + 1, n, solution);
            }
        }
    }
    
    public List<String[]> solveNQueens(int n) {
        int[] solution = new int[n];
        solveNQueensHelper(0, n, solution);
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        List<String[]> res = solution.solveNQueens(8);
        
        for (String[] s: res) {
            for (String i: s) {
                System.out.println(i);
            }
            System.out.println();
        }
        System.out.println(res.size());
    }

}
