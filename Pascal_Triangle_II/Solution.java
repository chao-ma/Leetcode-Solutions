/**
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
https://leetcode.com/problems/pascals-triangle-ii/

My note: This is a pretty fast implementation, avoiding auto boxing and auto unboxing.
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] buffer = new int[rowIndex + 1];
        int i, j;
        for (j = 0; j < buffer.length; j++)
            buffer[j] = 1;
        for (i = 2; i <= rowIndex; i++)
            for (j = i - 1; j >= 1; j--)
                buffer[j] += buffer[j - 1];
        List<Integer> retValue = new ArrayList<>();
        for (j = 0; j < buffer.length; j++)
            retValue.add(buffer[j]);
        return retValue;
    }
}
