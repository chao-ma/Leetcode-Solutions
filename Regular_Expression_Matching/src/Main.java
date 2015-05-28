class Solution {
    
    private boolean isPositionMatch(char[] s, int sIndex, char ptn) {
        if (sIndex >= s.length)
            return false;
        if (ptn == '.' || ptn == s[sIndex]) {
            return true;
        }
        return false;
    }

    private boolean isMatchHelper(char[] s, int sIndex, char[] p, int pIndex) {
        if (pIndex >= p.length && sIndex < s.length) {
            return false;
        } else if (pIndex >= p.length && sIndex >= s.length) {
            return true;
        } else {
            char curPtn = p[pIndex];
            boolean wildCard = false;
            if (pIndex + 1 < p.length && p[pIndex + 1] == '*') {
                wildCard = true;
            }
            if (wildCard) {
                boolean retValue = isMatchHelper(s, sIndex, p, pIndex + 2);
                int i = 0;
                while (sIndex + i < s.length && !retValue) {
                    if (isPositionMatch(s, sIndex + i, curPtn)) {
                        retValue = retValue || isMatchHelper(s, sIndex + i + 1, p, pIndex + 2);
                    } else {
                        break;
                    }
                    i++;
                }
                return retValue;
            } else {
                if (isPositionMatch(s, sIndex, curPtn)) {
                    return isMatchHelper(s, sIndex + 1, p, pIndex + 1);
                }
                return false;
            }
        }
    }
    
    public boolean isMatch(String s, String p) {
        char[] sBuffer = s.toCharArray();
        char[] pBuffer = p.toCharArray();
        return isMatchHelper(sBuffer, 0, pBuffer, 0);
    }
}


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        String s = "aba";
        String p = "a.*bac*";
        System.out.println(solution.isMatch("aab", "c*a*c*"));
    }

}
