class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String retValue = "";
        int prefixLength = 0;
        char curChar;
        int i;
        boolean flag = true;
        while (flag) {
            if (prefixLength < strs[0].length()) {
                curChar = strs[0].charAt(prefixLength);
            } else {
                break;
            }
            for (i = 1; i < strs.length && flag; i++) {
                if (prefixLength >= strs[i].length() || strs[i].charAt(prefixLength) != curChar) {
                    flag = false;
                }
            }
            if (flag) {
                prefixLength++;
            }
        }
        retValue = strs[0].substring(0, prefixLength);
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] strs = {
                "aabc",
                //"aabd",
                //"aabx",
                //"aabc",
                //"aa",
        };
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }

}
