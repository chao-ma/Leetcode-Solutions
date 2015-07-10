/**
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

https://leetcode.com/problems/word-break/
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int maxLen = 0;
        for (String word: wordDict)
            maxLen = word.length() > maxLen ? word.length() : maxLen;
        boolean[] dp = new boolean[s.length() + 1];
        int i, j;
        dp[0] = true;
        for (i = 0; i < s.length(); i++)
            for (j = i; j >=0 && (i - j + 1) <= maxLen && !dp[i + 1]; j--)
                dp[i + 1] = wordDict.contains(s.substring(j, i + 1)) && dp[j];
        return dp[s.length()];
    }
}
