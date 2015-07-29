import java.util.Arrays;

class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        char[] origin = s.toCharArray();
        char[] reverse = new StringBuilder(s).reverse().toString().toCharArray();
        int[] dp = new int[origin.length];
        // here is to build longest substring ptn table
        int i, cursor;
        dp[0] = -1; dp[1] = 0;
        for (i = 2; i < dp.length; i++) {
            for (cursor = dp[i - 1]; cursor > -1 && origin[cursor] != origin[i - 1]; cursor = dp[cursor]);
            dp[i] = cursor + 1;
        }
        // here is to do substring search
        i = 0; cursor = 0; //i for looping reverse, cursor for looping origin
        while (i + cursor < reverse.length) {
            if (reverse[i + cursor] == origin[cursor]) {
                cursor++;
            } else {
                i = i + cursor - dp[cursor];
                cursor = dp[cursor] > -1 ? dp[cursor] : 0;
            }
        }
        // to build palindrome
        char[] palindrome = new char[origin.length + i];
        for (cursor = 0; cursor < i; cursor++)
            palindrome[cursor] = reverse[cursor];
        for (cursor = 0; cursor < origin.length; cursor++)
            palindrome[i + cursor] = origin[cursor];
        return String.copyValueOf(palindrome);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution(); 
        System.out.println(solution.shortestPalindrome("abacabb"));
    }

}
