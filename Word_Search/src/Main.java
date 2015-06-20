import java.util.*;

class Solution {
    
    private boolean existHelper(char[][] board, int i, int j,
                                boolean[][] mark, String word, int index) {
        if (index == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || mark[i][j])
            return false;
        if (board[i][j] != word.charAt(index))
            return false;
        boolean retValue = false;
        mark[i][j] = true;
        retValue = retValue || existHelper(board, i + 1, j , mark, word, index + 1);
        retValue = retValue || existHelper(board, i - 1, j , mark, word, index + 1);
        retValue = retValue || existHelper(board, i, j + 1, mark, word, index + 1);
        retValue = retValue || existHelper(board, i, j - 1, mark, word, index + 1);
        mark[i][j] = false;
        return retValue;
    }
    
    public boolean exist(char[][] board, String word) {
        int nRow = board.length;
        if (nRow == 0)
            return false;
        int nCol = board[0].length;
        boolean[][] mark = new boolean[nRow][nCol];
        int i, j;
        boolean retValue = false;
        for (i = 0; i < nRow; i++) {
            for (j = 0; j < nCol; j++) {
                mark[i][j] = false;
            }
        }
        for (i = 0; i < nRow && !retValue; i++) {
            for (j = 0; j < nCol; j++) {
                retValue = retValue || existHelper(board, i, j, mark, word, 0);
            }
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        String word = "ABCESCFSADEEX";
        System.out.println(solution.exist(board, word));
    }

}
