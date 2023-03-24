//You are given an integer array prices where prices[i] is the price of a given 
//stock on the ith day. 
//
// On each day, you may decide to buy and/or sell the stock. You can only hold a
//t most one share of the stock at any time. However, you can buy it then immediat
//ely sell it on the same day. 
//
// Find and return the maximum profit you can achieve. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 
//5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//
//Total profit is 4 + 3 = 7.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Total profit is 4.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: There is no way to make a positive profit, so we never buy the st
//ock to achieve the maximum profit of 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 3 * 104 
// 0 <= prices[i] <= 104 
// 
// Related Topics Array Dynamic Programming Greedy 
// 👍 10222 👎 2497


package com.onepiece.leetcode.editor.en.greedy;

public class Q122BestTimeToBuyAndSellStockIi {

    public static void main(String[] args) {
        Solution solution = new Q122BestTimeToBuyAndSellStockIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            // use greedy
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    max = max + prices[i] - prices[i - 1];
                }
            }
            return max;
        }

        public int maxProfitByDp(int[] prices) {
            int[][] dp = new int[prices.length][2];
            //dp[i][0]表示第i天持有股票时的现金
            //dp[i][1]表示第i天不持有股票时的现金
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < prices.length; i++) {
                //第i天什么也不做(原本就持有股票)，第i天买入股票(未持股票)，两种情况求现金最大值
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                //第i天什么也不做(原本就不持有股票)，第i天卖出股票(持有股票)，两种情况求现金最大值
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            }
            return dp[prices.length - 1][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}