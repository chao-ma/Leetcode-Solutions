Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

https://leetcode.com/problems/distinct-subsequences/

My note:
This is another fun dp question. The idea is this:

i be the index of s, j be index of t, DP(i, j) represents the number of distinct
sequences to match t up to j vs s up to i.

DP(i, j) = DP(i, j - 1) if t[j] != s[i]
           DP(i, j - 1) + DP(i - 1, j - 1) // this is where dp[j + 1] += dp[j] comes from even though represents another index
initialize condition is DP(-1, -1) = 1
