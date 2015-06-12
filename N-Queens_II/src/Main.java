import java.util.ArrayList;
import java.util.List;

class Solution {
    
    private int solveNQueensHelper(int index, int n, int[] solution) {
        if (index == n) {
            return 1;
        }
        int i, j, sum = 0;
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
                sum += solveNQueensHelper(index + 1, n, solution);
            }
        }
        return sum;
    }

    public int totalNQueens(int n) {
        int[] solution = new int[n];
        return solveNQueensHelper(0, n, solution);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(8));
    }

}
