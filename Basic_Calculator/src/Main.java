import java.util.*;

class Solution {
    public int calculate(String s) {
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int state = 0; // 1: numeric 2: operator
        int val = 0;
        char x;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                continue;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (state < 2) {
                    val = val * 10 + s.charAt(i) - '0';
                } else {
                    val = s.charAt(i) - '0';
                }
                state = 1;
            } else {
                if (state == 1)
                    operand.push(val);
                if (s.charAt(i) == '(')
                    operator.push(s.charAt(i));
                else {
                    while (!operator.isEmpty() && operator.peek() != '(') {
                        x = operator.pop();
                        if (x == '+')
                            operand.push(operand.pop() + operand.pop());
                        else if (x == '-')
                            operand.push(-operand.pop() + operand.pop());
                    }
                    if (s.charAt(i) == ')')
                        operator.pop();
                    else
                        operator.push(s.charAt(i));
                }
                state = 2;
            }
        }
        if (state == 0)
            return 0;
        if (state == 1)
            operand.push(val);  
        while (!operator.isEmpty()) {
            x = operator.pop();
            if (x == '+')
                operand.push(operand.pop() + operand.pop());
            else if (x == '-')
                operand.push(-operand.pop() + operand.pop());
        }
        return operand.pop();
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.calculate("((1 )+ 2) -((3+ 4 ) ) "));
    }

}
