import java.util.ArrayList;
import java.util.List;

class Solution {
    char[][] digitToCharArray = {
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'},
    };
    List<String> retValue = new ArrayList<>();;
    
    private char[] digitToChars(char digit) {
        if (digit<='9' && digit>='2')
            return digitToCharArray[digit-'1'];
        else
            return digitToCharArray[0];
    }
    
    private void letterCombinationHelper(char[] buffer, int index, char[] solution) {
        if (index >= solution.length) {
            retValue.add(String.copyValueOf(solution));
            return;
        }
        char[] choices = digitToChars(buffer[index]);
        for (char choice: choices) {
            solution[index] = choice;
            letterCombinationHelper(buffer, index+1, solution);
        }
        
    }
    
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0)
            return retValue;
        char[] buffer = digits.toCharArray();
        char[] solution = new char[buffer.length];
        letterCombinationHelper(buffer, 0, solution);
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        List<String> res = solution.letterCombinations("");
        for(String i:res)
            System.out.println(i);
    }

}
