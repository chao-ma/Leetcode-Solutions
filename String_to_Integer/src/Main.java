class Solution {
    public int myAtoi(String str) {
        int retValue = 0;
        int i = 0;
        int strLen = str.length();
        long buffer = 0;
        boolean signed = false;
        char curChar;
        // searching for the first non-white space char
        for (i = 0; i < strLen && str.charAt(i) == ' '; i++);
        if (i < strLen) {
            if (str.charAt(i) == '-') {
                signed = true;
                i++;
            } else if (str.charAt(i) == '+') {
                signed = false;
                i++;
            }
        }
        while (i < strLen) {
            curChar = str.charAt(i);
            if (curChar >= '0' && curChar <= '9') {
                if (buffer <= Integer.MAX_VALUE) {
                    buffer = buffer * 10 + curChar - '0';
                }
            } else {
                break;
            }
            i++;
        }
        
        if (signed) {
            buffer = - buffer;
        }
        
        if (buffer < Integer.MIN_VALUE) {
            retValue = Integer.MIN_VALUE;
        } else if (buffer > Integer.MAX_VALUE) {
            retValue = Integer.MAX_VALUE;
        } else {
            retValue = (int)buffer;
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        /* Test cases:
         * ""
         * "    "
         * "123"
         * "-123"
         * "0"
         * "-0"
         * " + 1"
         * " +1"
         * " 123"
         * "  123  "
         * "   -123  "
         * "123abc"
         * "abc 123"
         * "123 abc"
         * " -123 abc"
         * "-"
         * " - "
         * Integer.MIN_VALUE - 1
         * Integer.MIN_VALUE
         * Integer.MAX_VALUE * 2 + 1
         */
        String str = "-0012a12";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(str));
    }

}
