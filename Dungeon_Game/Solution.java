/**
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)    -3        3
-5        -10       1
10         30      -5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

https://leetcode.com/problems/dungeon-game/

My note:
I underestimated this problem at the beginning, trying to solve it like
"How many ways to the bottom-right". Obviously it doesn't fit.
Theoretically this is a optimization problem:

route represents all possible paths from top-left to bottom right
As knight can only move right/bottom, then all routes have the same length
   argMax(route, argMin(i, f(route, i))) where f(route, i) is a function
some all values from 1 to i.
MaxMin != MinMax in this case. I got stuck here for long.

Then I change way of thinking, let dp(i, j) represents the minimum value
of health to play the game.
dp(i, j) > dungeon(i, j), and 1 minimum
to continue the game, it either moves right or down,
dp(i, j) + dungeon(i, j) >= dp(i + 1, j) or dp(i, j + 1)
Then here is the DP solution.
Lesson learnt, DP way of thinking should focus on the variable to solve itself
in this case dp(i, j) exactly answers the question. Every DP is new, can't simply
copy old solution to new ones.
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int nRow = dungeon.length;
        if (nRow == 0)
            return 1;
        int nCol = dungeon[0].length;
        if (nCol == 0)
            return 1;
        int[][] dp = new int[2][nCol];
        int curRow = (nRow - 1) % 2, nextRow, i, j;
        dp[curRow][nCol - 1] = dungeon[nRow - 1][nCol - 1] >= 0 ? 1 : 1 - dungeon[nRow - 1][nCol - 1];
        for (j = nCol - 2; j >= 0; j--)
            dp[curRow][j] = Math.max(dp[curRow][j + 1] - dungeon[nRow - 1][j], 1);
        for (i = nRow - 2; i >= 0; i--) {
            curRow = i % 2;
            nextRow = (i + 1) % 2;
            dp[curRow][nCol - 1] = Math.max(dp[nextRow][nCol - 1] - dungeon[i][nCol - 1], 1);
            for (j = nCol - 2; j >= 0; j--) {
                dp[curRow][j] = Math.min(Math.max(dp[nextRow][j] - dungeon[i][j], 1),
                                        Math.max(dp[curRow][j + 1] - dungeon[i][j], 1));
            }
        }
        return dp[0][0];
    }
}
