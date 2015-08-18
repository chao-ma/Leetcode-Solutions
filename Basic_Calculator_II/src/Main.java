import java.util.*;

class Solution {
    
    public static Map<Character, Integer> operatorPriority = new HashMap<>();
    
    static {
        operatorPriority.put('*', 2);
        operatorPriority.put('/', 2);
        operatorPriority.put('+', 1);
        operatorPriority.put('-', 1);
    }
    
    private int compute(int val1, int val2, int operator) {
        switch (operator) {
        case '+':
            return val2 + val1;
        case '-':
            return val2 - val1;
        case '*':
            return val2 * val1;
        case '/':
            return val2 / val1;
        }
        return 0;
    }
    
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                continue;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                val = val * 10 + s.charAt(i) - '0';
            } else {
                operands.push(val);
                val = 0;
                if (s.charAt(i) == '*' || s.charAt(i) == '/' ) {
                    while (!operators.isEmpty() && operatorPriority.get(operators.peek()) == 2)
                        operands.push(compute(operands.pop(), operands.pop(), operators.pop()));
                } else {
                    while (!operators.isEmpty())
                        operands.push(compute(operands.pop(), operands.pop(), operators.pop()));
                }
                operators.push(s.charAt(i));
            }
        }
        operands.push(val);
        while (!operators.isEmpty())
            operands.push(compute(operands.pop(), operands.pop(), operators.pop()));
        return operands.pop();
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.calculate("3 + 55 / 20"));
    }

}
