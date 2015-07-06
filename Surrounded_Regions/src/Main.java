import java.util.*;

class Solution {
    public void solve(char[][] board) {
        int nRow = board.length;
        if (nRow == 0)
            return;
        int nCol = board[0].length;
        if (nCol == 0)
            return;
        List<int[]> queue = new LinkedList<>();
        List<int[]> OCoord = new LinkedList<>();
        int[][] neighbors = new int[4][2];
        int row, col;
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (board[i][j] != 'O')
                    continue;
                queue.add(new int[] {i, j});
                board[i][j] = 'X';
                boolean touchBoundary = false;
                OCoord.clear();
                while (!queue.isEmpty()) {
                    int[] coord = queue.remove(0);
                    OCoord.add(coord);
                    neighbors[0][0] = coord[0];neighbors[0][1] = coord[1] - 1;
                    neighbors[1][0] = coord[0];neighbors[1][1] = coord[1] + 1;
                    neighbors[2][0] = coord[0] - 1;neighbors[2][1] = coord[1];
                    neighbors[3][0] = coord[0] + 1;neighbors[3][1] = coord[1];
                    for (int[] neighbor: neighbors) {
                        row = neighbor[0]; col = neighbor[1];
                        if (row < 0 || row == nRow || col < 0 || col == nCol) {
                            touchBoundary = true;
                            continue;
                        }
                        if (board[row][col] == 'O') {
                            board[row][col] = 'X';
                            queue.add(new int[] {row, col});
                        }
                    }
                }
                if (touchBoundary) {
                    for (int[] coord: OCoord) {
                        board[coord[0]][coord[1]] = 'o';
                    }
                }
            }
        }
        for (int i = 0; i < nRow; i++)
            for (int j = 0; j < board[i].length; j ++)
                if (board[i][j] == 'o')
                    board[i][j] = 'O';
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] inputs = {
                "XXXX",
                "XOOX",
                "XOXX",
                "XXXO"
        };
        char[][] board = new char[inputs.length][];
        for (int i = 0; i < inputs.length; i++)
            board[i] = inputs[i].toCharArray();
        Solution solution = new Solution();
        solution.solve(board);
        for (char[] row: board)
            System.out.println(Arrays.toString(row));
        List<String> l = new ArrayList<>();
        
    }
    

}
