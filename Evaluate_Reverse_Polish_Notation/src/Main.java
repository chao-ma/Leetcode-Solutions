import java.util.*;

class Solution {

    public static interface Operator {
        public int calculate(int a, int b);
    }
    
    public static class Plus implements Operator {
        public int calculate(int a, int b) {
            return a + b;
        }
    }
    
    public static class Minus implements Operator {
        public int calculate(int a, int b) {
            return a - b;
        }
    }
    
    public static class Multiply implements Operator {
        public int calculate(int a, int b) {
            return a * b;
        }
    }
    
    public static class Divide implements Operator {
        public int calculate(int a, int b) {
            return a / b;
        }
    }
    public int evalRPN(String[] tokens) {
        Map<String, Operator> map = new HashMap<>();
        map.put("+", new Plus());
        map.put("-", new Minus());
        map.put("*", new Multiply());
        map.put("/", new Divide());
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (String token: tokens) {
            if (map.containsKey(token)) {
                b = stack.pop();
                a = stack.pop();
                stack.push(map.get(token).calculate(a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] tokens = {"4", "13", "5", "/", "+"};
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(tokens));
    }

}
