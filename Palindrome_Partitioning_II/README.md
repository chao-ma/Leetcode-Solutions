Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

https://leetcode.com/problems/palindrome-partitioning-ii/

My note:

here is my first solution, recursion and brute force


public class Solution {
    private boolean isPalindrome(String s, int begin, int end) {
        for (; begin < end && s.charAt(begin) == s.charAt(end); begin++, end--);
        return begin >= end;
    }
    private int helper(String s, int index) {
        if (index == s.length())
            return 0;
        int retValue = 0;
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                int res = helper(s, i + 1);
                retValue = retValue == 0 ? res: Math.min(retValue, res); 
            }
        }
        return retValue + 1;
    }
    public int minCut(String s) {
        if (s.length() < 2)
            return 0;
        return helper(s, 0) - 1;
    }
}

Time limit exceeded. Then here is the DP solution.


class Solution {
    
    boolean cache[][];
    
    private boolean isPalindrome(String s, int begin, int end) {
        for (; begin < end && s.charAt(begin) == s.charAt(end); begin++, end--);
        return begin >= end;
    }
    
    public int minCut(String s) {
        if (s.length() < 2)
            return 0;
        cache = new boolean[s.length()][s.length()];
        int[] solution = new int[s.length() + 1];
        solution[0] = -1;
        int i, j;
        for (i = 0; i < s.length(); i++)
            for (j = i; j < s.length(); j++)
                cache[j][i] = cache[i][j] = isPalindrome(s, i, j);
        for (i = 0; i < s.length(); i++) {
            solution[i + 1] = solution[i] + 1;
            for (j = i - 1; j >= 0; j--) {
                if (cache[j][i])
                    solution[i + 1] = Math.min(solution[i + 1], solution[j] + 1);
            }
        }
        return solution[s.length()];
    }
}

This solution is better than the recursion one, time complexity is O(N^2). not bad, but still time limit exceeded
But I missed one detail, the way I solve cache[][] array is actually O(N^3). After a simple optimization, it passes the online judge:


class Solution {  
    public int minCut(String s) {
        if (s.length() < 2)
            return 0;
        boolean[][] cache = new boolean[s.length()][s.length()];
        int[] solution = new int[s.length() + 1];
        solution[0] = -1;
        int i, j;
        for (i = 0; i < s.length(); i++) {
            j = 0;
            while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                cache[i - j][i + j] = true;
                j++;
            }
            j = 0;
            while (i - j >= 0 && i + j + 1 < s.length() && s.charAt(i - j) == s.charAt(i + j + 1)) {
                cache[i - j][i + j + 1] = true;
                j++;
            }
        }
        for (i = 0; i < s.length(); i++) {
            solution[i + 1] = solution[i] + 1;
            for (j = i - 1; j >= 0; j--) {
                if (cache[j][i])
                    solution[i + 1] = Math.min(solution[i + 1], solution[j] + 1);
            }
        }
        return solution[s.length()];
    }
}

