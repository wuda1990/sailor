//You are given an array prices where prices[i] is the price of a given stock on
// the ith day. 
//
// You want to maximize your profit by choosing a single day to buy one stock an
//d choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you canno
//t achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must
// buy before you sell.
// 
//
// Example 2: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics Array Dynamic Programming 
// 👍 22865 👎 724


package com.onepiece.leetcode.editor.en.dp;

public class Q121BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        Solution solution = new Q121BestTimeToBuyAndSellStock().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            return maxProfitByDp(prices);
        }

        public int maxProfitByDp(int[] prices) {
            int[][] dp = new int[prices.length][2];
            //dp[i][0]表示第i天持有股票时的现金
            //dp[i][1]表示第i天不持有股票时的现金
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < prices.length; i++) {
                //第i天什么也不做(原本就持有股票)，第i天买入股票(未持股票)，两种情况求现金最大值
                //因为只能交易一次所以这里是0-prices[i]
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][0] = Math.max(dp[i - 1][0], 0 - prices[i]);
                //第i天什么也不做(原本就不持有股票)，第i天卖出股票(持有股票)，两种情况求现金最大值
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            }
            return dp[prices.length - 1][1];
        }

        //use greedy
        public int maxProfitGreedy(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int low = prices[0];
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                low = Math.min(low, prices[i]);
                if (low < prices[i]) {
                    result = Math.max(prices[i] - low, result);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}