import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        if (k >= prices.length - 1) {
            int retValue = 0;
            for (int i = 1; i < prices.length; i++)
                retValue += Math.max(prices[i] - prices[i - 1], 0);
            return retValue;
        }
        int[] maxProfitSell = new int[prices.length];
        int[] maxProfitEnd = new int[prices.length];
        int minCost, i, j;
        for (j = 0; j < k; j ++) {
            minCost = prices[0] - maxProfitEnd[0];
            for (i = 0; i < prices.length; i++) {
                maxProfitSell[i] = prices[i] - minCost;
                minCost = Math.min(minCost, prices[i] - maxProfitEnd[i]);
            }
            maxProfitEnd[0] = maxProfitSell[0];
            for (i = 1; i < prices.length; i++)
                maxProfitEnd[i] = Math.max(maxProfitEnd[i - 1], maxProfitSell[i]);
        }
        return maxProfitEnd[prices.length - 1];
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] prices = {2,1,4,5,2,9,7};int k = 2;
        System.out.println(solution.maxProfit(k, prices));
    }

}
