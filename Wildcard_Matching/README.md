Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false


My note: This is a fun problem to work with. <br>
First, I came up with an easy RecursiveSolution.java. As name suggested, it is recursive. The thought was derived from regular expression matching previously. Time limit exceeded obviously<br>
Then, as it is string matching, it is natural to go dynamic programming way. I simply derived a n*m table (solution not attached. obvious and simple), TLE again. <br>
DP is usually fast enough. After examining the test cases, some calculation is wasted. E.g. s="abc"; p = "a*a". There is no need to match '*' vs 'a' or 'c' as there are regular characters before and after '*'. These save some time. and it passes online judge<br>
Then I looked at other people's solutions. I borrowed the "greedy algorithm" and implemented in my way. It doesn't look clean as other people's. But it passes online judge. 
