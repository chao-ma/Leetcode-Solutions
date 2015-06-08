import java.util.*;

class Solution {

    private static class Interval {

        int begin;
        int end;
        
        Interval (int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
        
        boolean isOverlapping(Interval anotherInterval) {
            if (anotherInterval.begin == end + 1) {
                return true;
            } else if (begin > anotherInterval.begin) {
                return true;
            }
            return false;
        }
        
        void overlap(Interval anotherInterval) {
            if (anotherInterval.begin < begin) {
                begin = anotherInterval.begin;
                end = anotherInterval.end;
            } else if (anotherInterval.begin == end + 1) {
                end = anotherInterval.end;
            }
        }
        
        int length() {
            return end - begin + 1;
        }

        @Override
        public String toString() {
            return "(" + begin + ", " + end + ")";
        }
    }
    
    private int retValue = 0;
    private Stack<Interval> intervalStack = new Stack<>();
    
    private void push(Interval interval) {
        Interval tmp;
        while (!intervalStack.isEmpty() && intervalStack.peek().isOverlapping(interval)) {
            tmp = intervalStack.pop();
            tmp.overlap(interval);
            interval = tmp;
        }
        retValue = Math.max(retValue, interval.length());
        intervalStack.push(interval);
    }
    
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char curChar;
        for (int i = 0; i < s.length(); i++) {
            curChar = s.charAt(i);
            if (curChar == '(') {
                stack.push(i);
            } else if (curChar == ')') {
                if (!stack.isEmpty()) {
                    push(new Interval(stack.pop(), i));
                }
            }
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = ")))((()()())";
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }

}
