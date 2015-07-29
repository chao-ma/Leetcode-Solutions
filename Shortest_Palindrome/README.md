Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
For example:
Given "aacecaaa", return "aaacecaaa".
Given "abcd", return "dcbabcd".

https://leetcode.com/problems/shortest-palindrome/


Here is my first solution:

```java
// even case:  x x X x x x x
// odd case:   x x x X x x x
public class Solution {
    private String buildPalindrome(String s, int j) {
        char[] buffer = new char[s.length() * 2 - j];
        for (; j < s.length(); j++)
            buffer[s.length() - 1 - j] = s.charAt(j);
        for (j = s.length() - 1; j >= 0; j--)
            buffer[buffer.length - s.length() + j] = s.charAt(j);
        return String.copyValueOf(buffer);        
    }
    
    public String shortestPalindrome(String s) {
        int i, j, k;
        String evenCase = null, oddCase = null;
        for (k = s.length() / 2 - 1; k >= 0 && evenCase == null; k--) {
            for (i = k, j = k + 1; i >= 0 && s.charAt(i) == s.charAt(j); i--, j++);
            if (i < 0)
                evenCase = buildPalindrome(s, j);
        }
        for (k = (s.length() + 1) / 2 - 1; k >= 0 && oddCase == null; k--) {
            for (i = k - 1, j = k + 1; i >= 0 && s.charAt(i) == s.charAt(j); i--, j++);
            if (i < 0)
                oddCase = buildPalindrome(s, j);
        }
        if (evenCase == null)
            return oddCase;
        return evenCase.length() < oddCase.length() ? evenCase : oddCase;
    }
}
```

The code itself is not too bad. Simple but inefficient. It runs O(N-square)
time complexity. If it is this simple, it is not "hard" question at leetcode.

Here is my thought process

origin string:       aaaxya
reverse string    ayxaaa

Basically it is trying to find the maximum string overlay

origin string:       aaaxya
reverse string       ayxaaa
                      |

e.g. 1st position in origin string, origin_string[1] = origin_string[0]
Basically it nees to match to a position with two 'a's. but one backward look-up
is not enough. what if the string shifted multiple positions?

The answer is KMP.

Fine, my 3rd time to write KMP algorithm. 
IMO, it is not about how well I finish a coding exercise, it is about
how much I learn and how much I improve. Through this, my understanding of KMP is deeper
 and I learnt string builder.

This is the O(N) solution:

```java
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
```
