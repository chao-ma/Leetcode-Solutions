/**
Count the number of prime numbers less than a non-negative number, n.

https://leetcode.com/problems/count-primes/

My note: I think my solution is not bad at all. Simple and as efficient

Space complexity O(N), obvious
Time complexity. > O(N) b/c composite number is visited by number of prime factors
e.g. 6 is visited by prime 2 and 3. and Number of prime factors is somehow
related to N.
< O(NlogN). 
Worst case
N(1/2 + 1/3 + 1/4 + 1/5 + ... + 1/N) ~ NLogN
so the complexity is somewhere between N to NLogN.
 */
public class Solution {
    public int countPrimes(int n) {
        boolean[] visited = new boolean[n];
        int count = 0, index;
        for (int i = 2; i < n; i++) {
            if (!visited[i]) {
                count++;
                index = i;
                while (index < n) {
                    visited[index] = true;
                    index += i;
                }
            }
        }
        return count;
    }
}
