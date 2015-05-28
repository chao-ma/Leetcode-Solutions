class Solution {

    private int romanCharToValue(char c) {
        int retValue = 0;
        switch(c) {
        case 'I':
            retValue = 1;
            break;
        case 'V':
            retValue = 5;
            break;
        case 'X':
            retValue = 10;
            break;
        case 'L':
            retValue = 50;
            break;
        case 'C':
            retValue = 100;
            break;
        case 'D':
            retValue = 500;
            break;
        case 'M':
            retValue = 1000;
            break;
        }
        return retValue;
    }
    
    public int romanToInt(String s) {
        int retValue = 0;
        int strLen = s.length();
        char[] buffer = s.toCharArray();
        for (int i = 0; i < strLen; i++) {
            if (i + 1 < strLen) {
                if (romanCharToValue(buffer[i])>=romanCharToValue(buffer[i+1])) {
                    retValue += romanCharToValue(buffer[i]);
                } else {
                    retValue -= romanCharToValue(buffer[i]);
                }
            } else {
                retValue += romanCharToValue(buffer[i]);
            }
        }
        return retValue;
    }
}


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MMXIV"));
    }

}
