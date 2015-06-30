/**

Best Time to Buy and Sell Stock I

Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int retValue = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i: prices) {
            minPrice = Math.min(minPrice, i);
            retValue = Math.max(retValue, i - minPrice);
        }
        return retValue;
    }
}

/**

Best Time to Buy and Sell Stock II

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int retValue = 0;
        for (int i = 1; i < prices.length; i++)
            retValue += Math.max(0, prices[i] - prices[i - 1]);
        return retValue;
    }
}

/**
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

My note: I want to make it O(N). Here is the thought process:
 - O(N) to solve best buy/sell transaction from price[0....i]
 - Reversely think how to get best/sell from price[i....n]
 - as i is changing, it is better to loop backward from n to i
 - then find highest sell price
 - record forward and backward loop result
 - combine them. Bingo.

*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int retValue = 0;
        int[] forward = new int[prices.length];
        int[] backward = new int[prices.length];
        int prev, i;
        int bestProfit = 0;
        prev = prices[0];
        for (i = 1; i < prices.length; i++) {
            prev = Math.min(prev, prices[i]);
            bestProfit = Math.max(bestProfit, prices[i] - prev);
            forward[i] = bestProfit;
        }
        bestProfit = 0;
        prev = prices[prices.length - 1];
        for (i = prices.length - 2; i >= 0; i--) {
            prev = Math.max(prev, prices[i]);
            bestProfit = Math.max(bestProfit, prev - prices[i]);
            backward[i] = bestProfit;
        }
        for (i = 0; i < prices.length; i++)
            retValue = Math.max(retValue, forward[i] + backward[i]);
        return retValue;
    }
}
