Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

https://leetcode.com/problems/valid-number/

My note:
This is a nasty one. passed the test case by case

-.1 -> true
+.1 -> true
-1. -> true
+3. -> true
+3.2 -> true
3.2 -> true
-3.2 -> true
1.e3 -> true
1.2e-3 -> true

10e -> false
.e1 -> false
.e1.2 -> false
1.2 3e2 -> false
1e4 2 -> false
"  1.2   " -> true
"  1.2  a " -> false

Also the Java String.split function is so different from python. I like python version and implemented mine for this question here.
