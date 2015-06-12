import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[2][s.length()+1];
        int i, j, numCharPtn = 0, numCharPtnScanned = 0, numCharPtnLeft;
        int curRow, prevRow;
        char ptn; boolean starMatching;
        for (i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                numCharPtn++;
            }
        }
        dp[0][0] = dp[1][0] = true;
        for (i = 0; i < p.length(); i++) {
            ptn = p.charAt(i);
            curRow = i % 2; prevRow = (i + 1) % 2;
            starMatching = false;
            if (ptn == '*') {
                dp[curRow][0] = dp[prevRow][0];
                numCharPtnLeft = numCharPtn - numCharPtnScanned;
                for (j = numCharPtnScanned - 1; j < s.length() - numCharPtnLeft; j++) {
                    dp[curRow][j + 1] = starMatching = starMatching || dp[prevRow][j + 1];
                }
            } else {
                dp[curRow][0] = false;
                numCharPtnLeft = numCharPtn - numCharPtnScanned - 1;
                for (j = numCharPtnScanned; j < s.length() - numCharPtnLeft; j++) {
                    dp[curRow][j + 1] = dp[prevRow][j] && (ptn == '?' || ptn == s.charAt(j));
                }
                numCharPtnScanned++;
            }
        }
        return dp[(p.length() + 1)% 2][s.length()];
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        //String s = ""; String p = "*a*";
        //String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"; String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        char[] buffer = new char[32196];
        for (int i = 0; i < buffer.length; i++)
            buffer[i] = 'a';
        //buffer[0] = '*';buffer[buffer.length - 1] = '*';
        String s = String.copyValueOf(buffer);
        buffer[0] = '*';
        buffer[buffer.length-2]='*';
        String p = String.copyValueOf(buffer, 0, buffer.length-1);
        System.out.println(s);
        System.out.println(p);
        System.out.println(solution.isMatch(s, p));
    }

}
