class Solution {
    public int strStr(String haystack, String needle) {
        char[] str = haystack.toCharArray();
        char[] ptn = needle.toCharArray();
        int needleLen = needle.length();
        if (needleLen == 0) {
            return 0;
        }
        int[] ptnHelper = new int[needleLen];
        int i, j;
        for (i = 0; i < needleLen && i < 2; i++) {
            ptnHelper[i] = i - 1;
        }
        for (i = 2; i < needleLen; i++) {
            j = ptnHelper[i - 1];
            do {
                if (ptn[i - 1] == ptn[j]) {
                    ptnHelper[i] = j + 1;
                    break;
                } else {
                    j = ptnHelper[j];
                }
            } while(j >= 0);
        }
        i = 0; j = 0; // i for looping str. j for ptn
        while (i + j < str.length && j < needleLen) {
            if (str[i + j] == ptn[j]) {
                j++;
            } else {
                i = i + j - ptnHelper[j];
                j = ptnHelper[j];
                j = j < 0 ? 0: j;
            }
            if (j == needleLen) {
                return i;
            }
        }
        return -1;
    }
}


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //String haystack = "abababaac"; String needle = "abacabadabacabadx";
        //String haystack = "ababaaaac"; String needle = "ababaac";
        String haystack = "aa"; String needle = "a";
        Solution solution = new Solution();
        System.out.println(solution.strStr(haystack, needle));
    }

}
