Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

https://leetcode.com/problems/longest-substring-without-repeating-characters/

My note: This is a DP. At each state, save the current max length of unique character ending here and maintain the largest index of each appearing character.
