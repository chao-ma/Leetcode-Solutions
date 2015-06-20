class Solution {

    short[][][] cache; // (s1 start pos, s1 end pos, s2 matched pos)
                       // -1 uninitialized, 0 false, 1 true
    
    private boolean isScrambleHelper(char[] s1, int begin, int end, char[] s2, int pos) {
        if (cache[begin][end][pos] != -1)
            return cache[begin][end][pos] == 1;
        if (begin == end) {
            cache[begin][end][pos] = (short) (s1[begin] == s2[pos] ? 1 : 0);
            return s1[begin] == s2[pos];
        }
        boolean retValue = false; //end - begin + 1 - (i - begin + 1)
        for (int i = begin; i < end && !retValue; i++) {
            retValue = retValue || isScrambleHelper(s1, begin, i, s2, pos) &&
                    isScrambleHelper(s1, i + 1, end, s2, pos + (i - begin) + 1);
            retValue = retValue || isScrambleHelper(s1, begin, i, s2, pos + end - i) &&
                    isScrambleHelper(s1, i + 1, end, s2, pos);
        }
        cache[begin][end][pos] = (short) (retValue ? 1 : 0);
        return retValue;
    }
    
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.length() <= 1)
            return s1.equals(s2);
        int n = s1.length();
        cache = new short[n][n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    cache[i][j][k] = -1;
        return isScrambleHelper(s1.toCharArray(), 0, n - 1, s2.toCharArray(), 0);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.isScramble("agtex", "great"));
    }

}
