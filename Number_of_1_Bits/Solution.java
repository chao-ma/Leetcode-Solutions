/**
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
https://leetcode.com/problems/number-of-1-bits/

My note: java doesn't jave "unsigned" integer, making it troublesome.
 */
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                count++;
        }
        return count;
    }
}
