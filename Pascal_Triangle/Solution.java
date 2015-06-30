/**
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
https://leetcode.com/problems/pascals-triangle/
*/
public class Solution {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> retValue = new ArrayList<>();

        Integer[] lastRow = null;

        for (int i = 1; i <= numRows; i++) {

            Integer[] row = new Integer[i];

            row[0] = 1;

            row[i - 1] = 1;

            if (lastRow != null) {

                for (int j = 1; j < i - 1; j++) {

                    row[j] = lastRow[j] + lastRow[j - 1];

                }

            }

            lastRow = row;

            retValue.add(Arrays.asList(row));

        }

        return retValue;

    }

}
