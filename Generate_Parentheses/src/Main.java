import java.util.*;

class Solution {
    
    List<String> retValue = new ArrayList<>();
    
    private void generateParenthesisHelper(char[] solution, int index, int numUsedPt, int numLeftPt) {
        // pt for parenthesis. numUsedPt records how many ( is in solution and
        // numLeftPt is for remaining ( that can be put into solution
        if (index == solution.length) {
            retValue.add(String.copyValueOf(solution));
            return;
        }
        if (numLeftPt > 0) {
            solution[index] = '(';
            generateParenthesisHelper(solution, index+1, numUsedPt+1, numLeftPt-1);
        }
        if (numUsedPt > 0) {
            solution[index] = ')';
            generateParenthesisHelper(solution, index+1, numUsedPt-1, numLeftPt);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        if (n > 0) {
            char[] solution = new char[n * 2];
            generateParenthesisHelper(solution, 0, 0, n);
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(3);
        for(String s:res)
            System.out.println(s);
    }

}
