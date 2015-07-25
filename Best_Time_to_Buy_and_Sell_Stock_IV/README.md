Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/



My note: this is a pretty convoluted DP question

Profit(k, i) represents the best profit if kth sell is at prices[i]

Solution = Max(i) Profit(k, i)

Profit(k, i, j) = is the profit of kth transaction, buy at prices[j], sell at
prices[i]

Profit(k, i) = Max(j) prices[i] - prices[j] + Best profit for k-1 transactoin from 1 to j

