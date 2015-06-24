class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int a = 1, b = 1, val, tmp;
        int previousDigit = 3, currentDigit;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                currentDigit = s.charAt(i) - '0';
            else
                return 0;
            if (currentDigit == 0) {
                if (previousDigit * 10 + currentDigit > 26 || previousDigit * 10 + currentDigit < 1) {
                    return 0;
                } else {
                    tmp = a;
                }
            } else {
                if (previousDigit * 10 + currentDigit > 26 || previousDigit * 10 + currentDigit < 10) {
                    tmp = b;
                } else {
                    tmp = a + b;
                }
            }
            a = b;
            b = tmp;
            previousDigit = currentDigit;
        }
        return b;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("106"));
    }

}
