class Solution {
    public String longestPalindrome(String s) {
        int begin = 0, end = 1, longest = 1;
        int strLen = s.length();
        if (strLen <= 1) {
            return s;
        }
        int i, j;
        for (i = 0; i < strLen; i++) {
            if ((strLen-i-1)*2+1<=longest) {
                break;
            }
            // odd case
            j = 1;
            while ((i - j) >= 0 && (i + j) < strLen && s.charAt(i - j) == s.charAt(i + j)) {
                j++;
            }
            if (2*j-1 > longest) {
                longest = 2 * j - 1;
                begin = i - j + 1;
                end = i + j;
            }
            // even case
            j = 1;
            while ((i - j + 1) >= 0 && (i + j) < strLen && s.charAt(i - j + 1) == s.charAt(i + j)) {
                j++;
            }
            if (j*2 - 2 > longest) {
                longest = j * 2 - 2;
                begin = i - j + 2;
                end = i + j;
            }
        }
        return s.substring(begin, end);
    }
}


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("aaccabaasdf"));
    }

}
