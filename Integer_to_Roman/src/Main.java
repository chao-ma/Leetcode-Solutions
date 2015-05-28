class Solution {
    
    private String digitToRomanHelper(int digit, String oneInRoman, String fiveInRoman, String tenInRoman) {
        String retValue = "";
        int i;
        if (digit > 0 && digit <= 3 ) {
            for (i = 0; i < digit; i++) {
                retValue += oneInRoman;
            }
        } else if (digit == 4) {
            retValue = oneInRoman + fiveInRoman;
        } else if (digit == 5) {
            retValue = fiveInRoman;
        } else if (digit > 5 && digit < 9) {
            retValue = fiveInRoman;
            for (i = 5; i < digit; i++) {
                retValue += oneInRoman;
            }
        } else if (digit==9) {
            retValue = oneInRoman + tenInRoman;
        }
        return retValue;
    }
    
    public String intToRoman(int num) {
        String[][] digitLookup = {
                {"I", "V", "X"},
                {"X", "L", "C"},
                {"C", "D", "M"},
                {"M", "M", "M"},
        };
        String retValue = "";
        int divider = 1000;
        for (int digit = 3; digit >= 0; digit--) {
            retValue += digitToRomanHelper(num / divider % 10, digitLookup[digit][0],
                    digitLookup[digit][1], digitLookup[digit][2]);
            divider /= 10;
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3999));
        /*for (int i=1; i<50; i++){
            System.out.println(i);
            System.out.println(solution.intToRoman(i));
            System.out.println();
        }*/
    }

}
