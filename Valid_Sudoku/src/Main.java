
class Solution {
    
    boolean[] flag = new boolean[9];
    
    private void clear() {
        for (int i = 0; i < 9; i++) {
            flag[i] = false;
        }
    }
    public boolean isValidSudoku(char[][] board) {
        int i, j, k;
        for (i = 0; i < 9; i++) {
            clear();
            for (j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (flag[board[i][j] - '1'])
                    return false;
                flag[board[i][j] - '1'] = true;
            }
            clear();
            for (j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                if (flag[board[j][i] - '1'])
                    return false;
                flag[board[j][i] - '1'] = true;
            }
        }
        for (i = 0; i < 9; i += 3) {
            for (j = 0; j < 9; j += 3) {
                clear();
                for (k = 0; k < 9; k++) {
                    if (board[i+k/3][j+k%3] == '.')
                        continue;
                    if (flag[board[i+k/3][j+k%3] - '1'])
                        return false;
                    flag[board[i+k/3][j+k%3] - '1'] = true;
                }
            }
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] board = {
                {'5','3','.',   '.','7','.',   '.','.','.'},
                {'6','.','.',   '1','9','5',   '.','.','.'},
                {'.','9','8',   '.','.','.',   '.','6','.'},

                {'8','.','.',   '.','6','.',   '.','.','3'},
                {'4','.','.',   '8','.','3',   '.','.','1'},
                {'7','.','.',   '.','2','.',   '.','.','6'},

                {'.','6','.',   '.','.','.',   '2','8','.'},
                {'.','.','.',   '4','1','9',   '.','.','5'},
                {'.','.','.',   '.','8','.',   '.','7','9'},
        };
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(board));
    }

}
