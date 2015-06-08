class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String retValue = "1";
        String builder;
        char curChar;
        int count;
        for (int i = 2; i <= n; i++) {
            curChar = retValue.charAt(0);
            count = 0;
            builder = "";
            for (int j = 0; j < retValue.length(); j++) {
                if (retValue.charAt(j) == curChar) {
                    count++;
                } else {
                    builder += String.format("%d%c", count, curChar);
                    count = 1;
                    curChar = retValue.charAt(j);
                }
            }
            builder += String.format("%d%c", count, curChar);
            retValue = builder;
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        for (int i=0;i<10;i++)
            System.out.println(solution.countAndSay(i));
    }

}
