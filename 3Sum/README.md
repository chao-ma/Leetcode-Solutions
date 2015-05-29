Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

https://leetcode.com/problems/3sum/


My Note:
First, I reached a solution in Solution.java. This is a quite generic method,
It can compute K-Sum equal to a target in O(n^(K-1)) time complexity. <br>
This is also useful to solve the 4sum problem. Basically it is a recursive function.
But leetcode OJ is too strict on the time. This solution deals with lots of objects and slows it down.
Then I optimized to get to Main.java. This solution passes OJ, but it is tricky and not as generic as the former solution.
There is another hashtable solution in n^2 like Two-Sum. I am not adding it here.
