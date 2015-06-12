class Solution {
    private boolean isMatchingHelper(String s, int sIndex, String p, int pIndex) {
        if (sIndex >= s.length() && pIndex >= p.length()) {
            return true;
        } else if (pIndex >= p.length() && sIndex < s.length()) {
            return false;
        }
        char ptnChar = p.charAt(pIndex);
        if (ptnChar == '?') {
            if (sIndex >= s.length()) {
                return false;
            } else {
                return isMatchingHelper(s, sIndex + 1, p, pIndex + 1);
            }
        } else if (ptnChar == '*') {
            boolean retValue = false;
            int nextIndex = pIndex + 1;
            while (nextIndex < p.length() && p.charAt(nextIndex) == '*') {
                nextIndex++;
            }
            for (int i = sIndex; i <= s.length() && !retValue; i++) {
                retValue = retValue || isMatchingHelper(s, i, p, nextIndex);
            }
            return retValue;
        } else {
            if (sIndex < s.length() && ptnChar == s.charAt(sIndex)) {
                return isMatchingHelper(s, sIndex + 1, p, pIndex + 1);
            } else {
                return false;
            }
        }
    }
    
    public boolean isMatch(String s, String p) {
        return isMatchingHelper(s, 0, p, 0);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"; String p = "a*******b";
        System.out.println(solution.isMatch(s, p));
    }

}
