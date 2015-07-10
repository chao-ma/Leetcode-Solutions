/**
 There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

https://leetcode.com/problems/candy/
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0)
            return 0;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = 1; right[ratings.length - 1] = 1;
        int i;
        int retValue = 0;
        for (i = 1; i < ratings.length; i++)
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
        for (i = ratings.length - 2; i >= 0; i--)
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1: 1;
        for (i = 0; i < ratings.length; i++)
            retValue += left[i] > right[i] ? left[i] : right[i];
        return retValue;
    }
}
