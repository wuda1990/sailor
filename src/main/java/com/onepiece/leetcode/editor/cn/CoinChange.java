//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1864 👎 0


package com.onepiece.leetcode.editor.cn;

public class CoinChange{
    public static void main(String[]args){
        Solution solution=new CoinChange().new Solution();
//        solution.coinChange(new int[]{1, 2, 5}, 11);
        solution.coinChange(new int[]{2}, 3);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i]代表金钱为i时硬币的最小个数
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    if (min == -1) {
                        min = dp[i - coin] + 1;
                    }else {
                        min = Math.min(min, dp[i - coin] + 1);
                    }
                }
            }
            dp[i] = min;
        }

        return dp[amount];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}