//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// Find the maximum profit you can achieve. You may complete at most two 
//transactions. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// 
//交易0次，1次，2次，卖出算交易了一次
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you 
//are engaging multiple transactions at the same time. You must sell before buying 
//again.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// Related Topics Array Dynamic Programming 👍 7950 👎 154


package com.onepiece.leetcode.editor.en.dp;

public class Q123BestTimeToBuyAndSellStockIii {

    public static void main(String[] args) {
        Solution solution = new Q123BestTimeToBuyAndSellStockIii().new Solution();
        solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][4];
            int tradeNo = 0;
            //dp[i][0]表示第i天第一次持有股票时的现金
            //dp[i][1]表示第i天第一次不持有股票是的现金
            //dp[i][2]表示第i天第二次持有股票时的现金
            //dp[i][3]表示第i天第二次不持有股票是的现金
            dp[0][0] = -prices[0];
            dp[0][2] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                //第i天什么也不做(原本就持有股票)，第i天买入股票(未持股票)，两种情况求现金最大值
                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
                //第i天什么也不做(原本就不持有股票)，第i天卖出股票(持有股票)，两种情况求现金最大值
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
                //第i天什么都不做，或者第一次不持有股票后再买入
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
                //第i天什么都不做，或者第二次持有股票后再卖出
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
            }
            return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][3]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}