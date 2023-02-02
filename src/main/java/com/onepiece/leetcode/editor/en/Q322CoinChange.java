//You are given an integer array coins representing coins of different denominat
//ions and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If th
//at amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics Array Dynamic Programming Breadth-First Search 
// 👍 15194 👎 352


package com.onepiece.leetcode.editor.en;

public class Q322CoinChange {
    public static void main(String[] args) {
        Solution solution = new Q322CoinChange().new Solution();
//        solution.coinChange(new int[]{1, 2, 5}, 11);
        solution.coinChange(new int[]{2}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 求组合，完全背包，凑满金额的硬币最小个数
     */
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}