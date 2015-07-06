/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.

https://leetcode.com/problems/valid-palindrome/
*/
public class Solution {
    
    private boolean isAlphaNumeric(char c) {
        return c >= '0' && c <= '9' || c >='a' && c <= 'z' || c >= 'A' && c <='Z';
    }
    
    private char transform(char c) {
        if (c >= 'A' && c <='Z') {
            return (char)('a' + c - 'A');
        }
        return c;
    }
    
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            for (; i < j && !isAlphaNumeric(s.charAt(i)); i++);
            for (; j > i && !isAlphaNumeric(s.charAt(j)); j--);
            if (i < j) {
                if (transform(s.charAt(i)) != transform(s.charAt(j)))
                    return false;
            }
            i++; j--;
        }
        return true;
    }
}
