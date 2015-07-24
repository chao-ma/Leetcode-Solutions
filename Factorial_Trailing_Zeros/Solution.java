/**
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

https://leetcode.com/problems/factorial-trailing-zeroes/

My note: Idea is simple, count the number of factor 2s and 5s from 1 to N
The number of trailing zero will be the smaller number of factor 2s and 5s.
Obviously there are always more 2s than 5s. So simply need to count number of
5s.
At the beginning I was thinking about this
if i % 5 != 0, skip, otherwise number_of_five(i) = number_of_five(i/5) + 1
A hashtable will do. This is going to be linear time. not too bad.
The question asks for log(N) time. Here is the thinking.

The number contains five:
1 * 5
2 * 5
3 * 5
4 * 5
5 * 5
...
10 * 5
n / 5 will be how many fives, n / 25 will be the ones with double fives and so on
The solution is clear:
 */
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}
