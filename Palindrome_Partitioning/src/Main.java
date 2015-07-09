import java.util.*;

class Solution {

    private boolean isPalindrome(String s, int begin, int end) {
        for (; begin < end && s.charAt(begin) == s.charAt(end); begin++, end--);
        return begin >= end;
    }
    
    private List<List<String>> helper(String s, int index) {
        List<List<String>> retValue = new LinkedList<>();
        if (index < s.length()) {
            int i;
            for (i = index; i < s.length(); i++) {
                if (isPalindrome(s, index, i)) {
                    List<List<String>> res = helper(s, i + 1);
                    for (List<String> sol: res) {
                        sol.add(0, s.substring(index, i + 1));
                        retValue.add(sol);
                    }
                }
            }
        } else {
            retValue.add(new LinkedList<String>());
        }
        return retValue;
    }
    
    public List<List<String>> partition(String s) {
        return helper(s, 0);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.partition("abc"));
    }

}
