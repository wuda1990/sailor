//You are given an array prices where prices[i] is the price of a given stock on
// the ith day, and an integer fee representing a transaction fee. 
//
// Find the maximum profit you can achieve. You may complete as many transaction
//s as you like, but you need to pay the transaction fee for each transaction. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you m
//ust sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,3,2,8,4,9], fee = 2
//Output: 8
//Explanation: The maximum profit can be achieved by:
//- Buying at prices[0] = 1
//- Selling at prices[3] = 8
//- Buying at prices[4] = 4
//- Selling at prices[5] = 9
//The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,3,7,5,10,3], fee = 3
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5 * 104 
// 1 <= prices[i] < 5 * 104 
// 0 <= fee < 5 * 104 
// 
// Related Topics Array Dynamic Programming Greedy 
// 👍 4995 👎 122


package com.onepiece.leetcode.editor.en;

public class Q714BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new Q714BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        int maxProfit = solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
//        int maxProfit = solution.maxProfit(new int[]{1,3,7,5,10,3}, 3);
        System.out.println(maxProfit);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int max = 0;
            int pre = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - pre > 0) {
                    if (prices[i] - pre - fee > 0) {
                        max = max + prices[i] - pre - fee;
                        pre = prices[i] - fee;//难点在于这里，题目要求最大利润，pre作为买入的点，这里要尽量最小，去除手续费不交易为最小
                    }
                } else {
                    pre = Math.min(pre, prices[i]);
                }
            }
            return max;
        }

        public int maxProfitByDp(int[] prices, int fee) {
            int len = prices.length;
            // 0 : 持股（买入）
            // 1 : 不持股（售出）
            // dp 定义第i天持股/不持股 所得最多现金
            int[][] dp = new int[len][2];
            dp[0][0] = -prices[0];
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
            }
            return Math.max(dp[len - 1][0], dp[len - 1][1]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}