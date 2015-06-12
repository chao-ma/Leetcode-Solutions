import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        int pIndex = 0, sIndex = 0;
        int pIndexSaved = -1, sIndexSaved = -1;
        while (pIndex < p.length()) {
            if (p.charAt(pIndex) == '*') {
                pIndexSaved = pIndex;
                sIndexSaved = sIndex;
                pIndex++;
                if (pIndex == p.length())
                    return true;
            } else {
                if (sIndex < s.length()) {
                    if (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex)) {
                        sIndex++;
                        pIndex++;
                    } else {
                        if (pIndexSaved >= 0) {
                            sIndexSaved++;
                            sIndex = sIndexSaved;
                            pIndex = pIndexSaved + 1;
                            if (sIndex >= s.length()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            if (pIndex==p.length() && sIndex < s.length() && pIndexSaved >= 0) {
                sIndexSaved++;
                sIndex = sIndexSaved;
                pIndex = pIndexSaved + 1;
            }
        }
        return sIndex == s.length();
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        String s = "xxabcxxabbabcxx"; String p = "*abc*abc*c";
        //String s = ""
        //String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"; String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        /*char[] buffer = new char[32196];
        for (int i = 0; i < buffer.length; i++)
            buffer[i] = 'a';
        //buffer[0] = '*';buffer[buffer.length - 1] = '*';
        String s = String.copyValueOf(buffer);
        buffer[0] = '*';
        buffer[buffer.length-2]='*';
        String p = String.copyValueOf(buffer, 0, buffer.length-1);*/
        System.out.println(s);
        System.out.println(p);
        System.out.println(solution.isMatch(s, p));
    }

}
