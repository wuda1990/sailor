//You are given an array prices where prices[i] is the price of a given stock on
// the ith day. 
//
// Find the maximum profit you can achieve. You may complete as many transaction
//s as you like (i.e., buy one and sell one share of the stock multiple times) wit
//h the following restrictions: 
//
// 
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldo
//wn one day). 
// 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you m
//ust sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// 
//
// Example 2: 
//
// 
//Input: prices = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics Array Dynamic Programming 
// 👍 7933 👎 273


package com.onepiece.leetcode.editor.en;

public class Q309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new Q309BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length + 1][2];
            dp[1][0] = -prices[0];

            for (int i = 2; i <= prices.length; i++) {
            /*
            dp[i][0] 第i天持有股票收益;
            dp[i][1] 第i天不持有股票收益;
            情况一：第i天是冷静期，不能以dp[i-1][1]购买股票,所以以dp[i - 2][1]买股票，没问题
            情况二：第i天不是冷静期，理论上应该以dp[i-1][1]购买股票，但是第i天不是冷静期说明，第i-1天没有卖出股票，
                则dp[i-1][1]=dp[i-2][1],所以可以用dp[i-2][1]买股票，没问题
             */
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
            }

            return dp[prices.length][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}