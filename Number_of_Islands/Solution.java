/**
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

https://leetcode.com/problems/number-of-islands/

My note: always remember DFS, never add duplicate element to the queue!
*/

public class Solution {
    public int numIslands(char[][] grid) {
        int retValue = 0, i, j, row, col;
        List<int[]> queue = new LinkedList<>();
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    retValue++;
                    queue.add(new int[] {i, j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int[] coord = queue.remove(0);
                        row = coord[0]; col = coord[1];
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.add(new int[] {row - 1, col});
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
                            queue.add(new int[] {row + 1, col});
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.add(new int[] {row, col - 1});
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < grid[i].length && grid[row][col + 1] == '1') {
                            queue.add(new int[] {row, col + 1});
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return retValue;
    }
}
