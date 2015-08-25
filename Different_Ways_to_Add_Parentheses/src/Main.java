import java.util.*;
class Solution {
    private int calculate(int operandA, char operator, int operandB) {
        switch (operator) {
        case '+':
            return operandA + operandB;
        case '-':
            return operandA - operandB;
        case '*':
            return operandA * operandB;
        default:
            return 0;
        }
    }
    private List<Integer> computes(List<String> tokens, int begin, int end) {
        List<Integer> retValue = new ArrayList<>();
        if (begin == end)
            retValue.add(Integer.parseInt(tokens.get(begin)));
        else if (begin == end - 2) {
            retValue.add(calculate(Integer.parseInt(tokens.get(begin)),
                    tokens.get(begin + 1).charAt(0),
                    Integer.parseInt(tokens.get(end))));
        } else {
            for (int i = begin + 1; i < end; i += 2) {
                List<Integer> solutionsA = computes(tokens, begin, i - 1);
                List<Integer> solutionsB = computes(tokens, i + 1, end);
                char operator = tokens.get(i).charAt(0);
                for (int a: solutionsA) {
                    for (int b: solutionsB) {
                        retValue.add(calculate(a, operator, b));
                    }
                }
            }
        }
        return retValue;
    }
    public List<Integer> diffWaysToCompute(String input) {
        List<String> tokens = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (curChar == '+' || curChar == '-' || curChar == '*') {
                tokens.add(input.substring(last, i));
                tokens.add(input.substring(i, i + 1));
                last = i + 1;
            }
        }
        tokens.add(input.substring(last));
        return computes(tokens, 0, tokens.size() - 1);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }

}
