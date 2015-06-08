import java.util.Arrays;

class Solution {
    // define 27 constraints. Each constrain contains 9 2-elem array
    private int[][][] constraints = new int[27][9][2];
    // what choices a coordinate has, if not, who took it; choices[i][j][4] = -1 means
    // i,j can have '4'. if choices[i][j][4]=3 means function at stack 3 filled. it is function
    // 3's responsibility to remove it if rolls back
    private int[][][] choices = new int[9][9][9];
    private char[][] _board = new char[9][9]; // internal board
    
    private void populateConstraints() {
        int i, j, k;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                // row constraints
                constraints[i][j][0] = i;
                constraints[i][j][1] = j;
                // col constraints
                constraints[9 + j][i][0] = i;
                constraints[9 + j][i][1] = j;
                // block constraints
                constraints[18 + i/3*3 + j/3][i%3*3+j%3][0] = i;
                constraints[18 + i/3*3 + j/3][i%3*3+j%3][1] = j;
            }
        }
    }
    
    private int[] getConstraintIndex(int i, int j) {
        return new int[] {i, 9 + j, 18 + i/3*3 + j/3};
    }
    
    private void fill(int i, int j, char num, int stack) {
        for (int constraintIndex: getConstraintIndex(i, j)) {
            for (int[] coord: constraints[constraintIndex]) {
                if (choices[coord[0]][coord[1]][num-'1'] < 0) {
                    choices[coord[0]][coord[1]][num-'1'] = stack;
                }
            }
        }
        _board[i][j] = num;
    }
    
    private void unfill(int i, int j, int stack) {
        char num = _board[i][j];
        for (int constraintIndex: getConstraintIndex(i, j)) {
            for (int[] coord: constraints[constraintIndex]) {
                if (choices[coord[0]][coord[1]][num-'1'] == stack) {
                    choices[coord[0]][coord[1]][num-'1'] = -1;
                }
            }
        }
        _board[i][j] = '.';
    }
    
    private void solve(char[][] board, int stack) {
        int minChoices = 10;
        int fillRow = -1, fillCol = -1;
        int i, j, k, sum;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (_board[i][j] == '.') {
                    sum = 0;
                    for (k = 0; k < 9; k++) {
                        if (choices[i][j][k] < 0) {
                            sum++;
                        }
                    }
                    if (minChoices > sum) {
                        minChoices = sum;
                        fillRow = i;
                        fillCol = j;
                    }
                }
            }
        }
        if (fillRow >= 0) {
            for (k = 0; k < 9; k++) {
                if (choices[fillRow][fillCol][k] < 0) {
                    fill(fillRow, fillCol, (char)('1' + k), stack);
                    solve(board, stack + 1);
                    unfill(fillRow, fillCol, stack);
                }
            }
        } else {
            for (i = 0; i < 9; i++) {
                for (j = 0; j < 9; j++) {
                    board[i][j] = _board[i][j];
                }
            }
        }
    }
    
    public void solveSudoku(char[][] board) {
        int i, j, k;
        populateConstraints();
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                _board[i][j] = '.';
                for (k = 0; k < 9; k++) {
                    choices[i][j][k] = -1;
                }
            }
        }
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    fill(i, j, board[i][j], 0);
                }
            }
        }
        solve(board, 1);
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
        String[] inputs = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        for (int i=0; i< 9; i++) {
            board[i] = inputs[i].toCharArray();
        }
        for (char[] i: board)
            System.out.println(Arrays.toString(i));
        Solution solution = new Solution();
        solution.solveSudoku(board);
        System.out.println();
        for (char[] i: board)
            System.out.println(Arrays.toString(i));
    }

}
