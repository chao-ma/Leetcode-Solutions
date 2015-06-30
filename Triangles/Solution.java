/**
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
https://leetcode.com/problems/triangle/

My note: I don't want to assume the given List<List<Integer>> triangle supports constant random access. So I created two buffer array and use iterator to loop over input list
*/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        int[] prevRow = new int[triangle.size()];
        int[] curRow = new int[prevRow.length];
        int count = 0, i;
        for (List<Integer> row: triangle) {
            count++; // num of elements
            i = 0;
            for (Integer v: row) {
                if (i == 0) {
                    curRow[0] = v + prevRow[0];
                } else if (i == count - 1) {
                    curRow[i] = v + prevRow[i - 1];
                } else {
                    curRow[i] = v + Math.min(prevRow[i - 1], prevRow[i]);
                }
                i++;
            }
            for (i = 0; i < count; i++)
                prevRow[i] = curRow[i];
        }
        int retValue = prevRow[0];
        for (i = 1; i < prevRow.length; i++)
            retValue = Math.min(retValue, prevRow[i]);
        return retValue;
    }
}
