/**
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
https://leetcode.com/problems/excel-sheet-column-number/
 */
public class Solution {
    public int titleToNumber(String s) {
        int retValue = 0;
        int offset = 1;
        for (int i = s.length() - 1; i >= 0; i--, offset *= 26)
            retValue += (s.charAt(i) - 'A') * offset + offset;
        return retValue;
    }
}
