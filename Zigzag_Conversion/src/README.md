 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 

https://leetcode.com/problems/zigzag-conversion/

My note:
I could build nrows single-linked list and simulate the process and merge the lists, but a mathmatical solution is more efficient, just I havn't figured out a solution to make the code cleaner.
