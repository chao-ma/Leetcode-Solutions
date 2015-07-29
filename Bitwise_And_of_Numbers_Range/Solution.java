/**
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

https://leetcode.com/problems/bitwise-and-of-numbers-range/

My note: obviously O(n-m) solution is not acceptable.
here is the thinking,
the ith bit is 1 if m's ith bit is 1 and m+1 to n's ith bit is 1. Sounds stupid
but the trick is

5: 101 6:110 7:111
5's 3rd bit is not going to be overwritten to 0 if n <= 7 b/c
01 -> 10 -> 11 , there are 11 - 01 = 10 (two) to increment
so as long as n - m <= (1 << i - 1) - n & ((1 << i - 1) - 1)
n is not large enough to overwrite ith bit
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int retValue = 0, bit, mask;
        for (int i = 0; i < 31; i++) {
            bit = 1 << i;
            if ((m & bit) != 0) {
                mask = bit - 1;
                if (mask - (m & mask) >= n - m)
                    retValue = retValue | bit;
            } 
        }
        return retValue;
    }
}
