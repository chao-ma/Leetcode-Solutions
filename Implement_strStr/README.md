Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

https://leetcode.com/problems/implement-strstr/

My note: even though the problem is tagged as "EASY", I don't really think so.<br>
It is simply KMP substring matching algorithm, and it is non-trivial to implement. This is my own implementation, and it doesn't look as neat as original one.
Personally I don't quite agree with test case haystack = "", needle = "". In my opinion, it should be -1, leetcode gave 0. 0 index doesn't exist in haystack sinch its length is 0.
