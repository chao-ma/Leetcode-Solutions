import java.util.*;

class Solution {
    
    private boolean isDigit(String s) {
        if (s.length() == 0)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }
    
    private boolean isSignedDigit(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            return isDigit(s.substring(1));
        } else {
            return isDigit(s);
        }
    }
    
    private String[] split(String s, char ptn) {
        int count = 0, i, index = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ptn) {
                count++;
                index = i;
            }
            if (count > 1) {
                return null;
            }
        }
        if (count == 0) {
            return new String[] {s};
        } else {
            String[] retValue = new String[2];
            retValue[0] = s.substring(0, index);
            retValue[1] = s.substring(index + 1);
            return retValue;
        }
    }
    
    public boolean isNumber(String s) {
        String trimmedString = s.trim();
        if (trimmedString.length() == 0) {
            return false;
        }
        String[] exponentialSplits = split(trimmedString, 'e');
        if (exponentialSplits == null) {
            return false;
        } else if (exponentialSplits.length == 2) {
            if (!isSignedDigit(exponentialSplits[1])) {
                return false;
            }
        }
        String signDigitDotDigit = exponentialSplits[0];
        String digitDotDigit;
        if (signDigitDotDigit.length() == 0)
            return false;
        if (signDigitDotDigit.charAt(0) == '+' || signDigitDotDigit.charAt(0) == '-')
            digitDotDigit = signDigitDotDigit.substring(1);
        else
            digitDotDigit = signDigitDotDigit;
        String[] digits = split(digitDotDigit, '.');
        if (digits == null)
            return false;
        if (digits.length == 1)
            return isDigit(digits[0]);
        if (digits.length == 2) {
            if (digits[0].length() == 0) {
                return isDigit(digits[1]);
            } else {
                return isDigit(digits[0]) && (digits[1].length() == 0 || isDigit(digits[1]));
            }
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "-2.e10";
        Solution solution = new Solution();
        System.out.println(solution.isNumber(s));
    }

}
