import java.util.*;
class Solution {
    
    private int charToValue(char s) {
        switch (s) {
        case '(':
            return -1;
        case ')':
            return 1;
        case '[':
            return -2;
        case ']':
            return 2;
        case '{':
            return -3;
        case '}':
            return 3;
        }
        return 0;
    }
    public boolean isValid(String s) {
        char[] buffer = s.toCharArray();
        int i, j;
        Stack<Character> stack = new Stack<>();
        for (char p: buffer) {
            i = charToValue(p);
            if (i < 0) {
                stack.push(p);
            } else if (i > 0) {
                if (stack.size()==0)
                    return false;
                j = charToValue(stack.pop());
                if (i + j != 0)
                    return false;
            }
        }
        if (stack.size() > 0)
            return false;
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.isValid("())"));
    }

}
